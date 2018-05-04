package com.huanggit.util;

import com.huanggit.enumeration.common.ResultCode;
import com.huanggit.exception.BusinessException;
import org.apache.commons.codec.binary.Hex;

import java.security.SecureRandom;

/**
 * Created by huang on 2017-11-15-0015.
 */
public class RandomUtil {

    private RandomUtil(){}

    private static final char[] BIG_ENGLISH_CHARS = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    private static final char[] SMALL_ENGLISH_CHARS = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private static final char[] NUMBERS = {'1','2','3','4','5','6','7','8','9','0'};

    private static final char[] ALL_CHARS = new char[62];
    static {
        System.arraycopy(BIG_ENGLISH_CHARS,0,ALL_CHARS,0,26);
        System.arraycopy(SMALL_ENGLISH_CHARS,0,ALL_CHARS,26,26);
        System.arraycopy(NUMBERS,0,ALL_CHARS,52,10);
    }

    private static final SecureRandom RANDOM = new SecureRandom();

    public static String randomChar(int length) {
        if (length <= 0) {
            throw new BusinessException(ResultCode.NOT_ALLOWED_PARAMETER);
        }
        StringBuffer sb = new StringBuffer();

        for (int i=0;i<length;i++) {
            sb.append(ALL_CHARS[RANDOM.nextInt(62)]);
        }
        return sb.toString();
    }

    public static String randomNumber(int length) {
        if (length <= 0) {
            throw new BusinessException(ResultCode.NOT_ALLOWED_PARAMETER);
        }
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<length;i++) {
            sb.append(NUMBERS[RANDOM.nextInt(10)]);
        }
        return sb.toString();
    }

    public static byte[] randomBytes(int numBytes) {
        if (numBytes <= 0) {
            throw new BusinessException(ResultCode.NOT_ALLOWED_PARAMETER);
        }
        byte[] bytes = new byte[numBytes];
        RANDOM.nextBytes(bytes);
        return bytes;
    }

    public static String randomString(int numBytes) {
        return Hex.encodeHexString(randomBytes(numBytes));
    }

    public static void main(String[] a) {
        System.out.println(System.nanoTime());
        System.out.println(System.nanoTime());
        System.out.println(System.nanoTime());
        System.out.println(System.currentTimeMillis());
        System.out.println(randomChar(5));
    }
}
