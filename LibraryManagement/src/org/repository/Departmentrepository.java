package org.repository;
import java.sql.*;
import static java.lang.System.*;

import java.io.BufferedReader;
import java.io.FileReader;

import org.config.DBHelper;
import org.config.PathHelper;
import org.model.Departmentmodel;
public class Departmentrepository extends DBHelper 
{
    public boolean isDepartmentAdded(Departmentmodel dm)
    {
        try
        {
            FileReader fr = new FileReader(PathHelper.path + "department.csv");
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            int val = 0;
            while((line = br.readLine())!=null)
            {
                String data[] = line.split(",");
                pstmt = conn.prepareStatement("insert into Department values('0',?)");
                pstmt.setString(1, data[1]);
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
}
