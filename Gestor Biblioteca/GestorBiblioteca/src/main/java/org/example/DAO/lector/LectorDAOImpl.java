package org.example.DAO.lector;

import org.example.model.Lector;
import org.example.utils.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LectorDAOImpl implements LectorDAO {

    private Connection conn = ConexionBD.getConnection();


    @Override
    public int add(Lector object) {
        String sqlPersona = "INSERT INTO persona (dni, nombre) VALUES (?, ?)";
        String sqlLector = "INSERT INTO lector (dni) VALUES (?)";
        try {
            PreparedStatement psPersona = conn.prepareStatement(sqlPersona);
            psPersona.setString(1, object.getDni());
            psPersona.setString(2, object.getNombre());
            int i = psPersona.executeUpdate();
            psPersona.close();

            PreparedStatement psLector = conn.prepareStatement(sqlLector);
            psLector.setString(1, object.getDni());
            i += psLector.executeUpdate();
            psLector.close();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public ArrayList<Lector> getAll() {
        String sqlLector = "SELECT * FROM lector";
        String sqlPersona = "SELECT * FROM persona WHERE dni = ?";

        ArrayList<Lector> lectores = new ArrayList<>();
        try {
            PreparedStatement psLector = conn.prepareStatement(sqlLector);
            ResultSet rsLector = psLector.executeQuery();
            while (rsLector.next()) {
                String dni = rsLector.getString("dni");
                String nombre = "";

                PreparedStatement psPersona = conn.prepareStatement(sqlPersona);
                psPersona.setString(1, dni);
                ResultSet rsPersona = psPersona.executeQuery();
                while (rsPersona.next()) {
                    nombre = rsPersona.getString("nombre");
                }

                rsPersona.close();
                psPersona.close();

                Lector lector = new Lector(dni, nombre);
                lectores.add(lector);
            }

            rsLector.close();
            psLector.close();

            return lectores;
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
    public Lector getById(int id) {
        return null;
    }

    @Override
    public int deleteByDni(String dni) {
        String sql = "DELETE FROM lector WHERE dni = ?";
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

    @Override
    public Lector getByDni(String dni) {
        String sql = "SELECT * FROM lector WHERE dni = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();
            String nombre = "";
            if (rs.next()) {
                nombre = rs.getString("nombre");
            }

            Lector lector = new Lector(dni, nombre);
            return lector;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
