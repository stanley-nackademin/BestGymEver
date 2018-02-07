/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repo;

import DTO.Bokning;
import DTO.Medlem;
import DTO.Pass;
import DTO.Sal;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author claudiastenberg
 */
public class RepositoryReception {
          
    
    RepositoryAdmin ra = new RepositoryAdmin();
    Pass pass = new Pass();
    
      private Connection con;
    private Properties p = new Properties();
    
    public RepositoryReception(){
        try {
            p.load(new FileInputStream("/Users/marcuskarlberg/Desktop/Gruppuppgift/BestGymEver.properties"));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
    
    public Pass getPassIdByBokningsId(int id) throws SQLException {
        Pass pass = null;
        String query = "Select Pass_id from Bokning "
                + "inner join Pass on Pass.id = bokning.Pass_id"
                + "where bokning.Pass_id = ?";
        
        try(Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
        p.getProperty("name"),
        p.getProperty("password"));
        PreparedStatement pStmt = con.prepareStatement(query);){
        pStmt.setString(1, id+"");
        ResultSet rs = pStmt.executeQuery();
        
        while(rs.next()) {
            pass = new Pass(id, rs.getBoolean("privat"), rs.getDate("datum"), rs.getInt("deltagande"), 
                    ra.getTraningstypByPassId(id), ra.getSalByPassId(id), 
                    ra.getAnstalldByPassId(id), ra.getTidsLuckorByPassId(id));
        }
  
}       
    catch (SQLException ex){
            Logger.getLogger(RepositoryReception.class.getName()).log(Level.SEVERE, null, ex);
        }
    return pass;

    }
  public Medlem getMedlemIdByBokningsId(int id){
      Medlem medlem = null;
      String query = "";
  
      try(Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
        p.getProperty("name"),
        p.getProperty("password"));
        PreparedStatement pStmt = con.prepareStatement(query);){
        pStmt.setString(1, id+"");
        ResultSet rs = pStmt.executeQuery();
  
  
  
  }     catch (SQLException ex) {  
            Logger.getLogger(RepositoryReception.class.getName()).log(Level.SEVERE, null, ex);
        }  
    
    return null;

  }
}

//   public Sal getSalByPassId(int id) {
//        Sal sal = null;
//        String query = "select Sal.id, Sal.namn, Sal.platser from Sal "
//                + "inner join Pass on Pass.Sal_id = Sal.id where Pass.id = ?;";
//
//    try(Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
//        p.getProperty("name"),
//        p.getProperty("password"));
//        PreparedStatement pStmt = con.prepareStatement(query);){
//        pStmt.setString(1, id+"");
//        ResultSet rs = pStmt.executeQuery();
//
//        while(rs.next()){
//           sal = new Sal(rs.getInt("id"), rs.getString("namn"), rs.getInt("platser"));
//        }
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        
//        return sal;
//    }
//}
//    
//    public List <Bokning>getAllBokningar(int medlem_id, int pass_id){
//        List <Bokning> allabokning = new ArrayList<>(); 
//      
//        String query = "Select * from Bokningar";
//        
//        try (
//                  Connection con1 = DriverManager.getConnection(p.getProperty("connectionString"),
//                         p.getProperty("name"),
//                         p.getProperty("password"));
//         Statement stmt = con1.createStatement();
//         ResultSet rs = stmt.executeQuery(query);){
//
//        while (rs.next()){
//            int id = rs.getInt("id");
////            Pass passID = rs.getString("passID");
//            allabokning.add(new Bokning(id, ra.getAllMedlemmar(), pass.getId()));
//        }
//        
//        //IF medlem id and pass id finns 
//        //checka in person
//    
//    }   catch (SQLException ex) {
//            Logger.getLogger(RepositoryAdmin.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//}
//}
