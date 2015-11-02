package XML;

import static debug.log.debug;
import java.io.File;

import static util.var.*;
import java.awt.Color;
import java.util.ArrayList;

public class color {
    public static void colorRead(){
        //File paletteFile = new File("lib\\data\\palette.xml");
        Xml palette = new Xml("palette.xml", "palette");
        debug("Found XML");
        debug("Loading XML");
        debug("Palette URL: " + palette.child("url").content().trim());
        
        for(int i = 0; i < 4; i++){
            for(int x = 0; x < 5; x++){
                colorPalette[i][x][0] = palette.child("colorset" + (i+1)).child("color" + (x+1)).integer("r");
                colorPalette[i][x][1] = palette.child("colorset" + (i+1)).child("color" + (x+1)).integer("g");
                colorPalette[i][x][2] = palette.child("colorset" + (i+1)).child("color" + (x+1)).integer("b");
            }
        }
        debug("Loaded XML");
    }
    
    public static void colorSet(){
        colorText = new Color(colorPalette[3][0][0], colorPalette[3][0][1], colorPalette[3][0][2]);

        colorBackground = new Color(colorPalette[0][0][0], colorPalette[0][0][1], colorPalette[0][0][2]);

        colorTitleBackground = new Color(colorPalette[0][1][0], colorPalette[0][1][1], colorPalette[0][1][2]);

        colorMotorBackground = new Color(colorPalette[0][2][0], colorPalette[0][2][1], colorPalette[0][2][2]);

        colorBarBackground = new Color(colorPalette[1][2][0], colorPalette[1][2][1], colorPalette[1][2][2]);
        colorBarInfo = new Color(colorPalette[2][0][0], colorPalette[2][0][1], colorPalette[2][0][2]);

        colorDebugBackground = new Color(colorPalette[0][4][0], colorPalette[0][4][1], colorPalette[0][4][2]);
        colorDebugText = new Color(colorPalette[3][1][0], colorPalette[3][1][1], colorPalette[3][1][2]);

        colorButton = new Color(colorPalette[2][1][0], colorPalette[2][1][1], colorPalette[2][1][2]);
        colorButtonHover = new Color(colorPalette[2][2][0], colorPalette[2][2][1], colorPalette[2][2][2]);
        colorButtonSelected = new Color(colorPalette[2][3][0], colorPalette[2][3][1], colorPalette[2][3][2]);
        
        debug("Set all the colors");
        
    }
}
