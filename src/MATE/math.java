package MATE;

public class math{
    public static void math(){
        var.x = var.joystick.getX();
        var.z = var.joystick.getY();
        
        float mlx = 0, mlz = 0, mrx = 0, mrz = 0;
        
        //calculate var.z
        if(((var.x + var.z > 1)||(var.x + var.z < -1))||((var.x - var.z < -1)||(-var.x + var.z < -1))){
            if(var.z > 0){
                if(var.x > 0)
                    var.z = 1 - var.x;
                if(var.x < 0)
                    var.z = var.x + 1;
            } else if(var.z < 0){
                if(var.x > 0)
                    var.z = -1 + var.x;
                if(var.x < 0)
                    var.z = -1 + -var.x;
            }
        }
        
        

        //multiply sensitivity
        var.x *= var.sensitivity();
        var.y *= var.sensitivity();
        var.z *= var.sensitivity();
        
        if(var.x == 0){
            mlx = 0;
            mrx = 0;
        }
        
        if(var.z == 0){
            mlx = 0;
            mrz = 0;
        }
        
        if(var.x > 0){
            mlx = var.x;
            mrx = -var.x;
        }
        
        if(var.x < 0){
            mlx = var.x;
            mrx = -var.x;
        }
        
        if(var.z > 1){
            mlz = var.z;
            mrz = var.z;
        }
        
        if(var.z < 1){
            mlz = var.z;
            mrz = var.z;
        }
        
        var.motorL.setValue(mlx + mlz);
        var.motorR.setValue(mrx + mrz);
        
        if(var.elevationButton()){
            var.y = var.rotation() * var.sensitivity();
        } else {
            var.y = 0;
        }
        
        var.motorE.setValue(var.y);
        
        
    } 
}