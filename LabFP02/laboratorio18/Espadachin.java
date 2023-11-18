/*
Laboratorio 18 
Nombre : Huacani Jara Denise Andrea
 */
package laboratorio18;

import java.util.*;
public class Espadachin extends Soldado{
    private int longitudEspada;
    private int nivelVida;
    public Espadachin(String n , int nvida , int fil, String colum ,int nAtaque, int nDefensa,  int lon){
        super(n,nvida,fil,colum,nAtaque, nDefensa);
        nivelVida= aleatorioNV();
        longitudEspada=lon;
    }
    public int aleatorioNV(){
        Random rand = new Random();
        return rand.nextInt(2)+3;
    }
    public void crearMuroEscudos(){  //defensa
        
    }
    public int getNivelVida() {
        return nivelVida;
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
