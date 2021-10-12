package its.sw;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author Oliver Schwahlen
 */
public class TermometerGUI extends javax.swing.JFrame implements PropertyChangeListener {

    Temperatur temperatur;

    public TermometerGUI(Temperatur temperatur) {
        this.temperatur = temperatur;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jProgressBarTemperatur = new javax.swing.JProgressBar();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jProgressBarTemperatur.setMaximum(50);
    jProgressBarTemperatur.setMinimum(-25);
    jProgressBarTemperatur.setOrientation(1);
    jProgressBarTemperatur.setString("33%");

    jLabel1.setText("Temperatur in °Celsius");

    jLabel2.setText("0°");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addGap(64, 64, 64)))
        .addComponent(jProgressBarTemperatur, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(182, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jProgressBarTemperatur, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
            .addContainerGap())
          .addComponent(jLabel1)))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap(196, Short.MAX_VALUE)
        .addComponent(jLabel2)
        .addGap(90, 90, 90))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JProgressBar jProgressBarTemperatur;
  // End of variables declaration//GEN-END:variables

    @Override
    public void propertyChange(PropertyChangeEvent arg0) {
        if (arg0.getPropertyName().equalsIgnoreCase("Temperatur")) {
            jProgressBarTemperatur.setValue((int) Math.round(this.temperatur.getCelsius()));
        }
    }
}
