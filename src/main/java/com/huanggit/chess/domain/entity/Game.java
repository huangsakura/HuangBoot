package com.huanggit.chess.domain.entity;

import com.huanggit.chess.enumeration.Army;
import com.huanggit.chess.enumeration.GameStatus;
import com.huanggit.domain.entity.base.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * Created by huang on 2018-05-03-0003.
 */
@Data
public class Game extends BaseEntity {

    private Long redUserId;

    private Long blackUserId;

    private GameStatus status;

    private Army winner;

    private Date startTime;

    private Date finishTime;
}
