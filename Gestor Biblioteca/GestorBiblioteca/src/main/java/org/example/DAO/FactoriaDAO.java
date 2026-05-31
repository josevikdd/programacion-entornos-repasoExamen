package org.example.DAO;

import org.example.DAO.copia.CopiaDAOImpl;

public class FactoriaDAO {

    private static CopiaDAOImpl copiaDAOImpl = null;

    public static CopiaDAOImpl getCopiaDAOImpl() {
        if (copiaDAOImpl == null) {
            copiaDAOImpl = new CopiaDAOImpl();
        }
        return copiaDAOImpl;
    }
}
