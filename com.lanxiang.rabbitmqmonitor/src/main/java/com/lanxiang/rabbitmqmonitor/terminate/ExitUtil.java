package com.lanxiang.rabbitmqmonitor.terminate;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by lanxiang on 2017/4/21.
 */


@Slf4j
public class ExitUtil {

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
        } else {
            log.info("Status is OK");
            System.exit(0);
        }
    }
}
