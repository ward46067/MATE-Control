package MATE;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import java.awt.Dimension;

public class cam {
    public static void setup(){
        var.camera = Webcam.getDefault();
        //var.camera.setViewSize(WebcamResolution.VGA.getSize());
        var.camera.setViewSize(new Dimension(320, 240));
        
        var.cameraPanel = new WebcamPanel(var.camera);
        var.cameraPanel.setFPSDisplayed(true);
        var.cameraPanel.setDisplayDebugInfo(true);
        var.cameraPanel.setImageSizeDisplayed(true);
        var.cameraPanel.setMirrored(true);
        //var.cameraPanel.setSize(320, 240);
        
        //var.cameraPanel.setBorder(BorderFactory.createEmptyBorder(220, 0, 220, 0));
        
    }
}
