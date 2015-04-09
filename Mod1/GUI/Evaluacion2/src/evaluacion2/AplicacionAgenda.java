
package evaluacion2;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Dani
 */
public class AplicacionAgenda extends javax.swing.JFrame {
    
    private Agenda agenda;
    LinkedList<Contacto> listaTemporal;
    private Contacto contacto;
    private int tama�o = 0;

    /** Creates new form AplicacionAgenda */
    public AplicacionAgenda() {
        initComponents();
        agenda = new Agenda();
        contacto = new Contacto();
        listaTemporal = new LinkedList<Contacto>();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        bg = new javax.swing.ButtonGroup();
        botonLimpiar = new javax.swing.JButton();
        botonA�adir = new javax.swing.JButton();
        botonConsulta = new javax.swing.JButton();
        botonSiguiente = new javax.swing.JButton();
        botonAmigo = new javax.swing.JRadioButton();
        botonConocido = new javax.swing.JRadioButton();
        botonTrabajo = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cuadroNombre = new javax.swing.JTextField();
        cuadroTelefono = new javax.swing.JTextField();
        cuadroEmail = new javax.swing.JTextField();
        cuadroDireccion = new javax.swing.JTextField();
        cuadroProvincia = new javax.swing.JTextField();
        etiquetaString = new javax.swing.JLabel();

        bg.add(botonAmigo);
        bg.add(botonConocido);
        bg.add(botonTrabajo);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mis contactos");

        botonLimpiar.setText("Limpiar");
        botonLimpiar.setToolTipText("boton para limpiar");
        botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarActionPerformed(evt);
            }
        });

        botonA�adir.setText("A�adir");
        botonA�adir.setToolTipText("boton para a�adir");
        botonA�adir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonA�adirActionPerformed(evt);
            }
        });

        botonConsulta.setText("Consultar");
        botonConsulta.setToolTipText("boton para consultar");
        botonConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultaActionPerformed(evt);
            }
        });

        botonSiguiente.setText("Siguiente");
        botonSiguiente.setToolTipText("boton para siguiente");
        botonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSiguienteActionPerformed(evt);
            }
        });

        botonAmigo.setText("Amigo");
        botonAmigo.setToolTipText("boton para amigo");

        botonConocido.setText("Conocido");
        botonConocido.setToolTipText("boton para conocido");

        botonTrabajo.setText("Trabajo");
        botonTrabajo.setToolTipText("boton para trabajo");

        jLabel1.setText("Nombre");
        jLabel1.setToolTipText("etiquita para nombre");

        jLabel2.setText("Telefono");
        jLabel2.setToolTipText("etiqueta para telefono");

        jLabel3.setText("Email");
        jLabel3.setToolTipText("etiqueta para email");

        jLabel4.setText("Direccion");
        jLabel4.setToolTipText("etiqueta para direccion");

        jLabel5.setText("Provincia");
        jLabel5.setToolTipText("etiquieta para provincia");

        cuadroNombre.setToolTipText("cuadro texto nombre");

        cuadroTelefono.setToolTipText("cuadro texto Telefono");

        cuadroEmail.setToolTipText("cuadro texto Email");

        cuadroDireccion.setToolTipText("cuadro texto direccion");

        cuadroProvincia.setToolTipText("cuadro texto Provincia");

        etiquetaString.setToolTipText("etiqueta que devuelve valores");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonLimpiar)
                        .addGap(18, 18, 18)
                        .addComponent(botonA�adir)
                        .addGap(18, 18, 18)
                        .addComponent(botonConsulta)
                        .addGap(18, 18, 18)
                        .addComponent(botonSiguiente)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cuadroNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cuadroProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cuadroDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(130, 182, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cuadroEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cuadroTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonConocido, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonTrabajo)
                            .addComponent(botonAmigo))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(etiquetaString, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cuadroNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(botonAmigo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cuadroTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonConocido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonTrabajo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cuadroEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cuadroDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cuadroProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonLimpiar)
                    .addComponent(botonA�adir)
                    .addComponent(botonConsulta)
                    .addComponent(botonSiguiente))
                .addGap(18, 18, 18)
                .addComponent(etiquetaString, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
    }//GEN-END:initComponents

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        // TODO add your handling code here:
        cuadroNombre.setText("");
        cuadroTelefono.setText("");
        cuadroEmail.setText("");
        cuadroDireccion.setText("");
        cuadroProvincia.setText("");
        etiquetaString.setText("");
    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void botonA�adirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonA�adirActionPerformed
        // TODO add your handling code here:
        if(cuadroNombre.getText().isEmpty() || cuadroTelefono.getText().isEmpty() || cuadroEmail.getText().isEmpty() || cuadroDireccion.getText().isEmpty() || cuadroProvincia.getText().isEmpty()){
            etiquetaString.setText("No se puede a�adir el contacto, hay campos vacios");
        } else {
            Contacto temporal = new Contacto();
            temporal.setNombre(cuadroNombre.getText());
            temporal.setTelefono(cuadroTelefono.getText());
            temporal.setEmail(cuadroEmail.getText());
            temporal.setDireccion(cuadroDireccion.getText());
            temporal.setProvincia(cuadroProvincia.getText());
            
            String resultado = "";
            resultado += agenda.insertar(temporal);
            etiquetaString.setText(resultado);
            
        }
    }//GEN-LAST:event_botonA�adirActionPerformed

    private void botonConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultaActionPerformed
        // TODO add your handling code here:
        if(cuadroNombre.getText().isEmpty()){
            etiquetaString.setText("Debe rellenar el cuadro Nombre para poder hacer la consulta");
        } else {
            String nombre = cuadroNombre.getText();
            listaTemporal = agenda.consultarDatosContacto(nombre);  
            tama�o = (listaTemporal.size());
            if(tama�o >0){
                botonSiguiente.enable();
                cuadroTelefono.setText(listaTemporal.get(0).getTelefono());
                cuadroEmail.setText(listaTemporal.get(0).getEmail());
                cuadroDireccion.setText(listaTemporal.get(0).getDireccion());
                cuadroProvincia.setText(listaTemporal.get(0).getProvincia());
            }
        }
        
    }//GEN-LAST:event_botonConsultaActionPerformed

    private void botonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSiguienteActionPerformed
        // TODO add your handling code here:
        int prueba = tama�o;
        for(int i=1;i<prueba;i++){
            cuadroNombre.setText("");
            cuadroTelefono.setText("");
            cuadroEmail.setText("");
            cuadroDireccion.setText("");
            cuadroProvincia.setText("");
            etiquetaString.setText("");
            cuadroNombre.setText(listaTemporal.get(i).getNombre());
            cuadroTelefono.setText(listaTemporal.get(i).getTelefono());
            cuadroEmail.setText(listaTemporal.get(i).getEmail());
            cuadroDireccion.setText(listaTemporal.get(i).getDireccion());
            cuadroProvincia.setText(listaTemporal.get(i).getProvincia());
        }
    }//GEN-LAST:event_botonSiguienteActionPerformed

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
    private javax.swing.ButtonGroup bg;
    private javax.swing.JRadioButton botonAmigo;
    private javax.swing.JButton botonA�adir;
    private javax.swing.JRadioButton botonConocido;
    private javax.swing.JButton botonConsulta;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JButton botonSiguiente;
    private javax.swing.JRadioButton botonTrabajo;
    private javax.swing.JTextField cuadroDireccion;
    private javax.swing.JTextField cuadroEmail;
    private javax.swing.JTextField cuadroNombre;
    private javax.swing.JTextField cuadroProvincia;
    private javax.swing.JTextField cuadroTelefono;
    private javax.swing.JLabel etiquetaString;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables

}
