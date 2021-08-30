package com.bbzy.selfuse.common.core.result;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wangkeqiang
 * @date 2020-06-23
 **/
@AllArgsConstructor
@NoArgsConstructor
public enum ResultCode implements IResultCode, Serializable {

    SUCCESS("00000", "一切ok"),
    USER_NOT_ONLINE("A0001", "用户不在线"),
    PARAM_MISSING("4444", "参数缺失或非法"),

    SYSTEM_EXECUTION_ERROR("B0001", "系统执行出错"),
    SYSTEM_EXECUTION_TIMEOUT("B0100", "系统执行超时"),

    SYSTEM_DISASTER_RECOVERY_TRIGGER("B0200", "系统容灾触发"),
    FLOW_LIMITING("B0210", "系统限流"),
    DEGRADATION("B0220", "系统功能降级"),

    SYSTEM_RESOURCE_ERROR("B0300", "系统资源异常"),
    SYSTEM_RESOURCE_EXHAUSTION("B0310", "系统资源耗尽"),
    SYSTEM_RESOURCE_ACCESS_ERROR("B0320", "系统资源访问异常"),
    SYSTEM_READ_DISK_FILE_ERROR("B0321", "系统读取磁盘文件失败"),


    INF09001("9001", "用户账户余额不足"),

    INF08505("8505", "微信支付二维码生成失败"),
    INF08506("8506", "支付宝支付二维码生成失败"),
    INF08500("8500", "订单已支付");



    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    private String code;

    private String msg;

    @Override
    public String toString() {
        return "{" +
                "\"code\":\"" + code + '\"' +
                ", \"msg\":\"" + msg + '\"' +
                '}';
    }


    public static ResultCode getValue(String code) {
        for (ResultCode value : values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return SYSTEM_EXECUTION_ERROR; // 默认分页查询
    }
}
