package GUI;

import static Util.var.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class paint extends JPanel{
    paint(){  
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBoard((Graphics2D) g);
    }

    private void drawBoard(Graphics2D d) {
        draw.draw(d);
        
    }
    
}
    
