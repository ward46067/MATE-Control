package MATE;

//imports
//import Util.setup;

import com.ward.Console;
import java.io.IOException;
import robot.*;

public class main{
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Starting");
        
        var.debugCon = new Console();
        var.debugCon.build(500, 500, "Debug Console");

        var.log = new Log("MAIN", true);
        
        var.log.write("Connecting to devices.");
        
        //joystick
        var.joystick = new Joystick("Logitech Extreme 3D");
        var.log.write("Connecting to Joystick.");
        //var.joystick.connect();
        var.log.write("Connected to Joystick.");
        
        //arduino
        var.arduino = new Arduino("Arduino Uno", 115200);
        var.log.write("Connecting to Arduino.");
        //var.arduino.connect();
        var.log.write("Connected to Arduino.");
        
        //motors
        var.motorL = new Motor("Motor Left", 2, var.arduino);
        var.motorR = new Motor("Motor Right", 3, var.arduino);
        var.motorE = new Motor("Motor Elevation", 4, var.arduino);
        
        //var.motorL.setReverse(true);
        //var.motorR.setReverse(true);
        var.motorE.setReverse(true);
        
        //servos
        var.servoClaw = new Servo("Servo Claw", 5, var.arduino);
        var.servoArm = new Servo("Servo Arm", 6, var.arduino);
        
        //cameras
        var.cam1 = new Camera("USB 2.0 PC Cam");
        var.cam2 = new Camera("USB 2.0 PC Cam");
        var.cam3 = new Camera("USB 2.0 PC Cam");
        
        var.log.write("Connecting to Cam1.");
        var.cam1.connect();
        var.log.write("Connecting to Cam2.");
        var.cam2.connect();
        var.log.write("Connecting to Cam3.");
        var.cam3.connect();
        
        var.cam1.displayFPS(true);
        var.cam2.displayFPS(true);
        var.cam3.displayFPS(true);
        
        if(!var.joystick.isConnected() || !var.arduino.isConnected()){
            var.log.crtError("Not all required devices found, exiting.");
            //System.exit(1);
        }
        GUI.GUI();
        
        loop.main();
        
        var.arduino.startWrite();
        
        var.log.write("Running.");
   }
}
