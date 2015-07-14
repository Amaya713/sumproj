import java.awt.*;
import java.applet.*;
import java.util.*;

import mobius.dicom.receiver.Main;
import mobius.dicom.receiver.SendDICOM;
import mobius.dicom.receiver.AdvancedPreferences;

public class DICOMViewerApplet extends Applet{

    public void init() {
        setLayout(new BorderLayout());
        Window[] all = Window.getWindows();
        ArrayList<Window> allList = new ArrayList<Window>();
        for (Window window : all) {
            allList.add(window);
        }
        String[] args = {};
        Main iv = new Main(); 
        iv.main(args);

        all = Window.getWindows();
        for (Window window : all) {
            if (!allList.contains(window) && window.isVisible()) {
                if (window instanceof Frame) {
                    Frame f = (Frame)window;
                    Component[] allComp = f.getComponents();
                    Component c = f.getComponents()[0];
                    f.remove(c);
                    f.setVisible(false);
                    add(c);
                    validate();
                }
            }
        }
    }
}