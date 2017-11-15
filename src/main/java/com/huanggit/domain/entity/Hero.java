package com.huanggit.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by huang on 2017-11-15-0015.
 */
@Entity
@Table(name = "hero")
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Data
public class Hero {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String heroName;

    @NotBlank
    private String heroCode;

    @JsonIgnore
    private Date createTime = new Date();
}
