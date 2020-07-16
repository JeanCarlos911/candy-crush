package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public final class Interfaz{
    

    private Interfaz(){
    }
    
    public static JPanel getPanel(int x, int y, int ancho, int largo, Color color){
        JPanel panel = getPanel(x, y, ancho, largo);
        panel.setBackground(color);
        return panel;
    }
    
    public static JPanel getPanel(int x, int y, int ancho, int largo){
        JPanel panel = new JPanel();
        panel.setBounds(x, y, ancho, largo);
        panel.setLayout(null);
        return panel;
    }
    
    public static JLabel getLabel(Icon icono, int x, int y){
        JLabel label = new JLabel();
        label.setSize(icono.getIconWidth(), icono.getIconHeight());
        label.setLocation(x, y);
        label.setIcon(icono);
        return label;
    }
    
    public static JLabel getLabel(Icon icono, int x, int y, Cursor cursor){
        JLabel label = getLabel(icono, x, y);
        label.setCursor(cursor);
        return label;
    }
    
    public static JLabel getLabel(String cadena, int x, int y, int ancho, int alto, Color colorFuente, Font fuente){        
        JLabel label= new JLabel(cadena);
        label.setSize(ancho, alto);
        label.setLocation(x, y);
        label.setForeground(colorFuente);
        label.setFont(fuente);
        return label;
    }
    
    public static Icon getIcon(String ruta, int width, int height){
        ImageIcon iIcono = new ImageIcon(Icon.class.getResource(ruta));
        Icon icono = new ImageIcon(iIcono.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT));
        return icono;
    }
    
    public static void getFrame(JFrame frame, int ancho, int alto, String titulo){
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setTitle(titulo);
        frame.setSize(ancho, alto);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public static JButton getButton(Icon icono, int x, int y, Cursor cursor){
        JButton button = new JButton();
        button.setContentAreaFilled(false);
        button.setBorder(null);
        button.setIcon(icono);
        button.setSize(icono.getIconWidth(), icono.getIconHeight());
        button.setLocation(x, y);
        button.setCursor(cursor);
        return button;
    }
    
    public static JButton getButton(String texto, int x, int y, int ancho, int alto, Cursor cursor, Icon imagen, Font fuente, Color colorFondo,
            Color colorFuente,Border borde, String direccion, boolean esSolido){
        
        JButton button= new JButton(texto);
        button.setSize(ancho, alto);
        button.setLocation(x, y);
        button.setFocusable(false);
        button.setCursor(cursor);
        button.setFont(fuente);
        button.setBackground(colorFondo);
        button.setForeground(colorFuente);
        button.setIcon(imagen);
        button.setBorder(borde);
        button.setContentAreaFilled(esSolido);
        switch(direccion){
            case "l":
                button.setHorizontalAlignment(SwingConstants.LEFT);
                break;
            case "r":
                button.setHorizontalAlignment(SwingConstants.RIGHT);
                break;    
            default:
                break;
        }
        return button;
    }
    
    public static JButton getButton(Icon icono, int x, int y, Cursor cursor, String direccion){
        JButton button = new JButton();
        button.setSize(icono.getIconWidth(), icono.getIconHeight());
        button.setLocation(x, y);
        button.setFocusable(false);
        button.setCursor(cursor);
        button.setIcon(icono);
        button.setContentAreaFilled(true);
        switch(direccion){
            case "l":
                button.setHorizontalAlignment(SwingConstants.LEFT);
                break;
            case "r":
                button.setHorizontalAlignment(SwingConstants.RIGHT);
                break;    
            default:
                break;
        }
        return button;
    }
        
}