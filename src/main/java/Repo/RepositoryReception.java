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
 
    public Pass getPassIdByBokningsId(int id){
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
      String query = "Select Medlem_id from Bokning inner join Medlem on Medlem.id = bokning.Medlem_id"
              + "where bokning.Medlem_is = ?";
  
      try(Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
        p.getProperty("name"),
        p.getProperty("password"));
        PreparedStatement pStmt = con.prepareStatement(query);){
        pStmt.setString(1, id+"");
        ResultSet rs = pStmt.executeQuery();
        
        
        while (rs.next()) {
            medlem = new Medlem(id, rs.getString("aNamn"), rs.getString("lösen"), ra.getPersonByMedlemId(id));
        
        }
  
  
  }     catch (SQLException ex) {  
            Logger.getLogger(RepositoryReception.class.getName()).log(Level.SEVERE, null, ex);
        }  
    
    return medlem;

  }
}
