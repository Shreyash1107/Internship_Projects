package org.client;
import java.util.*;
import static java.lang.System.*;

import org.config.EmailSender;
import org.model.Bookissuemodel;
import org.model.Bookmodel;
import org.model.Departmentmodel;
import org.model.Studentmodel;
import org.service.BookService;
import org.service.Bookissueservice;
import org.service.Departmentservice;
import org.service.Studenrservice;
import org.service.Studentbookservice;
import org.service.Studentdeptservice;
public class ClientApplication 
{
   private static String receiveremail;

public static void main(String args[])
   {
        int choice,bid,deptid,Sid,issueid;
        int temp,temp1;
        String name,category,author,pub,language,msg,contact,email,ques,issueddate,returndate,duedate;
        String sendername,emailsub,emailcont;
        boolean flag;
        Vector<Bookmodel> v = new Vector<Bookmodel>();
        Vector<Studentmodel>v1 = new Vector<Studentmodel>();
        Vector <Studentmodel> v2 = new Vector<Studentmodel>();
        Vector <Bookmodel> v3 = new Vector<Bookmodel>();
        Vector <Bookissuemodel> v4 = new Vector<Bookissuemodel>();
        LinkedHashMap<String,Integer> bookmap = new LinkedHashMap<>();
        Bookmodel bm = new Bookmodel();
        BookService bservice = new BookService();
        Departmentservice dservice = new Departmentservice();
        Departmentmodel dm = new Departmentmodel();
        Studentmodel sm = new Studentmodel();
        Studenrservice studservice = new Studenrservice();
        Studentdeptservice sdservice = new Studentdeptservice();
        Bookissuemodel bim = new Bookissuemodel();
        Bookissueservice bis = new Bookissueservice();
        Studentbookservice studbservice = new Studentbookservice();
        Scanner xyz = new Scanner(System.in);
        do
        {
            out.println(" ");
            out.println("1.Add/View/Delete/Update Books in Library.");
            out.println("2.Add the Department Details.");
            out.println("3.Add/View/Delete/Update the Students in College.");
            out.println("4.Display Department Wise Student.");
            out.println("5.Count Category-wise Books.");
            out.println("6.Display Category-wise Books.");
            out.println("7.Search book in Library.");
            out.println("8.Issue the Book to Student.");
            out.println("9.Show the Student-wise Books.");
            out.println("10.Display list of Most Issued Books(Most read Books).");
            out.println("11.Show the Remaining stock After the Book issued.");
            out.println("12.Update the Book status with Return Date.");
            out.println("13.Sending the Updates regarding Books to Student through Mail.");
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
                            xyz.nextLine();  //Consuming newline character  
                            out.println("Do you want to Update the Book Details?");
                            msg = xyz.nextLine();
                            out.println(" ");
                            if(msg.equals("yes"))
                            {
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
                                        out.println("Lanaguage of book " + bmodel.getname() + " is " + bmodel.getLanguage());
                                        out.println(" ");
                                    }
                                }
                                else
                                {
                                    out.println("No Books are there in Library.....");
                                    out.println(" ");
                                }
                            }
                            else
                            {
                                out.println("No Book Details will be Updated....");
                                out.println(" ");
                            }
                            break;
                            case 4:
                            xyz.nextLine(); //Consuming newline character
                            out.println("Do you want to Delete any Book from Library ?");
                            msg = xyz.nextLine();
                            if(msg.equals("yes"))
                            {
                                out.println("Enter the Book Id which you want to Delete:");
                                bid = xyz.nextInt();
                                bm.setbid(bid);
                                flag = bservice.isBookdeleted(bm);
                                if(flag)
                                {
                                    out.println("Book with id " + bid + " has been Successfully Deleted....");
                                    out.println(" ");
                                }
                                else
                                {
                                    out.println("Book with id " + bid + " has not been Deleted.....");
                                    out.println(" ");
                                }
                                v = bservice.getbooks();
                                if(v!=null)
                                {
                                    out.println("Books are Present in Libraty even after deletion....");
                                    out.println(" ");
                                    for(Bookmodel bmodel : v)
                                    {
                                        out.println("Book Id is " + bmodel.getbid());
                                        out.println("Book Name is " + bmodel.getname());
                                        out.println(bmodel.getname() + " belongs to " + bmodel.getCategory() + " category");
                                        out.println("Author of the book " + bmodel.getname() + " is " + bmodel.getAuthor());
                                        out.println("Publication of Book " + bmodel.getname() + " is " + bmodel.getpublication());
                                        out.println("Lanaguage of book " + bmodel.getname() + " is " + bmodel.getLanguage());
                                        out.println(" ");
                                    }
                                }
                                else
                                {
                                    out.println("Books are not present in Library.....");
                                    out.println(" ");
                                }
                            }
                            else
                            {
                                out.println("Book deletion will not happen.....");
                                out.println(" ");
                            }
                            break;
                            default:
                            out.println("**************BOOK ARRANGMENT COMPLETED****************");
                            out.println(" ");
                            break;
                    }
                }while(choice!=5);
                break;
                        case 2:
                        xyz.nextLine(); //Consuming newline character
                        out.println("2.Add the Department Details.");
                        out.println(" ");
                        flag = dservice.isDepartmentAdded(dm);
                        if(flag)
                        {
                            out.println("Department Details has been Added Successfully.....");
                            out.println(" ");
                        }
                        else
                        {
                            out.println("Department Details has not been Added....");
                            out.println(" ");
                        }
                        break;
                        case 3:
                        out.println("3.Add/View/Update/Delete Students in College.");
                        out.println(" ");
                        do
                        {
                            out.println("1.Add the Students in College");
                            out.println("2.View the Students in College.");
                            out.println("3.Update Student Details.");
                            out.println("4.Delete the Student Details.");
                            out.println(" ");
                            out.println("Enter the Choice:");
                            choice = xyz.nextInt();
                            out.println(" ");
                            switch(choice)
                            {
                                case 1:
                                out.println("1.Add the Student Details");
                                out.println(" ");
                                do
                                {
                                    out.println("1.Add the Student Details Manually.");
                                    out.println("2.Add the Student Details in bulk.");
                                    out.println(" ");
                                    out.println("Enter the Choice:");
                                    choice = xyz.nextInt();
                                    out.println(" ");
                                    switch(choice)
                                    {
                                        case 1:
                                        out.println("1.Add the Student Details Manually.");
                                        out.println(" ");
                                        xyz.nextLine(); //Consuming newline character
                                        out.println("Enter the Student Name:");
                                        name = xyz.nextLine();
                                        sm.setname(name);
                                        out.println("Enter the Email of a Student:");
                                        email = xyz.nextLine();
                                        sm.setemail(email);
                                        out.println("Enter the Contact of a Student:");
                                        contact = xyz.nextLine();
                                        sm.setcontact(contact);
                                        out.println("Enter the Department Id of a Student:");
                                        deptid = xyz.nextInt();
                                        sm.setdeptid(deptid);
                                        flag = studservice.isStudentAdd(sm);
                                        if(flag)
                                        {
                                            out.println("Student Details has been Added Successfully.....");
                                            out.println(" ");
                                        }
                                        else
                                        {
                                             out.println("Student Details has not been Added....");
                                             out.println(" ");
                                        }
                                        break;
                                        case 2:
                                        out.println("2.Add the Student data in Bulk.");
                                        out.println(" ");
                                        flag = studservice.isbulkStudentadded(sm);
                                        if(flag)
                                        {
                                             out.println("Student Details has been Added Successfully.....");
                                             out.println(" ");
                                        }
                                        else
                                        {
                                             out.println("Student Details has not been Added....");
                                             out.println(" ");
                                        }
                                        break;
                                        default:
                                        out.println("********STUDENT INSERTION COMPLETED**********");
                                        break;
                                    }
                                }while(choice!=3);
                                break;
                                case 2:
                                out.println("2.View the Student Details.");
                                out.println(" ");
                                v1= studservice.getstudent();
                                if(v1!=null)
                                {
                                    out.println("Students are present.....");
                                    out.println(" ");
                                    for(Studentmodel smodel : v1)
                                    {
                                        out.println("Student Id is " + smodel.getSid());
                                        out.println("Student Name is " + smodel.getname());
                                        out.println("Email of " + smodel.getname() + " is " + smodel.getemail());
                                        out.println("Contact of the Student " + smodel.getname() + " is " + smodel.getcontact());
                                        out.println("Department Id of the Student " + smodel.getname() + " is " + smodel.getdeptid());
                                        out.println(" ");
                                    }
                                }
                                else
                                {
                                    out.println("Students are not Present....");
                                    out.println(" ");
                                }
                                break;
                                case 3:
                                out.println("3.Update Student Details.");
                                out.println(" ");
                                xyz.nextLine(); //Consuming newline character
                                out.println("Do you want to Update the Student Details?");
                                msg = xyz.nextLine();
                                if(msg.equals("yes"))
                                {
                                    out.println("Updating Student Details");
                                    out.println("Enter the Student Id you want to Update:");
                                    Sid = xyz.nextInt();
                                    sm.setSid(Sid);
                                    xyz.nextLine();  //Consuming newline character
                                    out.println("Enter the Student Updated Name:");
                                    name = xyz.nextLine();
                                    sm.setname(name);
                                    out.println("Enter the Student's Updated Email:");
                                    email = xyz.nextLine();
                                    sm.setemail(email);
                                    out.println("Enter the Student's Updated Contact Details:");
                                    contact = xyz.nextLine();
                                    sm.setcontact(contact);
                                    out.println("Enter the Student's Updated Department Id:");
                                    deptid = xyz.nextInt();
                                    sm.setdeptid(deptid);
                                    flag = studservice.isUpdateStudent(sm);
                                    if(flag)
                                    {
                                        out.println("Student Details for " + Sid + " has been Updated Successfully....");
                                        out.println(" ");
                                    }
                                    else
                                    {
                                        out.println("Student Details for " + Sid + " has not Updated....");
                                        out.println(" ");
                                    }
                                    v1 = studservice.getstudent();
                                    if(v1!=null)
                                    {
                                        out.println("Updated Student Details are as Follows....");
                                        out.println(" ");
                                        for(Studentmodel smodel : v1)
                                        {
                                            out.println("Student Id is " + smodel.getSid());
                                            out.println("Student Name is " + smodel.getname());
                                            out.println("Email of " + smodel.getname() + " is " + smodel.getemail());
                                            out.println("Contact of the Student " + smodel.getname() + " is " + smodel.getcontact());
                                            out.println("Department Id of the Student " + smodel.getname() + " is " + smodel.getdeptid());
                                            out.println(" ");
                                        }
                                    }
                                    else
                                    {
                                        out.println("Student Details has not been Updated....");
                                        out.println(" ");
                                    }
                                }
                                else
                                {
                                    out.println("Student details will not get updated.....");
                                    out.println(" ");
                                }
                                break;
                                case 4:
                                out.println("4.Delete the Student Details.");
                                out.println(" ");
                                xyz.nextLine();  //Consuming newline character
                                out.println("Had the Student Completed his Education ?");
                                ques = xyz.nextLine();
                                if(ques.equals("yes"))
                                {
                                    out.println("Do you want to remove Student Details then ?");
                                    msg = xyz.nextLine();
                                    if(msg.equals("yes"))
                                    {
                                        out.println("Removing Student Details");
                                        out.println("Enter the Student's Id which you want to delete:");
                                        Sid = xyz.nextInt();
                                        sm.setSid(Sid);
                                        flag = studservice.isdeleteStudent(sm);
                                        if(flag)
                                        {
                                            out.println("Student with id " + Sid + " has been removed Successfully.");
                                            out.println(" ");
                                        }
                                        else
                                        {
                                            out.println("Student with id " + Sid + " has not been removed Successfully.");
                                            out.println(" ");
                                        }
                                        v1 = studservice.getstudent();
                                        if(v1!=null)
                                        {
                                            out.println("Students are Present in College even After Deletion");
                                            out.println(" ");
                                            for(Studentmodel smodel : v1)
                                            {
                                                out.println("Student Id is " + smodel.getSid());
                                                out.println("Student Name is " + smodel.getname());
                                                out.println("Email of " + smodel.getname() + " is " + smodel.getemail());
                                                out.println("Contact of the Student " + smodel.getname() + " is " + smodel.getcontact());
                                                out.println("Department Id of the Student " + smodel.getname() + " is " + smodel.getdeptid());
                                                out.println(" ");
                                            }
                                        }
                                        else
                                        {
                                            out.println("Student are not there in college database.");
                                            out.println(" ");
                                        }
                                    }
                                    else
                                    {
                                        out.println("Student has not been removed");
                                        out.println(" ");
                                    }
                                }
                                else
                                {
                                    out.println("Student has not completed his Academics so will not be removed for College.");
                                    out.println(" ");
                                }
                                break;
                                default:
                                out.println("*********STUDENT REGISTRATION FOR LIBRARY COMPLETED***********");
                                out.println(" ");
                            }
                        }while(choice!=5);
                        break;
                        case 4:
                        out.println("4.Display Department Wise Student.");
                        out.println(" ");
                        xyz.nextLine();
                        out.println("Enter the Department Name:");
                        name = xyz.nextLine();
                        v2 = sdservice.getdeptwisestudent(name);
                        if(v2!=null)
                        {
                            out.println("Student are present for department " + name + " in database.....");
                            out.println(" ");
                            for(Studentmodel smd : v2)
                            {
                                out.println("Student Id is " + smd.getSid());
                                out.println("Name of the Student is " + smd.getname());
                                out.println("Student is from " + smd.getDepartmentmodel().getname() + " Department");
                                out.println(" ");
                            }
                        }
                        else
                        {
                            out.println("Students are not there for Department " + name + " in database....");
                            out.println(" ");
                        }
                        break;
                        case 5: 
                        out.println("5.Count the Book Category-wise.");
                        out.println(" ");
                        xyz.nextLine();  //Consuming newline character
                        out.println("Enter the Book Category:");
                        category = xyz.nextLine();
                        out.println(" ");
                        temp = bservice.getbookcountbycat(category);
                        if(temp!=0)
                        {
                            out.println("Number of Books in " + category + " Category is " + temp);
                            out.println(" ");
                        }
                        else
                        {
                            out.println("No Books are there in Library for " + category + " Category......");
                            out.println(" ");
                        }
                        break;
                        case 6:
                        out.println("6.Display the Category-wise Books.");
                        out.println(" ");
                        xyz.nextLine();  //Consuming newline character
                        out.println("Enter the Book Category:");
                        category = xyz.nextLine();
                        v = bservice.getcategorywisebooks(category);
                        if(v!=null)
                        {
                            out.println("Books of Category " + category + " are present in Library.....");
                            out.println(" ");
                            for(Bookmodel bmd : v)
                            {
                                out.println("Book id is " + bmd.getbid());
                                out.println("Book Name is " + bmd.getname());
                                out.println("Book " + bmd.getname() + " belongs to " + bmd.getCategory());
                                out.println("Author of the Book " + bmd.getname() + " is " + bmd.getAuthor());
                                out.println("Book " + bmd.getname() + " is published by " + bmd.getpublication());
                                out.println("Book " + bmd.getname() + " is of " + bmd.getLanguage() + " Language");
                                out.println(" ");
                            }
                        }
                        else
                        {
                            out.println("No Books are available for " + category + " Category.");
                            out.println(" ");
                        }
                        break;
                        case 7:
                        out.println("7.Search the Book in Library.");
                        out.println(" ");
                        out.println("Enter the Book Id which you want to Search for:");
                        bid = xyz.nextInt();
                        out.println(" ");
                        temp = bservice.searchbook(bid);
                        v3 = bservice.getdetails(bid);
                        if(temp!=0)
                        {
                            out.println("Book with id " + bid + " is present in Library.....");
                            out.println(" ");
                            if(v3!=null)
                            {
                                out.println("Book details for Id " + bid + " are as follows.....");
                                for(Bookmodel bmd : v3)
                                {
                                    out.println("Book id is " + bmd.getbid());
                                    out.println("Book Name is " + bmd.getname());
                                    out.println("Book " + bmd.getname() + " belongs to " + bmd.getCategory() + " Category");
                                    out.println("Author of the Book " + bmd.getname() + " is " + bmd.getAuthor());
                                    out.println("Book " + bmd.getname() + " is published by " + bmd.getpublication());
                                    out.println("Book " + bmd.getname() + " is of " + bmd.getLanguage() + " Language");
                                    out.println(" ");
                                }
                            }
                            else
                            {
                                out.println("There might be some issue so books are not Showing.....");
                                out.println(" ");
                            }
                        }
                        else
                        {
                            out.println("Book with id " + bid + " is not present in Library....");
                            out.println(" ");
                        }
                        break;
                        case 8:
                        out.println("8.Issue the Books to Student.");
                        out.println(" ");
                        xyz.nextLine();  //Consuming newline character
                        out.println("Enter the Book Id to check whether it is availble to issue or not:");
                        bid = xyz.nextInt();
                        out.println(" ");
                        out.println("What is your Student Id?"); //asking Student his Id
                        Sid = xyz.nextInt();
                        out.println(" ");
                        temp = bis.searchbooktoissue(bid);
                        temp1 = bis.searchstudentforissuebook(Sid);
                        if(temp!=0 && temp1!=0)
                        {
                            out.println("Book with id " + bid + " and Student with Id " + Sid + " are availble so that book can be issued to Students.....");
                            out.println(" ");
                            bim.setBid(bid);
                            bim.setSid(Sid);
                            xyz.nextLine();  //Consuming newline character
                            out.println("Tell the Book Issue date to Student:");
                            issueddate = xyz.nextLine();
                            bim.setissuedate(issueddate);
                            out.println("Tell the Book Due Date to the Student:");
                            duedate = xyz.nextLine();
                            bim.setduedate(duedate);
                            flag = bis.issueBook(bim);
                            v4 = bis.getissuedbookd();
                            if(v4!=null)
                            {
                                out.println("Issued Books Details are as Follows.....");
                                out.println(" ");
                                for(Bookissuemodel bimd : v4)
                                {
                                    out.println("Book Issue Id: " + bimd.getissueid());
                                    out.println("Book Id: " + bimd.getBookmodel().getbid());
                                    out.println("Student Id: " + bimd.getStudentmodel().getSid());
                                    out.println("Issue Date: " + bimd.getissuedate());
                                    out.println("Return Date: " + bimd.getreturndate());
                                    out.println("Due Date: " + bimd.getduedate());
                                    out.println("Status: " + bimd.getstatus());
                                    out.println(" ");
                                }
                            }
                            else
                            {
                                out.println("No Issued Books Details are there.....");
                                out.println(" ");
                            }
                            if(flag)
                            {
                                out.println("Book Issued to the Student.....");
                                out.println(" ");
                            }
                            else
                            {
                                out.println("Book not issued to the Student due to some problem....");
                                out.println(" ");
                            }
                        }
                        else
                        {
                            out.println("Book with id " + bid + " is not there in Library to issue to Student....");
                            out.println(" ");
                        }
                        break;
                        case 9:
                        out.println("9.Display Student-wise Books.");
                        out.println(" ");
                        v4 = studbservice.getstudentwisebooks();
                        if(v4!=null)
                        {
                            out.println("Books Allocated to Student are as Follows.....");
                            out.println(" ");
                            for(Bookissuemodel bimd : v4)
                            {
                                out.println("Student name is " + bimd.getStudentmodel().getname());
                                out.println("Book Name is " + bimd.getBookmodel().getname());
                                out.println(bimd.getBookmodel().getname() + " belongs to " + bimd.getBookmodel().getCategory() + " Category");
                                out.println(" ");
                            }
                        }
                        else
                        {
                            out.println("No Books are allocated to the Student....");
                            out.println(" ");
                        }
                        break;
                        case 10:
                        out.println("10.Display the Most issue Book.");
                        out.println(" ");
                        bookmap = bis.getmostreadbooks();
                        if(bookmap!=null)
                        {
                            out.println("Most Read Book and it's Count is as follows.....");
                            out.println(" ");
                            for(Map.Entry<String,Integer> entry : bookmap.entrySet())
                            {
                                out.println("Book Name: " + entry.getKey());
                                out.println("Count: " + entry.getValue());
                                out.println(" ");
                            }
                        }
                        else
                        {
                            out.println("There are no books which has been issued highest Time.....");
                            out.println(" ");
                        }
                        break;
                        case 11:
                        out.println("11.Display the Remaining Book After Book issue.");
                        out.println(" ");
                        v4 = bis.getremainingbooks();
                        if(v4!=null)
                        {
                            out.println("Books are there in Library even After Book Issue.....");
                            out.println(" ");
                            for(Bookissuemodel bimd : v4)
                            {
                                out.println("Book id: " + bimd.getBookmodel().getbid());
                                out.println("Book Name: " + bimd.getBookmodel().getname());
                                out.println("Book Category: " + bimd.getBookmodel().getCategory());
                                out.println(" ");
                            }
                        }
                        else
                        {
                            out.println("No Books are there in Library, all Books has been issue to Students....");
                            out.println(" ");
                        }
                        break;
                        case 12:
                        out.println("12.Update the Book Status:");
                        out.println(" ");
                        out.println("Enter the Book Issue Id provided to Student:");
                        issueid = xyz.nextInt();
                        bim.setissueid(issueid);
                            xyz.nextLine();  //Cnsuming newline character
                            out.println("When did the Student Returnded the Book?");
                            returndate = xyz.nextLine();
                            bim.setreturndate(returndate);
                            out.println("Has Student return the Book on time?");
                            msg = xyz.nextLine();
                            if(msg.equals("yes"))
                            {
                                bim.setstatus("Returned");
                            }
                            else if(msg.equals("No"))
                            {
                                out.println("How much Late he had Submitted the Book ?");
                                msg = xyz.nextLine();
                                if(msg.equals("After duedate"))
                                {
                                    bim.setstatus("Overdue");
                                        //Overdue meanins here Book returned by Student after due date
                                }
                            }
                            else
                            {
                                bim.setstatus("Pending");
                            }
                            flag = bis.isbookstatusupdated(bim);
                            if(flag)
                            {
                                out.println("Book Status Updated Successfully.....");
                                out.println(" ");
                            }
                            else
                            {
                                out.println("Book Status Update Failed due to some problem....");
                                out.println(" ");
                            }
                        break;
                        case 13:
                        out.println("13.Send Updates Regarding Book to the Student through Mail.");
                        out.println(" ");
                        xyz.nextLine();  //Consuming newline character
                        v1 = studservice.getstudent();
                        if(v1!=null)
                        {
                            out.println("Students are there in Database to send Updates regading Books.....");
                            out.println(" ");
                            out.println("Enter the Sender Name:");
                            sendername = xyz.nextLine();
                            out.println("Enter the Email Subject:");
                            emailsub = xyz.nextLine();
                            out.println("Enter the Main EMail COntent to inform Student about Book Updates:");
                            emailcont = xyz.nextLine();
                            for(Studentmodel smodel : v1)
                            {
                                EmailSender.sendEmail(sendername, smodel.getemail(), smodel.getname(), emailsub, emailcont);
                                out.println(" ");
                            }
                        }
                        else
                        {
                            out.println("No Students are there in Database So as to send Updates.....");
                            out.println(" ");
                        }
                        break;
                        default:
                        out.println("*****************THANK YOU FOR VISITING*******************");
                        break;
            }
        }while(true);
   }
}