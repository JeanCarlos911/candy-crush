package gui.components.tablero;

import models.Componente;
import models.Dulce;
import models.Tablero;
import gui.RecursoService;
import gui.ventanas.Ventana;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class TableroComponent extends MouseAdapter implements Componente {

    // referencias
    private RecursoService recurso; // service

    // atributos propios
    private Tablero tablero;// tablero a graficar
    private TableroTemplate tableroTemplate; // user interface
    private boolean pressed;
    private int casillasSeleccionadas, index1[], index2[];

    public TableroComponent() {
        recurso = RecursoService.getService();
        index1 = new int[2];
        index2 = new int[2];
        tablero = new Tablero();
        tableroTemplate = new TableroTemplate(this);
    }

    @Override
    public JPanel getGraphicComponent() {
        return tableroTemplate;
    }

    public void mousePressed(MouseEvent e) {
        pressed = true;
        if (e.getSource() instanceof javax.swing.JButton
                && !tableroTemplate.getDulce(e.getSource()).getBackground().equals(recurso.MOSTAZA)) {
            if (casillasSeleccionadas < 2) {
                casillasSeleccionadas++;
                index1 = tableroTemplate.getLocationDulce(e.getSource());
                tableroTemplate.getDulce(e.getSource()).setBackground(recurso.MOSTAZA);
            }
        }
    }

    public void mouseReleased(MouseEvent e) {
        pressed = false;
        if (casillasSeleccionadas == 2 && verificarMovimiento(index1, index2)) {
            tablero.moverDulce(new int[] { index1[0], index1[1], index2[0], index2[1] });

            if (!tablero.actualizarTablero(true)) {
                tablero.moverDulce(new int[] { index1[0], index1[1], index2[0], index2[1] });
            }

            if (tablero.getController().getJugador().getPuntaje() >= 3000) {
                Ventana.getReference().setVentanaNotificacion();
            }
        }
        tableroTemplate.refrescar();
        Ventana.getReference().repaint();

        casillasSeleccionadas = 0;
    }

    public void mouseEntered(MouseEvent e) {
        if (e.getSource() instanceof javax.swing.JButton) {
            if (pressed && casillasSeleccionadas < 2) {
                casillasSeleccionadas++;
                index2 = tableroTemplate.getLocationDulce(e.getSource());
                tableroTemplate.getDulce(e.getSource()).setBackground(recurso.MOSTAZA);
            } else
                tableroTemplate.getDulce(e.getSource()).setBackground(recurso.VERDE);
        }
    }

    public void mouseExited(MouseEvent e) {
        if (e.getSource() instanceof javax.swing.JButton) {
            if (tableroTemplate.getDulce(e.getSource()).getBackground().equals(recurso.VERDE)
                    || casillasSeleccionadas > 2) {

                int[] posicion = tableroTemplate.getLocationDulce(e.getSource());
                if ((posicion[0] + posicion[1]) % 2 == 0) {
                    tableroTemplate.getDulce(e.getSource()).setBackground(recurso.AZUL_GRIS_OSCURO);
                } else {
                    tableroTemplate.getDulce(e.getSource()).setBackground(recurso.AZUL_GRIS);
                } // tarea: Timer
            }
        }
    }

    protected Dulce[][] getMatriz() {
        return tablero.getMatriz();
    }

    private boolean verificarMovimiento(int[] posicion1, int[] posicion2) {
        int sumatoria = Math.abs(posicion2[0] - posicion1[0]) + Math.abs(posicion2[1] - posicion1[1]);

        if ((posicion1[0] < 0 || posicion1[0] > 8) || (posicion1[1] < 0 || posicion1[1] > 8)
                || (posicion2[0] < 0 || posicion2[0] > 8) || (posicion2[1] < 0 || posicion2[1] > 8)) {
            return false;
        } else if (sumatoria != 1) {
            return false;
        } else {
            return true;
        }
    }

}
