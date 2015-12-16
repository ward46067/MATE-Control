package MATE;

//imports
//import Util.setup;
import Util.setup;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.java.games.input.*;

public class main{
    
    public static void main(String[] args) throws IOException {
        System.out.println("Starting");
        try {
            setup.setup();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
}
