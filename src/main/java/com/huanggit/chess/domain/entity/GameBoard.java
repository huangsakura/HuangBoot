package com.huanggit.chess.domain.entity;

import com.huanggit.annotation.ColumnConstraint;
import com.huanggit.chess.enumeration.Army;
import com.huanggit.chess.enumeration.Duty;
import com.huanggit.domain.entity.base.BaseEntity;
import com.huanggit.general.constant.GeneralConstant;
import lombok.Data;

/**
 * Created by huang on 2018-05-03-0003.
 */
@Data
public class GameBoard extends BaseEntity {

    public GameBoard(Long gameId,Army army,Duty duty,int chessSequence) {
        this.army = army;
        this.duty = duty;
        this.chessSequence = chessSequence;
        this.gameId = gameId;
        switch (duty) {
            case JIANG:{
                switch (army) {
                    case RED:{
                        this.x = 4;
                        this.y = 0;
                        break;
                    } case BLACK:{
                        this.x = 4;
                        this.y = 9;
                        break;
                    } default:{
                        break;
                    }
                }
                break;
            } case JU:{
                switch (army) {
                    case RED:{
                        if (chessSequence == 1) {
                            this.x = 0;
                            this.y = 0;
                        } else if (chessSequence == 2) {
                            this.x = 8;
                            this.y = 0;
                        }
                        break;
                    } case BLACK:{
                        if (chessSequence == 1) {
                            this.x = 0;
                            this.y = 9;
                        } else if (chessSequence == 2) {
                            this.x = 8;
                            this.y = 9;
                        }
                        break;
                    } default:{
                        break;
                    }
                }
                break;
            } case MA:{
                switch (army) {
                    case RED:{
                        if (chessSequence == 1) {
                            this.x = 1;
                            this.y = 0;
                        } else if (chessSequence == 2) {
                            this.x = 7;
                            this.y = 0;
                        }
                        break;
                    } case BLACK:{
                        if (chessSequence == 1) {
                            this.x = 1;
                            this.y = 9;
                        } else if (chessSequence == 2) {
                            this.x = 7;
                            this.y = 9;
                        }
                        break;
                    } default:{
                        break;
                    }
                }
                break;
            } case PAO:{
                switch (army) {
                    case RED:{
                        if (chessSequence == 1) {
                            this.x = 1;
                            this.y = 2;
                        } else if (chessSequence == 2) {
                            this.x = 7;
                            this.y = 2;
                        }
                        break;
                    } case BLACK:{
                        if (chessSequence == 1) {
                            this.x = 1;
                            this.y = 7;
                        } else if (chessSequence == 2) {
                            this.x = 7;
                            this.y = 7;
                        }
                        break;
                    } default:{
                        break;
                    }
                }
                break;
            } case SHI:{
                switch (army) {
                    case RED:{
                        if (chessSequence == 1) {
                            this.x = 3;
                            this.y = 0;
                        } else if (chessSequence == 2) {
                            this.x = 5;
                            this.y = 0;
                        }
                        break;
                    } case BLACK:{
                        if (chessSequence == 1) {
                            this.x = 3;
                            this.y = 9;
                        } else if (chessSequence == 2) {
                            this.x = 5;
                            this.y = 9;
                        }
                        break;
                    } default:{
                        break;
                    }
                }
                break;
            } case XIANG:{
                switch (army) {
                    case RED:{
                        if (chessSequence == 1) {
                            this.x = 2;
                            this.y = 0;
                        } else if (chessSequence == 2) {
                            this.x = 6;
                            this.y = 0;
                        }
                        break;
                    } case BLACK:{
                        if (chessSequence == 1) {
                            this.x = 2;
                            this.y = 9;
                        } else if (chessSequence == 2) {
                            this.x = 6;
                            this.y = 9;
                        }
                        break;
                    } default:{
                        break;
                    }
                }
                break;
            } case ZU:{
                switch (army) {
                    case RED:{
                        if (chessSequence == 1) {
                            this.x = 0;
                            this.y = 3;
                        } else if (chessSequence == 2) {
                            this.x = 2;
                            this.y = 3;
                        } else if (chessSequence == 3) {
                            this.x = 4;
                            this.y = 3;
                        } else if (chessSequence == 4) {
                            this.x = 6;
                            this.y = 3;
                        } else if (chessSequence == 5) {
                            this.x = 8;
                            this.y = 3;
                        }
                        break;
                    } case BLACK:{
                        if (chessSequence == 1) {
                            this.x = 0;
                            this.y = 6;
                        } else if (chessSequence == 2) {
                            this.x = 2;
                            this.y = 6;
                        } else if (chessSequence == 3) {
                            this.x = 4;
                            this.y = 6;
                        } else if (chessSequence == 4) {
                            this.x = 6;
                            this.y = 6;
                        } else if (chessSequence == 5) {
                            this.x = 8;
                            this.y = 6;
                        }
                        break;
                    } default:{
                        break;
                    }
                }
                break;
            } default:{
                break;
            }
        }
    }

    @ColumnConstraint(nullable = false)
    private Long gameId;

    @ColumnConstraint(nullable = false)
    private Army army;

    @ColumnConstraint(nullable = false)
    private Duty duty;

    @ColumnConstraint(nullable = false,minLength = 1,maxLength = 1)
    private Integer chessSequence;

    @ColumnConstraint(nullable = false,minLength = 1,maxLength = 1)
    private Integer x;

    @ColumnConstraint(nullable = false,minLength = 1,maxLength = 1)
    private Integer y;

    @ColumnConstraint(nullable = false,maxLength = 24,allowBlank = false,minLength = 1)
    private String validCode = GeneralConstant.ZERO_STRING;

    public String getChessRedisKey() {
        return String.valueOf(gameId) + "_" + army.toString() + "_" + duty.toString() + "_" + chessSequence;
    }

    public String getPositionRedisKey() {
        return String.valueOf(gameId) + "_" + String.valueOf(x) + "_" + String.valueOf(y);
    }
}
