package kln.se.ass2;

import kln.se.ass2.input.Input;
import kln.se.ass2.logfile.Firstreadinglog;
import kln.se.ass2.logfile.Morereadinglog;
import kln.se.ass2.logvariable.Logvariables;
import kln.se.ass2.textcontent.CreateFile;
import kln.se.ass2.textcontent.FileExistence;
import kln.se.ass2.textcontent.ReadLastLine;
import kln.se.ass2.textcontent.Textfile;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class LogAnalyzerApp {
    Textfile textfile;
    Firstreadinglog firstreadinglog;
    Morereadinglog morereadinglog;
    Input input;
    public LogAnalyzerApp(Textfile textfile, Firstreadinglog firstreadinglog, Morereadinglog morereadinglog, Input input)
    {
        this.textfile=textfile;
        this.firstreadinglog=firstreadinglog;
        this.morereadinglog=morereadinglog;
        this.input=input;
    }

    public void show() throws FileNotFoundException {

        String logfilepath=input.readFilepath();

        //Checkinh Log file or other file
        if(logfilepath==null){
            return;
        }

        if (!new FileExistence().isfilecreated()) {
            new CreateFile().createnewfile();
            firstreadinglog.errorchecking(logfilepath);
        }

        else {
            String previoustimestamp = new ReadLastLine().readinglastline();
            List<Logvariables> newlogslist = new ArrayList<Logvariables>();
            newlogslist = morereadinglog.getcurrentlogstates(logfilepath, previoustimestamp);
            if(newlogslist.isEmpty()){
                return ;
            }
            morereadinglog.errorchecking(newlogslist);
        }

    }
}