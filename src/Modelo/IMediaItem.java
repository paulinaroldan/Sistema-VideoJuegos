package Modelo;

public interface IMediaItem {
    String getTitulo();
    String getCreador();
    String getGenero();
    int getId();
    void setTitulo(String titulo);
    void setCreador(String creador);
    void setGenero(String genero);
    void setId(int id);

}
