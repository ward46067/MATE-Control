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
            motorrb,
            motorlb;
    private static JLabel senstxt,
            rottxt, 
            mrSpeed,
            mlSpeed;
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
        gui.setSize(1200, 600);
        gui.setVisible(true);
        gui.setResizable(true); //has to be false for some reason
        gui.show();
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private static void initializePanels(){
        //panel
        panel = new JPanel(new BorderLayout());
        
        data = new JPanel(new FlowLayout());
        title = new JPanel();
        info = new JPanel(new FlowLayout());
        
        infoLeft = new JPanel(new BorderLayout());
        infoRight = new JPanel(new BorderLayout());
        
        leftTop = new JPanel(new BorderLayout());
        leftBottom = new JPanel(new BorderLayout());
        
        rightTop = new JPanel(new BorderLayout());
        rightBottom = new JPanel(new BorderLayout());
        
        cXYGraph();
        cRotation();
        cSensitivity();
        cElevation();
        cMotorL();
        cMotorR();
        
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
        
        panel.add(title, BorderLayout.CENTER);
        panel.add(data, BorderLayout.SOUTH);
        
        data.add(info, FlowLayout.LEFT);
        data.add(camera);
        
        //camera.add(var.cameraPanel);
        
        info.add(infoLeft, FlowLayout.LEFT);
        info.add(infoRight);
        
        infoLeft.add(leftTop, BorderLayout.NORTH);
        infoLeft.add(leftBottom, BorderLayout.SOUTH);
        
        infoRight.add(rightTop);
        
        leftTop.add(xypanel);
        
        leftBottom.add(senspanel, BorderLayout.NORTH);
        leftBottom.add(rotpanel, BorderLayout.CENTER);
        leftBottom.add(elevpanel, BorderLayout.SOUTH);
        
        rightTop.add(mlpanel, BorderLayout.NORTH);
        rightTop.add(mrpanel, BorderLayout.SOUTH);
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
        
        xypanel.add(xygraph);
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
    
    private static void drawTitle(){
        int w = title.getWidth(), h = title.getHeight();
        
        Graphics2D g = (Graphics2D) title.getGraphics();
        //g.clearRect(0, 0, w, h);
        
        //bottom border
        g.drawLine(0, h, w, h);
        
        g.setColor(Color.black);
        g.drawString("MATE Control", 0, 0);
    }
    
    private static void cRotation(){
        rotpanel = new JPanel(new FlowLayout());
        rotpanel.setBorder(titledBorder("Rotation"));
        
        rotb = new JProgressBar(0, 100);
        //rottxt = new JLabel("" + ((var.joystick.getRotation() * 90) + 90));
        //rotm = new JProgressBar()
        rotpanel.add(rotb);
    }
    
    private static void cSensitivity(){
        senspanel = new JPanel(new FlowLayout());
        senspanel.setBorder(titledBorder("Sensitivity"));
        
        sensb = new JProgressBar(0, 100);
        sensb.setForeground(darkGreen);
        
        senspanel.add(sensb);
    }
    
    private static void cElevation(){
        elevpanel = new JPanel(new FlowLayout());
        elevpanel.setBorder(titledBorder("Elevation"));
        
        elevb = new JProgressBar(0, 100);
        
        elevpanel.add(elevb);
    }
    
    private static void cMotorL(){
        mlpanel = new JPanel(new BorderLayout());
        mlpanel.setBorder(titledBorder("Motor Left"));
        
        mlSpeed = new JLabel();
        
        motorlb = new JProgressBar(0, 100);
        
        mlpanel.add(mlSpeed, BorderLayout.NORTH);
        mlpanel.add(motorlb);
    }
    
    private static void cMotorR(){
        mrpanel = new JPanel(new BorderLayout());
        mrpanel.setBorder(titledBorder("Motor Right"));
        
        mrSpeed = new JLabel();
        
        motorrb = new JProgressBar(0, 100);
        
        mrpanel.add(mrSpeed, BorderLayout.NORTH);
        mrpanel.add(motorrb);
    }
    
    public static void redraw(){
        drawXYGraph();
        drawTitle();
        
        colorBar(rotb, var.joystick.getRotation());
        sensb.setValue((int) (var.sensitivity()*100));
        colorBar(elevb, var.motorE.getValue());
        
        //left motor
        mlSpeed.setText("Speed: " + var.motorL.getValueInt());
        motorlb.setValue((var.motorL.getValueInt()/2) + 50);
        
        //right motor
        mrSpeed.setText("Speed: " + var.motorR.getValueInt());
        motorrb.setValue((var.motorR.getValueInt()/2) + 50);
    }
    
    private static Border titledBorder(String n){
        return BorderFactory.createTitledBorder(null, n, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, new Color(0, 0, 0));
    }
    
    private static void colorBar(JProgressBar bar, float num){
        if(num >= 0.5){
            bar.setForeground(darkGreen);
        } else {
            bar.setForeground(Color.red);
        }
        
        bar.setValue((int) ((num)*100));
        bar.setToolTipText("" + num);
        
    }
}
