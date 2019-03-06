import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.logging.Logger;

public class LoginServer {

    private Logger logger = Logger.getLogger(LoginServer.class.getName());
    private static int port = 23333;
    private Server server;
    public LoginServer(ServerBuilder<?> serverBuilder){
        server = serverBuilder.addService(new LoginServiceImplBaseImpl()).build();

    }

    private void start() throws IOException {
        server.start();
        logger.info("Server has started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {

                LoginServer.this.stop();

            }
        });
    }

    private void stop() {

        if(server != null)
            server.shutdown();

    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        LoginServer loginServer;
        loginServer = new LoginServer(ServerBuilder.forPort(port));
        loginServer.start();
        loginServer.blockUntilShutdown();

    }
}

