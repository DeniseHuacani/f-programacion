/*
Laboratorio 21 
Nombre Denise Andrea Huacani jara
 */
package laboratorio21;

import java.util.*;
public class Arquero extends Soldado{
    private int numeroFlechas;
    private int nivelVida;
    
    
    public Arquero(String n  , int fil, String colum ){
        super(n,fil,colum);
        setNivelAtaque(7);
        setNivelDefensa(3);
        setVidaActual(nivelVida);
        numeroFlechas=cantidadArmas();
        nivelVida= aleatorioNV();
        
    }
    public int aleatorioNV(){
        Random rand = new Random();
        return rand.nextInt(3)+3;
    }
    
    public int cantidadArmas(){
        Random rand = new Random();
        return rand.nextInt(10);
        
    }
    public void disparar(){
        
    }
    public int getNivelVida() {
        return nivelVida;
    }
    public void setNivelVida(int nivelVida) {
        this.nivelVida = nivelVida;
    }
    public String toString(){
        return  "\nNombre        : " + getNombre()+
                "\nNivel de Vida : " + getNivelVida()+
                "\nFila          : " + getFila()+
                "\nColumna       : " + getColumna()+
                "\nNumero de flechas :"+numeroFlechas+
                "\n------------------------------------";
    }
    
}
