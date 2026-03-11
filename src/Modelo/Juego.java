package Modelo;

public class Juego extends Media {
    private int numVersion;

    public Juego(String titulo, String creador, String genero, int numVersion) {
        super(titulo, creador, genero);
        setNumVersion(numVersion); //para validar
    }

    public void setNumVersion(int numVersion) {
        if (numVersion<0){
            throw new IllegalArgumentException("el numero de version debe ser mayor a 0");
        }
        this.numVersion = numVersion;
    }

    @Override
    public String toString() {
        return super.toString()+"Juego{" +
                "numVersion=" + numVersion +
                '}';
    }
}
