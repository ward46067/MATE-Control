package device;

import debug.debug;
import net.java.games.input.Component;
import static util.var.*;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;

public class bind {
    public static void bind(){
        //joystick
        bindJoystick();
        
        //throttle
        bindThrottle();
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
                    if(joystickIdent == Component.Identifier.Button.TRIGGER){
                        boost = pressed;
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
                    float axisValue = joystick.getPollData();
                    
                    //x 
                    if(joystickIdent == Component.Identifier.Axis.X){
                        x = axisValue;
                    }
                    
                    //y 
                    if(joystickIdent == Component.Identifier.Axis.Y){
                        y = axisValue;
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
                    if(throttleIdent == Component.Identifier.Axis.SLIDER){ //i think
                        sensitivity = axisValue;
                    }
                }
            }
            
        } catch(Exception e){
            debug.error("Could not bind throttle keys!");
        }
    }
    
    public static void poll(){
        joystickController.poll();
        throttleController.poll();
    }
}
