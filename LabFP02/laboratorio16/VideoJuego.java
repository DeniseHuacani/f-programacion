/*
Laboratorio 16
Nombre : Huacani Jara Denise Andrea
 */
package laboratorio16;
import java.util.*;
public class VideoJuego {
    public static void main(String[] args){
        Mapa mapa = new Mapa();
        mapa.elegirTerritorio();
        ArrayList<Ejercito> reino1 = new ArrayList<>();
        ArrayList<Ejercito> reino2 = new ArrayList<>();
        mapa.asignarNombreReinos();
        
        Mapa.ingresarEjercitos(reino1, reino2);
        int cantReino1 =mapa.getCantidadEjercitos();
        System.out.println("Reino (#) : "+mapa.getNombreReino1()+" => "+ cantReino1);
        
        Mapa.ingresarEjercitos(reino2, reino1);
        int cantReino2 =mapa.getCantidadEjercitos();
        System.out.println("Reino (&) : "+mapa.getNombreReino2()+" => "+ cantReino2);
        
        mapa.getCantidadEjercitos();
        System.out.println("\n\t\t\t*********"+mapa.getTerritorio()+"*********\n");
        
        Mapa.llenarTablero(reino1, reino2);
        Mapa.bonus(reino1, reino2);
        Mapa.llenarTablero(reino1, reino2);
        
        
        
    }
}
