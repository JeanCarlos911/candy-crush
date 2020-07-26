package gui.ventanas;

import gui.GraphicService;
import javax.swing.JFrame;
import javax.swing.JPanel;
import gui.ventanas.main.MainComponent;
import gui.ventanas.loading.LoadingComponent;
import gui.ventanas.game.GameComponent;

public class Ventana extends JFrame{
    
    //referencias
    private GraphicService interfaz;
    private static Ventana ventana;
    
    //atributos
    private JPanel main, loading, game;//vistas principales
    private static final long serialVersionUID = 1L;
    
    public Ventana(){
        interfaz = GraphicService.getService();
        ventana = this;
        
        main = (new MainComponent()).getGraphicComponent();
        add(main);

        interfaz.setFrame(this, 1195, 750, "Candy Crush");
    }
    
    public void setVentanaLoading(){
        loading = (new LoadingComponent()).getGraphicComponent();
        getContentPane().removeAll();
        add(loading);
        repaint();
    }

    public void setVentanaGame(){
        game = (new GameComponent()).getGraphicComponent();
        getContentPane().removeAll();
        add(game);
        repaint();
    }

    public static Ventana getReference(){
        return ventana;
    }
    
}