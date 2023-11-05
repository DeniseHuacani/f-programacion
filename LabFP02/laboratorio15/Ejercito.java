/*
Laboraorio 15
Nombre : Denise Huacani Jara
 */
package laboratorio15;

import java.util.*;

public class Ejercito {
    private String reino;
    private ArrayList<Soldado>  misSoldados = new ArrayList<Soldado>();
    public static final int MAX_SOLDADOS_EJERCITO = 10;
    private int cantidadSoldados;
    
    public Ejercito(String re) {
        reino = re;
        this.misSoldados = new ArrayList<>();
    }
    public Soldado getSoldado(int indice) {
        if (indice >= 0 && indice < misSoldados.size()) {
            return misSoldados.get(indice);
        } else {
            return null; 
        }
    }
    public void agregarSoldadoManualmente( int numero) {
        Scanner sc = new Scanner(System.in);
        
        if (misSoldados.size() < MAX_SOLDADOS_EJERCITO) {
            System.out.print("\nNombre: ");
            String nombre = ("Soldado "+(misSoldados.size()+1)+"X"+numero);
            System.out.print(nombre+"\n");
            System.out.print("Nivel Vida (1-5): ");
            int nivelVida = sc.nextInt();

            System.out.print("Nivel Ataque (1-5): ");
            int nivelAtaque = sc.nextInt();

            System.out.print("Nivel Defensa (1-5): ");
            int nivelDefensa= sc.nextInt();
            
            String actitud = "";
            int opcion;
            do{
                
                System.out.println("Elige la actitud");
                System.out.println("1. defensiva");
                System.out.println("2. ofensiva");
                System.out.println("3. fuga");
                System.out.print("Seleccione una opción: ");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        actitud = "defensiva";
                        break;
                    case 2:
                        actitud = "ofensiva";
                        break;
                    case 3:
                        actitud = "fuga";
                        break;
                }
            }while(1 < opcion || opcion > 3);
            
            System.out.print("Fila: ");
            int fila= sc.nextInt()-1;
            System.out.print("Columna: ");
            String letra= sc.next();
            int columna = Character.toUpperCase(letra.charAt(0)) - 'A';//Si es A seria 0
            
            if (posicionOcupada(fila, columna)) {
                System.out.println("Ya hay un soldado en esa posición. Por favor, elige otra posición.");
            } else {
                Soldado nuevoSoldado = new Soldado(nombre, nivelVida, nivelAtaque,nivelDefensa, nivelVida, fila, columna, actitud);
                misSoldados.add(nuevoSoldado);
                System.out.println("Soldado agregado correctamente.");
            }
        } else {
            System.out.println("El ejército está lleno. No se pueden agregar más soldados.");
        }
        cantidadSoldados++;
    }
    public boolean posicionOcupada(int fila, int columna) {
        for (Soldado soldado : misSoldados) {
            if (soldado.getFila() == fila && soldado.getColumna() == columna) {
                return true;
            }
        }
        return false;
    }
    public  void agregarSoldadoAutogenerado( int numero) {
        Random random = new Random();
        if (misSoldados.size() < MAX_SOLDADOS_EJERCITO) {
            int fila;
            int colum;
            do{
                fila  = random.nextInt(10);//del 0 al 9
                colum = random.nextInt(10);
                
            }while(posicionOcupada(fila, colum));
            
            String actitud ="";
            int num_actitud =random.nextInt(3);
            if(num_actitud ==0){
                actitud ="defensiva";
            }else if ( num_actitud ==1){
                actitud = "Ofensiva";
            }else if ( num_actitud ==2){
                actitud = "Fuga";
            }String nombre = ("Soldado"+misSoldados.size()+"X"+numero);
            int nivelVida = (random.nextInt(5)+1); 
            int nivelAtaque = (random.nextInt(5)+1);
            int nivelDefensa= (random.nextInt(5)+1);
            Soldado nuevoSoldado = new Soldado(nombre, nivelVida, nivelAtaque,
                    nivelDefensa,nivelVida, fila,colum,actitud);
            misSoldados.add( nuevoSoldado);
            
        }else {
            System.out.println("El ejército está lleno. No se pueden agregar más soldados.");
        }
        cantidadSoldados++;
    }
    //gets y sets
     public String getReino() {
        return reino;
    }

    public void setReino(String reino) {
        this.reino = reino;
    }

    public ArrayList<Soldado> getMisSoldados() {
        return misSoldados;
    }

    public void setMisSoldados(ArrayList<Soldado> misSoldados) {
        this.misSoldados = misSoldados;
    }

    public int getCantidadSoldados() {
        return cantidadSoldados;
    }

    public void setCantidadSoldados(int cantidadSoldados) {
        this.cantidadSoldados = cantidadSoldados;
    }
    
    
    public String toString() {
        String result = "";
        for (Soldado soldado : misSoldados) {
            result += soldado.toString() + "\n\n";
            
        }
        return result;
    }
   
}
