package dao;

import conexion.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.ActivoTI;

public class ActivoTIDAO {
    ConexionBD conexion = new ConexionBD();

    public List<ActivoTI> listarEquiposOficina() {
        List<ActivoTI> lista = new ArrayList<>();
        String sql = "SELECT * FROM activos_ti";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                ActivoTI a = new ActivoTI();
                a.setIdActivo(rs.getInt("id_activo"));
                a.setTipoDispositivo(rs.getString("tipo_dispositivo"));
                a.setMarca(rs.getString("marca"));
                a.setModelo(rs.getString("modelo"));
                a.setNroSerie(rs.getString("nro_serie"));
                a.setEstado(rs.getString("estado"));
                a.setSistemaOperativo(rs.getString("sistema_operativo"));
                a.setVersionSW(rs.getString("version_sw"));
                lista.add(a);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar activos: " + e.getMessage());
        }
        return lista;
    }
    
       public List<ActivoTI> listarPorUsuario(int idUsuario) {
    List<ActivoTI> lista = new ArrayList<>();
    String sql = "SELECT * FROM activos_ti WHERE id_usuario_asignado = ?";

    try (Connection con = ConexionBD.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, idUsuario);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            ActivoTI a = new ActivoTI();
            a.setIdActivo(rs.getInt("id_activo"));
            a.setTipoDispositivo(rs.getString("tipo_dispositivo"));
            a.setMarca(rs.getString("marca")); // 👈 CLAVE
            a.setModelo(rs.getString("modelo")); // 👈 CLAVE
            a.setNroSerie(rs.getString("nro_serie"));
            a.setSistemaOperativo(rs.getString("sistema_operativo")); // 👈 CLAVE
            lista.add(a);
        }

    } catch (SQLException e) {
        System.err.println(e);
    }

    return lista;
}
}