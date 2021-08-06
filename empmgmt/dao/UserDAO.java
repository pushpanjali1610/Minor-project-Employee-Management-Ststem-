/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.dao;

import empmgmt.dbutil.DBConnection;
import empmgmt.pojo.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDAO {
  
    public static boolean validateUser(User user)throws SQLException 
    {
     Connection con=DBConnection .getConnection();
      PreparedStatement ps=con.prepareStatement("Select * from users where userid=? and password=? and usertype=?");
       ps.setString(1, user.getUserId());
       ps.setString(2, user.getPassword());
       ps.setString(3, user.getUserType());
       ResultSet rs=ps.executeQuery();
       return rs.next(); 
    } 
    
    public static boolean RegisterStudent(User user)throws SQLException{
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("insert into users values(?,?,?)");
        ps.setString(1, user.getUserId());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getUserType());
        int i=ps.executeUpdate();
        return i==1;
    }
    public static boolean ChangePassowrd(User u)throws SQLException{
         PreparedStatement ps=DBConnection.getConnection().prepareStatement("update users set password=? where userid=?");
         ps.setString(1,u.getPassword());
         ps.setString(2,u.getUserId());
     //    ps.setString(3,u.getUserType());
         int i=ps.executeUpdate();
         return i==1;
    }  
}
