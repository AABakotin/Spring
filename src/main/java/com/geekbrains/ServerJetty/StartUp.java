package com.geekbrains.ServerJetty;


import java.net.URL;
import java.security.ProtectionDomain;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class StartUp {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8189);
        ProtectionDomain domain = StartUp.class.getProtectionDomain();
        URL location = domain.getCodeSource().getLocation();
        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath("/");
        webapp.setWar(location.toExternalForm());
        server.setHandler(webapp);
        server.start();
        server.join();
    }
}
