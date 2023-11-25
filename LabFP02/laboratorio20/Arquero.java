/*
Laboratorio 20
Nombre Denise Andrea Huacani Jara
 */
package laboratorio20;

import java.util.*;
public class Arquero extends Soldado{
    private int numeroFlechas;
    private int nivelVida;
    
    public Arquero(String n  , int fil, String colum ,int nAtaque, int nDefensa ){
        super(n,fil,colum,nAtaque, nDefensa);
        numeroFlechas=cantidadArmas();
        nivelVida= aleatorioNV();
    }
    public int aleatorioNV(){
        Random rand = new Random();
        return rand.nextInt(3)+1;
    }
    
    public int cantidadArmas(){
        Random rand = new Random();
        return rand.nextInt(6);
        
    }
    public void disparar(){
        
    }
    public int getNivelVida() {
        return nivelVida;
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
