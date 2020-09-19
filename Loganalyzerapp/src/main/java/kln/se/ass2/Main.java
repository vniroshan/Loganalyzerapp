package kln.se.ass2;

import kln.se.ass2.input.CommandLineInput;
import kln.se.ass2.input.Input;
import kln.se.ass2.logfile.Firstreadinglog;
import kln.se.ass2.logfile.Logfilehandler;
import kln.se.ass2.logfile.Morereadinglog;
import kln.se.ass2.logvariable.Log;
import kln.se.ass2.logvariable.Logvariables;
import kln.se.ass2.mail.Mail;
import kln.se.ass2.mail.SendMail;
import kln.se.ass2.textcontent.Textfile;

import java.io.FileNotFoundException;

public class Main {
    
    public static void main(String[] args) throws FileNotFoundException {

//logfilepath = "src\\main\\resources\\example.log";
        Input input=new CommandLineInput();
        Textfile textfile=null;
        Log logvariables=new Logvariables();
        Mail sendMail=new SendMail();
        Firstreadinglog firstreadinglog = new Firstreadinglog(textfile,logvariables,sendMail);
        Logfilehandler logfilehandler = null;
        Morereadinglog morereadinglog = new Morereadinglog(textfile,logvariables,sendMail);


        LogAnalyzerApp app=new LogAnalyzerApp(textfile,firstreadinglog,morereadinglog,input);
        app.show();



    }
}
