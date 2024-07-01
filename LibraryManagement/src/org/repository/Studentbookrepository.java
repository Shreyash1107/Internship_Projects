package org.repository;
import static java.lang.System.*;
import java.util.Vector;

import org.config.DBHelper;
import org.model.Bookissuemodel;
import org.model.Bookmodel;
import org.model.Studentmodel;

public class Studentbookrepository extends DBHelper
{
    Vector<Bookissuemodel> v = null;
    public Vector<Bookissuemodel> getstudentwisebooks()
    {
        v = new Vector<Bookissuemodel>();
        try
        {
            pstmt = conn.prepareStatement("select S.Name as Studname,B.Name as Bookname,B.Category as Category from Book b inner join Bookissue bi on b.Bid = bi.Bid inner join Students S on S.\r\n" + //
                                "Sid = bi.Sid");
                                rs = pstmt.executeQuery();
                                while(rs.next())
                                {
                                    Bookissuemodel bim = new Bookissuemodel();
                                    Bookmodel bmd = new Bookmodel();
                                    Studentmodel smd = new Studentmodel();
                                    smd.setname(rs.getString(1));
                                    bim.setStudentmodel(smd);
                                    bmd.setname(rs.getString(2));
                                    bim.setBookmodel(bmd);
                                    bmd.setCategory(rs.getString(3));
                                    bim.setBookmodel(bmd);
                                    v.add(bim);
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
