/**
 @author Pâncă Aida-Gabriela, A5
 **/
package compulsory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    private static final int PORT = 8081;

    private ServerSocket serverSocket;

    public GameServer() throws IOException {
        serverSocket = new ServerSocket(PORT);
        System.out.println("Server open to port " + PORT);

        while (true) {
            System.out.println("We are waiting for customers to connect...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connected client");

            ClientThread clientThread = new ClientThread(clientSocket, this);
            clientThread.start();
        }
    }

    public void stop() throws IOException {
        System.out.println("Server is now stopping...");
        serverSocket.close();
        System.exit(0);
    }
}
