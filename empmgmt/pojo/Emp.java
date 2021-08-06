/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.pojo;

/**
 *
 * @author VIDIT
 */
public class Emp {
    
    public Emp()
    {
        
    }
    public Emp(int empNo, String ename, double empSal)
    {
        this.empNo=empNo;
        this.ename=ename;
        this.empSal=empSal;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public double getEmpSal() {
        return empSal;
    }

    public void setEmpSal(double empSal) {
        this.empSal = empSal;
    }
  private int empNo;
  private String ename;
  private double empSal;
}
