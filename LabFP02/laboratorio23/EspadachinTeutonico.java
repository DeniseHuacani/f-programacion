/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio23;

public class EspadachinTeutonico extends Espadachin implements Especial{
   
    
    public EspadachinTeutonico(String n, int fil, String colum, int lon) {
        super(n, fil, colum, lon);
        setNivelVida(13);
    }

    public void lanzar() {
        System.out.println("Lanzando jabalinas...");
    }
    public String toString(){
        return  "\nNombre        : " + getNombre()+
                "\nNivel de Vida : " + getNivelVida()+
                "\nFila          : " + getFila()+
                "\nColumna       : " + getColumna()+
                "\n------------------------------------";
    }
}
