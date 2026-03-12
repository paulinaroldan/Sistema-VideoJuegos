package UI;

import Excepcion.IdentificadorDuplicadoEx;
import Modelo.Expansion;
import Modelo.IMediaItem;
import Modelo.Juego;
import Repositorio.IRepositorio;
import Repositorio.Repositorio;
import com.sun.source.doctree.EscapeTree;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private IRepositorio repositorio;


    public Menu() {
        this.repositorio = new Repositorio();
    }

    public void MenuFinal(){
        Scanner sc=new Scanner(System.in);
        int opcion=0;
        char seguir='s';
        do {
            System.out.println("MENU PRINCIPAL");
            System.out.println("1. Cargar");
            System.out.println("2. Mostrar todo");
            System.out.println("3. Eliminar");
            System.out.println("4. Filtrar por genero");
            System.out.println("5. Modificar");
            System.out.println("6. Buscar por id");
            System.out.println("7. Salir");
            opcion=sc.nextInt();
            sc.nextLine();
            switch (opcion){
                case 1:
                    menuCargar();
                    break;
                    case 2:
                        System.out.println(repositorio.mostrar());
                        break;
                case 3:
                    System.out.println("Ingrese id de objeto a eliminar");
                    int id=sc.nextInt();
                    boolean encontrado=repositorio.eliminar(id);
                    if (encontrado==true){
                        System.out.println("se elimino");
                    }else {
                        System.out.println("no se elimino");
                    }
                    break;
                case 4:
                    ArrayList rta=new ArrayList<>();
                    System.out.println("Ingrese genero a buscar");
                    String genero=sc.nextLine();
                    rta.add(repositorio.buscarPorGenero(genero));
                    System.out.println(rta.toString());
                    break;
                case 5:
                    System.out.println("Ingrese id de objeto a modificar");
                    int idB = sc.nextInt();

                    System.out.println("Opciones a modificar");
                    System.out.println("1. Titulo");
                    System.out.println("2. Genero");
                    System.out.println("3. Creador");
                    System.out.println("4. Numero de version");
                    System.out.println("5. Fecha de lanzamiento");
                    System.out.println("ingrese opcion");
                    int num=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingrese nuevo valor");
                    String nuevoValor=sc.nextLine();
                    System.out.println(repositorio.modificar(idB, num, nuevoValor));

                    break;
                case 6:
                    System.out.println("Ingrese id a buscar");
                    idB=sc.nextInt();
                    System.out.println(repositorio.buscarPorId(idB));
                    break;
                case 7:
                    seguir='n';
                    break;
            }
            if (opcion!=7){
                System.out.println("Quiere elegir otra opcion? s/n");
                seguir=sc.next().charAt(0);
            }
        }while(seguir=='s' && opcion!=7);
    }

    public void menuCargar(){
        int opcion=0;
        char seguir='s';
        Scanner sc=new Scanner(System.in);
        String titulo="";
        String creador="";
        String genero="";
        do{
            System.out.println("MENU CARGAR");
            System.out.println("1. Cargar juego");
            System.out.println("2. Cargar Expansion");
            System.out.println("3. Salir");
            opcion=sc.nextInt();
            sc.nextLine();
            switch (opcion){
                case 1:
                    System.out.println("Ingrese titulo del juego");
                    titulo=sc.nextLine();
                    System.out.println("Ingrese creador del juego");
                    creador=sc.nextLine();
                    System.out.println("Ingrese genero del juego");
                    genero=sc.nextLine();
                    System.out.println("Ingrese numero de version del juego");
                    int numVersion=sc.nextInt();
                    try {
                        repositorio.agregar(new Juego(titulo, creador, genero, numVersion));
                        System.out.println("Juego agregado con exito");
                    }catch (IdentificadorDuplicadoEx e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 2:
                    System.out.println("Ingrese titulo de la expansion");
                    titulo=sc.nextLine();
                    System.out.println("Ingrese creador de la expansion");
                    creador=sc.nextLine();
                    System.out.println("Ingrese genero de la expansion");
                    genero=sc.nextLine();
                    System.out.println("Ingrese fecha de lanzamiento de la expansion");
                    String fechaLanzamiento=sc.nextLine();
                    try {
                        repositorio.agregar(new Expansion(titulo, creador, genero, fechaLanzamiento));
                        System.out.println("Expansion agregado con exito");
                    }catch (IdentificadorDuplicadoEx e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    seguir='n';
                    break;
                default:
                    System.out.println("opcion incorrecta");
                    break;
            }
            if (opcion!=3){
                System.out.println("Quiere cargar de nuevo? s/n");
                seguir=sc.next().charAt(0);
            }
        }while (seguir=='s' && opcion!=3);
    }


}
