/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio17;

import java.util.*;

public class VideoJuego {
    public static void main(String[] args){
        Mapa mapa = new Mapa();
        mapa.elegirTerritorio();
        mapa.asignarNombreReinos();
        
        mapa.ingresarEjercitos();
        int cantReino1 =mapa.getCantidadEjercitos1();
        System.out.println("Reino : "+mapa.getNombreReino1()+" => "+ cantReino1);
        
        int cantReino2 =mapa.getCantidadEjercitos2();
        System.out.println("Reino : "+mapa.getNombreReino2()+" => "+ cantReino2);
        
        
        System.out.println("\n\t\t\t*********"+mapa.getTerritorio()+"*********\n");
        
        mapa.bonus();
        System.out.println("---Se agrego una bonificacion +1 a los soldados del reino , por ser su territorio---");
        mapa.llenarTablero();
        
        
        
        while(mapa.getReino1().size()>=1 && mapa.getReino2().size()>=1){
            
            System.out.println(" \nTURNO  =>  "+mapa.getNombreReino1()+" :---------------------------------------");
            int ubicacion_Nuevo = juegoEjercito(mapa.getReino1(), mapa.getReino2(), 1);
            
            if(hayPelea(mapa.getReino2(),ubicacion_Nuevo)){
                System.out.println("\n ---------Batalla---------");
                batallaSoldado(mapa,ubicacion_Nuevo);
            }
            mapa.llenarTablero();
            
            if (mapa.getReino1().isEmpty()) {
                System.out.println("GANADOR : EJERCITO 2 \n");
            } else if (mapa.getReino2().isEmpty()) {
                System.out.println("GANADOR : EJERCITO 1 \n");
            }
            System.out.println(" \nTURNO  =>  "+mapa.getNombreReino2()+" :---------------------------------------");
            int ubicacion_Nuevo2 =juegoEjercito(mapa.getReino2(), mapa.getReino1(), 2);
            
            if(hayPelea(mapa.getReino1(),ubicacion_Nuevo2)){
                System.out.println("\n ---------Batalla---------");
                batallaSoldado(mapa,ubicacion_Nuevo2);
            }
            mapa.llenarTablero();
            if (mapa.getReino1().isEmpty()) {
                System.out.println("GANADOR : EJERCITO 2 \n");
            } else if (mapa.getReino2().isEmpty()) {
                System.out.println("GANADOR : EJERCITO 1 \n");
            }
        }
        
        
    }
    
    public static int juegoEjercito(ArrayList<Ejercito> principal, ArrayList<Ejercito> secundario , int numeroDeEjercito){
        Scanner sc = new Scanner (System.in);
        
        //elegir ejercito
        int ubicacion_Actual=0;
        do{
            System.out.print("Elige la posicion de un ejercito(ej A4):");
            String posicionGuerrero = sc.next();
            ubicacion_Actual = convertirStringANumero(posicionGuerrero); //fila columna
            
            if(!verificarPosicion(ubicacion_Actual, principal)){
                System.out.println("No existe un ejercito en esa posicion");
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
        moverGuerrero(principal, ubicacion_Actual,ubicacion_Nuevo);
        return ubicacion_Nuevo;
        
    }
    public static int hallarIndiceArray(ArrayList<Ejercito> reino, int posicion) {
        int filaActual = posicion / 10;
        int colActual = posicion % 10;
        int cont = 0;

        for (Ejercito ejer : reino) {
            if (ejer.getFila() == filaActual && ejer.getColumna() == colActual) {
                return cont;
            }
            cont++;
        }
        return -1;
    }

    public static void batallaSoldado(Mapa mapa, int posicion){
        
        Random rand = new Random();
        int num = rand.nextInt(100)+1;
        
        int indicePrin  =hallarIndiceArray(  mapa.getReino1(),  posicion);
        int indiceSecun =hallarIndiceArray(  mapa.getReino2(),  posicion);
        
        int vida1 = mapa.getReino1().get(indicePrin).obtenerSumaNV();
        int vida2 = mapa.getReino2().get(indiceSecun).obtenerSumaNV();
        
        double cantidad = vida1+vida2;
        double probabilidad= vida1*100/cantidad;
        double factor = Math.pow(10, 1);//1 es el numero de decimales
        probabilidad = Math.round(probabilidad * factor) / factor;
        //double probabilidad_segundo = 100- probabilidad;
        
        System.out.println("\t\t"+mapa.getNombreReino1()+"        "+mapa.getNombreReino2());
        System.out.println(   "Vida:	  	"+vida1+"\t\t"+vida2);
        System.out.println("Probabilidad:  "+probabilidad+"%\t"+"\t"+(100- probabilidad)+"%");
        
        if(num<=probabilidad){
            System.out.println("Gano : "+mapa.getNombreReino1() );
            System.out.println("Muere: "+mapa.getNombreReino2());
            mapa.getReino2().remove(indiceSecun);
            
            mapa.getReino1().get(indicePrin).aumentarNV();
            
            System.out.println("Vida +1" );
        }else{
            System.out.println("Gano : "+mapa.getNombreReino2());
            System.out.println("Muere: "+mapa.getNombreReino1() );
            mapa.getReino1().remove(indicePrin);
            
            mapa.getReino2().get(indiceSecun).aumentarNV();
            System.out.println("Vida +1" );
        }
    }
    
    
    public static boolean hayPelea(ArrayList<Ejercito> reino2, int posicion){
        int filaActual = posicion / 10;
        int colActual = posicion % 10 ;
        for (Ejercito ejer : reino2) {
            if(ejer.getFila()==filaActual && ejer.getColumna()==colActual){
                return true;
            }
        }
        return false;
    }
    public static void moverGuerrero(ArrayList<Ejercito> reino,int poActual, int poNueva){
        
        int indice = hallarIndiceArray( reino, poActual);
        
        
        Ejercito  nuevo = reino.remove(indice);
        int filan = poNueva / 10;
        int coln = poNueva %10;
        
        nuevo.setFila(filan);
        nuevo.setColumna(coln);
        reino.add(nuevo); 

    }
    
    public static boolean nopuedeMoverse( int poActual, int poNueva) {
        int fila1 = poActual / 10;
        int colum1 = poActual % 10; // Modificar esta línea para obtener la columna correctamente

        int fila2 = poNueva / 10;
        int colum2 = poNueva % 10; // Modificar esta línea para obtener la columna correctamente
        
        return Math.abs(fila1 - fila2) > 1 || Math.abs(colum1 - colum2) > 1;
    }
    
    
    public static boolean verificarPosicion(int ubicacion_Actual, ArrayList<Ejercito> principal){
        int fila = ubicacion_Actual/10;
        int columna = ubicacion_Actual%10;
        
        for (Ejercito ejer : principal) {
            if(ejer.getFila()==fila && ejer.getColumna()==columna){
                return  true;
            }
        }
        
        return false;
        
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
}
