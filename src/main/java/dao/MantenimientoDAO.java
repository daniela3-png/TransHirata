package dao;

import conexion.ConexionBD;
import java.sql.*;

public class MantenimientoDAO {

    public int existeMantenimientoPendiente(String patente, int kmProgramado) {
        String sql = "SELECT id_mantenimiento FROM mantenimiento WHERE patente = ? AND kilometraje_programado = ? AND realizado = false LIMIT 1";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, patente);
            ps.setInt(2, kmProgramado);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id_mantenimiento");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar duplicidad: " + e.getMessage());
        }
        return -1; 
    }

    public int agendarMantencion(String patente, int kmProg, String solicitante, java.sql.Date fecha) {
        int idExistente = existeMantenimientoPendiente(patente, kmProg);
        if (idExistente != -1) {
            javax.swing.JOptionPane.showMessageDialog(null, "Este camión ya tiene una mantención pendiente con el ID: " + idExistente);
            return -2;
        }

        String sqlInsert = "INSERT INTO mantenimiento (patente, kilometraje_programado, fecha_mantenimiento, solicitado_por, realizado) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, patente);
            ps.setInt(2, kmProg);
            ps.setDate(3, fecha);
            ps.setString(4, solicitante);
            ps.setBoolean(5, false);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            System.err.println("Error al agendar: " + e.getMessage());
        }
        return -1;
    }
    
    public java.util.List<modelo.Mantenimiento> listarTodo() {
            java.util.List<modelo.Mantenimiento> lista = new java.util.ArrayList<>();
            String sql = "SELECT id_mantenimiento, patente, kilometraje_programado, fecha_mantenimiento, solicitado_por, realizado FROM mantenimiento ORDER BY id_mantenimiento DESC";

            try (Connection con = ConexionBD.conectar();
                 PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    modelo.Mantenimiento m = new modelo.Mantenimiento();
                    m.setId(rs.getInt("id_mantenimiento"));
                    m.setPatente(rs.getString("patente"));
                    m.setKilometrajeProgramado(rs.getInt("kilometraje_programado"));
                    m.setFecha(rs.getDate("fecha_mantenimiento"));
                    m.setSolicitadoPor(rs.getString("solicitado_por"));
                    m.setRealizado(rs.getBoolean("realizado"));
                    lista.add(m);
                }
            } catch (SQLException e) { System.err.println("Error: " + e.getMessage()); }
            return lista;
        }

    public java.util.List<Object[]> listarMantenimientosPendientes() {
        java.util.List<Object[]> lista = new java.util.ArrayList<>();
        String sql = "SELECT m.id_mantenimiento, m.patente, c.marca, c.modelo, m.kilometraje_programado " +
                     "FROM mantenimiento m " +
                     "JOIN camion c ON m.patente = c.patente " +
                     "WHERE m.realizado = false";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Object[]{
                    rs.getInt("id_mantenimiento"),
                    rs.getString("patente"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getInt("kilometraje_programado")
                });
            }
        } catch (SQLException e) {
            System.err.println("Error al listar pendientes: " + e.getMessage());
        }
        return lista;
    }

    public boolean finalizarServicio(String idTicket, String detalle, String patente, int nuevoKm) {
        String sqlTicket = "UPDATE mantenimiento SET realizado = true, detalle_servicio = ? WHERE id_mantenimiento = ?";
        String sqlCamion = "UPDATE camion SET kilometraje_actual = ?, estado = 'ACTIVO' WHERE patente = ?";

        try (Connection con = ConexionBD.conectar()) {
            con.setAutoCommit(false);

            try (PreparedStatement ps1 = con.prepareStatement(sqlTicket);
                 PreparedStatement ps2 = con.prepareStatement(sqlCamion)) {

                ps1.setString(1, detalle);
                ps1.setInt(2, Integer.parseInt(idTicket));
                ps1.executeUpdate();

                ps2.setInt(1, nuevoKm);
                ps2.setString(2, patente);
                ps2.executeUpdate();

                con.commit();
                return true;
            } catch (SQLException e) {
                con.rollback();
                System.err.println("Error en transacción de cierre: " + e.getMessage());
                return false;
            }
        } catch (SQLException e) { return false; }
    }
    
        public int crearMantencionDirecta(String patente, int kmActual, String detalle, String solicitante) {
            String sql = "INSERT INTO mantenimiento (patente, kilometraje_programado, fecha_mantenimiento, solicitado_por, realizado, detalle_servicio) " +
                         "VALUES (?, ?, CURDATE(), ?, false, ?)"; 

            try (Connection con = ConexionBD.conectar();
                 PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                ps.setString(1, patente);

                ps.setInt(2, kmActual);

                ps.setString(3, solicitante); 

                ps.setString(4, "INICIO DIRECTO: " + detalle);

                ps.executeUpdate();

                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) return rs.getInt(1);

            } catch (SQLException e) {
                System.err.println("Error en mantención directa: " + e.getMessage());
            }
            return -1;
        }
}