public class cancion {
    private String titulo;

    private double duracion;

    public cancion(String titulo,double duracion){
        this.duracion = duracion;
        this.titulo = titulo;
    }

    public String getTitulo(){
        return titulo;
    }

    @Override
    public String toString() {
        return titulo + " " + duracion;
    }
}
