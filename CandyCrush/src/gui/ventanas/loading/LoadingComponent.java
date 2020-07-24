package gui.ventanas.loading;

import controllers.Componente;
import javax.swing.JPanel;

public class LoadingComponent implements Componente{

    private LoadingTemplate loadingTemplate;

    public LoadingComponent(){
        loadingTemplate = new LoadingTemplate(this);
    }

    @Override
    public JPanel getGraphicComponent(){
        return loadingTemplate;
    }

}