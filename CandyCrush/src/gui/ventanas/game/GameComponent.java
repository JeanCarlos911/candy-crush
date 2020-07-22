package gui.ventanas.game;

import javax.swing.JPanel;

public class GameComponent{

    private GameTemplate gameTemplate;

    public GameComponent(){
        gameTemplate = new GameTemplate(this);
    }

    public JPanel getComponent(){
        return gameTemplate;
    }

}