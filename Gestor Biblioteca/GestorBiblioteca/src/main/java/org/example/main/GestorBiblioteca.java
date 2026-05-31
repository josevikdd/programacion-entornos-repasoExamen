package org.example.main;

import org.example.DAO.copia.CopiaDAOImpl;
import org.example.model.Copia;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorBiblioteca
{

    private final static Scanner sc = new Scanner(System.in);

    private static CopiaDAOImpl copiaDAOImpl = new CopiaDAOImpl();

    public static void main( String[] args ) {



        boolean salir = false;

        while ( !salir ) {
            menuPrincipal();
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    crearCopia();
                    break;
                case 2:
                    eliminarCopia();
                    break;
                case 3:
                    listarCopias();
                    break;
                case 11:
                    System.out.println("Cerrando sesión.");
                    salir = true;
                    break;
            }
        }
    }

    public static void menuPrincipal(){
        System.out.println("MENU PRINCIPAL");
        System.out.println("1.- Añadir copia.");
        System.out.println("2.- Borrar copia.");
        System.out.println("3.- Listar copias.");
        System.out.println("4.- Prestar copia.");
        System.out.println("5.- Crear bibliotecario.");
        System.out.println("6.- Eliminar bibliotecario.");
        System.out.println("7.- Listar bibliotecarios.");
        System.out.println("8.- Crear lector.");
        System.out.println("9.- Eliminar lector.");
        System.out.println("10.- Listar lectores.");
        System.out.println("11.- Salir.");
    }

    public static boolean existeCopia(int id){
        ArrayList<Copia> copias = copiaDAOImpl.getAll();

        for (Copia copia : copias){
            if(copia.getId() == id){
                return true;
            }
        }
        return false;
    }

    public static void crearCopia(){
        System.out.println("Ingrese id de la copia.");
        int id = sc.nextInt();
        sc.nextLine();

        if (!existeCopia(id)){
            System.out.println("Ingrese nombre de la copia.");
            String nombre = sc.nextLine();

            System.out.println("Ingrese el tipo de la copia");
            String tipo = sc.nextLine();

            System.out.println("Ingrese la editorial de la copia.");
            String editorial = sc.nextLine();

            System.out.println("Ingrese el año de la copia.");
            int ano =  sc.nextInt();
            sc.nextLine();

            System.out.println("Ingrese el autor de la copia.");
            String autor = sc.nextLine();

            System.out.println("Ingrese el estado de la copia.");
            String estado = sc.nextLine();

            Copia copia = new Copia(id, nombre, tipo, editorial, ano, autor, estado);

            if (copiaDAOImpl.add(copia) == 1){
                System.out.println("Copia creada con éxito.");
            } else {
                System.out.println("Error al crear la copia.");
            }
        } else {
            System.out.println("Ya existe una copia con esa ID. Volviendo al menú principal.");
        }
    }

    public static void eliminarCopia(){
        listarCopias();
        System.out.println("Ingrese id de la copia.");

        if (copiaDAOImpl.deleteById(sc.nextInt()) == 1){
            System.out.println("Copia eliminada con exito.");
        } else {
            System.out.println("No existe una copia con la ID ingresada.");
        }
    }

    public static void listarCopias(){
        ArrayList<Copia> copias = copiaDAOImpl.getAll();

        for (Copia copia : copias){
            copia.mostrarDatos();
        }
    }
}
