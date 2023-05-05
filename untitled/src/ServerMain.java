import network.*;

import java.io.IOException;

public class ServerMain {
    public static void main(String[] args) {
        Server s = new Server();
        try {
            s.start(6666);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
