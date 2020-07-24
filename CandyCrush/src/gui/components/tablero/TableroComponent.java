package gui.components.tablero;

import controllers.Componente;
import game.Dulce;
import game.Tablero;
import gui.RecursoService;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class TableroComponent extends MouseAdapter implements Componente{
    
    //referencias
    private RecursoService recurso; //service

    //atributos propios
    private Tablero tablero;//tablero a graficar
    private TableroTemplate tableroTemplate; //user interface
    private boolean pressed;
    private int casillasSeleccionadas, index1[], index2[];
    
    public TableroComponent(){
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
        if(e.getSource().getClass().toString().equals("class javax.swing.JButton") && 
                !tableroTemplate.getDulce(e.getSource()).getBackground().equals(recurso.MOSTAZA)){
            if(casillasSeleccionadas<2){
                casillasSeleccionadas++;
                index1 = tableroTemplate.getLocationDulce(e.getSource());
                tableroTemplate.getDulce(e.getSource()).setBackground(recurso.MOSTAZA);
            }
        }
    }

    public void mouseReleased(MouseEvent e) {
        pressed = false;
        if(casillasSeleccionadas == 2 && verificarMovimiento(index1, index2)){
            tablero.moverDulce(new int[] {index1[0], index1[1], index2[0], index2[1]});
            tablero.setPuntuacion(0);
            
            if(tablero.actualizarTablero()){
                //animIntercambio();
            }else{
                tablero.moverDulce(new int[] {index1[0], index1[1], index2[0], index2[1]});
            }
        }
        tableroTemplate.refrescar();
        
        casillasSeleccionadas=0;
    }

    public void mouseEntered(MouseEvent e) {
        if(e.getSource().getClass().toString().equals("class javax.swing.JButton")){
            if(pressed && casillasSeleccionadas<2){
                casillasSeleccionadas++;
                index2 = tableroTemplate.getLocationDulce(e.getSource());
                tableroTemplate.getDulce(e.getSource()).setBackground(recurso.MOSTAZA);
            }
            else
                tableroTemplate.getDulce(e.getSource()).setBackground(recurso.VERDE);
        }
    }

    public void mouseExited(MouseEvent e) {
        if(tableroTemplate.getDulce(e.getSource()).getBackground().equals(recurso.VERDE) || casillasSeleccionadas > 2){
            if(e.getSource().getClass().toString().equals("class javax.swing.JButton")){
                int[] posicion = tableroTemplate.getLocationDulce(e.getSource());
                if((posicion[0] + posicion[1]) % 2 == 0){
                    tableroTemplate.getDulce(e.getSource()).setBackground(recurso.AZUL_GRIS_OSCURO);
                }else{
                    tableroTemplate.getDulce(e.getSource()).setBackground(recurso.AZUL_GRIS);
                }//tarea: Timer
            }
        }
    }
    
    protected Dulce[][] getMatriz(){
        return tablero.getMatriz();
    }
    
    private boolean verificarMovimiento(int[] posicion1, int[] posicion2){
        int sumatoria = Math.abs(posicion2[0] - posicion1[0]) + Math.abs(posicion2[1]-posicion1[1]);
        
        if((posicion1[0]<0 || posicion1[0]>8) || (posicion1[1]<0 || posicion1[1]>8) 
                || (posicion2[0]<0 || posicion2[0]>8) || (posicion2[1]<0 || posicion2[1]>8)){
            return false;
        }else if(sumatoria != 1){
            return false;
        }else{
            return true;
        }
    }
/*
    private void animIntercambio() {
        int direccionX, direccionY;
        
        Point meta = tableroTemplate.getDulce(index2).getLocation();
        direccionX = (((index2[1] - index1[1]) != 0)?(index2[1] - index1[1])/Math.abs(index2[1] - index1[1]):0);
        direccionY = (((index2[0] - index1[0]) != 0)?(index2[0] - index1[0])/Math.abs(index2[0] - index1[0]):0);
        
        while(true){
            System.out.println(tableroTemplate.getDulce(index1).getLocation().x + " " + 
                    tableroTemplate.getDulce(index1).getLocation().y + " " +
                    tableroTemplate.getDulce(index2).getLocation().x + " " + 
                    tableroTemplate.getDulce(index2).getLocation().y + " " + 
                    meta.x + " " + meta.y + " " + direccionX + " " + direccionY
            );
            
            sleep(10);
            
            if(tableroTemplate.getDulce(index1).getLocation().x == meta.x ^ 
                    tableroTemplate.getDulce(index1).getLocation().y == meta.y){
                tableroTemplate.setLocacion(
                        tableroTemplate.getDulce(index1).getLocation().x + direccionX,
                        tableroTemplate.getDulce(index1).getLocation().y + direccionY,
                        index1
                );
                tableroTemplate.setLocacion(
                        tableroTemplate.getDulce(index2).getLocation().x - direccionX,
                        tableroTemplate.getDulce(index2).getLocation().y - direccionY,
                        index2
                );
            }
            else
                break;
        }
    }
    */
    
}
