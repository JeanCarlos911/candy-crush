package gui;

//java
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.JButton;

//libraries personalizadas <<De esta manera no se precargan metodos estaticos que no se usarán y se ahorra memoria>>
import static gui.Interfaz.getIcon;
import static gui.Interfaz.setFrame;
import static gui.Interfaz.getPanel;
import static gui.Interfaz.getLabel;
import static gui.Interfaz.getButton;
import static gui.Recurso.CURSOR_MANO;

public class MainTemplate extends JFrame{
    
    //Declaracion de objetos graficos
    private JPanel p_total;
    
    //Declaracion de objetos decoradores
    private Icon i_background, i_jugarOn, i_jugarOff, i_guardar;
    
    //Declaracion de componentes
    private JLabel l_background;
    private JButton bt_jugar, bt_guardar;
    
    //Declaracion de administrador de la interfaz
    private final MainComponent mainComponent;
    
    public MainTemplate(MainComponent mainComponent){
        this.mainComponent = mainComponent;
        cargarRecursos();     
        crearPaneles();
        crearBotones();
        crearDecoracion();
        
        setFrame(this, 1190, 740, "Candy Crush");
    }
    
    private void cargarRecursos(){
        //iconos
        i_background = getIcon("/resources/main/background.png", 1199, 720);
        i_jugarOff   = getIcon("/resources/main/btAjugarOff.png", 392, 105);
        i_jugarOn    = getIcon("/resources/main/btJugarOn.png", 392, 105);
        i_guardar    = getIcon("/resources/main/btGuardar.png", 457, 108);
    }
    
    private void crearPaneles(){
        //panel que contiene todo
        p_total = getPanel(0, 0, 1190, 720);
        add(p_total);
    }
    
    private void crearDecoracion(){
        //Imagen fondo
        l_background = getLabel(i_background, 0, 0);
        p_total.add(l_background);
    }
    
    private void crearBotones(){
    //por ahora usaré labels como botones mientras sigo investigando un poco más
        //Boton jugar
        bt_jugar = getButton(i_jugarOff, 680, 260, CURSOR_MANO);
        bt_jugar.addActionListener(mainComponent);
        p_total.add(bt_jugar);
        
        bt_guardar = getButton(i_guardar, 660, 390,CURSOR_MANO);
        p_total.add(bt_guardar);
        
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