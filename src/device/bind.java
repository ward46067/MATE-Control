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
        //joystick
        bindJoystick();
        
        //nath
        math.math();
    }
    
    public static void bindJoystick(){
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
                if(joystickIdent == Component.Identifier.Button._0){
                    boost = pressed;
                    //JOptionPane.showMessageDialog(null, "Trigger");
                }

                //elevation
                if(joystickIdent == Component.Identifier.Button._1){
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
                //float axisValue = var.getAxisValueInPercentage(axisValueFloat);
                
                //x 
                if(joystickIdent == Component.Identifier.Axis.X){
                    x = axisValue;
                    //System.out.println(x);
                    continue;
                }

                //y 
                if(joystickIdent == Component.Identifier.Axis.Y){
                    z = axisValue;
                    continue;
                }
                
                //sensitivity
                if(joystickIdent == Component.Identifier.Axis.SLIDER){
                    sensitivity = axisValue;
                    continue;
                }
                
                //rotation
                if(joystick.getName().equals("Z Rotation")){
                    rotation = axisValue;
                    continue;
                }
            }
        } 
    }
    
    public static void poll(){
        if(!joystickController.poll()){
            debug.error("Joystick disconnected");
        }
    }
}
