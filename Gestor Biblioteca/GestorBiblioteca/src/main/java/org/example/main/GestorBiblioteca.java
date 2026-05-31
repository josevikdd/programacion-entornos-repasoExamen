package org.example.main;

import org.example.DAO.bibliotecario.BibliotecarioDAOImpl;
import org.example.DAO.copia.CopiaDAOImpl;
import org.example.DAO.lector.LectorDAOImpl;
import org.example.DAO.persona.PersonaDAOImpl;
import org.example.model.Bibliotecario;
import org.example.model.Copia;
import org.example.model.Lector;
import org.example.model.Persona;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorBiblioteca
{
    //Por tiempo y para practicar otros enunciados hemos reducido el tamaño del programa y no hemos usado ninguna fecha en este.
    private final static Scanner sc = new Scanner(System.in);

    private static CopiaDAOImpl copiaDAOImpl = new CopiaDAOImpl();
    private static BibliotecarioDAOImpl bibliotecarioDAOImpl = new BibliotecarioDAOImpl();
    private static PersonaDAOImpl personaDAOImpl = new PersonaDAOImpl();
    private static LectorDAOImpl lectorDAOImpl = new LectorDAOImpl();

    public static void main( String[] args ) {



        boolean salir = false;

        while ( !salir ) {
            menuPrincipal();
            int opcion = sc.nextInt();
            sc.nextLine();
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
                case 4:
                    prestarCopia();
                    break;
                case 5:
                    crearBibliotecario();
                    break;
                case 6:
                    eliminarBibliotecario();
                    break;
                case 7:
                    listarBibliotecarios();
                    break;
                case 8:
                    crearLector();
                    break;
                case 9:
                    eliminarLector();
                    break;
                case 10:
                    listarLectores();
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

    public static void prestarCopia(){
        listarCopias();
        System.out.println("Ingrese id de la copia.");
        Copia copia = copiaDAOImpl.getById(sc.nextInt());

        listarLectores();
        System.out.println("Seleccione el DNI del lector.");
        String dni = sc.nextLine();
        if (existeLector(dni)){
            Lector lector = lectorDAOImpl.getByDni(dni);

            lector.prestar(copia);
        } else {
            System.out.println("No existe un lector con ese DNI.");
        }
    }

    public static boolean existeLector(String dni){
        ArrayList<Lector> lectores = lectorDAOImpl.getAll();

        for (Lector lector : lectores){
            if(lector.getDni().equals(dni)){
                return true;
            }
        }
        return false;
    }

    public static void crearBibliotecario(){
        System.out.println("Ingrese el DNI del bibliotecario.");
        String dni = sc.nextLine();

        if(!existePersona(dni)){
            System.out.println("Ingrese el nombre del bibliotecario.");
            String nombre = sc.nextLine();

            System.out.println("Ingrese el puesto del bibliotecario.");
            String puesto = sc.nextLine();

            Bibliotecario bibliotecario = new Bibliotecario(dni, nombre, puesto);

            if (bibliotecarioDAOImpl.add(bibliotecario)==2) {
                System.out.println("Bibliotecario creado con éxito.");
            } else {
                System.out.println("Error al crear bibliotecario.");
            }
        } else {
            System.out.println("Ya existe una persona en el sistema con ese DNI.");
        }
    }

    public static boolean existePersona(String dni){
        ArrayList<Persona> personas = personaDAOImpl.getAll();
        for (Persona persona : personas){
            if (persona.getDni().equals(dni)){
                return true;
            }
        }
        return false;
    }

    public static void eliminarBibliotecario(){
        listarBibliotecarios();
        System.out.println("Ingrese el DNI del bibliotecario a eliminar.");
        String dni = sc.nextLine();

        if ((bibliotecarioDAOImpl.deleteByDni(dni)==1)&&(personaDAOImpl.deleteByDni(dni)== 1)){
            System.out.println("Bibliotecario eliminado con exito.");
        } else {
            System.out.println("Error al eliminar bibliotecario.");
        }
    }

    public static void listarBibliotecarios(){
        ArrayList<Bibliotecario> bibliotecarios = bibliotecarioDAOImpl.getAll();

        for (Bibliotecario bibliotecario : bibliotecarios){
            bibliotecario.mostrarDatos();
        }
    }

    public static void crearLector(){
        System.out.println("Ingrese el DNI del lector.");
        String dni  = sc.nextLine();
        if (!existePersona(dni)){
            System.out.println("Ingrese el nombre del lector.");
            String nombre = sc.nextLine();

            Lector lector = new Lector(dni, nombre);

            if (lectorDAOImpl.add(lector) == 1) {
                System.out.println("Lector creado con éxito.");
            } else {
                System.out.println("Error al crear al nuevo lector.");
            }
        }
    }

    public static void eliminarLector(){
        listarLectores();
        System.out.println("Ingrese el DNI del lector a eliminar.");
        if (lectorDAOImpl.deleteByDni(sc.nextLine()) == 1){
            System.out.println("Lector eliminado con exito.");
        } else {
            System.out.println("Error al eliminar lector.");
        }
    }

    public static void listarLectores(){
        ArrayList<Lector> lectores = lectorDAOImpl.getAll();

        for (Lector lector : lectores){
            lector.mostrarDatos();
        }
    }
}
