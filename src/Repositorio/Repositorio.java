package Repositorio;

import Excepcion.IdentificadorDuplicadoEx;
import Modelo.Expansion;
import Modelo.IMediaItem;
import Modelo.Juego;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Repositorio implements IRepositorio<IMediaItem> {
     private ArrayList<IMediaItem> lista;

    public Repositorio() {
        this.lista = new ArrayList<>();
    }


    @Override
    public void agregar(IMediaItem elemento) throws IdentificadorDuplicadoEx {
        for (IMediaItem i : this.lista) {
            if (i.getId()==elemento.getId()) {
            throw new IdentificadorDuplicadoEx("Ya existe un elemento con el mismo identificador");
        }
    }
        lista.add(elemento);
    }

    @Override
    public boolean eliminar(int id) {
        boolean encontrado = false;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                lista.remove(i);
                encontrado = true;
            }
        }
        return encontrado;
    }

    @Override
    public List<IMediaItem> buscarPorGenero(String genero) {
        List<IMediaItem> resultado = new ArrayList<>();
        for(IMediaItem elemento: lista){
            if(elemento.getGenero().equalsIgnoreCase(genero)){
                resultado.add(elemento);
            }
        }
        return resultado;
    }

    @Override
    public String mostrar() {
        String rta="";
        for (IMediaItem elemento : lista) {
            rta+=elemento.toString()+"\n";
        }
        return rta;
    }

    @Override
    public String modificar(int id, int valor, String nuevoValor) {
        String rta="";
        boolean encontrado = false;
        for (IMediaItem elemento : lista) {
            if (elemento.getId() == id) {
                switch (valor) {
                    case 1:
                        elemento.setTitulo(nuevoValor);
                        rta="Se modifico el titulo";
                        break;
                    case 2:
                        elemento.setGenero(nuevoValor);
                        rta="Se modifico el genero";
                        break;
                        case  3:
                        elemento.setCreador(nuevoValor);
                        rta="Se modifico el creador";
                        break;
                        case  4:
                            if (elemento instanceof Juego) {
                                try {
                                    int version=Integer.parseInt(nuevoValor);
                                    ((Juego) elemento).setNumVersion(version);
                                    rta="Se modifico el numero de version";
                                }catch (NumberFormatException e){
                                    throw new IllegalArgumentException("La version debe ser un numero");
                                }

                            }
                            break;
                            case 5:
                                if(elemento instanceof Expansion){
                                    ((Expansion) elemento).setFechaLanzamiento(nuevoValor);
                                    rta="Se modifico la fecha de lanzamiento";
                                }
                                break;
                    default:
                            rta="Opcion invalida";
                            break;
                }
            }
        }
        return rta;
    }

    @Override
    public String buscarPorId(int id) {
        String rta="";
        boolean encontrado = false;
        for (IMediaItem elemento : lista) {
            if(elemento.getId()==id){
                rta=elemento.toString();
                encontrado=true;
            }
        }
        if(!encontrado){
            rta="No se encontro el id buscado";
        }
        return rta;
    }
}
