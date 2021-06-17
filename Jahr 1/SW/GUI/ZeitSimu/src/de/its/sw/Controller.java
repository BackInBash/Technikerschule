package de.its.sw;

public class Controller {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIZeit().setVisible(true);
            }
        });
    }

}
