package gui.ventanas.loading;

import static gui.ObjGraphic.setPanel;
import static gui.ObjGraphic.getLabel;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoadingTemplate extends JPanel{

    private LoadingComponent loadingComponent;

    private Icon iBackground;

    private JLabel lBackground;

    public LoadingTemplate(LoadingComponent lc){
        loadingComponent = lc;

        cargarRecursos();
        crearDecoracion();

        setPanel(this, 0, 0, 1190, 740);
        setVisible(true);
    }

    private void cargarRecursos(){
        iBackground = new ImageIcon("../resources/loading.png");
    }

    private void crearDecoracion(){
        lBackground = getLabel(iBackground, 0, 0);
        add(lBackground);
    }
}