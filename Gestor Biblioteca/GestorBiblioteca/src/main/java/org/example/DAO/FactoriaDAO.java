package org.example.DAO;

import org.example.DAO.bibliotecario.BibliotecarioDAOImpl;
import org.example.DAO.copia.CopiaDAOImpl;
import org.example.DAO.lector.LectorDAOImpl;
import org.example.DAO.persona.PersonaDAOImpl;

public class FactoriaDAO {

    private static CopiaDAOImpl copiaDAOImpl = null;
    private static BibliotecarioDAOImpl bibliotecarioDAOImpl = null;
    private static PersonaDAOImpl personaDAOImpl = null;
    private static LectorDAOImpl lectorDAOImpl = null;

    public static CopiaDAOImpl getCopiaDAOImpl() {
        if (copiaDAOImpl == null) {
            copiaDAOImpl = new CopiaDAOImpl();
        }
        return copiaDAOImpl;
    }

    public static BibliotecarioDAOImpl getBibliotecarioDAOImpl() {
        if (bibliotecarioDAOImpl == null) {
            bibliotecarioDAOImpl = new BibliotecarioDAOImpl();
        }
        return bibliotecarioDAOImpl;
    }

    public static PersonaDAOImpl getPersonaDAOImpl() {
        if (personaDAOImpl == null) {
            personaDAOImpl = new PersonaDAOImpl();
        }
        return personaDAOImpl;
    }

    public static LectorDAOImpl getLectorDAOImpl() {
        if (lectorDAOImpl == null) {
            lectorDAOImpl = new LectorDAOImpl();
        }
        return lectorDAOImpl;
    }
}
