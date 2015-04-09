
package ejercicio1;

/**
 *
 * @author Dani
 */
public class FrameEjercicio extends javax.swing.JFrame {
    
    private int contador=0;
    private boolean aparezco;

    /** Creates new form FrameEjercicio */
    public FrameEjercicio() {
        aparezco = true;
        contador = 1;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        botonAparezco = new javax.swing.JButton();
        etiqueta = new javax.swing.JLabel();
        texto = new javax.swing.JTextField();
        botonPulsar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonAparezco.setText("Aparezco");
        botonAparezco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAparezcoActionPerformed(evt);
            }
        });

        etiqueta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        etiqueta.setText("Introduzca su nombre");

        texto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoActionPerformed(evt);
            }
        });

        botonPulsar.setText("Pulsar");
        botonPulsar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPulsarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(botonPulsar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(botonAparezco, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(etiqueta, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(texto, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAparezco, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonPulsar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(etiqueta)
                .addGap(28, 28, 28)
                .addComponent(texto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }//GEN-END:initComponents

    private void textoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoActionPerformed
        String s = texto.getText();
        botonPulsar.setText(s+" "+contador+" veces");
        contador++;  
    }//GEN-LAST:event_textoActionPerformed

    private void botonPulsarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPulsarActionPerformed
        aparezco = !aparezco;
        botonAparezco.setEnabled(aparezco);
    }//GEN-LAST:event_botonPulsarActionPerformed

    private void botonAparezcoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAparezcoActionPerformed
        aparezco = true;
        botonPulsar.setEnabled(true);
        botonPulsar.setText("Pulsar");
        texto.setText(" ");
        contador = 1;
    }//GEN-LAST:event_botonAparezcoActionPerformed

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
            java.util.logging.Logger.getLogger(FrameEjercicio.class.getName()).log(java.util.logging.Level.SEVERE, null,
                                                                                   ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameEjercicio.class.getName()).log(java.util.logging.Level.SEVERE, null,
                                                                                   ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameEjercicio.class.getName()).log(java.util.logging.Level.SEVERE, null,
                                                                                   ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameEjercicio.class.getName()).log(java.util.logging.Level.SEVERE, null,
                                                                                   ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameEjercicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAparezco;
    private javax.swing.JButton botonPulsar;
    private javax.swing.JLabel etiqueta;
    private javax.swing.JTextField texto;
    // End of variables declaration//GEN-END:variables

}