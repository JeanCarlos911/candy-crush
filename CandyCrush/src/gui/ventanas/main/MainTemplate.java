package gui.ventanas.main;

//java
import gui.GraphicService;
import gui.RecursoService;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class MainTemplate extends JPanel{
    
    private static final long serialVersionUID = 1L;

    //referencias
    private final MainComponent mainComponent;
    private GraphicService interfaz;
    private RecursoService recurso;
    
    //Declaracion de objetos decoradores
    private Icon iBackground, iJugarOff, iGuardar;
    
    //Declaracion de componentes
    private JLabel lBackground;
    private JButton btJugar, btGuardar;
    
    
    
    protected MainTemplate(MainComponent mainComponent){
        interfaz = GraphicService.getService();
        recurso = RecursoService.getService();
        this.mainComponent = mainComponent;
        
        cargarRecursos();     
        crearBotones();
        crearDecoracion();
        
        interfaz.setPanel(this, 0, 0, 1195, 750);
        setVisible(true);
    }
    
    private void cargarRecursos(){
        //iconos
        iBackground = new ImageIcon("../resources/main/background.png");
        iJugarOff   = new ImageIcon("../resources/main/btJugarOff.png");
        iGuardar    = new ImageIcon("../resources/main/btGuardar.png");
    }
    
    private void crearDecoracion(){
        //fondo
        lBackground = interfaz.getLabel(iBackground, 0, 0);
        add(lBackground);
    }
    
    private void crearBotones(){
        //Boton jugar
        btJugar = interfaz.getButton(680, 260, iJugarOff, recurso.CURSOR_MANO);
        btJugar.addActionListener(mainComponent);
        add(btJugar);
        
        //boton guardar
        btGuardar = interfaz.getButton(660, 390, iGuardar, null);
        add(btGuardar);
        
    }

    protected JButton getBJugar(){
        return btJugar;
    }

}