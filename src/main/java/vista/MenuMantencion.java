
package vista;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.swing.JOptionPane;
public class MenuMantencion extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MenuMantencion.class.getName());

    public MenuMantencion() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarTablaPendientes();
        
    }

    private void cargarTablaPendientes() {
        dao.MantenimientoDAO mDao = new dao.MantenimientoDAO();
        java.util.List<Object[]> lista = mDao.listarMantenimientosPendientes(); 

        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) jTableMantenimientosPendientes.getModel();
        modelo.setRowCount(0);

        for (Object[] fila : lista) {
            modelo.addRow(fila);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMantenimientosPendientes = new javax.swing.JTable();
        txtId = new javax.swing.JTextField();
        txtPatente = new javax.swing.JTextField();
        txtKm = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtRegistroServicio = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        btnFinalizarServicio = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        btnTicketDirecto = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Panel de Control de Taller - Mantención");

        jTableMantenimientosPendientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Patente", "Marca", "Modelo", "KM Programado"
            }
        ));
        jTableMantenimientosPendientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMantenimientosPendientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMantenimientosPendientes);

        txtRegistroServicio.setColumns(20);
        txtRegistroServicio.setRows(5);
        jScrollPane2.setViewportView(txtRegistroServicio);

        jLabel2.setText("Registro Servicio:");

        btnFinalizarServicio.setText("Finalizar Servicio");
        btnFinalizarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarServicioActionPerformed(evt);
            }
        });

        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        btnTicketDirecto.setText("Registrar Mantención");
        btnTicketDirecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTicketDirectoActionPerformed(evt);
            }
        });

        jLabel3.setText("Mantenciones preventivas pendientes:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtKm, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtPatente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                        .addComponent(txtId))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(btnFinalizarServicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTicketDirecto, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(btnTicketDirecto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPatente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrarSesion)
                    .addComponent(btnFinalizarServicio))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarServicioActionPerformed

        int fila = jTableMantenimientosPendientes.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un mantenimiento de la lista.");
                return;
            }

            String idTicket = jTableMantenimientosPendientes.getValueAt(fila, 0).toString();
            String patente = jTableMantenimientosPendientes.getValueAt(fila, 1).toString(); // Nueva
            int kmProgramado = Integer.parseInt(jTableMantenimientosPendientes.getValueAt(fila, 4).toString()); // Nuevo
            String registro = txtRegistroServicio.getText().trim();

            if (registro.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, detalle lo realizado en el servicio.");
                return;
            }

            if (new dao.MantenimientoDAO().finalizarServicio(idTicket, registro, patente, kmProgramado)) {
                JOptionPane.showMessageDialog(this, "Ticket finalizado y Kilometraje de camión actualizado.");
                cargarTablaPendientes();
                txtRegistroServicio.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Error: No se pudo actualizar el ticket.");
            }

    }//GEN-LAST:event_btnFinalizarServicioActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed

        int resp = JOptionPane.showConfirmDialog(this, "¿Deseas cerrar tu sesión actual?", 
                "Cerrar Sesión", JOptionPane.YES_NO_OPTION);

        if (resp == JOptionPane.YES_OPTION) {
            modelo.SesionUsuario.cerrarSesion(); 

            new Login().setVisible(true);

            this.dispose();
        }
        
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void jTableMantenimientosPendientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMantenimientosPendientesMouseClicked

        int fila = jTableMantenimientosPendientes.getSelectedRow();
        if (fila != -1) {
            txtId.setText(jTableMantenimientosPendientes.getValueAt(fila, 0).toString());
            txtPatente.setText(jTableMantenimientosPendientes.getValueAt(fila, 1).toString());
            txtKm.setText(jTableMantenimientosPendientes.getValueAt(fila, 4).toString());

            txtId.setEditable(false);
            txtPatente.setEditable(false);
            txtKm.setEditable(false);
        }
    }//GEN-LAST:event_jTableMantenimientosPendientesMouseClicked

    private void btnTicketDirectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTicketDirectoActionPerformed
        dao.CamionDAO cDao = new dao.CamionDAO();
        List<String> patentes = cDao.listarPatentes();

        if (patentes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay camiones en estado ACTIVO para mantención.");
            return;
        }

        javax.swing.JComboBox<String> comboPatentes = new javax.swing.JComboBox<>(patentes.toArray(String[]::new));

        int opcion = JOptionPane.showConfirmDialog(this, comboPatentes, "Seleccione Patente del Vehículo", JOptionPane.OK_CANCEL_OPTION);

        if (opcion == JOptionPane.OK_OPTION) {
            String patenteSeleccionada = (String) comboPatentes.getSelectedItem();

            String motivo = JOptionPane.showInputDialog(this, "Describa el motivo del mantenimiento (ej: Cambio de luces):");
            if (motivo == null || motivo.trim().isEmpty()) return;

            String nombreSolicitante = modelo.SesionUsuario.getNombreCompleto(); 
            int kmActual = cDao.obtenerKilometrajeActual(patenteSeleccionada);

            if (new dao.MantenimientoDAO().crearMantencionDirecta(patenteSeleccionada, kmActual, motivo, nombreSolicitante) != -1) {
                JOptionPane.showMessageDialog(this, "Ticket abierto con éxito por: " + nombreSolicitante);
                cargarTablaPendientes(); // Refresca la lista de Alexandra
            } else {
                JOptionPane.showMessageDialog(this, "Error al crear el ticket. Reintente.");
            }
        }
    }//GEN-LAST:event_btnTicketDirectoActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MenuMantencion().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnFinalizarServicio;
    private javax.swing.JButton btnTicketDirecto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableMantenimientosPendientes;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtKm;
    private javax.swing.JTextField txtPatente;
    private javax.swing.JTextArea txtRegistroServicio;
    // End of variables declaration//GEN-END:variables
}
