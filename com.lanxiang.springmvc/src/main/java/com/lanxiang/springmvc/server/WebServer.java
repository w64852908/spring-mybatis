package com.lanxiang.springmvc.server;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.WebInfConfiguration;
import org.eclipse.jetty.webapp.WebXmlConfiguration;

import java.io.File;
import java.net.URL;

/**
 * Created by lanxiang on 2017/3/24.
 */

@Slf4j
public class WebServer {

    public static void start(int port, String webappPath) {
        log.info("Start webapp : {}", webappPath);
        String host = "localhost";
        String path = "/";
        String uri = "http://" + host + ":" + port + path;
        try {
            Server server = new Server(port);

            WebAppContext context = new WebAppContext();
            context.setDisplayName("JettyContext");
            context.setThrowUnavailableOnStartupException(true);
            context.setContextPath(path);
            context.setResourceBase(webappPath + "/resources");
            context.setWelcomeFiles(new String[]{"/webapp/index.json"});
            context.setConfigurations(new Configuration[]{
                    new WebXmlConfiguration(),
                    new WebInfConfiguration()
            });

            server.setHandler(context);
            server.start();
            log.info("Application started at {}", uri);
        } catch (Exception e) {
            log.error("Http server error." + e);
        }
    }

    public static void main(String[] args) throws Exception {
        URL url = Thread.currentThread().getContextClassLoader().getResource(".");
        String classes = url.getFile();
        File targetClassFolder = new File(classes);
        String parentPath = targetClassFolder.getParentFile().getParent();
        start(9090, parentPath + "/src/main");
    }
}
