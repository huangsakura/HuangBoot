package com.huanggit.chess.chessItem;

import com.huanggit.chess.chessItem.base.AbstractChess;
import com.huanggit.chess.enumeration.Army;
import com.huanggit.chess.enumeration.Duty;

/**
 * Created by huang on 2018-05-03-0003.
 */
public class ChessPao extends AbstractChess {

    public ChessPao(Army army, int sequence) {
        this.setDuty(Duty.PAO);
        this.setArmy(army);
        this.setSequence(sequence);
        switch (army) {
            case RED:{
                if (sequence == 1) {
                    this.setX(1);
                    this.setY(2);
                } else if (sequence == 2) {
                    this.setX(7);
                    this.setY(2);
                }
                break;
            } case BLACK:{
                if (sequence == 1) {
                    this.setX(1);
                    this.setY(7);
                } else if (sequence == 2) {
                    this.setX(7);
                    this.setY(7);
                }
                break;
            } default:{
                break;
            }
        }
    }
}
