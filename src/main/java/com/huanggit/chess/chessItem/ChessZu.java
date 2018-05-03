package com.huanggit.chess.chessItem;

import com.huanggit.chess.chessItem.base.AbstractChess;
import com.huanggit.chess.enumeration.Army;
import com.huanggit.chess.enumeration.Duty;

/**
 * Created by huang on 2018-05-03-0003.
 */
public class ChessZu extends AbstractChess {

    public ChessZu(Army army, int sequence) {
        this.setDuty(Duty.PAO);
        this.setArmy(army);
        this.setSequence(sequence);
        switch (army) {
            case RED:{
                if (sequence == 1) {
                    this.setX(0);
                    this.setY(3);
                } else if (sequence == 2) {
                    this.setX(2);
                    this.setY(3);
                } else if (sequence == 3) {
                    this.setX(4);
                    this.setY(3);
                } else if (sequence == 4) {
                    this.setX(6);
                    this.setY(3);
                } else if (sequence == 5) {
                    this.setX(8);
                    this.setY(3);
                }
                break;
            } case BLACK:{
                if (sequence == 1) {
                    this.setX(0);
                    this.setY(6);
                } else if (sequence == 2) {
                    this.setX(2);
                    this.setY(6);
                } else if (sequence == 3) {
                    this.setX(4);
                    this.setY(6);
                } else if (sequence == 4) {
                    this.setX(6);
                    this.setY(6);
                } else if (sequence == 5) {
                    this.setX(8);
                    this.setY(6);
                }
                break;
            } default:{
                break;
            }
        }
    }
}
