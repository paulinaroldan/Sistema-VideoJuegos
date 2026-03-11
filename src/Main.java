import Modelo.Expansion;
import Modelo.Juego;
import Repositorio.IRepositorio;
import Repositorio.Repositorio;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        IRepositorio repositorio = new Repositorio();
        repositorio.agregar(new Juego("juego1", "pau", "genero", 2));
        repositorio.agregar(new Juego("juego2", "pau2", "genero2", 1));
        repositorio.agregar(new Expansion("Expansion 1", "Carlos", "genero", "01/02/2026"));
        System.out.println("MOSTRAR TODO");
        System.out.println(repositorio.mostrar());
        System.out.println("BUSCAR POR ID");
        System.out.println(repositorio.buscarPorId(1));
        System.out.println(repositorio.buscarPorId(3));
        System.out.println(repositorio.buscarPorId(4));
        System.out.println("ELIMINAR");
        boolean encontrado=repositorio.eliminar(22);
        if (encontrado==true){
            System.out.println("se elimino");
            System.out.println(repositorio.mostrar());
        }else {
            System.out.println("no se elimino");
            System.out.println(repositorio.mostrar());
        }
        System.out.println("BUSCAR POR GENERO");
        ArrayList generos=new ArrayList();
        generos.add(repositorio.buscarPorGenero("genero2"));
        System.out.println(generos);
        System.out.println("MODIFICAR");
        System.out.println(repositorio.modificar(1, 1, "Titulo Nuevo"));
        System.out.println(repositorio.mostrar());

    }
}