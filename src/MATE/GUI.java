package MATE;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.JFrame.*;
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
            dTitle,
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
            elevpanel,
            bottom,
            dBottom,
            hspanel,
            hatswitch;
    private static JProgressBar sensb, 
            rotb,
            elevb,
            motorrb,
            motorlb;
    private static JLabel senstxt,
            rottxt, 
            mrSpeed,
            mlSpeed,
            datetime,
            temp;
            
    private static Color darkGreen;
    
    public static void GUI(){ 
        var.log.write("Creating GUI");
        
        //create colors
        ccolor();
        
        //create main frame 
        cGUI();
       
        //initialize panels
        initializePanels();
        
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
        info = new JPanel(new FlowLayout());
        
        infoLeft = new JPanel(new BorderLayout());
        infoRight = new JPanel(new BorderLayout());
        
        leftTop = new JPanel(new BorderLayout());
        leftBottom = new JPanel(new BorderLayout());
        
        rightTop = new JPanel(new BorderLayout());
        rightBottom = new JPanel(new BorderLayout());
        
        cTitle();
        cXYGraph();
        cRotation();
        cSensitivity();
        cElevation();
        cMotorL();
        cMotorR();
        cBottom();
        cHatSwitch();
        
        //camera
        camera = new JPanel(new BorderLayout());
        datetime = new JLabel(var.log.dateTime());
        temp = new JLabel();
    }
    
    private static void ccolor(){
        darkGreen = new Color(0, 153, 0);
    }
    
    private static void drawGUI(){
        gui.add(panel);
        
        //panel.add(title, BorderLayout.NORTH);
        panel.add(data, BorderLayout.CENTER);
        //panel.add(bottom, BorderLayout.SOUTH);
        
        data.add(info, FlowLayout.LEFT);
        data.add(camera);
        data.add(temp);
        
        //camera.add(var.cam1.getCameraPanel(), BorderLayout.NORTH);
        //camera.add(var.cam2.getCameraPanel(), BorderLayout.CENTER);
        //camera.add(var.cam3.getCameraPanel(), BorderLayout.SOUTH);
        
        info.add(infoLeft, FlowLayout.LEFT);
        
        //info.add(datetime);
        
        info.add(infoRight);
        
        infoLeft.add(leftTop, BorderLayout.NORTH);
        infoLeft.add(leftBottom, BorderLayout.SOUTH);
        
        infoRight.add(rightTop);
        
        leftTop.add(xypanel);
        
        leftBottom.add(senspanel, BorderLayout.NORTH);
        leftBottom.add(rotpanel, BorderLayout.CENTER);
        leftBottom.add(elevpanel, BorderLayout.SOUTH);
        
        rightTop.add(mlpanel, BorderLayout.NORTH);
        rightTop.add(mrpanel, BorderLayout.CENTER);
        rightTop.add(hspanel, BorderLayout.SOUTH);
        
        
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
        g.fillOval((x-2) + 100, (-y-2) + 100, 4, 4);
        
        //cross lines
        g.drawLine(100 - ((int)(100*var.sensitivity())), 100, 100 + ((int)(100*var.sensitivity())), 100);
        g.drawLine(100, 100 - ((int)(100*var.sensitivity())), 100, 100 + ((int)(100*var.sensitivity())));
    }
    
    private static void cTitle(){
        title = new JPanel(new FlowLayout());
        dTitle = new JPanel(new FlowLayout());
        
        Dimension d = new Dimension(200, 200);
        
        dTitle.setMaximumSize(d);
        dTitle.setMinimumSize(d);
        dTitle.setPreferredSize(d);
        
        title.add(dTitle);
    }
    
    private static void drawTitle(){
        int w = dTitle.getWidth(), h = dTitle.getHeight();
        
        Graphics2D g = (Graphics2D) dTitle.getGraphics();
        g.clearRect(0, 0, w, h);
        
        //bottom border
        //g.drawLine(0, h, w, h);
        
        
        g.setColor(Color.red);
        g.drawRect(0, 0, w, h);
        g.drawString("MATE Control", 100, 100);
        
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
    
    private static void cBottom(){
        bottom = new JPanel(new FlowLayout());
        dBottom = new JPanel(new FlowLayout());
        
        Dimension d = new Dimension(200, 50);
        
        bottom.setPreferredSize(d);
        
        bottom.add(dBottom);
    }
    
    private static void drawBottom(){
        
    }
    
    private static void cHatSwitch(){
        Dimension d = new Dimension(200, 200);
        
        hspanel = new JPanel(new FlowLayout());
        hatswitch = new JPanel(new FlowLayout());
        
        hspanel.setBorder(titledBorder("Hat Switch"));
        hspanel.setPreferredSize(d);
        
        hatswitch.setPreferredSize(new Dimension(150, 150));
        
        //hatswitch.setBorder(BorderFactory.createLineBorder(Color.black));
        
        hspanel.add(hatswitch);
    }
    
    private static void drawHS(){
        Graphics2D g = (Graphics2D)hatswitch.getGraphics();
        
        int circleSize = 100;
        
        int smallCircleSize = 10;
        int upCircleX = 65;
        int upCircleY = 17;
        int leftCircleX = 15;
        int leftCircleY = 68;
        int betweenX = 37;
        int betweenY = 17;
        
        int x = 0;
        int y = 0;
        
        g.clearRect(15, 15, hatswitch.getWidth() - 10, hatswitch.getHeight() - 22);
        
        g.setColor(Color.BLACK);
        g.setBackground(darkGreen);
        g.drawOval(20, 22, circleSize, circleSize);
        
        if(!var.joystick.getHatSwitch()[0] && var.joystick.isConnected()){
            g.setColor(Color.blue);

            //up
            if(var.joystick.getHatSwitch()[1]){
                x = upCircleX;
                y = upCircleY;
            //down
            }else if(var.joystick.getHatSwitch()[5]){
                x = upCircleX;
                y = upCircleY + circleSize;
            //left
            }else if(var.joystick.getHatSwitch()[7]){
                x = leftCircleX;
                y = leftCircleY;
            //right
            }else if(var.joystick.getHatSwitch()[3]){
                x = leftCircleX + circleSize;
                y = leftCircleY;
            //up left
            }else if(var.joystick.getHatSwitch()[8]){
                x = upCircleX - betweenX;
                y = upCircleY + betweenY;
            //up right
            }else if(var.joystick.getHatSwitch()[2]){
                x = upCircleX + betweenX;
                y = upCircleY + betweenY;
            //down left
            }else if(var.joystick.getHatSwitch()[6]){
                x = upCircleX - betweenX;
                y = upCircleY + circleSize - betweenY;
            //down right
            }else if(var.joystick.getHatSwitch()[4]){
                x = upCircleX + betweenX;
                y = upCircleY + circleSize - betweenY;
            }

            g.fillOval(x, y, smallCircleSize, smallCircleSize);
        }
    }
    
    public static void redraw(){
        //drawTitle();
        drawXYGraph();
        drawHS();
        
        
        colorBar(rotb, var.joystick.getRotation());
        sensb.setValue((int) (var.sensitivity()*100));
        colorBarInt(elevb, var.motorE.getValue()/2);
        
        //left motor
        mlSpeed.setText("Speed: " + var.motorL.getValue());
        motorlb.setValue(var.motorL.getValue()/2);
        
        //right motor
        mrSpeed.setText("Speed: " + var.motorR.getValue());
        motorrb.setValue(var.motorR.getValue()/2);
        
        //motorrb.setMaximum(var.motorScale);
        
        
        //datetime.setText(var.log.dateTime());
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
        
        bar.setValue((int) ((num + 1)*50));
        bar.setToolTipText("" + num);
        
    }
    
    private static void colorBarInt(JProgressBar bar, int num){
        if(num >= 50){
            bar.setForeground(darkGreen);
        } else {
            bar.setForeground(Color.red);
        }
        
        bar.setValue(num);
        bar.setToolTipText("" + num);
        
    }
    
    
    public static void beginTemp(){
        new Thread(){
            public void run(){
                while(true){
                    
                    temp.setText("Temperature: " + String.valueOf(var.getTemp()).substring(0, 5) + " C");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }.start();
    }
}
