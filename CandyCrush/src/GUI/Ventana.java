package GUI;

import GUI.Main.MainComponent;
import javax.swing.JFrame;

public class Ventana{
    
    private JFrame frame;
    private static Ventana ventana;
    
    public Ventana(){
        frame = new MainComponent();//Inicia menu del juego
    }
    
    public static Ventana getVentana(){
        if(ventana == null)
            ventana = new Ventana();
        return ventana;
    }
    
}
