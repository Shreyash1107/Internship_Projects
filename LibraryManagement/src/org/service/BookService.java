package org.service;

import java.util.Vector;

import org.model.Bookmodel;
import org.repository.Bookrepository;

public class BookService 
{
    Bookrepository brepo = new Bookrepository();
    public boolean isBookAdded(Bookmodel bm)
    {
        return brepo.isBookAdded(bm);
    }
    public boolean isbulkBookAdded(Bookmodel bm)
    {
        return brepo.isbulkBookAdded(bm);
    }
    public Vector<Bookmodel> getbooks()
    {
        Vector<Bookmodel> v = brepo.getbooks();
        return v;
    }
    public boolean isUpdatebook(Bookmodel bm)
    {
        return brepo.isUpdatebook(bm);
    }
}
