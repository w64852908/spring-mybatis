package com.lanxiang.httpclient.utils;

public interface IHTTPResponse {

    int getStatusCode();

    String getResponseAsString();

    String getHeader(String paramString);
}
