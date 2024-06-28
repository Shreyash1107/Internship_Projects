package org.model;

public class Bookmodel 
{
    private int Bid;
    private String name;
    private String Category;
    private String Author;
    private String publication;
    private String Language;
    public Bookmodel()
    {

    }
    public Bookmodel(String name, String Category,String Author,String publication,String Language)
    {
        this.name = name;
        this.Category = Category;
        this.Author = Author;
        this.publication = publication;
        this.Language = Language;
    }
    public void setbid(int Bid)
    {
        this.Bid = Bid;
    }
    public int getbid()
    {
        return Bid;
    }
    public void setname(String name)
    {
        this.name = name;
    }
    public String getname()
    {
        return name;
    }
    public void setCategory(String Category)
    {
        this.Category = Category;
    }
    public String getCategory()
    {
        return Category;
    }
    public void setAuthor(String Author)
    {
        this.Author = Author;
    }
    public String getAuthor()
    {
        return Author;
    }
    public void setpublication(String publication)
    {
        this.publication = publication;
    }
    public String getpublication()
    {
        return publication;
    }
    public void setLanguage(String Language)
    {
        this.Language = Language;
    }
    public String getLanguage()
    {
        return Language;
    }
}
