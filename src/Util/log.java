package Util;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class log {
    
    public static PrintWriter outputlog;
    public static PrintWriter debuglog;
    public static PrintWriter motor1log;
    public static PrintWriter motor2log;
    public static PrintWriter motor3log;
    public static PrintWriter motor4log;

    public static void createLog() throws FileNotFoundException, UnsupportedEncodingException {
        outputlog = new PrintWriter("logs/outputlog.txt", "UTF-8");
        debuglog = new PrintWriter("logs/outputlog.txt", "UTF-8");
        motor1log = new PrintWriter("logs/outputlog.txt", "UTF-8");
        motor2log = new PrintWriter("logs/outputlog.txt", "UTF-8");
        motor3log = new PrintWriter("logs/outputlog.txt", "UTF-8");
        motor4log = new PrintWriter("logs/outputlog.txt", "UTF-8");
    }
    
    public static void debuglog(String text){
        debuglog.println(var.logDateTime() + text); 
    }
    
    public static void log(){
        outputlog.println(var.logDateTime() + var.hexOut());
        
    }
    
}
