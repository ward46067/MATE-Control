package math;

import MATE.elevation;
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
        m1 = (int)(motor1 * 127) + 127;
        m2 = (int)(motor2 * 127) + 127;
        m3 = (int)(motor3 * 127) + 127;
        m4 = (int)(motor4 * 127) + 127;

        //calculate servo output
        s1 = (int)(servo1);
        s2 = (int)(servo2);
        s3 = (int)(servo3);
        s4 = (int)(servo4);
    } 
}