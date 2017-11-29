package com.huanggit.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by huang on 2017-11-29-0029.
 */
@Table
@Entity(name = "Country_Border")
@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class CountryBorder {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String hostAlpha3Code;

    @NotBlank
    private String guestAlpha3Code;

    @JsonIgnore
    @NotNull
    private Date createTime;
}
