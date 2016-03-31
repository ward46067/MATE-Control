package MATE;

//imports
//import Util.setup;

import java.io.IOException;
import robot.Log;

public class main{
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Starting");

        var.log = new Log("MAIN");
        var.log.write("Starting.");
        
        setup.setup();
   }
}
