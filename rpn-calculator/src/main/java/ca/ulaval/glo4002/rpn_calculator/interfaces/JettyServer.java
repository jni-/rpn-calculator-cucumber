package ca.ulaval.glo4002.rpn_calculator.interfaces;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class JettyServer {

    private static final String REST_PACKAGE = "ca.ulaval.glo4002.rpn_calculator.interfaces.rest";

    public Server create(int httpPort) throws Exception {
        Server server = new Server(httpPort);
        ServletContextHandler servletContextHandler = new ServletContextHandler(server, "/");
        configureRestInterface(servletContextHandler);
        return server;
    }

    private void configureRestInterface(ServletContextHandler servletContextHandler) {
        ServletContainer container = new ServletContainer(new ResourceConfig().packages(REST_PACKAGE).register(JacksonFeature.class));
        ServletHolder jerseyServletHolder = new ServletHolder(container);
        servletContextHandler.addServlet(jerseyServletHolder, "/*");
    }
}
