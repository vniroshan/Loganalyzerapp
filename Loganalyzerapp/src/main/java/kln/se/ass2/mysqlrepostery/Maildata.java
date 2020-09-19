package kln.se.ass2.mysqlrepostery;


import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Maildata implements Connect {
    private static String servername ="localhost";
    private static String username ="root";
    private static String dbname ="loganalyzerapp";
    private static Integer portnumber = 3306;
    private static String password ="";
    private static Object level;

    public  Connection getConnection() throws SQLException
    {
        Connection sql =null;
        MysqlDataSource datasource = new MysqlDataSource();

        datasource.setServerName(servername);
        datasource.setUser(username);
        datasource.setPassword(password);
        datasource.setDatabaseName(dbname+"?serverTimezone=UTC");
        datasource.setPortNumber(portnumber);

        try{
            sql =datasource.getConnection();
        } catch(SQLException ex){
            Logger.getLogger(" Get Connection -> " + Maildata.class.getName()).log(Level.SEVERE,null,ex);

        }
        return sql;
    }


    @Override
    public List<String> getmailaddress() {
        return null;
    }


}


