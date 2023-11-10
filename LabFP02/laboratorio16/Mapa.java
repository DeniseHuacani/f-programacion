/*
Laboratorio 16
Nombre : Huacani Jara Denise Andrea
 */
package laboratorio16;
import java.util.*;
public class Mapa {
    
    private static String nombreReino1 ;
    private static String nombreReino2 ;
    private static String territorio;
    private static int cantidadEjercitos =0;
    private int cantidadSoldadoPorEjercito;
    
    
    
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

    public static  void ingresarEjercitos(ArrayList<Ejercito> reino, ArrayList<Ejercito> otroreino) {
        Random random = new Random();
        int n = random.nextInt(10)+1;
        cantidadEjercitos=n;
        for(int i =0; i<n ; i++){
            int fila;
            int colum;
            do{
                fila  = random.nextInt(10);//del 0 al 9
                colum = random.nextInt(10);

            }while(posicionOcupada(fila, colum, otroreino));
            Ejercito newEjercito = new Ejercito( fila,colum);
            newEjercito.llenarEjercito();
            reino.add( newEjercito);
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
    
    
    public static void  llenarTablero(ArrayList<Ejercito> reino1, ArrayList<Ejercito> reino2 ){
        String[][] array= new String[10][10];
        System.out.println("    A      B      C      D      E      F      G       H      I      J");
        System.out.println("   ______________________________________________________________________");
        for(int i =0; i<10; i++){
            if(i==9)
                System.out.print((i+1)+" ");
            else
                System.out.print((i+1)+"  ");
            for(int j =0; j<10; j++){
                if (existeEjercito(i,j, reino1) || existeEjercito(i,j, reino2) ) {
                    if(existeEjercito(i,j, reino1)){
                        array[i][j] ="|"+imprimirDatos(i, j,  reino1)+"#";
                    }
                    else if (existeEjercito(i,j, reino2)){
                        array[i][j] = "|"+imprimirDatos(i, j,  reino2)+"&";
                    }
                    
                } else {
                    array[i][j] = "|      ";
                }
                System.out.print(array[i][j]);
            }
            System.out.print("|");
            System.out.println();
            System.out.println("   ______________________________________________________________________");
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
    public static  void bonus(ArrayList<Ejercito> reino ,ArrayList<Ejercito> reino2 ){
        
        switch(territorio){
            case "BOSQUE":
                if( (nombreReino1.equals("Inglaterra")|| nombreReino1.equals("Sacro Imperio Romano-Germánico")) ){
                    System.out.println("Ventaja para el reino de "+nombreReino1);
                    aumentarNV(reino);
                }if((nombreReino2.equals("Inglaterra")|| nombreReino2.equals("Sacro Imperio Romano-Germánico"))){
                    System.out.println("Ventaja para el reino de : "+nombreReino2);
                    aumentarNV(reino2);
                }
                break;
            case "CAMPO ABIERTO":
                if( (nombreReino1.equals("Francia")|| nombreReino1.equals("Sacro Imperio Romano-Germánico")) ){
                     System.out.println("Ventaja para el reino de "+nombreReino1);
                    aumentarNV(reino);
                }if((nombreReino2.equals("Francia")|| nombreReino2.equals("Sacro Imperio Romano-Germánico"))){
                    System.out.println("Ventaja para el reino de : "+nombreReino2);
                    aumentarNV(reino2);
                }
                break;
            case "MONTAÑA":
                if((nombreReino1.equals("Castilla-Aragon"))){
                     System.out.println("Ventaja para el reino de "+nombreReino1);
                    aumentarNV(reino);
                }if((nombreReino2.equals("Castilla-Aragon"))){
                    System.out.println("Ventaja para el reino de : "+nombreReino2);
                    aumentarNV(reino2);
                }
                break;
            case "DESIERTO":
                if( (nombreReino1.equals("Moros"))){
                     System.out.println("Ventaja para el reino de "+nombreReino1);
                    aumentarNV(reino);
                }if( (nombreReino2.equals("Moros"))){
                    System.out.println("Ventaja para el reino de : "+nombreReino2);
                    aumentarNV(reino2);
                }
                break;
            case "PLAYA":
                if(( nombreReino1.equals("Sacro Imperio Romano-Germánico")) ){
                     System.out.println("Ventaja para el reino de :"+nombreReino1);
                    aumentarNV(reino);
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
        return nombreReino1;
    }

    public String getNombreReino2() {
        return nombreReino2;
    }

    public String getTerritorio() {
        return territorio;
    }

    public int getCantidadEjercitos() {
        return cantidadEjercitos;
    }

    public int getCantidadSoldadoPorEjercito() {
        return cantidadSoldadoPorEjercito;
    }
    
}
