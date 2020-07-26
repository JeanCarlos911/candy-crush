import javax.swing.JOptionPane;
import models.Partida;

public class Main{
    
    /**
     * Metodo main
     * @param args 
     */
    public static void main(String args[]){
        String nombre =  JOptionPane.showInputDialog(null, "Ingrese su nombre: ", "Nombre jugador", JOptionPane.QUESTION_MESSAGE);
        Partida partida = new Partida(nombre);
    }
    
}