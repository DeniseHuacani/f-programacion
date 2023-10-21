/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio11;
public class Soldado {
    private String nombre;
    private int nivelVida;
    private int fila;
    private int columna;
    private int nivelAtaque;
    private int nivelDefensa;
    private int vidaActual;
    private int velocidad;
    private String actitud;

    private boolean vive;

    // Constructor
    public Soldado(String nombre, int nivelVida, int nivelAtaque, int nivelDefensa, int fila ,int  columna, String act) {
        this.nombre = nombre;
        this.nivelVida = nivelVida;
        this.nivelAtaque = nivelAtaque;
        this.nivelDefensa = nivelDefensa;
        this.vidaActual = nivelVida;
        this.velocidad = 0;
        this.actitud = act;
        this.vive = true;
        this.fila = fila;
        this.columna = columna;
        
    }
    public void atacar() {
        avanzar();
    }

    public void defender() {
        velocidad =0;
    }

    public void avanzar() {
        velocidad++;
    }

    public void retroceder() {
        if(velocidad>0){
            defender();
        }else if (velocidad ==0){
            velocidad-=2;
        }
    }

    public void serAtacado() {
        
        nivelVida--;
        if (nivelVida<=0){
            morir();
        }
    }

    public void huir() {
        velocidad+=2;
    }

    public void morir() {
        System.out.println(nombre+ " esta muerto");
        vive = false;
    }

    
    // Getters y setters
    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }

    public int getVidaActual() {
        return vidaActual;
    }
    
    public String getNombre() {
        return nombre;
    }
    public int getNivelVida() {
        return nivelVida;
    }
    public int getFila() {
        return fila;
    }
    public int getColumna() {
        return columna;
    }
    public int getNivelAtaque() {
        return nivelAtaque;
    }
    public int getNivelDefensa() {
        return nivelDefensa;
    }
    public String getActitud() {
        return actitud;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setNivelVida(int nivelVida) {
        this.nivelVida = nivelVida;
    }
    

}
