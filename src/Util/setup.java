package Util;

import static Util.var.*;
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
        
        
        
    }
}