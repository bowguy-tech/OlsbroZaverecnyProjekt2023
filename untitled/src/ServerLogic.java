import network.Server;

import java.io.IOException;

public class ServerLogic {
    public ServerLogic() {
        Server s = new Server();
        try {
            System.out.println("server is running");
            s.start(6666);

        } catch (IOException e) {
            System.out.println("");
        }
    }
}
