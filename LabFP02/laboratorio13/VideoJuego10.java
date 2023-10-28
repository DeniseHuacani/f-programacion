/*
Laboratorio 13
Nombre Denise Andrea Huacani Jara
 */
package laboratorio13;

import java.util.*;

public class VideoJuego10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer,Soldado> ejercito1 = new HashMap<Integer, Soldado>();
        Map<Integer,Soldado> ejercito2 = new HashMap<Integer, Soldado>();
        int opcion;
        do {
            System.out.println("\n\tMenú Principal:");
            System.out.println("1. Juego rápido");
            System.out.println("2. Juego personalizado");
            System.out.println("3. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    int respuesta;
                    do{
                        System.out.print("@ :Ejercito 1 : ");
                        ingresarDatosSoldados(ejercito1, ejercito2, 1);
                        System.out.print("# :Ejercito 2 : ");
                        ingresarDatosSoldados(ejercito2, ejercito1, 2);
                        
                        int cantidadTotal = Soldado.getCantidadSoldadosTotal();
                        System.out.println("Cantidad total de soldados: " + cantidadTotal);

                        
                        llenarTableroEquipo(ejercito1,ejercito2);
                        juegorapido(ejercito1, ejercito2);
                        System.out.println("\n1. reiniciar");
                        System.out.println("2. Salir al menu principal");
                        System.out.print("Elija una opcion : ");
                        respuesta = sc.nextInt();
                    }while(respuesta!=2);
                   mostrarDatos(ejercito1, ejercito2);
                    break;
                case 2:
                    System.out.print("@ :Ejercito 1 : ");
                    ingresarDatosSoldados(ejercito1, ejercito2, 1);
                    System.out.print("# :Ejercito 2 : ");
                    ingresarDatosSoldados(ejercito2, ejercito1, 2);
                    Soldado.getCantidadSoldadosTotal();
                    
                    int cantidadTotal = Soldado.getCantidadSoldadosTotal();
                    System.out.println("Cantidad total de soldados: " + cantidadTotal);
                    llenarTableroEquipo(ejercito1,ejercito2);
                    
                    int opcion2;
                    do {
                        System.out.println("\n\tMenú de Gestión de Soldados:");
                        System.out.println("1) Crear Soldado");
                        System.out.println("2) Eliminar Soldado");
                        System.out.println("3) Clonar Soldado");
                        System.out.println("4) Modificar Soldado");
                        System.out.println("5) Comparar Soldados");
                        System.out.println("6) Intercambiar Soldados");
                        System.out.println("7) Ver soldado");
                        System.out.println("8) Ver ejército");
                        System.out.println("9) Sumar niveles");
                        System.out.println("10) Jugar");
                        System.out.println("11) Volver");
                        System.out.print("Elija una opción: ");
                        opcion2 = sc.nextInt();

                        switch (opcion2) {
                            case 1:
                                
                                System.out.print("Ingresa el numero del ejercito para añadir un soldado : ");
                                int numero = sc.nextInt();
                                if(numero==1){
                                    if(ejercito1.size()==(Soldado.MAX_SOLDADOS_EJERCITO)){
                                        System.out.print("Ejercito lleno.");
                                        System.out.println("\n1. Llenar el otro ejercito");
                                        System.out.println("2. Salir ");
                                        System.out.print("Elija una opcion : ");
                                        int respuesta2 = sc.nextInt();
                                        if(respuesta2 == 1){
                                            crearSoldado(ejercito2, ejercito1,2);
                                        }else{
                                            break;
                                        }
                                    }else{
                                        crearSoldado(ejercito1, ejercito2,1);
                                    }
                                }if(numero==2){
                                    if(ejercito2.size()==(Soldado.MAX_SOLDADOS_EJERCITO)){
                                        System.out.print("Ejercito lleno.");
                                        System.out.println("\n1. Llenar el otro ejercito");
                                        System.out.println("2. Salir ");
                                        System.out.print("Elija una opcion : ");
                                        int respuesta2 = sc.nextInt();
                                        if(respuesta2 == 1){
                                            crearSoldado(ejercito1, ejercito2,1);
                                        }else{
                                            break;
                                        }
                                    
                                    }else{
                                        crearSoldado(ejercito2, ejercito1,2);
                                    }
                                }
                                llenarTableroEquipo(ejercito1,ejercito2);
                                break;
                            case 2:
                                
                                
                                System.out.print("Ingresa el numero del ejercito para eliminar un soldado : ");
                                int numero2 = sc.nextInt();
                                if(numero2==1){
                                    if(ejercito1.size()==1){
                                        System.out.print("Ejercito con solo un soldado.");
                                        System.out.println("\n1. Eliminar del otro ejercito");
                                        System.out.println("2. Salir ");
                                        System.out.print("Elija una opcion : ");
                                        int respuesta2 = sc.nextInt();
                                        if(respuesta2 == 1){
                                            eliminarSoldado(ejercito2);
                                        }else{
                                            break;
                                        }
                                    }else{
                                        eliminarSoldado(ejercito1);
                                    }
                                    
                                }else{
                                    if(ejercito2.size()==1){
                                        System.out.print("Ejercito con solo un soldado.");
                                        System.out.println("\n1. Eliminar del otro ejercito");
                                        System.out.println("2. Salir ");
                                        System.out.print("Elija una opcion : ");
                                        int respuesta2 = sc.nextInt();
                                        if(respuesta2 == 1){
                                            eliminarSoldado(ejercito1);
                                        }else{
                                            break;
                                        }
                                    }else{
                                        eliminarSoldado(ejercito2);
                                    }
                                }
                                llenarTableroEquipo(ejercito1,ejercito2);
                                
                                break;
                            case 3:
                                
                                System.out.print("Ingresa el numero del ejercito para clonar un soldado : ");
                                int numero3 = sc.nextInt();
                                if(numero3==1){
                                    if(ejercito1.size()==(Soldado.MAX_SOLDADOS_EJERCITO)){
                                        System.out.print("Ejercito lleno.");
                                        System.out.println("\n1. Clonar del otro ejercito");
                                        System.out.println("2. Salir ");
                                        System.out.print("Elija una opcion : ");
                                        int respuesta2 = sc.nextInt();
                                        if(respuesta2 == 1){
                                            clonarSoldado(ejercito2, ejercito1,2);
                                        }else{
                                            break;
                                        }
                                    }else{
                                        clonarSoldado(ejercito1, ejercito2,1);
                                    }
                                }if(numero3==2){
                                    if(ejercito2.size()==(Soldado.MAX_SOLDADOS_EJERCITO)){
                                        System.out.print("Ejercito lleno.");
                                        System.out.println("\n1. Clonar del otro ejercito");
                                        System.out.println("2. Salir ");
                                        System.out.print("Elija una opcion : ");
                                        int respuesta2 = sc.nextInt();
                                        if(respuesta2 == 1){
                                            clonarSoldado(ejercito1, ejercito2,1);
                                        }else{
                                            break;
                                        }
                                    
                                    }else{
                                        clonarSoldado(ejercito2, ejercito1,2);
                                    }
                                }
                                llenarTableroEquipo(ejercito1,ejercito2);
                                break;
                            case 4:
                                System.out.print("Ingresa el numero del ejercito  : ");
                                int numero4 = sc.nextInt();
                                System.out.print("Introduce la ubicación del soldado que deseas modificar: ");
                                String ubicacionTablero = sc.next();
                                int clave = posicion(ubicacionTablero);
                                if(numero4==1){
                                    modificarSoldado(ejercito1, clave);
                                }else{
                                    modificarSoldado(ejercito2, clave);
                                }
                                llenarTableroEquipo(ejercito1,ejercito2);
                                break;
                            case 5:
                                int numeroEjercito1=0;
                                int numeroEjercito2=0;
                                System.out.print("Introduce la ubicación del soldado: ");
                                String ubicSoldado1 = sc.next();
                                int cla = posicion(ubicSoldado1);
                                if (ejercito1.containsKey(cla)){
                                    numeroEjercito1 =1;
                                }else if (ejercito2.containsKey(cla)){
                                    numeroEjercito1 =2;
                                }
                                System.out.print("Introduce la ubicación del soldado: ");
                                String ubicSoldado2 = sc.next();
                                int cla2 = posicion(ubicSoldado2);
                                if (ejercito1.containsKey(cla2)){
                                    numeroEjercito2 =1;
                                }else if (ejercito2.containsKey(cla2)){
                                    numeroEjercito2 =2;
                                }
                                if(numeroEjercito1==1){
                                    if(numeroEjercito2==1){
                                        if(ejercito1.get(cla).equals(ejercito1.get(cla2))){
                                            System.out.println("iguales");
                                        }
                                        else{
                                            System.out.println("diferentes");
                                        }
                                    }else{
                                        if(ejercito1.get(cla).equals(ejercito2.get(cla2))){
                                            System.out.println("iguales");
                                        }
                                        else{
                                            System.out.println("diferentes");
                                        }
                                    }
                                }else{
                                    if(numeroEjercito2==1){
                                        if(ejercito2.get(cla).equals(ejercito1.get(cla2))){
                                            System.out.println("iguales");
                                        }
                                        else{
                                            System.out.println("diferentes");
                                        }
                                    }else{
                                        if(ejercito2.get(cla).equals(ejercito2.get(cla2))){
                                            System.out.println("iguales");
                                        }
                                        else{
                                            System.out.println("diferentes");
                                        }
                                    }
                                }
                                
                                break;
                            case 6:
                                System.out.print("Introduce la ubicación del soldado en el Ejercito 1: ");
                                String ubic = sc.next();
                                int clave1 = posicion(ubic);
                                System.out.print("Introduce la ubicación del soldado en el Ejercito 2: ");
                                String ubic2 = sc.next();
                                int clave2 = posicion(ubic2);
                                intercambiarSoldados(ejercito1,clave1,  ejercito2,clave2);
                                llenarTableroEquipo(ejercito1,ejercito2);
                                break;
                            case 7:
                                int claveBuscar =buscarNombre(ejercito1,ejercito2);
                                if(claveBuscar==0){
                                    System.out.println("Nombre no encotrado");
                                }
                                buscarClave( ejercito1, claveBuscar);
                                buscarClave( ejercito2, claveBuscar);
                                break;
                            case 8:
                                verEjercito(ejercito1);
                                verEjercito(ejercito2);
                                break;
                            case 9:
                                System.out.print("Ingresa el numero del ejercito para sumar  : ");
                                int numerosumar = sc.nextInt();
                                if(numerosumar==1){
                                    sumar( ejercito1);
                                }else{
                                    sumar( ejercito2);
                                }
                                break;
                            case 10:
                                juegorapido(ejercito1, ejercito2);
                                break;
                            case 11:
                                System.out.println("Volviendo al menú principal...");
                                break;
                            default:
                                System.out.println("Opción no válida. Inténtelo de nuevo.");
                                break;
                        }
                    } while (opcion2 != 11);
                    break;
                case 3:
                    System.out.println("¡FIN!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        } while (opcion != 3);
    }
    public static void sumar(Map<Integer,Soldado> ejercito){
        
        Soldado sumaSoldados = null;

        // Iterar a través del mapa y sumar los atributos de todos los soldados
        for (Soldado soldado : ejercito.values()) {
            if (sumaSoldados == null) {
                sumaSoldados = new Soldado(soldado.getNivelVida(), soldado.getNivelAtaque(), soldado.getNivelDefensa());
            } else {
                sumaSoldados = sumaSoldados.sumar(soldado);
            }
        }
        if (sumaSoldados != null) {
            System.out.println("Nivel de vida total: " + sumaSoldados.getNivelVida());
            System.out.println("Nivel de ataque total: " + sumaSoldados.getNivelAtaque());
            System.out.println("Nivel de defensa total: " + sumaSoldados.getNivelDefensa());
        } else {
            System.out.println("El ejército está vacío.");
        }
    }
    public static void verEjercito(Map<Integer,Soldado> ejercito){
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
    public static int buscarNombre(Map<Integer, Soldado> ejercito1, Map<Integer, Soldado> ejercito2) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Soldado n° X m° donde n es el numero del soldado y el m es el numero del ejercito");
        System.out.print("Ingresa n : ");
        int n = sc.nextInt();
        System.out.print("Ingresa m : ");
        int m = sc.nextInt();
        String nombrebuscar=("Soldado"+n+"X"+m);
        
        if (m == 1) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    int clave = i * 10 + j;
                    //System.out.print(clave+"++++++++++++++++++++++++++++++++++++");
                    if (ejercito1.containsKey(clave)) {
                        String nombre = ejercito1.get(clave).getNombre();
                        if (nombre.equals(nombrebuscar)) {
                            return clave;
                            
                        }
                    }
                }
            }
        } else if (m == 2) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    int clave = i * 10 + j;
                    if (ejercito2.containsKey(clave)) {
                        String nombre = ejercito2.get(clave).getNombre();
                        if (nombre.equals(nombrebuscar)) {
                            return clave;
                        }
                    }
                }
            }
        } 
        
        return 0;
    }public static void buscarClave(Map<Integer,Soldado> ejercito,int clave){
        
        if(ejercito.containsKey(clave)){
                System.out.println("Nombre: " +ejercito.get(clave).getNombre());
                System.out.println("Nivel de Vida: " +(ejercito.get(clave)).getNivelVida());
                System.out.println("Fila: " +ejercito.get(clave).getFila());
                System.out.println("Columna: " + ejercito.get(clave).getColumna());
                System.out.println("Actitud: " + ejercito.get(clave).getActitud());
                System.out.println("-----------");

        }
            
        
    }
    public static void intercambiarSoldados(Map<Integer,Soldado>ejercito1,int clave1, Map<Integer,Soldado> ejercito2,int clave2){
        
        Soldado soldadoEjercito1 = ejercito1.get(clave1);
        ejercito1.remove(clave1);
        Soldado soldadoEjercito2 = ejercito2.get(clave2);
        ejercito2.remove(clave2);
        if (soldadoEjercito1 != null && soldadoEjercito2 != null) {
            // Intercambiar los soldados
            ejercito1.put(clave2, soldadoEjercito2);
            ejercito2.put(clave1, soldadoEjercito1);
            
            System.out.println("Soldados intercambiados .");
        } else {
            System.out.println("Uno o ambos soldados no existen en los ejércitos.");
        }
    }
    
    public static void modificarSoldado(Map<Integer,Soldado> ejercito, int clave) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú de Modificación del Soldado:");
            System.out.println("1. Modificar nivel de ataque");
            System.out.println("2. Modificar nivel de defensa");
            System.out.println("3. Modificar vida actual");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nuevo nivel de ataque (1-5): ");
                    int nuevoAtaque = sc.nextInt();
                    ejercito.get(clave).setNivelAtaque(nuevoAtaque);
                    System.out.println("Nivel de ataque modificado exitosamente.");
                    break;
                case 2:
                    System.out.print("Ingrese el nuevo nivel de defensa (1-5): ");
                    int nuevaDefensa = sc.nextInt();
                    ejercito.get(clave).setNivelDefensa(nuevaDefensa);
                    System.out.println("Nivel de defensa modificado exitosamente.");
                    break;
                case 3:
                    System.out.print("Ingrese la nueva vida actual: ");
                    int nuevaVida = sc.nextInt();
                    ejercito.get(clave).setNivelVida(nuevaVida);
                    System.out.println("Vida actual modificada exitosamente.");
                    break;
                case 4:
                    System.out.println("Saliendo del menú de modificación.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 4);
    }

    
    public static void clonarSoldado(Map<Integer,Soldado> principal ,Map<Integer,Soldado> secundario, int n){
        Scanner sc = new Scanner (System.in);
        System.out.print("Introduce la ubicación del soldado que deseas clonar: ");
        String ubicacionTablero = sc.next();
        int clave = posicion(ubicacionTablero);
        
        int fila  = random(10);//del 0 al 9
        int colum = random(10);
        int clavenueva = fila*10+colum;  //23 es 2 fila , 3 colum
        while(principal.containsKey(clavenueva)|| secundario.containsKey(clavenueva)){
            fila  = random(10);
            colum = random(10);
            clavenueva = fila*10+colum;
        }
        String nombre= ("Soldado"+ (principal.size()+1)+"X"+n);  
        int nivelVida = principal.get(clave).getNivelVida();
        int nivelAtaque = principal.get(clave).getNivelAtaque();
        int nivelDefensa = principal.get(clave).getNivelDefensa();
        String actitud = principal.get(clave).getActitud();
        
        Soldado soldado = new Soldado(nombre, nivelVida, nivelAtaque, nivelDefensa,fila,colum,actitud);
        principal.put(clavenueva, soldado);
        int digito = clavenueva%10+1;
        char letra = (char) ('A' + digito - 1);
        String ubicacion =letra+""+(clavenueva/10+1);
        System.out.print("Ubicacion del nuevo soldado :"+ubicacion+"\n");
        
    }
    public static void eliminarSoldado(Map<Integer,Soldado> ejercito){
        Scanner sc = new Scanner (System.in);
        System.out.print("Introduce la ubicación del soldado que deseas eliminar: ");
        String ubicacionTablero = sc.next();
        int pos = posicion(ubicacionTablero);
        
        if (ejercito.containsKey(pos)) {
            ejercito.remove(pos);
            System.out.println("Soldado eliminado en la ubicación " + ubicacionTablero);
        } else {
            System.out.println("No hay soldado en la ubicación " + ubicacionTablero);
        }
        
    }
    public static void crearSoldado(Map<Integer,Soldado> ejercito1,Map<Integer,Soldado> ejercito2, int n ){
        Scanner sc = new Scanner (System.in);

        String nombre;
        int clave;
        int nivelVida ;
        int nivelAtaque ;
        int nivelDefensa;
        String actitud;
        int fila;
        int columna;
        System.out.print("Nombre: ");
        nombre = ("Soldado "+(ejercito1.size()+1)+"X"+n);
        System.out.print(nombre+"\n");
        System.out.print("Nivel Vida (1-5): ");
        nivelVida = sc.nextInt();

        System.out.print("Nivel Ataque (1-5): ");
        nivelAtaque = sc.nextInt();

        System.out.print("Nivel Defensa (1-5): ");
        nivelDefensa= sc.nextInt();

        System.out.print("Actitud(defensiva, ofensiva, fuga): ");
        actitud= sc.next();

        System.out.print("Fila: ");
        fila= sc.nextInt()-1;

        System.out.print("Columna: ");
        String letra= sc.next();
        columna = Character.toUpperCase(letra.charAt(0)) - 'A';//Si es A seria 0
        clave =fila*10+columna;
        while(ejercito1.containsKey(clave) || ejercito2.containsKey(clave)){
            System.out.print("Existe un soldado en esa posicion , vuelva a ingresar \n");
            System.out.print("Fila: ");
            fila= sc.nextInt()-1;

            System.out.print("Columna: ");
            letra= sc.next();
            columna = Character.toUpperCase(letra.charAt(0)) - 'A';//Si es A seria 0
            clave =fila*10+columna;
        }

        Soldado soldado = new Soldado(nombre, nivelVida, nivelAtaque, nivelDefensa,fila,columna,actitud);
        ejercito1.put(clave, soldado);
        System.out.print("Se creo un nuevo soldado ");
        
        
    }
    public static void juegorapido(Map<Integer,Soldado> ejercito1,Map<Integer,Soldado> ejercito2){
        Scanner sc = new Scanner (System.in);
        
        String respuesta ;
        int cantidad= Soldado.getCantidadSoldadosTotal();
        while(cantidad > 1){
                juegoEjercito(ejercito1,ejercito2, 1);
                System.out.println("@ :Ejercito 1 : "+ejercito1.size());
                
                System.out.println("# :Ejercito 2 : "+ejercito2.size());
                System.out.println("Total : "+Soldado.getCantidadSoldadosTotal());
                System.out.print("Desea continuar ? (S/N):");
                respuesta = sc.next();
                if(respuesta.equals("N")){
                    break;
                }
                juegoEjercito(ejercito2,ejercito1, 2);
                System.out.println("@ :Ejercito 1 : "+ejercito1.size());
                
                System.out.println("# :Ejercito 2 : "+ejercito2.size());
                System.out.println("Total : "+Soldado.getCantidadSoldadosTotal());
                System.out.print("Desea continuar ? (S/N):");
                respuesta = sc.next();
                if(respuesta.equals("N")){
                    break;
                }
        }
        
        if(ejercito1.size()==0){
            System.out.println("GANADOR : EJERCITO 2 \n");
        }else if(ejercito2.size()==0)
            System.out.println("GANADOR : EJERCITO 1 \n");

        
    }
    public static void juegoEjercito(Map<Integer,Soldado> principal,Map<Integer,Soldado> secundario, int numeroDeEjercito){
        Scanner sc = new Scanner (System.in);
        String signo = "@";
        if(numeroDeEjercito ==2){
            signo= "#";
        }
        System.out.println(signo+" :Ejercito "+numeroDeEjercito+" :---------------------------------------");
        
        int ubicacionGuerrero_Actual=0;
        do{
            System.out.print("Elige la posicion de un guerrero(ej A4):");
            String posicionGuerrero = sc.next();
            ubicacionGuerrero_Actual = posicion(posicionGuerrero);
        }while(ubicacionGuerrero_Actual == -1); //si es -1 es que no es valido la entrada
        
        //ingresar nueva ubicacion
        int ubicacionGuerrero_Nuevo=0;
        do{
            System.out.println("Solo puede moverse un casillero , "
                + "en cualquier direccion(diagonal , avanzar , retroceder)");
            System.out.print("Elige la posicion a donde se movera el guerrero(ej A4):");
            String guerreroNuevo = sc.next();
            ubicacionGuerrero_Nuevo =posicion(guerreroNuevo);
            if(nopuedeMoverse( principal, ubicacionGuerrero_Actual,  ubicacionGuerrero_Nuevo)){
                ubicacionGuerrero_Nuevo=-1; // para volver a ingresa 
                System.out.println("El soldado solo puede recorrer un espacio");
            }
        }while(ubicacionGuerrero_Nuevo == -1); //si es -1 es que no es valido la entrada
        
        moverGuerrero(principal, ubicacionGuerrero_Actual,ubicacionGuerrero_Nuevo);
        if(hayPelea(principal,secundario,ubicacionGuerrero_Nuevo)){
            System.out.println("\n\nBatalla!!!!!!!!!!!!!");
            batallaSoldado(principal,secundario,ubicacionGuerrero_Nuevo);
        }
        llenarTableroEquipo(principal,secundario);
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
            System.out.println("Vida +1" );
        }else{
            System.out.println("Gano : "+ ejercito2.get(posicion).getNombre() );
            System.out.println("El "+ejercito1.get(posicion).getNombre()+" muere");
            ejercito1.remove(posicion);
            int nivel = ejercito2.get(posicion).getNivelVida();
            ejercito2.get(posicion).setNivelVida(nivel+1);
            System.out.println("Vida +1" );
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
    public static void ingresarDatosSoldados(Map<Integer,Soldado> ejercito1, Map<Integer,Soldado> ejercito2,int n) {
        int cant =random ((Soldado.MAX_SOLDADOS_EJERCITO))+1;
        int num=0;
        System.out.println("Se creo "+ cant + " soldados");
        for ( int i =0; i < cant; i++){
            int fila  = random(10);//del 0 al 9
            int colum = random(10);
            int clave = fila*10+colum;  //23 es 2 fila , 3 colum
            while(ejercito1.containsKey(clave) || ejercito2.containsKey(clave)){
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
    public static void mostrarDatos(Map<Integer,Soldado> ejercito1, Map<Integer,Soldado> ejercito2){
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
    }
}
