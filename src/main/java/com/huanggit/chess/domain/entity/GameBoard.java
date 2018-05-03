package com.huanggit.chess.domain.entity;

import com.huanggit.annotation.ColumnConstraint;
import com.huanggit.chess.chessItem.base.AbstractChess;
import com.huanggit.chess.enumeration.Army;
import com.huanggit.chess.enumeration.Duty;
import com.huanggit.domain.entity.base.BaseEntity;
import lombok.Data;

/**
 * Created by huang on 2018-05-03-0003.
 */
@Data
public class GameBoard extends BaseEntity {

    public GameBoard(AbstractChess abstractChess,Long gameId) {
        this.army = abstractChess.getArmy();
        this.duty = abstractChess.getDuty();
        this.x = abstractChess.getX();
        this.y = abstractChess.getY();
        this.chessSequence = abstractChess.getSequence();
        this.gameId = gameId;
    }

    @ColumnConstraint(nullable = false)
    private Long gameId;

    @ColumnConstraint(nullable = false)
    private Army army;

    @ColumnConstraint(nullable = false)
    private Duty duty;

    @ColumnConstraint(nullable = false)
    private Integer chessSequence;

    private Integer x;

    private Integer y;

    @ColumnConstraint(nullable = false,maxLength = 24,allowBlank = false,minLength = 1)
    private String validCode = "0";
}
