package Repo;

import DTO.Medlem;
import DTO.Person;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class PTapplication {

    private Connection con;
    private Properties p = new Properties();
    private RepositoryAdmin rp = new RepositoryAdmin();

    public PTapplication() {

        setupConnection();
        printMedlemmar();
        /*printNotiser(1);
        printMedlemsPass(1);*/
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

    private void printMedlemsPass(int id){

        try (
                Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                        p.getProperty("name"),
                        p.getProperty("password"));
                Statement stmt = con.createStatement()) {
            String txt = "";
            ResultSet rs = stmt.executeQuery("select Medlem.id, Person.namn, Person.personnummer, TräningsTyp.namn, Pass.Datum from Person " +
                    "join Medlem on Medlem.Person_id = Person.id " +
                            "join Bokning on Medlem.id = Bokning.Medlem_id " +
                            "join Pass on Bokning.Pass_id = Pass_id " +
                            "join TräningsTyp on Pass.TräningsTyp_id=TräningsTyp.id group by Pass.id;");
            rs.next();
            txt+= rs.getInt
                    ("Medlem.id")+ " "+ rs.getString
                    ("Person.namn")+ " "+ rs.getString
                    ("Person.personnummer")+ "\n";
            rs.previous();
            while (rs.next()) {

                txt+=  rs.getString("TräningsTyp.namn")+" "+ rs.getString("Pass.Datum")+"\n";
            }

            System.out.println(txt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void printNotiser(int id){

        try (
                Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                        p.getProperty("name"),
                        p.getProperty("password"));
                PreparedStatement stmt = con.prepareStatement(
"select Medlem.id, Person.namn, Person.personnummer, Notis.Kommentar from Person join Medlem on Medlem.Person_id = Person.id join Notis on Notis.Medlem_id = Medlem.id group by Notis.id having ?;")) {
            String txt = "";
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            txt+= rs.getInt
                    ("Medlem.id")+ " "+ rs.getString
                    ("Person.namn")+ " "+ rs.getString
                    ("Person.personnummer")+ "\n";
            rs.previous();
            while (rs.next()) {

                txt+=  rs.getString("Notis.Kommentar")+ "\n";
            }

            System.out.println(txt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new PTapplication();
    }
}
