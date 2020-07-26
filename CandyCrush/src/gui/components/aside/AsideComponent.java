package gui.components.aside;

import models.Componente;
import javax.swing.JPanel;

public class AsideComponent implements Componente{
 
    private static final long serialVersionUID = 1L;
    
    private AsideTemplate asideTemplate;

    public AsideComponent(){
        asideTemplate = new AsideTemplate(this);
    }

    @Override
    public JPanel getGraphicComponent(){
        return asideTemplate;
    }
    
}