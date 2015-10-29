package GUI;

import static Util.var.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import static javax.swing.JFrame.*;

public class GUI {
    public static void GUI(){ //can't be static
        JFrame gui = new JFrame("MATE Control");
        gui.setTitle("MATE Controller");
        gui.getContentPane().add(new paint());
        gui.setSize(width, height+39);
        gui.setVisible(true);
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
        System.out.println("GUI");
    }
}
