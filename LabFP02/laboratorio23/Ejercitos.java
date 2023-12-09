/*
Laboratorio 22
ombre :Denise Andrea Huacani Jara
 */
package laboratorio23;


import java.util.*;
public class Ejercitos {
    private ArrayList<Soldado> misSoldados = new ArrayList<Soldado>();
    private int cantEspadachines=0;
    private int cantCaballeros=0;
    private int cantLanzeros=0;
    private int cantArquero=0;
    
    private int cantEspaReal=1;
    private int cantCabaMoro=1;
    private int cantEspaConquistador=1;
    private int cantCabaFranco=1;
    
    
    public static final int MAX_SOLDADOS_EJERCITO = 10;
    private int cantidadSoldados=0;
    
    public static final String BLUE = "\u001B[34m";
    public static final String WHITE = "\u001B[37m";
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    
    public  void aumentarNV( ) {
        System.out.println("---Se agrego una bonificacion +1 a los soldados del reino,---\n \t\tpor ser su territorio");
        for (Soldado soldado : misSoldados) {
            int nv = soldado.getNivelVida();
            soldado.setNivelVida(nv+1);
        }
            
    }
    public int[] sortearCantSoldados(){
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
    public  void agregarSoldadoAleatorio(int numero, String tipo , Ejercitos otroejer) {
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

            switch (tipo) {
                case "Espadachin":
                    int longitud = (random.nextInt(10) + 1);
                    Espadachin nuevoSoldado = new Espadachin(nombre, fila, letraColumna, longitud);
                    cantEspadachines++;
                    misSoldados.add(nuevoSoldado);
                    break;
                case "Caballero":
                    Caballero nuevoCaballero = new Caballero(nombre, fila, letraColumna);
                    cantCaballeros++;
                    misSoldados.add(nuevoCaballero);
                    break;
                case "Arquero":
                    Arquero nuevoArquero = new Arquero(nombre, fila, letraColumna);
                    cantArquero++;
                    misSoldados.add(nuevoArquero);
                    break;
                case "Lancero":
                    Lancero nuevoLancero = new Lancero(nombre, fila, letraColumna);
                    cantLanzeros++;
                    misSoldados.add(nuevoLancero);
                    break;
                default:
                    break;
            }
            cantidadSoldados++;
        } else {
        }
    }
    public  void agregarEspecialAleatorio(int numero, String tipo , Ejercitos otroejer) {
        Random random = new Random();
        
            int fila;
            String letraColumna;
            do {
                fila = random.nextInt(10)+1; // del 1 al 10
                int colum = random.nextInt(10);
                letraColumna = convertirAAbecedario(colum);
            } while (this.posicionOcupada(fila, letraColumna, otroejer));

            String nombre = (tipo + cantidadSoldados + "X" + numero);

            switch (tipo) {
                case "Real":
                    int longitud = (random.nextInt(10) + 1);
                    EspadachinReal nuevoSoldado = new EspadachinReal(nombre, fila, letraColumna, longitud);
                    cantEspadachines++;
                    misSoldados.add(nuevoSoldado);
                    break;
                case "Moro":
                    CaballeroMoro nuevoCaballero = new CaballeroMoro(nombre, fila, letraColumna);
                    cantCaballeros++;
                    misSoldados.add(nuevoCaballero);
                    break;
                case "Franco":
                    CaballeroFranco nuevoCaballeroF = new CaballeroFranco(nombre, fila, letraColumna);
                    cantArquero++;
                    misSoldados.add(nuevoCaballeroF);
                    break;
                case "Conquistador":
                    EspadachinConquistador nuevoEspadCon = new EspadachinConquistador(nombre, fila, letraColumna,10);
                    cantLanzeros++;
                    misSoldados.add(nuevoEspadCon);
                    break;
                case "Teutonico":
                    EspadachinTeutonico nuevoEspadaTeu = new EspadachinTeutonico(nombre, fila, letraColumna,10);
                    cantLanzeros++;
                    misSoldados.add(nuevoEspadaTeu);
                    break;
                default:
                    break;
            }
            cantidadSoldados++;
        
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
    public static String convertirAAbecedario(int numero) {
        
        char letra = (char) ('A' + numero); // A=0  9=J

        return Character.toString(letra);
    }
    public  String imprimirDatos(int fi, int co){
        String columna = convertirAAbecedario(co);
        for (Soldado soldado : misSoldados) {
            if (soldado.getFila() == fi && soldado.getColumna().equals(columna)) {
                if( soldado instanceof Espadachin){
                    String  vida=soldado.getNivelVida()+"";
                    if(soldado.getNivelVida()<10){
                        vida = soldado.getNivelVida()+"   ";
                    }
                    return "E"+vida+" ";
                }
                else if( soldado instanceof Caballero){
                    String  vida=soldado.getNivelVida()+"";
                    if(soldado.getNivelVida()<10){
                        vida = soldado.getNivelVida()+"   ";
                    }
                    return "C"+vida+" ";
                }
                else if( soldado instanceof Arquero){
                    String  vida=soldado.getNivelVida()+"";
                    if(soldado.getNivelVida()<10){
                        vida = soldado.getNivelVida()+"   ";
                    }
                    return "A"+vida+" ";
                }
                else if( soldado instanceof Lancero){
                    String  vida=soldado.getNivelVida()+"";
                    if(soldado.getNivelVida()<10){
                        vida = soldado.getNivelVida()+"   ";
                    }
                    return "L"+vida+" ";
                }
                else if( soldado instanceof CaballeroMoro){
                    String  vida=soldado.getNivelVida()+"";
                    if(soldado.getNivelVida()<10){
                        vida = soldado.getNivelVida()+"   ";
                    }
                    return "CM"+vida+" ";
                }
                else if( soldado instanceof CaballeroFranco){
                    String  vida=soldado.getNivelVida()+"";
                    if(soldado.getNivelVida()<10){
                        vida = soldado.getNivelVida()+"  ";
                    }
                    return "CF"+vida+" ";
                }
                else if( soldado instanceof EspadachinConquistador){
                    String  vida=soldado.getNivelVida()+"";
                    if(soldado.getNivelVida()<10){
                        vida = soldado.getNivelVida()+"  ";
                    }
                    return "EC"+vida+" ";
                }
                else if( soldado instanceof EspadachinReal){
                    String  vida=soldado.getNivelVida()+"";
                    if(soldado.getNivelVida()<10){
                        vida = soldado.getNivelVida()+"  ";
                    }
                    return "ER"+vida+" ";
                }
                else if( soldado instanceof EspadachinTeutonico){
                    String  vida=soldado.getNivelVida()+"";
                    if(soldado.getNivelVida()<10){
                        vida = soldado.getNivelVida()+"   ";
                    }
                    return "ET"+vida+" ";
                }
                
            }
        }
        return "";
    }

    public int getCantidadSoldados() {
        return cantidadSoldados;
    }
    
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
    public  int juegoEjercito( String posicionGuerrero, String posString){
        
        
        int ubicacion_Actual = convertirStringANumero(posicionGuerrero); //fila columna
        if(!this.verificarPosicion(ubicacion_Actual)){
            //System.out.println("-->No existe un soldado en esa posicion");
            return  -1;
        }
        
        
        int ubicacion_Nuevo =convertirStringANumero(posString);
        if(nopuedeMoverse( ubicacion_Actual,  ubicacion_Nuevo)){
            return -2; // para volver a ingresa 
            //System.out.println("-->El soldado solo puede recorrer un espacio");
        }
           
        moverGuerrero(this, ubicacion_Actual,ubicacion_Nuevo);
        return ubicacion_Nuevo;
        
    }
    public static int convertirStringANumero(String posicion){
        char letra = posicion.charAt(0); 
        int fila = Integer.parseInt(posicion.substring(1))-1; 

        // Convierte la letra a su valor numérico correspondiente (A=1, B=2, ..., Z=26)
        int columna = Character.toUpperCase(letra) - 'A' +0;
        
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
        int fila = ubicacion_Actual/10+1;
        int columna = ubicacion_Actual%10+1;
        
        return buscarSoldadoEjercito( fila,  columna);
        
    }
    public  boolean  buscarSoldadoEjercito(int fi, int co){
        String columna = convertirAAbecedario(co-1);
        for (Soldado soldado : misSoldados) {
            if (soldado.getFila() == fi && soldado.getColumna().equals(columna)) {
                return true;
            }
        }
        return false;
    }
    public static boolean nopuedeMoverse( int poActual, int poNueva) {
        int fila1 = poActual / 10;
        int colum1 = poActual % 10; // Modificar esta línea para obtener la columna correctamente

        int fila2 = poNueva / 10;
        int colum2 = poNueva % 10; // Modificar esta línea para obtener la columna correctamente
        
        return Math.abs(fila1 - fila2) > 1 || Math.abs(colum1 - colum2) > 1;
    }
    public static void moverGuerrero(Ejercitos ejercito,int poActual, int poNueva){
        
        int filan = poNueva / 10;
        int coln = poNueva %10;
        String letra =convertirAAbecedario(coln);
        
        Soldado solda=hallarYEliminarSoldado(ejercito, poActual);
        solda.setFila(filan+1);
        solda.setColumna(letra);
        ejercito.misSoldados.add(solda);
        

    }
    public static Soldado hallarYEliminarSoldado(Ejercitos ejer, int posicion) {
        int filaActual = posicion / 10+1;
        int colActual = posicion % 10;
        int cont = 0;
        for (Soldado soldado : ejer.misSoldados) {
            if(soldado.getFila()==filaActual && soldado.getColumna().equals(convertirAAbecedario(colActual))){
                ejer.misSoldados.remove(cont);
                
                return soldado;
            }
            cont++;
        }
        
        return null;
    }
    public int hallarIndiceSoldado( int posicion) {
        int filaActual = posicion / 10+1;
        int colActual = posicion % 10;
        int cont = 0;
        for (Soldado soldado : this.misSoldados) {
            if(soldado.getFila()==filaActual && soldado.getColumna().equals(convertirAAbecedario(colActual))){
                return cont;
            }
            cont++;
        }
        
        return -1;
        
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

    public ArrayList<Soldado> getMisSoldados() {
        return misSoldados;
    }
    public String toString(){
        return    "Espadachines : "+cantEspadachines+
                "\nArqueros     : "+cantArquero+
                "\nCaballeros   : "+cantCaballeros+
                "\nLanceros     : "+cantLanzeros;
    }
    public int contadorSoldados(){
        int cont =0;
        for (Soldado soldado : this.misSoldados) {
            cont++;
        }
        return cont;
    }

    public int getCantEspaReal() {
        return cantEspaReal;
    }

    public void setCantEspaReal(int cantEspaReal) {
        this.cantEspaReal = cantEspaReal;
    }

    public int getCantCabaMoro() {
        return cantCabaMoro;
    }

    public void setCantCabaMoro(int cantCabaMoro) {
        this.cantCabaMoro = cantCabaMoro;
    }

    public int getCantEspaConquistador() {
        return cantEspaConquistador;
    }

    public void setCantEspaConquistador(int cantEspaConquistador) {
        this.cantEspaConquistador = cantEspaConquistador;
    }

    public int getCantCabaFranco() {
        return cantCabaFranco;
    }

    public void setCantCabaFranco(int cantCabaFranco) {
        this.cantCabaFranco = cantCabaFranco;
    }
    
}
