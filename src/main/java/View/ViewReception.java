/*
 *• Receptionisten behöver en checkin-applikation där medlemmar kan checkas in när de dyker
*   upp till ett visst pass
 */
package View;

import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author claudiastenberg
 */
public class ViewReception {
    	//variabler
	private int medlemsID;
	private int passID;
//        JFrame ram;
//        JLabel LmedlemsID;
//        JLabel LpassID;
//        JTextField TmedlemsID;
//        JTextField TpassID;
//        
//        public void GUI() {
//            
//            LmedlemsID = new JLabel("Vad är ditt medlemsID? ");
//            LpassID = new JLabel("Vad är ditt passID? ");
//            TmedlemsID = new JTextField();
//            TpassID = new JTextField();
//        }

public void checkIn () {

    
    
	Scanner sc = new Scanner(System.in);
	System.out.println("Vad är ditt medlemsID? ");
	medlemsID = sc.nextInt();
	System.out.println("Vad är ditt passID");
   	passID = sc.nextInt();

	//Här ska de komma en if som kollar om passet finns bokat. 
	//Med hjälp av vår SP. ChechIn 

}

    
    
    
}
