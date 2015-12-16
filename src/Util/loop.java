package util;

import static util.var.*;
import debug.log;
import GUI.GUI;
import static GUI.GUI.pan;
import Util.arduino;
import java.util.logging.Level;
import java.util.logging.Logger;
import debug.log.*;
import debug.debug;
import device.bind;
import java.io.PrintWriter;
import math.math;

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
                    
                    //math
                    //math.math();
                    
                    //log
                    log.log();
                    
                    //print to arduino
                    arduino.begin();
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
                    if(!joystickController.poll()){
                        debug.error("Couldn't pool Joystick");
                        //System.out.println("Couldn't poll Joystick");
                        break;
                    }

                    bind.bind();
                    
                    try {
                        Thread.sleep(16);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(loop.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }.start();
        log.debug("Poll loop sucessful");
    }

}
