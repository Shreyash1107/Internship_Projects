package org.repository;
import static java.lang.System.*;

import java.util.LinkedHashMap;
import java.util.Vector;

import org.config.DBHelper;
import org.model.Bookissuemodel;
import org.model.Bookmodel;

public class Bookissuerepository extends DBHelper 
{
    Vector<Bookissuemodel> vect = null;
    public int searchbooktoissue(int Bid)
    {
        int id = 0;
        try
        {
            pstmt = conn.prepareStatement("select *from Book where Bid = ?");
            pstmt.setInt(1, Bid);
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                id = rs.getInt(1);
            }
        }
        catch(Exception ex)
        {
            out.println("Error is " + ex);
        }
        return id;
    }
    public boolean issueBook(Bookissuemodel bim)
    {
        int val = 0;
        try
        {
            pstmt = conn.prepareStatement("insert into Bookissue(Bid,Sid,issuedate,duedate)values(?,?,?,?)");
            Bookmodel bm = new Bookmodel();
            pstmt.setInt(1, bim.getBid());
            pstmt.setInt(2, bim.getSid());
            pstmt.setString(3, bim.getissuedate());
            pstmt.setString(4, bim.getduedate());
            val = pstmt.executeUpdate();
            return val>0?true:false;
        }
        catch(Exception ex)
        {
            out.println("Error is " + ex);
        }
        return false;
    }
    public LinkedHashMap<String,Integer> getmostreadbooks()
    {
        int count;
        LinkedHashMap<String,Integer> mostreadbook = new LinkedHashMap<String,Integer>();
        try
        {
            pstmt = conn.prepareStatement(" select b.name,count(bi.bid) as Bookcount from Bookissue bi inner join Book b on bi.Bid = b.Bid group by b.name order by Bookcount desc Limit 1");
            // pstmt = conn.prepareStatement(" SELECT B.Name AS Bookname, COUNT(Bi.Bid) AS issue_count FROM Bookissue Bi JOIN Book B ON Bi.Bid = B.Bid GROUP BY B.Name HAVING COUNT(Bi.Bid) = (SELECT MAX(issue_count) FROM (SELECT COUNT(Bid) AS issue_count FROM Bookissue GROUP BY Bid) AS counts)");
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                String bookName = rs.getString("Name");
                count = rs.getInt("Bookcount");
                mostreadbook.put(bookName, count);
            }
            return mostreadbook.size()>0?mostreadbook:null;
        }
        catch(Exception ex)
        {
            out.println("Error is " + ex);
        }
        return null;
    }
    public Vector<Bookissuemodel> getremainingbooks()
    {
        vect = new Vector<Bookissuemodel>();
        try
        {
            pstmt = conn.prepareStatement("select b.Bid as Bookid, b.Name as bookname,b.category as Category from Book b left join Bookissue bi on b.Bid = bi.Bid where bi.Bid is Null");
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                Bookissuemodel bim = new Bookissuemodel();
                Bookmodel bmd = new Bookmodel();
                bmd.setbid(rs.getInt(1));
                bim.setBookmodel(bmd);
                bmd.setname(rs.getString(2));
                bim.setBookmodel(bmd);
                bmd.setCategory(rs.getString(3));
                bim.setBookmodel(bmd);
                vect.add(bim);
            }
            return vect.size()>0?vect:null;
        }
        catch(Exception ex)
        {
            out.println("Error is " + ex);
        }
        return null;
    }
}
