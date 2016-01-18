/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static util.var.*;

public class arduino {
    public static void begin(){
        restrain();
        
        if(connectedArduino){
            printToArduino();
        }
    }
    
    public static void restrain(){
        //motor1
        if(motor1 > 1){
            motor1 = 1;
        } else if (motor1 < -1){
            motor1 = -1;
        }
        
        //motor2
        if(motor2 > 1){
            motor2 = 1;
        } else if (motor2 < -1){
            motor2 = -1;
        }
    }
    
    public static void printToArduino(){
        String write = 'T' + hexOut();
        
        try {
            portOutStream.write(write.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(arduino.class.getName()).log(Level.SEVERE, null, ex);
            debug.debug.error("Couldn't write to Arduino! Java IOException");
        }
    }
}
