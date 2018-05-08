package com.huanggit.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by huang on 2017-11-15-0015.
 */
public class DateUtil {

    private DateUtil(){}

    public static final String CHINESE_DATE_FORMAT_LINE = "yyyy-MM-dd";
    public static final String CHINESE_DATETIME_FORMAT_LINE = "yyyy-MM-dd HH:mm:ss";
    public static final String CHINESE_DATE_FORMAT_SLASH = "yyyy/MM/dd";
    public static final String CHINESE_DATETIME_FORMAT_SLASH = "yyyy/MM/dd HH:mm:ss";
    public static final String DATETIME_NOT_SEPARATOR = "yyyyMMddHHmmssSSS";
    public static final String DATETIME_NOT_SEPARATOR_HALF_YEAR = "yyMMddHHmmssSSS";
    public static final String DATE_NOT_SEPARATOR = "yyyyMMdd";

    private static SimpleDateFormat SDF_CHINESE_DATE_FORMAT_LINE;
    private static SimpleDateFormat SDF_CHINESE_DATETIME_FORMAT_LINE;
    private static SimpleDateFormat SDF_CHINESE_DATE_FORMAT_SLASH;
    private static SimpleDateFormat SDF_CHINESE_DATETIME_FORMAT_SLASH;
    private static SimpleDateFormat SDF_DATETIME_NOT_SEPARATOR;
    private static SimpleDateFormat SDF_DATETIME_NOT_SEPARATOR_HALF_YEAR;
    private static SimpleDateFormat SDF_DATE_NOT_SEPARATOR;

    public enum DateFormatPattern {
        CHINESE_DATE_FORMAT_LINE,
        CHINESE_DATETIME_FORMAT_LINE,
        CHINESE_DATE_FORMAT_SLASH,
        CHINESE_DATETIME_FORMAT_SLASH,
        DATETIME_NOT_SEPARATOR,
        DATETIME_NOT_SEPARATOR_HALF_YEAR,
        DATE_NOT_SEPARATOR
    }

    public static String format(Date date, DateFormatPattern dateFormatPattern) {
        return getSimpleDateFormat(dateFormatPattern).format(date);
    }

    private static SimpleDateFormat getSimpleDateFormat(DateFormatPattern dateFormatPattern) {
        switch (dateFormatPattern) {
            case DATETIME_NOT_SEPARATOR:{
                if (null == SDF_DATETIME_NOT_SEPARATOR) {
                    SDF_DATETIME_NOT_SEPARATOR = new SimpleDateFormat(DATETIME_NOT_SEPARATOR);
                }
                return SDF_DATETIME_NOT_SEPARATOR;
            } case CHINESE_DATE_FORMAT_LINE:{
                if (null == SDF_CHINESE_DATE_FORMAT_LINE) {
                    SDF_CHINESE_DATE_FORMAT_LINE = new SimpleDateFormat(CHINESE_DATE_FORMAT_LINE);
                }
                return SDF_CHINESE_DATE_FORMAT_LINE;
            } case CHINESE_DATE_FORMAT_SLASH:{
                if (null == SDF_CHINESE_DATE_FORMAT_SLASH) {
                    SDF_CHINESE_DATE_FORMAT_SLASH = new SimpleDateFormat(CHINESE_DATE_FORMAT_SLASH);
                }
                return SDF_CHINESE_DATE_FORMAT_SLASH;
            } case CHINESE_DATETIME_FORMAT_LINE:{
                if (null == SDF_CHINESE_DATETIME_FORMAT_LINE) {
                    SDF_CHINESE_DATETIME_FORMAT_LINE = new SimpleDateFormat(CHINESE_DATETIME_FORMAT_LINE);
                }
                return SDF_CHINESE_DATETIME_FORMAT_LINE;
            } case CHINESE_DATETIME_FORMAT_SLASH:{
                if (null == SDF_CHINESE_DATETIME_FORMAT_SLASH) {
                    SDF_CHINESE_DATETIME_FORMAT_SLASH = new SimpleDateFormat(CHINESE_DATETIME_FORMAT_SLASH);
                }
                return SDF_CHINESE_DATETIME_FORMAT_SLASH;
            } case DATE_NOT_SEPARATOR:{
                if (null == SDF_DATE_NOT_SEPARATOR) {
                    SDF_DATE_NOT_SEPARATOR = new SimpleDateFormat(DATE_NOT_SEPARATOR);
                }
                return SDF_DATE_NOT_SEPARATOR;
            } case DATETIME_NOT_SEPARATOR_HALF_YEAR :{
                if (null == SDF_DATETIME_NOT_SEPARATOR_HALF_YEAR) {
                    SDF_DATETIME_NOT_SEPARATOR_HALF_YEAR = new SimpleDateFormat(DATETIME_NOT_SEPARATOR_HALF_YEAR);
                }
                return SDF_DATETIME_NOT_SEPARATOR_HALF_YEAR;
            } default:{
                throw new UnsupportedOperationException();
            }
        }
    }

    public static Date igoreTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        return calendar.getTime();
    }

    public static Date igoreTime(int year,int month,int date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year,month-1,date,0,0,0);
        calendar.set(Calendar.MILLISECOND,0);
        return calendar.getTime();
    }

    public static Date currentTime() {
        return new Date();
    }
}
