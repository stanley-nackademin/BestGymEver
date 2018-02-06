
package View;

import DTO.Traningstyp;
import Repo.RepositoryAdmin;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewAdmin {
   Scanner sc;
   RepositoryAdmin r = new RepositoryAdmin();
     
   //Personal
    private String personalNamn;
    private String aNamnPersonal;
    private String losenPersonal;

    //Medlem
    private String namn;
    private String losen;
    private String aNamn;
    private String pNummer;
    
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
   
    public void displayMenu(){   
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
        System.out.println("Ange om passet ska vara privat:");
        System.out.println("(1)JA \n(0)NEJ");
        privat = sc.nextInt();
        
        System.out.println("Ange Träningstyp");
        traningar = r.getAllTraningstyper();
        traningar.stream().forEach(t -> t.print());
        traningstyp = sc.nextLine();
        
        System.out.println("Ange datum: ÅÅÅÅ-MM-DD");
        datum = sc.nextLine();
        
        System.out.println("Hur långt ska passet vara:");
        System.out.println("(1)30min \n(2)60min \n(90)min");
        varaktighet = sc.nextInt();
        
        System.out.println("Ange sal:");
        //Visa lista på tillängliga saler
        //visa lista på tidsluckor till salen
        salId = sc.nextLine();
        System.out.println("Ange starttid: HH:MM:SS"); 
        starttid = sc.nextLine();
        
        System.out.println("Ange anställd: ");
        //Visa lista på tillgängliga anställda
        anstalld = sc.nextLine();
        
        //kalla på stored procedure AddPass
    }
    
    public void AddMedlemView(){
        
        System.out.println("Ange Namn: ");
        namn = sc.nextLine();
        System.out.println("Ange personnummer");
        pNummer = sc.nextLine();
        
        System.out.println("Ange Användarnamn: ");
        aNamn = sc.nextLine();
        //TODO - check if Användarnamn redan finns; bör ligga i loop med frågan
        System.out.println("Ange lösenord");
        losen = sc.nextLine();
        
        //Kalla på Stored procedure Medlem
        //Kalla på Stored procedure Person
        
    }
    public void AddAnstalldView(){
        System.out.println("Ange namn: ");
        personalNamn = sc.nextLine();
        System.out.println("Ange användarnamn: ");
        aNamnPersonal = sc.nextLine();
        //TODO - check if Användarnamn redan finns; bör ligga i loop med frågan
        System.out.println("Ange lösenord: ");
        losenPersonal = sc.nextLine();
        
        //Kalla på SP Add PersonalRegister
        //Kalla på SP Add Anställd
    }
    
}
