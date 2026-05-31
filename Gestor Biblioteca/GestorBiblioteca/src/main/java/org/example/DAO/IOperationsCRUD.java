package org.example.DAO;

import java.util.ArrayList;

public interface IOperationsCRUD <T>{

    public int add (T object);
    public ArrayList<T> getAll();
    public int deleteById(int id);
    public T getById(int id);
}
