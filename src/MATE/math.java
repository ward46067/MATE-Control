package MATE;

public class math{
    public static void math(){
        float x = var.x(), z = var.z(), m1x = 0, m1z = 0, m2x = 0, m2z = 0;
        
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
        
        

        //multiply sensitivity
        x *= var.sensitivity();
        var.y *= var.sensitivity();
        z *= var.sensitivity();
        
        if(x == 0){
            m1x = 0;
            m2x = 0;
        }
        
        if(z == 0){
            m1x = 0;
            m2z = 0;
        }
        
        if(x > 0){
            m1x = -x;
            m2x = x;
        }
        
        if(x < 0){
            m1x = -x;
            m2x = x;
        }
        
        if(z > 1){
            m1z = z;
            m2z = z;
        }
        
        if(z < 1){
            m1z = z;
            m2z = z;
        }
        
        var.motorL.setValue(m1x + m1z);
        var.motorR.setValue(m2x + m2z);
        
        if(var.elevationButton()){
            var.y = var.rotation();
        } else {
            var.y = 0;
        }
        
        var.motorE.setValue(var.y);
        
        
    } 
}