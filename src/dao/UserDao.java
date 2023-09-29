/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import java.security.*;
import model.User;

/**
 *
 * @author djlap
 */
public class UserDao {

    static String db_url = "jdbc:mysql://localhost:3306/Pharmacy_Managment_system";
    static String db_user = "root";
    static String db_pwd = "";

    public Integer userNameCheck(User user) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(db_url, db_user, db_pwd);
            PreparedStatement pst = con.prepareStatement("select username from users where username=?");
            pst.setString(1, user.getUsername());
            ResultSet rst = pst.executeQuery();
            int counter = 0;
            while (rst.next()) {
                counter += 1;
            }
            con.close();
            return counter;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Integer newUser(User user) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(user.getPassword().getBytes());
            byte[] digest = md.digest();
            StringBuffer sb = new StringBuffer();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(db_url, db_user, db_pwd);
            PreparedStatement pst = con.prepareStatement("INSERT INTO USERS(u_role,name,dob,phone,email,username,password,address) VALUES(?,?,?,?,?,?,?,?)");
            pst.setString(1, user.getUserRore());
            pst.setString(2, user.getName());
            pst.setString(3, user.getDob());
            pst.setString(4, user.getPhone());
            pst.setString(5, user.getEmail());
            pst.setString(6, user.getUsername());
            pst.setString(7, sb.toString());
            pst.setString(8, user.getAddress());
            int counter = pst.executeUpdate();
            if (counter >= 1) {
                return counter;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public ResultSet searchUser(User user) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(db_url, db_user, db_pwd);
            PreparedStatement pst = con.prepareStatement("SELECT * FROM USERS where username=?");
            pst.setString(1, user.getUsername());
            ResultSet rst = pst.executeQuery();

            return rst;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Integer updateUser(User user) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(db_url, db_user, db_pwd);
            PreparedStatement pst = con.prepareStatement("UPDATE USERS SET u_role=?,name=?,dob=?,phone=?,email=?,address=? WHERE username=?");
            pst.setString(1, user.getUserRore());
            pst.setString(2, user.getName());
            pst.setString(3, user.getDob());
            pst.setString(4, user.getPhone());
            pst.setString(5, user.getEmail());
            pst.setString(6, user.getAddress());
            pst.setString(7, user.getUsername());
            int counter = pst.executeUpdate();
            if (counter >= 1) {
                return counter;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet profileUpdate(User user) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(db_url, db_user, db_pwd);
            PreparedStatement pst = con.prepareStatement("SELECT * FROM USERS where username=?");
            pst.setString(1, user.getUsername());
            ResultSet rst = pst.executeQuery();
            return rst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Integer updateUserProfile(User user) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(db_url, db_user, db_pwd);
            PreparedStatement pst = con.prepareStatement("UPDATE USERS SET name=?,phone=?,email=?,address=? WHERE username=?");
            pst.setString(1, user.getName());
            pst.setString(2, user.getPhone());
            pst.setString(3, user.getEmail());
            pst.setString(4, user.getAddress());
            pst.setString(5, user.getUsername());
            int counter = pst.executeUpdate();
            return counter;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet displayUser() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(db_url, db_user, db_pwd);
            PreparedStatement pst = con.prepareStatement("select * from users");
            ResultSet rst = pst.executeQuery();
            return rst;
        } catch (Exception ex) {

            return null;
        }
    }

    public Integer saerchPassword(User user) {
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(db_url, db_user, db_pwd);
            PreparedStatement pst = con.prepareStatement("select * from users where username=?");
            pst.setString(1, user.getUsername());
            ResultSet rst = pst.executeQuery();
            int counter = 0;
            while (rst.next()) {
                counter = 1;
            }
            return counter;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    ///////////
    public Integer updatePassword(User user) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(user.getPassword().getBytes());
            byte[] digest = md.digest();
            StringBuffer sb = new StringBuffer();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(db_url, db_user, db_pwd);
            PreparedStatement pst = con.prepareStatement("update users set password=? where username=?");
            pst.setString(1, sb.toString());
            pst.setString(2, user.getUsername());
            int counter = pst.executeUpdate();

            return counter;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
