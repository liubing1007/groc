package java;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.logging.Logger;

public class JwtServer {

    private Logger logger = Logger.getLogger(JwtServer.class.getName());
    private static int port = 23334;
    private Server server;
    public JwtServer(ServerBuilder<?> serverBuilder){
        server = serverBuilder.addService(new JwtServiceImplBaseImpl()).build();

    }

    private void start() throws IOException {
        server.start();
        logger.info("Server has started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {

                JwtServer.this.stop();

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
        JwtServer jwtServer;
        jwtServer = new JwtServer(ServerBuilder.forPort(port));
        jwtServer.start();
        jwtServer.blockUntilShutdown();

    }
}

