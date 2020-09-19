package kln.se.ass2.textcontent;

import java.io.*;
import java.util.Scanner;

public class ReadLastLine implements Textfile {
    public String readinglastline() throws FileNotFoundException {
        String strLine = null;
        String lastlinestring="";

        try {
            FileInputStream fis = new FileInputStream(filepath);
            DataInputStream dis = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(dis));
            LineNumberReader ln = new LineNumberReader(br);
            Scanner sn= new Scanner(fis);


            while ((strLine = br.readLine()) != null) {
                lastlinestring=strLine;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lastlinestring;
    }

}
