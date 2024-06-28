package org.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBHelper 
{
    protected DBConfig db = DBConfig.getInstance();
    protected Connection conn = DBConfig.getconnection();
    protected PreparedStatement pstmt = DBConfig.getstatement();
    protected ResultSet rs = DBConfig.getresult();
}
