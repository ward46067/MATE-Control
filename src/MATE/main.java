package MATE;

//imports
import net.java.games.input.*;

public class main{
    
    public static void main(String[] args) {
         Controller[] ca = ControllerEnvironment.getDefaultEnvironment().getControllers();

        for(int i =0;i<ca.length;i++){

            /* Get the name of the controller */
            System.out.println(ca[i].getName());
    }
   }
}
