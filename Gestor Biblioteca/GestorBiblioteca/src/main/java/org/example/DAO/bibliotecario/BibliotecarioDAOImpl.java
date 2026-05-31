package org.example.DAO.bibliotecario;

import org.example.model.Bibliotecario;
import org.example.utils.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BibliotecarioDAOImpl implements BibliotecarioDAO {

    private Connection conn = ConexionBD.getConnection();

    @Override
    public int add(Bibliotecario object) {
        String sqlPersona = "INSERT INTO persona (dni, nombre) VALUES (?, ?)";
        String sqlBibliotecario = "INSERT INTO bibliotecario (dni, puesto) VALUES (?, ?)";
        try {
            PreparedStatement psPersona = conn.prepareStatement(sqlPersona);
            psPersona.setString(1, object.getDni());
            psPersona.setString(2, object.getNombre());
            int i = psPersona.executeUpdate();
            psPersona.close();

            PreparedStatement psBibliotecario = conn.prepareStatement(sqlBibliotecario);
            psBibliotecario.setString(1, object.getDni());
            psBibliotecario.setString(2, object.getPuesto());
            i += psBibliotecario.executeUpdate();
            psBibliotecario.close();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public ArrayList<Bibliotecario> getAll() {
        ArrayList<Bibliotecario> bibliotecarios = new ArrayList<>();

        String sqlPersona = "SELECT * FROM persona";

        try {
            PreparedStatement psPersona = conn.prepareStatement(sqlPersona);
            ResultSet rsPersona = psPersona.executeQuery();

            while (rsPersona.next()) {
                String dni = rsPersona.getString("dni");
                String nombre = rsPersona.getString("nombre");

                String sqlBibliotecario = "SELECT * FROM bibliotecario WHERE dni =?";
                PreparedStatement psBibliotecario = conn.prepareStatement(sqlBibliotecario);
                psBibliotecario.setString(1, dni);
                ResultSet rsBibliotecario = psBibliotecario.executeQuery();

                if (rsBibliotecario.next()) {
                    String puesto = rsBibliotecario.getString("puesto");

                    Bibliotecario bibliotecario = new Bibliotecario(dni, nombre, puesto);
                    bibliotecarios.add(bibliotecario);
                }

                rsBibliotecario.close();
                psBibliotecario.close();
            }
            rsPersona.close();
            psPersona.close();

            return bibliotecarios;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int deleteById(int id) {
        return -1;
    }

    @Override
    public int deleteByDni(String dni) {
        String sql = "DELETE FROM bibliotecario WHERE dni = ?";
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
