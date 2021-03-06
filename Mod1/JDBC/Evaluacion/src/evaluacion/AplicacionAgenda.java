
package evaluacion;

import java.sql.ResultSet;


import java.sql.SQLException;

import java.util.Collection;
import java.util.List;
import java.util.TimeZone;

import javax.swing.JOptionPane;

/**
 *
 * @author Dani
 */
public class AplicacionAgenda extends javax.swing.JFrame {

    private AgendaDAO ag;
    private AgendaOracleDAO con = null;
    private ResultSet res = null;
    private int total = 0;

    /** Creates new form AplicacionAgenda */
    public AplicacionAgenda() {
        try {
            inicializarTimeZone();
            initComponents(); 
            botonSiguiente.setEnabled(false);
            botonUltimo.setEnabled(false);
            botonAnterior.setEnabled(false);
            botonPrimero.setEnabled(false);
            con = new AgendaOracleDAO();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Exception " +ex+ "\nNo se ha a�adido el registro", "Error", JOptionPane.ERROR_MESSAGE); 
        }
    }
    
    private void inicializarTimeZone(){
        TimeZone timeZone = TimeZone.getTimeZone("GTM+1");
        TimeZone.setDefault(timeZone);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        etiquetaNombre = new javax.swing.JLabel();
        etiquetaTelefono = new javax.swing.JLabel();
        etiquetaDireccion = new javax.swing.JLabel();
        etiquetaCodigoPostal = new javax.swing.JLabel();
        etiquetaProvincia = new javax.swing.JLabel();
        cuadroNombre = new javax.swing.JTextField();
        cuadroTelefono = new javax.swing.JTextField();
        cuadroDireccion = new javax.swing.JTextField();
        cuadroPostal = new javax.swing.JTextField();
        cuadroProvincia = new javax.swing.JTextField();
        botonLimpiar = new javax.swing.JButton();
        botonA�adir = new javax.swing.JButton();
        botonConsultar = new javax.swing.JButton();
        botonPrimero = new javax.swing.JButton();
        botonAnterior = new javax.swing.JButton();
        botonSiguiente = new javax.swing.JButton();
        botonUltimo = new javax.swing.JButton();
        etiquetaMensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Base de datos Agenda");

        etiquetaNombre.setText("Nombre");

        etiquetaTelefono.setText("Telefono");

        etiquetaDireccion.setText("Direccion");

        etiquetaCodigoPostal.setText("Codigo Postal");

        etiquetaProvincia.setText("Provincia");

        botonLimpiar.setText("Limpiar");
        botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarActionPerformed(evt);
            }
        });

        botonA�adir.setText("A�adir");
        botonA�adir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonA�adirActionPerformed(evt);
            }
        });

        botonConsultar.setText("Consultar");
        botonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultarActionPerformed(evt);
            }
        });

        botonPrimero.setText("<<");
        botonPrimero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPrimeroActionPerformed(evt);
            }
        });

        botonAnterior.setText("<");
        botonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnteriorActionPerformed(evt);
            }
        });

        botonSiguiente.setText(">");
        botonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSiguienteActionPerformed(evt);
            }
        });

        botonUltimo.setText(">>");
        botonUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonUltimoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiquetaCodigoPostal)
                                    .addComponent(etiquetaProvincia))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cuadroPostal)
                                    .addComponent(cuadroProvincia)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaDireccion)
                                .addGap(40, 40, 40)
                                .addComponent(cuadroDireccion))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaTelefono)
                                .addGap(41, 41, 41)
                                .addComponent(cuadroTelefono))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaNombre)
                                .addGap(46, 46, 46)
                                .addComponent(cuadroNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(botonLimpiar)
                        .addGap(18, 18, 18)
                        .addComponent(botonA�adir)
                        .addGap(18, 18, 18)
                        .addComponent(botonConsultar)
                        .addGap(18, 18, 18)
                        .addComponent(botonPrimero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonAnterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonSiguiente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(etiquetaMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaNombre)
                    .addComponent(cuadroNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaTelefono)
                    .addComponent(cuadroTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaDireccion)
                    .addComponent(cuadroDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaCodigoPostal)
                    .addComponent(cuadroPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaProvincia)
                    .addComponent(cuadroProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonA�adir)
                    .addComponent(botonLimpiar)
                    .addComponent(botonConsultar)
                    .addComponent(botonPrimero)
                    .addComponent(botonAnterior)
                    .addComponent(botonSiguiente)
                    .addComponent(botonUltimo))
                .addGap(18, 18, 18)
                .addComponent(etiquetaMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }//GEN-END:initComponents

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        // TODO add your handling code here:
        muestraVacio();
    }//GEN-LAST:event_botonLimpiarActionPerformed
    
    private void muestraVacio(){
        cuadroNombre.setText("");
        cuadroTelefono.setText("");
        cuadroDireccion.setText("");
        cuadroProvincia.setText("");
        cuadroPostal.setText("");
        botonSiguiente.setEnabled(false);
        botonUltimo.setEnabled(false);
        botonAnterior.setEnabled(false);
        botonPrimero.setEnabled(false);
    }
    
    private void botonA�adirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonA�adirActionPerformed
        // TODO add your handling code here:
        try {
            Registro agenda = new Registro();
            con.insertar(agenda, res);
            muestraVacio();
            JOptionPane.showMessageDialog(this, "El registro se ha a�adido correctamente", "A�adir datos", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Exception SQL " +ex+ "\nNo se ha a�adido el registro", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex){
            JOptionPane.showMessageDialog(this, "Exception " +ex+ "\nNo se ha a�adido el registro", "Error", JOptionPane.ERROR_MESSAGE);     
        }
    }//GEN-LAST:event_botonA�adirActionPerformed

    private void botonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultarActionPerformed
        // TODO add your handling code here:
        try {
            res = con.consultar(obtenerAgenda());
            total = numeroFilas();
            if(!res.isAfterLast() && res.next()){
                muestraDatos();
            } else {
                muestraVacio();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Exception SQL " +ex+ "\nNo se ha a�adido el registro", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex){
            JOptionPane.showMessageDialog(this, "Exception " +ex+ "\nNo se ha a�adido el registro", "Error", JOptionPane.ERROR_MESSAGE);     
        }
    }//GEN-LAST:event_botonConsultarActionPerformed

    private void botonPrimeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPrimeroActionPerformed
        // TODO add your handling code here:
        try {
            if(res.first()){
                muestraDatos();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Exception SQL " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonPrimeroActionPerformed

    private void botonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnteriorActionPerformed
        // TODO add your handling code here:
        try {
            if(res.previous()){
                muestraDatos();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Exception SQL " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonAnteriorActionPerformed

    private void botonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSiguienteActionPerformed
        // TODO add your handling code here:
        try {
            if(!res.isAfterLast() && res.next()){
                muestraDatos();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Exception SQL " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonSiguienteActionPerformed

    private void botonUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonUltimoActionPerformed
        // TODO add your handling code here:
        try {
            if(res.last()){
                muestraDatos();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Exception SQL " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonUltimoActionPerformed
    
    private int numeroFilas() throws SQLException {
        res.last();
        return res.getRow();
    }
    
    private void muestraDatos() throws SQLException {
        cuadroNombre.setText(res.getString(1));
        cuadroTelefono.setText(res.getString(2));
        cuadroDireccion.setText(res.getString(3));
        cuadroPostal.setText(res.getString(4));
        cuadroProvincia.setText(res.getString(5));
        int num = res.getRow();
        if(num == total){
            botonUltimo.setEnabled(false);
            botonSiguiente.setEnabled(false);
        } else {
            botonUltimo.setEnabled(true);
            botonSiguiente.setEnabled(true);
        }
        if(num == 1){
            botonPrimero.setEnabled(false);
            botonAnterior.setEnabled(false);
        } else {
            botonPrimero.setEnabled(true);
            botonAnterior.setEnabled(true);
        }
    }
    
    private Registro obtenerAgenda(){
        Registro agenda = new Registro();
        agenda.setNombre(cuadroNombre.getText());
        agenda.setTelefono(cuadroTelefono.getText());
        agenda.setDireccion(cuadroDireccion.getText());
        if(cuadroPostal.getText().equals("")){
            agenda.setCodPostal(-1);
        } else {
            agenda.setCodPostal(Integer.parseInt(cuadroPostal.getText()));
        }
        agenda.setProvincia(cuadroProvincia.getText());
        return agenda;
    }
    
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
            java.util.logging.Logger.getLogger(AplicacionAgenda.class.getName()).log(java.util.logging.Level.SEVERE,
                                                                                     null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AplicacionAgenda.class.getName()).log(java.util.logging.Level.SEVERE,
                                                                                     null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AplicacionAgenda.class.getName()).log(java.util.logging.Level.SEVERE,
                                                                                     null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AplicacionAgenda.class.getName()).log(java.util.logging.Level.SEVERE,
                                                                                     null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AplicacionAgenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAnterior;
    private javax.swing.JButton botonA�adir;
    private javax.swing.JButton botonConsultar;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JButton botonPrimero;
    private javax.swing.JButton botonSiguiente;
    private javax.swing.JButton botonUltimo;
    private javax.swing.JTextField cuadroDireccion;
    private javax.swing.JTextField cuadroNombre;
    private javax.swing.JTextField cuadroPostal;
    private javax.swing.JTextField cuadroProvincia;
    private javax.swing.JTextField cuadroTelefono;
    private javax.swing.JLabel etiquetaCodigoPostal;
    private javax.swing.JLabel etiquetaDireccion;
    private javax.swing.JLabel etiquetaMensaje;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel etiquetaProvincia;
    private javax.swing.JLabel etiquetaTelefono;
    // End of variables declaration//GEN-END:variables

}
