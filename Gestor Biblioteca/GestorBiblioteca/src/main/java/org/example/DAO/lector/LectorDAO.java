package org.example.DAO.lector;

import org.example.DAO.IOperationsCRUD;
import org.example.model.Bibliotecario;
import org.example.model.Lector;

public interface LectorDAO extends IOperationsCRUD<Lector> {
    public int add (Lector object);
    public int deleteByDni(String dni);
    public Lector getByDni(String dni);
}
