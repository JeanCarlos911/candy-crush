package gui.ventanas.game;

import controllers.Componente;
import javax.swing.JPanel;

public class GameComponent implements Componente{

    private GameTemplate gameTemplate;

    public GameComponent(){
        gameTemplate = new GameTemplate(this);
    }

    @Override
    public JPanel getGraphicComponent(){
        return gameTemplate;
    }

}