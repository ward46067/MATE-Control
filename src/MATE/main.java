package MATE;

//imports
//import Util.setup;

import java.io.IOException;
import robot.Arduino;
import robot.Joystick;
import robot.Log;

public class main{
    public static void main(String[] args) throws IOException {
        System.out.println("Starting");

        var.log = new Log("MAIN");
        var.log.write("Starting.");
        var.log.write("Connecting to devices.");
        
        //joystick
        var.joystick = new Joystick("Logitech Extreme 3D");
        var.joystick.connect();
        
        //arduino
        var.arduino = new Arduino("Arduino Uno", "COM3", 115200);
        var.arduino.connect();

        color.colorRead();
        color.colorSet();
        GUI.GUI();
        
        var.log.write("Created GUI.");
   }
}
