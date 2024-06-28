package org.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DBConfig 
{
    private static Connection conn;
    private static PreparedStatement pstmt;
    private static ResultSet rs;
    private static DBConfig db = null;
    public static void main(String[] args) 
    {
        new DBConfig();    
    }
    private DBConfig()
    {
        try
        {
            Properties prop = new Properties();
            prop.load(PathHelper.fin);
            String username,password,url,driverclass;
            username = prop.getProperty("db.username");
            url = prop.getProperty("db.url");
            password = prop.getProperty("db.password");
            driverclass = prop.getProperty("driver.classname");
            Class.forName(driverclass);
            conn = DriverManager.getConnection(url, username, password);
            if(conn!=null)
            {
                System.out.println("Database has been Connected.....");
            }
            else
            {
                System.out.println("Database has not been Connected.....");
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public static DBConfig getInstance()
        {
            if(db==null)
            {
                db = new DBConfig();
            }
            return db;
        }
        public static Connection getconnection()
        {
            return conn;
        }
        public static PreparedStatement getstatement()
        {
            return pstmt;
        }
        public static ResultSet getresult()
        {
            return rs;
        }
}
