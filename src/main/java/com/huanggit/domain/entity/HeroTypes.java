package com.huanggit.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.huanggit.enumeration.hero.HeroType;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by huang on 2017-11-15-0015.
 */
@Entity
@Table(name = "hero_types")
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
public class HeroTypes {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String heroCode;

    @NotNull
    @Enumerated(EnumType.STRING)
    private HeroType heroTypes;

    @JsonIgnore
    private Date createTime = new Date();
}
