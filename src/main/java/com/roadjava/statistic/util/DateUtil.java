package com.roadjava.statistic.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
@Deprecated
public class DateUtil {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH:mm");

    public static LocalDateTime str2Date(String str) {
        return LocalDateTime.from(formatter.parse(str));
    }
}
