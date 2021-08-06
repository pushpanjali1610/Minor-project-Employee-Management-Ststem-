/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.dao;

import empmgmt.dbutil.DBConnection;
import empmgmt.pojo.Emp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author VIDIT
 */
public class EmpDAO {
    public static boolean addEmployee(Emp e)throws SQLException
    {
        Connection con=DBConnection.getConnection();
         PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?)");
         ps.setInt(1,e.getEmpNo());
         ps.setString(2,e.getEname());
         ps.setDouble(3,e.getEmpSal());
         
         int result = ps.executeUpdate();
         if(result==1)
             return true;
         return false;
   }
    
    public  static Emp findEmployeeById(int empNo)throws SQLException
    {
        Connection con=DBConnection.getConnection();
           PreparedStatement ps=con.prepareStatement("Select * from employee where empid= ?");
           ps.setInt(1, empNo);
           ResultSet rs=ps.executeQuery();
           Emp e=null;
           if(rs.next())
           {
           e=new Emp();
           e.setEmpNo(rs.getInt(1));
           e.setEname(rs.getString(2));
           e.setEmpSal(rs.getDouble(3));
         
           }
            return e;
    }
    
    public static ArrayList<Emp> getAllEmployee()throws SQLException
    {
         Connection con=DBConnection.getConnection();
            Statement st=con.createStatement();
            ArrayList<Emp> empList=new ArrayList<>();
            
              ResultSet rs=st.executeQuery("Select * from employee");
           while(rs.next())
           {
           Emp e=new Emp();
           e=new Emp();
           e.setEmpNo(rs.getInt(1));
           e.setEname(rs.getString(2));
           e.setEmpSal(rs.getDouble(3));
           empList.add(e);
           }
            return empList;
    
    }
     public static boolean updateEmployee(Emp e)throws SQLException
    {
        Connection con=DBConnection.getConnection();
         PreparedStatement ps=con.prepareStatement("update employee set ename=?, sal=? where empid =?");
         
       
        ps.setString(1,e.getEname());
        ps.setDouble(2,e.getEmpSal());
         ps.setInt(3,e.getEmpNo());
        int result = ps.executeUpdate();
         if(result==1)
             return true;
         return false;
   }
     public static boolean deleteEmployee(int EmpNo)throws SQLException
     {
     Connection con=DBConnection.getConnection();
           PreparedStatement ps=con.prepareStatement("Delete from employee where empid= ?");
           ps.setInt(1,EmpNo);
           int result=ps.executeUpdate();
          if(result==1)
             return true;
         return false;
     }

  } 

