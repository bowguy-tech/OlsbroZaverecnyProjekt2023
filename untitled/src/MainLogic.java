import java.util.Scanner;
public class MainLogic {
    public MainLogic() {
        Scanner sc = new Scanner(System.in);
        System.out.println("type \"host\" to host server or join to \"join\" game");
        while (true) {
            String input = sc.next();
            if (input.equals("host")) {
                ServerLogic sl = new ServerLogic();
            }
            if (input.equals("join")) {
                ClientLogic cl = new ClientLogic();
            }
        }
    }
}
