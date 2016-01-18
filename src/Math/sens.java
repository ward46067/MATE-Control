package math;

import static util.var.*;

public class sens{
    public static void sensitivity(){
        //calculate sensitivity
        sensitivity *= -1;
        sensitivity += 1;
        sensitivity /= 2;

        if(sensitivity < minSensitivity)
            sensitivity = (float)minSensitivity;

        //boost
        if(boost) {
            sensitivity = 1;
        }

        //multiply sensitivity
        x *= sensitivity;
        y *= sensitivity;
        z *= sensitivity;
        rotation *= sensitivity;
    }
}
