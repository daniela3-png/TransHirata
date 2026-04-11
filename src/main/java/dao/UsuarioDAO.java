package dao;

import conexion.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;

public class UsuarioDAO {
    
    public Usuario login(String rut, String contrasena) {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuario WHERE rut = ? AND contrasena = ?";
        
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            if (con == null) {
                System.out.println("Error: La conexión no se pudo establecer.");
                return null;
            }

            
            ps.setString(1, rut);
            ps.setString(2, contrasena);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setRut(rs.getString("rut"));
                usuario.setRol(rs.getString("rol"));
            }
        } catch (SQLException e) {
            System.err.println("Error en LoginDAO: " + e.getMessage());
        }
        return usuario;
    }
    
    public boolean insertarUsuario(Usuario u) {
    String sql = "INSERT INTO usuario (rut, nombre, apellido, contrasena, rol) VALUES (?, ?, ?, ?, ?)";
    try (Connection con = ConexionBD.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, u.getRut());
        ps.setString(2, u.getNombre());
        ps.setString(3, u.getApellido());
        ps.setString(4, u.getContrasena());
        ps.setString(5, u.getRol());
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        System.err.println("Error al insertar usuario: " + e.getMessage());
        return false;
    }
}

    public List<Usuario> listarConductores() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario WHERE rol = 'CONDUCTOR'";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setRut(rs.getString("rut"));
                u.setNombre(rs.getString("nombre"));
                u.setApellido(rs.getString("apellido"));
                lista.add(u);
            }
        } catch (SQLException e) { System.out.println(e); }
        return lista;
    }
    
    public java.util.ArrayList<modelo.Usuario> listarUsuariosPorRol(String rolBuscado) {
    java.util.ArrayList<modelo.Usuario> lista = new java.util.ArrayList<>();
    String sql = "SELECT * FROM usuario WHERE rol = ?";
    
    try (java.sql.Connection con = conexion.ConexionBD.conectar();
         java.sql.PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setString(1, rolBuscado);
        java.sql.ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            modelo.Usuario u = new modelo.Usuario();
            u.setRut(rs.getString("rut"));
            u.setNombre(rs.getString("nombre"));
            u.setApellido(rs.getString("apellido"));
            lista.add(u);
        }
    } catch (java.sql.SQLException e) {
        System.err.println("Error al listar: " + e.getMessage());
    }
    return lista;
}
    
    public boolean eliminarConductor(String rut) {
        String sql = "DELETE FROM usuario WHERE rut = ? AND rol = 'CONDUCTOR'";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, rut);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { 
            System.err.println("Error al eliminar: " + e.getMessage());
            return false; 
        }
    }

    public boolean modificarConductor(modelo.Usuario u) {
        String sql = "UPDATE usuario SET nombre = ?, apellido = ?, contrasena = ? WHERE rut = ?";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getApellido());
            ps.setString(3, u.getContrasena());
            ps.setString(4, u.getRut());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { return false; }
    }
}