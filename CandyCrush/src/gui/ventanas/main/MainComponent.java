package gui.ventanas.main;

import controllers.Componente;
import gui.ventanas.Ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class MainComponent implements ActionListener, Componente{
    
    //Declaracion de interfaz
    private MainTemplate mainTemplate;
    
    public MainComponent(){
        this.mainTemplate = new MainTemplate(this);//Crear interfaz del menu del juego
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mainTemplate.getBJugar()) {
            Ventana.getReferencia().setVentanaLoading();
            Ventana.getReferencia().setVentanaGame();
        }
    }

    @Override
    public JPanel getGraphicComponent() {
        return mainTemplate;
    }

}