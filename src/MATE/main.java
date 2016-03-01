package MATE;

//imports
//import Util.setup;

import java.io.IOException;
import robot.Arduino;
import robot.Joystick;
import robot.Log;
import robot.Motor;

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
        var.motorL = new Motor("Motor Left");
        var.motorR = new Motor("Motor Right");
        var.motorE = new Motor("Motor Elevation");

        color.colorRead();
        color.colorSet();
        math.math();
        GUI.GUI();
        
        var.log.write("Created GUI.");
        
        while(true){
            math.math();
            GUI.pan.validate();
            GUI.pan.repaint();
            //System.out.println(var.output());
            var.arduino.write(var.hexOutput());
            System.out.println(var.output());
            //System.out.println(var.motorE.getValueHex());
            Thread.sleep(20); 
        }
   }
}
