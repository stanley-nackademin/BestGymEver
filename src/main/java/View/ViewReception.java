package View;

import Controller.ControllerReception;
import Repo.RepositoryReception;

import java.sql.SQLException;
import java.util.Scanner;
import java.sql.*;

public class ViewReception {

        Scanner sc = new Scanner(System.in);
        RepositoryReception rr = new RepositoryReception();
        ControllerReception cr = new ControllerReception();

        //Medlem
        private int medlemsId;

        //Pass
        private int passId;


        public void displayReceptionMenu() throws SQLException {
            System.out.println("Ange vilket medlemsID du har: ");
            medlemsId = sc.nextInt();
            System.out.println("Ange vilket passID du bokat: ");
            passId = sc.nextInt();


            while(cr.MatchMedlemId(medlemsId) && cr.MatchPassId(passId)){ //Om det finns ett bokat pass
                System.out.println("Du har ett bokat pass");
                medlemsId = sc.nextInt();
                passId = sc.nextInt();
                //TODO kalla på SP bokning
            }
            System.out.println("Du har inget bokat pass!");
            //TODO Kalla på Stored procedure Bokning


            System.out.println("Du är nu inbokad");

        }
        public static void main(String[] args) throws SQLException, ClassNotFoundException {
            Class.forName("com.mysql.jdbc.Driver");
            ViewReception kör = new ViewReception();
            kör.displayReceptionMenu();
        }
    }



