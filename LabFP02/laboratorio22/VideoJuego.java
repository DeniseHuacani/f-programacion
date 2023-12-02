/*
Laboratorio 22
ombre :Denise Andrea Huacani Jara
 */
package laboratorio22;


import java.util.*;
public class VideoJuego {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        
        String respuesta;
        do{
            Mapa mapa = new Mapa();
            mapa.asignarNombreReinos();
            mapa.elegirTerritorio();
            mapa.llenarReino();
            System.out.println(mapa.getNombreReino1()+" -->"+mapa.getCantidadSoldadoReino1());
            System.out.println(mapa.getNombreReino2()+" -->"+mapa.getCantidadSoldadoReino2());
            System.out.println("\n\t\t*********"+mapa.getTerritorio()+"*********\n");
            mapa.bonus();
            mapa.llenarTablero();
            //mapa.mostrarSoldados();
            mapa.juego();
            
            
            System.out.println("Desea volver a jugar(S/N)??");
            respuesta =sc.next();
        }while(respuesta.equals("S"));
        System.out.println("SALIENDO DEL JUEGO----->");   
        
        
        
    }
    
}
