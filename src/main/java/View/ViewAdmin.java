
package View;

import Controller.ControllerAdmin;
import DTO.Medlem;
import DTO.Pass;
import DTO.Sal;
import DTO.Tidslucka;
import DTO.Traningstyp;
import Repo.RepositoryAdmin;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ViewAdmin {
   Scanner sc;
   RepositoryAdmin r = new RepositoryAdmin();
   ControllerAdmin c = new ControllerAdmin();
     
   //Personal
    private String personalNamn;
    private String aNamnPersonal;
    private String losenPersonal;
    private int behorighet;

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
    private List<Sal> allaSaler;
    private List<Pass> allaPass;

    List<Traningstyp> traningar = new ArrayList<>();
    
    public ViewAdmin(){
        sc = new Scanner(System.in);
    }
//----------------------------------------------------------------------------//     
    public void displayAdminMenu() throws SQLException{   
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
              AddPassView();
              break;
            case 2:
              AddMedlemView();
              break;
            case 3:
              AddAnstalldView();
            case 4:
              break Menu;
            default:
              System.out.println("Ogtiltigt val.");
              break;
            }
        }
    }
//----------------------------------------------------------------------------//      
    public void AddPassView(){
        System.out.println("Ange om passet ska vara privat:");
        System.out.println("(1)JA \n(0)NEJ");
        privat = sc.nextInt();
        
        System.out.println("Ange Träningstyp");
        traningar = r.getAllTraningstyper();
        traningar.forEach(t -> t.print());
        sc.nextLine();
        traningstyp = sc.nextLine();
        
        System.out.println("Träningstypen vald: " + traningstyp);
        
        System.out.println("\nHur långt ska passet vara:");
        System.out.println("(1)30min \n(2)60min \n(3)90min");
        varaktighet = sc.nextInt();
        
        System.out.println("\nAnge datum för passet: ÅÅÅÅ-MM-DD");
        sc.nextLine();
        datum = sc.nextLine();
        
         System.out.println("Du valde datumet: " + datum);
        
        System.out.println("\nAnge sal:");
        allaSaler = r.getAllSal();
        allaSaler.forEach(s -> s.print());
        salId = sc.nextLine();
        
        System.out.println("Du valde salen: " + salId);
        
        //Visar tagna tidsluckor i den specefika salen på det specefika datumet
        System.out.println("\n*** Upptagna tider i sal:" + salId + " Datum: " + datum + " ***");
        List<Tidslucka> tidsluckor = new ArrayList<>();
        tidsluckor = c.getTidsluckorBySalIdDate(datum, salId);
        tidsluckor.forEach(t -> t.print());
        
        System.out.println("Ange starttid: HH:MM:SS"); 
        starttid = sc.nextLine();
        
        System.out.println("Du valde startiden: " + starttid);
        
        while(c.checkTimeClash(datum, starttid, varaktighet, salId)){ 
            System.out.println("Tiden är upptagen...Försök med en annan tid");
            starttid = sc.nextLine();
        }
        System.out.println("*** Tiden accepterad ***");
        
        System.out.println("Personal:");
        r.getAllAnstallda().forEach(a -> a.getpRegister().print());
        
        System.out.println("\nVälj personal till Passet: NAMN");
        personalNamn = sc.nextLine();

        while(c.checkavailability(personalNamn, datum, starttid, varaktighet)){
            System.out.println("Den anställde är upptagen..Försök igen");
            personalNamn = sc.nextLine();
        }
        System.out.println("Du valde Anställde: " + personalNamn);
        
        String verdict = null;
        verdict = r.addPass(c.getTraningsId(traningstyp), privat, c.getSalId(salId), c.getAnstaldId(personalNamn), datum, starttid, c.getStoptid(starttid, varaktighet));
        System.out.println(verdict);
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
        
        r.addMedlem(namn, pNummer, aNamn, losen);
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
        
        System.out.println("Ange behörighet");
        System.out.println("(1) - Admin \n(2) - PT \n(3) - Receptionist\n");
        behorighet = sc.nextInt();
        
        r.addAnstalld(personalNamn, aNamnPersonal, losenPersonal, behorighet);
        System.out.println("Du är nu Anställd!");
    }
//----------------------------------------------------------------------------//  
}
