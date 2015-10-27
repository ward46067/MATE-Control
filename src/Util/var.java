package Util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import static processing.core.PApplet.hex;
import processing.data.XML;

public class var {
    //robot
    double motor1 = 0;
    double motor2 = 0;
    double motor3 = 0;
    double motor4 = 0;

    double motor1x = 0;
    double motor2x = 0;
    double motor3x = 0;
    double motor4x = 0;

    double motor1z = 0;
    double motor2z = 0;
    double motor3z = 0;
    double motor4z = 0;

    double servo1 = 0;
    double servo2 = 0;
    double servo3 = 0;
    double servo4 = 0;

    //arduino 
    static int m1, m2, m3, m4, s1, s2, s3, s4;

    //mode 
    int defaultMode = 1;

    //display 
    float x, y, z, sensitivity, boost, rotation, elevationButton, mode;
    
    int width = 1200;
    int height = 600;
    
    //sensitivity
    double minSensitivity = 0.1;
    
    //sending to arduino
    long lastSend;
    
    //connect
    boolean connectedDevice = false;
    boolean connectedJoystick = false;
    boolean connectedThrottle = false;
    boolean connectedArduino = false;
    
    static String hexOut(){
        return hex(m1,2) + hex(m2,2) + hex(m3,2) + hex(m4,2) + hex(s1,2) + hex(s3,2) + hex(s3,2) + hex(s4,2);
    }
    
    static String dateTime(){
        return date() + " " + time();
    }
    
    static String time(){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
    
    static String date(){
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }
    
    static String logDateTime(){
        return dateTime() + " --> ";
    }
    
    //XML
    XML colorXML;
    
    XML[] colorset;
    XML[] colorsetChild;


    String xmlID;
    String paletteURL;
    XML xmlURL;

    //xml colors 
    int[][][] colorPalette = new int[4][5][3];

    //colors
    int[] colorText = new int[3];

    int[] colorBackground = new int[3];

    int[] colorBarInfo = new int[3];
    int[] colorBarBackground = new int[3];

    int[] colorTitleBackground = new int[3];

    int[] colorMotorBackground = new int[3];
    int[] colorMotorBackgroundSS = new int[3];

    int[] colorDebugBackground = new int[3];
    int[] colorDebugText = new int[3];

    int[] colorButton = new int[3];
    int[] colorButtonHover = new int[3];
    int[] colorButtonSelected = new int[3];
}
