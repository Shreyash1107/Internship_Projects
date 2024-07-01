package org.service;

import java.util.Vector;

import org.model.Bookissuemodel;
import org.repository.Studentbookrepository;

public class Studentbookservice 
{
    Studentbookrepository studbookrepo = new Studentbookrepository();
    public Vector<Bookissuemodel> getstudentwisebooks()
    {
        Vector<Bookissuemodel> vect = studbookrepo.getstudentwisebooks();
        return vect;
    }
}
