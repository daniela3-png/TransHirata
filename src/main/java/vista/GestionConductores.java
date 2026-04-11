package vista;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class GestionConductores extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GestionConductores.class.getName());

    public GestionConductores() {
        initComponents();
        setLocationRelativeTo(null);
        cargarTabla();
    }

        private void limpiarCampos() {
        txtRut.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtPass.setText("");
    }
        
    private void cargarTabla() {
        dao.UsuarioDAO uDao = new dao.UsuarioDAO();
        java.util.List<modelo.Usuario> lista = uDao.listarUsuariosPorRol("CONDUCTOR");

        javax.swing.table.DefaultTableModel modeloTabla = new javax.swing.table.DefaultTableModel();
        modeloTabla.addColumn("RUT");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Apellido");

        for (modelo.Usuario u : lista) {
            Object[] fila = {
                u.getRut(),
                u.getNombre(),
                u.getApellido()
            };
            modeloTabla.addRow(fila);
        }

        jTableConductores.setModel(modeloTabla); 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtRut = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableConductores = new javax.swing.JTable();
        txtApellido = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        txtPass = new javax.swing.JTextField();
        Patente = new javax.swing.JLabel();
        Patente1 = new javax.swing.JLabel();
        Patente2 = new javax.swing.JLabel();
        Patente3 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Registro de Conductores");

        jTableConductores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "RUT", "Nombre", "Apellido", "Contraseña"
            }
        ));
        jTableConductores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableConductoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableConductores);

        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        Patente.setText("RUT:");

        Patente1.setText("Nombre:");

        Patente2.setText("Apellido:");

        Patente3.setText("Contraseña:");

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel2.setText("Administrador");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Patente3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Patente, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Patente2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Patente1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(32, 32, 32)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNombre)
                                            .addComponent(txtRut)
                                            .addComponent(txtApellido)
                                            .addComponent(txtPass)
                                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Patente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Patente1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Patente2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Patente3))
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnVolver))
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
                String rut = txtRut.getText().trim();
                String nombre = txtNombre.getText().trim();
                String apellido = txtApellido.getText().trim();
                String pass = txtPass.getText().trim();

                if (rut.isEmpty() || nombre.isEmpty() || apellido.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Nombre, Apellido y RUT son obligatorios.");
                    return;
                }

                modelo.Usuario user = new modelo.Usuario();
                user.setRut(rut);
                user.setNombre(nombre);
                user.setApellido(apellido);
                user.setContrasena(pass);
                user.setRol("CONDUCTOR");

                dao.UsuarioDAO uDao = new dao.UsuarioDAO();

                if (!txtRut.isEditable()) {
                    if (uDao.modificarConductor(user)) {
                        JOptionPane.showMessageDialog(this, "Datos del conductor actualizados.");
                    }
                } else {
                    if (uDao.insertarUsuario(user)) {
                        JOptionPane.showMessageDialog(this, "Nuevo conductor registrado.");
                    }
                }

                txtRut.setEditable(true);
                limpiarCampos();
                cargarTabla();

            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(this, "Error al procesar: " + e.getMessage());
            }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
            int fila = jTableConductores.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Selecciona a un conductor de la tabla.");
                return;
            }
            String rut = jTableConductores.getValueAt(fila, 0).toString();

            int confirm = JOptionPane.showConfirmDialog(this, "¿Eliminar permanentemente al conductor con RUT " + rut + "?");
            if (confirm == JOptionPane.YES_OPTION) {
                if (new dao.UsuarioDAO().eliminarConductor(rut)) {
                    JOptionPane.showMessageDialog(this, "Conductor eliminado con éxito.");
                    cargarTabla();
                }
            }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        new MenuAdmin().setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnVolverActionPerformed

    private void jTableConductoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableConductoresMouseClicked

    int fila = jTableConductores.getSelectedRow();
        if (fila != -1) {
            txtRut.setText(jTableConductores.getValueAt(fila, 0).toString());
            txtNombre.setText(jTableConductores.getValueAt(fila, 1).toString());
            txtApellido.setText(jTableConductores.getValueAt(fila, 2).toString());

            txtPass.setText(""); 

            txtRut.setEditable(false); 
        }
    }//GEN-LAST:event_jTableConductoresMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new GestionConductores().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Patente;
    private javax.swing.JLabel Patente1;
    private javax.swing.JLabel Patente2;
    private javax.swing.JLabel Patente3;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableConductores;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtRut;
    // End of variables declaration//GEN-END:variables

}
