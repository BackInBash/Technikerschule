package de.its.fti;

import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.JColorChooser;

public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
        erzeugeDaten();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        pnlOverview = new javax.swing.JPanel();
        scrpnOverview = new javax.swing.JScrollPane();
        lstOverview = new javax.swing.JList();
        pnlDetail = new javax.swing.JPanel();
        tbpnDetail = new javax.swing.JTabbedPane();
        pnlRectangle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfRectangleLength = new javax.swing.JTextField();
        tfRectangleWidth = new javax.swing.JTextField();
        pnlTriangle = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfTriangleBaseline = new javax.swing.JTextField();
        tfTriangleHeight = new javax.swing.JTextField();
        pnlCircle = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tfCircleRadius = new javax.swing.JTextField();
        btnSelectColor = new javax.swing.JButton();
        pnlControl = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlOverview.setBorder(javax.swing.BorderFactory.createTitledBorder("Übersicht"));

        lstOverview.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstOverview.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstOverviewValueChanged(evt);
            }
        });
        scrpnOverview.setViewportView(lstOverview);

        javax.swing.GroupLayout pnlOverviewLayout = new javax.swing.GroupLayout(pnlOverview);
        pnlOverview.setLayout(pnlOverviewLayout);
        pnlOverviewLayout.setHorizontalGroup(
            pnlOverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOverviewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrpnOverview, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlOverviewLayout.setVerticalGroup(
            pnlOverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOverviewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrpnOverview)
                .addContainerGap())
        );

        pnlDetail.setBorder(javax.swing.BorderFactory.createTitledBorder("Details"));

        jLabel1.setText("Länge");

        jLabel2.setText("Breite");

        javax.swing.GroupLayout pnlRectangleLayout = new javax.swing.GroupLayout(pnlRectangle);
        pnlRectangle.setLayout(pnlRectangleLayout);
        pnlRectangleLayout.setHorizontalGroup(
            pnlRectangleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRectangleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRectangleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlRectangleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfRectangleWidth, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(tfRectangleLength))
                .addContainerGap())
        );
        pnlRectangleLayout.setVerticalGroup(
            pnlRectangleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRectangleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRectangleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(tfRectangleLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRectangleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfRectangleWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        tbpnDetail.addTab("Rechteck", pnlRectangle);

        jLabel4.setText("Grundlinie");

        jLabel5.setText("Hoehe");

        javax.swing.GroupLayout pnlTriangleLayout = new javax.swing.GroupLayout(pnlTriangle);
        pnlTriangle.setLayout(pnlTriangleLayout);
        pnlTriangleLayout.setHorizontalGroup(
            pnlTriangleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTriangleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTriangleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(pnlTriangleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfTriangleBaseline, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                    .addComponent(tfTriangleHeight))
                .addContainerGap())
        );
        pnlTriangleLayout.setVerticalGroup(
            pnlTriangleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTriangleLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pnlTriangleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfTriangleBaseline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTriangleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfTriangleHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        tbpnDetail.addTab("Dreieck", pnlTriangle);

        jLabel6.setText("Radius");

        javax.swing.GroupLayout pnlCircleLayout = new javax.swing.GroupLayout(pnlCircle);
        pnlCircle.setLayout(pnlCircleLayout);
        pnlCircleLayout.setHorizontalGroup(
            pnlCircleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCircleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(tfCircleRadius, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlCircleLayout.setVerticalGroup(
            pnlCircleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCircleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCircleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfCircleRadius, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        tbpnDetail.addTab("Kreis", pnlCircle);

        btnSelectColor.setText("Farbe");
        btnSelectColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectColorActionPerformed(evt);
            }
        });

        pnlControl.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        btnAdd.setText("hinzufügen");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        pnlControl.add(btnAdd);

        btnUpdate.setText("ändern");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        pnlControl.add(btnUpdate);

        javax.swing.GroupLayout pnlDetailLayout = new javax.swing.GroupLayout(pnlDetail);
        pnlDetail.setLayout(pnlDetailLayout);
        pnlDetailLayout.setHorizontalGroup(
            pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDetailLayout.createSequentialGroup()
                        .addComponent(btnSelectColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetailLayout.createSequentialGroup()
                        .addGroup(pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlControl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tbpnDetail))
                        .addContainerGap())))
        );
        pnlDetailLayout.setVerticalGroup(
            pnlDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetailLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnSelectColor)
                .addGap(18, 18, 18)
                .addComponent(tbpnDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tbpnDetail.getAccessibleContext().setAccessibleName("rechteck");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlOverview, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlOverview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void erzeugeDaten(){
        Rechteck r = new Rechteck();
        r.setBreite(22.0);
        r.setHoehe(21.0);
        r.setFarbe(Color.RED);
        ListeGeometrischeFiguren.add(r);
        
        Dreieck d = new Dreieck();
        d.setGrundlinie(4.2);
        d.setHoehe(2.1);
        d.setFarbe(Color.GREEN);
        ListeGeometrischeFiguren.add(d);
        
        Kreis k = new Kreis();
        k.setRadius(8.7);
        k.setFarbe(Color.BLUE);
        ListeGeometrischeFiguren.add(k);
        
        DefaultListModel listModel = new DefaultListModel();
        listModel.addAll(ListeGeometrischeFiguren.get());
        lstOverview.setModel(listModel);
    }
    
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        switch (tbpnDetail.getSelectedIndex()) {
            case 0:
                Rechteck r = new Rechteck();
                r.setBreite(Double.parseDouble(tfRectangleLength.getText()));
                r.setHoehe(Double.parseDouble(tfRectangleWidth.getText()));
                r.setFarbe(btnSelectColor.getBackground());
                ListeGeometrischeFiguren.add(r);
                tfRectangleLength.setText("");
                tfRectangleWidth.setText("");
                btnSelectColor.setBackground(null);
                break;
            case 1:
                Dreieck d = new Dreieck();
                d.setGrundlinie(Double.parseDouble(tfTriangleBaseline.getText()));
                d.setHoehe(Double.parseDouble(tfTriangleHeight.getText()));
                d.setFarbe(btnSelectColor.getBackground());
                ListeGeometrischeFiguren.add(d);
                tfTriangleBaseline.setText("");
                tfTriangleHeight.setText("");
                btnSelectColor.setBackground(null);
                break;
            case 2:
                Kreis k = new Kreis();
                k.setRadius(Double.parseDouble(tfCircleRadius.getText()));
                k.setFarbe(btnSelectColor.getBackground());
                ListeGeometrischeFiguren.add(k);
                tfCircleRadius.setText("");
                btnSelectColor.setBackground(null);
                break;
        }
        DefaultListModel listModel = new DefaultListModel();
        listModel.addAll(ListeGeometrischeFiguren.get());
        lstOverview.setModel(listModel);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if (lstOverview.getSelectedValue() instanceof Rechteck) {
            tbpnDetail.setSelectedIndex(0);
            Rechteck r = (Rechteck) lstOverview.getSelectedValue();
            r.setBreite(Double.parseDouble(tfRectangleLength.getText()));
            r.setHoehe(Double.parseDouble(tfRectangleWidth.getText()));
            r.setFarbe(btnSelectColor.getBackground());
        }
        if (lstOverview.getSelectedValue() instanceof Dreieck) {
            tbpnDetail.setSelectedIndex(1);
            Dreieck d = (Dreieck) lstOverview.getSelectedValue();
            d.setGrundlinie(Double.parseDouble(tfTriangleBaseline.getText()));
            d.setHoehe(Double.parseDouble(tfTriangleHeight.getText()));
            d.setFarbe(btnSelectColor.getBackground());
        }
        if (lstOverview.getSelectedValue() instanceof Kreis) {
            tbpnDetail.setSelectedIndex(2);
            Kreis k = (Kreis) lstOverview.getSelectedValue();
            k.setRadius(Double.parseDouble(tfCircleRadius.getText()));
            k.setFarbe(btnSelectColor.getBackground());
        }
        DefaultListModel listModel = new DefaultListModel();
        listModel.addAll(ListeGeometrischeFiguren.get());
        lstOverview.setModel(listModel);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void lstOverviewValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstOverviewValueChanged
        // TODO add your handling code here:
        if (lstOverview.getSelectedValue() instanceof Rechteck) {
            tbpnDetail.setSelectedIndex(0);
            Rechteck r = (Rechteck) lstOverview.getSelectedValue();
            tfRectangleLength.setText(String.valueOf(r.getBreite()));
            tfRectangleWidth.setText(String.valueOf(r.getHoehe()));
            btnSelectColor.setBackground(r.getFarbe());
        }
        if (lstOverview.getSelectedValue() instanceof Dreieck) {
            tbpnDetail.setSelectedIndex(1);
            Dreieck d = (Dreieck) lstOverview.getSelectedValue();
            tfTriangleBaseline.setText(String.valueOf(d.getGrundlinie()));
            tfTriangleHeight.setText(String.valueOf(d.getHoehe()));
            btnSelectColor.setBackground(d.getFarbe());
        }
        if (lstOverview.getSelectedValue() instanceof Kreis) {
            tbpnDetail.setSelectedIndex(2);
            Kreis k = (Kreis) lstOverview.getSelectedValue();
            tfCircleRadius.setText(String.valueOf(k.getRadius()));
            btnSelectColor.setBackground(k.getFarbe());
        }
    }//GEN-LAST:event_lstOverviewValueChanged

    private void btnSelectColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectColorActionPerformed
        // TODO add your handling code here:
        Color ausgewaehlteFarbe = JColorChooser.showDialog(null,"Farbauswahl", null);
        btnSelectColor.setBackground(ausgewaehlteFarbe);
    }//GEN-LAST:event_btnSelectColorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnSelectColor;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList lstOverview;
    private javax.swing.JPanel pnlCircle;
    private javax.swing.JPanel pnlControl;
    private javax.swing.JPanel pnlDetail;
    private javax.swing.JPanel pnlOverview;
    private javax.swing.JPanel pnlRectangle;
    private javax.swing.JPanel pnlTriangle;
    private javax.swing.JScrollPane scrpnOverview;
    private javax.swing.JTabbedPane tbpnDetail;
    private javax.swing.JTextField tfCircleRadius;
    private javax.swing.JTextField tfRectangleLength;
    private javax.swing.JTextField tfRectangleWidth;
    private javax.swing.JTextField tfTriangleBaseline;
    private javax.swing.JTextField tfTriangleHeight;
    // End of variables declaration//GEN-END:variables
}
