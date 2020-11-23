/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author
 */
public class GUIPaint extends Frame {
    
    public GUIPaint(){
	// Set Windows Name
        super("GUIPaint");
	// Add Closing Event handler
        addWindowListener(
            new WindowAdapter(){
                public void windowClosing(WindowEvent event){
                    System.exit(0);
                }
            });
    }
    
    public void paint(Graphics g){
	// Draw Tcom Logo \_/(^-^)\_/
        String t = "T+";
        Font font = g.getFont().deriveFont( 50.0f );
        g.setFont( font );
        g.drawString(t, 50, 150);
    }
    
    public static void GPaint(){
        // Create Class Object
	GUIPaint gui = new GUIPaint();
	// Set Windows Size
        gui.setSize(400,300);
	// Backroud Color
        gui.setBackground(Color.MAGENTA);
        gui.setVisible(true);
    }
    
}