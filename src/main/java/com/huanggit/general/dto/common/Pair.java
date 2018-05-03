package com.huanggit.general.dto.common;

import lombok.Data;

/**
 * Created by huang on 2018-05-03-0003.
 */
@Data
public class Pair<X,Y> {

    private X first;
    private Y second;

    public Pair(X x,Y y) {
        first = x;
        second = y;
    }
}
