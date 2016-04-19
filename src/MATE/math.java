package MATE;

public class math{
    public static void math(){
        var.x = var.joystick.getX();
        var.z = var.joystick.getY();
        
        double snapPoint = var.sensitivity() - 0.85;
        
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
        
        //snapping
        if(Math.abs(var.x) <= snapPoint){
            var.x = 0;
        }
        
        if(Math.abs(var.z) <= snapPoint){
            var.z = 0;
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
            mlz = 0;
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
        
        var.motorL.setValueAxisValue(mlx + mlz);
        var.motorR.setValueAxisValue(mrx + mrz);
        
        /*
        if(var.elevationButton()){
            var.y = var.rotation() * var.sensitivity();
        } else {
            var.y = 0;
        }
        */
        if(var.joystick.getButton(2)){
            var.motorE.setValue(200);
        } else if(var.joystick.getButton(3)){
            var.motorE.setValue(0);
        } else {
            var.motorE.setValue(100);
        }
        
        //var.motorE.setValueAxisValue(var.y);
        
        //servos
        if(var.joystick.getHatSwitch()[3]){ //right
            var.servoClaw.addDegree(1);

        }
        if(var.joystick.getHatSwitch()[7]){ //left
            var.servoClaw.subDegree(1);
        }
        
        if(var.joystick.getHatSwitch()[1]){ //up
            var.servoArm.addDegree(1);

        }
        if(var.joystick.getHatSwitch()[5]){//down
            var.servoArm.subDegree(1);
        }
        
        //System.out.println(var.arduino.getOutput());
        
        var.motorL.scaleValue(var.motorScale);
        var.motorR.scaleValue(var.motorScale);
        
    } 
}