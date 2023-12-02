/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio22;

import java.util.*;
public class Lancero extends Soldado{
    private int longLanza;
    private int nivelVida;
    
    public Lancero(String n  , int fil, String colum  ){
        super(n,fil,colum);
        setNivelAtaque(5);
        setNivelDefensa(10);
        setVidaActual(nivelVida);
        Random rand = new Random();
        longLanza =rand.nextInt(5)+1;
        //nivelVida = aleatorioNV();
    }
    public void schiltrom(){
        int vida = getNivelDefensa();
        setNivelDefensa(vida+1);
    }
    public int aleatorioNV(){
        Random rand = new Random();
        return rand.nextInt(4)+5;
    }
    
     
    public String toString(){
        return  "\nNombre        : " + getNombre()+
                "\nNivel de Vida : " + getNivelVida()+
                "\nFila          : " + getFila()+
                "\nColumna       : " + getColumna()+
                "\nLongitud de lanza :"+longLanza+
                "\n------------------------------------";
    }
}
