package GUI;

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
    private static JPanel pan;
    
    public static void GUI(){ //can't be static
        gui = new JFrame("MATE Control");
        gui.setTitle("MATE Controller");
        gui.getContentPane().add(new paint());
        pan = (JPanel) gui.getContentPane();
        gui.setSize(width, height+39);
        gui.setVisible(true);
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void refresh(){
        new Thread(){
            public void run(){
                int r = 1;
                while(r == 1){
                    pan.validate();
                    pan.repaint();
                    try {
                        Thread.sleep(16);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }.start();
        
    }
}
