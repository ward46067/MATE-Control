package src;

//imports
import net.java.games.input.*;

public class Main{
    
    public static void main(String[] args) {
         Controller[] ca = ControllerEnvironment.getDefaultEnvironment().getControllers();

        for(int i =0;i<ca.length;i++){

            /* Get the name of the controller */
            System.out.println(ca[i].getName());
    }
   }
}
