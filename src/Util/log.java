package Util;

import static Util.var.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class log {
    
    private static PrintWriter outputlog;
    private static PrintWriter debuglog;
    private static PrintWriter motor1log;
    private static PrintWriter motor2log;
    private static PrintWriter motor3log;
    private static PrintWriter motor4log;
    
    private static File outputlogFile = new File("logs\\outputlog.txt");
    private static File debuglogFile = new File("logs\\debuglog.txt");
    private static File motor1logFile = new File("logs\\motor1log.txt");
    private static File motor2logFile = new File("logs\\motor2log.txt");
    private static File motor3logFile = new File("logs\\motor3log.txt");
    private static File motor4logFile = new File("logs\\motor4log.txt");

    public static void createLog() throws FileNotFoundException, UnsupportedEncodingException {
        outputlogFile.getParentFile().mkdirs();
        debuglogFile.getParentFile().mkdirs();
        motor1logFile.getParentFile().mkdirs();
        motor2logFile.getParentFile().mkdirs();
        motor3logFile.getParentFile().mkdirs();
        motor4logFile.getParentFile().mkdirs();
        
        outputlog = new PrintWriter(outputlogFile, "UTF-8");
        debuglog = new PrintWriter(debuglogFile, "UTF-8");
        motor1log = new PrintWriter(motor1logFile, "UTF-8");
        motor2log = new PrintWriter(motor2logFile, "UTF-8");
        motor3log = new PrintWriter(motor3logFile, "UTF-8");
        motor4log = new PrintWriter(motor4logFile, "UTF-8");
        debug("Starting");
        debug("Created logs");
    }
    
    public static void debug(String text){
        debuglog.println(logDateTimeMillis() + text); 
        debuglog.flush();
    }
    
    public static void log(){
        outputlog.println(logDateTime() + 'T' + var.hexOut());
        motor1log.println(logDateTime() + "1, " + servo1 + ", " + motor1 + " PWM Signal: " + m1);
        motor2log.println(logDateTime() + "1, " + servo2 + ", " + motor2 + " PWM Signal: " + m2);
        motor3log.println(logDateTime() + "1, " + servo3 + ", " + motor3 + " PWM Signal: " + m3);
        motor4log.println(logDateTime() + "1, " + servo4 + ", " + motor4 + " PWM Signal: " + m4);
        
        outputlog.flush();
        motor1log.flush();
        motor2log.flush();
        motor3log.flush();
        motor4log.flush();
        
        //debug("Logged");
    }
    
}
