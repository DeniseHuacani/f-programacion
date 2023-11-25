/*
Laboratorio 21 
Nombre Denise Andrea Huacani jara
 */
package laboratorio21;

import java.util.ArrayList;
import java.util.Random;
public class Mapa {
    private Ejercitos reino1 =new Ejercitos();
    private Ejercitos reino2 =new Ejercitos();//estandar
    private String nombreReino1 ;
    private String nombreReino2 ;
    
    private String territorio;
    private int cantidadSoldadoReino1;
    private int cantidadSoldadoReino2;
    
    
    
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
    private String elegirNombresReino() {
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

    
    public void  llenarTablero(){
        String[][] array= new String[10][10];
        System.out.println("     A    B    C    D    E    F    G     H    I    J");
        System.out.println("   ___________________________________________________");
        for(int i =0; i<10; i++){
            if(i==9)
                System.out.print((i+1)+" ");
            else
                System.out.print((i+1)+"  ");
            for(int j =0; j<10; j++){
                if ( reino1.existeSoldado(i+1,j) ||  reino2.existeSoldado(i+1,j) ) {
                    if(reino1.existeSoldado(i+1,j)){
                        array[i][j] = "| " + RED + reino1.imprimirDatos(i+1, j) +" " +RESET;
                    }
                    else if (  reino2.existeSoldado(i+1,j)){
                        array[i][j] = "| " + BLUE + reino2.imprimirDatos(i+1, j) +" " + RESET;
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
    public void llenarReino() {
        reino1.llenarEjercito(1, reino2);
        cantidadSoldadoReino1=reino1.getCantidadSoldados();
        reino2.llenarEjercito(2, reino1);
        cantidadSoldadoReino2=reino2.getCantidadSoldados();
    }
    
    public  void bonus(  ){
        
        switch(territorio){
            case "BOSQUE":
                if( (nombreReino1.equals("Inglaterra")|| nombreReino1.equals("Sacro Imperio Romano-Germánico")) ){
                    System.out.println("Ventaja para el reino de "+getNombreReino1());
                    
                    reino1.aumentarNV();
                }if((nombreReino2.equals("Inglaterra")|| nombreReino2.equals("Sacro Imperio Romano-Germánico"))){
                    System.out.println("Ventaja para el reino de : "+getNombreReino2());
                    reino2.aumentarNV();
                }
                break;
            case "CAMPO ABIERTO":
                if( (nombreReino1.equals("Francia")|| nombreReino1.equals("Sacro Imperio Romano-Germánico")) ){
                     System.out.println("Ventaja para el reino de "+getNombreReino1());
                    reino1.aumentarNV();
                }if((nombreReino2.equals("Francia")|| nombreReino2.equals("Sacro Imperio Romano-Germánico"))){
                    System.out.println("Ventaja para el reino de : "+getNombreReino2());
                    reino2.aumentarNV();
                }
                break;
            case "MONTAÑA":
                if((nombreReino1.equals("Castilla-Aragon"))){
                     System.out.println("Ventaja para el reino de "+getNombreReino1());
                    reino1.aumentarNV();
                }if((nombreReino2.equals("Castilla-Aragon"))){
                    System.out.println("Ventaja para el reino de : "+getNombreReino2());
                    reino2.aumentarNV();
                }
                break;
            case "DESIERTO":
                if( (nombreReino1.equals("Moros"))){
                     System.out.println("Ventaja para el reino de "+getNombreReino1());
                    reino1.aumentarNV();
                }if( (nombreReino2.equals("Moros"))){
                    System.out.println("Ventaja para el reino de : "+getNombreReino2());
                    reino2.aumentarNV();
                }
                break;
            case "PLAYA":
                if(( nombreReino1.equals("Sacro Imperio Romano-Germánico")) ){
                     System.out.println("Ventaja para el reino de :"+getNombreReino1());
                    reino1.aumentarNV();
                }if( ( nombreReino2.equals("Sacro Imperio Romano-Germánico"))){
                     System.out.println("Ventaja para el reino de  : "+getNombreReino2());
                    reino2.aumentarNV();
                }
                break;
        }
    }
    public void  mayorNV(){
        System.out.println("--------------Ejercito 1:Mayor nivel de vida---------------");
        reino1.mayorNV();
        System.out.println("--------------Ejercito 2:Mayor nivel de vida---------------");
        reino2.mayorNV();
    }
    public void promedioNVTodos(){
        System.out.println("--------------Ejercito 1:Promedio de nivel de vida----------");
        System.out.println(reino1.promedioNVTodos());
        System.out.println("--------------Ejercito 2:Promedio de nivel de vida----------");
        System.out.println(reino2.promedioNVTodos());
    }
    public void ordenarCreadosPorNombre(){
        System.out.println("--------------Ejercito 1:Soldado Ordenados por Nombre----------");
        reino1.ordenarCreadosNombre();
        System.out.println("--------------Ejercito 2:Soldado Ordenados por Nombre----------");
        reino2.ordenarCreadosNombre();
    }
    public void ordenarPorNV(){
        System.out.println("--------------Ejercito 1:Soldado Ordenados por Nivel Vida----------");
        reino1.ordenarEjercitoPorNivelVidaBurbuja();
        System.out.println("--------------Ejercito 2:Soldado Ordenados por Nivel Vida----------");
        reino2.ordenarEjercitoPorNivelVidaBurbuja();
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

    

    public int getCantidadSoldadoReino1() {
        return cantidadSoldadoReino1;
    }
    public int getCantidadSoldadoReino2() {
        return cantidadSoldadoReino2;
    }
    public String toString(){
        return  "\nEjercito 1 :"+getNombreReino1()+"\n"+
                "Cantidad total de soldados creados:"+getCantidadSoldadoReino1()+"\n"+
                reino1.toString()+"\n"+
                "\nEjercito 2 :"+getNombreReino2()+"\n"+
                "Cantidad total de soldados creados:"+getCantidadSoldadoReino2()+"\n"+
                reino2.toString();
    }

    public Ejercitos getReino1() {
        return reino1;
    }

    public Ejercitos getReino2() {
        return reino2;
    }
    
    
}