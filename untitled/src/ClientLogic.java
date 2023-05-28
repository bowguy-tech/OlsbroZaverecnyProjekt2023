import network.Client;

import java.io.IOException;
import java.util.Scanner;

public class ClientLogic {
    public ClientLogic() {
        Scanner cs = new Scanner(System.in);
        String name;
        while(true) {
            System.out.println("please enter name:");
            name = cs.next();
            if (2 < name.length() && name.length() < 20) {
                break;
            }
            System.out.println("invalid name");
        }

        Client c = new Client();
        c.setName(name);

        try {
            c.connect("127.0.0.1", 6666);
            while(true){
                if (c.getMessage().equals("/d")) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        cs.close();
    }
}
