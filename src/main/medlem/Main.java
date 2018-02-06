import java.util.Scanner;

public class Main {

    private Controller controller = new Controller();

    Main() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("-- Medlemsinloggning --");
            System.out.print("Skriv in ditt användarnamn: ");
            String username = input.nextLine();
            System.out.print("Skriv in ditt lösenord: ");
            String password = input.nextLine();
            controller.userLogin(username, password);
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
    }
}
