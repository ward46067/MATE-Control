package MATE;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import java.awt.Color;
import java.awt.Graphics2D;
import robot.Arduino;
import robot.Joystick;
import robot.Log;
import robot.Motor;

public class var {
    //log
    public static Log log;
    
    public static Joystick joystick;
    public static Arduino arduino;
    public static Motor motorL, motorR, motorE;
    
    //xyz
    public static float x, y, z;
    
    //sensitivity
    public static float sensitivity(){
        //calculate sensitivity
        float s = joystick.getSlider();
        s *= -1;
        s += 1;
        s /= 2;

        if(s < minSensitivity)
            s = (float)minSensitivity;

        //boost
        if(boost()) {
            s = 1;
        }
        return s;
    }
    
    public static boolean elevationButton(){
        return joystick.getButton(1);
    }
    
    public static float rotation(){
        return joystick.getRotation();
    }
    
    public static boolean boost(){
        return joystick.getButton(0);
    }
    
    public static String output(){
        return arduino.getOutput(hexOutput());
    }
    
    public static String hexOutput(){
        return "" + motorL.getValueHex() + motorR.getValueHex() + motorE.getValueHex();
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
    
    public static Webcam camera;
    public static WebcamPanel cameraPanel;
    
}
