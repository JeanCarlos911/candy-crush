package gui;

//java
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.JButton;

//libraries personalizadas <<De esta manera no se precargan metodos estaticos que no se usarán y se ahorra memoria>>
import static gui.Interfaz.getIcon;
import static gui.Interfaz.getFrame;
import static gui.Interfaz.getPanel;
import static gui.Interfaz.getLabel;
import static gui.Interfaz.getButton;
import static gui.Recurso.CURSOR_MANO;

public class MainTemplate extends JFrame{
    
    //Declaracion de objetos graficos
    private JPanel p_Total;
    private JButton bt_jugar;
    
    //Declaracion de objetos decoradores
    private Icon i_background, i_jugarOn, i_jugarOff;
    
    //Declaracion de componentes
    private JLabel l_background;
    
    //Declaracion de servicios
    private MainComponent mainComponent;
    
    public MainTemplate(MainComponent mainComponent){
        this.mainComponent = mainComponent;
        
        cargarRecursos();
        
        crearPaneles();
        crearBotones();
        crearDecoracion();
        
        getFrame(this, 1190, 740, "Candy Crush");
    }
    
    private void cargarRecursos(){
        //iconos
        i_background = getIcon("../resources/main/background.png", 1199, 720);
        i_jugarOff = getIcon("../resources/main/bt_jugar_off.png", 392, 105);
        i_jugarOn = getIcon("../resources/main/bt_jugar_on.png", 392, 105);
    }
    
    private void crearPaneles(){
        //panel que contiene todo
        p_Total = getPanel(0, 0, 1190, 720);
        add(p_Total);
    }
    
    private void crearDecoracion(){
        //Imagen fondo
        l_background = getLabel(i_background, 0, 0);
        p_Total.add(l_background);
    }
    
    private void crearBotones(){
    //por ahora usaré labels como botones mientras sigo investigando un poco más
        //Boton jugar
        bt_jugar = getButton(i_jugarOff, 660, 260, CURSOR_MANO);
        bt_jugar.addActionListener(mainComponent);
        p_Total.add(bt_jugar);
        
    }

    public JButton getBJugar(){
        return bt_jugar;
    }

    public void closeWindow(){
        setVisible(false);
        System.exit(0);
    }

    public void setVisibilidad(boolean b) {
        setVisible(b);
    }
    
}