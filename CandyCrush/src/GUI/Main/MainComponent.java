package GUI.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class MainComponent extends JFrame implements ActionListener{
    
    private MainTemplate mainTemplate;
    
    public MainComponent(){
        this.mainTemplate = new MainTemplate(this);//Crear Interfaz del menu del juego
    }

    //definir lógica de la interfaz del menu del juego
    @Override
    public void actionPerformed(ActionEvent e) {
        //Aún no hay botones...
    }
    
}