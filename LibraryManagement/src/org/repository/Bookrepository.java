package org.repository;

import org.config.DBHelper;
import org.config.PathHelper;
import org.model.Bookmodel;
import static java.lang.System.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Vector;
public class Bookrepository extends DBHelper 
{
    Vector<Bookmodel> v = null;
    public boolean isBookAdded(Bookmodel bm)
    {
        try
        {
            pstmt = conn.prepareStatement("insert into Book values('0',?,?,?,?,?)");
            pstmt.setString(1, bm.getname());
            pstmt.setString(2, bm.getCategory());
            pstmt.setString(3, bm.getAuthor());
            pstmt.setString(4, bm.getpublication());
            pstmt.setString(5, bm.getLanguage());
            int val;
            val = pstmt.executeUpdate();
            return val>0?true:false;
        }
        catch(Exception ex)
        {
            out.println("Error is " + ex);
        }
        return false;
    }
    public boolean isbulkBookAdded(Bookmodel bm)
    {
        try
        {
            FileReader fr = new FileReader(PathHelper.path + "books.csv");
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            int val = 0;
            while((line = br.readLine())!=null)
            {
                String str[] = line.split(",");
                pstmt = conn.prepareStatement("insert into Book values('0',?,?,?,?,?)");
                pstmt.setString(1, str[1]);
                pstmt.setString(2, str[2]);
                pstmt.setString(3, str[3]);
                pstmt.setString(4, str[4]);
                pstmt.setString(5, str[5]);
                val = pstmt.executeUpdate(); 
            }
            return val>0?true:false;
        }
        catch(Exception ex)
        {
            out.println("Hi");
            out.println("Error is " + ex);
        }
        return false;
    }
    public Vector<Bookmodel> getbooks()
    {
        v = new Vector<Bookmodel>();
        try
        {
            int val;
            pstmt = conn.prepareStatement("select *from Book");
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                Bookmodel bm = new Bookmodel();
                bm.setbid(rs.getInt(1));
                bm.setname(rs.getString(2));
                bm.setCategory(rs.getString(3));
                bm.setAuthor(rs.getString(4));
                bm.setpublication(rs.getString(5));
                bm.setLanguage(rs.getString(6));
                v.add(bm);
            }
            return v.size()>0?v:null;
        }
        catch(Exception ex)
        {
            out.println("Error is " + ex);
        }
        return null;
    }
    public boolean isUpdatebook(Bookmodel bm)
    {
        int val = 0;
        v = new Vector<Bookmodel>();
        try
        {
            pstmt = conn.prepareStatement("update Book set Name = ?, Category = ?, Author = ?, Publication = ?, Language = ? where Bid = ?");
            pstmt.setString(1, bm.getname());
            pstmt.setString(2, bm.getCategory());
            pstmt.setString(3, bm.getAuthor());
            pstmt.setString(4, bm.getpublication());
            pstmt.setString(5, bm.getLanguage());
            pstmt.setInt(6, bm.getbid());
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
