package gui.ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import static gui.ObjGraphic.setFrame;
import gui.ventanas.main.MainComponent;
import gui.ventanas.loading.LoadingComponent;
import gui.ventanas.game.GameComponent;

public class Ventana extends JFrame{
    
    private JPanel main, loading, game;
    private static final long serialVersionUID = 1L;

    //referencia
    private static Ventana ventana;
    
    public Ventana(){
        main = (new MainComponent()).getComponent();
        add(main);

        setFrame(this, 1195, 750, "Candy Crush");
        ventana = this;
    }
    
    public void setVentanaLoading(){
        loading = (new LoadingComponent()).getComponent();
        getContentPane().removeAll();
        add(loading);
        repaint();
    }

    public void setVentanaGame(){
        game = (new GameComponent()).getComponent();
        getContentPane().removeAll();
        add(game);
        repaint();
    }

    public static Ventana getReferencia(){
        return ventana;
    }
}