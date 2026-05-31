package org.example.DAO.copia;

import org.example.DAO.IOperationsCRUD;
import org.example.model.Copia;

import java.util.ArrayList;

public interface CopiaDAO extends IOperationsCRUD<Copia> {
    public int add (Copia object);
    public ArrayList<Copia> getAll();
    public int deleteById(int id);
}
