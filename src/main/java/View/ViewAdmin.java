
package View;

import java.util.Scanner;

public class ViewAdmin {
    public void displayMenu(){
    Scanner sc = new Scanner(System.in);

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
    
}
