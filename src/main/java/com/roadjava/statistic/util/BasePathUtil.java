package com.roadjava.statistic.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 时天晔
 * @data: 2023/4/16
 * description:
 */
@Deprecated
public class BasePathUtil {
    public static String getBasePath(HttpServletRequest request) {
        String basePath = null;
        String scheme = request.getScheme(); // http
        String serverName = request.getServerName(); // localhost
        int serverPort = request.getServerPort(); // 8888
        String contextPath = request.getContextPath(); // /ssm_student_war_exploded
        if (serverPort == 80) {
            basePath = scheme +"://" + serverName +contextPath +"/";
        } else {
            basePath = scheme +"://" + serverName +":" + serverPort +contextPath +"/";
        }
        // 比如: http://localhost:8888/ssm_student_war_exploded/
        return basePath;
    }
}
