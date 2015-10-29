package Util;

import GUI.GUI;
import GUI.paint;
import Math.math;
import static Util.var.*;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import processing.data.XML.*;

public class setup {
    
    public static void setup() throws FileNotFoundException, UnsupportedEncodingException{
        log.createLog();
        log.debuglog("Created logs");
        
        color.colorRead();
        log.debuglog("Loaded XML");
        
        color.colorSet();
        log.debuglog("Loaded Colors");
        
        GUI.GUI();
        log.debuglog("Loaded GUI");
    }
}