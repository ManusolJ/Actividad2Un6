import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<album> albumlist = new ArrayList<album>();

        album al1 = new album("Album 1","Artista 1");
        album al2 = new album("Album 2","Artista 2");

        LinkedList<cancion> tracklist = new LinkedList<cancion>();

        al1.addSong("Song 1",1);
        al1.addSong("Song 2",2);
        al1.addSong("Song 3",3);
        al1.addSong("Song 4",4);

        al1.AddToPlayList(0,tracklist);
        al1.AddToPlayList(1,tracklist);
        al1.AddToPlayList("Song 3",tracklist);
        al1.AddToPlayList("Song 4",tracklist);

        printmenu();
        play(tracklist);
    }

    public static void printPlayList(LinkedList<cancion> tracklist){
        Iterator<cancion> it = tracklist.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("---------------");
    }

    public static void printmenu(){
        System.out.println("0 - Salir de la lista de reproducción.");
        System.out.println("1 - Reproducir siguiente canción en la lista.");
        System.out.println("2 - Reproducir la canción previa de la lista.");
        System.out.println("3 - Repetir la canción actual.");
        System.out.println("4 - Imprimir la lista de canciones en la playlist.");
        System.out.println("5 - Volver a imprimir el menú.");
        System.out.println("6 - Eliminar cancion actual.");
    }

    public static void play(LinkedList<cancion> tracklist){
       ListIterator<cancion> it = tracklist.listIterator();
        Scanner sc = new Scanner(System.in);
        boolean keep = true;
        int opcion;
        do{
            System.out.println("Elige una opcion.");
            opcion = sc.nextInt();
            switch (opcion) {
                case 0:
                    keep = false;
                    break;
                case 1:
                    if(!it.hasNext()) {
                        System.out.println("Ultimo puesto de la lista alcanzado!Volviendo al principio.");
                        it = tracklist.listIterator();
                        System.out.println(it.next());
                    }else{
                        System.out.println(it.next());
                    }
                    break;
                case 2:
                    if(!it.hasPrevious()){
                        System.out.println("Primer puesto de la lista alcanzado!Volviendo al final.");
                        it = tracklist.listIterator(tracklist.size());
                        System.out.println(it.previous());
                    }else{
                        System.out.println(it.previous());
                    }
                    break;
                case 3:
                    if(!it.hasPrevious()){
                        it.next();
                    }
                    it.previous();
                    System.out.println(it.next());
                    break;
                case 4:
                    printPlayList(tracklist);
                    break;
                case 5:
                    printmenu();
                    break;
                case 6:
                    it.remove();
                    if(it.hasNext()){
                        System.out.println(it.next());
                    }else{
                        System.out.println(it.previous());
                    }
            }
        }while(keep);
    }
}