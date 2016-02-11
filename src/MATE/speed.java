package MATE;

import static MATE.var.*;

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
        if(x == 0){
            motor1x = 0;
            motor2x = 0;
        }
        
        if(z == 0){
            motor1x = 0;
            motor2z = 0;
        }
        
        if(x > 0){
            motor1x = -x;
            motor2x = x;
        }
        
        if(x < 0){
            motor1x = -x;
            motor2x = x;
        }
        
        if(z > 1){
            motor1z = z;
            motor2z = z;
        }
        
        if(z < 1){
            motor1z = z;
            motor2z = z;
        }
        
        motor1 = motor1x + motor1z;
        motor2 = motor2x + motor2z;
    }
}
