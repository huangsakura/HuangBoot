package com.huanggit.util;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
                return DateUtil.format(new Date(),DateUtil.DateFormatPattern.DATETIME_NOT_SEPARATOR);
            } default:{
                return UUID.randomUUID().toString();
            }
        }
    }

    private static class UuidLock {

        private Lock lock = new ReentrantLock();

        public String getTimeString() {
            //if (lock.tryLock())
            //while (!lock.tryLock()) {
             //   Thread.sleep(1);
            //}
            try {
                lock.tryLock(10,TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {

            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] a) {
        System.out.println(getUUID(Type.TIME));
    }
}
