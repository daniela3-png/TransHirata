package vista;
 
import dao.MantencionTIDAO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;
 

public class HistorialMantencionesTI extends javax.swing.JFrame {
 
    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(HistorialMantencionesTI.class.getName());
 
    private static final SimpleDateFormat FMT = new SimpleDateFormat("dd/MM/yyyy HH:mm");
 
    public HistorialMantencionesTI() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Historial de Mantenimientos TI - Transportes Hirata");
        cargarTabla();
        configurarDobleClick();
    }
 
    private void cargarTabla() {
        MantencionTIDAO mDao = new MantencionTIDAO();
        List<Object[]> datos = mDao.listarHistorialTI(); //obtiene los registros del historial
 
        DefaultTableModel modelo = (DefaultTableModel) tblHistorialTI.getModel();
        modelo.setRowCount(0);  // limpia toda la fila actuales
 
        for (Object[] fila : datos) {
            //  fecha_inicio                                fecha_termino 
            String fInicio  = fila[6] != null ? FMT.format(fila[6]) : "—";
            String fTermino;
if (fila[7] == null) {
    fTermino = "En curso";
} else {
    java.util.Date dt = (java.util.Date) fila[7];
    java.util.Calendar cal = java.util.Calendar.getInstance();
    cal.setTime(dt);
    boolean tieneHora = cal.get(java.util.Calendar.HOUR_OF_DAY) != 0
                     || cal.get(java.util.Calendar.MINUTE) != 0;
    fTermino = tieneHora
        ? FMT.format(dt)                                        // si tiene la fecha + hora muestra ambas
        : new SimpleDateFormat("dd/MM/yyyy").format(dt);        //sino  solo fecha

}
 
            modelo.addRow(new Object[]{
    fila[0],   
    fila[1],   
    fila[3],   
    fila[5],   
    fInicio,
    fTermino,
    fila[8]    
});
        }
    }
 
    // Click para abrir  ventana de detalle 
    private void configurarDobleClick() {
        tblHistorialTI.addMouseListener(new MouseAdapter() {
            @Override       // metodo que detecta los click
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int fila = tblHistorialTI.getSelectedRow();
                    if (fila >= 0) {
                        int idMantencion = (int) tblHistorialTI.getValueAt(fila, 0);
                        DetalleMantencionTI dlg = new DetalleMantencionTI(idMantencion);
                        dlg.setVisible(true);   // muestra la ventana detalle
                        
                        cargarTabla();
                    }
                }
            }
        });
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
 
        jPanel1        = new javax.swing.JPanel();
        jLabel1        = new javax.swing.JLabel();
        lblAyuda       = new javax.swing.JLabel();
        tblHistorial   = new javax.swing.JScrollPane();
        tblHistorialTI = new javax.swing.JTable();
        btnVolver      = new javax.swing.JButton();
 
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
 
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jLabel1.setText("Historial de Mantenimiento TI");
 
        lblAyuda.setFont(new java.awt.Font("Segoe UI", 2, 11));
        lblAyuda.setForeground(new java.awt.Color(100, 100, 100));
        lblAyuda.setText("Haga doble clic en un registro para ver el detalle completo");
 
        // Tabla con las columnas nuevas
        tblHistorialTI.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][]{},
           new String[]{"ID", "Equipo", "Usuario Asignado",
             "Tipo", "Fecha Inicio", "Fecha Término", "Estado Equipo"}

        ) {
            final Class<?>[] types = {
    Integer.class, String.class, String.class,
    String.class, String.class, String.class, String.class
};
final boolean[] canEdit = {false, false, false, false, false, false, false};
 
            @Override public Class<?> getColumnClass(int c) { return types[c]; }
            @Override public boolean isCellEditable(int r, int c) { return canEdit[c]; }
        });
        tblHistorialTI.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblHistorialTI.setRowHeight(22);
        tblHistorialTI.getTableHeader().setReorderingAllowed(false);
 
        // Anchos de columna sugeridos
        tblHistorialTI.getColumnModel().getColumn(0).setPreferredWidth(40);   // ID
tblHistorialTI.getColumnModel().getColumn(1).setPreferredWidth(90);   // Equipo
tblHistorialTI.getColumnModel().getColumn(2).setPreferredWidth(150);  // Usuario
tblHistorialTI.getColumnModel().getColumn(3).setPreferredWidth(90);   // Tipo
tblHistorialTI.getColumnModel().getColumn(4).setPreferredWidth(120);  // F.Inicio
tblHistorialTI.getColumnModel().getColumn(5).setPreferredWidth(120);  // F.Término
tblHistorialTI.getColumnModel().getColumn(6).setPreferredWidth(130);  // Estado
 
        tblHistorial.setViewportView(tblHistorialTI);
 
        btnVolver.setText("Volver");
        btnVolver.addActionListener(evt -> btnVolverActionPerformed(evt));
 
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lblAyuda)
                            .addComponent(tblHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(430, 430, 430)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(lblAyuda)
                .addGap(12, 12, 12)
                .addComponent(tblHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(btnVolver)
                .addContainerGap(20, Short.MAX_VALUE))
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
 
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {
        new MenuSoporte().setVisible(true);
        this.dispose();
    }
 
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName()); break;
                }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new HistorialMantencionesTI().setVisible(true));
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton       btnVolver;
    private javax.swing.JLabel        jLabel1;
    private javax.swing.JLabel        lblAyuda;
    private javax.swing.JPanel        jPanel1;
    private javax.swing.JScrollPane   tblHistorial;
    private javax.swing.JTable        tblHistorialTI;
    // End of variables declaration//GEN-END:variables
}