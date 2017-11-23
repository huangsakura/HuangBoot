package com.huanggit.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by huang on 2017-11-15-0015.
 */
public class DateUtil {

    private DateUtil(){}

    private static final String CHINESE_DATE_FORMAT_LINE = "yyyy-MM-dd";
    private static final String CHINESE_DATETIME_FORMAT_LINE = "yyyy-MM-dd HH:mm:ss";
    private static final String CHINESE_DATE_FORMAT_SLASH = "yyyy/MM/dd";
    private static final String CHINESE_DATETIME_FORMAT_SLASH = "yyyy/MM/dd HH:mm:ss";
    private static final String DATETIME_NOT_SEPARATOR = "yyyyMMddHHmmssSSS";
    private static final String DATE_NOT_SEPARATOR = "yyyyMMdd";

    private static SimpleDateFormat SDF_CHINESE_DATE_FORMAT_LINE;
    private static SimpleDateFormat SDF_CHINESE_DATETIME_FORMAT_LINE;
    private static SimpleDateFormat SDF_CHINESE_DATE_FORMAT_SLASH;
    private static SimpleDateFormat SDF_CHINESE_DATETIME_FORMAT_SLASH;
    private static SimpleDateFormat SDF_DATETIME_NOT_SEPARATOR;
    private static SimpleDateFormat SDF_DATE_NOT_SEPARATOR;

    public enum DateFormatPattern {
        CHINESE_DATE_FORMAT_LINE,
        CHINESE_DATETIME_FORMAT_LINE,
        CHINESE_DATE_FORMAT_SLASH,
        CHINESE_DATETIME_FORMAT_SLASH,
        DATETIME_NOT_SEPARATOR,
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
            } default:{
                throw new UnsupportedOperationException();
            }
        }
    }
}
