package Util;

import static Util.var.*;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import java.io.IOException;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;

public class connect {
    public static void connect() throws IOException{
        log.debug("Connecting to Joystick");
        connectJoystick();
        
        log.debug("Connecting to Arduino");
        connectArduino();
    }
    
    public static void connectArduino() throws IOException {
        log.debug("Connecting to Arduino");
        try{
            portID = CommPortIdentifier.getPortIdentifier("COM3");
            port = (SerialPort) portID.open("Ardiono Uno", 9600);
            
            portOutStream = port.getOutputStream();
            portInStream = port.getInputStream();
            
            log.debug("Connected to Arduino");
            connectedArduino = true;
            
        }catch (NoSuchPortException e) {
            debug.error("No Port Exception!");
            throw new IOException(e.getMessage());
        } catch (PortInUseException e) {
            debug.error("Port in use Exception!");
            throw new IOException(e.getMessage());
        } catch (IOException e) {
            debug.error("Port IOException!");
            port.close();
            throw e;
        }
    }
    
    public static void connectJoystick(){
        device = ControllerEnvironment.getDefaultEnvironment().getControllers();

        for(int i =0;i<device.length;i++){
            log.debug("Found a device: " + device[i].getName());
            
            //connect to joystick
            if(device[i].getName().equals("Saitek Pro Flight X-55 Rhino Stick")){
                log.debug("Found joystick");
                joystick = device[i];
                log.debug("Connected to " + joystick.getName());
                connectedJoystick = true;
            }
            
            //connect to throttle
            if(device[i].getName().equals("Saitek Pro Flight X-55 Rhino Throttle")){
                log.debug("Found throttle");
                throttle = device[i];
                log.debug("Connected to " + throttle.getName());
                connectedThrottle = true;
            }
            
            //check connectedDevice
            if(connectedJoystick && connectedThrottle){
                connectedDevice = true;
            }  
        }
        
        //if couldn't connected to device
        if(!connectedDevice){
           debug.error("Could not find and connect to controller!");
        } else {
            
        }
    }
}
