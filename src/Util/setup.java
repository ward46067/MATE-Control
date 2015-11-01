package Util;

import GUI.GUI;
import GUI.paint;
import Math.math;
import static Util.log.debug;
import static Util.var.*;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import processing.data.XML.*;

public class setup {
    
    public static void setup() throws FileNotFoundException, UnsupportedEncodingException{
        log.createLog();
        color.colorRead();
        color.colorSet();
        GUI.GUI();
        
        log.debug("Created GUI");
        log.debug("That took " + ((millis()) - guiTimeMillis) + " milliseconds!");
        loop.loop();
    }
}