package org.example.DAO.copia;

import org.example.model.Copia;
import org.example.utils.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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

    @Override
    public ArrayList<Copia> getAll() {
        ArrayList<Copia> copias = new ArrayList<>();

        try {
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM copia";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id_copia");
                String nombre = rs.getString("nombre_libro");
                String tipo = rs.getString("tipo");
                String editorial = rs.getString("editorial");
                int anio = rs.getInt("anio");
                String autor = rs.getString("autor");
                String estado = rs.getString("estado");

                Copia copia = new Copia (id, nombre, tipo, editorial, anio, autor, estado);
                copias.add(copia);
            }

            rs.close();
            st.close();

            return copias;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
