package gui;

import javax.swing.JFrame;

public class Ventana{
    
    private JFrame frame;
    private static Ventana ventana;
    //ventanas
    
    public Ventana(){
        //Establece menu del juego como ventana inicial
        frame = (new MainComponent()).getFrame();//Inicia menu del juego
    }
    
}