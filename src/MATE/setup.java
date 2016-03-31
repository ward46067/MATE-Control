package MATE;

import robot.Arduino;
import robot.Camera;
import robot.Joystick;
import robot.Motor;
import robot.Servo;

public class setup {
    public static void setup(){
        var.log.write("Connecting to devices.");
        
        //joystick
        var.joystick = new Joystick("Logitech Extreme 3D");
        var.joystick.connect();
        
        //arduino
        var.arduino = new Arduino("Arduino Uno", 115200);
        var.arduino.connect();
        
        //motors
        var.motorL = new Motor("Motor Left");
        var.motorR = new Motor("Motor Right");
        var.motorE = new Motor("Motor Elevation");
        
        //servos
        var.servoClaw = new Servo("Servo Claw");
        var.servoArm = new Servo("Servo Arm");
        
        //cameras
        var.cam1 = new Camera("USB 2.0 PC Cam");
        var.cam2 = new Camera("USB 2.0 PC Cam");
        
        //var.cam1.connect();
        //var.cam2.connect();
        
        math.math();
        GUI.GUI();
        
        var.log.write("Created GUI.");
        
        loop.main();
    }
}
