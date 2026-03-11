package Modelo;

public class Expansion extends Media{
    private String fechaLanzamiento;

    public Expansion(String titulo, String creador, String genero, String fechaLanzamiento) {
        super(titulo, creador, genero);
        setFechaLanzamiento(fechaLanzamiento);
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        if (fechaLanzamiento==null){
            throw new IllegalArgumentException("La fecha de lanzamiento no puede ser nula");
        }
        this.fechaLanzamiento = fechaLanzamiento;
    }

    @Override
    public String toString() {
        return super.toString()+"Expansion{" +
                "fechaLanzamiento='" + fechaLanzamiento + '\'' +
                '}';
    }
}
