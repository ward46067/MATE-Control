package Math;

import static Util.var.*;

public class speed{
    public static void speedZ(){
        //calculate z
        if(((x + z > 1)||(x + z < -1))||((x - z < -1)||(-x + z < -1))){
            if(z > 0){
                if(x > 0)
                    z = 1 - x;
                if(x < 0)
                    z = x + 1;
            } else if(z < 0){
                if(x > 0)
                    z = -1 + x;
                if(x < 0)
                    z = -1 + -x;
            }
        }
    }
    
    public static void speed(){
        //zeros
        if(x == 0) {
            motor1x = 0;
            motor2x = 0;
            motor3x = 0;
            motor4x = 0;
        }
        if(z == 0) {
            motor1z = 0;
            motor2z = 0;
            motor3z = 0;
            motor4z = 0;
        }
        
        //x
        if(x < 0) {
            motor1x = x;
            motor2x = -1 * x;
            motor3x = -1 * x;
            motor4x = x;
        }
        if(x > 0) {
            motor1x = x;
            motor2x = -1 * x;
            motor3x = -1 * x;
            motor4x = x;
        }
        
        //z
        if(z > 0) {
            motor1z = -1 * z;
            motor2z = -1 * z;
            motor3z = z;
            motor4z = z;
        }
        if(z < 0) {
            motor1z = -1 * z;
            motor2z = -1 * z;
            motor3z = z;
            motor4z = z;
        }
        
        //add
        motor1 = motor1x + motor1z;
        motor2 = motor2x + motor2z;
        motor3 = motor3x + motor3z;
        motor4 = motor4x + motor4z;
    }
}
