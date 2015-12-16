package device;

import debug.debug;
import debug.log;
import static util.var.*;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import java.io.IOException;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;

public class connect {
    public static void connect() throws IOException{
        
        connectJoystick();
        
        log.debug("Connecting to Arduino");
        connectArduino();
    }
    
    public static void connectArduino() throws IOException {
        log.debug("Connecting to Arduino");
        try{
            portID = CommPortIdentifier.getPortIdentifier("COM5"); //change com
            port = (SerialPort) portID.open("Ardiono Uno", 9600);
            
            portOutStream = port.getOutputStream();
            portInStream = port.getInputStream();
            
            log.debug("Connected to Arduino");
            connectedArduino = true;
            
        }catch (NoSuchPortException e) {
            debug.error("No port exception! Looks like the arduino isn't plugged in.");
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
        log.debug("Connecting to Joystick and Throttle");
        
        for (int i = 0; i < device.length; i++) {
            //log.debug("Found a device: " + device[i].getName());
            
            //connect to joystick
            if (device[i].getName().equals("Logitech Extreme 3D") && !connectedJoystick) {
                log.debug("Found joystick");
                joystickController = device[i];
                log.debug("Connected to " + joystickController.getName());
                joystickComponent = joystickController.getComponents();
                log.debug("Joystick has " + joystickComponent.length + " components");
                if(!(joystickComponent.length == 0)){
                    connectedJoystick = true;
                }
            }
            if(connectedJoystick){
                log.debug("Connected to Joystick");
            }
        }
        if(!connectedJoystick){
            debug.error("Could not connect to the Joystick");
        }
    }
}
