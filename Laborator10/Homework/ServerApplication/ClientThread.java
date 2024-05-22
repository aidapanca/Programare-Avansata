/**
 @author Pâncă Aida-Gabriela, A5
 **/
package compulsory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private final Socket clientSocket;
    private final GameServer server;
    private PrintWriter out;
    private BufferedReader in;

    public ClientThread(Socket clientSocket, GameServer server) {
        this.clientSocket = clientSocket;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received input: " + inputLine);
                String[] command = inputLine.split(" ");
                switch (command[0]) {
                    case "create":
                        server.createGame(command[1], Long.parseLong(command[2]));
                        out.println("Game created with ID: " + command[1]);
                        break;
                    case "join":
                        Game game = server.getGame(command[1]);
                        if (game != null) {
                            game.addPlayer(new Player(command[2], game.getTimeLimit()));
                            out.println("Player " + command[2] + " joined game " + command[1]);
                        } else {
                            out.println("Game not found");
                        }
                        break;
                    case "move":
                        Game moveGame = server.getGame(command[1]);
                        if (moveGame != null) {
                            String result = moveGame.makeMove(command[2], new Move(Integer.parseInt(command[3]), Integer.parseInt(command[4])));
                            out.println("Move made by " + command[2] + ": " + result);
                        } else {
                            out.println("Game not found");
                        }
                        break;
                    case "place":
                        Game placeGame = server.getGame(command[1]);
                        if (placeGame != null) {
                            placeGame.placeShips(command[2], Integer.parseInt(command[3]), Integer.parseInt(command[4]), Integer.parseInt(command[5]), Boolean.parseBoolean(command[6]));
                            out.println("Ship placed by " + command[2]);
                        } else {
                            out.println("Game not found");
                        }
                        break;
                    case "stop":
                        out.println("Stopping server...");
                        server.stop();
                        break;
                    default:
                        out.println("Unknown command: " + inputLine);
                        break;
                }
            }
            System.out.println("Client disconnected");
        } catch (IOException e) {
            System.out.println("Error handling client input: " + e);
        } finally {
            try {
                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                System.out.println("Error closing client socket: " + e);
            }
        }
    }
}
