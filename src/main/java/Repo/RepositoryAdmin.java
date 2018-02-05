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
            p.load(new FileInputStream("/Users/marcuskarlberg/Desktop/Gruppuppgift/BestGymEver.properties"));
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
        String query = "TODO";
 
        try (
         Connection con1 = DriverManager.getConnection(p.getProperty("connectionString"),
                         p.getProperty("name"),
                         p.getProperty("password"));
         Statement stmt = con1.createStatement();
         ResultSet rs = stmt.executeQuery("TODO");){

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
        String query = "TODO";
 
        try (
         Connection con1 = DriverManager.getConnection(p.getProperty("connectionString"),
                         p.getProperty("name"),
                         p.getProperty("password"));
         Statement stmt = con1.createStatement();
         ResultSet rs = stmt.executeQuery("TODO");){

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
        String query = "TODO";
 
        try (
         Connection con1 = DriverManager.getConnection(p.getProperty("connectionString"),
                         p.getProperty("name"),
                         p.getProperty("password"));
         Statement stmt = con1.createStatement();
         ResultSet rs = stmt.executeQuery("TODO");){

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
        String query = "TODO";
 
        try (
         Connection con1 = DriverManager.getConnection(p.getProperty("connectionString"),
                         p.getProperty("name"),
                         p.getProperty("password"));
         Statement stmt = con1.createStatement();
         ResultSet rs = stmt.executeQuery("TODO");){

        while(rs.next()){
            behorighet = new Behorighet(rs.getInt("id"), rs.getString("namn"));
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    
        return behorighet;
    }
    
    public PersonalRegister getPRegisterByAnstalldId(int id){
        PersonalRegister pRegister = null;
        String query = "TODO";
 
        try (
         Connection con1 = DriverManager.getConnection(p.getProperty("connectionString"),
                         p.getProperty("name"),
                         p.getProperty("password"));
         Statement stmt = con1.createStatement();
         ResultSet rs = stmt.executeQuery("TODO");){

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
        String query = "TODO";
 
        try (
         Connection con1 = DriverManager.getConnection(p.getProperty("connectionString"),
                         p.getProperty("name"),
                         p.getProperty("password"));
         Statement stmt = con1.createStatement();
         ResultSet rs = stmt.executeQuery("TODO");){

        while(rs.next()){
            int id = rs.getInt("id");
            allaPass.add(new Pass(id, rs.getBoolean("private"), rs.getDate("datum"), rs.getInt("deltagande"), 
                    getTraningstypByTraningstypId(id), getSalBySalId(id), getAnstalldByAnstalldId(id)));
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    
        return allaPass;
    }
    
//---------------------------------------------------------------------------------------//

    public Traningstyp getTraningstypByTraningstypId(int id){
        Traningstyp tTraningstyp = null;
        String query = "TODO";
        
        try (
              Connection con1 = DriverManager.getConnection(p.getProperty("connectionString"),
                         p.getProperty("name"),
                         p.getProperty("password"));
         Statement stmt = con1.createStatement();
         ResultSet rs = stmt.executeQuery("TODO");){
             while (rs.next()){
                 tTraningstyp = new Traningstyp(rs.getInt("id"), rs.getString("namn"));
             }
            }catch(Exception e){
            e.printStackTrace();
            }
        
        return tTraningstyp;
        //TODO
    }
    public Sal getSalBySalId(int id){
         Sal sSal = null;
        String query = "TODO";
        
        try (
              Connection con1 = DriverManager.getConnection(p.getProperty("connectionString"),
                         p.getProperty("name"),
                         p.getProperty("password"));
         Statement stmt = con1.createStatement();
         ResultSet rs = stmt.executeQuery("TODO");){
             while (rs.next()){
                 sSal = new Sal(rs.getInt("id"), rs.getString("namn"));
             }
            }catch(Exception e){
            e.printStackTrace();
            }
        
        
        
        return null;
        //TODO
    }
    
    public Anstalld getAnstalldByAnstalldId(int id){
         Anstalld aAnstalld = null;
        String query = "TODO";
        
        try (
              Connection con1 = DriverManager.getConnection(p.getProperty("connectionString"),
                         p.getProperty("name"),
                         p.getProperty("password"));
         Statement stmt = con1.createStatement();
         ResultSet rs = stmt.executeQuery("TODO");){
             while (rs.next()){
                 aAnstalld = new Anstalld(rs.getInt("id"), rs.getNString("namn"), rs.getString("losen"),
                         getBehorighetByAnstalldId(id), getPRegisterByAnstalldId(id));}
            }catch(Exception e){
            e.printStackTrace();
            }
        
        
        
        return null;
        //TODO
    }

}
