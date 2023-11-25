/*
Laboratorio 21 
Nombre Denise Andrea Huacani jara
 */
package laboratorio21;

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
        nivelVida = aleatorioNV();
    }
    public void schiltrom(){
        int vida = getNivelDefensa();
        setNivelDefensa(vida+1);
    }
    public int aleatorioNV(){
        Random rand = new Random();
        return rand.nextInt(4)+5;
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
                "\nLongitud de lanza :"+longLanza+
                "\n------------------------------------";
    }
}
