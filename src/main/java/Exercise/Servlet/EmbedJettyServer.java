package Exercise.Servlet;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

public class EmbedJettyServer {
    private Server server;

    public void start() throws Exception {
        server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8000);
        server.setConnectors(new Connector[] {connector});

        ServletHandler servletHandler = new ServletHandler();
        server.setHandler(servletHandler);

        servletHandler.addServletWithMapping(HelloServlet.class, "/hello");

        server.start();
    }

    public static void main(String[] args) throws Exception {
        EmbedJettyServer embedJettyServer = new EmbedJettyServer();
        embedJettyServer.start();
    }
}
