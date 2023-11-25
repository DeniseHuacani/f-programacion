/*
Laboratorio 20
Nombre Denise Andrea Huacani Jara
 */
package laboratorio20;
import java.util.*;
public class Caballero extends Soldado{
    
    private String armaActual; //espada y lanza
    private boolean montado;
    private int nivelVida;
    
    public Caballero(String n  , int fil, String colum ,int nAtaque, int nDefensa ){
        super(n,fil,colum,nAtaque, nDefensa);
        
        armaActual =elegirArma();
        montado =estaMontado();
        nivelVida= aleatorioNV();
    }
    
    public int aleatorioNV(){
        Random rand = new Random();
        return rand.nextInt(3)+3;
    }
    
    public String elegirArma(){
        Random rand = new Random();
        int n = rand.nextInt(2);
        if(n==0){
            return  "Lanza";
        }else
            return "Espada";
    }
    
    public boolean estaMontado(){
        Random rand = new Random();
        int n = rand.nextInt(2);
        if(n==0){
            return  true;
        }else
            return false;
    }
    
    public void desmontar(){
        if(montado){
            montado =false;
            armaActual ="Espada";
        }
    }
    
    public void montar(){
        if(!montado){
            montado =true;
            armaActual="Lanza";
            envestir();
        }
    }
    public void envestir(){
        if(montado){
            //atacar 3veces
        }else{
            //atacar 2 veces
        }
    }
    public int getNivelVida() {
        return nivelVida;
    }
    public String toString(){
        return  "\nNombre        : " + getNombre()+
                "\nNivel de Vida : " + getNivelVida()+
                "\nFila          : " + getFila()+
                "\nColumna       : " + getColumna()+
                "\nArma Actual   :"+armaActual+
                "\nMontado       :"+montado+
                "\n------------------------------------";
    }
}