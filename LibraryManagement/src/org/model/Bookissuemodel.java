package org.model;

public class Bookissuemodel 
{
    private int Bid;
    private int Sid;
    private Bookmodel bm;
    private Studentmodel sm;
    private String issuedate;
    private String returndate;
    private String duedate;
    public void setBid(int Bid)
    {
        this.Bid = Bid;
    }
    public int getBid()
    {
        return Bid;
    }
    public void setSid(int Sid)
    {
        this.Sid = Sid;
    }
    public int getSid()
    {
        return Sid;
    }
    public void setBookmodel(Bookmodel bm)
    {
        this.bm = bm;
    }
    public Bookmodel getBookmodel()
    {
        return bm;
    }
    public void setStudentmodel(Studentmodel sm)
    {
        this.sm = sm;
    }
    public Studentmodel getStudentmodel()
    {
        return sm;
    }
    public void setissuedate(String issuedate)
    {
        this.issuedate = issuedate;
    }
    public String getissuedate()
    {
        return issuedate;
    }
    public void setreturndate(String returndate)
    {
        this.returndate = returndate;
    }
    public String getreturndate()
    {
        return returndate;
    }
    public void setduedate(String duedate)
    {
        this.duedate = duedate;
    }
    public String getduedate()
    {
        return duedate;
    }
}
