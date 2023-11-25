/*
Laboratorio 20
Nombre Denise Andrea Huacani Jara
 */
package laboratorio20;
import java.util.*;
public class VideoJuego {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        
        
        String respuesta;
        do{
            Ejercitos ejer1 = new Ejercitos();
            Ejercitos ejer2 = new Ejercitos();
            ejer1.llenarEjercito(1, ejer2);
            System.out.println(Ejercitos.getNombre("Ejercito 1 : ", "ROJO")+ejer1.getCantidadSoldados());

            ejer2.llenarEjercito(2, ejer1);
            System.out.println(Ejercitos.getNombre("Ejercito 2 : ", "AZUL")+ejer2.getCantidadSoldados());
            ejer1.llenarTablero(ejer2);

            System.out.println("--------------"+Ejercitos.getNombre("Ejercito 1 :Mostrar Soldados ", "ROJO")+"-----------------");
            ejer1.mostrarSoldados();
            System.out.println("--------------"+Ejercitos.getNombre("Ejercito 2 :Mostrar Soldados", "AZUL")+"-----------------");
            ejer2.mostrarSoldados();

            
            System.out.println("--------------Ejercito 1:Mayor nivel de vida---------------");
            ejer1.mayorNV();
            System.out.println("--------------Ejercito 2:Mayor nivel de vida---------------");
            ejer2.mayorNV();

            System.out.println("--------------Ejercito 1:Promedio de nivel de vida----------");
            System.out.println(ejer1.promedioNVTodos());
            System.out.println("--------------Ejercito 2:Promedio de nivel de vida----------");
            System.out.println(ejer2.promedioNVTodos());

            System.out.println("--------------Ejercito 1:Soldado Ordenados por Nombre----------");
            ejer1.ordenarCreadosNombre();
            System.out.println("--------------Ejercito 2:Soldado Ordenados por Nombre----------");
            ejer2.ordenarCreadosNombre();

            System.out.println("--------------Ejercito 1:Soldado Ordenados por Nivel Vida----------");
            ejer1.ordenarEjercitoPorNivelVidaBurbuja();
            System.out.println("--------------Ejercito 2:Soldado Ordenados por Nivel Vida----------");
            ejer2.ordenarEjercitoPorNivelVidaBurbuja();

            ejer1.seleccionarGanador(ejer2);
            System.out.println("Desea volver a jugar(S/N)??");
            respuesta =sc.next();
        }while(respuesta.equals("S"));
        System.out.println("SALIENDO DEL JUEGO----->");   
    }
}
