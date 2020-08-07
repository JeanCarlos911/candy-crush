package gui.ventanas;

import gui.GraphicService;
import javax.swing.JFrame;
import javax.swing.JPanel;
import gui.ventanas.main.MainComponent;
import gui.ventanas.game.GameComponent;
import gui.components.notification.NotificationComponent;
import java.awt.Dimension;

public class Ventana extends JFrame{
    
    //referencias
    private GraphicService interfaz;
    private static Ventana ventana;
    
    //atributos
    private JPanel main, game,notificacion;//vistas principales
    private static final long serialVersionUID = 1L;
    
    public Ventana(){
        interfaz = GraphicService.getService();
        ventana = this;
        
        main = (new MainComponent()).getGraphicComponent();
        add(main);

        interfaz.setFrame(this, 1195, 750, "Candy Crush");
    }
    
    public void setVentanaGame(){
        game = (new GameComponent()).getGraphicComponent();
        getContentPane().removeAll();
        add(game);
        repaint();
    }

    public void setVentanaNotificacion(){
        notificacion = (new NotificationComponent()).getGraphicComponent();
        getContentPane().removeAll();
        this.setSize(new Dimension(500,300));
        this.setLocationRelativeTo(null);
        add(notificacion);
        repaint();
    }

    public static Ventana getReference(){
        return ventana;
    }
    
}