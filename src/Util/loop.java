package Util;

import GUI.GUI;
import static GUI.GUI.pan;
import java.util.logging.Level;
import java.util.logging.Logger;
import Util.log.*;
import static Util.log.debug;
import java.io.PrintWriter;

public class loop {

    public static void loop(){
        
        log.debug("Creating new Thread for loop");
        
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
        log.debug("Loop sucessful");
    }

}
