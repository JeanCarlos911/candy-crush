package gui.components.tablero;

import game.Dulce;
import game.Tablero;
import static gui.ObjDecorator.AZUL_GRIS;
import static gui.ObjDecorator.AZUL_GRIS_OSCURO;
import static gui.ObjDecorator.MOSTAZA;
import static gui.ObjDecorator.VERDE;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TableroComponent implements MouseListener{
    
    //externo
    private TableroTemplate tableroTemplate;
    
    //atributo compartido
    private Tablero tablero;

    //atributos propios
    private boolean pressed;
    private int casillasSeleccionadas, sleep, index1[], index2[];
    
    public TableroComponent(){
        index1 = new int[2];
        index2 = new int[2];
        tablero = new Tablero();
        tableroTemplate = new TableroTemplate(this);
    }
    
    public JPanel getComponent() {
        return tableroTemplate;
    }
    
    protected Dulce[][] getMatriz(){
        return tablero.getMatriz();
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        pressed = true;
        if(e.getSource().getClass().toString().equals("class javax.swing.JButton") && 
                !tableroTemplate.getDulce(e.getSource()).getBackground().equals(MOSTAZA)){
            if(casillasSeleccionadas<2){
                casillasSeleccionadas++;
                index1 = tableroTemplate.getLocationDulce(e.getSource());
                tableroTemplate.getDulce(e.getSource()).setBackground(MOSTAZA);
            }
        }
    }

    //PROBLEMA
    @Override
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

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource().getClass().toString().equals("class javax.swing.JButton")){
            if(pressed && casillasSeleccionadas<2){
                casillasSeleccionadas++;
                index2 = tableroTemplate.getLocationDulce(e.getSource());
                tableroTemplate.getDulce(e.getSource()).setBackground(MOSTAZA);
            }
            else
                tableroTemplate.getDulce(e.getSource()).setBackground(VERDE);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(tableroTemplate.getDulce(e.getSource()).getBackground().equals(VERDE) || casillasSeleccionadas > 2){
            if(e.getSource().getClass().toString().equals("class javax.swing.JButton")){
                int[] posicion = tableroTemplate.getLocationDulce(e.getSource());
                if((posicion[0] + posicion[1]) % 2 == 0){
                    tableroTemplate.getDulce(e.getSource()).setBackground(AZUL_GRIS_OSCURO);
                }else{
                    tableroTemplate.getDulce(e.getSource()).setBackground(AZUL_GRIS);
                }//tarea: Timer
            }
        }
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
    private void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {}
    }
    
}
