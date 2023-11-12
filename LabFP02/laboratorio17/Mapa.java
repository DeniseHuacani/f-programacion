/*
Laboratorio 17
Nombre : Huacani Jara Denise Andrea
 */
package laboratorio17;
import java.util.ArrayList;
import java.util.Random;
public class Mapa {
    
    private ArrayList<Ejercito> reino1 = new ArrayList<>();
    private ArrayList<Ejercito> reino2 = new ArrayList<>();
    
    
    private String nombreReino1 ;
    private String nombreReino2 ;
    
    private String territorio;
    
    private int cantidadEjercitos1 =0;
    private int cantidadEjercitos2 =0;
    private int cantidadSoldadoPorEjercito;
    
    
    public static final String BLUE = "\u001B[34m";
    public static final String WHITE = "\u001B[37m";
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

    
    public void elegirTerritorio(){
        Random ran = new Random();
        int numero = ran.nextInt(5);
        switch (numero){
            case 0 -> territorio ="BOSQUE";
            case 1 -> territorio ="CAMPO ABIERTO";
            case 2 -> territorio ="MONTAÑA";
            case 3 -> territorio ="DESIERTO";
            case 4 -> territorio ="PLAYA";
        }
    }
    public String elegirNombresReino() {
        Random random = new Random();
        int numero1 = random.nextInt(5);
        switch (numero1) {
            case 4:
                return "Inglaterra";
            case 3:
                return "Francia";
            case 2:
                return "Sacro Imperio Romano-Germánico";
            case 1:
                return "Castilla-Aragon"; 
            case 0:
                return "Moros";
        }
        return "";
    }
    public void asignarNombreReinos(){
        nombreReino1=elegirNombresReino();
        nombreReino2=elegirNombresReino();
        while(nombreReino1.equals(nombreReino2)){
            nombreReino2=elegirNombresReino();
        }
    }

    public  void ingresarEjercitos( ) {
        Random random = new Random();
        int n = random.nextInt(10)+1;
        cantidadEjercitos1=n;
        for(int i =0; i<n ; i++){
            int fila;
            int colum;
            do{
                fila  = random.nextInt(10);//del 0 al 9
                colum = random.nextInt(10);

            }while(posicionOcupada(fila, colum, reino2  )|| posicionOcupada(fila, colum, reino1  ));
            Ejercito nuevo = new Ejercito( fila,colum);
            nuevo.llenarEjercito();
            reino1.add( nuevo);
        }
        int m = random.nextInt(10)+1;
        cantidadEjercitos2=m;
        for(int i =0; i<m ; i++){
            int fila;
            int colum;
            do{
                fila  = random.nextInt(10);//del 0 al 9
                colum = random.nextInt(10);

            }while(posicionOcupada(fila, colum, reino1  )|| posicionOcupada(fila, colum, reino2  ));
            Ejercito nuevo2 = new Ejercito( fila,colum);
            nuevo2.llenarEjercito();
            reino2.add( nuevo2);
        }
        
    }
    
    
    
    public static  boolean posicionOcupada(int fila, int columna, ArrayList<Ejercito> reino) {
        for (Ejercito ejer : reino) {
            if (ejer.getFila() == fila && ejer.getColumna() == columna) {
                return true;
            }
        }
        return false;
    }
    
    
    public void  llenarTablero(){
        String[][] array= new String[10][10];
        System.out.println("    A     B     C     D     E     F     G      H     I     J");
        System.out.println("   _____________________________________________________________");
        for(int i =0; i<10; i++){
            if(i==9)
                System.out.print((i+1)+" ");
            else
                System.out.print((i+1)+"  ");
            for(int j =0; j<10; j++){
                if (existeEjercito(i,j, reino1) || existeEjercito(i,j, reino2) ) {
                    if(existeEjercito(i,j, reino1)){
                        array[i][j] = "|" + RED + imprimirDatos(i, j, reino1) + RESET;
                    }
                    else if (existeEjercito(i,j, reino2)){
                        array[i][j] = "|" + BLUE + imprimirDatos(i, j, reino2) + RESET;
                    }
                } else {
                    array[i][j] = "|" + WHITE + "     " + RESET;
                }
                System.out.print(array[i][j]);
            }
            System.out.print("|");
            System.out.println();
            System.out.println("   _____________________________________________________________");
        }
    } 
    public static boolean  existeEjercito(int fi, int co, ArrayList<Ejercito> reino){
        for (Ejercito ejer : reino) {
            if (ejer.getFila() == fi && ejer.getColumna() == co) {
                return true;
            }
        }
        return false;
    }
    public static  String imprimirDatos(int fi, int co, ArrayList<Ejercito> reino){
        for (Ejercito ejer : reino) {
            if (ejer.getFila() == fi && ejer.getColumna() == co) {
                int cant=ejer.getCantidadSoldados();
                String num = ""+cant;
                if(cant<10){
                    num= " "+cant;
                }
                int sum = ejer.obtenerSumaNV();
                String suma = ""+sum;
                if(sum<10){
                    suma =" "+sum;
                }
                return num+"-"+suma;
            }
        }
        return "";
    }
    public  void bonus(  ){
        
        switch(territorio){
            case "BOSQUE":
                if( (nombreReino1.equals("Inglaterra")|| nombreReino1.equals("Sacro Imperio Romano-Germánico")) ){
                    System.out.println("Ventaja para el reino de "+nombreReino1);
                    aumentarNV(reino1);
                }if((nombreReino2.equals("Inglaterra")|| nombreReino2.equals("Sacro Imperio Romano-Germánico"))){
                    System.out.println("Ventaja para el reino de : "+nombreReino2);
                    aumentarNV(reino2);
                }
                break;
            case "CAMPO ABIERTO":
                if( (nombreReino1.equals("Francia")|| nombreReino1.equals("Sacro Imperio Romano-Germánico")) ){
                     System.out.println("Ventaja para el reino de "+nombreReino1);
                    aumentarNV(reino1);
                }if((nombreReino2.equals("Francia")|| nombreReino2.equals("Sacro Imperio Romano-Germánico"))){
                    System.out.println("Ventaja para el reino de : "+nombreReino2);
                    aumentarNV(reino2);
                }
                break;
            case "MONTAÑA":
                if((nombreReino1.equals("Castilla-Aragon"))){
                     System.out.println("Ventaja para el reino de "+nombreReino1);
                    aumentarNV(reino1);
                }if((nombreReino2.equals("Castilla-Aragon"))){
                    System.out.println("Ventaja para el reino de : "+nombreReino2);
                    aumentarNV(reino2);
                }
                break;
            case "DESIERTO":
                if( (nombreReino1.equals("Moros"))){
                     System.out.println("Ventaja para el reino de "+nombreReino1);
                    aumentarNV(reino1);
                }if( (nombreReino2.equals("Moros"))){
                    System.out.println("Ventaja para el reino de : "+nombreReino2);
                    aumentarNV(reino2);
                }
                break;
            case "PLAYA":
                if(( nombreReino1.equals("Sacro Imperio Romano-Germánico")) ){
                     System.out.println("Ventaja para el reino de :"+nombreReino1);
                    aumentarNV(reino1);
                }if( ( nombreReino2.equals("Sacro Imperio Romano-Germánico"))){
                     System.out.println("Ventaja para el reino de  : "+nombreReino2);
                    aumentarNV(reino2);
                }
                break;
        }
    }
    public static  void aumentarNV(ArrayList<Ejercito> reino){
        for (Ejercito ejer : reino) {
            ejer.aumentarNV();
        }
    }

    public String getNombreReino1() {
        return RED+nombreReino1+RESET;
    }

    public String getNombreReino2() {
        return BLUE+nombreReino2+RESET;
    }

    public String getTerritorio() {
        return territorio;
    }

    public int getCantidadEjercitos1() {
        return cantidadEjercitos1;
    }
    public int getCantidadEjercitos2() {
        return cantidadEjercitos2;
    }

    public int getCantidadSoldadoPorEjercito() {
        return cantidadSoldadoPorEjercito;
    }
    public ArrayList<Ejercito> getReino1() {
        return reino1;
    }

    public ArrayList<Ejercito> getReino2() {
        return reino2;
    }
    
}