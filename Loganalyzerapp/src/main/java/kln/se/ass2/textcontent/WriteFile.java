package kln.se.ass2.textcontent;

import java.io.FileWriter;

public class WriteFile implements Textfile{
    public void writetofile(String currenttimestamp){

        try {
            FileWriter fw = new FileWriter(filepath,true);
            fw.write("\n"+currenttimestamp);
            fw.close();
            System.out.println("Current Timestamp notted to text file");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
