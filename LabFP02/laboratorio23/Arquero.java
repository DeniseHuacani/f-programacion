/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio23;

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
        //nivelVida= aleatorioNV();
        
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
    
    public String toString(){
        return  "\nNombre        : " + getNombre()+
                "\nNivel de Vida : " + getNivelVida()+
                "\nFila          : " + getFila()+
                "\nColumna       : " + getColumna()+
                "\nNumero de flechas :"+numeroFlechas+
                "\n------------------------------------";
    }
    
}
