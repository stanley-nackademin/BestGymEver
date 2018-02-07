import DTO.Medlem;
import DTO.Pass;
import Repo.RepositoryAdmin;

import java.util.List;
import java.util.Scanner;

public class MemberMenu {
    private Repository repo;
    private RepositoryAdmin repoAdmin;
    Medlem member = null;

    public MemberMenu() {
        repo = new Repository();
        repoAdmin = new RepositoryAdmin();
    }

    public void mainMenu() {
        Scanner input = new Scanner(System.in);

        System.out.println("-- Medlemsinloggning --");
        System.out.print("Skriv in ditt användarnamn: ");
        String username = input.nextLine().trim();
        System.out.print("Skriv in ditt lösenord: ");
        String password = input.nextLine().trim();
        member = repo.getMemberByLogin(username, password);

        if (member != null) {
            System.out.println("Du är inloggad som " + member.getaNamn());
            workoutMenu();
        } else {
            System.out.println("Kunde ej logga in.\n");
        }
    }

    private void workoutMenu() {
        boolean loop = true;
        Scanner input = new Scanner(System.in);

        while (loop) {
            System.out.println();
            System.out.println("[1] Visa tillgängliga pass");
            System.out.println("[2] Visa mina bokade pass");
            System.out.println("[3] Boka ett pass");
            System.out.println("[4] Avboka ett pass");
            System.out.print("Skriv in ditt val: ");
            String workoutMenuChoice = input.nextLine().trim();

            switch (workoutMenuChoice) {
                case "1":
                    showAvailableWorkouts();
                    break;
                case "2":
                    System.out.println("2");
                    break;
                case "3":
                    System.out.println("3");
                    break;
                case "4":
                    System.out.println("4");
                    break;
                case "q":
                    loop = false;
                    break;
                default:
                    System.out.println("\nOgiltig val");
                    break;
            }
        }
    }

    private void showAvailableWorkouts() {
        List<Pass> passes = repoAdmin.getAllPass();
        passes.stream().forEach(System.out::println);
    }
}
