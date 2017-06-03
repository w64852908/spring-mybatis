package com.lanxiang.rabbitmqmonitor.utils;

import org.apache.commons.codec.binary.Base64;

/**
 * Created by lanxiang on 2017/4/21.
 */
public class Base64Util {

    public static String base64Encode(final byte[] bytes) {
        return new String(Base64.encodeBase64(bytes));
    }
}
