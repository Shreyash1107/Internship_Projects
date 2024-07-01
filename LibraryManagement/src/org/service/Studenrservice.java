package org.service;

import java.util.Vector;

import org.model.Studentmodel;
import org.repository.Studentrepository;

public class Studenrservice 
{
    Studentrepository srepo = new Studentrepository();
    public boolean isStudentAdd(Studentmodel sm)
    {
        return srepo.isStudentAdd(sm);
    }
    public boolean isbulkStudentadded(Studentmodel sm)
    {
        return srepo.isbulkStudentadded(sm);
    }
    public Vector<Studentmodel> getstudent()
    {
        Vector<Studentmodel>v = srepo.getstudent();
        return v;
    }
    public boolean isUpdateStudent(Studentmodel sm)
    {
        return srepo.isUpdateStudent(sm);
    }
    public boolean isdeleteStudent(Studentmodel sm)
    {
        return srepo.isdeleteStudent(sm);
    }
}
