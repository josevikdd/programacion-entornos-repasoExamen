package org.example.DAO.copia;

import org.example.model.Copia;
import org.example.utils.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class CopiaDAOImpl implements CopiaDAO {

    private Connection conn = ConexionBD.getConnection();

    @Override
    public int add (Copia copia){
        String sql = "INSERT INTO copia (id_copia, nombre_libro, tipo, editorial, anio, autor, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, copia.getId());
            ps.setString(2, copia.getNombre());
            ps.setString(3, copia.getTipo());
            ps.setString(4, copia.getEditorial());
            ps.setInt(5, copia.getAno());
            ps.setString(6, copia.getAutor());
            ps.setString(7, copia.getEstado());
            int i = ps.executeUpdate();
            ps.close();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
