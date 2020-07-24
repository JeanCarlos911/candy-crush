package gui.ventanas.loading;

import gui.GraphicService;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoadingTemplate extends JPanel{

    private GraphicService interfaz;
    private LoadingComponent loadingComponent;

    private Icon iBackground;

    private JLabel lBackground;

    public LoadingTemplate(LoadingComponent lc){
        interfaz = GraphicService.getService();
        loadingComponent = lc;

        cargarRecursos();
        crearDecoracion();

        interfaz.setPanel(this, 0, 0, 1190, 740);
        setVisible(true);
    }

    private void cargarRecursos(){
        iBackground = new ImageIcon("../resources/loading.png");
    }

    private void crearDecoracion(){
        lBackground = interfaz.getLabel(iBackground, 0, 0);
        add(lBackground);
    }
}