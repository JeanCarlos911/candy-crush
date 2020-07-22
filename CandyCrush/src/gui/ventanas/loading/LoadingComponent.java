package gui.ventanas.loading;

import javax.swing.JPanel;

public class LoadingComponent{

    private LoadingTemplate loadingTemplate;

    public LoadingComponent(){
        loadingTemplate = new LoadingTemplate(this);
    }

    public JPanel getComponent(){
        return loadingTemplate;
    }

}