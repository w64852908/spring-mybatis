package com.lanxiang.httpclient.async;

import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.nio.client.HttpAsyncClient;
import org.junit.Test;

/**
 * Created by lanxiang on 2017/10/18.
 */
public class AsyncTest {

    @Test
    public void testAsync() {
        HttpAsyncClient asyncClient = HttpAsyncClients.createDefault();

    }
}
