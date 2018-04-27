package com.huanggit.general.dto.common;

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
        Money money = new Money();
        money.setCent(t_cent);
        return money;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Money)) {
            return false;
        }
        return this.cent.compareTo(((Money)obj).getCent()) == 0;
    }
}
