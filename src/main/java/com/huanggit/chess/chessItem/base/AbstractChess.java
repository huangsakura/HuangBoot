package com.huanggit.chess.chessItem.base;

import com.huanggit.chess.enumeration.Army;
import com.huanggit.chess.enumeration.ChessStatus;
import com.huanggit.chess.enumeration.Duty;
import lombok.Data;

/**
 * Created by huang on 2018-05-03-0003.
 */
@Data
public abstract class AbstractChess {

    public AbstractChess(){};

    public AbstractChess(Army army,Duty duty,int x,int y,int sequence) {
        this.army = army;
        this.duty = duty;
        this.x = x;
        this.y = y;
        this.sequence = sequence;
    }

    private Army army;

    private Duty duty;

    private int x;

    private int y;

    private int sequence;

    private ChessStatus status = ChessStatus.LIVE;
}
