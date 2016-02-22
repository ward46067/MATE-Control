package MATE;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;

public class draw {
    
    private static Graphics2D d;
    private static Font f;
    
    public static void draw(Graphics2D d){
        draw.d = d;
        
        //log.debug("Drawing GUI");
        
        background();
        title();
        debug();
        xyGraph();
        rotation();
        sensitivity();
        elevation();
        motor();
        write();
        
        //log.debug("Drew GUI");
    }
    
    //builders
    private static void rect(Color c, int x, int y, int w, int h){
        if(w < 0){
            w *= -1;
            x -= w;
        }
        
        if(h < 0){
            h *= -1;
            y -= h;
        }
        //outline
        d.setColor(Color.BLACK);
        d.drawRect(x-1, y-1, w+1, h+1);
        
        //fill
        d.setColor(c);
        d.fillRect(x, y, w, h);
    }
    
    private static void line(float x1, float y1, float x2, float y2){
        d.setColor(Color.BLACK);
        d.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
    }
    
    private static void text(String text, int x, int y){
        d.setFont(f);
        d.drawString(text, x, y);
    }
    
    private static void textCB(String s, int x, int y){
        text(s, x - (var.stringW(s, d)/2), y - (var.stringH(s, d)/3)); // /3 for better alignment
    }
    
    private static void textLB(String s, int x,  int y){
        text(s, x , y - (var.stringH(s, d)/3));
    }
    
    private static void textCC(String s, int x, int y){
        text(s, x - (var.stringW(s, d)/2), y + (var.stringH(s, d)/2));
    }
    
    private static void textLT(String s, int x, int y){
        text(s, x , y + (var.stringH(s, d)/3));
    }
    
    private static void textRT(String s, int x, int y){
        text(s, (x - var.stringW(s, d)), y + (var.stringH(s, d)/3));
    }
    
    private static void drawMotor(int x, int y, double m){
        //background
        rect(var.colorMotorBackground, x, y, 300, 115);
        
        //speed background
        rect(var.colorBarBackground, x+10, y+50, 280, 40);
        
        //speed bar
        rect(var.colorBarInfo, x+150, y+50, (int)(m*140), 40);
    }
    
    //objects
    public static void background(){
        rect(var.colorBackground, 0, 0, var.width, var.height);
    }
    
    public static void title(){
        rect(var.colorTitleBackground, 0, 0, var.width, var.height/6);
    }
    
    public static void debug(){
        rect(var.colorDebugBackground, 975, 550, 255, 50);
    }
    
    public static void xyGraph(){
        //background
        rect(var.colorBarBackground, 50, 150, 250, 250);
        
        //restraint lines
        line(175 - 125*var.sensitivity(), 275, 175, 275 - 125*var.sensitivity());
        line(175, 275 - 125*var.sensitivity(), 175 + 125*var.sensitivity(), 275);
        line(175 - 125*var.sensitivity(), 275, 175, 275 + 125*var.sensitivity());
        line(175, 275 + 125*var.sensitivity(), 175 + 125*var.sensitivity(), 275);
        
        //display joystick x y
        line(175, 275, 175 + var.x * 125, 275 + -var.z * 125);
        d.setColor(var.colorBarInfo);
        d.fillOval((int)(173 + var.x * 125), (int)(273 + -var.z * 125), 5, 5); //dot
    }
    
    public static void rotation(){
        //background
        rect(var.colorBarBackground, 50, 535, 250, 40);
        
        //rotation
        rect(var.colorBarInfo, 175, 535, (int) (125 * var.rotation()), 40);
    }
    
    public static void sensitivity(){
        //background
        rect(var.colorBarBackground, 50, 450, 250, 40);
        
        //sensitivity
        rect(var.colorBarInfo, 50, 450, (int) (250 * var.sensitivity()), 40);
        
    }
    
    public static void elevation(){
        //background
        rect(var.colorBarBackground, 350, 150, 40, 250);
        
        //elevation
        rect(var.colorBarInfo, 350, 275, 40, (int) (-var.y * 125));
    }
    
    public static void motor(){
        //motor1
        drawMotor(490, 150, var.motorL.getValue()); 
        
        //motor2
        drawMotor(490, 290, var.motorR.getValue());
    }
    
    //text
    public static void write(){
        d.setColor(var.colorText);
        setFontSize(18);
        
        textCB("Joystick Map", 175, 150);
        textCB("Sensitivity: " + (int)(var.sensitivity() * 100) + "%", 175, 450);
        textCB("Rotation: " + (int)(var.rotation() * 100), 175, 535);
        textCB("Elevation", 370, 150);
        textCB("Motor Left", 640, 175);
        textCB("Motor Right", 640, 315);
        
        //motor1
        textLB("Speed: " + var.motorL.getValueInt(), 500, 200);
        //motor2
        textLB("Speed: " + var.motorR.getValueInt(), 500, 340);
        
        //title
        setFontSize(30);
        textCC("MATE Control 2016", 600, 50);
        
        //debug title
        setFontSize(15);
        d.setColor(var.colorDebugText);
        textCB("Debug", 1100, 575);
        
        //debug text
        setFontSize(10);
        textCB("Output: " + var.arduino.getOutput(var.output()), 1130, 595);
        
        //date and time
        setFontSize(15);
        String dateTime = var.log.dateTime();
        textLT(dateTime, 5, 20);
        
        //x
        setFontSize(10);
        textLT("X: " + (int)(var.x * 100), 55, 155);
        
        //y
        textRT("Z: " + (int)(var.z * 100), 295, 155);
        
        //credits
        setFontSize(15);
        textRT("Created by Dalen Ward", 1115, 20);
    }
    
    private static void setFontSize(int s){
        f = new Font("Comic Sans MS", Font.PLAIN, s);
    }
    
}
