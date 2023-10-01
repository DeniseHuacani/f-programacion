/*
    Laboratorio Nro 05 Ejercicio 01
    Autor : Denise Andrea Huacani Jara
    Colaboro:-
    Tiempo:
 */
package laboratorio05;
import java.util.*;
public class VideoJuego {
    public static void main (String [] args ){
        Soldado[][] soldados = new Soldado[10][10];
        ingresarDatosSoldados(soldados);
        mostrarTableroSoldados(soldados);
        //mostrarTodosSoldados(soldados);
        mostrarMayorNV(soldados);
        System.out.println("El promedio de los niveles de vida : "+promedioNV(soldados));
        mostrarNVTodos(soldados);
        ordenarCreadosNombre(soldados);
        ordenarPuntosBurbuja(soldados);
        ordenarPuntosSeleccion(soldados);
        
        
    }
    public static  int random (int num){
        Random random = new Random ();
        return random.nextInt(num)+1;
    }
    
    public static void ingresarDatosSoldados(Soldado[][] array) {
        int cant =random (10);
        System.out.println("Se creo "+cant+" soldados");
        for ( int i =0; i < cant; i++){
            int fila  = random(10);
            int colum = random(10);
            while(array[fila-1][colum-1]!= null){
                fila  = random(10);
                colum = random(10);
            }
            array[fila-1][colum-1]=new Soldado();
            array[fila-1][colum-1].setNombre("Soldado"+i);
            array[fila-1][colum-1].setNivelVida(random(5));
            array[fila-1][colum-1].setFila(fila);
            array[fila-1][colum-1].setColumna(colum);
        }
    }
    public static void  mostrarTableroSoldados(Soldado[][] soldados){
        String[][] array= new String[10][10];
        System.out.println("    A  B  C  D  E  F  G  H  I  J");
        System.out.println("   ______________________________");
        for(int i =0; i<10; i++){
            if(i==9)
                System.out.print((i+1)+" ");
            else
                System.out.print((i+1)+"  ");
            for(int j =0; j<10; j++){
                if (soldados[i][j] != null) {
                    array[i][j] = "|@ ";
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
    public static void mostrarMayorNV(Soldado[][] soldados){
        int mayor =0;
        for(int i =0; i<soldados.length ; i++){
            for(int j =0; j<soldados.length ; j++){
                if(soldados[i][j]!=null){
                    int nivel =soldados[i][j].getNivelVida();
                    if(mayor<nivel){
                        mayor = nivel;
                    }
                }
            }
        }
        System.out.println("\nDatos del soldado con mayor nivel de vida ");
        System.out.println("-------------------------");
        for(int i =0; i<soldados.length ; i++){
            for(int j =0; j<soldados.length ; j++){
                if(soldados[i][j] != null && soldados[i][j].getNivelVida()==mayor){
                    System.out.println("Nombre: " + soldados[i][j].getNombre());
                    System.out.println("Nivel de Vida: " + soldados[i][j].getNivelVida());
                    System.out.println("Fila: " + soldados[i][j].getFila());
                    System.out.println("Columna: " + soldados[i][j].getColumna());
                    System.out.println("-----------");
                }
            }
        }
    }
    public static double promedioNV(Soldado[][] soldados){
        double suma =0;
        int cont =0;
        for(int i =0; i<soldados.length ; i++){
            for(int j =0; j<soldados.length ; j++){
                if(soldados[i][j]!=null){
                    int nivel =soldados[i][j].getNivelVida();
                    suma+=nivel;
                    cont++;
                }
            }
        }
        System.out.println("-----------");
        return suma/cont;
    }
    public static void mostrarNVTodos(Soldado[][] soldados){
        System.out.println("\nNivel de vida de todos los soldados:");
        for (int i = 0; i < soldados.length; i++) {
            for (int j = 0; j < soldados[i].length; j++) {
                if (soldados[i][j] != null) {
                    System.out.println("Nombre: " + soldados[i][j].getNombre());
                    System.out.println("Nivel de Vida: " + soldados[i][j].getNivelVida());
                    System.out.println("-----------");
                }
            }
        }
    }
    public static void ordenarCreadosNombre(Soldado[][] soldados){
        System.out.println("\nDatos ordenados por nombre :");
        System.out.println("-------------------------");
        int cont=0;
        for( int i = 0 ; i< soldados.length;i++){
            for( int m = 0 ; m< soldados.length;m++){
                if (soldados[i][m] != null) {
                    cont++;
                }
            }
        }
        int m=0;
        while(m<cont){
            for( int i = 0 ; i< soldados.length; i++){
                for( int j = 0 ; j< soldados.length; j++){
                    if (soldados[i][j] != null){
                    String nombre =soldados[i][j].getNombre();
                    int numero = Integer.parseInt(nombre.substring(7));
                    if(numero == m){
                        System.out.println("Nombre: " + soldados[i][j].getNombre());
                        System.out.println("Nivel de Vida: " + soldados[i][j].getNivelVida());
                        System.out.println("Fila: " + soldados[i][j].getFila());
                        System.out.println("Columna: " + soldados[i][j].getColumna());
                        System.out.println("-----------");
                    }
                    }
                }
            }
            m++;
        }
    }
    public static void ordenarPuntosBurbuja(Soldado[][] soldados) {
        System.out.println("\nDatos ordenados por puntos(Burbuja) :");
        System.out.println("-------------------------");
        int fila=0;
        int colum =0;
        int fila2=0;
        int colum2 =0;
        int cantidad=0;
        for (int i = 0; i < soldados.length; i++) {
            for (int j = 0; j < soldados[i].length; j++) {
                if (soldados[i][j] != null ) {
                    cantidad++;
                }
            }
        }
        int otrocontador=0;//1
        while(otrocontador<cantidad){
            int contador = 1;//
            while( contador< cantidad-otrocontador){//3<5

                int cant =0;
                for (int i = 0; i < soldados.length; i++) {
                    for (int j = 0; j < soldados[i].length; j++) {
                        if (soldados[i][j] != null  ) {
                            cant++;
                            if( cant ==contador){
                                fila =i;
                                colum=j;
                            }
                        }
                    }
                }
                cant =0;
                for (int i = 0; i < soldados.length; i++) {
                    for (int j = 0; j < soldados[i].length; j++) {
                        if (soldados[i][j] != null  ) {
                            cant++;
                            if( cant ==contador+1){
                                fila2 =i;
                                colum2=j;
                            }
                        }
                    }
                }
                if(soldados[fila][colum].getNivelVida()>soldados[fila2][colum2].getNivelVida()){
                    Soldado aux = soldados[fila][colum];
                    soldados[fila][colum] = soldados[fila2][colum2];
                    soldados[fila2][colum2]= aux;
                }
                contador++;

            } 
            otrocontador ++;
        }
        
        
        // Mostrar los soldados ordenados por nivel de vida
        for (int i = 0; i < soldados.length; i++) {
            for (int j = 0; j < soldados[i].length; j++) {
                if (soldados[i][j] != null) {
                    System.out.println("Nombre: " + soldados[i][j].getNombre());
                    System.out.println("Nivel de Vida: " + soldados[i][j].getNivelVida());
                    System.out.println("Fila: " + soldados[i][j].getFila());
                    System.out.println("Columna: " + soldados[i][j].getColumna());
                    System.out.println("-----------");
                }
            }
        }
    }
    public static void ordenarPuntosSeleccion(Soldado[][] soldados) {
        System.out.println("\nDatos ordenados por puntos(Seleccion) :");
        System.out.println("-------------------------");
        
        int fila=0;
        int colum =0;
        int cant=0;
        for (int i = 0; i < soldados.length; i++) {
            for (int j = 0; j < soldados[i].length; j++) {
                if (soldados[i][j] != null ) {
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
            for (int i = filainicio; i < soldados.length; i++) {
                for (int j = columinicio+1; j < soldados[i].length; j++) {
                    if (soldados[i][j] != null && soldados[i][j].getNivelVida()<menor ) {
                        menor=soldados[i][j].getNivelVida();
                        fila=i;
                        colum =j;
                    }
                }
            }
            int veces=0;
            for (int i = filainicio; i < soldados.length; i++) {
                for (int j = columinicio+1; j < soldados[i].length ; j++) {
                    if (soldados[i][j] != null ) {
                        veces++;
                        if(veces ==1){
                            if(i==fila && j ==colum){
                                filainicio=i;
                                columinicio=j;
                            }else{
                                Soldado aux = soldados[fila][colum];
                                soldados[fila][colum] = soldados[i][j];
                                soldados[i][j]= aux;
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
        // Mostrar los soldados ordenados por nivel de vida
        for (int i = 0; i < soldados.length; i++) {
            for (int j = 0; j < soldados[i].length; j++) {
                if (soldados[i][j] != null) {
                    System.out.println("Nombre: " + soldados[i][j].getNombre());
                    System.out.println("Nivel de Vida: " + soldados[i][j].getNivelVida());
                    System.out.println("Fila: " + soldados[i][j].getFila());
                    System.out.println("Columna: " + soldados[i][j].getColumna());
                    System.out.println("-----------");
                }
            }
        }
    }

   
    public static void mostrarTodosSoldados(Soldado[][] soldados) {
        System.out.println("\nDatos de todos los soldados:");
        System.out.println("-------------------------");
        for (int i = 0; i < soldados.length; i++) {
            for (int j = 0; j < soldados[i].length; j++) {
                if (soldados[i][j] != null) {
                    System.out.println("Nombre: " + soldados[i][j].getNombre());
                    System.out.println("Nivel de Vida: " + soldados[i][j].getNivelVida());
                    System.out.println("Fila: " + soldados[i][j].getFila());
                    System.out.println("Columna: " + soldados[i][j].getColumna());
                    System.out.println("-----------");
                }
            }
        }
    }

}
