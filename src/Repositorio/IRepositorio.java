package Repositorio;

import java.util.ArrayList;
import java.util.List;

public interface IRepositorio <T>{
    void agregar(T elemento);
    boolean eliminar(int id);
    List <T> buscarPorGenero(String genero);
    String mostrar();
    String modificar(int id, int valor, String nuevoValor);
    String buscarPorId(int id);
}
