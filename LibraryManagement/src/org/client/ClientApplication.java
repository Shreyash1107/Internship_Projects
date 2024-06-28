package org.client;
import java.util.*;
import static java.lang.System.*;
import org.model.Bookmodel;
import org.service.BookService;
public class ClientApplication 
{
   public static void main(String args[])
   {
        int choice,bid;
        String name,category,author,pub,language;
        boolean flag;
        Vector<Bookmodel> v = new Vector<Bookmodel>();
        Bookmodel bm = new Bookmodel();
        BookService bservice = new BookService();
        Scanner xyz = new Scanner(System.in);
        do
        {
            out.println("1.Add/View/Delete/Update Books in Library.");
            out.println("2.Add/View/Delete/Update the Students in College.");
            out.println("3.Count Category-wise Books.");
            out.println("4.Display Category-wise Books.");
            out.println("5.Search book in Library.");
            out.println("6.Issue the Book to Student.");
            out.println("7.Show the Remaining After the Book issued.");
            out.println("8.Show the Student-wise Books.");
            out.println("9.Display list of Most Issued Books(Most read Books).");
            out.println("10.Submit the Fine if Student failed to return Book on time.");
            out.println("11.Sending the Updates regarding Books to Student teough Mail.");
            out.println(" ");
            out.println("Enter the Choice:");
            choice = xyz.nextInt();
            out.println(" ");
            switch(choice)
            {
                case 1:
                out.println("1.Add/View/Update/Delete Books in Library.");
                out.println(" ");
                do
                {
                    out.println("1.Add Books in Library.");
                    out.println("2.View Books in Library.");
                    out.println("3.Update the Books in Library.");
                    out.println("4.Delete Books in Library.");
                    out.println(" ");
                    out.println("Enter the Choice:");
                    choice = xyz.nextInt();
                    out.println(" ");
                    switch(choice)
                    {
                        case 1:
                        out.println("1.Add the Books in Library:");
                        out.println(" ");
                        do
                        {
                            out.println("1.Add the Books in Libary Manually.");
                            out.println("2.Add the Books in Library in bulk.");
                            out.println(" ");
                            out.println("Enter the Choice:");
                            choice = xyz.nextInt();
                            out.println(" ");
                            switch(choice)
                            {
                                case 1:
                                out.println("1.Add the Books in Library manually.");
                                out.println(" ");
                                xyz.nextLine();  //Consuming newline character
                                out.println("Enter the Name of a Book");
                                name = xyz.nextLine();
                                out.println("Enter the Book Category");
                                category = xyz.nextLine();
                                out.println("Enter the Author Name");
                                author = xyz.nextLine();
                                out.println("Enter the Book Publication");
                                pub = xyz.nextLine();
                                out.println("Enter the Language");
                                language = xyz.nextLine();
                                bm = new Bookmodel(name, category, author, pub,language);
                                flag = bservice.isBookAdded(bm);
                                if(flag)
                                {
                                    out.println("Books has been Added Successfully in Library.....");
                                    out.println(" ");
                                }
                                else
                                {
                                    out.println("Books has not been Added in Library.....");
                                    out.println(" ");
                                }
                                break;
                                case 2:
                                out.println("1.Add the Books in Library in bulk.");
                                out.println(" ");
                                flag = bservice.isbulkBookAdded(bm);
                                if(flag)
                                {
                                    out.println("Books has been Added in Library in bulk....");
                                    out.println(" ");
                                }
                                else
                                {
                                    out.println("Books has not been Added in Library in Bulk....");
                                    out.println(" ");
                                }
                                break;
                                default:
                                out.println("*********BOOK INSERTION COMPLETED*********");
                                break;
                            }
                        }while(choice!=3);
                        break;
                            case 2:
                            out.println("2.View all the Books in Library");
                            out.println(" ");
                            v = bservice.getbooks();
                            if(v!=null)
                            {
                                out.println("Books are Present in Library....");
                                for(Bookmodel bmodel:v)
                                {
                                    out.println("Book Id is " + bmodel.getbid());
                                    out.println("Book Name is " + bmodel.getname());
                                    out.println(bmodel.getname() + " belongs to " + bmodel.getCategory() + " category");
                                    out.println("Author of the book " + bmodel.getname() + " is " + bmodel.getAuthor());
                                    out.println("Publication of Book " + bmodel.getname() + " is " + bmodel.getpublication());
                                    out.println("Lnaguage of book " + bmodel.getname() + " is " + bmodel.getLanguage());
                                    out.println(" ");
                                }
                            }
                            else
                            {
                                out.println("Books are not Present in Library....");
                                out.println(" ");
                            }
                            break;
                            case 3:
                            out.println("3.Update the Books in Library.");
                            out.println(" ");
                            out.println("Enter the Book Id which you want to Update:");
                            bid = xyz.nextInt();
                            bm.setbid(bid);
                            xyz.nextLine();  //Consuming newline Character
                            out.println("Enter the Updated Book Name:");
                            name = xyz.nextLine();
                            bm.setname(name);
                            out.println("Enter the Updated Book Category:");
                            category = xyz.nextLine();
                            bm.setCategory(category);
                            out.println("Enter the Updated Book Author:");
                            author = xyz.nextLine();
                            bm.setAuthor(author);
                            out.println("Enter the Updated book Publication:");
                            pub = xyz.nextLine();
                            bm.setpublication(pub);
                            out.println("Enter the Updated Book Language");
                            language = xyz.nextLine();
                            bm.setLanguage(language);
                            flag = bservice.isUpdatebook(bm);
                            if(flag)
                            {
                                out.println("Book with id " + bid + " has been Update dSuccesfully....");
                                out.println(" ");
                            }
                            else
                            {
                                out.println("Book with id " + bid + " has not Updated Succesfully.... ");
                                out.println(" ");
                            }
                            v = bservice.getbooks();
                            if(v!=null)
                            {
                                out.println("Books are present in Library........");
                                out.println(" ");
                                for(Bookmodel bmodel:v)
                                {
                                    out.println("Book Id is " + bmodel.getbid());
                                    out.println("Book Name is " + bmodel.getname());
                                    out.println(bmodel.getname() + " belongs to " + bmodel.getCategory() + " category");
                                    out.println("Author of the book " + bmodel.getname() + " is " + bmodel.getAuthor());
                                    out.println("Publication of Book " + bmodel.getname() + " is " + bmodel.getpublication());
                                    out.println("Lnaguage of book " + bmodel.getname() + " is " + bmodel.getLanguage());
                                    out.println(" ");
                                }
                            }
                            else
                            {
                                out.println("No Books are there in Library.....");
                                out.println(" ");
                            }
                            break;
                    }
                }while(choice!=5);
            }
        }while(true);
   }
}
