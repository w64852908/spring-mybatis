package com.lanxiang.rabbitmqmonitor.terminate;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lanxiang on 2017/4/21.
 */


/**
 * 接收状态码,并以Nagios状态码退出
 */
public class ExitUtil {

    private final static Logger log = LoggerFactory.getLogger(ExitUtil.class);

    public static void exit(String type) {
        if (type.equalsIgnoreCase("warning")) {
            log.info("Status is WARN");
            System.exit(1);
        } else if (type.equalsIgnoreCase("critical")) {
            log.info("Status is CRITICAL");
            System.exit(2);
        } else if (type.equalsIgnoreCase("unknown")) {
            log.info("Status is UNKNOWN");
            System.exit(3);
        } else if (type.equalsIgnoreCase("ok")) {
            log.info("Status is OK");
            System.exit(0);
        } else {
            log.error("Unknown exit type");
            System.exit(-1);
        }
    }
}