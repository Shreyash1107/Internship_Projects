package org.repository;
import static java.lang.System.*;
import java.util.Vector;

import org.config.DBHelper;
import org.model.Departmentmodel;
import org.model.Studentmodel;

public class Studentdeptrepository extends DBHelper
{
    Vector <Studentmodel> v = null;
    public Vector<Studentmodel> getdeptwisestudent(String deptname)
    {
        v = new Vector<Studentmodel>();
        try
        {
            pstmt = conn.prepareStatement("select s.Sid,s.Name,d.Name as Dept_name from Students s inner join Department d on S.Dept_id = d.Dept_id where d.name = ? ");
            pstmt.setString(1, deptname);
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                Studentmodel smd = new Studentmodel();
                smd.setSid(rs.getInt(1));
                smd.setname(rs.getString(2));
                Departmentmodel dmd = new Departmentmodel();
                dmd.setName(deptname);
                smd.setDepartmentmodel(dmd);
                v.add(smd);
            }
            return v.size()>0?v:null;
        }
        catch(Exception ex)
        {
            out.println("Error is " + ex);
        }
        return null;
    }
}
