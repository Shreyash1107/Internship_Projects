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
    public boolean isBookdeleted(Bookmodel bm)
    {
        return brepo.isBookdeleted(bm);
    }
    public int getbookcountbycat(String category)
    {
        int count = brepo.getbookcountbycat(category);
        return count;
    }
    public Vector<Bookmodel> getcategorywisebooks(String Category)
    {
        Vector<Bookmodel> v = brepo.getcategorywisebooks(Category);
        return v;
    }
    public int searchbook(int Bid)
    {
        int id = brepo.searchbook(Bid);
        return id;
    }
    public Vector<Bookmodel> getdetails(int Bid)
    {
        Vector<Bookmodel> v = brepo.getdetails(Bid);
        return v;
    }
}
