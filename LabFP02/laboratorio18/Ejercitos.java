/*
Laboratorio 18 
Nombre : Huacani Jara Denise Andrea
 */
package laboratorio18;

import java.util.*;
public class Ejercitos {
    
    private ArrayList<Espadachin> misEspadachines = new ArrayList<Espadachin>();
    private ArrayList<Arquero> misArqueros = new ArrayList<Arquero>();
    private ArrayList<Caballero> misCaballeros = new ArrayList<Caballero>();
    
    public static final int MAX_SOLDADOS_EJERCITO = 10;
    private int cantidadSoldados=0;
    
    
    public static final String BLUE = "\u001B[34m";
    public static final String WHITE = "\u001B[37m";
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    
    public int obtenerSumaNV() {
        int sumaNV = 0;
        for (Soldado soldado : misEspadachines) {
            sumaNV += soldado.getNivelVida();
        }
        for (Soldado soldado : misArqueros) {
            sumaNV += soldado.getNivelVida();
        }
        for (Soldado soldado : misCaballeros) {
            sumaNV += soldado.getNivelVida();
        }
        return sumaNV;
    }
    
    public void llenarEjercito(int n,Ejercitos otroejer) {
        Random random = new Random();

        int nEspadachines = random.nextInt(10) + 1;
        int resto =10-nEspadachines;
        int nArqueros=0;
        if(resto>=1){
            nArqueros = random.nextInt(resto) + 1;
        }
        
        resto = 10-nArqueros-nEspadachines;
        int nCaballeros=0;
        if(resto>=1){
            nCaballeros = random.nextInt(resto) + 1;
        }
    // Resto del código...


        for(int i =0; i < nEspadachines; i++){
            agregarSoldadoAutogenerado( n, "Espadachin" , otroejer);
        }
        for(int i =0; i < nArqueros ; i++){
            agregarSoldadoAutogenerado( n, "Arquero" ,otroejer);
        }
        for(int i =0; i < nCaballeros; i++){
            agregarSoldadoAutogenerado( n, "Caballero" ,otroejer);
        }
    }
    public boolean posicionOcupada(int fila, String columna, Ejercitos otroejer) {
        for (Soldado soldado : misEspadachines) {
            if (soldado.getFila() == fila && soldado.getColumna().equals(columna)) {
                return true;
            }
        }
        for (Soldado soldado : misCaballeros) {
            if (soldado.getFila() == fila && soldado.getColumna().equals(columna)) {
                return true;
            }
        }
        for (Soldado soldado : misArqueros) {
            if (soldado.getFila() == fila && soldado.getColumna().equals(columna)) {
                return true;
            }
        }
         for (Soldado soldado : otroejer.misEspadachines) {
            if (soldado.getFila() == fila && soldado.getColumna().equals(columna)) {
                return true;
            }
        }
        for (Soldado soldado : otroejer.misCaballeros) {
            if (soldado.getFila() == fila && soldado.getColumna().equals(columna)) {
                return true;
            }
        }
        for (Soldado soldado : otroejer.misArqueros) {
            if (soldado.getFila() == fila && soldado.getColumna().equals(columna)) {
                return true;
            }
        }
        return false;
    }
    public  void agregarSoldadoAutogenerado(int numero, String tipo , Ejercitos otroejer) {
        Random random = new Random();
        if (cantidadSoldados < MAX_SOLDADOS_EJERCITO) {
            int fila;
            String  letraColumna;
            do{
                fila  = random.nextInt(10);//del 0 al 9
                int colum = random.nextInt(10);
                letraColumna=convertirAAbecedario(colum);
            }while(posicionOcupada(fila, letraColumna, otroejer));
            
            String nombre = (tipo+cantidadSoldados+"X"+numero);
            int nivelVida = (random.nextInt(5)+1); 
            int nivelAtaque = (random.nextInt(5)+1);
            int nivelDefensa= (random.nextInt(5)+1);
            if(tipo.equals("Espadachin")){
                int longitud= (random.nextInt(10)+1); 
                Espadachin nuevoSoldado = new Espadachin(nombre, nivelVida, fila,letraColumna , nivelAtaque,
                    nivelDefensa,longitud);
                misEspadachines.add(nuevoSoldado);
            }
            else if(tipo.equals("Caballero")){
                Caballero nuevoSoldado = new Caballero(nombre, nivelVida, fila,letraColumna , nivelAtaque,
                    nivelDefensa);
                misCaballeros.add(nuevoSoldado);
            }
            else if(tipo.equals("Arquero")){
                Arquero nuevoSoldado = new Arquero(nombre, nivelVida, fila,letraColumna , nivelAtaque,
                    nivelDefensa);
                misArqueros.add(nuevoSoldado);
            }
            
            cantidadSoldados++;
        }else {
            System.out.println("El ejército está lleno. No se pueden agregar más soldados.");
        }
        
    }
    public static String convertirAAbecedario(int numero) {
        
        char letra = (char) ('A' + numero);

        return Character.toString(letra);
    }
    
    
    public  void aumentarNV( ) {
        for (Espadachin soldado : misEspadachines) {
            int nv = soldado.getNivelVida();
            soldado.setNivelVida(nv+1);
        }
        for (Arquero soldado : misArqueros) {
            int nv = soldado.getNivelVida();
            soldado.setNivelVida(nv+1);
        }
        for (Caballero soldado : misCaballeros) {
            int nv = soldado.getNivelVida();
            soldado.setNivelVida(nv+1);
        }
            
    }
    public void  llenarTablero(Ejercitos ejer2){
        String[][] array= new String[10][10];
        System.out.println("     A    B    C    D    E    F    G     H    I    J");
        System.out.println("   ___________________________________________________");
        for(int i =0; i<10; i++){
            if(i==9)
                System.out.print((i+1)+" ");
            else
                System.out.print((i+1)+"  ");
            for(int j =0; j<10; j++){
                if ( existeSoldado(i,j, this) ||  existeSoldado(i,j, ejer2) ) {
                    if(existeSoldado(i,j,this)){
                        array[i][j] = "| " + RED + imprimirDatos(i, j, this) +" " +RESET;
                    }
                    else if ( existeSoldado(i,j, ejer2)){
                        array[i][j] = "| " + BLUE + imprimirDatos(i, j, ejer2) +" " + RESET;
                    }
                } else {
                    array[i][j] = "|" + WHITE + "    " + RESET;
                }
                System.out.print(array[i][j]);
            }
            System.out.print("|");
            System.out.println();
            System.out.println("   ___________________________________________________");
        }
    } 
    public  boolean  existeSoldado(int fi, int co, Ejercitos ejer){
        String columna = convertirAAbecedario(co);
        for (Espadachin soldado : ejer.misEspadachines) {
            if (soldado.getFila() == fi && soldado.getColumna().equals(columna)) {
                return true;
            }
        }
        for (Caballero soldado : ejer.misCaballeros) {
            if (soldado.getFila() == fi && soldado.getColumna().equals(columna)) {
                return true;
            }
        }
        for (Arquero soldado : ejer.misArqueros) {
            if (soldado.getFila() == fi && soldado.getColumna().equals(columna)) {
                return true;
            }
        }
        return false;
    }
    
    public static  String imprimirDatos(int fi, int co, Ejercitos ejer){
        String columna = convertirAAbecedario(co);
        for (Espadachin soldado : ejer.misEspadachines) {
            if (soldado.getFila() == fi && soldado.getColumna().equals(columna)) {
                return "E"+soldado.getNivelVida();
            }
        }
        for (Caballero soldado : ejer.misCaballeros) {
            if (soldado.getFila() == fi && soldado.getColumna().equals(columna)) {
                return "C"+soldado.getNivelVida();
            }
        }
        for (Arquero soldado : ejer.misArqueros) {
            if (soldado.getFila() == fi && soldado.getColumna().equals(columna)) {
                return"A"+soldado.getNivelVida();
            }
        }
       
        return "";
    }
    
    public int getCantidadSoldados() {
        return cantidadSoldados;
    }
    public void mostrarSoldados() {
        for (Arquero arquero : this.misArqueros) {
            System.out.println(arquero.toString());
        }
        for (Espadachin espadachin : this.misEspadachines) {
            System.out.println(espadachin.toString());
        }
        for (Caballero caballero : this.misCaballeros) {
            System.out.println(caballero.toString());
        }
    }

    public  void mayorNV(){
        
        int mayorNV =0;
        for (Arquero sol: this.misArqueros) {
            if(mayorNV<sol.getNivelVida()){
                mayorNV=sol.getNivelVida();
            } 
        }
        for (Espadachin sol: this.misEspadachines) {
            if(mayorNV<sol.getNivelVida()){
                mayorNV=sol.getNivelVida();
            } 
        }
        for (Caballero sol: this.misCaballeros) {
            if(mayorNV<sol.getNivelVida()){
                mayorNV=sol.getNivelVida();
            }  
        }
        
        buscarSoldado(mayorNV);
    }
    public  void buscarSoldado(int num){
        for (Arquero sol: this.misArqueros) {
            if(num==sol.getNivelVida()){
                System.out.println(sol.toString());
            } 
        }
        for (Espadachin sol: this.misEspadachines) {
            if(num==sol.getNivelVida()){
                System.out.println(sol.toString());
            } 
        }
        for (Caballero sol: this.misCaballeros) {
            if(num==sol.getNivelVida()){
                System.out.println(sol.toString());
            }   
        }
    }
    public  double promedioNVTodos(){
        
        double suma =0;
        int cont =0;
        for (Arquero sol: this.misArqueros) {
            suma+=sol.getNivelVida();
            cont++;
        }
        for (Espadachin sol: this.misEspadachines) {
            suma+=sol.getNivelVida();
            cont++;
        }
        for (Caballero sol: this.misCaballeros) {
            suma+=sol.getNivelVida(); 
            cont++;
        }
        return suma/cont;
    }
    public  void ordenarCreadosNombre(){
        
        int m=0;
        while(m<this.cantidadSoldados){
            for (Arquero sol: this.misArqueros) {
                String nombre = sol.getNombre();
                int numero= Integer.parseInt(nombre.substring(7,8));
                if(numero==m){
                    System.out.println(sol.toString());
                }
            }
            for (Espadachin sol: this.misEspadachines) {
                String nombre = sol.getNombre();
                int numero= Integer.parseInt(nombre.substring(10,11));
                if(numero==m){
                    System.out.println(sol.toString());
                }
            }
            for (Caballero sol: this.misCaballeros) {
                String nombre = sol.getNombre();
                int numero= Integer.parseInt(nombre.substring(9,10));
                if(numero==m){
                    System.out.println(sol.toString());
                }
            }
            m++;
        }
    }
    public void ordenarEjercitoPorNivelVidaBurbuja() {
        ArrayList<Soldado> todosLosSoldados = new ArrayList<>();

        // Agregar todos los soldados a la lista
        todosLosSoldados.addAll(this.misEspadachines);
        todosLosSoldados.addAll(this.misArqueros);
        todosLosSoldados.addAll(this.misCaballeros);

        // Aplicar el algoritmo de ordenamiento de burbuja
        int n = todosLosSoldados.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (todosLosSoldados.get(j).getNivelVida() < todosLosSoldados.get(j + 1).getNivelVida()) {
                    // Swap si el elemento actual es menor que el siguiente
                    Soldado temp = todosLosSoldados.get(j);
                    todosLosSoldados.set(j, todosLosSoldados.get(j + 1));
                    todosLosSoldados.set(j + 1, temp);
                }
            }
        }

        // Mostrar la lista ordenada
        for (Soldado soldado : todosLosSoldados) {
            System.out.println(soldado.toString());
        }
    }
    public void seleccionarGanador(Ejercitos ejer){
        int numeroVida1 = this.obtenerSumaNV();
        int numeroVida2 = ejer.obtenerSumaNV();
        System.out.println("Ejercito 1: Suma de nivel de vida : "+numeroVida1);
        System.out.println("Ejercito 2: Suma de nivel de vida : "+numeroVida2);
        if(numeroVida1>numeroVida2){
            System.out.println("\n!!!   Ganador Ejercito  1    !!!");
            System.out.println("Metrica usada : El ejercito con mayor nivel de vida");
        }else{
            System.out.println("\n!!!   Ganador Ejercito  2   !!!");
            System.out.println("Metrica usada : El ejercito con mayor nivel de vida");
        }
        
    }

}
