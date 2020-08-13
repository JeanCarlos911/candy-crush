package gui.components.tablero;

import gui.GraphicService;
import gui.RecursoService;
import java.awt.Point;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TableroTemplate extends JPanel{
    
    
    private static final long serialVersionUID = 1L;
    // referencias
    private TableroComponent tableroComponent;
    private RecursoService recurso;
    private GraphicService interfaz;
    
    //objetos decoradores
    private Icon iBackground, dulce1, dulce2, dulce3, dulce4, dulce5,dulce6;
    
    //objetos graficos
    private JButton[][] dulce;
    private JLabel lBackground;
    
    public TableroTemplate(TableroComponent tc){
        tableroComponent = tc;
        recurso = RecursoService.getService();
        interfaz = GraphicService.getService();
        
        cargarRecursos();
        
        crearBotonesConDulces();
        crearDecoracion();
        
        interfaz.setPanel(this, 395, 12, 695, 695);
    }

    protected JButton getDulce(int[] index) {
        return dulce[index[0]][index[1]];
    }
    
    protected JButton getDulce(Object source) {
        Point location = ((JButton) source).getLocation();
        return dulce[(location.y-6)/76][(location.x-6)/76];
    }
    
    protected void setLocacion(int x, int y, int[] dulceIndex){
        dulce[dulceIndex[0]][dulceIndex[1]].setLocation(x, y);
    }
    
    protected int[] getLocationDulce(Object source) {
        Point location = ((JButton) source).getLocation();
        return new int[]{(location.y-6)/76,(location.x-6)/76};
    }

    protected void refrescar() {
        Icon icono;
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                int ico = tableroComponent.getMatriz()[i][j].getForma();
                
                if((i+j)%2 == 0)
                    dulce[i][j].setBackground(recurso.AZUL_GRIS_OSCURO);
                else
                    dulce[i][j].setBackground(recurso.AZUL_GRIS);
                
                dulce[i][j].setBounds(j*76+6, i*76+6, 76, 76);
                
                switch(ico){
                    case 1:
                        icono = dulce1;
                        break;
                    case 2:
                        icono = dulce2;
                        break;
                    case 3:
                        icono = dulce3;
                        break;
                    case 4:
                        icono = dulce4;
                        break;
                    case 5:
                        icono = dulce5;
                        break;
                    case 6:
                        icono = dulce6;
                        break;
                    default:
                        icono = null;
                        break;
                }
                dulce[i][j].setIcon(icono);
            }
        }
        repaint();
    }

    private void cargarRecursos() {
        iBackground = new ImageIcon("../resources/game/tablero/tablero.png");
        dulce1 = new ImageIcon("../resources/game/tablero/Dulce1.png");
        dulce2 = new ImageIcon("../resources/game/tablero/Dulce2.png");
        dulce3 = new ImageIcon("../resources/game/tablero/Dulce3.png");
        dulce4 = new ImageIcon("../resources/game/tablero/Dulce4.png");
        dulce5 = new ImageIcon("../resources/game/tablero/Dulce5.png");
        dulce6 = new ImageIcon("../resources/game/tablero/Dulce6.png");

    }

    private void crearBotonesConDulces() {
        dulce = new JButton[9][9];
        Icon icono;
        
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                int ico = tableroComponent.getMatriz()[i][j].getForma();
                switch(ico){
                    case 1:
                        icono = dulce1;
                        break;
                    case 2:
                        icono = dulce2;
                        break;
                    case 3:
                        icono = dulce3;
                        break;
                    case 4:
                        icono = dulce4;
                        break;
                    case 5:
                        icono = dulce5;
                        break;
                    case 6:
                        icono = dulce6;
                        break;
                    default:
                        icono = null;
                        break;
                }
                if((i+j)%2 == 0){
                    dulce[i][j] = interfaz.getButton(j*76+6, i*76+6, 76, 76, recurso.CURSOR_MANO, icono, recurso.AZUL_GRIS_OSCURO, true);
                }else{
                    dulce[i][j] = interfaz.getButton(j*76+6, i*76+6, 76, 76, recurso.CURSOR_MANO, icono, recurso.AZUL_GRIS, true);
                }
                dulce[i][j].addMouseListener(tableroComponent);
                add(dulce[i][j]);
            }
        }
    }

    private void crearDecoracion() {
        lBackground = interfaz.getLabel(iBackground, 0, 0);
        add(lBackground);
    }

}
