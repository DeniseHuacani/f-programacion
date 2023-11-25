/*
Laboratorio 20
Nombre Denise Andrea Huacani Jara
 */
package laboratorio20;
import java.util.*;
public class Lancero extends Soldado{
    private int longLanza;
    private int nivelVida;
    
    public Lancero(String n  , int fil, String colum ,int nAtaque, int nDefensa ){
        super(n,fil,colum,nAtaque, nDefensa);
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
        return rand.nextInt(2)+1;
    }
     public int getNivelVida() {
        return nivelVida;
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
