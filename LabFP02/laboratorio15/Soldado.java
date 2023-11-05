/*
Laboraorio 15
Nombre : Denise Huacani Jara
 */
package laboratorio15;

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
    private static int cantidadSoldadosTotal=0;//soldados en total
    public static final int MAX_SOLDADOS_EJERCITO = 5;
    // Constructor
    public Soldado ( int fila , int columna){
        this.fila = fila;
        this.columna = columna;
        cantidadSoldadosTotal++;
    }
    public Soldado(String nombre, int nivelVida, int nivelAtaque, int nivelDefensa,int nivelActual , int fila ,int  columna, String act) {
        this.nombre = nombre;
        //this.nombreEjercito = nombreEjercito;
        this.nivelVida = nivelVida;
        this.nivelAtaque = nivelAtaque;
        this.nivelDefensa = nivelDefensa;
        this.vidaActual =nivelActual;
        this.vidaActual = nivelVida;
        this.velocidad = 0;
        this.actitud = act;
        this.vive = true;
        this.fila = fila;
        this.columna = columna;
        cantidadSoldadosTotal++;
    }
    public Soldado(int n, int m , int l){ //cambiar el nivel de vida 
        this.nivelVida = n;
        this.nivelAtaque = m;
        this.nivelDefensa = l;
    }
    public Soldado sumar(Soldado sol2) {
        int numerovida = this.nivelVida +sol2.nivelVida;
        int numeroataque = this.nivelAtaque +sol2.nivelAtaque;
        int numerodefensa= this.nivelDefensa +sol2.nivelDefensa;
        return new Soldado(numerovida,numeroataque,numerodefensa);
    }
    public boolean equals(Soldado otro){
        if(otro==null){
            return false;
        }
        return (nivelVida == otro.nivelVida && 
                nivelAtaque == otro.nivelAtaque &&
                nivelDefensa == otro.nivelDefensa);
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
        this.vidaActual = nivelVida;
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

    public void setNivelAtaque(int nivelAtaque) {
        this.nivelAtaque = nivelAtaque;
    }
    public void setNivelDefensa(int nivelDefensa) {
        this.nivelDefensa = nivelDefensa;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public static int getCantidadSoldadosTotal() {
        return cantidadSoldadosTotal;
    }
    
    public String toString() {
        return "Nombre: " + nombre +
               "\nNivel de Vida: " + nivelVida +
               "\nNivel de Ataque: " + nivelAtaque +
               "\nNivel de Defensa: " + nivelDefensa +
               "\nVida Actual: " + vidaActual +
               "\nFila: " + fila +
               "\nColumna: " + columna +
               "\nActitud: " + actitud +
               "\nEstado: " + (vive ? "Vivo" : "Muerto");
    }
}
