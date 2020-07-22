package gui.ventanas.game;

import gui.components.tablero.TableroComponent;
import gui.components.aside.AsideComponent;

import static gui.ObjGraphic.setPanel;
import static gui.ObjGraphic.getPanel;
import static gui.ObjGraphic.getLabel;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameTemplate extends JPanel{

    private GameComponent gameComponent;

    private Icon iBackground;

    private JPanel tablero, aside;

    private JLabel lBackground;

    public GameTemplate(GameComponent gc){
        gameComponent = gc;

        cargarRecursos();

        crearPaneles();
        crearDecoracion();

        setPanel(this, 0, 0, 1195, 750);
        setVisible(true);
    }

    private void cargarRecursos(){
        iBackground = new ImageIcon("../resources/game/background.png");
    }

    private void crearPaneles(){
        tablero = (new TableroComponent()).getComponent();
        add(tablero);

        aside = (new AsideComponent()).getComponent();
        add(aside);
    }

    private void crearDecoracion(){
        lBackground = getLabel(iBackground, 0, 0);
        add(lBackground);
    }
}