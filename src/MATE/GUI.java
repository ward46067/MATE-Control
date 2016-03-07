package MATE;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import static javax.swing.JFrame.*;
import javax.swing.JLabel;
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
            mepanel,
            elevpanel;
    private static JProgressBar sensb, 
            rotb,
            elevb,
            motorml,
            motorr,
            motore;
    private static JLabel senstxt,
            rottxt;
    private static Color darkGreen;
    
    public static void GUI(){ 
        var.log.write("Creating GUI");
        
        //create colors
        ccolor();
        
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
        infoMid = new JPanel(new BorderLayout());
        
        leftTop = new JPanel();
        leftBottom = new JPanel(new BorderLayout());
        
        cXYGraph();
        cRotation();
        cSensitivity();
        cElevation();
        
        //camera
        camera = new JPanel();
    }
    
    private static void initializeText(){
        
    }
    
    private static void ccolor(){
        darkGreen = new Color(0, 153, 0);
    }
    
    private static void drawGUI(){
        gui.add(panel);
        
        panel.add(title, BorderLayout.NORTH);
        panel.add(data, BorderLayout.CENTER);
        
        data.add(info, FlowLayout.LEFT);
        data.add(camera);
        
        //camera.add(var.cameraPanel);
        
        info.add(infoLeft, FlowLayout.LEFT);
        info.add(infoMid);
        
        infoLeft.add(leftTop, BorderLayout.NORTH);
        infoLeft.add(leftBottom, BorderLayout.SOUTH);
        
        leftTop.add(xypanel);
        
        leftBottom.add(senspanel, BorderLayout.NORTH);
        leftBottom.add(rotpanel, BorderLayout.CENTER);
        leftBottom.add(elevpanel, BorderLayout.SOUTH);
        
        xypanel.add(xygraph);
        senspanel.add(sensb);
        //rotpanel.add(rottxt);
        rotpanel.add(rotb);
        elevpanel.add(elevb);
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
        g.setColor(Color.red);
        g.drawLine(100 - ((int)(100*var.sensitivity())), 100, 100, 100 - ((int)(var.sensitivity()*100))); //top left
        g.drawLine(100, 100 - ((int)(100*var.sensitivity())), 100 + ((int)(100*var.sensitivity())), 100); //top right
        g.drawLine(100 - ((int)(100*var.sensitivity())), 100, 100, 100 + ((int)(100*var.sensitivity()))); //bottom left
        g.drawLine(100, 100 + ((int)(100*var.sensitivity())), 100 + ((int)(100*var.sensitivity())), 100); //bottom right
        
        //point
        g.setColor(Color.black);
        g.fillOval(x + 100, -y + 100, 5, 5);
        
        //cross lines
        g.drawLine(100 - ((int)(100*var.sensitivity())), 100, 100 + ((int)(100*var.sensitivity())), 100);
        g.drawLine(100, 100 - ((int)(100*var.sensitivity())), 100, 100 + ((int)(100*var.sensitivity())));
    }
    
    private static void cRotation(){
        rotpanel = new JPanel(new FlowLayout());
        rotpanel.setBorder(titledBorder("Rotation"));
        
        rotb = new JProgressBar(0, 50);
        //rottxt = new JLabel("" + ((var.joystick.getRotation() * 90) + 90));
        //rotm = new JProgressBar()
        
    }
    
    private static void cSensitivity(){
        senspanel = new JPanel(new FlowLayout());
        senspanel.setBorder(titledBorder("Sensitivity"));
        
        sensb = new JProgressBar(0, 100);
        sensb.setForeground(darkGreen);
    }
    
    private static void cElevation(){
        elevpanel = new JPanel(new FlowLayout());
        elevpanel.setBorder(titledBorder("Elevation"));
        
        elevb = new JProgressBar(0, 50);
    }
    
    public static void redraw(){
        drawXYGraph();
        
        colorBar(rotb, var.joystick.getRotation());
        sensb.setValue((int) (var.sensitivity()*100));
        colorBar(elevb, var.joystick.getRotation());
    }
    
    private static Border titledBorder(String n){
        return BorderFactory.createTitledBorder(null, n, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, new Color(0, 0, 0));
    }
    
    private static void colorBar(JProgressBar bar, float num){
        if(num >= 0){
            bar.setForeground(darkGreen);
        } else {
            bar.setForeground(Color.red);
        }
        
        bar.setValue((int) ((num + 1)*25));
    }
}
