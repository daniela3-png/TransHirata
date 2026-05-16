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
    private ConexionBD conexion = new ConexionBD();

    public List<Repuesto> listarRepuestosDisponibles() {
        List<Repuesto> lista = new ArrayList<>();
        String sql = "SELECT id_repuesto, nombre_pieza, stock_actual FROM repuestos WHERE stock_actual > 0";
        
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Repuesto r = new Repuesto();
                r.setIdRepuesto(rs.getInt("id_repuesto"));
                r.setNombrePieza(rs.getString("nombre_pieza"));
                r.setStockActual(rs.getInt("stock_actual"));
                lista.add(r);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar repuestos: " + e);
        }
        return lista;
    }
    
    public List<Repuesto> listarPorCategoria(String cat) {
        List<Repuesto> lista = new ArrayList<>();
        String sql = "SELECT * FROM repuestos WHERE categoria = ? AND stock_actual > 0";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cat);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Repuesto r = new Repuesto();
                r.setIdRepuesto(rs.getInt("id_repuesto"));
                r.setNombrePieza(rs.getString("nombre_pieza"));
                lista.add(r);
            }
        } catch (SQLException e) { System.err.println(e); }
        return lista;
    }
}