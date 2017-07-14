package com.lanxiang.httpclient.utils;

import org.apache.http.Header;
import org.apache.http.HttpResponse;

import java.io.Serializable;

public class HTTPResponse implements IHTTPResponse, Serializable {
    private static final long serialVersionUID = -1821379468426449438L;
    private int statusCode;
    private String responseAsString = null;
    private HttpResponse httpResponse;

    public HTTPResponse() {
    }

    public HTTPResponse(HttpResponse httpResponse) {
        this.httpResponse = httpResponse;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getResponseAsString() {
        return this.responseAsString;
    }

    public void setResponseAsString(String responseAsString) {
        this.responseAsString = responseAsString;
    }

    public HttpResponse getHttpResponse() {
        return this.httpResponse;
    }

    public void setHttpResponse(HttpResponse httpResponse) {
        this.httpResponse = httpResponse;
    }

    public String getHeader(String name) {
        Header[] allHeaders = this.httpResponse.getAllHeaders();
        if (allHeaders != null) {
            for (Header header : allHeaders) {
                if (header.getName().equals(name)) {
                    return header.getValue();
                }
            }
        }
        return null;
    }
}
