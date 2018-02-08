package Repo;

import DTO.Anstalld;
import DTO.Medlem;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

public class PTapplication {

    private Connection con;
    private Properties p = new Properties();
    private RepositoryAdmin rp = new RepositoryAdmin();

    public PTapplication() {

        setupConnection();
        printMedlemmar();
        viewer();

    }

    private void viewer() {

        List<Anstalld> list = rp.getAllAnstallda();
        boolean inloggad = false;
        Anstalld user = null;

        String aNamn = JOptionPane.showInputDialog("Användarnamn: ");
        String pw = JOptionPane.showInputDialog("Lösen: ");

        for(Anstalld a : list){
            if (aNamn.equalsIgnoreCase(a.getaNamn()) && pw.equalsIgnoreCase(a.getLosen())) {
                inloggad = true;
                user = a;
                break;
                }
            }
            if(!inloggad){
                JOptionPane.showMessageDialog(null, "Who da fakk r u", "gtfo", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }

            Object[] options = {"Se notiser", "Se pass", "Skriv notis"};
            int i = JOptionPane.showOptionDialog(null, "Vad du göra", "Inloggad",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
            switch(i){
                case 0 :
                    caseSeeNotis();
                    break;
                case 1 :
                    caseSeePass();
                    break;
                case 2 :
                    caseInsert(user);
            }

    }

    private void caseInsert(Anstalld user) {

        int aID = user.getId();
        printMedlemmar();
        int mID = Integer.parseInt(JOptionPane.showInputDialog(null, "Vem insert (id)"));
        String kommentar = JOptionPane.showInputDialog("Skriv kommentar");
        insertNotis(kommentar, aID, mID);
        System.exit(0);
    }

    private void caseSeePass() {

        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Vem du se (id)"));
        printMedlemsPass(id);
        System.exit(0);
    }

    private void caseSeeNotis() {

        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Vem du se (id)"));
        printNotiser(id);
        System.exit(0);
    }

    private void setupConnection() {

        try {
            p.load(new FileInputStream("bestGymEver.properties"));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    protected void printMedlemmar() {

        List<Medlem> m = rp.getAllMedlemmar();
        m.forEach(System.out::println);
    }

    private void printMedlemsPass(int memberID){

        try (
                Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                        p.getProperty("name"),
                        p.getProperty("password"));
            PreparedStatement stmt = con.prepareStatement(
"select Medlem.id, Person.namn, Person.personnummer, TräningsTyp.namn, Pass.Datum from Person " +
"join Medlem on Medlem.Person_id = Person.id " +
"join Bokning on Medlem.id = Bokning.Medlem_id " +
"join Pass on Bokning.Pass_id = Pass_id " +
"join TräningsTyp on Pass.TräningsTyp_id=TräningsTyp.id where Medlem.id = ? group by Pass.id;"))
                 {
            stmt.setInt(1, memberID);
            ResultSet rs = stmt.executeQuery();
            String txt = "";
            try {

            rs.next();
            txt+= rs.getInt
                    ("Medlem.id")+ " "+ rs.getString
                    ("Person.namn")+ " "+ rs.getString
                    ("Person.personnummer")+ "\n";
            rs.previous();
            while (rs.next()) {

                LocalDate nu = LocalDate.now();
                String datum = rs.getString("Pass.Datum");
                LocalDate passTid = LocalDate.parse(datum);

                if(nu.isAfter(passTid))
                txt+=  rs.getString("TräningsTyp.namn")+" "+ datum +"\n";
                }
            }
            catch (SQLException e){
                     System.out.println("inga pass på medlem");
                 }

            System.out.println(txt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void printNotiser(int memberID){

        try (
                Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                        p.getProperty("name"),
                        p.getProperty("password"));
                PreparedStatement stmt = con.prepareStatement(
"select Medlem.id, Person.namn, Person.personnummer, Notis.Kommentar from Person " +
        "right join Medlem on Medlem.Person_id = Person.id " +
        "right join Notis on Notis.Medlem_id = Medlem.id where Notis.Medlem_id= ? " +
        "group by Notis.id;")) {
            String txt = "";
            stmt.setInt(1, memberID);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            try {
            txt+= rs.getInt
                    ("Medlem.id")+ " "+ rs.getString
                    ("Person.namn")+ " "+ rs.getString
                    ("Person.personnummer")+ "\n";
            rs.previous();
            while (rs.next()) {

                txt+=  rs.getString("Notis.Kommentar")+ "\n";
            }

            }
            catch (SQLException e){
                System.out.println("inga kommentarer på medlem");
            }

            System.out.println(txt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertNotis(String comment, int employeID, int memberID){

        try (
                Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                        p.getProperty("name"),
                        p.getProperty("password"));
                CallableStatement stmnt = con.prepareCall("call setComment(?,?,?)")
        ){
            stmnt.setString(1, comment);
            stmnt.setInt(2, employeID);
            stmnt.setInt(3, memberID);
            stmnt.execute();
            System.out.println("Gick igenom...");
        } catch (SQLException e) { e.printStackTrace(); }

    }

    public static void main(String[] args) {
        new PTapplication();
    }
}
