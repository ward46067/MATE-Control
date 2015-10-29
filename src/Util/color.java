package Util;

import java.io.File;
import Util.var.*;
import static Util.var.colorBackground;
import static Util.var.colorBarBackground;
import static Util.var.colorBarInfo;
import static Util.var.colorButton;
import static Util.var.colorButtonHover;
import static Util.var.colorButtonSelected;
import static Util.var.colorDebugBackground;
import static Util.var.colorDebugText;
import static Util.var.colorMotorBackground;
import static Util.var.colorPalette;
import static Util.var.colorText;
import static Util.var.colorTitleBackground;
import java.util.ArrayList;

public class color {
    public static void colorRead(){
        //File paletteFile = new File("lib\\data\\palette.xml");
        Xml palette = new Xml("palette.xml", "palette");
        
        log.debuglog.println("Palette URL: " + palette.child("url").content());
        
        for(int i = 0; i < 4; i++){
            for(int x = 0; x < 5; x++){
                colorPalette[i][x][0] = palette.child("colorset" + (i+1)).child("color" + (x+1)).integer("r");
                colorPalette[i][x][1] = palette.child("colorset" + (i+1)).child("color" + (x+1)).integer("g");
                colorPalette[i][x][2] = palette.child("colorset" + (i+1)).child("color" + (x+1)).integer("b");
            }
        }
        log.debuglog.println("Loaded XML");
    }
    
    public static void colorSet(){
        for(int i = 0; i < 3; i++) { //loop 3 times for rgb
  
            colorText[i] = colorPalette[3][0][i];

            colorBackground[i] = colorPalette[0][0][i];

            colorTitleBackground[i] = colorPalette[0][1][i];

            colorMotorBackground[i] = colorPalette[0][2][i];

            colorBarBackground[i] = colorPalette[1][2][i];
            colorBarInfo[i] = colorPalette[2][0][i];

            colorDebugBackground[i] = colorPalette[0][4][i];
            colorDebugText[i] = colorPalette[3][1][i];

            colorButton[i] = colorPalette[2][1][i];
            colorButtonHover[i] = colorPalette[2][2][i];
            colorButtonSelected[i] = colorPalette[2][3][i];
        }
    }
}
