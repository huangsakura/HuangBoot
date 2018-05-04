package com.huanggit.chess.domain.entity;

import com.huanggit.annotation.ColumnConstraint;
import com.huanggit.domain.entity.base.BaseEntity;
import lombok.Data;

/**
 * Created by huang on 2018-05-04-0004.
 */
@Data
public class GameBoardChange extends BaseEntity {

    @ColumnConstraint(maxLength = 20,nullable = false)
    private Long gameId;

    @ColumnConstraint(maxLength = 20,nullable = false)
    private Long chessBoardId;

    @ColumnConstraint(maxLength = 16,nullable = false,allowBlank = false)
    private String chessDesc;

    @ColumnConstraint(nullable = false,minLength = 1,maxLength = 1)
    private Integer fromX;

    @ColumnConstraint(nullable = false,minLength = 1,maxLength = 1)
    private Integer fromY;

    @ColumnConstraint(nullable = false,minLength = 1,maxLength = 1)
    private Integer toX;

    @ColumnConstraint(nullable = false,minLength = 1,maxLength = 1)
    private Integer toY;
}
