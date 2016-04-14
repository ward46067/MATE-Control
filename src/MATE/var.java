package MATE;

import com.ward.Console;
import robot.Arduino;
import robot.Camera;
import robot.Joystick;
import robot.Log;
import robot.Motor;
import robot.Servo;

public class var {
    //log
    public static Log log;
    
    public static Joystick joystick;
    public static Arduino arduino;
    public static Motor motorL, motorR, motorE;
    public static Servo servoClaw, servoArm;
    public static Camera cam1, cam2;
    public static Console debugCon;
    
    //xyz
    public static float x = 0, y = 0, z = 0;
    public static Camera cam3;
    
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
    
    //mode 
    int defaultMode = 1;
    
    public static int width = 1200;
    public static int height = 600;
    
    //sensitivity
    public static double minSensitivity = 0.1;
}
