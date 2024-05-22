/**
 @author Pâncă Aida-Gabriela, A5
 **/
package compulsory;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GameClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8081;

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private BufferedReader consoleInput;

    public void start() throws IOException {
        consoleInput = new BufferedReader(new InputStreamReader(System.in));
        socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        System.out.println("Client connected to server");

        String inputLine;
        while ((inputLine = consoleInput.readLine()) != null) {
            out.println(inputLine);

            if (inputLine.equalsIgnoreCase("exit")) {
                break; //exit
            }
            System.out.println(in.readLine());//rasp de la server
        }

        System.out.println("Client disconnected from server");
        in.close();
        out.close();
        socket.close();
    }
}
