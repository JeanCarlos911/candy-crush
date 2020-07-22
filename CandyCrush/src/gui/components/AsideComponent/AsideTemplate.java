package gui.components.AsideComponent;

//import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import game.Jugador;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class AsideTemplate extends JPanel {

    private static final long serialVersionUID = 1L;
    private JLabel image, txtMovimientosRestantes, txtVidas, txtName;
    private final int ancho,alto;
    private JLabel puntuacionObjetivo, puntuacionActual;

    public AsideTemplate(Jugador jugador,int puntuacionObjetivo,int puntuacionActual){
        
        ancho = 350;
        alto = 540;

        setSize(new Dimension(ancho,alto));
        setLayout(null);
        setBackground(new Color(87,119,230));
        
        image = new JLabel();
        image.setSize(new Dimension(96,96));
        image.setIcon(new ImageIcon("../resources/main/iconHeart.png"));
        image.setLocation(20, 170);
        //-----------------------------------------------------------------------------------
        txtName = new JLabel("Jugador: "+jugador.getNombre());
        txtName.setFont(new Font("Liberation Serif",Font.PLAIN,25));
        txtName.setSize(new Dimension(300,30));
        txtName.setLocation((this.getWidth()-txtName.getWidth())/2, 20);
        txtName.setForeground(Color.white);
        //------------------------------------------------------------------------------------
        txtMovimientosRestantes = new JLabel("Movimientos Restantes: "+String.valueOf(jugador.getNumeroMovimientos()));
        txtMovimientosRestantes.setFont(new Font("Liberation Serif",Font.PLAIN,25));
        txtMovimientosRestantes.setSize(new Dimension(300,30));
        txtMovimientosRestantes.setLocation((this.getWidth()-txtMovimientosRestantes.getWidth())/2,300);
        txtMovimientosRestantes.setForeground(Color.white);
       //-------------------------------------------------------------------------------------
        txtVidas = new JLabel("Vidas restantes: " + String.valueOf(jugador.getVidasRestantes()));
        txtVidas.setFont(new Font("Liberation Serif",Font.PLAIN,25));
        txtVidas.setSize(new Dimension(200,30));
        txtVidas.setLocation((this.getWidth()-110)/2,200);
        txtVidas.setForeground(Color.white);
        //--------------------------------------------------------------------------------------
        this.puntuacionObjetivo = new JLabel("Puntuacion Objetivo: "+String.valueOf(puntuacionObjetivo));
        this.puntuacionObjetivo.setSize(new Dimension(300,25));
        this.puntuacionObjetivo.setLocation((this.getWidth()-this.puntuacionObjetivo.getWidth())/2,400);
        this.puntuacionObjetivo.setFont(new Font("Liberation Serif",Font.PLAIN,25));
        this.puntuacionObjetivo.setForeground(Color.white);
        //--------------------------------------------------------------------------------------- 
        this.puntuacionActual = new JLabel("Puntuacion Actual: "+String.valueOf(puntuacionActual));  
        this.puntuacionActual.setSize(new Dimension(300,25));
        this.puntuacionActual.setLocation((this.getWidth()-this.puntuacionActual.getWidth())/2, 450);
        this.puntuacionActual.setFont(new Font("Liberation Serif",Font.PLAIN,25));
        this.puntuacionActual.setForeground(Color.white);
        //---------------------------------------------------------------------------------------    
        add(image);
        add(txtName);
        add(txtVidas);
        add(txtMovimientosRestantes);
        add(this.puntuacionObjetivo);
        add(this.puntuacionActual);
    }
    
}