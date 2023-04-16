package com.roadjava.statistic.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
public class DateUtil {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH:mm");

    public static LocalDateTime str2Date(String str) {
        return LocalDateTime.from(formatter.parse(str));
    }
}
