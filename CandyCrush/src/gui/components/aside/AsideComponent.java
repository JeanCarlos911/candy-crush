package gui.components.aside;

import models.Componente;
import javax.swing.JPanel;

public class AsideComponent implements Componente{
 

    
    private AsideTemplate asideTemplate;

    public AsideComponent(){
        asideTemplate = new AsideTemplate();
    }

    @Override
    public JPanel getGraphicComponent(){
        return asideTemplate;
    }
    
}