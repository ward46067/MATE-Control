package GUI;

import util.var;
import java.awt.Graphics2D;
import static util.var.*;
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
        text(s, x - (stringW(s, d)/2), y - (stringH(s, d)/3)); // /3 for better alignment
    }
    
    private static void textLB(String s, int x,  int y){
        text(s, x , y - (stringH(s, d)/3));
    }
    
    private static void textCC(String s, int x, int y){
        text(s, x - (stringW(s, d)/2), y + (stringH(s, d)/2));
    }
    
    private static void textLT(String s, int x, int y){
        text(s, x , y + (stringH(s, d)/3));
    }
    
    private static void textRT(String s, int x, int y){
        text(s, (x - stringW(s, d)), y + (stringH(s, d)/3));
    }
    
    private static void drawMotor(int x, int y, double m, double s){
        //background
        rect(colorMotorBackground, x, y, 300, 165);
        
        //speed background
        rect(colorBarBackground, x+10, y+50, 280, 40);
        
        //speed bar
        rect(colorBarInfo, x+150, y+50, (int)(m*140), 40);
        
        //servo background
        rect(colorBarBackground, x+10, y+115, 280, 40);
        
        //servo bar
        rect(colorBarInfo, (int) ((x+10) + (280 * (s/180))), y+115, 5, 40);
        rect(colorBarInfo, (int) ((x+10) + (280 * (s/180))), y+115, -5, 40);
    }
    
    //objects
    public static void background(){
        rect(colorBackground, 0, 0, width, height);
    }
    
    public static void title(){
        rect(colorTitleBackground, 0, 0, width, height/6);
    }
    
    public static void debug(){
        rect(colorDebugBackground, 1025, 550, 175, 50);
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
        d.fillOval((int)(173 + x * 125), (int)(273 + -z * 125), 5, 5); //dot
    }
    
    public static void rotation(){
        //background
        rect(colorBarBackground, 50, 535, 250, 40);
        
        //rotation
        rect(colorBarInfo, 175, 535, (int) (125 * rotation), 40);
    }
    
    public static void sensitivity(){
        //background
        rect(colorBarBackground, 50, 450, 250, 40);
        
        //sensitivity
        rect(colorBarInfo, 50, 450, (int) (250 * sensitivity), 40);
        
    }
    
    public static void elevation(){
        //background
        rect(colorBarBackground, 350, 150, 40, 250);
        
        //elevation
        rect(colorBarInfo, 350, 275, 40, (int) (-y * 125));
    }
    
    public static void motor(){
        //motor1
        drawMotor(490, 150, motor1, servo1); 
        
        //motor2
        drawMotor(840, 150, motor2, servo2);
        
        //motor 3
        drawMotor(490, 340, motor3, servo3);
        
        //motor4
        drawMotor(840, 340, motor4, servo4);
    }
    
    //text
    public static void write(){
        d.setColor(colorText);
        setFontSize(18);
        
        textCB("Joystick Map", 175, 150);
        textCB("Sensitivity: " + (int)(sensitivity * 100) + "%", 175, 450);
        textCB("Rotation: " + (int)(rotation * 100), 175, 535);
        textCB("Elevation", 370, 150);
        textCB("Motor 1", 640, 175);
        textCB("Motor 2", 990, 175);
        textCB("Motor 3", 640, 365);
        textCB("Motor 4", 990, 365);
        
        //motor1
        textLB("Speed: " + (int)(motor1*100), 500, 200);
        textLB("Servo: " + (int)(servo1), 500, 265);
        //motor2
        textLB("Speed: " + (int)(motor2*100), 850, 200);
        textLB("Servo: " + (int)(servo2), 850, 265);
        //motor3
        textLB("Speed: " + (int)(motor3*100), 500, 390);
        textLB("Servo: " + (int)(servo3), 500, 455);
        //motor4
        textLB("Speed: " + (int)(motor4*100), 850, 390);
        textLB("Servo: " + (int)(servo4), 850, 455);
        
        //title
        setFontSize(30);
        textCC("MATE Control 2016", 600, 50);
        
        //debug title
        setFontSize(15);
        d.setColor(colorDebugText);
        textCB("Debug", 1130, 575);
        
        //debug text
        setFontSize(10);
        textCB("Output: " + 'T' + hexOut(), 1140, 595);
        
        //date and time
        setFontSize(15);
        String dateTime = var.dateTime();
        textLT(dateTime, 5, 20);
        
        //x
        setFontSize(10);
        textLT("X: " + (int)(x * 100), 55, 155);
        
        //y
        textRT("Z: " + (int)(z * 100), 295, 155);
        
        //credits
        setFontSize(15);
        textRT("Created by Dalen Ward", 1115, 20);
    }
    
    private static void setFontSize(int s){
        f = new Font("Comic Sans MS", Font.PLAIN, s);
    }
    
}
