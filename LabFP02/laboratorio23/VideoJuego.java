/*
Laboratorio 23
Nombre: Denise Andrea Huacani Jara
 */
package laboratorio23;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
public class VideoJuego extends JFrame{
    Mapa mapa = new Mapa();
    private static final int ANCHO =1000;
    private static final int ALTO=500;
    private JButton enviar;
    private JTextField actualTextField;
    private JTextField nuevaTextField;
    private JLabel turnoLabel;
    private JLabel mensaje;
    private JTextArea tableroTextArea;
    
    private int numeroTurno=1;
    private int turno=1;
    
    private JTextField nameBox;
    private JLabel saludo;
    
    public VideoJuego(){
        setTitle("VIDEOJUEGO!!");
        setSize(ANCHO,ALTO);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createContents(mapa);
        setVisible(true);
    }
    private void createContents(Mapa mapa) {
        tableroTextArea = new JTextArea();
        tableroTextArea.setEditable(false); 
        tableroTextArea.setText(mapa.llenarTablero());
        turnoLabel = new JLabel("Turno del Jugador: " + turno);
        mensaje= new JLabel("");
        JLabel blanco = new JLabel("");
        actualTextField = new JTextField(5); 
        JLabel actualLabel = new JLabel("Ubicación Actual (A3):");

        // Crear JTextField para la ubicación nueva
        nuevaTextField = new JTextField(5); 
        JLabel nuevaLabel = new JLabel("Ubicación Nueva (A3):");
        enviar = new JButton("Enviar");
        JPanel preguntas = new JPanel(new GridLayout(0, 2,10,10));
        
        JLabel codigos = new JLabel("Ejercito 1: o");
        JLabel codigos2 = new JLabel("Ejercito 2: x");
        preguntas.add(codigos);
        preguntas.add(blanco);
        preguntas.add(codigos2);
        preguntas.add(blanco);
        preguntas.add(turnoLabel);
        preguntas.add(blanco);
        preguntas.add(actualLabel);
        preguntas.add(actualTextField);
        
        preguntas.add(nuevaLabel);
        preguntas.add(nuevaTextField);
        preguntas.add(enviar);
        preguntas.add(mensaje);
        
        
        
        add(tableroTextArea);
        add(preguntas);
        enviar.addActionListener(new Listener());
        
        
    }
    private class Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            
            if (turno %2 == 1) {
                String ubicacionActual = actualTextField.getText();
                String ubicacionNueva = nuevaTextField.getText();

                int resultado = getMapa().getReino1().juegoEjercito(ubicacionActual, ubicacionNueva);

                if (resultado == -1) {
                    mensaje.setText("No existe un soldado en la ubicacion Actual");
                } else if (resultado == -2) {
                    mensaje.setText("El soldado solo puede recorrer un espacio");
                } else {
                    mensaje.setText("Acción realizada con éxito");
                    turno++;
                    if(hayPelea(resultado)){
                        System.out.println("\n ---------Batalla---------");
                        JOptionPane.showMessageDialog(null, batallaSoldado(resultado));

                    }
                    avanzarTurno();
                }
                
            } else {
                String ubicacionActual = actualTextField.getText();
                String ubicacionNueva = nuevaTextField.getText();

                int resultado = getMapa().getReino2().juegoEjercito(ubicacionActual, ubicacionNueva);

                if (resultado == -1) {
                    mensaje.setText("No existe un soldado en la ubicacion Actual");
                } else if (resultado == -2) {
                    mensaje.setText("El soldado solo puede recorrer un espacio");
                } else {
                    mensaje.setText("Acción realizada con éxito");
                    turno++;
                    if(hayPelea(resultado)){

                        System.out.println("\n ---------Batalla---------");
                        JOptionPane.showMessageDialog(null, batallaSoldado(resultado));
                    }
                    avanzarTurno();
                }
                
                
            }
    
        }
    }
    public static void main (String[] args){
            new VideoJuego();
    }
    
    private void avanzarTurno() {
        numeroTurno++;
        if(numeroTurno==3){
            numeroTurno=1;
        }
        // Actualizar el label del turno
        turnoLabel.setText("Turno del Jugador: " + numeroTurno);
        actualTextField.setText("");
        nuevaTextField.setText("");
        tableroTextArea.setText(mapa.llenarTablero());
    }
    public  boolean hayPelea( int posicion){
        int filaActual = posicion / 10+1;
        int colActual = posicion % 10 ;
        return (getMapa().getReino2().existeSoldado( filaActual,  colActual)) && (getMapa().getReino1().existeSoldado( filaActual,  colActual));
    }
    public  String batallaSoldado( int posicion){
        StringBuilder resultado = new StringBuilder();
        
        Random rand = new Random();
        int num = rand.nextInt(100)+1;
        
        int indice  =getMapa().getReino1().hallarIndiceSoldado( posicion);
        int vida1 = getMapa().getReino1().getMisSoldados().get(indice).getNivelVida();
        
        int indice2  =getMapa().getReino2().hallarIndiceSoldado( posicion);
        int vida2 = getMapa().getReino2().getMisSoldados().get(indice2).getNivelVida();
        
        double cantidad = vida1+vida2;
        double probabilidad= vida1*100/cantidad;
        double factor = Math.pow(10, 1);//1 es el numero de decimales
        probabilidad = Math.round(probabilidad * factor) / factor;
        resultado.append("\n"+getMapa().getNombreReino1());
        resultado.append("\nVida:"+vida1);
        resultado.append("\nProbabilidad:  "+probabilidad);
        resultado.append("\n\t\t"+getMapa().getNombreReino2());
        resultado.append("\nVida:"+vida2);
        resultado.append("\nProbabilidad:  "+(100- probabilidad)+"%");
        
        if(num<=probabilidad){
            resultado.append("\nGano : "+getMapa().getNombreReino1() );
            resultado.append("\nMuere: "+getMapa().getNombreReino2());
            getMapa().getReino2().getMisSoldados().remove(  indice2);
            getMapa().getReino1().getMisSoldados().get(indice).setNivelVida(vida1+1);
            
            resultado.append("\nVida +1" );
        }else{
            resultado.append("\nGano : "+getMapa().getNombreReino2());
            resultado.append("\nMuere: "+getMapa().getNombreReino1() );
            getMapa().getReino1().getMisSoldados().remove(  indice);
            getMapa().getReino2().getMisSoldados().get(indice2).setNivelVida(vida2+1);
            resultado.append("\nVida +1" );
        }
        return resultado.toString();
    }

    
    
    
        
    public Mapa getMapa() {
        return mapa;
    }

    public JLabel getTurnoLabel() {
        return turnoLabel;
    }
    
}

