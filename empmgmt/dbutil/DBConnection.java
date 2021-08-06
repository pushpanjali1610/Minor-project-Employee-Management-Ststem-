/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.dbutil;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class DBConnection {
   private static Connection con;
   static
   {
    try
       {
            Class.forName("oracle.jdbc.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@//LAPTOP-9TT9F16B:1521/xe", "project", "javase");
          //  ps=con.prepareStatement("insert into employee values(?,?,?)");
            JOptionPane.showMessageDialog(null,"Connected succesfully to the DB");
           }
       catch(Exception e)
       {
       JOptionPane.showMessageDialog(null, "Cannot connected to the DB");
       e.printStackTrace();
       System.exit(1);
       }
   }
   public static Connection getConnection()
   {
   return con;
   }
   public static void closeConnection()
   {
   try
       {
        con.close();
         JOptionPane.showMessageDialog(null, "Disconnected Successfully to the DB");
       }
    catch(Exception e)
       {
       JOptionPane.showMessageDialog(null, "Cannot connected to the DB");
       e.printStackTrace();
       }
   }

}
