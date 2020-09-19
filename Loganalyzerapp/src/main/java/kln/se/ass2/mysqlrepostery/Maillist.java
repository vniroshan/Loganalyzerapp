package kln.se.ass2.mysqlrepostery;

import kln.se.ass2.Main;
import kln.se.ass2.mysqlrepostery.Maildata;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Maillist implements Connect {

    public  List<String> getmailaddress(){

         Connect maildata= new Maildata();
        List<String> emails = new ArrayList<String>();
        PreparedStatement st;
        ResultSet rs;
        String query = "SELECT email FROM emailtable";
        try{
            st= maildata.getConnection().prepareStatement(query);
            rs= st.executeQuery();
            while(rs.next()){
                String output = (rs.getString(1));
                emails.add(output);
                System.out.println(output);
            }

        } catch (SQLException ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,ex);
        }
        return emails;
    }
}
