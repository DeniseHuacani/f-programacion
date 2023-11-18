/*
Laboratorio 18 
Nombre : Huacani Jara Denise Andrea
 */
package laboratorio18;
import java.util.*;
public class Arquero extends Soldado{
    private int numeroFlechas;
    private int nivelVida;
    
    public Arquero(String n , int nvida , int fil, String colum ,int nAtaque, int nDefensa ){
        super(n,nvida,fil,colum,nAtaque, nDefensa);
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
