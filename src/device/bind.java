package device;

import debug.debug;
import javax.swing.JOptionPane;
import math.math;
import net.java.games.input.Component;
import util.var;
import static util.var.*;
import static util.var.joystickComponent;
import static util.var.joystickIdent;

public class bind {
    public static void bind(){
        poll();
        //joystick
        //bindJoystick();
        
        //throttle
        bindThrottle();
        
        //nath
        math.math();
    }
    
    public static void bindJoystick(){
        try{
            for(int i = 0; i < joystickComponent.length; i++){
                joystick = joystickComponent[i];
                joystickIdent = joystick.getIdentifier();
                
                //buttons
                if(joystick.getName().contains("Button")){
                    boolean pressed;
                    
                    if(joystick.getPollData() == 0.0f){
                        pressed = false;
                    } else {
                        pressed = true;
                    } 
                    
                    //boost
                    if(joystickIdent == Component.Identifier.Button._1){
                        boost = pressed;
                        //JOptionPane.showMessageDialog(null, "Trigger");
                    }
                    
                    //elevation
                    if(joystickIdent == Component.Identifier.Button.PINKIE){
                        elevationButton = pressed;
                    }
                }
                
                //hat switch
                if(joystickIdent == Component.Identifier.Axis.POV){
                    //not planning on using hat switch, so continue
                    continue;
                }
                
                //Axis
                if(joystick.isAnalog()){
                    float axisValueFloat = joystick.getPollData();
                    float axisValue = var.getAxisValueInPercentage(axisValueFloat);
                    
                    //x 
                    if(joystickIdent == Component.Identifier.Axis.X){
                        x = axisValue;
                        continue;
                    }
                    
                    //y 
                    if(joystickIdent == Component.Identifier.Axis.Y){
                        y = axisValue;
                        continue;
                    }
                }
            }
        } catch(Exception e){
            debug.error("Could not bind joystick keys!");
        }
    }
    
    public static void bindThrottle(){
        try {
            for(int i = 0; i < throttleComponent.length; i++){
                throttle = throttleComponent[i];
                throttleIdent = throttle.getIdentifier();
                
                //buttons
                if(joystick.getName().contains("Button")){
                    boolean pressed;
                    
                    if(joystick.getPollData() == 0.0f){
                        pressed = false;
                    } else {
                        pressed = true;
                    }
                    continue;
                }
                
                //hat switch
                if(throttleIdent == Component.Identifier.Axis.POV){
                    //not planning on using hatswitch, so continue
                    continue;
                }
                
                //axis
                if(throttle.isAnalog()){
                    float axisValue = throttle.getPollData();
                    
                    //sensitivity
                    if(throttleIdent == Component.Identifier.Axis.X){ //i think
                        sensitivity = axisValue;
                        System.out.println(sensitivity);
                    }
                }
            }
            
        } catch(Exception e){
            debug.error("Could not bind throttle keys!");
        }
    }
    
    public static void poll(){
        if(!joystickController.poll()){
            debug.error("Joystick disconnected");
        }
        
        if(!throttleController.poll()){
            debug.error("Throttle disconnected");
        }
    }
}
