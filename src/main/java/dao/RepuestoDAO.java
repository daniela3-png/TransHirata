package dao;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Repuesto;

public class RepuestoDAO {

    public List<Repuesto> listarRepuestosDisponibles() {
        List<Repuesto> lista = new ArrayList<>();
        String sql = "SELECT id_repuesto, nombre_pieza, tipo_pieza, stock_actual, estado_pieza, categoria FROM repuestos";
        
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Repuesto r = new Repuesto();
                r.setIdRepuesto(rs.getInt("id_repuesto"));
                r.setNombrePieza(rs.getString("nombre_pieza"));
                r.setTipoPieza(rs.getString("tipo_pieza"));
                r.setStockActual(rs.getInt("stock_actual"));
                r.setEstadoPieza(rs.getString("estado_pieza"));
                r.setCategoria(rs.getString("categoria"));
                lista.add(r);
            }
        } catch (SQLException e) {
            System.err.println("Error en listarRepuestosDisponibles: " + e.getMessage());
        }
        return lista;
    }

    public List<Repuesto> listarPorCategoria(String categoria) {
        List<Repuesto> lista = new ArrayList<>();
        String sql = "SELECT id_repuesto, nombre_pieza, tipo_pieza, stock_actual, estado_pieza, categoria FROM repuestos WHERE categoria = ?";
        
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, categoria);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Repuesto r = new Repuesto();
                    r.setIdRepuesto(rs.getInt("id_repuesto"));
                    r.setNombrePieza(rs.getString("nombre_pieza"));
                    r.setTipoPieza(rs.getString("tipo_pieza"));
                    r.setStockActual(rs.getInt("stock_actual"));
                    r.setEstadoPieza(rs.getString("estado_pieza"));
                    r.setCategoria(rs.getString("categoria"));
                    lista.add(r);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error en listarPorCategoria: " + e.getMessage());
        }
        return lista;
    }
}