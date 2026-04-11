package dao;
import java.sql.*;
import conexion.ConexionBD;
import modelo.RegistroKilometraje;

public class RegistroKilometrajeDAO {
    public boolean guardarRegistro(RegistroKilometraje r) {
        String sql = "INSERT INTO registro_kilometraje (patente, kilometraje, fecha_registro) VALUES (?, ?, NOW())";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, r.getPatente());
            ps.setInt(2, r.getKilometraje());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al guardar historial: " + e.getMessage());
            return false;
        }
    }
}