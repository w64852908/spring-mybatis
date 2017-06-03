package com.lanxiang.rabbitmqmonitor.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.lanxiang.rabbitmqmonitor.remote.resource.RMQResource;
import com.lanxiang.rabbitmqmonitor.utils.Base64Util;
import com.lanxiang.rabbitmqmonitor.utils.RMQConfig;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.glassfish.jersey.apache.connector.ApacheClientProperties;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.proxy.WebResourceFactory;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lanxiang on 2017/4/21.
 */

/**
 * RabbitMQ的REST API
 */
public class RMQApi {

    private final static Logger log = LoggerFactory.getLogger(RMQApi.class);

    private static Map<Class<?>, Object> restInstance = new HashMap<>();

    static {
        RMQConfig config = RMQConfig.Singleton.INSTANCE.getRmqConfig();
        String rmqUrl = config.getRmqUrl();
        String username = config.getUsername();
        String password = config.getPassword();

        //调用RabbitMQ Management HTTP API需要带上验证信息
        String authorization = "Basic " + Base64Util.base64Encode((username + ":" + password).getBytes());

        log.info("RabbitMQ monitor REST url {}", rmqUrl);

        ClientConfig clientConfig = new ClientConfig();
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(10);
        connectionManager.setDefaultMaxPerRoute(10);
        connectionManager.setValidateAfterInactivity(60000);

        clientConfig.property(ApacheClientProperties.CONNECTION_MANAGER, connectionManager);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);



        WebTarget target = ClientBuilder.newClient(clientConfig)
                .register(JacksonFeature.class)
                .register(new JacksonJsonProvider(objectMapper))
                .target(rmqUrl);

        restInstance.put(RMQResource.class, bindService(RMQResource.class, target, authorization));
    }

    private static <T> T bindService(Class<T> clazz, WebTarget target, String authorization) {
        MultivaluedMap<String, Object> headers = new MultivaluedHashMap<>();
        headers.put("Authorization", Arrays.asList((Object) authorization));
        return WebResourceFactory.newResource(clazz, target, false, headers, new ArrayList<Cookie>(), new Form());
    }

    @SuppressWarnings("unchecked")
    public static <T> T getService(Class<T> tClass) {
        return (T) restInstance.get(tClass);
    }
}
