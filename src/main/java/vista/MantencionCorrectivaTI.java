
package vista;

import dao.ActivoTIDAO;
import dao.MantencionTIDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ActivoTI;
import modelo.MantencionTI;
import modelo.SesionUsuario;
import util_PDF.GeneradorPDFMantencionTI;

public class MantencionCorrectivaTI extends javax.swing.JFrame {

     private List<ActivoTI> listaEquipos;  //Guarda los equipos cargados segun el usuario seleccionado
    private List<modelo.Usuario> listaUsuarios; //usuarios cargados desde la BD
   
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MantencionCorrectivaTI.class.getName());

    public MantencionCorrectivaTI() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarUsuarios();    //carga usuarios combobox
        //cambio de usuario se actualizan los equipos que le pertenencen
cbUsuarios.addActionListener(e -> filtrarEquiposPorUsuario());
        cargarRepuestos();
        if (cbUsuarios.getItemCount() > 0) { //verifica si hay usuario cargado
    cbUsuarios.setSelectedIndex(0);
    filtrarEquiposPorUsuario();
}
        txtHoraInicio.setText(new SimpleDateFormat("HH:mm").format(new Date()));
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgPrioridad = new javax.swing.ButtonGroup();
        bgTipoFalla = new javax.swing.ButtonGroup();
        cbUsuarios = new javax.swing.JComboBox<>();
        cbEquipos = new javax.swing.JComboBox<>();
        txtHoraInicio = new javax.swing.JTextField();
        txtHoraTermino = new javax.swing.JTextField();

fechaTermino = new com.toedter.calendar.JDateChooser();
fechaTermino.setDateFormatString("dd/MM/yyyy");

rbHardware = new javax.swing.JRadioButton();
        rbSoftware = new javax.swing.JRadioButton();
        rbAlta = new javax.swing.JRadioButton();
        rbMedia = new javax.swing.JRadioButton();
        rbBaja = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtFalla = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRepuestos = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDetalleSoporte = new javax.swing.JTextArea();
        btnGuardar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jLabel9.setText("Fecha término:");
        jLabel10.setText("Hora:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbUsuarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbEquipos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEquiposActionPerformed(evt);
            }
        });

        bgTipoFalla.add(rbHardware);
        rbHardware.setText("Hardware");

        bgTipoFalla.add(rbSoftware);
        rbSoftware.setText("Software");
        rbSoftware.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSoftwareActionPerformed(evt);
            }
        });

        bgPrioridad.add(rbAlta);
        rbAlta.setText("Alta");

        bgPrioridad.add(rbMedia);
        rbMedia.setText("Media");

        bgPrioridad.add(rbBaja);
        rbBaja.setText("Baja");

        txtFalla.setColumns(20);
        txtFalla.setRows(5);
        jScrollPane2.setViewportView(txtFalla);

        jTableRepuestos.setModel(new javax.swing.table.DefaultTableModel(
    new Object [][] {},
    new String [] {"ID", "Repuesto", "Solicitar"}
) {
    Class[] types = new Class [] {
        java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class
    };

    public Class getColumnClass(int columnIndex) {
        return types[columnIndex];
    }
});
        jScrollPane1.setViewportView(jTableRepuestos);

        txtDetalleSoporte.setColumns(20);
        txtDetalleSoporte.setRows(5);
        jScrollPane3.setViewportView(txtDetalleSoporte);

        btnGuardar.setText("Guardar y generar PDF");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel1.setText("Usuario:");

        jLabel2.setText("Equipo:");

        jLabel3.setText("Falla detectada:");

        jLabel4.setText("Detalle de trabajo realizado:");

        jLabel5.setText("Tipo de falla:");

        jLabel6.setText("Prioridad:");

        jLabel7.setText("Repuestos solicitados:");

        jLabel8.setText("Hora inicio:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                               .addComponent(txtHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
.addGap(18, 18, 18)
.addComponent(jLabel9)
.addGap(8, 8, 8)
.addComponent(fechaTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
.addGap(8, 8, 8)
.addComponent(jLabel10)
.addGap(4, 4, 4)
.addComponent(txtHoraTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(cbEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(rbAlta)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(rbMedia)
                                                .addGap(18, 18, 18)
                                                .addComponent(rbBaja))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(rbHardware)
                                                .addGap(18, 18, 18)
                                                .addComponent(rbSoftware))))))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(210, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbUsuarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
.addComponent(txtHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
.addComponent(jLabel9)
.addComponent(fechaTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
.addComponent(jLabel10)
.addComponent(txtHoraTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rbHardware)
                    .addComponent(rbSoftware))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rbAlta)
                    .addComponent(rbMedia)
                    .addComponent(rbBaja))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(257, 257, 257))
        );

        pack();
setSize(650, 680);
setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 
    private void cargarRepuestos() {
        dao.RepuestoDAO rDao = new dao.RepuestoDAO();
        List<modelo.Repuesto> lista = rDao.listarRepuestosDisponibles();
        DefaultTableModel modeloTabla = (DefaultTableModel) jTableRepuestos.getModel();
        modeloTabla.setRowCount(0);
        for (modelo.Repuesto r : lista)
            modeloTabla.addRow(new Object[]{r.getIdRepuesto(), r.getNombrePieza(), false});   // Este es el Boolean que se verá como Checkbox
    }

   private void cargarRepuestosPorFiltro(String equipoSel) {
    String equipoUpper = equipoSel.toUpperCase();
    String cat = "";
    if (equipoUpper.contains("NOTEBOOK"))                          cat = "NOTEBOOK";
    else if (equipoUpper.contains("CPU") || equipoUpper.contains("PC")) cat = "PC";
    else if (equipoUpper.contains("PRN") || equipoUpper.contains("IMPRESORA")) cat = "IMPRESORA";

        dao.RepuestoDAO rDao = new dao.RepuestoDAO();
        List<modelo.Repuesto> lista = cat.isEmpty()
                ? rDao.listarRepuestosDisponibles() : rDao.listarPorCategoria(cat);
        DefaultTableModel modeloTabla = (DefaultTableModel) jTableRepuestos.getModel();
        modeloTabla.setRowCount(0);
        for (modelo.Repuesto r : lista)
            modeloTabla.addRow(new Object[]{r.getIdRepuesto(), r.getNombrePieza(), false});
    }

    private void filtrarEquiposPorUsuario() {
        if (listaUsuarios == null) return;
        int idx = cbUsuarios.getSelectedIndex();
        if (idx < 0) return;
        int idUser = listaUsuarios.get(idx).getIdUsuario();
        ActivoTIDAO adao = new ActivoTIDAO();
        listaEquipos = adao.listarPorUsuario(idUser);
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        if (listaEquipos != null && !listaEquipos.isEmpty())
            for (ActivoTI a : listaEquipos)
                model.addElement(a.getTipoDispositivo() + " (" + a.getNroSerie() + ")");
        else
            model.addElement("Sin equipos asignados");
        cbEquipos.setModel(model);
       if (cbEquipos.getItemCount() > 0)
    cargarRepuestosPorFiltro(cbEquipos.getSelectedItem().toString());
    }

    private void cargarUsuarios() {
        dao.UsuarioDAO uDao = new dao.UsuarioDAO();
        listaUsuarios = uDao.listarUsuarios();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        if (listaUsuarios != null)
            for (modelo.Usuario u : listaUsuarios)
                model.addElement(u.getNombre() + " " + u.getApellido());
        cbUsuarios.setModel(model);
    }
    private void rbSoftwareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSoftwareActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbSoftwareActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

    if (cbEquipos.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un equipo."); return;
        }
        String falla   = txtFalla.getText().trim();
        String detalle = txtDetalleSoporte.getText().trim();
        if (falla.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese falla detectada."); return;
        }

        // Repuestos seleccionados
        List<Integer> seleccionados = new ArrayList<>();
List<String[]> piezasParaPDF = new ArrayList<>();

for (int i = 0; i < jTableRepuestos.getRowCount(); i++) {
    int idRep = (int) jTableRepuestos.getValueAt(i, 0);
    String nombrePieza = (String) jTableRepuestos.getValueAt(i, 1);
    Boolean sol = (Boolean) jTableRepuestos.getValueAt(i, 2);

    if (sol != null && sol) {
        seleccionados.add(idRep); // solo los seleccionados se guardan en BD
    }
    // Los que se muestran en el PDF
    piezasParaPDF.add(new String[]{
        nombrePieza,
        "",
        (sol != null && sol) ? "Sí" : "No"
    });
}

       
        MantencionTI m = new MantencionTI();

if (listaEquipos == null || listaEquipos.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Este usuario no tiene equipos asignados.");
    return;
}
        ActivoTI equipo = listaEquipos.get(cbEquipos.getSelectedIndex());
        m.setIdActivo(equipo.getIdActivo());
        m.setIdUsuarioSoporte(SesionUsuario.getUsuario().getIdUsuario());
        m.setDescripcionFalla(falla);
        m.setAccionRealizada(detalle);

        //fechas de inicio y termino desde los campos de texto
        try {
            String hoy = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
            String horaIni = txtHoraInicio.getText().trim();
            String horaTer = txtHoraTermino.getText().trim();
            java.util.Date fInicio = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(hoy + " " + horaIni);
            m.setFechaInicio(fInicio);
           if (fechaTermino.getDate() != null) {
    String fechaTer = new SimpleDateFormat("dd/MM/yyyy").format(fechaTermino.getDate());
    String horaFinal = horaTer.isEmpty() ? "00:00" : horaTer;
    java.util.Date fTermino = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(fechaTer + " " + horaFinal);
    m.setFechaTermino(fTermino);
} else if (!horaTer.isEmpty()) {
    java.util.Date fTermino = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(hoy + " " + horaTer);
    m.setFechaTermino(fTermino);
}
            // Si la hora de termino esta vacia, deja fechaTermino null,entonces en el historial  aparece "En curso" 
        } catch (java.text.ParseException ex) {
            m.setFechaInicio(new Date());
            
        }

        MantencionTIDAO daoM = new MantencionTIDAO();
        int idMantencion = daoM.registrarMantencionCorrectiva(m, seleccionados);

if (idMantencion == -1) {
    JOptionPane.showMessageDialog(this, "Error al procesar la solicitud.");
    return;
}

String anio = new SimpleDateFormat("yyyy").format(new Date());

String folio = String.format(
    "MT-%s-%04d",
    anio,
    idMantencion
);
           

        // Elegir donde se guardará  PDF
        JFileChooser fc = new JFileChooser(); // se crea la ventana exploradora para guardar el archivo
        fc.setDialogTitle("Guardar formulario PDF correctivo");
        fc.setSelectedFile(new java.io.File("Correctivo_RF06_" +
                new SimpleDateFormat("yyyyMMdd_HHmm").format(new Date()) + ".pdf")); // genera el nombre automatico del PDF con fecha y hora
        fc.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("PDF (*.pdf)", "pdf")); // formato que permite
        if (fc.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) return;

        String ruta = fc.getSelectedFile().getAbsolutePath();
        if (!ruta.toLowerCase().endsWith(".pdf")) ruta += ".pdf";

        String tecnico = SesionUsuario.getUsuario().getNombre() + " " + SesionUsuario.getUsuario().getApellido();
        String usuarioEquipo = (listaUsuarios != null && cbUsuarios.getSelectedIndex() >= 0)
                ? cbUsuarios.getSelectedItem().toString()
                : "";
      String tipoFalla = rbHardware.isSelected() ? "Hardware" :
                   rbSoftware.isSelected() ? "Software" : "No especificado";

    String prioridad = rbAlta.isSelected()  ? "Alta"  :
                   rbMedia.isSelected() ? "Media" :
                   rbBaja.isSelected()  ? "Baja"  : "No especificado";

        
     String[] lineas = detalle.split("\n");
String[][] accionesArr = new String[5][2];
for (int i = 0; i < 5; i++) {
    accionesArr[i][0] = i < lineas.length ? lineas[i].trim() : "";
    accionesArr[i][1] = i < lineas.length && !lineas[i].trim().isEmpty() ? "OK" : "";
}

        String[][] piezasArr = piezasParaPDF.isEmpty()
                ? new String[][]{{"", "", ""}, {"", "", ""}}
                : piezasParaPDF.toArray(new String[0][]);
        
        // Genera el PDF

        try {
            GeneradorPDFMantencionTI.generarCorrectivo(
        idMantencion,
        folio,
        String.valueOf(equipo.getIdActivo()),
                    new SimpleDateFormat("dd/MM/yyyy").format(new Date()),
                    txtHoraInicio.getText().trim(),
                   (fechaTermino.getDate() != null ? new SimpleDateFormat("dd/MM/yyyy").format(fechaTermino.getDate()) + " " : "") + txtHoraTermino.getText().trim(),
                    tecnico,
                    usuarioEquipo,
                    equipo.getMarca()            != null ? equipo.getMarca()            : "",
                    equipo.getModelo()           != null ? equipo.getModelo()           : "",
                    equipo.getNroSerie()         != null ? equipo.getNroSerie()         : "",
                equipo.getSistemaOperativo() != null ? equipo.getSistemaOperativo() : "No registrado",
                    falla, tipoFalla, prioridad,
                    accionesArr, piezasArr, ruta);
            JOptionPane.showMessageDialog(this, "Mantenimiento y PDF generados correctamente.");
            new MenuSoporte().setVisible(true);
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al generar el PDF:\n" + ex.getMessage());
            ex.printStackTrace();
        }
        
        
        
      
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
         new MenuSoporte().setVisible(true);
    this.dispose();

    }//GEN-LAST:event_btnVolverActionPerformed

private void cbEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEquiposActionPerformed

    if (cbEquipos.getSelectedItem() != null) {
        cargarRepuestosPorFiltro(cbEquipos.getSelectedItem().toString());
    }

}//GEN-LAST:event_cbEquiposActionPerformed
 
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName()); break;
                }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new MantencionCorrectivaTI().setVisible(true));
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgPrioridad;
    private javax.swing.ButtonGroup bgTipoFalla;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cbEquipos;
    private javax.swing.JComboBox<String> cbUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableRepuestos;
    private javax.swing.JRadioButton rbAlta;
    private javax.swing.JRadioButton rbBaja;
    private javax.swing.JRadioButton rbHardware;
    private javax.swing.JRadioButton rbMedia;
    private javax.swing.JRadioButton rbSoftware;
    private javax.swing.JTextArea txtDetalleSoporte;
    private javax.swing.JTextArea txtFalla;
    private javax.swing.JTextField txtHoraInicio;
    private javax.swing.JTextField txtHoraTermino;
    private com.toedter.calendar.JDateChooser fechaTermino;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel10;
    // End of variables declaration//GEN-END:variables
}
