package Math;

import static util.var.*;

public class elevation{
    
    public static void toggle(){
        
    }
    
    public static void servo(){
        if(y == 0) {
            servo1 = 90;
            servo2 = 90;
            servo3 = 90;
            servo4 = 90;
        }

        if(y > 0) {

            if(motor1 > 0)
                servo1 = ((motor1 + y)/2) * 90;
            if(motor2 > 0)
                servo2 = ((motor2 + y)/2) * 90;
            if(motor3 > 0)
                servo3 = ((motor3 + y)/2) * 90;
            if(motor4 > 0)
                servo4 = ((motor4 + y)/2) * 90;

            if(motor1 < 0)
                servo1 = (((-motor1 + y)/2) * 90) + 90;
            if(motor2 < 0)
                servo2 = (((-motor2 + y)/2) * 90) + 90;
            if(motor3 < 0)
                servo3 = (((-motor3 + y)/2) * 90) + 90;
            if(motor4 < 0)
                servo4 = (((-motor4 + y)/2) * 90) + 90;

            if(motor1 == 0){
                servo1 = 90 - (y *90);
                motor1 = y;
            }
            if(motor2 == 0){
                servo2 = 90 - (y *90);
                motor2 = y;
            }
            if(motor3 == 0){
                servo3 = 90 - (y *90);
                motor3 = y;
            }
            if(motor4 == 0){
                servo4 = 90 - (y *90);
                motor4 = y;
            }
        }

        if(y < 0) {
            y *= -1;

            if(motor1 > 0)
                servo1 = ((motor1 / 2) + y) * 90 - 90; 
            if(motor2 > 0)
                servo2 = ((motor2 / 2) + y) * 90 - 90;
            if(motor3 > 0)
                servo3 = ((motor3 / 2) + y) * 90 - 90;
            if(motor4 > 0)
                servo4 = ((motor4 / 2) + y) * 90 - 90;

            if(motor1 < 0)
                servo1 = ((-motor1 / 2) + y) * 90;
            if(motor2 < 0)
                servo2 = ((-motor2 / 2) + y) * 90;
            if(motor3 < 0)
                servo3 = ((-motor3 / 2) + y) * 90;
            if(motor4 < 0)
                servo4 = ((-motor4 / 2) + y) * 90;

            if(motor1 == 0){
                servo1 = 90 - (y *90);
                motor1 = y;
            }
            if(motor2 == 0){
                servo2 = 90 - (y *90);
                motor2 = y;
            }
            if(motor3 == 0){
                servo3 = 90 - (y *90);
                motor3 = y;
            }
            if(motor4 == 0){
                servo4 = 90 - (y *90);
                motor4 = y;
            }

            servo1 = -servo1 + 180;
            servo2 = -servo2 + 180;
            servo3 = -servo3 + 180;
            servo4 = -servo4 + 180;

            y *= -1;
        }
    }
}
