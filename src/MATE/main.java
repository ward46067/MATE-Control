package MATE;

//imports
//import Util.setup;

import java.io.IOException;
import robot.Log;

public class main{
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Starting");

        var.log = new Log("MAIN");
        var.log.write("Starting.");
        
        setup.setup();
        
        while(true){
            math.math();
            //GUI.draw.validate();
            //GUI.draw.repaint();
            //System.out.println(var.output());
            var.arduino.write(var.hexOutput());
            //System.out.println(var.output());
            //System.out.println(var.motorE.getValueHex());
            
            GUI.redraw();
            Thread.sleep(20); 
        }
   }
}
