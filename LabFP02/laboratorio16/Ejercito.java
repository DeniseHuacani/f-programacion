/*
Laboratorio 16
Nombre : Huacani Jara Denise Andrea
 */
package laboratorio16;

import java.util.*;
public class Ejercito {

    private ArrayList<Soldado>  misSoldados = new ArrayList<Soldado>();
    public static final int MAX_SOLDADOS_EJERCITO = 10;
    private int cantidadSoldados;
    private int fila;
    private int columna;
    
    public Ejercito(int fi, int co){
        fila = fi;
        columna = co;
    }
    
    public int obtenerSumaNV() {
        int sumaNV = 0;
        for (Soldado soldado : misSoldados) {
            sumaNV += soldado.getNivelVida();
        }
        return sumaNV;
    }
    
    public void llenarEjercito(){
        Random random = new Random();
        int nu = random.nextInt(10)+1;
        for(int i =0; i<nu; i++){
            agregarSoldadoAutogenerado( );
        }
    }
    public  void agregarSoldadoAutogenerado( ) {
        Random random = new Random();
        if (misSoldados.size() < MAX_SOLDADOS_EJERCITO) {
            
            int nivelVida = (random.nextInt(5)+1); 
            Soldado nuevoSoldado = new Soldado( nivelVida);
            misSoldados.add( nuevoSoldado);
            
        }else {
            System.out.println("El ejército está lleno. No se pueden agregar más soldados.");
        }
        cantidadSoldados++;
    }
    public  void aumentarNV( ) {
        for (Soldado soldado : misSoldados) {
            int nv = soldado.getNivelVida();
            soldado.setNivelVida(nv+1);
        }
            
    }
    public int getFila() {
        return fila;
    }
    
    public int getColumna() {
        return columna;
    }
    
    public int getCantidadSoldados() {
        return cantidadSoldados;
    }
    
}
