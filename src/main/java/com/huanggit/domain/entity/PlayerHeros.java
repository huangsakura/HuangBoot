package com.huanggit.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.huanggit.enumeration.player.HeroProficiency;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by huang on 2017-11-15-0015.
 */
@Entity
@Table(name = "player_heros")
@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class PlayerHeros {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String playerCode;

    @NotBlank
    private String heroCode;

    @Enumerated(EnumType.STRING)
    private HeroProficiency heroProficiency;

    @NotNull
    @JsonIgnore
    private Date createTime = new Date();
}
