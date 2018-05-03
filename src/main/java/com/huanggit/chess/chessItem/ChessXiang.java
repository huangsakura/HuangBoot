package com.huanggit.chess.chessItem;

import com.huanggit.chess.chessItem.base.AbstractChess;
import com.huanggit.chess.enumeration.Army;
import com.huanggit.chess.enumeration.Duty;

/**
 * Created by huang on 2018-05-03-0003.
 */
public class ChessXiang extends AbstractChess {

    public ChessXiang(Army army, int sequence) {
        this.setDuty(Duty.XIANG);
        this.setArmy(army);
        this.setSequence(sequence);
        switch (army) {
            case RED:{
                if (sequence == 1) {
                    this.setX(2);
                    this.setY(0);
                } else if (sequence == 2) {
                    this.setX(6);
                    this.setY(0);
                }
                break;
            } case BLACK:{
                if (sequence == 1) {
                    this.setX(2);
                    this.setY(9);
                } else if (sequence == 2) {
                    this.setX(6);
                    this.setY(9);
                }
                break;
            } default:{
                break;
            }
        }
    }
}
