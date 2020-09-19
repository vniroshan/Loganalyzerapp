package kln.se.ass2.textcontent;

import java.io.IOException;

public class CreateFile implements Textfile {
    public void createnewfile(){
        try {
            System.out.println("Text file created path is :- "+filepath);
            textfile.createNewFile();
        }
        catch (IOException i){
            System.out.println(i);
        }
    }
}
