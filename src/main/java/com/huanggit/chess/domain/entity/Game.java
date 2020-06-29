package com.huanggit.chess.domain.entity;

import com.huanggit.chess.enumeration.Army;
import com.huanggit.chess.enumeration.GameStatus;
import com.huanggit.domain.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by huang on 2018-05-03-0003.
 */
@Setter
@Getter
@ToString
public class Game extends BaseEntity {

    @NotNull
    private Long redUserId;

    @NotNull
    private Long blackUserId;

    @NotNull
    private GameStatus status;

    @NotNull
    private Army winner;

    @NotNull
    private Date startTime;

    @NotNull
    private Date finishTime;
}
