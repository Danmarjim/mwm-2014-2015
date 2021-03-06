
package jws;

/**
 *
 * @author Dani
 */
public class MiAplicacion extends javax.swing.JFrame {

    private int contador = 0;

    /** Creates new form MiAplicacion */
    public MiAplicacion() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        bMensaje = new javax.swing.JButton();
        bLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        cuadroTexto = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bMensaje.setText("Mensaje");
        bMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMensajeActionPerformed(evt);
            }
        });

        bLimpiar.setText("Limpiar");
        bLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLimpiarActionPerformed(evt);
            }
        });

        cuadroTexto.setColumns(20);
        cuadroTexto.setRows(5);
        jScrollPane1.setViewportView(cuadroTexto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bMensaje)
                        .addGap(50, 50, 50)
                        .addComponent(bLimpiar)))
                .addContainerGap(174, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bMensaje)
                    .addComponent(bLimpiar))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pack();
    }//GEN-END:initComponents

    private void bMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMensajeActionPerformed
        // TODO add your handling code here:
        contador++;
        cuadroTexto.setText("Has pulsado " +contador+ " veces el boton de mensaje");
    }//GEN-LAST:event_bMensajeActionPerformed

    private void bLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLimpiarActionPerformed
        // TODO add your handling code here:
        cuadroTexto.setText("");
        contador = 0;
    }//GEN-LAST:event_bLimpiarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MiAplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null,
                                                                                 ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MiAplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null,
                                                                                 ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MiAplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null,
                                                                                 ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MiAplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null,
                                                                                 ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MiAplicacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bLimpiar;
    private javax.swing.JButton bMensaje;
    private javax.swing.JTextArea cuadroTexto;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
