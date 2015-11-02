package math;

import util.loop;
import debug.log;
import XML.color;
import GUI.GUI;
import GUI.paint;
import device.connect;
import static debug.log.debug;
import static util.var.*;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import processing.data.XML.*;

public class setup {
    
    public static void setup() throws FileNotFoundException, UnsupportedEncodingException, IOException{
        log.createLog();
        color.colorRead();
        color.colorSet();
        GUI.GUI();
        
        log.debug("Created GUI");
        log.debug("That took " + ((millis()) - guiTimeMillis) + " milliseconds!");
        
        loop.loop();
        
        connect.connect();
    }
}