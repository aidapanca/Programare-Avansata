/**
 @author Pâncă Aida-Gabriela, A5
 **/
package compulsory;

import java.io.IOException;

public class ClientApplication {
    public static void main(String[] args) throws IOException {
        GameClient client = new GameClient();
        client.start();
    }
}
