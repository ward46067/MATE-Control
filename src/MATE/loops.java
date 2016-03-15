package MATE;

import java.util.logging.Level;
import java.util.logging.Logger;

public class loops {
    public static void claw(){
        new Thread(){
            public void run(){
                int deg = 90; //starting degree
                while(true){
                    if(var.joystick.getHatSwitch()[3]){ //right
                        deg++;
                        
                    }
                    if(var.joystick.getHatSwitch()[7]){ //left
                        deg--;
                    }
                    
                    if(deg < 0){
                        deg = 0;
                    } 

                    if(deg > 180){
                        deg = 180;
                    }
                    
                    var.servoClaw.setValue(deg);
                    
                    
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(loops.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
        }.start();
    }
    
    public static void arm(){
        new Thread(){
            public void run(){
                    int deg = 90; //starting degree
                while(true){
                    if(var.joystick.getHatSwitch()[1]){ //up
                        deg++;
                        
                    }
                    if(var.joystick.getHatSwitch()[5]){//down
                        deg--;
                    }
                    
                    if(deg < 0){
                        deg = 0;
                    } 

                    if(deg > 180){
                        deg = 180;
                    }
                    
                    var.servoArm.setValue(deg);
                    
                    
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(loops.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
        }.start();
    }
    
    public static void main(){
        new Thread(){
            public void run(){
                while(true){
                    math.math();
                    GUI.redraw();
                    
                    var.arduino.write(
                              var.motorL.getValueHex()
                            + var.motorR.getValueHex()
                            + var.motorE.getValueHex()
                            + var.servoClaw.getValueHex()
                            + var.servoArm.getValueHex()
                    );
                    
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(loops.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }.start();
    }
}
