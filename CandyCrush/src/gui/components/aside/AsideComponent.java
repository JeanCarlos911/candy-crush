package gui.components.aside;

import javax.swing.JPanel;
import game.Partida;
import game.Jugador;

public class AsideComponent {
 
    private static final long serialVersionUID = 1L;
    private AsideTemplate asideTemplate;

    public AsideComponent(){
        asideTemplate = new AsideTemplate(this, Partida.getReferencia().getJugador());
    }

    public JPanel getComponent(){
        return asideTemplate;
    }
    
}