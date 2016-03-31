package MATE;

import java.util.logging.Level;
import java.util.logging.Logger;

public class loop {
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
                        var.log.Error("Loop failed");
                        Logger.getLogger(loop.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }.start();
    }
}
