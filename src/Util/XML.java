package Util;

import static Util.var.*;
import processing.data.XML.*;

public class XML {
    public static void XML(){
        

        //load xml children
        colorset = colorXML.getChildren("colorset");
        xmlURL = colorXML.getChild("url");
        paletteURL = xmlURL.getContent();

        //get all xml values
        for(int i = 0; i < colorset.length; i++) {
            xmlID = colorset[i].getString("id");

            colorsetChild = colorset[i].getChildren("color");

            for(int x = 0; x < colorsetChild.length; x++) {
                colorPalette[i][x][0] = colorsetChild[x].getInt("r");
                colorPalette[i][x][1] = colorsetChild[x].getInt("g");
                colorPalette[i][x][2] = colorsetChild[x].getInt("b");
            }
        }
    }
}
