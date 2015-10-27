package Util;

import static Util.var.*;
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
        debuglog.println(logDateTime() + text); 
    }
    
    public static void log(){
        outputlog.println(logDateTime() + var.hexOut());
        motor1log.println(logDateTime() + "1, " + servo1 + ", " + motor1 + " PWM Signal: " + m1);
        motor2log.println(logDateTime() + "1, " + servo2 + ", " + motor2 + " PWM Signal: " + m2);
        motor3log.println(logDateTime() + "1, " + servo3 + ", " + motor3 + " PWM Signal: " + m3);
        motor4log.println(logDateTime() + "1, " + servo4 + ", " + motor4 + " PWM Signal: " + m4);
    }
    
}
