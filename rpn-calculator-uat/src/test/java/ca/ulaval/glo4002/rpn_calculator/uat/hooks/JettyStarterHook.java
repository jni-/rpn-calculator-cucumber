package ca.ulaval.glo4002.rpn_calculator.uat.hooks;

import org.eclipse.jetty.server.Server;

import ca.ulaval.glo4002.rpn_calculator.interfaces.JettyServer;
import cucumber.api.java.Before;

public class JettyStarterHook {
    public static final int JETTY_TEST_PORT = 8181;

    private static boolean isFirstFeature = true;
    private Server server;

    @Before
    public void beforeAll() throws Exception {
        if (isFirstFeature) {
            Runtime.getRuntime().addShutdownHook(new JettyServerShutdown());
            startJettyServer();
            isFirstFeature = false;
        }
    }

    private void startJettyServer() throws Exception {
        server = new JettyServer().create(JETTY_TEST_PORT);
        server.start();
    }

    private class JettyServerShutdown extends Thread {
        public void run() {
            try {
                server.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
