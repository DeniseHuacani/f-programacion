/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio22;

public class CaballeroFranco extends Caballero implements Especial{
    
    public CaballeroFranco(String n, int fil, String colum) {
        super(n, fil, colum);
        setNivelVida(15);
    }
    public void lanzar() {
        System.out.println("Lanzando lanzas...");
    }
    public String toString(){
        return  "\nNombre        : " + getNombre()+
                "\nNivel de Vida : " + getNivelVida()+
                "\nFila          : " + getFila()+
                "\nColumna       : " + getColumna()+
                "\n------------------------------------";
    }
    
}
