package math;

import Math.elevation;
import static util.var.*;

public class math{
    public static void math(){
        z *= -1; //negative to correct numbers

        speed.speedZ();
        sens.sensitivity();
        speed.speed();
        elevation.toggle();
        elevation.servo();

        //calculate motor output
        m1 = (int)(motor1 * 100) + 100;
        m2 = (int)(motor2 * 100) + 100;
        m3 = (int)(motor3 * 100) + 100;
        m4 = (int)(motor4 * 100) + 100;

        //calculate servo output
        s1 = (int)(servo1);
        s2 = (int)(servo2);
        s3 = (int)(servo3);
        s4 = (int)(servo4);
    } 
}