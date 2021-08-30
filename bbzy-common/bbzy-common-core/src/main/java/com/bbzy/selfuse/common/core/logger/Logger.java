package com.bbzy.selfuse.common.core.logger;

import org.slf4j.LoggerFactory;

/**
 * 日志封装类，使用静态方法打印日志  无需每个类中定义日志对象
 * Logback对每个Logger对象做了缓存，每次调用LoggerFactory.getLogger(String name)时如果已存在则从缓存中获取不会生成新的对象;
 * 同时也不会有对象的创建与销毁造成的性能损失
 *
 * @author bbzy
 * @datetime  2021-08-30 20:01:05 星期一
 */
public class Logger {
    public static void error(String msg) {
        LoggerFactory.getLogger(getClassName()).error(msg);
        //LoggerFactory.getILoggerFactory().getLogger(getClassName()).
    }

    public static void error(String msg, Object... obj) {
        LoggerFactory.getLogger(getClassName()).error(msg, obj);
    }

    public static void error(String msg, Exception e) {
        StackTraceElement[] stackTraces = e.getStackTrace();// 得到异常棧的首个元素
        StringBuilder errMessage = new StringBuilder();
        errMessage.append(e.getMessage() + "\r\n");
        for (StackTraceElement stackTrace : stackTraces) {
            errMessage.append(stackTrace.toString() + "\r\n");
        }
        LoggerFactory.getLogger(getClassName()).error(msg, errMessage);
    }

    public static void warn(String msg) {
        LoggerFactory.getLogger(getClassName()).error(msg);
    }

    public static void warn(String msg, Object... obj) {
        LoggerFactory.getLogger(getClassName()).error(msg, obj);
    }

    public static void info(String msg) {
        LoggerFactory.getLogger(getClassName()).info(msg);
    }

    public static void info(String msg, Object... obj) {
        LoggerFactory.getLogger(getClassName()).info(msg, obj);
    }

    public static void debug(String msg) {
        LoggerFactory.getLogger(getClassName()).debug(msg);
    }

    public static void debug(String msg, Object... obj) {
        LoggerFactory.getLogger(getClassName()).debug(msg, obj);
    }

    // 获取调用 error,info,debug静态类的类名
    private static String getClassName() {
        return new SecurityManager() {
            public String getClassName() {
                return getClassContext()[3].getName();
            }
        }.getClassName();
    }
}
