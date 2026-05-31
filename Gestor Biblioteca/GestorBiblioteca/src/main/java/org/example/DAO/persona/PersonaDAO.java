package org.example.DAO.persona;

import org.example.DAO.IOperationsCRUD;
import org.example.model.Persona;

import java.util.ArrayList;

public interface PersonaDAO extends IOperationsCRUD<Persona> {
    public ArrayList<Persona> getAll();
    public int deleteByDni(String dni);
}
