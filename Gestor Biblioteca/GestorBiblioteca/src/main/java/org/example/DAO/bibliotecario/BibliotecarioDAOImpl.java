package org.example.DAO.bibliotecario;

import org.example.model.Bibliotecario;
import org.example.utils.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        return null;
    }

    @Override
    public int deleteById(int id) {
        return 0;
    }
}
