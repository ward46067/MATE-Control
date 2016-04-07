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
                    
                    //System.out.println(var.motorE.getValueAsAxis());
                    
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
