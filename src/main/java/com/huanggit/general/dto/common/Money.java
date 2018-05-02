package com.huanggit.general.dto.common;

import com.huanggit.exception.BusinessException;

import java.io.Serializable;

/**
 * Created by huang on 2018-04-27-0027.
 */
public class Money implements Serializable {

    private Long cent = 0L;

    public Long getCent() {
        return cent;
    }

    public void setCent(Long cent) {
        this.cent = cent;
    }

    public Money() {
        this.cent = 0L;
    }

    public Money(Long t_cent) {
        this.cent = t_cent;
    }

    public static Money cent(Long t_cent) {
        return new Money(t_cent);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Money)) {
            return false;
        }
        return this.cent.compareTo(((Money)obj).getCent()) == 0;
    }

    public Money add(Money other) {
        return Money.cent(this.cent + other.cent);
    }

    public Money subtract(Money other) {
        if (this.cent.compareTo(other.cent) < 0) {
            throw new BusinessException("被减数不能小于减数");
        }
        return Money.cent(this.cent - other.cent);
    }

    @Override
    public String toString() {
        return String.valueOf(this.cent);
    }
}
