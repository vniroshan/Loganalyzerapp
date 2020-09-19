package kln.se.ass2.textcontent;

public class FileExistence implements Textfile {
    public Boolean isfilecreated(){

        if(textfile.exists()){
            return true;
        }
        else{
            return false;
        }
    }
}
