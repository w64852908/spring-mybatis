package com.lanxiang.httpclient.utils;

/**
 * Created by lanxiang on 2017/6/20.
 */

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.Serializable;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLException;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.NoHttpResponseException;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

public class HTTPHelper implements Serializable {
    private static final long serialVersionUID = -3299372832483886065L;

    private static final String CHARSET_UTF8 = "UTF-8";
    private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    private static final Logger LOGGER = LoggerFactory.getLogger(HTTPHelper.class);

    private CloseableHttpClient _httpClient = null;

    private PoolingHttpClientConnectionManager connectionManager = null;

    public HTTPHelper() {//默认配置
        this(1024, 30000, 30000, 1048576);
    }

    public HTTPHelper(int maxConPerHost, int conTimeOutMs, int soTimeOutMs, int maxSize) {
        Registry<ConnectionSocketFactory> r = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", SSLConnectionSocketFactory.getSocketFactory())
                .build();

        connectionManager = new PoolingHttpClientConnectionManager(r);
        connectionManager.setMaxTotal(1024);//连接总数
        connectionManager.setDefaultMaxPerRoute(maxConPerHost);//每个主机的并发
        HttpHost localhost = new HttpHost("localhost", 8888);
        connectionManager.setMaxPerRoute(new HttpRoute(localhost), maxConPerHost);

        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(soTimeOutMs)//读取超时时间
                .setConnectTimeout(conTimeOutMs)//连接超时时间
                .setConnectionRequestTimeout(200)//从连接池中获取到连接的最长时间
                .setStaleConnectionCheckEnabled(true)
                .setCookieSpec(CookieSpecs.IGNORE_COOKIES)
                .setExpectContinueEnabled(Boolean.FALSE)
                .build();

        HashSet<Header> defaultHeaders = new HashSet<Header>();
        //defaultHeaders.add(new BasicHeader(HttpHeaders.ACCEPT_LANGUAGE, getAcceptLanguage()));
        //defaultHeaders.add(new BasicHeader(HttpHeaders.ACCEPT_CHARSET,  ));
        //defaultHeaders.add(new BasicHeader(HttpHeaders.ACCEPT_ENCODING,  ));
        //defaultHeaders.add(new BasicHeader(HttpHeaders.ACCEPT, DEFAULT_ACCEPT));
        defaultHeaders.add(new BasicHeader("REMOTE_MACHINE", "MAOYAN_GATEWAY"));

        this._httpClient = HttpClients
                .custom()
                .setConnectionManager(connectionManager)
                .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.97 Safari/537.36")
                .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
                .setDefaultRequestConfig(requestConfig)
                .setRetryHandler(new DefaultHttpRequestRetryHandler(0, false))//不重试
                .setDefaultHeaders(defaultHeaders)
                .build();

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("apache http client create succeed!");
        }

        //this._httpClient.getParams().setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
        //this._httpClient.getParams().setParameter("http.protocol.content-charset", DEFAULT_CHARSET.toString());
        //this._httpClient.getParams().setParameter("http.tcp.nodelay", Boolean.TRUE);

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                LOGGER.info("HTTPHelper has shutdown");
                try {
                    if (connectionManager != null) {
                        connectionManager.shutdown();
                    }
                    IOUtils.closeQuietly(_httpClient);
                } catch (Exception e) {
                    LOGGER.info("HTTPHelper Exception by:", e.getMessage());
                }
            }
        }));
    }

    public IHTTPResponse get(String url, Map<String, ?> params) {
        HttpGet httpGet = null;
        if (url == null) {
            return null;
        }
        List qparams = getParamsList(params);
        if ((qparams != null) && (qparams.size() > 0)) {
            String formatParams = URLEncodedUtils.format(qparams, "UTF-8");
            url = url + "?" + formatParams;
        }
        try {
            httpGet = new HttpGet(url);

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("HTTPHelper get " + url);
            }
            return retriveResponse(this._httpClient.execute(httpGet));
        } catch (IOException e) {
            abortRequest(httpGet);
            LOGGER.error("http get error.", e);
            throw new RuntimeException(e);
        } finally {
            if (httpGet != null) {
                httpGet.releaseConnection();
            }
        }
    }

    public IHTTPResponse get(String url) {
        HttpGet httpGet = null;
        if (url == null) {
            return null;
        }
        try {
            httpGet = new HttpGet(url);

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("HTTPHelper get " + url);
            }
            return retriveResponse(this._httpClient.execute(httpGet));
        } catch (IOException e) {
            abortRequest(httpGet);
            LOGGER.error("http get error.", e);
            throw new RuntimeException(e);
        } finally {
            if (httpGet != null) {
                httpGet.releaseConnection();
            }
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public IHTTPResponse post(String url, Map<String, ?> params) {
        try {
            HttpPost httpPost = new HttpPost(url);

            if ((params != null) && (!params.isEmpty())) {
                List nvps = getParamsList(params);
                httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            }
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("HTTPHelper post " + url);
            }
            return retriveResponse(this._httpClient.execute(httpPost));
        } catch (IOException e) {
            LOGGER.debug("post exception " + url, e);
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public IHTTPResponse postJSON(String url, String params) {
        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader(HTTP.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
            if (null != params && !"".equals(params)) {
                httpPost.setEntity(new StringEntity(params, ContentType.APPLICATION_JSON));
            }
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("HTTPHelper post " + url);
            }
            return retriveResponse(this._httpClient.execute(httpPost));
        } catch (IOException e) {
            LOGGER.debug("post exception " + url, e);
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public IHTTPResponse putForm(String url, Map<String, ?> params) {
        try {
            HttpPut httpPut = new HttpPut(url);
            if ((params != null) && (!params.isEmpty())) {
                List nvps = getParamsList(params);
                httpPut.setEntity(new UrlEncodedFormEntity(nvps));
            }
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("HTTPHelper put " + url);
            }
            return retriveResponse(this._httpClient.execute(httpPut));
        } catch (IOException e) {
            LOGGER.debug("put exception " + url, e);
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public IHTTPResponse putJson(String url, Map<String, ?> params) {
        try {
            HttpPut httpPut = new HttpPut(url);
            if ((params != null) && (!params.isEmpty())) {
                String jsonParams = getJsonParamsString(params);
                StringEntity entity = new StringEntity(jsonParams);
                entity.setContentType(ContentType.APPLICATION_JSON.getMimeType());
                httpPut.setEntity(entity);
            }
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("HTTPHelper put " + url);
            }
            return retriveResponse(this._httpClient.execute(httpPut));
        } catch (IOException e) {
            LOGGER.debug("put exception " + url, e);
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    protected IHTTPResponse retriveResponse(HttpResponse httpResponse) throws IOException {
        StatusLine statusLine = httpResponse.getStatusLine();
        assert (statusLine != null);
        if (LOGGER.isDebugEnabled()) {
            Header[] responseHeaders = httpResponse.getAllHeaders();
            for (int i = 0; i < responseHeaders.length; i++) {
                LOGGER.debug("response header [" + i + " ]:" + responseHeaders[i]);
            }
        }

        if (statusLine.getStatusCode() >= 300) {
            return null;
        }
        HttpEntity entity = httpResponse.getEntity();
        if (entity == null) {
            throw new ClientProtocolException("Response contains no content.");
        }
        Charset entityCharset = null;
        try {
            entityCharset = ContentType.get(entity).getCharset();
        } catch (Exception localException) {
        }
        if (entityCharset == null) {
            entityCharset = DEFAULT_CHARSET;
        }

        HTTPResponse response = new HTTPResponse();
        response.setResponseAsString(new String(EntityUtils.toByteArray(entity), entityCharset));
        response.setStatusCode(statusLine.getStatusCode());
        response.setHttpResponse(httpResponse);
        return response;
    }

    private void abortRequest(HttpRequestBase httpRequestBase) {
        if ((httpRequestBase != null) && (httpRequestBase.isAborted()))
            httpRequestBase.abort();
    }

    private List<NameValuePair> getParamsList(Map<String, ?> paramsMap) {
        if ((paramsMap == null) || (paramsMap.size() == 0)) {
            return null;
        }
        List params = new ArrayList();
        for (Map.Entry map : paramsMap.entrySet()) {
            params.add(new BasicNameValuePair((String) map.getKey(), map.getValue() == null ? "" : map.getValue().toString()));
        }
        return params;
    }

    private String getJsonParamsString(Map<String, ?> paramsMap) {
        JSONObject jsonParam = new JSONObject();
        for (Map.Entry<String, ?> entry : paramsMap.entrySet()) {
            jsonParam.put(entry.getKey(), entry.getValue());
        }
        return jsonParam.toJSONString();
    }


    private class RequestRetryHandler implements HttpRequestRetryHandler {
        @Override
        public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
            if (executionCount >= 3) {
                return false;
            }

            if ((exception instanceof NoHttpResponseException)) {
                return true;
            }

            if ((exception instanceof InterruptedIOException)) {
                return false;
            }
            if ((exception instanceof UnknownHostException)) {
                return false;
            }

            if ((exception instanceof ConnectException)) {
                return false;
            }

            if ((exception instanceof SSLException)) {
                return false;
            }

            HttpRequest request = (HttpRequest) context.getAttribute("http.request");
            boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
            return idempotent;
        }
    }
}
