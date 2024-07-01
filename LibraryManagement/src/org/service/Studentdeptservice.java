package org.service;

import java.util.Vector;

import org.model.Studentmodel;
import org.repository.Studentdeptrepository;

public class Studentdeptservice 
{
    Studentdeptrepository sdrepo = new Studentdeptrepository();
    public Vector<Studentmodel> getdeptwisestudent(String deptname)
    {
        Vector<Studentmodel> v = sdrepo.getdeptwisestudent(deptname);
        return v;
    }
}
