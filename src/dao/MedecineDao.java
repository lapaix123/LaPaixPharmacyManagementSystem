/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import model.Medecine;

/**
 *
 * @author djlap
 */
public class MedecineDao {

    static String db_url = "jdbc:mysql://localhost:3306/Pharmacy_Managment_system";
    static String db_user = "root";
    static String db_pwd = "";

    public Integer newMed(Medecine med) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(db_url, db_user, db_pwd);
            PreparedStatement pst = con.prepareStatement("INSERT INTO medecine(medId,name,company,quantity,price,manDate,expDate) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, med.getId());
            pst.setString(2, med.getNames());
            pst.setString(3, med.getCompany());
            pst.setString(4, med.getQuantity());
            pst.setString(5, med.getPrice());
            pst.setString(6, med.getMandate());
            pst.setString(7, med.getExpdate());
            int counter = pst.executeUpdate();
            if (counter >= 1) {
                return counter;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }}
    ////////////////////////////////////////////////////
    public ResultSet displayMedecine() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(db_url, db_user, db_pwd);
            PreparedStatement pst = con.prepareStatement("select * from medecine");
            ResultSet rst = pst.executeQuery();
            return rst;
        } catch (Exception ex) {
            
            return null;
        }
    }
    //////////
      public ResultSet searchMedecine(Medecine med) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(db_url, db_user, db_pwd);
            PreparedStatement pst = con.prepareStatement("SELECT * FROM medecine where medId=?");
            pst.setString(1, med.getId());
            ResultSet rst = pst.executeQuery();

            return rst;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
      ////////
      public Integer updateMedecine(Medecine med){
          try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(db_url, db_user, db_pwd);
            PreparedStatement pst = con.prepareStatement("update medecine set name=?,company=?,quantity=?,price=?,manDate=?,expdate=? where medId=?");
            pst.setString(1, med.getNames());
            pst.setString(2, med.getCompany());
            pst.setString(3, med.getQuantity());
            pst.setString(4, med.getPrice());           
            pst.setString(5, med.getMandate());
            pst.setString(6, med.getExpdate());
            pst.setString(7, med.getId());
            int counter= pst.executeUpdate();
              return counter;
          } catch (Exception e) {
              e.printStackTrace();
              return null;
          }
  
      }
    }
