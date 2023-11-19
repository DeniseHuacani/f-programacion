/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio19;

public class VideoJuego {
    public static void main(String [] args){
        Ejercitos ejer1 = new Ejercitos();
        Ejercitos ejer2 = new Ejercitos();
        
        ejer1.llenarEjercito(1, ejer2);
        System.out.println(ejer1.getNombre("Ejercito 1 : ", "ROJO")+ejer1.getCantidadSoldados());
        ejer2.llenarEjercito(2, ejer1);
        
        System.out.println(ejer1.getNombre("Ejercito 2 : ", "AZUL")+ejer2.getCantidadSoldados());
        ejer1.llenarTablero(ejer2);
        
        
        while(ejer1.getCantidadSoldados()>=1 && ejer2.getCantidadSoldados()>=1){
            
            System.out.println(" \nTURNO  =>  "+ejer1.getNombre("Ejercito 1 : ", "ROJO") +" :---------------------------------------");
            int ubicacion_Nuevo = ejer1.juegoEjercito(ejer2, 1);
            
            if(ejer2.hayPelea(ubicacion_Nuevo)){
                System.out.println("\n ---------Batalla---------");
                ejer1.batallaSoldado(ejer2,ubicacion_Nuevo);
            }
            ejer1.llenarTablero(ejer2);
            
            if (ejer1.getCantidadSoldados()==0) {
                System.out.println("GANADOR : EJERCITO 2 \n");
            } else if (ejer2.getCantidadSoldados()==0) {
                System.out.println("GANADOR : EJERCITO 1 \n");
            }
            
            System.out.println(" \nTURNO  =>  "+ejer1.getNombre("Ejercito 2 : ", "AZUL")+" :---------------------------------------");
            int ubicacion_Nuevo2 =ejer2.juegoEjercito(ejer1, 2);
            
            if(ejer1.hayPelea(ubicacion_Nuevo2)){
                System.out.println("\n ---------Batalla---------");
                ejer1.batallaSoldado(ejer2,ubicacion_Nuevo2);
            }
            ejer1.llenarTablero(ejer2);
            if (ejer1.getCantidadSoldados()==0) {
                System.out.println("GANADOR : EJERCITO 2 \n");
            } else if (ejer2.getCantidadSoldados()==0) {
                System.out.println("GANADOR : EJERCITO 1 \n");
            }
        }
        
    }
}