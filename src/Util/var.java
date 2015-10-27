package Util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import static processing.core.PApplet.hex;
import processing.data.XML;

public class var {
    //robot
    public static double motor1 = 0;
    public static double motor2 = 0;
    public static double motor3 = 0;
    public static double motor4 = 0;

    public static double motor1x = 0;
    public static double motor2x = 0;
    public static double motor3x = 0;
    public static double motor4x = 0;

    public static double motor1z = 0;
    public static double motor2z = 0;
    public static double motor3z = 0;
    public static double motor4z = 0;

    public static double servo1 = 0;
    public static double servo2 = 0;
    public static double servo3 = 0;
    public static double servo4 = 0;

    //arduino 
    public static int m1, m2, m3, m4, s1, s2, s3, s4;

    //mode 
    int defaultMode = 1;

    //display 
    public static float x, y, z, sensitivity, boost, rotation, elevationButton, mode;
    
    public static int width = 1200;
    public static int height = 600;
    
    //sensitivity
    public static double minSensitivity = 0.1;
    
    //sending to arduino
    public static long lastSend;
    
    //connect
    boolean connectedDevice = false;
    boolean connectedJoystick = false;
    boolean connectedThrottle = false;
    boolean connectedArduino = false;
    
    public static String hexOut(){
        return hex(m1,2) + hex(m2,2) + hex(m3,2) + hex(m4,2) + hex(s1,2) + hex(s3,2) + hex(s3,2) + hex(s4,2);
    }
    
    public static String dateTime(){
        return date() + " " + time();
    }
    
    public static String time(){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
    
    public static String date(){
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }
    
    public static String logDateTime(){
        return dateTime() + " --> ";
    }
    
    //XML
    public static XML colorXML;
    
    
    public static XML[] colorset;
    public static XML[] colorsetChild;


    public static String xmlID;
    public static String paletteURL;
    public static XML xmlURL;

    //xml colors 
    public static int[][][] colorPalette = new int[4][5][3];

    //colors
    public static int[] colorText = new int[3];

    public static int[] colorBackground = new int[3];

    public static int[] colorBarInfo = new int[3];
    public static int[] colorBarBackground = new int[3];

    public static int[] colorTitleBackground = new int[3];

    public static int[] colorMotorBackground = new int[3];
    public static int[] colorMotorBackgroundSS = new int[3];

    public static int[] colorDebugBackground = new int[3];
    public static int[] colorDebugText = new int[3];

    public static int[] colorButton = new int[3];
    public static int[] colorButtonHover = new int[3];
    public static int[] colorButtonSelected = new int[3];
}
