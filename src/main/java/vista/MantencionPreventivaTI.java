package vista;

import dao.ActivoTIDAO;
import dao.MantencionTIDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import modelo.ActivoTI;
import modelo.MantencionTI;
import modelo.SesionUsuario;
import util_PDF.GeneradorPDFMantencionTI;

import vista.MenuSoporte;

public class MantencionPreventivaTI extends javax.swing.JFrame {

    private List<ActivoTI> listaEquipos;
    private List<modelo.Usuario> listaUsuarios;
    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(MantencionPreventivaTI.class.getName());

    public MantencionPreventivaTI() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarUsuarios();
        cbUsuarios.addActionListener(e -> filtrarEquiposPorUsuario());
        if (cbUsuarios.getItemCount() > 0) {
            cbUsuarios.setSelectedIndex(0);
            filtrarEquiposPorUsuario();
        }
        txtHoraInicio.setText(new SimpleDateFormat("HH:mm").format(new Date()));
    }

    private void cargarEquipos() {
        ActivoTIDAO dao = new ActivoTIDAO();
        listaEquipos = dao.listarEquiposOficina();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (ActivoTI a : listaEquipos)
            model.addElement(a.getTipoDispositivo() + " - " + a.getNroSerie());
        cbEquipos.setModel(model);
    }

    private void cargarUsuarios() {
        dao.UsuarioDAO uDao = new dao.UsuarioDAO(); //creo el DAO de usuario
        listaUsuarios = uDao.listarUsuarios(); // se obtienen los usuarios de la BD
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (modelo.Usuario u : listaUsuarios)
            model.addElement(u.getNombre() + " " + u.getApellido());
        cbUsuarios.setModel(model);
    }

    private void filtrarEquiposPorUsuario() {   //si la lista de usuarios  no existe termina el metodo
        if (listaUsuarios == null) return;
        int idx = cbUsuarios.getSelectedIndex(); //se obtiene la poscicion seleccionada del combobox
        if (idx < 0 || idx >= listaUsuarios.size()) return;
        int idUser = listaUsuarios.get(idx).getIdUsuario(); //se obtiene el ID del usuario seleccionado
        ActivoTIDAO dao = new ActivoTIDAO(); //creo el dao de activos TI
        listaEquipos = dao.listarPorUsuario(idUser); //obtengo los equipos asignados al usuario
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (ActivoTI a : listaEquipos)
            model.addElement(a.getTipoDispositivo() + " (" + a.getNroSerie() + ")");
        cbEquipos.setModel(model);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtHoraTermino = new javax.swing.JTextField();

fechaTermino = new com.toedter.calendar.JDateChooser();
fechaTermino.setDateFormatString("dd/MM/yyyy");

jLabel6 = new javax.swing.JLabel();
        chkLimpieza = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
jLabel8 = new javax.swing.JLabel();
jLabel8.setText("Hora:");
        chkConexiones = new javax.swing.JCheckBox();
        cbUsuarios = new javax.swing.JComboBox<>();
        chkRAM = new javax.swing.JCheckBox();
        chkActSO = new javax.swing.JCheckBox();
        chkDisco = new javax.swing.JCheckBox();
        chkFuente = new javax.swing.JCheckBox();
        chkPuertos = new javax.swing.JCheckBox();
        chkArmado = new javax.swing.JCheckBox();
        chkVersionSO = new javax.swing.JCheckBox();
        chkActApps = new javax.swing.JCheckBox();
        chkAntivirus = new javax.swing.JCheckBox();
        chkLimpiezaA = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        btnGuardar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbEquipos = new javax.swing.JComboBox<>();
        txtHoraInicio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("Software");

        jLabel5.setText("Hora inicio");

        jLabel6.setText("Fecha término:");

        chkLimpieza.setText("Limpieza física interna");

        jLabel7.setText("Observaciones:");

        chkConexiones.setText("Conexiones internas");
        chkConexiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkConexionesActionPerformed(evt);
            }
        });

        cbUsuarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        chkRAM.setText("Revisión de RAM");

        chkActSO.setText("Actualización SO");
        chkActSO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkActSOActionPerformed(evt);
            }
        });

        chkDisco.setText("Disco duro /SSD");

        chkFuente.setText("Fuente de poder");

        chkPuertos.setText("Puertos USB/red");

        chkArmado.setText("Armado y encendido");

        chkVersionSO.setText("Versión del SO");
        chkVersionSO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkVersionSOActionPerformed(evt);
            }
        });

        chkActApps.setText("Actualización apps");

        chkAntivirus.setText("Antivirus");
        chkAntivirus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAntivirusActionPerformed(evt);
            }
        });

        chkLimpiezaA.setText("Limpieza de archivos");

        txtObservaciones.setColumns(20);
        txtObservaciones.setRows(5);
        jScrollPane1.setViewportView(txtObservaciones);

        jScrollPane2.setViewportView(jScrollPane1);

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

        jLabel1.setText("Equipo:");

        jLabel2.setText("Usuario:");

        jLabel3.setText("Hardware:");

        cbEquipos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(btnVolver)
                        .addGap(122, 122, 122)
                        .addComponent(btnGuardar)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(chkLimpieza)
                            .addComponent(jLabel7)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(chkRAM, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkFuente, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkArmado, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkVersionSO, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkActApps, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkLimpiezaA, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(6, 6, 6)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkDisco)
                            .addComponent(chkConexiones)
                            .addComponent(chkPuertos)
                            .addComponent(chkActSO)
                            .addComponent(chkAntivirus)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(jLabel6)
.addGap(8, 8, 8)
.addComponent(fechaTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
.addGap(8, 8, 8)
.addComponent(jLabel8)
.addGap(4, 4, 4)
.addComponent(txtHoraTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
.addContainerGap(80, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
.addComponent(fechaTermino, javax.swing.GroupLayout.PREFERRED_SIZE,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              javax.swing.GroupLayout.PREFERRED_SIZE)
.addComponent(jLabel8)
.addComponent(txtHoraTermino, javax.swing.GroupLayout.PREFERRED_SIZE,
              javax.swing.GroupLayout.DEFAULT_SIZE,
              javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkConexiones)
                    .addComponent(chkLimpieza))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkRAM)
                    .addComponent(chkDisco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkFuente)
                    .addComponent(chkPuertos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkArmado)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkActSO)
                    .addComponent(chkVersionSO))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkAntivirus)
                    .addComponent(chkActApps))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkLimpiezaA)
                .addGap(25, 25, 25)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chkActSOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkActSOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkActSOActionPerformed

    private void chkAntivirusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkAntivirusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkAntivirusActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (cbEquipos.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un equipo."); return;
        }
        String obs = txtObservaciones.getText().trim();

        // checklist
        StringBuilder checklist = new StringBuilder(); // texto donde iran las actividades seleccionadas
        if (chkLimpieza.isSelected())   checklist.append("  - Limpieza física interna\n");
        if (chkConexiones.isSelected()) checklist.append("  - Verificación de conexiones internas\n");
        if (chkRAM.isSelected())        checklist.append("  - Revisión de RAM\n");
        if (chkDisco.isSelected())      checklist.append("  - Revisión de disco duro / SSD\n");
        if (chkFuente.isSelected())     checklist.append("  - Verificación de fuente de poder\n");
        if (chkPuertos.isSelected())    checklist.append("  - Revisión de puertos USB / red\n");
        if (chkArmado.isSelected())     checklist.append("  - Armado y encendido del equipo\n");
        if (chkVersionSO.isSelected())  checklist.append("  - Verificación de versión del SO\n");
        if (chkActSO.isSelected())      checklist.append("  - Actualización del sistema operativo\n");
        if (chkActApps.isSelected())    checklist.append("  - Actualización de aplicaciones\n");
        if (chkAntivirus.isSelected())  checklist.append("  - Verificación de antivirus\n");
        if (chkLimpiezaA.isSelected())  checklist.append("  - Limpieza de archivos temporales\n");

        MantencionTI mant = new MantencionTI();
        ActivoTI equipo = listaEquipos.get(cbEquipos.getSelectedIndex());
        //guarda el ID del equipo en mantencion
        mant.setIdActivo(equipo.getIdActivo());
       //guardo el ID del equipo
        mant.setIdUsuarioSoporte(SesionUsuario.getUsuario().getIdUsuario());
        mant.setTipoMantencion("PREVENTIVO");
        mant.setDescripcionFalla(checklist.toString().trim());
        mant.setAccionRealizada(obs.isEmpty() ? "Sin notas adicionales." : "Notas adicionales:\n  " + obs);

        try {
            String hoy    = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
            String horaIni = txtHoraInicio.getText().trim();
            String horaTer = txtHoraTermino.getText().trim();
            mant.setFechaInicio(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(hoy + " " + horaIni));
           if (fechaTermino.getDate() != null) {
    String fechaTer = new SimpleDateFormat("dd/MM/yyyy").format(fechaTermino.getDate());
    String horaFinal = horaTer.isEmpty() ? "00:00" : horaTer;
    java.util.Date fTermino = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(fechaTer + " " + horaFinal);
    mant.setFechaTermino(fTermino);
} else if (!horaTer.isEmpty()) {
    java.util.Date fTermino = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(hoy + " " + horaTer);
    mant.setFechaTermino(fTermino);
}
        } catch (java.text.ParseException ex) {
            mant.setFechaInicio(new Date());
        }

        MantencionTIDAO daoM = new MantencionTIDAO();
        int idMantencion = daoM.registrarMantencion(mant, null, null);
        if (idMantencion == -1) {
            JOptionPane.showMessageDialog(this, "Error al guardar en la base de datos."); return;
        }

        String folio = String.format("MT-%s-%04d",
                new SimpleDateFormat("yyyy").format(new Date()), idMantencion);

        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Guardar formulario PDF");
        fc.setSelectedFile(new java.io.File("Preventivo_RF06_" +
                new SimpleDateFormat("yyyyMMdd_HHmm").format(new Date()) + ".pdf"));
        fc.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("PDF (*.pdf)", "pdf"));
        if (fc.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) return;

        String ruta = fc.getSelectedFile().getAbsolutePath();
        if (!ruta.toLowerCase().endsWith(".pdf")) ruta += ".pdf";

        String tecnico = SesionUsuario.getUsuario().getNombre() + " " + SesionUsuario.getUsuario().getApellido();
        String usuarioEquipo = (listaUsuarios != null && cbUsuarios.getSelectedIndex() >= 0)
                ? cbUsuarios.getSelectedItem().toString() : "";

        String fechaEncabezadoPDF = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

String fechaTerminoPDF = fechaTermino.getDate() != null
        ? new SimpleDateFormat("dd/MM/yyyy").format(fechaTermino.getDate())
        : "";

        try {
            GeneradorPDFMantencionTI.generarPreventivo(
                    idMantencion, folio,
                    String.valueOf(equipo.getIdActivo()),
                    fechaEncabezadoPDF,
fechaTerminoPDF,
txtHoraInicio.getText().trim(),
txtHoraTermino.getText().trim(),
                    tecnico, usuarioEquipo,
                    equipo.getMarca()            != null ? equipo.getMarca()            : "",
                    equipo.getModelo()           != null ? equipo.getModelo()           : "",
                    equipo.getNroSerie()         != null ? equipo.getNroSerie()         : "",
                    equipo.getSistemaOperativo() != null ? equipo.getSistemaOperativo() : "No registrado",
                    chkLimpieza.isSelected(),   chkConexiones.isSelected(),
                    chkRAM.isSelected(),         chkDisco.isSelected(),
                    chkFuente.isSelected(),      chkPuertos.isSelected(),
                    chkArmado.isSelected(),      chkVersionSO.isSelected(),
                    chkActSO.isSelected(),       chkActApps.isSelected(),
                    chkAntivirus.isSelected(),   chkLimpiezaA.isSelected(),
                    obs, ruta);
            JOptionPane.showMessageDialog(this, "Registro guardado y formulario PDF generado.");
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

    private void chkVersionSOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkVersionSOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkVersionSOActionPerformed

    private void chkConexionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkConexionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkConexionesActionPerformed


    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName()); break;
                }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new vista.MantencionPreventivaTI().setVisible(true));
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cbEquipos;
    private javax.swing.JComboBox<String> cbUsuarios;
    private javax.swing.JCheckBox chkActApps;
    private javax.swing.JCheckBox chkActSO;
    private javax.swing.JCheckBox chkAntivirus;
    private javax.swing.JCheckBox chkArmado;
    private javax.swing.JCheckBox chkConexiones;
    private javax.swing.JCheckBox chkDisco;
    private javax.swing.JCheckBox chkFuente;
    private javax.swing.JCheckBox chkLimpieza;
    private javax.swing.JCheckBox chkLimpiezaA;
    private javax.swing.JCheckBox chkPuertos;
    private javax.swing.JCheckBox chkRAM;
    private javax.swing.JCheckBox chkVersionSO;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtHoraInicio;
    private javax.swing.JTextField txtHoraTermino;
    private javax.swing.JTextArea txtObservaciones;
    private com.toedter.calendar.JDateChooser fechaTermino;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
