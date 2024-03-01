import java.util.ArrayList;
import java.util.LinkedList;

public class album {
    private String nombre;

    private String artista;

    private ArrayList<cancion> canciones = new ArrayList<cancion>();

    public album(String nombre,String artista){
        this.artista = artista;
        this.nombre = nombre;
    }

    private cancion finsong(String titulo){
        for(int i = 0;i < canciones.size();i++){
            if(canciones.get(i).getTitulo().equalsIgnoreCase(titulo)){
                return canciones.get(i);
            }
        }
        return null;
    }

    public boolean addSong(String titulo,double duracion){
        if(finsong(titulo) == null){
            cancion x = new cancion(titulo,duracion);
            canciones.add(x);
            return true;
        }
        return false;
    }

    public boolean AddToPlayList(int i, LinkedList<cancion> tracklist){
        for(int x = 0;x < tracklist.size();x++) {
            if (canciones.get(i).getTitulo().equalsIgnoreCase(tracklist.get(x).getTitulo())){
                return false;
            }
        }
        tracklist.add(canciones.get(i));
        return true;
    }

    public boolean AddToPlayList(String titulo, LinkedList<cancion> tracklist){
        for(int i = 0;i < tracklist.size();i++) {
            if (canciones.get(i).getTitulo().equalsIgnoreCase(titulo)){
                return false;
            }
        }
        tracklist.add(finsong(titulo));
        return true;
    }


}
