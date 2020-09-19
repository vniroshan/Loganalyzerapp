package kln.se.ass2.mysqlrepostery;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Connect {
      default Connection getConnection() throws SQLException
     {
         return null;
     }

     public List<String> getmailaddress();
}
