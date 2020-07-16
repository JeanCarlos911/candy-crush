package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.JButton;

public class MainTemplate extends JFrame{
    
    //Declaracion de objetos graficos
    private JPanel p_Total;
    private JButton bt_jugar;
    
    //Declaracion de objetos decoradores
    private Icon i_background, i_jugarOn, i_jugarOff;
    private JLabel l_background, l_jugarOn, l_jugarOff;
    
    //Declaracion de servicios
    private Recurso recurso;
    private MainComponent mainComponent;
    
    public MainTemplate(MainComponent mainComponent){
        this.mainComponent = mainComponent;
        
        recurso = Recurso.getService();
        
        cargarRecursos();
        
        crearPaneles();
        crearBotones();
        crearDecoracion();
        
        Interfaz.getFrame(this, 1190, 740, "Candy Crush");
    }
    
    private void cargarRecursos(){
        //Icons
        i_background = Interfaz.getIcon(this, "/lib/main/background.png", 1199, 720);
        i_jugarOff = Interfaz.getIcon(this, "/lib/main/bt_jugar_off.png", 392, 105);
        i_jugarOn = Interfaz.getIcon(this, "/lib/main/bt_jugar_on.png", 392, 105);
    }
    
    private void crearPaneles(){
        
        //panel que contiene todo
        p_Total = Interfaz.getPanel(0, 0, 1190, 720);
        add(p_Total);
    }
    
    private void crearDecoracion(){
        //Imagen fondo Main
        l_background = Interfaz.getLabelIcon(i_background, 0, 0);
        p_Total.add(l_background);
    }
    
    private void crearBotones(){
        //Boton jugar
        //Revisando como hacerlo de la mejor manera... bt_jugar = Interfaz.getJButtonIcon(i_jugarOff, 0, 0, recurso.getCursorMano(), "c");
    }

    public JButton getBJugar(){
        return bt_jugar;
    }

    public void closeWindow(){
        setVisible(false);
    }

    public void setVisibilidad(boolean b) {
        setVisible(b);
    }
    
}