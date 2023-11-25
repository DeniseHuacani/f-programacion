/*
Laboratorio 21 
Nombre Denise Andrea Huacani jara
 */
package laboratorio21;

import java.util.*;
public class Espadachin extends Soldado{
    private int longitudEspada;
    private int nivelVida;
    public Espadachin(String n  , int fil, String colum ,  int lon){
        super(n,fil,colum);
        setNivelAtaque(10);
        setNivelDefensa(8);
        setVidaActual(nivelVida);
        nivelVida= aleatorioNV();
        longitudEspada=lon;
    }
    public int aleatorioNV(){
        Random rand = new Random();
        return rand.nextInt(3)+8;
    }
    public void crearMuroEscudos(){  //defensa
        
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
                "\nLongitud de espada :"+longitudEspada+
                "\n------------------------------------";
    }
}
