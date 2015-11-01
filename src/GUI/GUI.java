package GUI;

import Util.log;
import static Util.var.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import static javax.swing.JFrame.*;
import javax.swing.JPanel;

public class GUI {
    
    private static JFrame gui;
    public static JPanel pan;
    
    public static void GUI(){ 
        log.debug("Creating GUI");
        guiTimeMillis = millis();
        
        gui = new JFrame("MATE Control");
        gui.setTitle("MATE Controller");
        gui.getContentPane().add(new paint());
        pan = (JPanel) gui.getContentPane();
        gui.setSize(width, height+39);
        gui.setVisible(true);
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
