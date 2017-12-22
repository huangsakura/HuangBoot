package com.huanggit.util;

/**
 * Created by huang on 2017-12-19-0019.
 */
public class PriceUtil {

    private PriceUtil(){}

    public static Integer calcuPrice(Long distance) {
        if (distance <= 6000L) {
            return 2;
        } else if (distance <= 11000L) {
            return 3;
        } else if (distance <= 17000L) {
            return 4;
        } else if (distance <= 24000L) {
            return 5;
        } else if (distance <= 32000L) {
            return 6;
        } else if (distance <= 41000L) {
            return 7;
        } else if (distance <= 51000L) {
            return 8;
        } else if (distance <= 63000L) {
            return 9;
        } else {
            return 10;
        }
    }
}
