package ca.ulaval.glo4002.rpn_calculator.interfaces;

import org.eclipse.jetty.server.Server;

public class Main {

    private static final int JETTY_PORT = 8080;

    public static void main(String[] args) throws Exception {
        Server server = new JettyServer().create(JETTY_PORT);
        server.start();
        server.join();
    }
}
