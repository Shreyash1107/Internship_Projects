package org.model;
public class Departmentmodel 
{
    private int deptid;
    private String name;
    public Departmentmodel()
    {

    } 
    public Departmentmodel(int deptid, String name)
    {
        this.deptid = deptid;
        this.name = name;
    }
    public void setdeptid(int deptid)
    {
        this.deptid = deptid;
    }
    public int getdeptid()
    {
        return deptid;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getname()
    {
        return name;
    }
}
