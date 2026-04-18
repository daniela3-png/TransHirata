package vista;

import dao.CamionDAO;
import dao.RegistroKilometrajeDAO;
import javax.swing.JOptionPane;
import modelo.Camion;
import modelo.RegistroKilometraje;
import java.util.List;


public class RegistrarKilometraje extends javax.swing.JFrame {
    private Camion camionSeleccionado;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(RegistrarKilometraje.class.getName());

        public RegistrarKilometraje() {
                initComponents();
                setLocationRelativeTo(null);
                cargarCamion();
                txtKilometrajeActual.setEditable(false);
            }

        private void cargarCamion() {
            try {
                CamionDAO dao = new CamionDAO();
                List<Camion> listaCamiones = dao.listarCamiones();
                jComboBox1.removeAllItems();
                jComboBox1.addItem("Seleccione un camión");

                if (listaCamiones != null) {
                    for (Camion c : listaCamiones) {
                        jComboBox1.addItem(c.getPatente());
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al cargar camiones: " + e.getMessage());
            }
        }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGuardar = new javax.swing.JButton();
        txtNuevoKilometraje = new javax.swing.JTextField();
        txtKilometrajeActual = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Nuevo Kilometraje:");

        jLabel2.setText("Kilometraje Actual:");

        jLabel3.setText("Patente:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Registro de Uso");

        btnCerrarSesion.setText("Cerrar Sesion");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtKilometrajeActual, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNuevoKilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKilometrajeActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNuevoKilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(btnCerrarSesion)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (camionSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un camión primero.");
            return;
        }

        String textoNuevoKilometraje = txtNuevoKilometraje.getText().trim();
        if (textoNuevoKilometraje.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el nuevo kilometraje.");
            return;
        }

        try {
            int nuevoKilometraje = Integer.parseInt(textoNuevoKilometraje);
            int kmActual = camionSeleccionado.getKilometrajeActual();

            if (nuevoKilometraje < kmActual) {
                JOptionPane.showMessageDialog(this, "El kilometraje no puede retroceder.");
                return;
            }

            int proximoMantencion = ((kmActual / 5000) + 1) * 5000;

            if (nuevoKilometraje >= (proximoMantencion - 100) && nuevoKilometraje < proximoMantencion) {
                int opcion = JOptionPane.showConfirmDialog(this, 
                    "Faltan menos de 100km para la mantención (" + proximoMantencion + "km).\n¿Agendar ahora?",
                    "Aviso de Seguridad", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {
                    agendarNuevaCita(proximoMantencion);
                }
            }

            if (nuevoKilometraje >= proximoMantencion) {
                int rpta = JOptionPane.showConfirmDialog(this, 
                    "¡BLOQUEO! El camión alcanzó los " + proximoMantencion + "km.\n" +
                    "¿Deseas agendar la mantención ahora para obtener tu correlativo?", 
                    "Seguridad Trans Hirata", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if (rpta == JOptionPane.YES_OPTION) {
                    agendarNuevaCita(proximoMantencion);
                }
                return;
            }

            RegistroKilometraje registro = new RegistroKilometraje();
            registro.setPatente(camionSeleccionado.getPatente());
            registro.setKilometraje(nuevoKilometraje);

            if (new RegistroKilometrajeDAO().guardarRegistro(registro) && 
                new CamionDAO().actualizarKilometraje(camionSeleccionado.getPatente(), nuevoKilometraje)) {
                
                JOptionPane.showMessageDialog(this, "Kilometraje actualizado con éxito.");
                txtKilometrajeActual.setText(String.valueOf(nuevoKilometraje));
                txtNuevoKilometraje.setText("");
                camionSeleccionado.setKilometrajeActual(nuevoKilometraje);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese solo números enteros.");
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
            String patente = (String) jComboBox1.getSelectedItem();

            if (patente != null && !patente.equals("Seleccione un camión")) {
                camionSeleccionado = new dao.CamionDAO().buscarCamionPorPatente(patente);

                if (camionSeleccionado != null) {
                    txtKilometrajeActual.setText(String.valueOf(camionSeleccionado.getKilometrajeActual()));
                }
            } else {
                camionSeleccionado = null;
                txtKilometrajeActual.setText("");
            }
        

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed

        int resp = JOptionPane.showConfirmDialog(this, "¿Deseas cerrar tu sesión actual?", 
                "Cerrar Sesión", JOptionPane.YES_NO_OPTION);

        if (resp == JOptionPane.YES_OPTION) {
            modelo.SesionUsuario.cerrarSesion(); 

            new Login().setVisible(true);

            this.dispose();
        }

    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void agendarNuevaCita(int kmProg) {
        modelo.Usuario actual = modelo.SesionUsuario.getUsuario();
        if (actual == null) {
            JOptionPane.showMessageDialog(this, "Error: No hay sesión activa.");
            return;
        }

        String solicitante = modelo.SesionUsuario.getNombreCompleto();
        
        com.toedter.calendar.JDateChooser chooser = new com.toedter.calendar.JDateChooser();
        chooser.setDate(new java.util.Date());

        Object[] params = {"Seleccione fecha para mantención de " + kmProg + "km:", chooser};
        int res = JOptionPane.showConfirmDialog(this, params, "Agendar Cita", JOptionPane.OK_CANCEL_OPTION);

        if (res == JOptionPane.OK_OPTION) {
            java.sql.Date fechaSQL = new java.sql.Date(chooser.getDate().getTime());

            dao.MantenimientoDAO mDao = new dao.MantenimientoDAO();

            int correlativo = mDao.agendarMantencion(camionSeleccionado.getPatente(), kmProg, solicitante, fechaSQL);

            if (correlativo != -1) {
                JOptionPane.showMessageDialog(this, 
                    "¡Cita agendada con éxito!\nSolicitante: " + solicitante + 
                    "\nNÚMERO CORRELATIVO: " + correlativo);

                HistorialMantenciones historial = new HistorialMantenciones();
                historial.setVisible(true);
                this.dispose();
            }       
            
        }
    }
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new RegistrarKilometraje().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtKilometrajeActual;
    private javax.swing.JTextField txtNuevoKilometraje;
    // End of variables declaration//GEN-END:variables
}
