package Repo;

import DTO.Anstalld;
import DTO.Behorighet;
import DTO.Medlem;
import DTO.Pass;
import DTO.Person;
import DTO.PersonalRegister;
import DTO.Sal;
import DTO.Traningstyp;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RepositoryAdmin {    
        
    private Connection con;
    private Properties p = new Properties();
    
    public RepositoryAdmin(){
        try {
            p.load(new FileInputStream("bestGymEver.properties"));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
  //---------------------------------------------------------------------------------------//
                                        //Medlemmar
  //---------------------------------------------------------------------------------------//   
    public List<Medlem> getAllMedlemmar() {
        List<Medlem> allaMedlemmar = new ArrayList<>();
        String query = "SELECT * FROM Medlem;";
 
        try (
         Connection con1 = DriverManager.getConnection(p.getProperty("connectionString"),
                         p.getProperty("name"),
                         p.getProperty("password"));
         Statement stmt = con1.createStatement();
         ResultSet rs = stmt.executeQuery(query)){

        while(rs.next()){
            int id = rs.getInt("id");
            allaMedlemmar.add( new Medlem(id, rs.getString("aNamn"), rs.getString("lösen"), getPersonByMedlemId(id)));
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    
        return allaMedlemmar;
    }
 
 //---------------------------------------------------------------------------------------//
    
    public Person getPersonByMedlemId(int id) {
        Person person = null;
        String query = "SELECT Person.id, Person.namn, Person.personnummer FROM Person \n" +
        "INNER JOIN Medlem ON  Person.id = Medlem.Person_id\n" +
        "WHERE Medlem.Id = ?;";
 
    try(Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
        p.getProperty("name"),
        p.getProperty("password"));
        PreparedStatement pStmt = con.prepareStatement(query);){
        pStmt.setString(1, id+"");
        ResultSet rs = pStmt.executeQuery();

        while(rs.next()){
            person = new Person(rs.getInt("id"), rs.getString("namn"), rs.getString("personnummer"));
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    
        return person;
    }
       
 //---------------------------------------------------------------------------------------//
                                    //Anstallda
 //---------------------------------------------------------------------------------------//
       
    public List<Anstalld> getAllAnstallda() {
        List<Anstalld> allaAnstallda = new ArrayList<>();
        String query = "SELECT * FROM Anställd";
 
        try (
         Connection con1 = DriverManager.getConnection(p.getProperty("connectionString"),
                         p.getProperty("name"),
                         p.getProperty("password"));
         Statement stmt = con1.createStatement();
         ResultSet rs = stmt.executeQuery(query);){

        while(rs.next()){
            int id = rs.getInt("id");
            allaAnstallda.add( new Anstalld(id, rs.getString("aNamn"), rs.getString("lösen"), 
                    getBehorighetByAnstalldId(id), getPRegisterByAnstalldId(id)));
        }
        }catch(Exception e){
            e.printStackTrace();
        }
      return allaAnstallda; 
    }
    
//---------------------------------------------------------------------------------------//
    
    public Behorighet getBehorighetByAnstalldId(int id){
        Behorighet behorighet = null;
        String query = "SELECT Behörighet.id, Behörighet.roll FROM Behörighet\n" +
        "INNER JOIN Anställd ON Anställd.Behörighet_id = Behörighet.id\n" +
        "WHERE Anställd.id = ?;";
 
    try(Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
        p.getProperty("name"),
        p.getProperty("password"));
        PreparedStatement pStmt = con.prepareStatement(query);){
        pStmt.setString(1, id+"");
        ResultSet rs = pStmt.executeQuery();

        while(rs.next()){
            behorighet = new Behorighet(rs.getInt("id"), rs.getString("namn"));
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    
        return behorighet;
    }
    
//---------------------------------------------------------------------------------------//
    
    public PersonalRegister getPRegisterByAnstalldId(int id){
        PersonalRegister pRegister = null;
        String query = "SELECT PersonalRegister.id, PersonalRegister.namn FROM PersonalRegister\n" +
        "INNER JOIN Anställd ON Anställd.PersonalRegister_id = PersonalRegister.id\n" +
        "WHERE Anställd.id = ?;";
 
    try(Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
        p.getProperty("name"),
        p.getProperty("password"));
        PreparedStatement pStmt = con.prepareStatement(query);){
        pStmt.setString(1, id+"");
        ResultSet rs = pStmt.executeQuery();

        while(rs.next()){
            pRegister = new PersonalRegister(rs.getInt("id"), rs.getString("namn"));
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    
        return pRegister;
    }
 
 //---------------------------------------------------------------------------------------//
                                        //Pass
 //---------------------------------------------------------------------------------------//
    
    public List<Pass> getAllPass(){
        List<Pass> allaPass = null;
        String query = "Select * from Pass";
 
        try (
         Connection con1 = DriverManager.getConnection(p.getProperty("connectionString"),
                         p.getProperty("name"),
                         p.getProperty("password"));
         Statement stmt = con1.createStatement();
         ResultSet rs = stmt.executeQuery(query);){

        while(rs.next()){
            int id = rs.getInt("id");
            allaPass.add(new Pass(id, rs.getBoolean("privat"), rs.getDate("datum"), rs.getInt("deltagande"), 
                    getTraningstypByTraningstypId(id), getSalBySalId(id), getAnstalldByAnstalldId(id)));
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    
        return allaPass;
    }
    
//---------------------------------------------------------------------------------------//

    public Traningstyp getTraningstypByTraningstypId(int id){
        Traningstyp traningstyp = null;
        String query = "SELECT TräningsTyp.id, TräningsTyp.namn FROM TräningsTyp\n" +
                        "WHERE TräningsTyp.id = ?;";
 
        try (
         Connection con1 = DriverManager.getConnection(p.getProperty("connectionString"),
                         p.getProperty("name"),
                         p.getProperty("password"));
         Statement stmt = con1.createStatement();
         ResultSet rs = stmt.executeQuery(query);){

        while(rs.next()){
            traningstyp = new Traningstyp(rs.getInt("id"), rs.getString("namn"));
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    
        return traningstyp;
    }
//---------------------------------------------------------------------------------------//
    public Sal getSalBySalId(int id){
        Sal sal = null;
        String query = "SELECT Sal.id, Sal.namn FROM Sal \n" +
                        "WHERE Sal.id = ?;";
 
        try (
         Connection con1 = DriverManager.getConnection(p.getProperty("connectionString"),
                         p.getProperty("name"),
                         p.getProperty("password"));
         Statement stmt = con1.createStatement();
         ResultSet rs = stmt.executeQuery(query);){

        while(rs.next()){
            sal = new Sal(rs.getInt("id"), rs.getString("namn"));
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    
        return sal;
    }
//---------------------------------------------------------------------------------------//
    public Anstalld getAnstalldByAnstalldId(int id){
        Anstalld anstalld = null;
        String query = "SELECT Anställd.id, Anställd.aNamn, Anställd.lösen, "
                    + "Anställd.Behörighet_id, Anställd.PersonalRegister_id FROM Anställd\n" +
                       "WHERE Anställd.id = 1;";
 
        try (
         Connection con1 = DriverManager.getConnection(p.getProperty("connectionString"),
                         p.getProperty("name"),
                         p.getProperty("password"));
         Statement stmt = con1.createStatement();
         ResultSet rs = stmt.executeQuery(query);){

        while(rs.next()){
            anstalld = new Anstalld(id, rs.getString("aNamn"), rs.getString("losen"), 
                    getBehorighetByAnstalldId(id), getPRegisterByAnstalldId(id));
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    
        return anstalld;
    }
}
