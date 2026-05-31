package org.example.DAO.copia;

import org.example.DAO.IOperationsCRUD;
import org.example.model.Copia;

public interface CopiaDAO extends IOperationsCRUD<Copia> {
    public int add (Copia object);
}
