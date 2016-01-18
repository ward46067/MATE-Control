package math;

import Math.elevation;
import static util.var.*;

public class math{
    public static void math(){
        z *= -1; //negative to correct numbers

        speed.speedZ();
        sens.sensitivity();
        speed.speed();
        elevation.elevation();

        //calculate motor output
        m1 = (int)(motor1 * 100) + 100;
        m2 = (int)(motor2 * 100) + 100;
    } 
}