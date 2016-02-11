package MATE;

import java.awt.Color;
import java.awt.Graphics2D;
import robot.Arduino;
import robot.Joystick;
import robot.Log;

public class var {
    //log
    public static Log log;
    
    public static Joystick joystick;
    public static Arduino arduino;
    
    //x
    public static float x(){
        return joystick.getX();
    }
    
    //z
    public static float z(){
        return joystick.getY();
    }
    
    //y
    public static float y;
    
    //sensitivity
    public static float sensitivity(){
        return joystick.getSlider();
    }
    
    
    //mode 
    int defaultMode = 1;
    
    public static int width = 1200;
    public static int height = 600;
    
    //sensitivity
    public static double minSensitivity = 0.1;
    
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
    
    
}