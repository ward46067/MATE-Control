package MATE;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import static javax.swing.JFrame.*;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class GUI {
    
    private static JFrame gui;
    private static JPanel panel, 
            data, 
            info, 
            camera,
            xygraph, 
            xypanel, 
            title, 
            rotpanel, 
            senspanel, 
            infoRight,
            infoLeft,
            infoMid,
            leftTop,
            leftBottom,
            rightTop,
            rightBottom,
            mlpanel,
            mrpanel,
            mepanel;
    private static JProgressBar sens, 
            rotp,
            rotm,
            motorml,
            motorr,
            motore;
    
    public static void GUI(){ 
        var.log.write("Creating GUI");
        
        //create main frame 
        cGUI();
       
        //initialize panels
        initializePanels();
        
        //initialize text
        initializeText();
        
        //add panels to frame
        drawGUI();
    }
    
    private static void cGUI(){
        gui = new JFrame("MATE Control");
        gui.setTitle("MATE Controller");
        gui.setSize(1300, 600);
        gui.setVisible(true);
        gui.setResizable(false); //has to be false for some reason
        gui.show();
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private static void initializePanels(){
        //panel
        panel = new JPanel(new BorderLayout());
        
        data = new JPanel(new FlowLayout());
        title = new JPanel(new FlowLayout());
        info = new JPanel(new FlowLayout());
        
        infoLeft = new JPanel(new BorderLayout());
        leftTop = new JPanel();
        leftBottom = new JPanel(new BorderLayout());
        
        cXYGraph();
        cRotation();
        cSensitivity();
        
        //camera
        camera = new JPanel();
    }
    
    private static void initializeText(){
        
    }
    
    private static void drawGUI(){
        gui.add(panel);
        
        panel.add(title, BorderLayout.NORTH);
        panel.add(data, BorderLayout.CENTER);
        
        data.add(info, FlowLayout.LEFT);
        data.add(camera);
        
        camera.add(var.cameraPanel);
        
        info.add(infoLeft, FlowLayout.LEFT);
        
        infoLeft.add(leftTop, BorderLayout.NORTH);
        infoLeft.add(leftBottom, BorderLayout.SOUTH);
        
        leftTop.add(xypanel);
        
        leftBottom.add(senspanel, BorderLayout.NORTH);
        leftBottom.add(rotpanel, BorderLayout.SOUTH);
        
        xypanel.add(xygraph);
        senspanel.add(sens);
        rotpanel.add(rot);
    }
    
    private static void cXYGraph(){
        Dimension d = new Dimension(200, 200);
        
        //panel
        xypanel = new JPanel(new FlowLayout());
        xypanel.setBorder(titledBorder("Axes"));
        
        
        xygraph = new JPanel(new FlowLayout());
        
        //set size
        xygraph.setMinimumSize(d);
        xygraph.setMaximumSize(d);
        xygraph.setPreferredSize(d);
        
        xygraph.setBorder(BorderFactory.createLineBorder(Color.black));
        
    }
    
    private static void drawXYGraph(){
        int x = (int)(var.x * 100);
        int y = (int)(var.z * 100);
        
        Graphics2D g = (Graphics2D) xygraph.getGraphics();
        g.clearRect(1, 1, xygraph.getWidth() - 2, xygraph.getHeight() - 2);
        
        
        //restraint lines
        g.drawLine(100 - ((int)(100*var.sensitivity())), 100, 100, 100 - ((int)(var.sensitivity()*100)));
        g.drawLine(100, 100 - ((int)(100*var.sensitivity())), 100 + ((int)(100*var.sensitivity())), 100);
        g.drawLine(100 - ((int)(100*var.sensitivity())), 100, 100, 100 + ((int)(100*var.sensitivity())));
        g.drawLine(100, 100 + ((int)(100*var.sensitivity())), 100 + ((int)(100*var.sensitivity())), 100);
        
        g.fillOval(x + 100, -y + 100, 5, 5);
        
    }
    
    private static void cRotation(){
        rotpanel = new JPanel(new FlowLayout());
        rotpanel.setBorder(titledBorder("Rotation"));
        
        rotp = new JProgressBar(0, 50);
        rotm = new JProgressBar()
        
    }
    
    private static void cSensitivity(){
        senspanel = new JPanel(new FlowLayout());
        senspanel.setBorder(titledBorder("Sensitivity"));
        
        sens = new JProgressBar(0, 100);
        
    }
    
    public static void redraw(){
        drawXYGraph();
        
        rotp.setValue((int) (var.rotation()*50) + 50);
        sens.setValue((int) (var.sensitivity()*100));
    }
    
    private static Border titledBorder(String n){
        return BorderFactory.createTitledBorder(null, n, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, new Color(0, 0, 0));
    }
}
