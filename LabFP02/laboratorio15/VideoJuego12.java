/*
Laboraorio 15
Nombre : Denise Huacani Jara
 */
package laboratorio15;
import java.util.*;
public class VideoJuego12 {
    public static void main(String[] args) {
        ArrayList<Ejercito> reino1 = new ArrayList<>();
        ArrayList<Ejercito> reino2 = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1. Agregar soldado manualmente");
            System.out.println("2. Agregar soldado autogenerado");
            System.out.println("3. Modificar soldado");
            System.out.println("4. Eliminar soldado");
            System.out.println("5. Consultas");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    crearEjercitosEnReino(reino1, reino2);
                    mostrarReino (reino1);
                    crearEjercitosEnReino(reino2, reino1);
                    mostrarReino (reino2);
                    
                    break;
                case 2:
                    crearEjercitosEnReinoAutomatico(reino1, reino2);
                    mostrarReino (reino1);
                    crearEjercitosEnReinoAutomatico(reino2, reino1);
                    mostrarReino (reino2);
                    break;
                case 3:
                    System.out.println("Elija un reino para modificar soldados:");
                    int numero = sc.nextInt();
                    if(numero ==1){
                        modificarSoldado(reino1);
                        mostrarReino(reino1);
                    }else{
                        modificarSoldado(reino2);
                        mostrarReino(reino2);
                    }
                    break;
                case 4:
                    System.out.println("Elija un reino para modificar soldados:");
                    int num = sc.nextInt();
                    if(num ==1){
                        eliminarSoldado(reino1);
                        mostrarReino(reino1);
                    }else{
                        eliminarSoldado(reino2);
                        mostrarReino(reino2);
                    }
                    
                    break;
                case 5:
                    int opci;
                    do{
                        System.out.println("\nConsultas");
                        System.out.println("1. Soldado con mayor nivel de ataque");
                        System.out.println("2. Ranking de poder");
                        System.out.println("3. Ver datos del ejército y de los soldados");
                        System.out.println("4. Salir");
                        System.out.print("Seleccione una opción: ");
                        opci = sc.nextInt();
                        switch (opci) {
                            case 1:
                                System.out.println("\nxxxx Primer Reino xxxx");
                                mostraSoldadosConMayorNV( reino1);
                                System.out.println("\nxxxx Segundo Reino xxxx");
                                mostraSoldadosConMayorNV( reino2);
                                break;
                            case 2:
                                System.out.println("\nxxxx Primer Reino xxxx");
                                ordenarPuntosBurbuja(reino1);
                                mostrarEjercitosOrdenados(reino1);
                                
                                System.out.println("\nxxxx Segundo Reino xxxx");
                                ordenarPuntosBurbuja(reino2);
                                mostrarEjercitosOrdenados(reino2);
                                
                                break;
                            case 3:
                                System.out.println("\nxxxx Primer Reino xxxx");
                                mostrarReino(reino1);
                                
                                System.out.println("\nxxxx Segundo Reino xxxx");
                                mostrarReino(reino2);
                                
                                
                                break;
                            case 4:
                                System.out.println("Saliendo del programa.");
                                break;
                            default:
                                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                        }
                    }while(opci!=4);
                        
                    break;
                case 6:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 6);
    }
    public static void mostrarReino(ArrayList<Ejercito> reino) {
        System.out.println("Reino: " + reino.get(0).getReino() );
        int can = reino.size();
        for (int i = 0; i < can; i++) {
            System.out.print("\nSoldados del ejército " + (i + 1) + ":**********\n");
            System.out.println(reino.get(i).toString()); // Mostrar la representación del ejército y sus soldados
        }
    }
    
    public static void crearEjercitosEnReino(ArrayList<Ejercito> reino, ArrayList<Ejercito> reinoSecundario){
        Scanner sc = new Scanner ( System.in);
        System.out.println("xxxxxxxxxxxxxx REINO xxxxxxxxxxxxxx");
        String name ="";
        boolean nombreValido;
        do {
            nombreValido = true;
            int opcion;
            System.out.println("Elige el nombre del reino");
            System.out.println("1. Inglaterra");
            System.out.println("2. Francia");
            System.out.println("3. Castilla-Aragón");
            System.out.println("4. Sacro Imperio Romano-Germánico");
            System.out.println("5. Moros");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    name = "Inglaterra";
                    break;
                case 2:
                    name = "Francia";
                    break;
                case 3:
                    name = "Castilla-Aragón";
                    break;
                case 4:
                    name = "Sacro Imperio Romano-Germánico";
                    break;
                case 5:
                    name = "Moros";
                    break;

            }
            if (reinoSecundario.get(0).getReino().equals(name)) {
                System.out.println("¡Error! El nombre del reino ya existe. Ingresa un nombre diferente.");
                nombreValido = false; // El nombre no es válido
                break;
            }
        } while (!nombreValido); 
        System.out.println("Ingresa la cantidad de ejercitos para el reino "+name);
        int cantEjercitos = sc.nextInt();
        
        for ( int i =0; i < cantEjercitos; i++){
            Ejercito ejercito =new Ejercito(name);
            System.out.print("\nIngresa la cantidad de soldados para el "+(i+1)+ " ejercito : ");
            int cantSoldados = sc.nextInt();
            for ( int j =0; j < cantSoldados ; j++){
                ejercito.agregarSoldadoManualmente((i+1));
            }
            reino.add(ejercito);
        }
        mostrarReino (reino);
    }
    public static String elegirNombreReino(){
        Random random = new Random();
        int numero = random.nextInt(5);
        switch (numero) {
            case 4:
                return "Inglaterra";
            case 3:
                return "Francia";
            case 2:
                return "Sacro Imperio Romano-Germánico";
            case 1:
                return "Castilla- Aragon";
            case 0:
                return "Moros";
            default:
                return null;
        }
    }
    public static void crearEjercitosEnReinoAutomatico(ArrayList<Ejercito> reino, ArrayList<Ejercito> reinoSecundario) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("xxxxxxxxxxxxxx REINO xxxxxxxxxxxxxx");

        int cantEjercitos = rand.nextInt(    Ejercito.MAX_SOLDADOS_EJERCITO) + 1;

        boolean nombreValido;
        String name;
        do {
            nombreValido = true;
            name = elegirNombreReino();

            for (Ejercito ejercito : reinoSecundario) {
                if (ejercito.getReino().equals(name)) {
                    nombreValido = false; // El nombre no es válido
                    break;
                }
            }
        } while (!nombreValido);

        for (int i = 0; i < cantEjercitos; i++) {
            Ejercito ejercito = new Ejercito(name);
            int cantSoldados = rand.nextInt(Ejercito.MAX_SOLDADOS_EJERCITO) + 1;
            for (int j = 0; j < cantSoldados; j++) {
                ejercito.agregarSoldadoAutogenerado((i + 1));
            }
            reino.add(ejercito);
        }
    }
    public static void modificarSoldado(ArrayList<Ejercito> reino) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Seleccione el número de ejército: ");
        int numeroEjercito = sc.nextInt();

        if (numeroEjercito < 1 || numeroEjercito > reino.size()) {
            System.out.println("Número de ejército inválido.");
            return;
        }
        Ejercito ejercito = reino.get(numeroEjercito - 1);

        System.out.println("Soldados del ejército " + numeroEjercito + ":");
        ejercito.toString();

        System.out.print("Seleccione el número de soldado a modificar: ");
        int numeroSoldado = sc.nextInt();
        Soldado soldado = ejercito.getSoldado(numeroSoldado - 1);
        System.out.print("Nuevo nivel de vida del soldado: ");
        int nuevoNivelVida = sc.nextInt();
        System.out.print("Nuevo nivel de ataque del soldado: ");
        int nuevoNivelAtaque = sc.nextInt();
        soldado.setNivelVida(nuevoNivelVida);
        soldado.setNivelAtaque(nuevoNivelAtaque);
        System.out.println("Soldado modificado con éxito.");
    }
    
    public static void eliminarSoldado(ArrayList<Ejercito> reino) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Seleccione un ejército para eliminar un soldado: ");
        int numEjercito = sc.nextInt() - 1;

        if (numEjercito >= 0 && numEjercito < reino.size()) {
            Ejercito ejercito = reino.get(numEjercito);

            // Solicitar al usuario seleccionar un soldado para eliminar
            System.out.print("Seleccione un soldado para eliminar: ");
            int numSoldado = sc.nextInt() - 1;
            
            reino.get(numEjercito).getMisSoldados().remove(numSoldado);
            System.out.println("Soldado eliminado exitosamente del ejército " + ejercito.getReino() + ".");
            
        } else {
            System.out.println("Número de ejército inválido.");
        }
    }
    public static int encontrarMayorNV(ArrayList<Ejercito> reino){
        
        int mayor =-1;
        System.out.println("Reino: " + reino.get(0).getReino() );
        int can = reino.size();
        for (int i = 0; i < can; i++) {
            int cantidadSoldados = reino.get(i).getCantidadSoldados();
            for (int j = 0; j < cantidadSoldados; j++) {
                int nivelVida = reino.get(i).getMisSoldados().get(j).getNivelAtaque();
                if(nivelVida>mayor){
                    mayor = nivelVida;
                }
            }
        }
        return mayor;
    }
    public static void mostraSoldadosConMayorNV(ArrayList<Ejercito> reino){
        int can = reino.size();
        for (int i = 0; i < can; i++) {
            int cantidadSoldados = reino.get(i).getCantidadSoldados();
            for (int j = 0; j < cantidadSoldados; j++) {
                int nivelVida = reino.get(i).getMisSoldados().get(j).getNivelAtaque();
                if(nivelVida==encontrarMayorNV( reino)){
                    System.out.println(reino.get(i).getMisSoldados().get(j).toString());
                }
            }
        }
    }
    public static void ordenarPuntosBurbuja(ArrayList<Ejercito> reino) {
        int n = reino.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                
                int nivelVida1 = reino.get(j).getMisSoldados().get(0).getNivelVida();
                int nivelVida2 = reino.get(j + 1).getMisSoldados().get(0).getNivelVida();

                if (nivelVida1 > nivelVida2) {
                    // Intercambiar 
                    Ejercito temp = reino.get(j);
                    reino.set(j, reino.get(j + 1));
                    reino.set(j + 1, temp);
                }
            }
        }
    }
    public static void mostrarEjercitosOrdenados(ArrayList<Ejercito> reino) {
        for (Ejercito ejercito : reino) {
            Soldado primerSoldado = ejercito.getMisSoldados().get(0);
            System.out.println("Reino: " + ejercito.getReino());
            System.out.println(primerSoldado.toString()+"\n"); 
        }
    }

}