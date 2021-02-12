package de.its.fti1;

/**
 *
 * @author FTI1
 */
public class AppController {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new GUI().setVisible(true);
        });
    }
}
