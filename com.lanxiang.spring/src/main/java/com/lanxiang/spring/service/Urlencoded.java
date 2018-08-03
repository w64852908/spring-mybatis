package com.lanxiang.spring.service;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;
import org.junit.Test;

/**
 * Created by lanxiang on 2018/1/4.
 */
public class Urlencoded {

    @Test
    public void test1() throws EncoderException {
        URLCodec urlCodec = new URLCodec();
        String res = urlCodec.encode("-");
        System.out.println(res);
    }

    @Test
    public void test2() throws DecoderException {
        URLCodec urlCodec = new URLCodec();
        String res = urlCodec.decode("%c2%ad");
        System.out.println(res);
    }
}
