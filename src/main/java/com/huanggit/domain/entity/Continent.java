package com.huanggit.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by huang on 2017-11-20-0020.
 */
@Table
@Entity(name = "continent")
@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Continent {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String code;

    @NotBlank
    private String name;

    @NotBlank
    private String chineseName;

    @JsonIgnore
    @NotNull
    private Date createTime;
}
