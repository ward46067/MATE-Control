package Util;

import static Util.var.logDateTimeMillis;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class debug {
    public static void error(String error){
        log.debug(error);
        JOptionPane.showMessageDialog(null, error, "ERROR", ERROR_MESSAGE);
    }

}
