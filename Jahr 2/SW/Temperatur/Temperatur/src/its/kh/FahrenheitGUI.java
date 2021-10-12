package its.kh;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author Oliver Schwahlen
 */
public class FahrenheitGUI extends javax.swing.JFrame implements PropertyChangeListener {

    Thermometer temperatur;

    public FahrenheitGUI(Thermometer temperatur) {
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

        jLabel1 = new javax.swing.JLabel();
        jTextFieldGrad = new javax.swing.JTextField();
        jButtonUebernehmen = new javax.swing.JButton();
        jButtonHoch = new javax.swing.JButton();
        jButtonRunter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fahrenheit");

        jLabel1.setText("in Grad");

        jButtonUebernehmen.setText("übernehmen");
        jButtonUebernehmen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUebernehmenActionPerformed(evt);
            }
        });

        jButtonHoch.setText("hoch");
        jButtonHoch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHochActionPerformed(evt);
            }
        });

        jButtonRunter.setText("runter");
        jButtonRunter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRunterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldGrad, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonUebernehmen))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jButtonHoch, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonRunter)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldGrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonUebernehmen))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonHoch)
                    .addComponent(jButtonRunter))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void jButtonHochActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHochActionPerformed
      this.temperatur.setFahrenheit(temperatur.getFahrenheit() + 1);
  }//GEN-LAST:event_jButtonHochActionPerformed

  private void jButtonRunterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRunterActionPerformed
      this.temperatur.setFahrenheit(temperatur.getFahrenheit() - 1);
  }//GEN-LAST:event_jButtonRunterActionPerformed

  private void jButtonUebernehmenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUebernehmenActionPerformed
      this.temperatur.setFahrenheit(Double.parseDouble(jTextFieldGrad.getText()));
  }//GEN-LAST:event_jButtonUebernehmenActionPerformed

    @Override
    public void propertyChange(PropertyChangeEvent arg0) {
        if (arg0.getPropertyName().equalsIgnoreCase("Temperatur")) {
            jTextFieldGrad.setText(String.format("%.2f", temperatur.getFahrenheit()));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonHoch;
    private javax.swing.JButton jButtonRunter;
    private javax.swing.JButton jButtonUebernehmen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextFieldGrad;
    // End of variables declaration//GEN-END:variables
}
