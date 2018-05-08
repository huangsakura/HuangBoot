package com.huanggit.chess.service;

import com.huanggit.chess.enumeration.Army;
import com.huanggit.chess.enumeration.Duty;
import com.huanggit.enumeration.common.ResultCode;
import com.huanggit.exception.BusinessException;
import com.huanggit.general.constant.GeneralConstant;
import com.huanggit.general.dto.common.Pair;
import com.huanggit.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.huanggit.chess.domain.entity.GameBoard;
import com.huanggit.chess.domain.dao.GameBoardDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class GameBoardService {

    @Resource
    private GameBoardDao gameBoardDao;
    @Autowired
    private GameBoardChangeService gameBoardChangeService;
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    public int insert(GameBoard pojo){
        return gameBoardDao.insert(pojo);
    }

    public int update(GameBoard pojo){
        return gameBoardDao.update(pojo);
    }

    public void initGameBoard(Long gameId) {

        GameBoard[] gameBoardList = {
                new GameBoard(gameId,Army.BLACK,Duty.JIANG,1),
                new GameBoard(gameId,Army.BLACK,Duty.SHI,1),
                new GameBoard(gameId,Army.BLACK,Duty.SHI,2),
                new GameBoard(gameId,Army.BLACK,Duty.XIANG,1),
                new GameBoard(gameId,Army.BLACK,Duty.XIANG,2),
                new GameBoard(gameId,Army.BLACK,Duty.MA,1),
                new GameBoard(gameId,Army.BLACK,Duty.MA,2),
                new GameBoard(gameId,Army.BLACK,Duty.JU,1),
                new GameBoard(gameId,Army.BLACK,Duty.JU,2),
                new GameBoard(gameId,Army.BLACK,Duty.PAO,1),
                new GameBoard(gameId,Army.BLACK,Duty.PAO,2),
                new GameBoard(gameId,Army.BLACK,Duty.ZU,1),
                new GameBoard(gameId,Army.BLACK,Duty.ZU,2),
                new GameBoard(gameId,Army.BLACK,Duty.ZU,3),
                new GameBoard(gameId,Army.BLACK,Duty.ZU,4),
                new GameBoard(gameId,Army.BLACK,Duty.ZU,5),

                new GameBoard(gameId,Army.RED,Duty.JIANG,1),
                new GameBoard(gameId,Army.RED,Duty.SHI,1),
                new GameBoard(gameId,Army.RED,Duty.SHI,2),
                new GameBoard(gameId,Army.RED,Duty.XIANG,1),
                new GameBoard(gameId,Army.RED,Duty.XIANG,2),
                new GameBoard(gameId,Army.RED,Duty.MA,1),
                new GameBoard(gameId,Army.RED,Duty.MA,2),
                new GameBoard(gameId,Army.RED,Duty.JU,1),
                new GameBoard(gameId,Army.RED,Duty.JU,2),
                new GameBoard(gameId,Army.RED,Duty.PAO,1),
                new GameBoard(gameId,Army.RED,Duty.PAO,2),
                new GameBoard(gameId,Army.RED,Duty.ZU,1),
                new GameBoard(gameId,Army.RED,Duty.ZU,2),
                new GameBoard(gameId,Army.RED,Duty.ZU,3),
                new GameBoard(gameId,Army.RED,Duty.ZU,4),
                new GameBoard(gameId,Army.RED,Duty.ZU,5)
        };

        for (int i = 0,siz = gameBoardList.length;i < siz;i++) {
            gameBoardDao.insert(gameBoardList[i]);
            redisTemplate.opsForValue().set(gameBoardList[i].getChessRedisKey(),new Pair<>(gameBoardList[i].getX(),gameBoardList[i].getY()),30, TimeUnit.MINUTES);
            redisTemplate.opsForValue().set(gameBoardList[i].getPositionRedisKey(),gameBoardList[i],30, TimeUnit.MINUTES);
        }
    }

    public void move(Long id,int toX,int toY) {

        GameBoard gameBoardNow = gameBoardDao.getForUpdate(id);
        if (!GeneralConstant.ZERO_STRING.equals(gameBoardNow.getValidCode())) {
            throw new BusinessException("当前棋子已经死亡");
        }

        gameBoardChangeService.saveOne(gameBoardNow.getGameId(),gameBoardNow.getId(),
                gameBoardNow.getArmy().toString() + "_" +gameBoardNow.getDuty().toString() + "_" + gameBoardNow.getChessSequence()
                ,gameBoardNow.getX(),gameBoardNow.getY(),toX,toY);

        GameBoard gameBoardNext = gameBoardDao.getByPositionForUpdate(gameBoardNow.getGameId(),toX,toY);
        if (null != gameBoardNext) {
            if (gameBoardNow.getArmy().equals(gameBoardNext.getArmy())) {
                throw new BusinessException("欲占领位置已有我方棋子");
            }
            gameBoardNext.setValidCode(UUIDUtil.getUUID(UUIDUtil.Type.TIME));
            gameBoardDao.update(gameBoardNext);
        }

        gameBoardNow.setX(toX);
        gameBoardNow.setY(toY);
        gameBoardDao.update(gameBoardNow);

        redisTemplate.opsForValue().set(gameBoardNow.getChessRedisKey(),new Pair<>(toX,toY),30, TimeUnit.MINUTES);
        redisTemplate.opsForValue().set(gameBoardNow.getPositionRedisKey(),gameBoardNow,30, TimeUnit.MINUTES);
    }

    public List<Pair<Integer,Integer>> findNextSteps(Long id) {
        List<Pair<Integer,Integer>> result = new ArrayList<>();

        GameBoard gameBoard = gameBoardDao.get(id);
        if (gameBoard == null) {
            throw new BusinessException("没有找到对应的棋子",ResultCode.OBJECT_NOT_EXIST);
        }
        return result;
    }

    private List<Pair<Integer,Integer>> findNextStepsOfJiang(Army army,int currentX,int currentY) {
        List<Pair<Integer,Integer>> result = new ArrayList<>();
        switch (army) {
            case RED:{
                if ((currentX == 3)) {
                    if (currentY == 0) {

                    }
                }
                break;
            } case BLACK:{
                break;
            } default:{
                break;
            }
        }
        return result;
    }

    public static void main(String[] a) {
        System.out.println(Army.BLACK.toString());
        System.out.println(Army.BLACK.name());
        System.out.println(Army.BLACK.ordinal());
    }
}
