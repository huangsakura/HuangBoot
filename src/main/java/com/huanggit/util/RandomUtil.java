package com.huanggit.util;

import java.util.Random;

/**
 * Created by huang on 2017-11-15-0015.
 */
public class RandomUtil {

    private RandomUtil(){}

    private static final char[] ENGLISH_CHARS = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    public static String prefixCode(int length) {
        if (length <= 0) {
            throw new UnsupportedOperationException();
        }
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<length;i++) {
            Random random = new Random();
            sb.append(ENGLISH_CHARS[random.nextInt(25)]);
        }
        return sb.toString();
    }
}
