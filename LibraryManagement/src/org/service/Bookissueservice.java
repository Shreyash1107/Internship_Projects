package org.service;

import java.util.LinkedHashMap;
import java.util.Vector;

import org.model.Bookissuemodel;
import org.repository.Bookissuerepository;

public class Bookissueservice 
{
    Bookissuerepository birepo = new Bookissuerepository();
    public int searchbooktoissue(int Bid)
    {
        int issueid = birepo.searchbooktoissue(Bid);
        return issueid;
    }
    public int searchstudentforissuebook(int Sid)
    {
        int issueid = birepo.searchstudentforissuebook(Sid);
        return issueid;
    }
    public boolean issueBook(Bookissuemodel bim)
    {
        return birepo.issueBook(bim);
    }
    public LinkedHashMap<String,Integer> getmostreadbooks()
    {
        LinkedHashMap<String,Integer> map = birepo.getmostreadbooks();
        return map;
    }
    public Vector<Bookissuemodel> getissuedbookd()
    {
        Vector<Bookissuemodel> vect = birepo.getissuedbooks();
        return vect;
    } 
    public Vector<Bookissuemodel> getremainingbooks()
    {
        Vector<Bookissuemodel> vect = birepo.getremainingbooks();
        return vect;
    }
    public boolean isbookstatusupdated(Bookissuemodel bim)
    {
        return birepo.isbookstatusupdated(bim);
    }
}
