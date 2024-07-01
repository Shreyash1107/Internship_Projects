package org.repository;
import java.sql.*;
import java.util.Vector;

import static java.lang.System.*;

import java.io.BufferedReader;
import java.io.FileReader;

import org.config.DBHelper;
import org.config.PathHelper;
import org.model.Studentmodel;
public class Studentrepository extends DBHelper
{
    int val = 0;
    Vector<Studentmodel> v = null;
    public boolean isStudentAdd(Studentmodel sm)
    {
        try
        {
            pstmt = conn.prepareStatement("insert into Students values('0',?,?,?,?)");
            pstmt.setString(1, sm.getname());
            pstmt.setString(2, sm.getemail());
            pstmt.setString(3, sm.getcontact());
            pstmt.setInt(4, sm.getdeptid());
            val = pstmt.executeUpdate();
            return val>0?true:false;
        }
        catch(Exception ex)
        {
            out.println("Error is " + ex);
        }
        return false;
    }
    public boolean isbulkStudentadded(Studentmodel sm)
    {
        try
        {
            String line = null;
            FileReader fr = new FileReader(PathHelper.path + "student.csv");
            BufferedReader br = new BufferedReader(fr);
            while((line = br.readLine())!=null)
            {
                String data[] = line.split(",");
                pstmt = conn.prepareStatement("insert into Students values('0',?,?,?,?)");
                pstmt.setString(1, data[1]);
                pstmt.setString(2, data[2]);
                pstmt.setString(3, data[3]);
                pstmt.setInt(4, Integer.parseInt(data[4]));
                val = pstmt.executeUpdate();
            }
            return val>0?true:false;
        }
        catch(Exception ex)
        {
            out.println("Error is " + ex);
        }
        return false;
    }
    public Vector<Studentmodel> getstudent()
    {
        v = new Vector<Studentmodel>();
        try
        {
            pstmt = conn.prepareStatement("select * from Students");
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                Studentmodel sm = new Studentmodel();
                sm.setSid(rs.getInt(1));
                sm.setname(rs.getString(2));
                sm.setemail(rs.getString(3));
                sm.setcontact(rs.getString(4));
                sm.setdeptid(rs.getInt(5));
                v.add(sm);
            }
            return v.size()>0?v:null;
        }
        catch(Exception ex)
        {
            out.println("Error is " + ex);
        }
        return null;
    }
    public boolean isUpdateStudent(Studentmodel sm)
    {
        try
        {
            pstmt = conn.prepareStatement("update Students set name = ?, Email = ?, Contact = ?, Dept_id = ? where Sid = ?");
            pstmt.setString(1, sm.getname());
            pstmt.setString(2, sm.getemail());
            pstmt.setString(3, sm.getcontact());
            pstmt.setInt(4, sm.getdeptid());
            pstmt.setInt(5, sm.getSid());
            val = pstmt.executeUpdate();
            return val>0?true:false;
        }
        catch(Exception ex)
        {
            out.println("Error is " + ex);
        }
        return false;
    }
    public boolean isdeleteStudent(Studentmodel sm)
    {
        try
        {
            pstmt = conn.prepareStatement("delete from Students where Sid = ?");
            pstmt.setInt(1, sm.getSid());
            val = pstmt.executeUpdate();
            return val>0?true:false;
        }
        catch(Exception ex)
        {
            out.println("Error is " + ex);
        }
        return false;
    }
}
