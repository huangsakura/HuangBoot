package com.huanggit.util;

import java.util.Random;

/**
 * Created by huang on 2017-11-15-0015.
 */
public class RandomUtil {

    private RandomUtil(){}

    private static final char[] ENGLISH_CHARS = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    private static final char[] NUMBERS = {'1','2','3','4','5','6','7','8','9','0'};

    private static final Random RANDOM = new Random();

    public static String prefixChar(int length) {
        if (length <= 0) {
            throw new UnsupportedOperationException();
        }
        StringBuffer sb = new StringBuffer();

        for (int i=0;i<length;i++) {
            sb.append(ENGLISH_CHARS[RANDOM.nextInt(26)]);
        }
        return sb.toString();
    }

    public static String prefixNumber(int length) {
        if (length <= 0) {
            throw new UnsupportedOperationException();
        }
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<length;i++) {
            sb.append(NUMBERS[RANDOM.nextInt(10)]);
        }
        return sb.toString();
    }

    public static void main(String[] a) {
        System.out.println(prefixChar(4));
        System.out.println(prefixNumber(4));
    }
}
