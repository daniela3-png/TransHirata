
package vista;
public class DetalleMantencionTI extends javax.swing.JFrame {

    private int idMantencion;  // guarda el ID de la mantención seleccionada

    public DetalleMantencionTI(int idMantencion) {
        initComponents();
        this.idMantencion = idMantencion;

        setTitle("Detalle Mantención #" + idMantencion);
        setLocationRelativeTo(null);
        setResizable(false); // Evita cambiar el tamaño de la ventana

        cargarDatos();  // Llama al método que carga los datos desde la base de datos

        btnEstado.addActionListener(e -> actualizarEstado());//presionas el boton actualizar y se ejecuta el metodo

        btnCerrar.addActionListener(e -> dispose()); // lo mismo que el anterior pero para cerrar la ventana
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtAcciones = new javax.swing.JTextArea();
        lblSerie = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        btnEstado = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        lblTecnico = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblEquipo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtAcciones.setColumns(20);
        txtAcciones.setRows(5);
        jScrollPane1.setViewportView(txtAcciones);

        lblSerie.setText("jLabel8");

        jLabel3.setText("Usuario :");

        jLabel4.setText("Técnico :");

        jLabel7.setText("Acciones realizadas :");

        jLabel5.setText("Tipo :");

        txtObservaciones.setColumns(20);
        txtObservaciones.setRows(5);
        jScrollPane2.setViewportView(txtObservaciones);

        jLabel6.setText("Estado  equipo :");

        btnEstado.setText("Actualizar estado");

        lblUsuario.setText("jLabel9");

        btnCerrar.setText("Cerrar");

        lblTecnico.setText("jLabel10");

        lblTipo.setText("jLabel11");

        jLabel1.setText("Equipo :");

        lblEstado.setText("jLabel12");

        lblEquipo.setText("jLabel7");

        jLabel2.setText("N° Serie : ");

        jLabel8.setText("Observaciones :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel8)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                    .addGap(126, 126, 126)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblEstado)
                                        .addComponent(lblTipo)
                                        .addComponent(lblTecnico)
                                        .addComponent(lblUsuario)
                                        .addComponent(lblSerie)
                                        .addComponent(lblEquipo)))
                                .addComponent(jScrollPane2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(btnEstado)
                        .addGap(18, 18, 18)
                        .addComponent(btnCerrar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblEquipo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblSerie))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblTecnico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblTipo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstado))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar)
                    .addComponent(btnEstado))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void cargarDatos() {

        dao.MantencionTIDAO dao = new dao.MantencionTIDAO(); //crea un DAO para trabajar con las mantenciones

        //obtiene el detalle de la mantención usando ID
        Object[] d = dao.obtenerDetalle(idMantencion);

        if (d == null) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "No se encontró la mantención.");
            dispose();
            return;
        }

        String tipoEquipo = str(d[1]);
        String serie = str(d[4]);
        String usuAsig = str(d[6]);
        String tecnico = str(d[7]);
        
        
//Verifica si la mantencion es preventiva
        String tipoMant = "PREVENTIVO".equals(str(d[8]))
                ? "Preventiva"
                : "Correctiva";

        String falla = str(d[9]);
        String accion = str(d[10]);
        String estadoEq = str(d[13]);

        lblEquipo.setText(tipoEquipo);
        lblSerie.setText(serie);
        lblUsuario.setText(usuAsig);
        lblTecnico.setText(tecnico);
        lblTipo.setText(tipoMant);
        lblEstado.setText(formatearEstado(estadoEq));

        boolean esPreventivo = "PREVENTIVO".equals(str(d[8]));

        txtAcciones.setText(esPreventivo ? falla : accion);

        txtObservaciones.setText(esPreventivo ? accion : falla);

        txtAcciones.setEditable(false);
        txtObservaciones.setEditable(false);
    }

    private void actualizarEstado() {

        String[] etiquetas = { //cambiamos el estado del equipo
            "Operativo",
            "En reparación",
            "En espera de repuesto"
        };

        String[] valores = {
            "OPERATIVO",
            "EN_REPARACION",
            "PENDIENTE_REPUESTO"
        };

        String etiqueta = (String) javax.swing.JOptionPane.showInputDialog(
                this,
                "Seleccione el nuevo estado:",
                "Actualizar Estado",
                javax.swing.JOptionPane.PLAIN_MESSAGE,
                null,
                etiquetas,
                etiquetas[0]);

        if (etiqueta == null) return;

        String seleccion = valores[
                java.util.Arrays.asList(etiquetas).indexOf(etiqueta)
        ];

        dao.MantencionTIDAO dao = new dao.MantencionTIDAO();

        if (dao.actualizarEstado(idMantencion, seleccion)) {

    javax.swing.JOptionPane.showMessageDialog(
            this,
            "Estado actualizado correctamente.");

    // Actualiza label de esta ventana
    lblEstado.setText(formatearEstado(seleccion));

    // Refresca automáticamente la tabla historial
    java.awt.Window[] ventanas = java.awt.Window.getWindows();

    for (java.awt.Window w : ventanas) {

        if (w instanceof HistorialMantencionesTI) {

            HistorialMantencionesTI h = (HistorialMantencionesTI) w;

            try {

                java.lang.reflect.Method m =
                        HistorialMantencionesTI.class.getDeclaredMethod("cargarTabla");

                m.setAccessible(true);

                m.invoke(h);

            } catch (Exception ex) {

                ex.printStackTrace();
            }
        }
    }

} else {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "No se pudo actualizar el estado.");
        }
    }

    private String formatearEstado(String estado) {

        switch (estado) {

            case "EN_REPARACION":
                return "En reparación";

            case "PENDIENTE_REPUESTO":
                return "En espera de repuesto";

            case "OPERATIVO":
                return "Operativo";

            default:
                return estado;
        }
    }

    private String str(Object o) {
        return o != null ? o.toString() : "";
    }
     public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new DetalleMantencionTI(1).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEstado;
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
    private javax.swing.JLabel lblEquipo;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblSerie;
    private javax.swing.JLabel lblTecnico;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextArea txtAcciones;
    private javax.swing.JTextArea txtObservaciones;
    // End of variables declaration//GEN-END:variables
}
