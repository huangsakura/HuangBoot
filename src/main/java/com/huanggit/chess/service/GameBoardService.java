package com.huanggit.chess.service;

import com.huanggit.chess.chessItem.*;
import com.huanggit.chess.chessItem.base.AbstractChess;
import com.huanggit.chess.enumeration.Army;
import com.huanggit.chess.enumeration.Duty;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.huanggit.chess.domain.entity.GameBoard;
import com.huanggit.chess.domain.dao.GameBoardDao;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GameBoardService {

    @Resource
    private GameBoardDao gameBoardDao;

    public int insert(GameBoard pojo){
        return gameBoardDao.insert(pojo);
    }

    public int insertSelective(GameBoard pojo){
        return gameBoardDao.insertSelective(pojo);
    }

    public int insertList(List<GameBoard> pojos){
        return gameBoardDao.insertList(pojos);
    }

    public int update(GameBoard pojo){
        return gameBoardDao.update(pojo);
    }

    public void initGameBoard(Long gameId) {

        GameBoard gameBoard1 = new GameBoard(new ChessJiang(Army.BLACK),gameId);
        GameBoard gameBoard2 = new GameBoard(new ChessShi(Army.BLACK,1),gameId);
        GameBoard gameBoard3 = new GameBoard(new ChessShi(Army.BLACK,2),gameId);
        GameBoard gameBoard4 = new GameBoard(new ChessXiang(Army.BLACK,1),gameId);
        GameBoard gameBoard5 = new GameBoard(new ChessXiang(Army.BLACK,2),gameId);
        GameBoard gameBoard6 = new GameBoard(new ChessMa(Army.BLACK,1),gameId);
        GameBoard gameBoard7 = new GameBoard(new ChessMa(Army.BLACK,2),gameId);
        GameBoard gameBoard8 = new GameBoard(new ChessJu(Army.BLACK,1),gameId);
        GameBoard gameBoard9 = new GameBoard(new ChessJu(Army.BLACK,2),gameId);
        GameBoard gameBoard10 = new GameBoard(new ChessPao(Army.BLACK,1),gameId);
        GameBoard gameBoard11 = new GameBoard(new ChessPao(Army.BLACK,2),gameId);
        GameBoard gameBoard12 = new GameBoard(new ChessZu(Army.BLACK,1),gameId);
        GameBoard gameBoard13 = new GameBoard(new ChessZu(Army.BLACK,2),gameId);
        GameBoard gameBoard14 = new GameBoard(new ChessZu(Army.BLACK,3),gameId);
        GameBoard gameBoard15 = new GameBoard(new ChessZu(Army.BLACK,4),gameId);
        GameBoard gameBoard16 = new GameBoard(new ChessZu(Army.BLACK,5),gameId);


        GameBoard gameBoard17 = new GameBoard(new ChessJiang(Army.RED),gameId);
        GameBoard gameBoard18 = new GameBoard(new ChessShi(Army.RED,1),gameId);
        GameBoard gameBoard19 = new GameBoard(new ChessShi(Army.RED,2),gameId);
        GameBoard gameBoard20 = new GameBoard(new ChessXiang(Army.RED,1),gameId);
        GameBoard gameBoard21 = new GameBoard(new ChessXiang(Army.RED,2),gameId);
        GameBoard gameBoard22 = new GameBoard(new ChessMa(Army.RED,1),gameId);
        GameBoard gameBoard23 = new GameBoard(new ChessMa(Army.RED,2),gameId);
        GameBoard gameBoard24 = new GameBoard(new ChessJu(Army.RED,1),gameId);
        GameBoard gameBoard25 = new GameBoard(new ChessJu(Army.RED,2),gameId);
        GameBoard gameBoard26 = new GameBoard(new ChessPao(Army.RED,1),gameId);
        GameBoard gameBoard27 = new GameBoard(new ChessPao(Army.RED,2),gameId);
        GameBoard gameBoard28 = new GameBoard(new ChessZu(Army.RED,1),gameId);
        GameBoard gameBoard29 = new GameBoard(new ChessZu(Army.RED,2),gameId);
        GameBoard gameBoard30 = new GameBoard(new ChessZu(Army.RED,3),gameId);
        GameBoard gameBoard31 = new GameBoard(new ChessZu(Army.RED,4),gameId);
        GameBoard gameBoard32 = new GameBoard(new ChessZu(Army.RED,5),gameId);

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

    public AbstractChess getByPosition(Long gameId,int x,int y) {
        GameBoard gameBoard = gameBoardDao.getByPosition(gameId,x,y);
        if (null == gameBoard) {
            return null;
        }
        return new AbstractChess(gameBoard.getArmy(),gameBoard.getDuty(),
                gameBoard.getX(),gameBoard.getY(),gameBoard.getChessSequence()) {};
    }
}
