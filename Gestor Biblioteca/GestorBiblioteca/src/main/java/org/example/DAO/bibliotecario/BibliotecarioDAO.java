package org.example.DAO.bibliotecario;

import org.example.DAO.IOperationsCRUD;
import org.example.model.Bibliotecario;

public interface BibliotecarioDAO extends IOperationsCRUD<Bibliotecario> {
    public int add (Bibliotecario object);
    public int deleteByDni(String dni);
}
