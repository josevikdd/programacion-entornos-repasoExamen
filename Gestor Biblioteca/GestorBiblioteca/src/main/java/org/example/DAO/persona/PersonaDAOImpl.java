package org.example.DAO.persona;

import org.example.model.Persona;
import org.example.utils.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PersonaDAOImpl implements PersonaDAO {

    private Connection conn = ConexionBD.getConnection();


    @Override
    public int add(Persona object) {
        return 0;
    }

    @Override
    public ArrayList<Persona> getAll() {
        ArrayList<Persona> personas = new ArrayList<>();
        String sql = "SELECT * FROM persona";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");

                Persona persona = new Persona(dni, nombre);
                personas.add(persona);
            }
            rs.close();
            ps.close();
            return personas;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int deleteById(int id) {
        return 0;
    }

    @Override
    public int deleteByDni(String dni) {
        String sql = "DELETE FROM persona WHERE dni = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dni);
            int i = ps.executeUpdate();
            ps.close();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
