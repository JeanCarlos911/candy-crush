package gui.ventanas.game;

import gui.GraphicService;
import gui.components.tablero.TableroComponent;
import gui.components.aside.AsideComponent;

import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameTemplate extends JPanel{

    
    private static final long serialVersionUID = 1L;

    private GraphicService interfaz;

    private Icon iBackground;
    private JPanel tablero, aside;
    private JLabel lBackground;

    public GameTemplate(){
        interfaz = GraphicService.getService();

        cargarRecursos();

        crearPaneles();
        crearDecoracion();

        interfaz.setPanel(this, 0, 0, 1195, 750);
        setVisible(true);
    }

    private void cargarRecursos(){
        iBackground = new ImageIcon("../resources/game/background.png");
    }

    private void crearPaneles(){
        tablero = (new TableroComponent()).getGraphicComponent();
        add(tablero);

        aside = (new AsideComponent()).getGraphicComponent();
        add(aside);
    }

    private void crearDecoracion(){
        lBackground = interfaz.getLabel(iBackground, 0, 0);
        add(lBackground);
    }
    
}