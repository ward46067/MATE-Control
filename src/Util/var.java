package util;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.java.games.input.Component;
import net.java.games.input.Component.Identifier;
import net.java.games.input.Controller;

public class var {
    //robot
    public static double motor1 = 1;
    public static double motor2 = 1;
    public static double motor3 = 1;
    public static double motor4 = 1;

    public static double motor1x = 0;
    public static double motor2x = 0;
    public static double motor3x = 0;
    public static double motor4x = 0;

    public static double motor1z = 0;
    public static double motor2z = 0;
    public static double motor3z = 0;
    public static double motor4z = 0;

    public static double servo1 = 180;
    public static double servo2 = 90;
    public static double servo3 = 90;
    public static double servo4 = 90;

    //arduino 
    public static int m1 = 254, m2 = 127, m3 = 127, m4 = 127, s1 = 180, s2 = 90, s3 = 90, s4 = 90;

    //mode 
    int defaultMode = 1;

    //display 
    public static float x;
    public static float y;
    public static float z;
    public static float sensitivity;
    public static float rotation;
    public static float mode;
            
    public static boolean boost, elevationButton;
    
    public static int width = 1200;
    public static int height = 600;
    
    //sensitivity
    public static double minSensitivity = 0.1;
    
    //sending to arduino
    public static long lastSend;
    
    public static String hexOut(){
        return Integer.toHexString(m1) 
                + Integer.toHexString(m2)
                + Integer.toHexString(m3)
                + Integer.toHexString(m4)
                
                + Integer.toHexString(s1)
                + Integer.toHexString(s2)
                + Integer.toHexString(s3)
                + Integer.toHexString(s4);
    }
    
    public static String dateTime(){
        return date() + " " + time();
    }
    
    public static String time(){
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
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
    
    public static String logDateTimeMillis(){
        long millis = System.currentTimeMillis() % 1000;
        return dateTime() + "::" + millis + "--> ";
    }
    
    public static long millis(){
        return System.currentTimeMillis();
    }
    
    //xml colors 
    public static int[][][] colorPalette = new int[4][5][3];

    //colors
    public static Color colorText;

    public static Color colorBackground;

    public static Color colorBarInfo;
    public static Color colorBarBackground;

    public static Color colorTitleBackground;

    public static Color colorMotorBackground;
    public static Color colorMotorBackgroundSS;

    public static Color colorDebugBackground;
    public static Color colorDebugText;

    public static Color colorButton;
    public static Color colorButtonHover;
    public static Color colorButtonSelected;
    
    public static int stringW(String text, Graphics2D d){
        return (int) d.getFontMetrics().getStringBounds(text, d).getWidth();
    }
    
    public static int stringH(String text, Graphics2D d){
        return (int) d.getFontMetrics().getStringBounds(text, d).getHeight();
    }
    
    public static long guiTimeMillis;
    
    //Arduino
    public static CommPortIdentifier portID;
    public static SerialPort port;
    public static OutputStream portOutStream;
    public static InputStream portInStream;
    public static boolean connectedArduino = false;
    
    //joystick & throttle
    public static Controller[] device;
    public static Controller joystickController;
    public static Controller throttleController;
    
    public static Component[] joystickComponent;
    public static Component[] throttleComponent;
    
    public static Component joystick;
    public static Component throttle;
    
    public static Identifier joystickIdent;
    public static Identifier throttleIdent;
    
    public static boolean connectedDevice = false;
    public static boolean connectedJoystick = false;
    public static boolean connectedThrottle = false;
}
