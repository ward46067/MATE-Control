package util;

import debug.log;
import GUI.GUI;
import static GUI.GUI.pan;
import java.util.logging.Level;
import java.util.logging.Logger;
import debug.log.*;
import static debug.log.debug;
import device.bind;
import java.io.PrintWriter;
import static util.var.connectedDevice;

public class loop {

    public static void gui(){
        
        log.debug("Creating new Thread for GUI");
        
        new Thread(){
            
            public void run(){
                
                //log.debug("Thread created");
                //log.debug("Starting loop");
                while(true){
                    
                    //screen refresh
                    pan.validate();
                    pan.repaint();
                    
                    //log
                    log.log();
                    try {
                        Thread.sleep(16);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }.start();
        log.debug("GUI loop sucessful");
    }
    
    
    public static void poll(){
        log.debug("Creating new thread to poll device values");
        
        new Thread(){
            public void run(){
                while(true){
                    if(connectedDevice){
                        bind.bind();
                    }
                }
            }
        }.start();
        log.debug("Poll loop sucessful");
    }

}
