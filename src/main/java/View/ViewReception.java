/*
 *• Receptionisten behöver en checkin-applikation där medlemmar kan checkas in när de dyker
*   upp till ett visst pass
 */
package View;

import java.util.Scanner;

/**
 *
 * @author claudiastenberg
 */
public class ViewReception {
    	//variabler
	private int medlemsID;
	private int passID;


public void checkIn () {

	//ska ge en meny med en ruta där man kan fylla i sitt medlemsID samt sitt passID 
	Scanner sc = new Scanner(System.in);
	System.out.println("Vad är ditt medlemsID? ");
	medlemsID = sc.nextInt();
	System.out.println("Vad är ditt passID");
	passID = sc.nextInt();

	//Här ska de komma en if som kollar om passet finns bokat. 
	//Med hjälp av vår SP. ChechIn 

}

    
    
    
}
