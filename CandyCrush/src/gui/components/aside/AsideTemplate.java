package gui.components.aside;

//import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import models.Jugador;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class AsideTemplate extends JPanel {

    private Jugador jugador;

    private static final long serialVersionUID = 1L;
    private JLabel image, txtMovimientosRestantes, txtVidas, txtName;
    private final int ANCHO,ALTO;
    private JLabel puntuacionObjetivo, puntuacionActual;
    
    public AsideTemplate(){
        jugador = Jugador.getReference("");

        ANCHO = 350;
        ALTO = 600;

        setSize(new Dimension(ANCHO,ALTO));
        setLayout(null);
        setBackground(new Color(87,119,230));
        
        image = new JLabel();
        image.setSize(new Dimension(96,96));
        image.setIcon(new ImageIcon("../resources/main/iconHeart.png"));
        image.setLocation((this.getWidth() - image.getWidth())/2,100);
        //-----------------------------------------------------------------------------------
        txtName = new JLabel("Jugador: "+jugador.getNombre());
        txtName.setFont(new Font("Serif",Font.PLAIN,25));
        txtName.setSize(new Dimension(300,30));
        txtName.setLocation((this.getWidth()-txtName.getWidth())/2, 20);
        txtName.setForeground(Color.white);
        //------------------------------------------------------------------------------------
        txtMovimientosRestantes = new JLabel("Movimientos Restantes: "+String.valueOf(jugador.getTurnosRestantes()));
        txtMovimientosRestantes.setFont(new Font("Serif",Font.PLAIN,25));
        txtMovimientosRestantes.setSize(new Dimension(300,30));
        txtMovimientosRestantes.setLocation((this.getWidth()-txtMovimientosRestantes.getWidth())/2,300);
        txtMovimientosRestantes.setForeground(Color.white);
       //-------------------------------------------------------------------------------------
        txtVidas = new JLabel("Vidas restantes: " + String.valueOf(jugador.getVidasRestantes()));
        txtVidas.setFont(new Font("Serif",Font.PLAIN,25));
        txtVidas.setSize(new Dimension(300,30));
        txtVidas.setLocation((this.getWidth()-200)/2,200);
        txtVidas.setForeground(Color.white);
        //--------------------------------------------------------------------------------------
        puntuacionObjetivo = new JLabel("Puntuacion Objetivo: "+String.valueOf(3000));
        puntuacionObjetivo.setSize(new Dimension(300,25));
        puntuacionObjetivo.setLocation((this.getWidth()-this.puntuacionObjetivo.getWidth())/2,400);
        puntuacionObjetivo.setFont(new Font("Serif",Font.PLAIN,25));
        puntuacionObjetivo.setForeground(Color.white);
        //--------------------------------------------------------------------------------------- 
        puntuacionActual = new JLabel("Puntuacion Actual: "+String.valueOf(jugador.getPuntaje()));  
        puntuacionActual.setSize(new Dimension(300,25));
        puntuacionActual.setLocation((this.getWidth()- puntuacionActual.getWidth())/2, 450);
        puntuacionActual.setFont(new Font("Serif",Font.PLAIN,25));
        puntuacionActual.setForeground(Color.white);
        //---------------------------------------------------------------------------------------    
        add(image);
        add(txtName);
        add(txtVidas);
        add(txtMovimientosRestantes);
        add(this.puntuacionObjetivo);
        add(this.puntuacionActual);
        setLocation(15, 10);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        txtMovimientosRestantes.setText("Movimientos Restantes: " + String.valueOf(jugador.getTurnosRestantes()));
        txtVidas.setText("Vidas restantes: " + String.valueOf(jugador.getVidasRestantes()));
        puntuacionActual.setText("Puntuacion Actual: " + String.valueOf(jugador.getPuntaje()));
        
        updateUI();
    }
    
}