package com.huanggit.util;

import java.util.UUID;

public class UUIDUtil {

    public enum Type {
        ORIGIN,
        NO_HYPHEN,
        TIME_STAMP,
        TIME
    }

    public static String getUUID(Type type) {
        switch (type) {
            case ORIGIN:{
                return UUID.randomUUID().toString();
            } case NO_HYPHEN:{
                return UUID.randomUUID().toString().replace("-","");
            } case TIME_STAMP:{
                return String.valueOf(System.currentTimeMillis());
            } case TIME:{
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(System.nanoTime());
                stringBuffer.append(RandomUtil.randomChar(6));
                return stringBuffer.toString();
            } default:{
                return UUID.randomUUID().toString();
            }
        }
    }

    public static void main(String[] a) {
        new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println(getUUID(Type.TIME));
            }
        }).start();
        new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println(getUUID(Type.TIME));
            }
        }).start();
        new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println(getUUID(Type.TIME));
            }
        }).start();
        new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println(getUUID(Type.TIME));
            }
        }).start();
        new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println(getUUID(Type.TIME));
            }
        }).start();
    }
}
