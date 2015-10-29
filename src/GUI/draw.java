package GUI;

import java.awt.Graphics2D;
import static Util.var.*;
import java.awt.Color;

public class draw {
    
    private static Graphics2D d;
    
    public static void draw(Graphics2D d){
        draw.d = d;
        background();
        title();
        debug();
        xyGraph();
    }
    
    private static void rect(Color c, int x, int y, int w, int h){
        d.setColor(Color.BLACK);
        d.drawRect(x, y, w, h);
        d.setColor(c);
        d.fillRect(x, y, w, h);
    }
    
    private static void line(float x1, float y1, float x2, float y2){
        d.setColor(Color.BLACK);
        d.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
    }
    
    public static void background(){
        rect(colorBackground, 0, 0, width, height);
    }
    
    public static void title(){
        rect(colorTitleBackground, 0, 0, width, height/6);
    }
    
    public static void debug(){
        rect(colorDebugBackground, 1025, 550, 250, 50);
    }
    
    public static void xyGraph(){
        //background
        rect(colorBarBackground, 50, 150, 250, 250);
        
        //restraint lines
        line(175 - 125*sensitivity, 275, 175, 275 - 125*sensitivity);
        line(175, 275 - 125*sensitivity, 175 + 125*sensitivity, 275);
        line(175 - 125*sensitivity, 275, 175, 275 + 125*sensitivity);
        line(175, 275 + 125*sensitivity, 175 + 125*sensitivity, 275);
        
        //display joystick x y
        line(175, 275, 175 + x * 125, 275 + -z * 125);
        d.setColor(colorBarInfo);
        d.fillOval((int)(175 + x * 125), (int)(275 + -z * 125), 5, 5); //dot
    }
    
}
