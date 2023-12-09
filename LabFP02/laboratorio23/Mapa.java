/*
Laboratorio 22
ombre :Denise Andrea Huacani Jara
 */
package laboratorio23;


import java.util.*;
public class Mapa {
    private Ejercitos reino1 =new Ejercitos();
    private Ejercitos reino2 =new Ejercitos();
    private String nombreReino1 ;
    private String nombreReino2 ;
    
    private String territorio;
    private int cantidadSoldadoReino1;
    private int cantidadSoldadoReino2;
    
    public static final String BLUE = "\u001B[34m";
    public static final String WHITE = "\u001B[37m";
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

    public Mapa(){
        asignarNombreReinos();
        elegirTerritorio();
        llenarReino();
    }
    
    
    public void añadirSoldadosEspeciales( ){
        switch (nombreReino1){
            case "Inglaterra":
                añadirEspadachinReal(1);
                break;
            case "Francia":
                añadirCaballeroFranco(1);
                break;
            case "Sacro Imperio Romano-Germánico":
                añadirEspadachinTeutonio(1);
                break;
            case "Castilla-Aragon":
                añadirEspadachinConquistador(1);
                break;
            case "Moros":
                añadirCaballeroMoro(1);
                break;
            default:
        }
        switch (nombreReino2){
            case "Inglaterra":
                añadirEspadachinReal(2);
                break;
            case "Francia":
                añadirCaballeroFranco(2);
                break;
            case "Sacro Imperio Romano-Germánico":
                añadirEspadachinTeutonio(2);
                break;
            case "Castilla-Aragon":
                añadirEspadachinConquistador(2);
                break;
            case "Moros":
                añadirCaballeroMoro(2);
                break;
            default:
        }
    }
    public void añadirEspadachinReal(int numero){
        if(numero ==1){
            
            reino1.agregarEspecialAleatorio(numero, "Real" , reino2);
        }else{
            reino2.agregarEspecialAleatorio(numero, "Real" , reino1);
        }
        
    }
    public void añadirCaballeroFranco(int numero){
        if(numero ==1){
            reino1.agregarEspecialAleatorio(numero, "Franco" , reino2);
        }else{
            reino2.agregarEspecialAleatorio(numero, "Franco" , reino1);
        }
    }
    public void añadirEspadachinTeutonio(int numero){
        if(numero ==1){
            reino1.agregarEspecialAleatorio(numero, "Teutonio" , reino2);
        }else{
            reino2.agregarEspecialAleatorio(numero, "Teutonio" , reino1);
        }
    }
    public void añadirEspadachinConquistador(int numero){
        if(numero ==1){
            reino1.agregarEspecialAleatorio(numero, "Conquistador" , reino2);
        }else{
            reino2.agregarEspecialAleatorio(numero, "Conquistador" , reino1);
        }
    }
    public void añadirCaballeroMoro(int numero){
        if(numero ==1){
            reino1.agregarEspecialAleatorio(numero, "Moro" , reino2);
        }else{
            reino2.agregarEspecialAleatorio(numero, "Moro" , reino1);
        }
    }
    
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
    public String  llenarTablero(){
        StringBuilder result = new StringBuilder();
        String[][] array= new String[10][10];
        result.append("            A         B         C         D         E         F         G         H         I         J\n");
        result.append("       ___________________________________________________\n");
        for(int i =0; i<10; i++){
            if(i==9)
                result.append("\n "+(i+1)+" ");
            else
                result.append("\n "+(i+1)+"   ");
            for(int j =0; j<10; j++){
                if ( reino1.existeSoldado(i+1,j) ||  reino2.existeSoldado(i+1,j) ) {
                    if(reino1.existeSoldado(i+1,j)){
                        array[i][j] = "|o "  + reino1.imprimirDatos(i+1, j) +"" ;
                    }
                    else if (  reino2.existeSoldado(i+1,j)){
                        array[i][j] = "|x "  + reino2.imprimirDatos(i+1, j) +"" ;
                    }
                } else {
                    array[i][j] = "|" + "           " ;
                }
                result.append(array[i][j]);
            }
            result.append("|\n");
            result.append("      ___________________________________________________");
        }
        return result.toString();
    } 
    public void llenarReino() {
        reino1.llenarEjercito(1, reino2);
        cantidadSoldadoReino1=reino1.getCantidadSoldados();
        reino2.llenarEjercito(2, reino1);
        cantidadSoldadoReino2=reino2.getCantidadSoldados();
    }
    
    public  void bonus(  ){
        /*
        Map<String,String> mapa = new HashMap<String, String>();
        mapa.put("BOSQUE","Inglaterra")*/;
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
    public void mostrarSoldados(){
         System.out.println("--------------"+Ejercitos.getNombre("Ejercito 1 :Mostrar Soldados ", "ROJO")+"-----------------");
            reino1.mostrarSoldados();
            System.out.println("--------------"+Ejercitos.getNombre("Ejercito 2 :Mostrar Soldados", "AZUL")+"-----------------");
            reino2.mostrarSoldados();
    }

    
    
    public  boolean hayPelea( int posicion){
        int filaActual = posicion / 10+1;
        int colActual = posicion % 10 ;
        return (reino2.existeSoldado( filaActual,  colActual)) && (reino1.existeSoldado( filaActual,  colActual));
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