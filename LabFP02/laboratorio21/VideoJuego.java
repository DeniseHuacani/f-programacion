/*
Laboratorio 21 
Nombre Denise Andrea Huacani jara
 */
package laboratorio21;

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
            
            mapa.mayorNV();

            mapa.promedioNVTodos();

            mapa.ordenarCreadosPorNombre();

            mapa.ordenarPorNV();
            
            System.out.println(mapa.toString());
            
            Random rand = new Random();
            int num = rand.nextInt(100)+1;
            int vida1 = mapa.getReino1().obtenerSumaNV();
            int vida2 = mapa.getReino2().obtenerSumaNV();
            double cantidad = vida1+vida2;
            double probabilidad= vida1*100/cantidad;
            double factor = Math.pow(10, 1);//1 es el numero de decimales
            probabilidad = Math.round(probabilidad * factor) / factor;
            
            System.out.println("\nEjercito 1 :"+mapa.getNombreReino1()+"  "+vida1+" \t\t"
                    +probabilidad+"% de probabilidad de victoria");
            System.out.println("Ejercito 2 :"+mapa.getNombreReino2()+"  "+vida2+" \t\t"
                    +(100- probabilidad)+"% de probabilidad de victoria");
            
            if(num<=probabilidad){
                System.out.println("Gano el Ejercito 1 : "+mapa.getNombreReino1() );
            }else{
                System.out.println("Gano el Ejercito 2 : "+mapa.getNombreReino2());
            }
            System.out.println("Ya que al generar losporcentajes de probabilidad de victoria basada \n"
                    + "en los niveles de vida de sus soldados y aplicando\n"
                    + "un experimento aleatorio salió vencedor. ");
            System.out.println("(Aleatorio generado:"+num+")");
            
            
            System.out.println("Desea volver a jugar(S/N)??");
            respuesta =sc.next();
        }while(respuesta.equals("S"));
        System.out.println("SALIENDO DEL JUEGO----->");   
        
        
        
    }
}
