package com.huanggit.util;

import com.huanggit.exception.BusinessException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by huang on 2017-11-18-0018.
 */
public class SecurityUtil {

    private SecurityUtil(){}

    public static byte[] sha1(byte[] input, byte[] salt, int iterations) {
        return digest(input, "SHA-1", salt, iterations);
    }

    private static byte[] digest(byte[] input, String algorithm, byte[] salt, int iterations) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new BusinessException(e.getMessage());
        }

        if(salt != null) {
            digest.update(salt);
        }

        byte[] result = digest.digest(input);

        for(int i = 1; i < iterations; ++i) {
            digest.reset();
            result = digest.digest(result);
        }
        return result;
    }
}
