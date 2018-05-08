package com.huanggit.chess.service;

import com.huanggit.chess.enumeration.GameStatus;
import com.huanggit.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.huanggit.chess.domain.entity.Game;
import com.huanggit.chess.domain.dao.GameDao;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GameService{

    @Resource
    private GameDao gameDao;
    @Autowired
    private GameBoardService gameBoardService;

    public int insert(Game pojo){
        return gameDao.insert(pojo);
    }

    public int insertSelective(Game pojo){
        return gameDao.insertSelective(pojo);
    }

    public int insertList(List<Game> pojos){
        return gameDao.insertList(pojos);
    }

    public int update(Game pojo){
        return gameDao.update(pojo);
    }


    public Game start(Long redUserId,Long blackUserId) {
        Game game = new Game();
        game.setRedUserId(redUserId);
        game.setBlackUserId(blackUserId);
        game.setStartTime(DateUtil.currentTime());
        game.setStatus(GameStatus.WORKING);
        gameDao.insert(game);

        gameBoardService.initGameBoard(game.getId());

        return game;
    }
}
