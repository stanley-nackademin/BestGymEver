
package View;

<<<<<<< Updated upstream
import DTO.IncheckedPeople;
import Repo.RepositoryAdmin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class ViewAdmin {
    public void displayMenu(){
    Scanner sc = new Scanner(System.in);

=======
import Controller.ControllerAdmin;
import DTO.Medlem;
import DTO.Traningstyp;
import Repo.RepositoryAdmin;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewAdmin {
   Scanner sc;
   RepositoryAdmin r = new RepositoryAdmin();
   ControllerAdmin c = new ControllerAdmin();
     
   //Personal
    private String personalNamn;
    private String aNamnPersonal;
    private String losenPersonal;

    //Medlem
    private String namn;
    private String losen;
    private String aNamn;
    private String pNummer;
    private List<Medlem> medlemmar = new ArrayList<>();
    
    //Pass
    private int privat;
    private String datum;
    private String traningstyp;
    private String salId;
    private String anstalld;
    private int varaktighet;
    private String starttid;

    List<Traningstyp> traningar = new ArrayList<>();
    
    public ViewAdmin(){
        sc = new Scanner(System.in);
    }
//----------------------------------------------------------------------------//     
    public void displayAdminMenu(){
        Menu: while(true) { //label. hoppar direct ut från lopen.
            System.out.println(
                "\n*** Meny: ***\n" +
                "  1) Lägg Till Pass\n" +
                "  2) Lägg Till Medlem\n" +
                "  3) Lägg Till Anställd\n "
            );
            int val = sc.nextInt();
            sc.nextLine();

            switch (val) {
            case 1:
              ;
              break;
            case 2:
              ;
              break;
            case 3:
              ;
            case 4:
              break Menu;
            default:
              System.out.println("Ogtiltigt val.");
              break;
            }
        }
    }
    
    public void AddPassView(){
        
    }
    public void AddMedlemView(){
        
    }
    public void AddAnstalldView(){
        
    }
    
//----------------------------------------------------------------------------//
    public void AddPassView(){
        System.out.println("Ange om passet ska vara privat:");
        System.out.println("(1)JA \n(0)NEJ");
        privat = sc.nextInt();
        
        System.out.println("Ange Träningstyp");
        traningar = r.getAllTraningstyper();
        traningar.forEach(t -> t.print());
        sc.next();
        traningstyp = sc.nextLine();
        
        System.out.println("Ange datum: ÅÅÅÅ-MM-DD");
        datum = sc.nextLine();
        
        System.out.println("Hur långt ska passet vara:");
        System.out.println("(1)30min \n(2)60min \n(3)90min");
        varaktighet = sc.nextInt();
        
        System.out.println("Ange sal:");
        //Visa lista på saler
        //visa lista på tidsluckor till salen
        salId = sc.nextLine();
        System.out.println("Ange starttid: HH:MM:SS"); 
        starttid = sc.nextLine();
        
        System.out.println("Ange anställd: NAMN");
        //Visa lista på tillgängliga anställda
        anstalld = sc.nextLine();
        
        //kalla på stored procedure AddPass
    }
//----------------------------------------------------------------------------//    
    public void AddMedlemView() throws SQLException{
        
        System.out.println("Ange Namn: ");
        namn = sc.nextLine();
        System.out.println("Ange personnummer");
        pNummer = sc.nextLine();
        
        System.out.println("Ange Användarnamn: ");
        aNamn = sc.nextLine();
        while(c.matchUsername(aNamn)){ //kollar om användarnamnet redan används bland medlemmarna
            System.out.println("Användarnamnet används..Försök igen: ");
            aNamn = sc.nextLine();
        }
        System.out.println("Godkänt användarnamn");

        System.out.println("Ange lösenord");
        losen = sc.nextLine();
        
        //TODO Kalla på Stored procedure Medlem
        System.out.println("Du är nu en medlem!");
    }
//----------------------------------------------------------------------------//    
    public void AddAnstalldView() throws SQLException{
        System.out.println("Ange namn: ");
        personalNamn = sc.nextLine();
        
        System.out.println("Ange användarnamn: ");
        aNamnPersonal = sc.nextLine();
        while(c.matchAnstalldUsername(aNamnPersonal)){ //kollar om användarnamnet redan används bland de Anställda
            System.out.println("Användarnamnet används..Försök igen: ");
            aNamnPersonal = sc.nextLine();
        }
        System.out.println("Godkänt användarnamn");
        
        System.out.println("Ange lösenord: ");
        losenPersonal = sc.nextLine();
        
        //TODO Kalla på SP Add Anställd
        System.out.println("Du är nu Anställd!");
    }
//----------------------------------------------------------------------------//
}
public static class RepositoryAnstalld {

    Properties p = new Properties();
    RepositoryAdmin ra = new RepositoryAdmin();

    public RepositoryAnstalld() {
        try {
            p.load(new FileInputStream("bestGymEver.properties"));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    protected List<IncheckedPeople> getAllInchecks(){

        List<IncheckedPeople> temp = new ArrayList<>();

        try (
                Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                        p.getProperty("name"),
                        p.getProperty("password"));
                Statement stnmt = con.createStatement();
                ResultSet rs = stnmt.executeQuery("select * from IncheckedPeople")
        ){

            while(rs.next()){



            }


        }
         catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }

}