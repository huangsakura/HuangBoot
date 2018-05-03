package com.huanggit.chess.chessItem;

import com.huanggit.chess.chessItem.base.AbstractChess;
import com.huanggit.chess.enumeration.Army;
import com.huanggit.chess.enumeration.Duty;

/**
 * Created by huang on 2018-05-03-0003.
 */
public class ChessJu extends AbstractChess {

    public ChessJu(Army army, int sequence) {
        this.setDuty(Duty.JU);
        this.setArmy(army);
        this.setSequence(sequence);
        switch (army) {
            case RED:{
                if (sequence == 1) {
                    this.setX(0);
                    this.setY(0);
                } else if (sequence == 2) {
                    this.setX(8);
                    this.setY(0);
                }
                break;
            } case BLACK:{
                if (sequence == 1) {
                    this.setX(0);
                    this.setY(9);
                } else if (sequence == 2) {
                    this.setX(8);
                    this.setY(9);
                }
                break;
            } default:{
                break;
            }
        }
    }
}
