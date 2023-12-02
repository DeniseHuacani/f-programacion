/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio22;


public abstract class Soldado {
    
    private String nombre;
    private int nivelVida;
    private int fila;
    private String columna;
    private int nivelAtaque;
    private int nivelDefensa;
    
    private int vidaActual;
    private int velocidad;
    private String actitud;
    private boolean vive;
    private static int cantidadSoldadosTotal=0;//soldados en total
    public static final int MAX_SOLDADOS_EJERCITO = 10;
    
    public Soldado(String n, int fil, String colum) {
        nombre=n;
        fila = fil;
        columna = colum;
        nivelVida= aleatorioNV();
    }
    
    
    public int getNivelVida() {
        return nivelVida;
    }
    public void setNivelVida(int nivelVida) {
        this.nivelVida = nivelVida;
    }
    public int getFila() {
        return fila;
    }
    
    public abstract int aleatorioNV();
    public String getColumna() {
        return columna;
    }
    public String getNombre() {
        return nombre;
    }
    public  int getNivelAtaque() {
        return nivelAtaque;
    }
    public int getNivelDefensa() {
        return nivelDefensa;
    }
    
    public void setFila(int fila) {
        this.fila = fila;
    }
    public void setColumna(String columna) {
        this.columna = columna;
    }
    public void setNivelDefensa(int nivelDefensa) {
        this.nivelDefensa = nivelDefensa;
    }
    public void setNivelAtaque(int nivelAtaque) {
        this.nivelAtaque = nivelAtaque;
    }
    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }
    
}