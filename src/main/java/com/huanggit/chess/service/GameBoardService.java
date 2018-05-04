package com.huanggit.chess.service;

import com.huanggit.chess.enumeration.Army;
import com.huanggit.chess.enumeration.Duty;
import com.huanggit.exception.BusinessException;
import com.huanggit.general.constant.GeneralConstant;
import com.huanggit.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.huanggit.chess.domain.entity.GameBoard;
import com.huanggit.chess.domain.dao.GameBoardDao;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GameBoardService {

    @Resource
    private GameBoardDao gameBoardDao;
    @Autowired
    private GameBoardChangeService gameBoardChangeService;

    public int insert(GameBoard pojo){
        return gameBoardDao.insert(pojo);
    }

    public int update(GameBoard pojo){
        return gameBoardDao.update(pojo);
    }

    public void initGameBoard(Long gameId) {

        GameBoard gameBoard1 = new GameBoard(gameId,Army.BLACK,Duty.JIANG,1);
        GameBoard gameBoard2 = new GameBoard(gameId,Army.BLACK,Duty.SHI,1);
        GameBoard gameBoard3 = new GameBoard(gameId,Army.BLACK,Duty.SHI,2);
        GameBoard gameBoard4 = new GameBoard(gameId,Army.BLACK,Duty.XIANG,1);
        GameBoard gameBoard5 = new GameBoard(gameId,Army.BLACK,Duty.XIANG,2);
        GameBoard gameBoard6 = new GameBoard(gameId,Army.BLACK,Duty.MA,1);
        GameBoard gameBoard7 = new GameBoard(gameId,Army.BLACK,Duty.MA,2);
        GameBoard gameBoard8 = new GameBoard(gameId,Army.BLACK,Duty.JU,1);
        GameBoard gameBoard9 = new GameBoard(gameId,Army.BLACK,Duty.JU,2);
        GameBoard gameBoard10 = new GameBoard(gameId,Army.BLACK,Duty.PAO,1);
        GameBoard gameBoard11 = new GameBoard(gameId,Army.BLACK,Duty.PAO,2);
        GameBoard gameBoard12 = new GameBoard(gameId,Army.BLACK,Duty.ZU,1);
        GameBoard gameBoard13 = new GameBoard(gameId,Army.BLACK,Duty.ZU,2);
        GameBoard gameBoard14 = new GameBoard(gameId,Army.BLACK,Duty.ZU,3);
        GameBoard gameBoard15 = new GameBoard(gameId,Army.BLACK,Duty.ZU,4);
        GameBoard gameBoard16 = new GameBoard(gameId,Army.BLACK,Duty.ZU,5);


        GameBoard gameBoard17 = new GameBoard(gameId,Army.RED,Duty.JIANG,1);
        GameBoard gameBoard18 = new GameBoard(gameId,Army.RED,Duty.SHI,1);
        GameBoard gameBoard19 = new GameBoard(gameId,Army.RED,Duty.SHI,2);
        GameBoard gameBoard20 = new GameBoard(gameId,Army.RED,Duty.XIANG,1);
        GameBoard gameBoard21 = new GameBoard(gameId,Army.RED,Duty.XIANG,2);
        GameBoard gameBoard22 = new GameBoard(gameId,Army.RED,Duty.MA,1);
        GameBoard gameBoard23 = new GameBoard(gameId,Army.RED,Duty.MA,2);
        GameBoard gameBoard24 = new GameBoard(gameId,Army.RED,Duty.JU,1);
        GameBoard gameBoard25 = new GameBoard(gameId,Army.RED,Duty.JU,2);
        GameBoard gameBoard26 = new GameBoard(gameId,Army.RED,Duty.PAO,1);
        GameBoard gameBoard27 = new GameBoard(gameId,Army.RED,Duty.PAO,2);
        GameBoard gameBoard28 = new GameBoard(gameId,Army.RED,Duty.ZU,1);
        GameBoard gameBoard29 = new GameBoard(gameId,Army.RED,Duty.ZU,2);
        GameBoard gameBoard30 = new GameBoard(gameId,Army.RED,Duty.ZU,3);
        GameBoard gameBoard31 = new GameBoard(gameId,Army.RED,Duty.ZU,4);
        GameBoard gameBoard32 = new GameBoard(gameId,Army.RED,Duty.ZU,5);

        gameBoardDao.insert(gameBoard1);
        gameBoardDao.insert(gameBoard2);
        gameBoardDao.insert(gameBoard3);
        gameBoardDao.insert(gameBoard4);
        gameBoardDao.insert(gameBoard5);
        gameBoardDao.insert(gameBoard6);
        gameBoardDao.insert(gameBoard7);
        gameBoardDao.insert(gameBoard8);
        gameBoardDao.insert(gameBoard9);
        gameBoardDao.insert(gameBoard10);
        gameBoardDao.insert(gameBoard11);
        gameBoardDao.insert(gameBoard12);
        gameBoardDao.insert(gameBoard13);
        gameBoardDao.insert(gameBoard14);
        gameBoardDao.insert(gameBoard15);
        gameBoardDao.insert(gameBoard16);
        gameBoardDao.insert(gameBoard17);
        gameBoardDao.insert(gameBoard18);
        gameBoardDao.insert(gameBoard19);
        gameBoardDao.insert(gameBoard20);
        gameBoardDao.insert(gameBoard21);
        gameBoardDao.insert(gameBoard22);
        gameBoardDao.insert(gameBoard23);
        gameBoardDao.insert(gameBoard24);
        gameBoardDao.insert(gameBoard25);
        gameBoardDao.insert(gameBoard26);
        gameBoardDao.insert(gameBoard27);
        gameBoardDao.insert(gameBoard28);
        gameBoardDao.insert(gameBoard29);
        gameBoardDao.insert(gameBoard30);
        gameBoardDao.insert(gameBoard31);
        gameBoardDao.insert(gameBoard32);
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
                throw new BusinessException("欲占领位置目前已有我方棋子");
            }
            gameBoardNext.setValidCode(UUIDUtil.getUUID(UUIDUtil.Type.TIME));
            gameBoardDao.update(gameBoardNext);
        }

        gameBoardNow.setX(toX);
        gameBoardNow.setY(toY);
        gameBoardDao.update(gameBoardNow);
    }

    public static void main(String[] a) {
        System.out.println(Army.BLACK.toString());
        System.out.println(Army.BLACK.name());
        System.out.println(Army.BLACK.ordinal());
    }
}
