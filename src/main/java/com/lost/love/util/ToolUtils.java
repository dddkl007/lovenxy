package com.lost.love.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhongzhiqiang
 * @date 2018/7/17  8:38
 */
public class ToolUtils {
    public static String getIP(HttpServletRequest request){
        String ip = "";
        try {
            ip = request.getHeader("x-forwarded-for");
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("X-Real-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ip;
    }

}
