package MATE;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JFrame;
import static javax.swing.JFrame.*;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class GUI {
    
    private static JFrame gui;
    public static JPanel panel;
    public static JInternalFrame drawFrame, camFrame;
    public static JPanel draw;
    public static JPanel camPanel;
    public static JPanel camera;
    public static TransparentPanel camTop, camBottom;
    
    public static void GUI(){ 
        var.log.write("Creating GUI");
        
        //gui 
        gui = new JFrame("MATE Control");
        gui.setTitle("MATE Controller");
        gui.setSize(var.width, var.height+39);
        gui.setVisible(true);
        gui.setResizable(false);
        gui.show();
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //draw frame
        drawFrame = new JInternalFrame("Data");
        drawFrame.setTitle("Data");
        drawFrame.setSize(var.width, var.height+39);
        drawFrame.setVisible(false);
        drawFrame.setResizable(false);
        drawFrame.show();
        
        //cam frame
        camFrame = new JInternalFrame("Cam");
        camFrame.setSize(320, 240);
        camFrame.setVisible(true);
        camFrame.setResizable(false);
        camFrame.show();
        camFrame.pack();
        
        
        panel = new JPanel(new BorderLayout());
        camPanel = new JPanel(new BorderLayout());
        camTop = new TransparentPanel();
        camBottom = new TransparentPanel();
        
        drawFrame.getContentPane().add(new paint());
        draw = (JPanel) drawFrame.getContentPane();
        
        camTop.setSize(320, 220);
        camBottom.setSize(320, 220);
        
        
        //add panels
        gui.add(panel);
        
        panel.add(draw);
        panel.add(camPanel, BorderLayout.EAST);
        
        camPanel.add(camTop, BorderLayout.PAGE_START);
        camPanel.add(var.cameraPanel);
        camPanel.add(camBottom, BorderLayout.PAGE_END);
        
        //camFrame.add(var.cameraPanel);
    }
}

class TransparentPanel extends JPanel {
    {
        setOpaque(false);
    }
    public void paintComponent(Graphics g) {
        g.setColor(getBackground());
        Rectangle r = g.getClipBounds();
        g.fillRect(r.x, r.y, r.width, r.height);
        super.paintComponent(g);
    }
}
