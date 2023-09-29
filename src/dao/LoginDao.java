/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.security.MessageDigest;
import java.sql.*;
import model.Login;


/**
 *
 * @author djlap
 */
public class LoginDao {
    static String db_url="jdbc:mysql://localhost:3306/Pharmacy_Managment_system";
    static String db_user="root";
    static String db_pwd="";
    public Integer signIn(Login login){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(login.getPassword().getBytes());
        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection(db_url,db_user,db_pwd);
           PreparedStatement pst=con.prepareStatement("select username,password,u_role from users where username=? and password=?");
          pst.setString(1, login.getUsername());
          pst.setString(2, sb.toString());
           ResultSet rst= pst.executeQuery();
           int counter=0;
           while(rst.next()){
               if(rst.getString("u_role").equals("Admin")){
                  counter=1; 
               }else{
                   counter=2;
               }
               
           }
           con.close();
           return counter;
    }catch(Exception ex){
        ex.printStackTrace();
        return null;
    }
    }
    //////////////////////////////////////////////////////
    
}
