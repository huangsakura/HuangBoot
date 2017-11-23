package com.huanggit.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.huanggit.enumeration.common.Country;
import com.huanggit.enumeration.player.Gender;
import com.huanggit.enumeration.player.Rank;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by huang on 2017-11-15-0015.
 */
@Entity
@Table(name = "player")
@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Player {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String playerCode;

    @NotBlank
    private String mobile;

    @NotBlank
    @JsonIgnore
    private String password;

    @NotBlank
    @JsonIgnore
    private String passwordSalt;

    @NotBlank
    private String nickName;

    private Integer point = new Integer(0);

    @Enumerated(EnumType.STRING)
    private Gender gender = Gender.UNKNOWN;

    @Enumerated(EnumType.STRING)
    private Rank rank = Rank.COPPER3;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Country country;

    @NotNull
    @JsonIgnore
    private Date createTime = new Date();
}
