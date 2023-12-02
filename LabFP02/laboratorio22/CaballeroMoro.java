/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio22;

public class CaballeroMoro extends Caballero implements Especial{
    
    public CaballeroMoro(String n, int fil, String colum) {
        super(n, fil, colum);
        setNivelVida(13);
    }
    public void lanzar() {
        System.out.println("Lanzando flechas...");
    }
    public String toString(){
        return  "\nNombre        : " + getNombre()+
                "\nNivel de Vida : " + getNivelVida()+
                "\nFila          : " + getFila()+
                "\nColumna       : " + getColumna()+
                "\n------------------------------------";
    }
    
}
