/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio06;
import java.util.*;
public class Videojuego3 {
    public static void main(String[] args){
        ArrayList<ArrayList<Soldado>> tablero = new ArrayList<ArrayList<Soldado>>();
        System.out.println("Equipo1 : @");
        ingresarDatosSoldados(tablero, 1);
        
        System.out.println("Equipo2 : $");
        ingresarDatosSoldados(tablero, 2);
        llenarTableroEquipo(tablero);
        System.out.println();
        mostrarMayorNV(tablero);
        
        promedioNVTodos(tablero);
        System.out.println("--------------------------------------------------------");
        System.out.println("Datos ordenados del Equipo 1 ");
        ordenarCreadosNombre(tablero,1);
        System.out.println("--------------------------------------------------------");
        System.out.println("Datos ordenados del Equipo 2 ");
        ordenarCreadosNombre(tablero,2);
        System.out.println("--------------------------------------------------------");
        ordenarPuntosBurbuja( tablero);
        System.out.println("--------------------------------------------------------");
        ordenarPuntosSeleccion( tablero);
        System.out.println("--------------------------------------------------------");
        ganadorGuerra(tablero);
        
        
    }
    public static  int random (int num){
        Random random = new Random ();
        return random.nextInt(num)+1;
    }
    public static void ingresarDatosSoldados(ArrayList<ArrayList<Soldado>> tablero,int n) {
        int cant =random (10);
        System.out.println("Se creo "+cant+" soldados");
        for (int i = 0; i < 10; i++) {
            tablero.add(new ArrayList<Soldado>());
            for (int j = 0; j < 10; j++) {
                tablero.get(i).add(null); // Inicializa las celdas como null (sin Soldado)
            }
        }
        for ( int i =0; i < cant; i++){
            int fila  = random(10);
            int colum = random(10);
            while(tablero.get(fila-1).get(colum-1)!= null){
                fila  = random(10);
                colum = random(10);
            }
            tablero.get(fila-1).set(colum-1,new Soldado());
            tablero.get(fila-1).get(colum-1).setNombre("Soldado"+i+"X"+n);
            tablero.get(fila-1).get(colum-1).setNivelVida(random(5));
            tablero.get(fila-1).get(colum-1).setFila(fila);
            tablero.get(fila-1).get(colum-1).setColumna(colum);
        }
    }
          
    public static void  llenarTableroEquipo(ArrayList<ArrayList<Soldado>> tablero ){
        String[][] array= new String[10][10];
        String[] opcionesFiguras ={"@","$"};
        
        System.out.println("    A  B  C  D  E  F  G  H  I  J");
        System.out.println("   ______________________________");
        
        for(int i =0; i<10; i++){
            if(i==9)
                System.out.print((i+1)+" ");
            else
                System.out.print((i+1)+"  ");
            for(int j =0; j<10; j++){
                if (tablero.get(i).get(j) != null) {
                    String nombre = tablero.get(i).get(j).getNombre();
                    char num = nombre.charAt(nombre.length()-1);
                    int imagen = Character.getNumericValue(num);
                    array[i][j] = "|"+opcionesFiguras[imagen-1]+" ";
                } else {
                    array[i][j] = "|  ";
                }
                System.out.print(array[i][j]);
            }
            System.out.print("|");
            System.out.println();
            System.out.println("   _______________________________");
        }
    }
    public static void mostrarMayorNV(ArrayList<ArrayList<Soldado>> tablero){
        
        int mayorEquipo1 =0;
        int mayorEquipo2 =0;
        for(int i =0; i<10 ; i++){
            
            for(int j =0; j<10 ; j++){
                if(tablero.get(i).get(j)!=null){
                    String nombre = tablero.get(i).get(j).getNombre();
                    char numerofinal = nombre.charAt(nombre.length()-1);
                    int numero = Character.getNumericValue(numerofinal);
                    
                    if(numero ==1){
                        int nivel =tablero.get(i).get(j).getNivelVida();
                        if(mayorEquipo1<nivel){
                            mayorEquipo1 = nivel;
                        }
                    }
                    else{
                        int nivel =tablero.get(i).get(j).getNivelVida();
                        if(mayorEquipo2<nivel){
                            mayorEquipo2 = nivel;
                        }
                    }
                    
                }
            }
        }
        System.out.println("--------------------------------------------------------");
        System.out.println("\nDatos del soldado con mayor nivel de vidadel Equipo 1 ");
        
        buscarSoldado(tablero,  mayorEquipo1,1);
        System.out.println("\nDatos del soldado con mayor nivel de vidadel Equipo 2 ");
        buscarSoldado(tablero,  mayorEquipo2,2);
    }
    public static int numeroEquipo(ArrayList<ArrayList<Soldado>> tablero, int i,int j){
        String nombre = tablero.get(i).get(j).getNombre();
        char numerofinal = nombre.charAt(nombre.length()-1);
        int numero = Character.getNumericValue(numerofinal);
        return numero;
    }
    
    public static void buscarSoldado(ArrayList<ArrayList<Soldado>> tablero, int mayor,int num){
        for(int i =0; i<10 ; i++){
            for(int j =0; j<10 ; j++){
                if(tablero.get(i).get(j) != null  ){
                    String nombre = tablero.get(i).get(j).getNombre();
                    char numerofinal = nombre.charAt(nombre.length()-1);
                    int numero = Character.getNumericValue(numerofinal);
                    if(num==numero && tablero.get(i).get(j).getNivelVida()==mayor){
                        System.out.println("Nombre: " +tablero.get(i).get(j).getNombre());
                        System.out.println("Nivel de Vida: " +tablero.get(i).get(j).getNivelVida());
                        System.out.println("Fila: " +tablero.get(i).get(j).getFila());
                        System.out.println("Columna: " + tablero.get(i).get(j).getColumna());
                        System.out.println("-----------");
                    }
                }
            }
        }
    }
    public static void promedioNVTodos(ArrayList<ArrayList<Soldado>> tablero){
        
        double suma =0;
        int cont =0;
        double suma2 =0;
        int cont2 =0;
        for(int i =0; i<10 ; i++){
            for(int j =0; j<10 ; j++){
                if(tablero.get(i).get(j)!=null){
                    int numero = numeroEquipo(tablero,  i, j);
                    if (numero ==1){
                        int nivel =tablero.get(i).get(j).getNivelVida();
                        suma+=nivel;
                        cont++;
                    }else{
                        int nivel =tablero.get(i).get(j).getNivelVida();
                        suma2+=nivel;
                        cont2++;
                    }
                    
                }
            }
        }
        System.out.println("--------------------------------------------------------");
        System.out.println("El promedio del nivel de vida del Equipo 1 :");
        System.out.println(suma/cont);
        System.out.println("El promedio del nivel de vida del Equipo 2 :");
        System.out.println(suma2/cont2);
        
    }
    public static void ordenarCreadosNombre(ArrayList<ArrayList<Soldado>> tablero ,int n){
        
        int cont=0;
        for( int i = 0 ; i< 10;i++){
            for( int m = 0 ; m< 10;m++){
                if (tablero.get(i).get(m) != null) {
                    cont++;
                }
            }
        }
        int m=0;
        while(m<cont){
            for( int i = 0 ; i< 10; i++){
                for( int j = 0 ; j< 10; j++){
                    if (tablero.get(i).get(j) != null){
                        int numero = numeroEquipo(tablero,  i, j);
                        if(n == numero){
                            String nombre =tablero.get(i).get(j).getNombre();
                            int orden = Integer.parseInt(nombre.substring(7,8));
                            if(orden == m){
                                System.out.println("Nombre: " + tablero.get(i).get(j).getNombre());
                                System.out.println("Nivel de Vida: " + tablero.get(i).get(j).getNivelVida());
                                System.out.println("Fila: " + tablero.get(i).get(j).getFila());
                                System.out.println("Columna: " + tablero.get(i).get(j).getColumna());
                                System.out.println("-----------");
                            }
                        }
                    
                    }
                }
            }
            m++;
        }
    }
    public static void ordenarPuntosBurbuja(ArrayList<ArrayList<Soldado>> tablero) {
        System.out.println("\nDatos ordenados por puntos(Burbuja) :");
        
        int fila=0;
        int colum =0;
        int fila2=0;
        int colum2 =0;
        int cantidad=0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tablero.get(i).get(j) != null ) {
                    cantidad++;
                }
            }
        }
        int otrocontador=0;//1
        while(otrocontador<cantidad){
            int contador = 1;//
            while( contador< cantidad-otrocontador){//3<5

                int cant =0;
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (tablero.get(i).get(j) != null  ) {
                            cant++;
                            if( cant ==contador){
                                fila =i;
                                colum=j;
                            }
                        }
                    }
                }
                cant =0;
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (tablero.get(i).get(j) != null  ) {
                            cant++;
                            if( cant ==contador+1){
                                fila2 =i;
                                colum2=j;
                            }
                        }
                    }
                }
                if(tablero.get(fila).get(colum).getNivelVida()>tablero.get(fila2).get(colum2).getNivelVida()){
                     Soldado aux = tablero.get(fila).get(colum);
                     //si no funciona corregir esta parte
                    tablero.get(fila).set(colum, tablero.get(fila2).get(colum2));
                    tablero.get(fila2).set(colum2, aux);
                }
                contador++;

            } 
            otrocontador ++;
        }
        
        mostrarSoldadosOrdenados(tablero);
    }
    
    
    public static void ordenarPuntosSeleccion(ArrayList<ArrayList<Soldado>> tablero) {
        System.out.println("\nDatos ordenados por puntos(Seleccion) :");
        
        
        int fila=0;
        int colum =0;
        int cant=0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tablero.get(i).get(j) != null ) {
                    cant++;
                }
            }
        }
        System.out.println("la cantidad es "+cant);
        int filainicio=0;
        int columinicio=0;
        int m =0;
        
        while(m < cant-1){
            int menor =6;
            for (int i = filainicio; i < 10; i++) {
                for (int j = columinicio+1; j < 10; j++) {
                    if (tablero.get(i).get(j)!= null && tablero.get(i).get(j).getNivelVida()<menor ) {
                        menor=tablero.get(i).get(j).getNivelVida();
                        fila=i;
                        colum =j;
                    }
                }
            }
            int veces=0;
            for (int i = filainicio; i < 10; i++) {
                for (int j = columinicio+1; j < 10; j++) {
                    if (tablero.get(i).get(j) != null ) {
                        veces++;
                        if(veces ==1){
                            if(i==fila && j ==colum){
                                filainicio=i;
                                columinicio=j;
                            }else{
                                Soldado aux = tablero.get(fila).get(colum);
                                tablero.get(fila).set(colum, tablero.get(i).get(j));
                                tablero.get(i).set(j, aux);

                                filainicio=i;
                                columinicio=j;
                                veces++;
                            }
                        }
                    }
                }
            }
            m++;
        }
        mostrarSoldadosOrdenados(tablero);
        
    }
    public static void mostrarSoldadosOrdenados(ArrayList<ArrayList<Soldado>> tablero){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <10; j++) {
                if (tablero.get(i).get(j)!= null) {
                    System.out.println("Nombre: " + tablero.get(i).get(j).getNombre());
                    System.out.println("Nivel de Vida: " + tablero.get(i).get(j).getNivelVida());
                    System.out.println("Fila: " + tablero.get(i).get(j).getFila());
                    System.out.println("Columna: " + tablero.get(i).get(j).getColumna());
                    System.out.println("-----------");
                }
            }
        }
    }
    public static void ganadorGuerra(ArrayList<ArrayList<Soldado>> tablero){
        int suma =0;
        int suma2 =0;
        for(int i =0; i<10 ; i++){
            for(int j =0; j<10 ; j++){
                if(tablero.get(i).get(j)!=null){
                    int numero = numeroEquipo(tablero,  i, j);
                    if (numero ==1){
                        int nivel =tablero.get(i).get(j).getNivelVida();
                        suma+=nivel;
                    }else{
                        int nivel =tablero.get(i).get(j).getNivelVida();
                        suma2+=nivel;
                    }
                    
                }
            }
        }
        Random rand = new Random();
        int numrandom = rand.nextInt(100)+1;
        int probabilidad = suma/(suma+suma2);
        if(numrandom<=probabilidad){
            System.out.println("Ganador de la Guerra  Equipo 1");
        }else{
            System.out.println("Ganador de la Guerra  Equipo 2 ");
        }
    }
}
