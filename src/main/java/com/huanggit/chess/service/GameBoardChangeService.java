package com.huanggit.chess.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.huanggit.chess.domain.entity.GameBoardChange;
import com.huanggit.chess.domain.dao.GameBoardChangeDao;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GameBoardChangeService {

    @Resource
    private GameBoardChangeDao gameBoardChangeDao;

    public int insert(GameBoardChange pojo){
        return gameBoardChangeDao.insert(pojo);
    }

    public int update(GameBoardChange pojo){
        return gameBoardChangeDao.update(pojo);
    }

    public GameBoardChange saveOne(Long gameId,Long chessBoardId,String chessDesc,int fromX,int fromY,int toX,int toY) {
        GameBoardChange gameBoardChange = new GameBoardChange();
        gameBoardChange.setChessBoardId(chessBoardId);
        gameBoardChange.setChessDesc(chessDesc);
        gameBoardChange.setFromX(fromX);
        gameBoardChange.setFromY(fromY);
        gameBoardChange.setToX(toX);
        gameBoardChange.setToY(toY);
        gameBoardChange.setGameId(gameId);
        gameBoardChangeDao.insert(gameBoardChange);
        return gameBoardChange;
    }
}
