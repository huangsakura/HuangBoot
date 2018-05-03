package com.huanggit.chess.chessItem;

import com.huanggit.chess.chessItem.base.AbstractChess;
import com.huanggit.chess.enumeration.Army;
import com.huanggit.chess.enumeration.Duty;

/**
 * Created by huang on 2018-05-03-0003.
 */
public class ChessJiang extends AbstractChess {

    public ChessJiang(Army army) {
        this.setDuty(Duty.JIANG);
        this.setArmy(army);
        this.setSequence(1);
        switch (army) {
            case RED:{
                this.setX(4);
                this.setY(0);
                break;
            } case BLACK:{
                this.setX(4);
                this.setY(9);
                break;
            } default:{
                break;
            }
        }
    }
}
