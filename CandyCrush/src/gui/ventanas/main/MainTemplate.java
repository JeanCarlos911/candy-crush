package gui.ventanas.main;

//java
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.JButton;
//libraries personalizadas <<De esta manera no se precargan metodos estaticos que no se usaran y se ahorra memoria>>
import static gui.ObjGraphic.setPanel;
import static gui.ObjGraphic.getPanel;
import static gui.ObjGraphic.getLabel;
import static gui.ObjGraphic.getButton;
import static gui.ObjDecorator.CURSOR_MANO;
import javax.swing.ImageIcon;

public class MainTemplate extends JPanel{
    
    private static final long serialVersionUID = 1L;

    // Declaracion de objetos graficos
    private JPanel pTotal;
    
    //Declaracion de objetos decoradores
    private Icon iBackground, iJugarOn, iJugarOff, iGuardar;
    
    //Declaracion de componentes
    private JLabel lBackground;
    private JButton btJugar, btGuardar;
    
    //Declaracion de administrador de la interfaz
    private final MainComponent mainComponent;
    
    public MainTemplate(MainComponent mainComponent){
        this.mainComponent = mainComponent;
        
        cargarRecursos();     
        crearBotones();
        crearDecoracion();
        
        setPanel(this, 0, 0, 1195, 750);
        setVisible(true);
    }
    
    private void cargarRecursos(){
        //iconos
        iBackground = new ImageIcon("../resources/main/background.png");
        iJugarOff   = new ImageIcon("../resources/main/btJugarOff.png");
        iJugarOn    = new ImageIcon("../resources/main/btJugarOn.png");
        iGuardar    = new ImageIcon("../resources/main/btGuardar.png");
    }
    
    private void crearDecoracion(){
        //fondo
        lBackground = getLabel(iBackground, 0, 0);
        add(lBackground);
    }
    
    private void crearBotones(){
        //Boton jugar
        btJugar = getButton(680, 260, iJugarOff, CURSOR_MANO);
        btJugar.addActionListener(mainComponent);
        add(btJugar);
        
        //boton guardar
        btGuardar = getButton(660, 390, iGuardar, null);
        add(btGuardar);
        
    }

    public JButton getBJugar(){
        return btJugar;
    }

    public void closeWindow(){
        setVisible(false);
        System.exit(0);
    }

    public void setVisibilidad(boolean b) {
        setVisible(b);
    }
    
}