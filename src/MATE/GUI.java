package MATE;

import java.awt.BorderLayout;
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
    public static JPanel camTop, camBottom;
    
    public static void GUI(){ 
        var.log.write("Creating GUI");
        
        //gui 
        gui = new JFrame("MATE Control");
        gui.setTitle("MATE Controller");
        //gui.getContentPane().add(new paint()); //needed
        gui.setSize(var.width, var.height + 30);
        gui.setVisible(true);
        gui.setResizable(false);
        gui.show();
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //draw frame
        drawFrame = new JInternalFrame("draw");
        drawFrame.setSize(var.width, var.height+30);
        drawFrame.setVisible(true);
        drawFrame.setResizable(true);
        drawFrame.show();
        drawFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        drawFrame.getContentPane().add(new paint());
        draw = (JPanel) drawFrame.getContentPane();
        
        //cam frame
        camFrame = new JInternalFrame("cam");
        camFrame.setSize(320, 240);
        camFrame.setVisible(true);
        camFrame.setResizable(false);
        camFrame.show();
        
        //create panels
        panel = new JPanel(new BorderLayout());
        camPanel = new JPanel(new BorderLayout());
        camTop = new JPanel();
        camBottom = new JPanel();
        camera = new JPanel();
        
        //add panels
        gui.add(panel);
        
        panel.add(drawFrame, BorderLayout.WEST);
        panel.add(camPanel, BorderLayout.EAST);
        
        camPanel.add(camTop, BorderLayout.LINE_START);
        camPanel.add(camera, BorderLayout.CENTER);
        camPanel.add(camBottom, BorderLayout.LINE_END);
        
        camFrame.add(var.cameraPanel);
        camera.add(camFrame);
        
    }
}
