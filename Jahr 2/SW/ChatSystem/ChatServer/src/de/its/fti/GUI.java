package de.its.fti;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class GUI extends javax.swing.JFrame {

    private ChatServer chatServer = null;
    private Thread chatThread;

    public GUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txa_Messages = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        bt_StartStopServer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txf_ServerPort = new javax.swing.JTextField();
        bt_DeleteArea = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat Server");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Messages"));

        txa_Messages.setEditable(false);
        txa_Messages.setColumns(20);
        txa_Messages.setRows(5);
        txa_Messages.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setViewportView(txa_Messages);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Conection"));

        bt_StartStopServer.setText("Start");
        bt_StartStopServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_StartStopServerActionPerformed(evt);
            }
        });

        jLabel1.setText("Port:");

        txf_ServerPort.setText("4712");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_StartStopServer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 87, Short.MAX_VALUE))
                    .addComponent(txf_ServerPort))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txf_ServerPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(bt_StartStopServer))
        );

        bt_DeleteArea.setText("Delete Message Area");
        bt_DeleteArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_DeleteAreaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_DeleteArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bt_DeleteArea)
                        .addGap(0, 122, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_StartStopServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_StartStopServerActionPerformed
        if (bt_StartStopServer.getText().equals("Start")) {
            try {
                bt_StartStopServer.setText("Stop");
                chatServer = new ChatServer(txa_Messages);
                chatThread = new Thread(chatServer);
                chatThread.start();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Server-Socket konnte nicht gestartet werden.", "Chat-Server", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            try {
                bt_StartStopServer.setText("Start");
                txa_Messages.append("- Server stopped\n");
                chatServer.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Server-Socket konnte nicht gestoppt werden.", "Chat-Server", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_bt_StartStopServerActionPerformed

    private void bt_DeleteAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_DeleteAreaActionPerformed
        txa_Messages.setText("");
    }//GEN-LAST:event_bt_DeleteAreaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_DeleteArea;
    private javax.swing.JButton bt_StartStopServer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txa_Messages;
    private javax.swing.JTextField txf_ServerPort;
    // End of variables declaration//GEN-END:variables
}
