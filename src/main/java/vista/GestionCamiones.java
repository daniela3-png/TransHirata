package vista;

import modelo.Camion;
import dao.CamionDAO;
import javax.swing.JOptionPane;

public class GestionCamiones extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GestionCamiones.class.getName());

    public GestionCamiones() {
        initComponents();
        setLocationRelativeTo(null);
        cargarTabla();

    }
    
    private void limpiarCampos() {
    txtPatente.setText("");
    txtMarca.setText("");
    txtModelo.setText("");
    txtAnio.setText("");
    txtKM.setText("");
    txtPatente.requestFocus();
}
    
    private void cargarTabla() {
        dao.CamionDAO dao = new dao.CamionDAO();
        java.util.List<modelo.Camion> lista = dao.listarCamiones();

        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel();
        modelo.addColumn("Patente");
        modelo.addColumn("Marca");
        modelo.addColumn("Modelo");
        modelo.addColumn("Año");
        modelo.addColumn("Kilometraje");

        for (modelo.Camion c : lista) {
            Object[] fila = {
                c.getPatente(),
                c.getMarca(),
                c.getModelo(),
                c.getAnio(),
                c.getKilometrajeActual()
            };
            modelo.addRow(fila);
        }
        jTableCamiones.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtPatente = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtAnio = new javax.swing.JTextField();
        txtKM = new javax.swing.JTextField();
        Patente = new javax.swing.JLabel();
        Patente1 = new javax.swing.JLabel();
        Patente2 = new javax.swing.JLabel();
        Patente3 = new javax.swing.JLabel();
        Patente4 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCamiones = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModeloActionPerformed(evt);
            }
        });

        txtKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKMActionPerformed(evt);
            }
        });

        Patente.setText("Patente:");

        Patente1.setText("Marca:");

        Patente2.setText("Modelo:");

        Patente3.setText("Año:");

        Patente4.setText("Kilometraje:");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jTableCamiones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Patente", "Marca", "Modelo", "Año", "Kilometraje"
            }
        ));
        jTableCamiones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCamionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCamiones);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Patente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Patente1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Patente2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Patente3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Patente4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtKM)
                                    .addComponent(txtMarca)
                                    .addComponent(txtPatente)
                                    .addComponent(txtModelo)
                                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPatente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Patente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Patente1))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Patente2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Patente3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Patente4))
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Registro de Flota");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar)
                    .addComponent(btnVolver))
                .addGap(61, 61, 61))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKMActionPerformed
    }//GEN-LAST:event_txtKMActionPerformed

    private void txtModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModeloActionPerformed
    }//GEN-LAST:event_txtModeloActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
                if (txtPatente.getText().isEmpty() || txtAnio.getText().isEmpty() || txtKM.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Debe completar todos los campos.");
                    return;
                }

                Camion c = new Camion();
                c.setPatente(txtPatente.getText());
                c.setMarca(txtMarca.getText());
                c.setModelo(txtModelo.getText());
                c.setAnio(Integer.parseInt(txtAnio.getText()));
                c.setKilometrajeActual(Integer.parseInt(txtKM.getText()));

                CamionDAO cDao = new CamionDAO();

                if (txtPatente.isEditable() == false) {
                    if (cDao.modificarCamion(c)) {
                        JOptionPane.showMessageDialog(this, "¡Camión actualizado con éxito!");
                    }
                } else {
                    if (cDao.insertarCamion(c)) {
                        JOptionPane.showMessageDialog(this, "Camión registrado con éxito.");
                    }
                }

                txtPatente.setEditable(true); // Muy importante para poder agregar otro después
                limpiarCampos();
                cargarTabla();

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Error: Ingrese solo números en Año y Kilometraje.");
            }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
            new MenuAdmin().setVisible(true);
            this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
            int fila = jTableCamiones.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Selecciona un camión de la tabla.");
                return;
            }

            String patente = jTableCamiones.getValueAt(fila, 0).toString();
            int resp = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres eliminar el camión " + patente + "?");

            if (resp == JOptionPane.YES_OPTION) {
                if (new dao.CamionDAO().eliminarCamion(patente)) {
                    JOptionPane.showMessageDialog(this, "Camión eliminado.");
                    cargarTabla();
                }
            }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jTableCamionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCamionesMouseClicked
            int fila = jTableCamiones.getSelectedRow();
                if (fila != -1) {
                    txtPatente.setText(jTableCamiones.getValueAt(fila, 0).toString());
                    txtMarca.setText(jTableCamiones.getValueAt(fila, 1).toString());
                    txtModelo.setText(jTableCamiones.getValueAt(fila, 2).toString());
                    txtAnio.setText(jTableCamiones.getValueAt(fila, 3).toString());
                    // AQUÍ ESTABA EL ERROR: Cambiamos txtKilometraje por txtKM
                    txtKM.setText(jTableCamiones.getValueAt(fila, 4).toString());

                    txtPatente.setEditable(false); 
                }
    }//GEN-LAST:event_jTableCamionesMouseClicked

    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new GestionCamiones().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Patente;
    private javax.swing.JLabel Patente1;
    private javax.swing.JLabel Patente2;
    private javax.swing.JLabel Patente3;
    private javax.swing.JLabel Patente4;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCamiones;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtKM;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPatente;
    // End of variables declaration//GEN-END:variables
}
