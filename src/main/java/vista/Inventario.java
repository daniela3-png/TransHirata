
package vista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Inventario extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Inventario.class.getName());

    private DefaultTableModel modeloTabla;
    
    public Inventario() {
        initComponents();
        configurarTabla();
        cargarTablaStock(); 
        cargarComboBox();
    }
 private Connection getConexion() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/db_hirata";
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }
    
    private void configurarTabla() {
        String[] columnas = {"ID", "Nombre Pieza", "Tipo Pieza", "Stock Actual"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };
        tblStock.setModel(modeloTabla);
    }
    
    private void cargarTablaStock() {
        modeloTabla.setRowCount(0);
        String sql = "SELECT id_repuesto, nombre_pieza, tipo_pieza, stock_actual FROM repuestos";
        
        try (Connection con = getConexion();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("id_repuesto"),
                    rs.getString("nombre_pieza"),
                    rs.getString("tipo_pieza"),
                    rs.getInt("stock_actual")
                };
                modeloTabla.addRow(fila);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar la tabla de stock: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private void cargarComboBox() {
        cmbItems.removeAllItems();
        String sql = "SELECT nombre_pieza FROM repuestos ORDER BY nombre_pieza ASC";
        
        try (Connection con = getConexion();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                cmbItems.addItem(rs.getString("nombre_pieza"));
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar los repuestos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStock = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbItems = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblStock);

        jLabel1.setText("CONTROL DE INVENTARIO: REPUESTOS");

        jLabel2.setText("Agregar :");

        cmbItems.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Cantidad:");

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbItems, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(txtCantidad)))
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnConfirmar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVolver)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        btnConfirmar.addActionListener(e -> {
                    String repuestoSeleccionado = (String) cmbItems.getSelectedItem();
                    String cantidadTexto = txtCantidad.getText().trim();

                    if (repuestoSeleccionado == null || cantidadTexto.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Por favor seleccione un repuesto e ingrese una cantidad.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    try {
                        int cantidadSumar = Integer.parseInt(cantidadTexto);
                        if (cantidadSumar <= 0) {
                            JOptionPane.showMessageDialog(this, "La cantidad debe ser un número entero mayor a 0.", "Cantidad inválida", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        String sqlUpdate = "UPDATE repuestos SET stock_actual = stock_actual + ? WHERE nombre_pieza = ?";
                        try (Connection con = getConexion();
                             PreparedStatement pstmt = con.prepareStatement(sqlUpdate)) {

                            pstmt.setInt(1, cantidadSumar);
                            pstmt.setString(2, repuestoSeleccionado);

                            int rowsAffected = pstmt.executeUpdate();
                            if (rowsAffected > 0) {
                                JOptionPane.showMessageDialog(this, "¡Stock actualizado con éxito!");
                                txtCantidad.setText(""); // Limpiar el campo de texto
                                cargarTablaStock();      // Refrescar la tabla al instante
                            }
                        }

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "La cantidad ingresada debe ser un número entero válido.", "Error de formato", JOptionPane.ERROR_MESSAGE);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, "Error al actualizar el inventario en la base de datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        logger.log(java.util.logging.Level.SEVERE, null, ex);
                    }
                });
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
         new MenuSoporte().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new Inventario().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbItems;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblStock;
    private javax.swing.JTextField txtCantidad;
    // End of variables declaration//GEN-END:variables
}
