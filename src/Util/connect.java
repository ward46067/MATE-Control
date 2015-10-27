package Util;

import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;

public class connect {
    public static void connect(){
        Controller[] device = ControllerEnvironment.getDefaultEnvironment().getControllers();

        for(int i =0;i<device.length;i++){

            /* Get the name of the controller */
            System.out.println(device[i].getName());
        }
    }
}
