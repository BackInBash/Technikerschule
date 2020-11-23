/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author
 */
public class GUITest {

    /**
     * @param args the command line arguments
     */
    public static Color get(int c){
        switch(c){
            case 1:
                return Color.RED;
            case 2:
                return Color.BLUE;
            case 3:
                return Color.ORANGE;
            case 4:
                return Color.CYAN;
            case 5:
                return Color.MAGENTA;
            case 6:
                return Color.PINK;
            case 7:
                return Color.YELLOW;
            case 8:
                return Color.WHITE;
            default:
                return Color.BLACK;
        }
    }
    
    public static void GUIWTF(){
	// Create Object
        Frame fr = new Frame("GUI Test");
	// Add Closing Event handler
        addWindowListener(
            new WindowAdapter(){
                public void windowClosing(WindowEvent event){
                    System.exit(0);
                }
            });
	// Set Window Size
        fr.setSize(400,300);
	// Set Visibility
        fr.setVisible(true);
        for(;;){
	// LSD loop
        fr.setBackground(get(ThreadLocalRandom.current().nextInt(1, 8 + 1)));
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
	// Start Class GUITest
	GUIWTF();
		
	// Start Class GUIPaint
	for(int i=0; i<1; i++){
            GUIPaint pnt = new GUIPaint();
            pnt.GPaint();
        }
    }
}