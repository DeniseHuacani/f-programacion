/*
Laboratorio 20
Nombre Denise Andrea Huacani Jara
 */
package laboratorio20;
import java.util.*;
public class Ejercitos {
    private ArrayList<Soldado> misSoldados = new ArrayList<Soldado>();
    public static final int MAX_SOLDADOS_EJERCITO = 10;
    private int cantidadSoldados=0;
    
    public static final String BLUE = "\u001B[34m";
    public static final String WHITE = "\u001B[37m";
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    
    private int[] sortearCantSoldados(){
        Random random = new Random();
        int[] numeros = new int[4];
        for (int i = 0; i < 4; i++) {
            numeros[i] = random.nextInt(6);
        }
        int suma = numeros[0] + numeros[1] + numeros[2] + numeros[3];
        if (suma <= 10) {
            return numeros;
        } 
        int cant =0;
        do {
            if(cant>3){
                cant=0;
            }
            numeros[cant]--;
            suma = numeros[0] + numeros[1] + numeros[2] + numeros[3];
            cant++;
            if (suma <= 10) {
                return numeros;
            } 
        }while(suma>10);
        return numeros;
        
    }
    public void llenarEjercito(int n,Ejercitos otroejer) {
        int[] cantSoldados = sortearCantSoldados();
        int nEspadachines = cantSoldados[0];
        int nArqueros = cantSoldados[1];
        int nCaballeros = cantSoldados[2];
        int nLanceros = cantSoldados[3];

        agregarSoldados(n, nEspadachines, "Espadachin", otroejer);
        agregarSoldados(n, nArqueros, "Arquero", otroejer);
        agregarSoldados(n, nCaballeros, "Caballero", otroejer);
        agregarSoldados(n, nLanceros, "Lancero", otroejer);
    }
    private void agregarSoldados(int numero, int cantidadSoldados, String tipo, Ejercitos otroejer ) {
        for (int i = 0; i < cantidadSoldados; i++) {
            agregarSoldadoAleatorio(numero, tipo, otroejer);
        }
    }
    private  void agregarSoldadoAleatorio(int numero, String tipo , Ejercitos otroejer) {
        Random random = new Random();
        
        if (cantidadSoldados < MAX_SOLDADOS_EJERCITO) {
            int fila;
            String letraColumna;
            do {
                fila = random.nextInt(10)+1; // del 1 al 10
                int colum = random.nextInt(10);
                letraColumna = convertirAAbecedario(colum);
            } while (this.posicionOcupada(fila, letraColumna, otroejer));

            String nombre = (tipo + cantidadSoldados + "X" + numero);
            int nivelAtaque = (random.nextInt(5) + 1);
            int nivelDefensa = (random.nextInt(5) + 1);

            switch (tipo) {
                case "Espadachin":
                    int longitud = (random.nextInt(10) + 1);
                    Espadachin nuevoSoldado = new Espadachin(nombre, fila, letraColumna, nivelAtaque,
                            nivelDefensa, longitud);
                    misSoldados.add(nuevoSoldado);
                    break;
                case "Caballero":
                    Caballero nuevoCaballero = new Caballero(nombre, fila, letraColumna, nivelAtaque,
                            nivelDefensa);
                    misSoldados.add(nuevoCaballero);
                    break;
                case "Arquero":
                    Arquero nuevoArquero = new Arquero(nombre, fila, letraColumna, nivelAtaque,
                            nivelDefensa);
                    misSoldados.add(nuevoArquero);
                    break;
                case "Lancero":
                    Lancero nuevoLancero = new Lancero(nombre, fila, letraColumna, nivelAtaque,
                            nivelDefensa);
                    misSoldados.add(nuevoLancero);
                    break;
                default:
                    break;
            }

            cantidadSoldados++;
        } else {
            
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
                if ( this.existeSoldado(i+1,j) ||  ejer2.existeSoldado(i+1,j) ) {
                    if(this.existeSoldado(i+1,j)){
                        array[i][j] = "| " + RED + this.imprimirDatos(i+1, j) +" " +RESET;
                    }
                    else if (  ejer2.existeSoldado(i+1,j)){
                        array[i][j] = "| " + BLUE + ejer2.imprimirDatos(i+1, j) +" " + RESET;
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
    public static String convertirAAbecedario(int numero) {
        
        char letra = (char) ('A' + numero);

        return Character.toString(letra);
    }
    public boolean posicionOcupada(int fila, String columna, Ejercitos otroejer) {
        for (Soldado soldado : otroejer.misSoldados) {
            if (soldado.getFila() == fila && soldado.getColumna().equals(columna)) {
                return true;
            }
        }
        for (Soldado soldado : this.misSoldados) {
            if (soldado.getFila() == fila && soldado.getColumna().equals(columna)) {
                return true;
            }
        }
        
        return false;
    }
    public  boolean  existeSoldado(int fi, int co){
        String columna = convertirAAbecedario(co);
        for (Soldado soldado : misSoldados) {
            if (soldado.getFila() == fi && soldado.getColumna().equals(columna)) {
                return true;
            }
        }
        return false;
    }
    public  String imprimirDatos(int fi, int co){
        String columna = convertirAAbecedario(co);
        for (Soldado soldado : misSoldados) {
            if (soldado.getFila() == fi && soldado.getColumna().equals(columna)) {
                if( soldado instanceof Espadachin){
                    return "E"+soldado.getNivelVida();
                }
                else if( soldado instanceof Caballero){
                    return "C"+soldado.getNivelVida();
                }
                else if( soldado instanceof Arquero){
                    return "A"+soldado.getNivelVida();
                }
                else if( soldado instanceof Lancero){
                    return "L"+soldado.getNivelVida();
                }
                
            }
        }
        
       
        return "";
    }

    public int getCantidadSoldados() {
        return cantidadSoldados;
    }
    
    //
    public void mostrarSoldados() {
        for (Soldado soldado : this.misSoldados) {
            System.out.println(soldado.toString());
        }
        
    }
    
    public  void mayorNV(){
        int mayorNV =0;
        for (Soldado sol: misSoldados) {
            if(mayorNV<sol.getNivelVida()){
                mayorNV=sol.getNivelVida();
            } 
        }
        buscarSoldado(mayorNV);
    }
    public  void buscarSoldado(int num){
       for (Soldado sol: misSoldados) {
            if(num==sol.getNivelVida()){
                System.out.println(sol.toString());
            } 
        }
        
    }
    public  double promedioNVTodos(){
        
        double suma =0;
        int cont =0;
        for (Soldado sol: this.misSoldados) {
            suma+=sol.getNivelVida();
            cont++;
        }
        return suma/cont;
    }
    public  void ordenarCreadosNombre(){
        
        int m=0;
        while(m<this.cantidadSoldados){
            for (Soldado sol: this.misSoldados) {
                String nombre = sol.getNombre();
                
                int numero= Integer.parseInt(nombre.substring(nombre.length()-3,nombre.length()-2));
                if(numero==m){
                    System.out.println(sol.toString());
                }
            }
            
            m++;
        }
    }
     public void ordenarEjercitoPorNivelVidaBurbuja() {
        ArrayList<Soldado> todosLosSoldados = new ArrayList<>();

        todosLosSoldados.addAll(this.misSoldados);
        
        int n = todosLosSoldados.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (todosLosSoldados.get(j).getNivelVida() < todosLosSoldados.get(j + 1).getNivelVida()) {
                    
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
    public int obtenerSumaNV() {
        int sumaNV = 0;
        for (Soldado soldado : misSoldados) {
            sumaNV += soldado.getNivelVida();
        }
        
        return sumaNV;
    }
    
    public static String getNombre(String nombre, String color){
        if(color.equals("ROJO")){
            return RED+nombre+RESET;
        }
        return BLUE+nombre+RESET;
    }

}
