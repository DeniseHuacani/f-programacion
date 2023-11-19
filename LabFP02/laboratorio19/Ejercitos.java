/*
Laboratorio 19 
Nombre: Denise Andrea Huacani Jara
 */
package laboratorio19;

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
    
    public int obtenerNV(int indice, String co) {
        int cont =0;
        for (Espadachin soldado : misEspadachines) {
            if(indice==cont){
                return soldado.getNivelVida();
            }
            cont++;
        }
        for (Arquero soldado : misArqueros) {
            if(indice==cont){
                return soldado.getNivelVida();
            }
            cont++;
        }
        for (Caballero soldado : misCaballeros) {
            if(indice==cont){
                return soldado.getNivelVida();
            }
            cont++;
        }
        return -1;
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
    public static int convertirANumero(String letra){

        char letraMayuscula = letra.toUpperCase().charAt(0);
        if (letraMayuscula < 'A' || letraMayuscula > 'Z') {
            System.out.println("El carácter debe ser una letra mayúscula.");
        }
        int numero = letraMayuscula - 'A';

        return numero;
    }
    
    public  void aumentarNV(String tipo,int indice ) {
        int cont=0;
        if(tipo.equals("Espadachin")){
            for (Espadachin soldado : misEspadachines) {
                if(indice==cont){
                    int nv = soldado.getNivelVida();
                    soldado.setNivelVida(nv+1);
                }

            }
        }
        else if(tipo.equals("Arquero")){
            for (Arquero soldado : misArqueros) {
                if(indice==cont){
                    int nv = soldado.getNivelVida();
                    soldado.setNivelVida(nv+1);
                }
            }
        }
        else if(tipo.equals("Caballero")){
            for (Caballero soldado : misCaballeros) {
                if(indice==cont){
                    int nv = soldado.getNivelVida();
                    soldado.setNivelVida(nv+1);
                }
            }
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
    
    public  int juegoEjercito( Ejercitos secundario , int numeroDeEjercito){
        Scanner sc = new Scanner (System.in);
        
        //elegir ejercito
        int ubicacion_Actual=0;
        do{
            System.out.print("Elige la posicion a donde se movera el guerrero(ej A4):");
            String posicionGuerrero =sc.next();
            ubicacion_Actual = convertirStringANumero(posicionGuerrero); //fila columna
            
            if(!this.verificarPosicion(ubicacion_Actual)){
                System.out.println("No existe un soldado en esa posicion");
                ubicacion_Actual = -1;
            }
        }while(ubicacion_Actual == -1); //si es -1 es que no es valido la entrada
        
        
        //ingresar nueva ubicacion
        int ubicacion_Nuevo=0;
        do{
            System.out.println("Solo puede moverse un casillero , "
                + "en cualquier direccion(diagonal , avanzar , retroceder)");
            
            System.out.print("Elige la posicion a donde se movera el guerrero(ej A4):");
            String posString = sc.next();
            ubicacion_Nuevo =convertirStringANumero(posString);
            
                if(nopuedeMoverse( ubicacion_Actual,  ubicacion_Nuevo)){
                    ubicacion_Nuevo=-1; // para volver a ingresa 
                    System.out.println("El soldado solo puede recorrer un espacio");
                }
            
        }while(ubicacion_Nuevo == -1); //si es -1 es que no es valido la entrada
        
        //moverlo
        moverGuerrero(this, ubicacion_Actual,ubicacion_Nuevo);
        return ubicacion_Nuevo;
        
    }
    public static int convertirStringANumero(String posicion){
        char letra = posicion.charAt(0); 
        int fila = Integer.parseInt(posicion.substring(1))-1; 

        // Convierte la letra a su valor numérico correspondiente (A=1, B=2, ..., Z=26)
        int columna = Character.toUpperCase(letra) - 'A' ;
        
        if(fila>=10 ){
            System.out.println("Fila no valida. Vuelva a ingresar");
            return -1;
        }else if(columna >=10){
            System.out.println("Columna no valida. Vuelva a ingresar");
            return -1;
        }
        int posicionNum = fila*10 + columna;//fila+ columa

        return posicionNum;
    }
    
    public  boolean verificarPosicion(int ubicacion_Actual){
        int fila = ubicacion_Actual/10;
        int columna = ubicacion_Actual%10;
        
        return existeSoldado( fila,  columna, this);
        
    }
    public static boolean nopuedeMoverse( int poActual, int poNueva) {
        int fila1 = poActual / 10;
        int colum1 = poActual % 10; // Modificar esta línea para obtener la columna correctamente

        int fila2 = poNueva / 10;
        int colum2 = poNueva % 10; // Modificar esta línea para obtener la columna correctamente
        
        return Math.abs(fila1 - fila2) > 1 || Math.abs(colum1 - colum2) > 1;
    }
    public static void moverGuerrero(Ejercitos ejercito,int poActual, int poNueva){
        
        
        String numYTipoSoldado=hallarTipoSoldadoYNumero(ejercito, poActual);
        int indice = Integer.parseInt(numYTipoSoldado.substring(0,1));
        String tipo =numYTipoSoldado.substring(1);
        
        int filan = poNueva / 10;
        int coln = poNueva %10;
        String letra =convertirAAbecedario(coln);
        
        if(tipo .equals("Espadachin")){
            Espadachin nuevo = ejercito.misEspadachines.remove(indice);
            nuevo.setFila(filan);
            nuevo.setColumna(letra);
            ejercito.misEspadachines.add(nuevo);
        }
        else if(tipo .equals("Arquero")){
            Arquero nuevo = ejercito.misArqueros.remove(indice);
            nuevo.setFila(filan);
            nuevo.setColumna(letra);
            ejercito.misArqueros.add(nuevo);
        }
        else if(tipo .equals("Caballero")){
            Caballero nuevo = ejercito.misCaballeros.remove(indice);
            nuevo.setFila(filan);
            nuevo.setColumna(letra);
            ejercito.misCaballeros.add(nuevo);
        }
        

    }
    public static String hallarTipoSoldadoYNumero(Ejercitos ejer, int posicion) {
        int filaActual = posicion / 10;
        int colActual = posicion % 10;
        int cont = 0;
        for (Espadachin soldado : ejer.misEspadachines) {
            if(soldado.getFila()==filaActual && convertirANumero(soldado.getColumna())==colActual){
                return cont+"Espadachin";
            }
            cont++;
                
        }
         cont = 0;
        for (Arquero soldado : ejer.misArqueros) {
            if(soldado.getFila()==filaActual && convertirANumero(soldado.getColumna())==colActual){
                return cont+"Arquero";
            }
        }
         cont = 0;
        for (Caballero soldado : ejer.misCaballeros) {
            if(soldado.getFila()==filaActual && convertirANumero(soldado.getColumna())==colActual){
                return cont+"Caballero";
            }
        }
        return null;
    }
    public String getNombre(String nombre, String color){
        if(color.equals("ROJO")){
            return RED+nombre+RESET;
        }
        return BLUE+nombre+RESET;
    }
    public  boolean hayPelea( int posicion){
        int filaActual = posicion / 10;
        int colActual = posicion % 10 ;
        return existeSoldado( filaActual,  colActual, this);
    }
    public  void batallaSoldado(Ejercitos ejer2, int posicion){
        
        Random rand = new Random();
        int num = rand.nextInt(100)+1;
        
        String indiceTipo  =hallarTipoSoldadoYNumero(this, posicion);
        int indice = Integer.parseInt(indiceTipo.substring(0,1));
        String tipo =indiceTipo.substring(1);
        int vida1 = obtenerNV( indice,  tipo);
        
        String indiceTipo2 =hallarTipoSoldadoYNumero(ejer2, posicion);
        int indice2 = Integer.parseInt(indiceTipo2.substring(0,1));
        String tipo2 =indiceTipo2.substring(1);
        int vida2 = obtenerNV( indice2,  tipo2);
        
        double cantidad = vida1+vida2;
        double probabilidad= vida1*100/cantidad;
        double factor = Math.pow(10, 1);//1 es el numero de decimales
        probabilidad = Math.round(probabilidad * factor) / factor;
        //double probabilidad_segundo = 100- probabilidad;
        
        System.out.println("\t\t"+this.getNombre("Ejercito 1 ", "ROJO")+"        "+this.getNombre("Ejercito 2 ", "AZUL"));
        System.out.println(   "Vida:	  	"+vida1+"\t\t"+vida2);
        System.out.println("Probabilidad:  "+probabilidad+"%\t"+"\t"+(100- probabilidad)+"%");
        
        if(num<=probabilidad){
            System.out.println("Gano : "+this.getNombre("Ejercito 1 ", "ROJO") );
            System.out.println("Muere: "+this.getNombre("Ejercito 2 ", "AZUL"));
            ejer2.eliminarSoldado( tipo2, indice2);
            this.aumentarNV(tipo, indice);
            
            System.out.println("Vida +1" );
        }else{
            System.out.println("Gano : "+this.getNombre("Ejercito 2 ", "AZUL"));
            System.out.println("Muere: "+this.getNombre("Ejercito 1 ", "ROJO") );
            this.eliminarSoldado( tipo, indice);
            ejer2.aumentarNV(tipo2, indice2);
            System.out.println("Vida +1" );
        }
    }
    public  void eliminarSoldado(String tipo, int indice){
        
        if(tipo .equals("Espadachin")){
            this.misEspadachines.remove(indice);
        }
        else if(tipo .equals("Arquero")){
            this.misArqueros.remove(indice);
        }
        else if(tipo .equals("Caballero")){
            this.misCaballeros.remove(indice);
        }
    }
    
    

}
