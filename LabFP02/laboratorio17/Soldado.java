/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio17;

/**
 *
 * @author Toshiba
 */
public class Soldado {

    private String nombre;
    private int nivelVida;
    
    public Soldado( int nivelVida) {
        this.nivelVida = nivelVida;
    }

    public int getNivelVida() {
        return nivelVida;
    }

    public void setNivelVida(int nivelVida) {
        this.nivelVida = nivelVida;
    }
}
