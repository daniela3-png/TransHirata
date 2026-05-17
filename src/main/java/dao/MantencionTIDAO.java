package dao;

import conexion.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.MantencionTI;

public class MantencionTIDAO {

    public int registrarMantencion(MantencionTI m, Integer idRepuesto, Integer cantidad) {

        String sqlMant = "INSERT INTO mantencion_ti "
                + "(id_activo, id_usuario_soporte, tipo_mantencion, descripcion_falla, "
                + " accion_realizada, proxima_revision, fecha_inicio, fecha_termino, estado_equipo) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        String sqlStock = "UPDATE repuestos SET stock_actual = stock_actual - ? WHERE id_repuesto = ?";

        Connection con = null;
        try {
            con = ConexionBD.conectar();
            con.setAutoCommit(false);
            int idMantencion = -1;

            PreparedStatement ps = con.prepareStatement(sqlMant, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, m.getIdActivo());
            ps.setInt(2, m.getIdUsuarioSoporte());
            ps.setString(3, m.getTipoMantencion());
            ps.setString(4, m.getDescripcionFalla());
            ps.setString(5, m.getAccionRealizada());

            if (m.getProximaRevision() != null) {
                ps.setDate(6, new java.sql.Date(m.getProximaRevision().getTime()));
            } else {
                ps.setNull(6, Types.DATE);
            }

            ps.setTimestamp(7, new Timestamp(
                    m.getFechaInicio() != null ? m.getFechaInicio().getTime() : System.currentTimeMillis()));

            if (m.getFechaTermino() != null) {
                ps.setTimestamp(8, new Timestamp(m.getFechaTermino().getTime()));
            } else {
                ps.setNull(8, Types.TIMESTAMP);
            }

            ps.setString(9, m.getEstadoEquipo() != null ? m.getEstadoEquipo() : "OPERATIVO");
            ps.executeUpdate();

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    idMantencion = keys.getInt(1);
                }
            }

            if (idRepuesto != null && cantidad != null) {
                try (PreparedStatement psS = con.prepareStatement(sqlStock)) {
                    psS.setInt(1, cantidad);
                    psS.setInt(2, idRepuesto);
                    psS.executeUpdate();
                }
            }

            con.commit();
            return idMantencion;

        } catch (SQLException e) {
            if (con != null) try {
                con.rollback();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
            System.err.println("Error en registrarMantencion: " + e.getMessage());
            return -1;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public int registrarMantencionCorrectiva(MantencionTI mant, List<Integer> idsRepuestos) {

        String sqlMant = "INSERT INTO mantencion_ti "
                + "(id_activo, id_usuario_soporte, tipo_mantencion, descripcion_falla, "
                + " accion_realizada, fecha_inicio, fecha_termino, estado_equipo) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        String sqlUso = "INSERT INTO uso_repuestos_ti (id_mantencion, id_repuesto, cantidad_usada) VALUES (?, ?, 1)";
        String sqlStock = "UPDATE repuestos SET stock_actual = stock_actual - 1 WHERE id_repuesto = ?";

        Connection con = null;
        try {
            con = ConexionBD.conectar();
            con.setAutoCommit(false);

            PreparedStatement psMant = con.prepareStatement(sqlMant, PreparedStatement.RETURN_GENERATED_KEYS);
            psMant.setInt(1, mant.getIdActivo());
            psMant.setInt(2, mant.getIdUsuarioSoporte());
            psMant.setString(3, "CORRECTIVO"); // Se pasa el tipo ordenadamente en la posición 3
            psMant.setString(4, mant.getDescripcionFalla());
            psMant.setString(5, mant.getAccionRealizada());

            psMant.setTimestamp(6, new Timestamp(
                    mant.getFechaInicio() != null ? mant.getFechaInicio().getTime() : System.currentTimeMillis()));

            if (mant.getFechaTermino() != null) {
                psMant.setTimestamp(7, new Timestamp(mant.getFechaTermino().getTime()));
            } else {
                psMant.setNull(7, Types.TIMESTAMP);
            }

            psMant.setString(8, mant.getEstadoEquipo() != null ? mant.getEstadoEquipo() : "OPERATIVO");
            psMant.executeUpdate();

            int idMantencion = -1;
            try (ResultSet keys = psMant.getGeneratedKeys()) {
                if (keys.next()) {
                    idMantencion = keys.getInt(1);
                }
            }

            if (idMantencion > 0 && idsRepuestos != null && !idsRepuestos.isEmpty()) {
                try (PreparedStatement psUso = con.prepareStatement(sqlUso); PreparedStatement psStock = con.prepareStatement(sqlStock)) {

                    for (Integer idRep : idsRepuestos) {
                        psUso.setInt(1, idMantencion);
                        psUso.setInt(2, idRep);
                        psUso.addBatch();

                        psStock.setInt(1, idRep);
                        psStock.addBatch();
                    }

                    psUso.executeBatch();
                    psStock.executeBatch();
                }
            }

            con.commit();
            return idMantencion;

        } catch (SQLException e) {
            if (con != null) try {
                con.rollback();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
            System.err.println("Error en transacción correctiva: " + e);
            return -1;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public List<Object[]> listarHistorialTI() {
        List<Object[]> lista = new ArrayList<>();

        String sql = "SELECT m.id_mantencion, "
                + "  a.tipo_dispositivo, "
                + "  a.nro_serie, "
                + "  CONCAT(u_asig.nombre, ' ', u_asig.apellido) AS usuario_asignado, "
                + "  CONCAT(u_sop.nombre,  ' ', u_sop.apellido)  AS tecnico_soporte, "
                + "  m.tipo_mantencion, "
                + "  m.fecha_inicio, "
                + "  m.fecha_termino, "
                + "  m.estado_equipo "
                + "FROM mantencion_ti m "
                + "JOIN activos_ti a      ON m.id_activo          = a.id_activo "
                + "JOIN usuario u_asig    ON a.id_usuario_asignado = u_asig.id_usuario "
                + "JOIN usuario u_sop     ON m.id_usuario_soporte  = u_sop.id_usuario "
                + "ORDER BY m.fecha_inicio DESC";

        try (Connection con = ConexionBD.conectar(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Object[]{
                    rs.getInt("id_mantencion"),
                    rs.getString("tipo_dispositivo"),
                    rs.getString("nro_serie"),
                    rs.getString("usuario_asignado"),
                    rs.getString("tecnico_soporte"),
                    rs.getString("tipo_mantencion"),
                    rs.getTimestamp("fecha_inicio"),
                    rs.getTimestamp("fecha_termino"),
                    rs.getString("estado_equipo")
                });
            }
        } catch (SQLException e) {
            System.err.println("Error al listar historial TI: " + e.getMessage());
        }
        return lista;
    }

    public Object[] obtenerDetalle(int idMantencion) {
        String sqlBase = "SELECT m.id_mantencion, "
                + "  a.tipo_dispositivo, a.marca, a.modelo, a.nro_serie, a.sistema_operativo, "
                + "  CONCAT(u_asig.nombre,' ',u_asig.apellido) AS usuario_asignado, "
                + "  CONCAT(u_sop.nombre, ' ',u_sop.apellido)  AS tecnico_soporte, "
                + "  m.tipo_mantencion, m.descripcion_falla, m.accion_realizada, "
                + "  m.fecha_inicio, m.fecha_termino, m.estado_equipo, m.proxima_revision "
                + "FROM mantencion_ti m "
                + "JOIN activos_ti a   ON m.id_activo          = a.id_activo "
                + "JOIN usuario u_asig ON a.id_usuario_asignado = u_asig.id_usuario "
                + "JOIN usuario u_sop  ON m.id_usuario_soporte  = u_sop.id_usuario "
                + "WHERE m.id_mantencion = ?";

        String sqlRep = "SELECT r.nombre_pieza, ur.cantidad_usada "
                + "FROM uso_repuestos_ti ur "
                + "JOIN repuestos r ON ur.id_repuesto = r.id_repuesto "
                + "WHERE ur.id_mantencion = ?";

        try (Connection con = ConexionBD.conectar()) {

            Object[] resultado = new Object[16];

            try (PreparedStatement ps = con.prepareStatement(sqlBase)) {
                ps.setInt(1, idMantencion);
                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) {
                        return null;
                    }
                    resultado[0] = rs.getInt("id_mantencion");
                    resultado[1] = rs.getString("tipo_dispositivo");
                    resultado[2] = rs.getString("marca");
                    resultado[3] = rs.getString("modelo");
                    resultado[4] = rs.getString("nro_serie");
                    resultado[5] = rs.getString("sistema_operativo");
                    resultado[6] = rs.getString("usuario_asignado");
                    resultado[7] = rs.getString("tecnico_soporte");
                    resultado[8] = rs.getString("tipo_mantencion");
                    resultado[9] = rs.getString("descripcion_falla");
                    resultado[10] = rs.getString("accion_realizada");
                    resultado[11] = rs.getTimestamp("fecha_inicio");
                    resultado[12] = rs.getTimestamp("fecha_termino");
                    resultado[13] = rs.getString("estado_equipo");
                    resultado[14] = rs.getDate("proxima_revision");
                }
            }

            StringBuilder repuestos = new StringBuilder();
            try (PreparedStatement psR = con.prepareStatement(sqlRep)) {
                psR.setInt(1, idMantencion);
                try (ResultSet rsR = psR.executeQuery()) {
                    while (rsR.next()) {
                        repuestos.append("• ")
                                .append(rsR.getString("nombre_pieza"))
                                .append(" (x").append(rsR.getInt("cantidad_usada")).append(")\n");
                    }
                }
            }
            resultado[15] = repuestos.length() > 0 ? repuestos.toString().trim() : "Ninguno";

            return resultado;

        } catch (SQLException e) {
            System.err.println("Error al obtener detalle: " + e.getMessage());
            return null;
        }
    }

    public boolean actualizarEstado(int idMantencion, String nuevoEstado) {
        String sql = "UPDATE mantencion_ti SET estado_equipo = ? WHERE id_mantencion = ?";
        try (Connection con = ConexionBD.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nuevoEstado);
            ps.setInt(2, idMantencion);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar estado: " + e.getMessage());
            return false;
        }
    }
}
