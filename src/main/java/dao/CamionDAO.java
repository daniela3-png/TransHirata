package dao;

import conexion.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Camion;

public class CamionDAO {

    public boolean insertarCamion(Camion c) throws SQLException {
    String sql = "INSERT INTO camion (patente, marca, modelo, anio, kilometraje_actual) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, c.getPatente());
            ps.setString(2, c.getMarca());
            ps.setString(3, c.getModelo());
            ps.setInt(4, c.getAnio());
            ps.setInt(5, c.getKilometrajeActual());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean eliminarCamion(String patente) {
        String sql = "DELETE FROM camion WHERE patente = ?";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, patente);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }

    public boolean modificarCamion(Camion c) throws SQLException {
        String sql = "UPDATE camion SET marca=?, modelo=?, anio=?, kilometraje_actual=? WHERE TRIM(patente)=TRIM(?)";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getMarca());
            ps.setString(2, c.getModelo());
            ps.setInt(3, c.getAnio());
            ps.setInt(4, c.getKilometrajeActual());
            ps.setString(5, c.getPatente());

            int filasAfectadas = ps.executeUpdate();

            System.out.println("Filas actualizadas en DB: " + filasAfectadas);

            return filasAfectadas > 0;
        }
    }
    
    public List<Camion> listarCamiones() {
        List<Camion> lista = new ArrayList<>();
        String sql = "SELECT * FROM camion";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Camion c = new Camion();
                c.setPatente(rs.getString("patente"));
                c.setMarca(rs.getString("marca"));
                c.setModelo(rs.getString("modelo"));
                c.setAnio(rs.getInt("anio"));
                c.setKilometrajeActual(rs.getInt("kilometraje_actual"));
                lista.add(c);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar camiones: " + e.getMessage());
        }
        return lista;
    }

    public Camion buscarCamionPorPatente(String patente) {
        String sql = "SELECT * FROM camion WHERE patente = ?";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, patente);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Camion c = new Camion();
                    c.setPatente(rs.getString("patente"));
                    c.setMarca(rs.getString("marca"));
                    c.setModelo(rs.getString("modelo"));
                    c.setAnio(rs.getInt("anio"));
                    c.setKilometrajeActual(rs.getInt("kilometraje_actual"));
                    return c;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar camión: " + e.getMessage());
        }
        return null;
    }

    public boolean actualizarKilometraje(String patente, int nuevoKm) {
        String sql = "UPDATE camion SET kilometraje_actual = ? WHERE patente = ?";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, nuevoKm);
            ps.setString(2, patente);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar odómetro: " + e.getMessage());
            return false;
        }
    }
    
    
    public int obtenerKilometrajeActual(String patente) {
        String sql = "SELECT kilometraje_actual FROM camion WHERE patente = ?";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, patente);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("kilometraje_actual");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener KM: " + e.getMessage());
        }
        return 0; 
    }
    
    public List<String> listarPatentes() {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT patente FROM camion WHERE estado = 'ACTIVO'";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(rs.getString("patente"));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar patentes: " + e.getMessage());
        }
        return lista;
    }
}