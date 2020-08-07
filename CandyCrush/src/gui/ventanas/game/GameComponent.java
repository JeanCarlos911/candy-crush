package gui.ventanas.game;

import models.Componente;
import javax.swing.JPanel;

public class GameComponent implements Componente{

    private GameTemplate gameTemplate;

    public GameComponent(){
        gameTemplate = new GameTemplate();
    }

    @Override
    public JPanel getGraphicComponent(){
        return gameTemplate;
    }

}