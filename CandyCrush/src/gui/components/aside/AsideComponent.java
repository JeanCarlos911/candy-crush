package gui.components.aside;

import controllers.Componente;
import javax.swing.JPanel;
import game.Partida;

public class AsideComponent implements Componente{
 
    private static final long serialVersionUID = 1L;
    
    private AsideTemplate asideTemplate;

    public AsideComponent(){
        asideTemplate = new AsideTemplate(this, Partida.getReferencia().getJugador());
    }

    @Override
    public JPanel getGraphicComponent(){
        return asideTemplate;
    }
    
}