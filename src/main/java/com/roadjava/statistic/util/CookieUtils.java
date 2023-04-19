package com.roadjava.statistic.util;

import com.google.common.collect.Maps;

import java.util.HashMap;

/**
 * @author 时天晔
 * @data 2023/4/18
 * description: 一次进程中的缓存
 */
public class CookieUtils {

    private static HashMap<String,Integer> hashMap = Maps.newHashMap();

    public static HashMap<String,Integer> getHashMap() {
        return hashMap;
    }

    public static void setHashMap(HashMap<String, Integer> hashMap) {
        CookieUtils.hashMap = hashMap;
    }
}
