package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class MainComponent implements ActionListener{
    
    private MainTemplate mainTemplate;
    
    public MainComponent(){
        this.mainTemplate = new MainTemplate(this);//Crear Interfaz del menu del juego
    }
    
    public JFrame getFrame(){
        return mainTemplate;
    }

    //definir lógica de la interfaz del menu del juego
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mainTemplate.getBJugar()) {
            mainTemplate.closeWindow();
        }
    }
    
}