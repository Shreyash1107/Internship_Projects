package org.model;

public class Studentmodel 
{
    private int Sid;
    private String name;
    private String email;
    private String Contact;
    private int dept_id;
    private Departmentmodel dm;
    public Studentmodel()
    {

    }   
    public Studentmodel(String name,String email,String Contact,int dept_id)
    {
        this.name=name;
        this.email=email;
        this.Contact=Contact;
        this.dept_id=dept_id;
    }
    public void setSid(int Sid)
    {
        this.Sid = Sid;
    }
    public int getSid()
    {
        return Sid;
    }
    public void setname(String name)
    {
        this.name = name;
    }
    public String getname()
    {
        return name;
    }
    public void setemail(String email)
    {
        this.email = email;
    }
    public String getemail()
    {
        return email;
    }
    public void setcontact(String Contact)
    {
        this.Contact = Contact;
    }
    public String getcontact()
    {
        return Contact;
    }
    public void setdeptid(int dept_id)
    {
        this.dept_id = dept_id;
    }
    public int getdeptid()
    {
        return dept_id;
    }
    public void setDepartmentmodel(Departmentmodel dm)
    {
        this.dm = dm;
    }
    public Departmentmodel getDepartmentmodel()
    {
        return dm;
    }
}
