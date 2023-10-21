/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio11;
import java.util.*;
public class VideoJuego8 {
    public static void main(String[] args){
        Scanner sc = new Scanner ( System.in);
        String respuesta ="";
        while(!respuesta.equals("N")){
            Map<Integer,Soldado> ejercito1 = new HashMap<Integer, Soldado>();
            Map<Integer,Soldado> ejercito2 = new HashMap<Integer, Soldado>();
            System.out.print("@ :Ejercito 1 : ");
            ingresarDatosSoldados(ejercito1, ejercito2, 1);
            System.out.print("# :Ejercito 2 : ");
            ingresarDatosSoldados(ejercito2, ejercito1, 2);
            llenarTableroEquipo(ejercito1,ejercito2);
            /*
            System.out.println("--------------------------------------------------------");
            System.out.println("\nSoldado con mayor nivel de vida del Equipo 1 ");
            int mayor_nivel =mayorNV(ejercito1);
            buscarSoldado(ejercito1, mayor_nivel);
            System.out.println("\nSoldado con mayor nivel de vida del Equipo 2 ");
            mayor_nivel =mayorNV(ejercito2);
            buscarSoldado(ejercito2, mayor_nivel);


            System.out.println("--------------------------------------------------------");
            System.out.print("Promedio del nivel de vida del Equipo 1 :");
            System.out.println(promedioNVTodos(ejercito1));
            System.out.print("Promedio del nivel de vida del Equipo 2 :");
            System.out.println(promedioNVTodos(ejercito2));

            System.out.println("--------------------------------------------------------");
            System.out.println("Ejercito 1 ordenado :");
            System.out.println("---------------");
            ordenarCreadosNombre(ejercito1);
            System.out.println("Ejercito 2 ordenado :");
            System.out.println("---------------");
            ordenarCreadosNombre(ejercito2);

            System.out.println("--------------------------------------------------------");
            System.out.println("Ordenados por metodo burbuja Nivel de Vida\n ");
            System.out.println("Ejercito 1 ordenado :");
            System.out.println("---------------");
            ordenarPuntosBurbuja(ejercito1);
            System.out.println("Ejercito 2 ordenado :");
            System.out.println("---------------");
            ordenarPuntosBurbuja(ejercito2);

            System.out.println("--------------------------------------------------------");
            System.out.println("Ordenados por metodo Seleccion Nivel de Vida\n ");
            System.out.println("Ejercito 1 ordenado :");
            System.out.println("---------------");
            ordenarPuntosSeleccion(ejercito1);
            System.out.println("Ejercito 2 ordenado :");
            System.out.println("---------------");
            ordenarPuntosSeleccion(ejercito2);
            */
            while(ejercito1.size()>=1 && ejercito2.size()>=1){
                System.out.println("Ejercito 1:---------------------------------------");
                System.out.print("Elige la posicion de un guerrero(ej A4):");
                String poguerrero = sc.next();
                int ubicacionGuerrero_Actual = posicion(poguerrero);
                while(ubicacionGuerrero_Actual==-1){
                    System.out.print("Elige la posicion de un guerrero(ej A4):");
                    poguerrero = sc.next();
                    ubicacionGuerrero_Actual = posicion(poguerrero);
                }
                //ingresar a donde ira
                System.out.println("Solo puede moverse un casillero , "
                        + "en cualquier direccion(diagonal , avanzar , retroceder)");
                System.out.print("Elige la posicion a donde se movera el guerrero(ej A4):");
                String guerreroNuevo = sc.next();
                
                int ubicacionGuerrero_Nuevo =posicion(guerreroNuevo);
                if(nopuedeMoverse( ejercito1, ubicacionGuerrero_Actual,  ubicacionGuerrero_Nuevo)){
                    ubicacionGuerrero_Nuevo=-1;
                    System.out.println("El soldado solo puede recorrer un espacio");
                }
                while(ubicacionGuerrero_Nuevo==-1){
                    System.out.println("Solo puede moverse un casillero , "
                            + "en cualquier direccion(diagonal , avanzar , retroceder)");
                    System.out.print("Elige la posicion a donde se movera el guerrero(ej A4):");
                    guerreroNuevo = sc.next();
                    ubicacionGuerrero_Nuevo = posicion(guerreroNuevo);
                    if(nopuedeMoverse( ejercito1, ubicacionGuerrero_Actual,  ubicacionGuerrero_Nuevo)){
                        ubicacionGuerrero_Nuevo=-1;
                        System.out.println("El soldado solo puede recorrer un espacio");
                    }
                }
                moverGuerrero(ejercito1, ubicacionGuerrero_Actual,ubicacionGuerrero_Nuevo);
                if(hayPelea(ejercito1,ejercito2,ubicacionGuerrero_Nuevo)){
                    System.out.println("\n\nBatalla!!!!!!!!!!!!!");
                    batallaSoldado(ejercito1,ejercito2,ubicacionGuerrero_Nuevo);
                }
                llenarTableroEquipo(ejercito1,ejercito2);
                
                System.out.println("Ejercito 2:---------------------------------------");
                System.out.print("Elige la posicion de un guerrero(ej A4):");
                String poguerrero2 = sc.next();
                int posicionGuerrero2 = posicion(poguerrero2);
                while(posicionGuerrero2==-1){
                    poguerrero2 = sc.next();
                    posicionGuerrero2 = posicion(poguerrero2);
                }
                System.out.println("Solo puede moverse un casillero , "
                        + "en cualquier direccion(diagonal , avanzar , retroceder)");
                System.out.print("Elige la posicion a donde se movera el guerrero(ej A4):");
                guerreroNuevo = sc.next();
                int posicionNueva2 =posicion(guerreroNuevo);
                if(nopuedeMoverse( ejercito1, posicionGuerrero2,  posicionNueva2)){
                    posicionNueva2=-1;
                    System.out.println("El soldado solo puede recorrer un espacio");
                }
                while(posicionNueva2==-1){
                    System.out.println("Solo puede moverse un casillero ,"
                            + " en cualquier direccion(diagonal , avanzar , retroceder)");
                    System.out.print("Elige la posicion a donde se movera el guerrero(ej A4):");
                    guerreroNuevo = sc.next();
                    posicionNueva2 = posicion(guerreroNuevo);
                    if(nopuedeMoverse( ejercito1, posicionGuerrero2,  posicionNueva2)){
                        posicionNueva2=-1;
                        System.out.println("El soldado solo puede recorrer un espacio");
                    }
                }
                moverGuerrero(ejercito2, posicionGuerrero2,posicionNueva2);
                if(hayPelea(ejercito1,ejercito2,posicionNueva2)){
                    System.out.println("\n\nBatalla!!!!!!!!!!!!!");
                    batallaSoldado(ejercito1,ejercito2,posicionNueva2);
                }
                
                llenarTableroEquipo(ejercito1,ejercito2);
            }
            if(ejercito1.size()==0){
                System.out.println("GANADOR : EJERCITO 2 ");
            }else
                System.out.println("GANADOR : EJERCITO 1 ");
            
            System.out.println();
            System.out.print("Desea volver a jugar ? (S/N):");
            respuesta = sc.next();
        }
             
    }
    public static void batallaSoldado(Map<Integer,Soldado> ejercito1,Map<Integer,Soldado> ejercito2, int posicion){
        
        Random rand = new Random();
        int num = rand.nextInt(100)+1;
        int vida1=ejercito1.get(posicion).getNivelVida();
        int vida2=ejercito2.get(posicion).getNivelVida();
        double cantidad = vida1+vida2;
        double probabilidad= vida1*100/cantidad;
        double factor = Math.pow(10, 1);//1 es el numero de decimales
        probabilidad = Math.round(probabilidad * factor) / factor;
        double probabilidad_segundo = 100- probabilidad;
        
        System.out.println("\t\tEjercito 1        Ejercito2");
        System.out.println(   "Vida:	  	"+vida1+"\t\t"+vida2);
        System.out.println("Probabilidad:  "+probabilidad+"%\t"+"\t"+(probabilidad_segundo+"%"));
        
        if(num<=probabilidad){
            System.out.println("Gano : "+ ejercito1.get(posicion).getNombre() );
            System.out.println("Muere: "+ejercito2.get(posicion).getNombre());
            ejercito2.remove(posicion);
            int nivel = ejercito1.get(posicion).getNivelVida();
            ejercito1.get(posicion).setNivelVida(nivel+1);
        }else{
            System.out.println("Gano : "+ ejercito2.get(posicion).getNombre() );
            System.out.println("El "+ejercito1.get(posicion).getNombre()+" muere");
            ejercito1.remove(posicion);
            int nivel = ejercito2.get(posicion).getNivelVida();
            ejercito2.get(posicion).setNivelVida(nivel+1);
        }
    }
    public static boolean hayPelea(Map<Integer,Soldado> ejercito1,Map<Integer,Soldado> ejercito2, int posicion){
        return (ejercito1.containsKey(posicion)&& ejercito2.containsKey(posicion) );
    }
    public static int posicion(String posicion){
        char letra = posicion.charAt(0); 
        int fila = Integer.parseInt(posicion.substring(1))-1; 

        // Convierte la letra a su valor numérico correspondiente (A=1, B=2, ..., Z=26)
        int columna = Character.toUpperCase(letra) - 'A' ;
        
        if(fila>=10 ){
            System.out.println("Fila no valida");
            return -1;
        }else if(columna >=10){
            System.out.println("Columna no valida");
            return -1;
        }
        int posicionNum = fila*10 + columna;//fila+ columa

        return posicionNum;
    }
    public static void moverGuerrero(Map<Integer,Soldado> ejercito,int poActual, int poNueva){
        if (ejercito.containsKey(poActual)) {
            Soldado soldado = ejercito.remove(poActual); // Elimina el soldado con la clave poActual
            if (!ejercito.containsKey(poNueva)) {
                int filan = poNueva / 10;
                int coln = poNueva - (filan * 10);
                soldado.setFila(filan);
                soldado.setColumna(coln);
                ejercito.put(poNueva, soldado); // Agrega el soldado con la nueva clave poNueva
            } else {
                System.out.println("Error: Ya hay un soldado en la posición " + poNueva);
            }
        } else {
            System.out.println("Error: No hay un soldado en la posición " + poActual);
        }
    }
    public static boolean nopuedeMoverse(Map<Integer, Soldado> ejercito, int poActual, int poNueva) {
        int fila1 = poActual / 10;
        int colum1 = poActual % 10; // Modificar esta línea para obtener la columna correctamente

        int fila2 = poNueva / 10;
        int colum2 = poNueva % 10; // Modificar esta línea para obtener la columna correctamente
        
        return Math.abs(fila1 - fila2) > 1 || Math.abs(colum1 - colum2) > 1;
    }

    public static  int random (int num){
        Random random = new Random ();
        return random.nextInt(num); 
    }
    public static void ingresarDatosSoldados(Map<Integer,Soldado> ejercito1,Map<Integer,Soldado> ejercito2,int n) {
        int cant =random (10)+1;
        System.out.println("Se creo "+ cant + " soldados");
        for ( int i =0; i < cant; i++){
            int fila  = random(10);//del 0 al 9
            int colum = random(10);
            int clave = fila*10+colum;  //23 es 2 fila , 3 colum
            while(ejercito1.containsKey(clave)&&ejercito2.containsKey(clave)){
                fila  = random(10);
                colum = random(10);
                clave = fila*10+colum;
            }String actitud ="";
            int num_actitud =random(3);
            if(num_actitud ==0){
                actitud ="defensiva";
            }else if ( num_actitud ==1){
                actitud = "Ofensiva";
            }else if ( num_actitud ==2){
                actitud = "Fuga";
            }String nombre = ("Soldado"+i+"X"+n);
            int nivelVida = (random(5)+1); 
            int nivelAtaque = (random(5)+1);
            int nivelDefensa= (random(5)+1);
            Soldado soldado = new Soldado(nombre, nivelVida, nivelAtaque, nivelDefensa,fila,colum,actitud);
            ejercito1.put(clave, soldado);
        }
    }
    
    public static void  llenarTableroEquipo(Map<Integer,Soldado> ejercito1,Map<Integer,Soldado> ejercito2){
        String[][] array= new String[10][10];
        String[] opcionesFiguras ={"@","#"};
        System.out.println("    A   B   C   D   E   F   G   H   I   J");
        System.out.println("   _______________________________________");
        for(int i =0; i<10; i++){
            if(i==9)
                System.out.print((i+1)+" ");
            else
                System.out.print((i+1)+"  ");
            for(int j =0; j<10; j++){
                int clave = i*10+j;
                if (ejercito1.containsKey(clave)|| ejercito2.containsKey(clave)) {
                    if(ejercito2.containsKey(clave)){
                        array[i][j] = "|"+ejercito2.get(clave).getNivelVida()+"x"+opcionesFiguras[1];
                    }else
                        array[i][j] = "|"+ejercito1.get(clave).getNivelVida()+"x"+opcionesFiguras[0];
                } else {
                    array[i][j] = "|   ";
                }
                System.out.print(array[i][j]);
            }
            System.out.print("|");
            System.out.println();
            System.out.println("   _________________________________________");
        }
    }
    
    public static int mayorNV(Map<Integer,Soldado> ejercito){
        int mayor =0;
        
        for(int i =0; i<10 ; i++){
            for(int j =0; j<10 ; j++){
                int clave = i*10+j;
                if(ejercito.containsKey(clave)){
                    int nivel =ejercito.get(clave).getNivelVida();
                    if(mayor<nivel){
                        mayor = nivel;
                    }
                }
            }
        }
        return mayor;
    }
    public static void buscarSoldado(Map<Integer,Soldado> ejercito,int numero){
        for(int i =0; i<10 ; i++){
            for(int j =0; j<10 ; j++){
                int clave = i*10+j;
                if(ejercito.containsKey(clave)){
                    if((ejercito.get(clave)).getNivelVida()==numero){
                        System.out.println("Nombre: " +ejercito.get(clave).getNombre());
                        System.out.println("Nivel de Vida: " +(ejercito.get(clave)).getNivelVida());
                        System.out.println("Fila: " +ejercito.get(clave).getFila());
                        System.out.println("Columna: " + ejercito.get(clave).getColumna());
                        System.out.println("Actitud: " + ejercito.get(clave).getActitud());
                        System.out.println("-----------");
                    }
                }
            }
        }
    }
    public static double promedioNVTodos(Map<Integer,Soldado> ejercito){
        double suma =0;
        int cont =0;
        for(int i =0; i<10 ; i++){
            for(int j =0; j<10 ; j++){
                int clave = i*10+j;
                if(ejercito.containsKey(clave)){
                    int nivel =ejercito.get(clave).getNivelVida();
                    suma+=nivel;
                    cont++;
                }
            }
        }
        return suma/cont;
    }
    public static void ordenarCreadosNombre(Map<Integer,Soldado> ejercito){
        int cont=ejercito.size();
        int m=0;
        while(m<cont){
            for( int i = 0 ; i< 10; i++){
                for( int j = 0 ; j< 10; j++){
                    int clave = i*10+j;
                    if(ejercito.containsKey(clave)){
                        String nombre =ejercito.get(clave).getNombre();
                        int orden = Integer.parseInt(nombre.substring(7,8));
                        if(orden == m){
                            System.out.println("Nombre: " + ejercito.get(clave).getNombre());
                            System.out.println("Nivel de Vida: " + ejercito.get(clave).getNivelVida());
                            System.out.println("Fila: " + ejercito.get(clave).getFila());
                            System.out.println("Columna: " + ejercito.get(clave).getColumna());
                            System.out.println("Actitud: " + ejercito.get(clave).getActitud());
                            System.out.println("-----------");
                        }
                    }
                }
            }m++;
        }
    }
    public static void ordenarPuntosBurbuja(Map<Integer,Soldado> ejercito) {
        int cantidad=ejercito.size();
        Soldado[] nuevoejercito =new Soldado[cantidad];
        ejercito.values().toArray(nuevoejercito);
        int j = 1;
        while(j != cantidad){
            for( int i = 0 ; i< cantidad-j;i++){
                if (nuevoejercito[i].getNivelVida()< nuevoejercito[i+1].getNivelVida()){
                        Soldado aux = nuevoejercito[i+1];
                        nuevoejercito[i+1] = nuevoejercito[i];
                        nuevoejercito[i]= aux;
                }
            }
            j++;
        }
        mostrarArray(nuevoejercito);
    }
    public static void ordenarPuntosSeleccion(Map<Integer,Soldado> ejercito) {
        
        int cantidad=ejercito.size();
        Soldado[] nuevoejercito =new Soldado[cantidad];
        ejercito.values().toArray(nuevoejercito);
        int j =0;
        int posicion =0;
        while(j != nuevoejercito.length){
            int minimo = Integer.MAX_VALUE;
            for(int i = 1+j ;i<nuevoejercito.length; i++){
                if(nuevoejercito[i].getNivelVida()<minimo){
                    minimo =nuevoejercito[i].getNivelVida();
                    posicion=i;
                }
            }
            Soldado aux = nuevoejercito[posicion];
            nuevoejercito[posicion] = nuevoejercito[j];
            nuevoejercito[j] = aux;
            j++;
            
        }
        mostrarArray(nuevoejercito);
        
    }
    public static void mostrarArray(Soldado[] array){
        for( int i = 0 ; i< array.length; i++){
            System.out.println("Nombre: " + array[i].getNombre());
            System.out.println("Nivel de Vida: " + array[i].getNivelVida());
            System.out.println("Fila: " + array[i].getFila());
            System.out.println("Columna: " + array[i].getColumna());
            System.out.println("Actitud: " + array[i].getActitud());
            System.out.println("-----------");
        }
    }
}
