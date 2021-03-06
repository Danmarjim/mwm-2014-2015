
package evaluacion1;

import java.awt.Color;

/**
 *
 * @author Dani
 */
public class FrameEvaluacion extends javax.swing.JFrame {

    private int contador = 0;

    /** Creates new form FrameEvaluacion */
    public FrameEvaluacion() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        botonMas = new javax.swing.JButton();
        botonMenos = new javax.swing.JButton();
        etiqueta = new javax.swing.JLabel();
        cuadroTexto = new javax.swing.JTextField();
        cuadroPass = new javax.swing.JPasswordField();
        botonColor = new javax.swing.JButton();
        botonPrueba = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EVALUACION");

        botonMas.setText("+1");
        botonMas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonMasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonMasMouseEntered(evt);
            }
        });
        botonMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMasActionPerformed(evt);
            }
        });

        botonMenos.setText("-1");
        botonMenos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonMenosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonMenosMouseEntered(evt);
            }
        });
        botonMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenosActionPerformed(evt);
            }
        });

        etiqueta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                etiquetaMouseEntered(evt);
            }
        });

        cuadroTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuadroTextoActionPerformed(evt);
            }
        });

        cuadroPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuadroPassActionPerformed(evt);
            }
        });

        botonColor.setBackground(new java.awt.Color(102, 255, 0));
        botonColor.setText("0");
        botonColor.setActionCommand("0");
        botonColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonColorActionPerformed(evt);
            }
        });

        botonPrueba.setText("Boton de Prueba");
        botonPrueba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPruebaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cuadroPass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                        .addComponent(cuadroTexto, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonMas, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(etiqueta, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonColor, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonPrueba, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 44, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonMas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(etiqueta))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(botonColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cuadroTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonPrueba, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(cuadroPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }//GEN-END:initComponents

    private void botonMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMasActionPerformed
        if(contador==0){
            botonColor.setBackground(Color.green);
        }
        contador++;
        botonColor.setText(""+contador);
    }//GEN-LAST:event_botonMasActionPerformed

    private void botonMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMenosActionPerformed
        if(contador==0){
            botonColor.setBackground(Color.red);
            botonColor.setText(""+contador);
        } else if(contador>0){
            contador--;
            botonColor.setText(""+contador);
        }
    }//GEN-LAST:event_botonMenosActionPerformed

    private void cuadroTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuadroTextoActionPerformed
        String s = cuadroTexto.getText();
        etiqueta.setText(s);
    }//GEN-LAST:event_cuadroTextoActionPerformed

    private void botonMasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMasMouseClicked
        etiqueta.setText("Se ha pulsado el boton +1");
    }//GEN-LAST:event_botonMasMouseClicked

    private void botonMenosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMenosMouseClicked
        etiqueta.setText("Se ha pulsado el boton -1"); 
    }//GEN-LAST:event_botonMenosMouseClicked

    private void botonMenosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMenosMouseEntered
        etiqueta.setText("Ha pasado por encima del -1");
    }//GEN-LAST:event_botonMenosMouseEntered

    private void botonMasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMasMouseEntered
        etiqueta.setText("Ha pasado por encima del +1");
    }//GEN-LAST:event_botonMasMouseEntered

    private void cuadroPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuadroPassActionPerformed
        etiqueta.setText("password");
    }//GEN-LAST:event_cuadroPassActionPerformed

    private void botonColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonColorActionPerformed

    }//GEN-LAST:event_botonColorActionPerformed

    private void botonPruebaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPruebaActionPerformed
        
    }//GEN-LAST:event_botonPruebaActionPerformed

    private void etiquetaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etiquetaMouseEntered
        String s = etiqueta.getText();
        botonPrueba.setText(""+s);
    }//GEN-LAST:event_etiquetaMouseEntered

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
            java.util.logging.Logger.getLogger(FrameEvaluacion.class.getName()).log(java.util.logging.Level.SEVERE,
                                                                                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameEvaluacion.class.getName()).log(java.util.logging.Level.SEVERE,
                                                                                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameEvaluacion.class.getName()).log(java.util.logging.Level.SEVERE,
                                                                                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameEvaluacion.class.getName()).log(java.util.logging.Level.SEVERE,
                                                                                    null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameEvaluacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonColor;
    private javax.swing.JButton botonMas;
    private javax.swing.JButton botonMenos;
    private javax.swing.JButton botonPrueba;
    private javax.swing.JPasswordField cuadroPass;
    private javax.swing.JTextField cuadroTexto;
    private javax.swing.JLabel etiqueta;
    // End of variables declaration//GEN-END:variables

}
