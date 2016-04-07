package MATE;

//imports
//import Util.setup;

import java.io.IOException;
import robot.*;

public class main{
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Starting");

        var.log = new Log("MAIN");
        var.log.write("Starting.");
        
        var.log.write("Connecting to devices.");
        
        //joystick
        var.joystick = new Joystick("Logitech Extreme 3D");
        var.joystick.connect();
        
        //arduino
        var.arduino = new Arduino("Arduino Uno", 115200);
        var.arduino.connect();
        
        //motors
        var.motorL = new Motor("Motor Left", 2, var.arduino);
        var.motorR = new Motor("Motor Right", 3, var.arduino);
        var.motorE = new Motor("Motor Elevation", 4, var.arduino);
        
        var.motorL.setReverse(true);
        var.motorR.setReverse(true);
        var.motorE.setReverse(true);
        
        //servos
        var.servoClaw = new Servo("Servo Claw", 5, var.arduino);
        var.servoArm = new Servo("Servo Arm", 6, var.arduino);
        
        //cameras
        var.cam1 = new Camera("USB 2.0 PC Cam");
        var.cam2 = new Camera("USB 2.0 PC Cam");
        
        //var.cam1.connect();
        //var.cam2.connect();
        
        if(!var.joystick.isConnected() || !var.arduino.isConnected()){
            var.log.crtError("Not all required devices found, exiting.");
            System.exit(1);
        }
        
        math.math();
        GUI.GUI();
        
        var.arduino.startWrite();
        
        var.log.write("Created GUI.");
        
        loop.main();
   }
}
