package Modelo;

public abstract class Media implements IMediaItem, Comparable<Media>{
    private static int cont=1;
    private int id;
    private String titulo;
    private String creador;
    private String genero;

    public Media(String titulo, String creador, String genero) {
        this.id = cont++;
        this.titulo = titulo;
        this.creador = creador;
        this.genero = genero;
    }

    @Override
    public String getTitulo() {
        return this.titulo;
    }

    @Override
    public String getCreador() {
        return this.creador;
    }

    @Override
    public String getGenero() {
        return this.genero;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public void setCreador(String creador) {
        this.creador = creador;
    }

    @Override
    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Media otra) {
        return Integer.compare(this.id, otra.id);
    }

    @Override
    public String toString() {
        return "Media{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", creador='" + creador + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
