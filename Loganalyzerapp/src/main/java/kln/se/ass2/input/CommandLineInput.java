package kln.se.ass2.input;

import java.util.Scanner;

public class CommandLineInput implements Input {

    //Checkinh Log file or other file
    @Override
    public String readFilepath() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter log file path");
        String logfilepath = input.nextLine();
        if(logfilepath.contains(".log")){
             return logfilepath;}
        System.out.println("Program Terminated: It is not a Logfile");
          return null;

    }
}
