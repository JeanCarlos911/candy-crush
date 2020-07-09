package app.service;

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

public class Interfaz{
    
    private Interfaz(){
    }
    
    /**
     * Retorna JPanel con propiedades dadas
     * @param x
     * @param y
     * @param ancho
     * @param largo
     * @param color
     * @return 
     */
    public static JPanel panel(int x, int y, int ancho, int largo, Color color){
        JPanel panel = new JPanel();
        panel.setBounds(x, y, ancho, largo);
        panel.setLayout(null);
        panel.setBackground(color);
        return panel;
    }
    
    /**
     * Retorna JLabel con propiedades dadas
     * @param icono
     * @param x
     * @param y
     * @return 
     */
    public static JLabel labelIcono(Icon icono, int x, int y){
        JLabel label = new JLabel();
        label.setSize(icono.getIconWidth(), icono.getIconHeight());
        label.setLocation(x, y);
        label.setIcon(icono);
        return label;
    }
    
    /**
     * Este metodo retorna un label con texto
     *
     * @param cadena cadena a mostrar en panel
     * @param x posicion x del texto 
     * @param y posicion y del texto
     * @param ancho ancho del label del texto
     * @param alto alto del label del texto
     * @param colorFuente color del texto
     * @param fuente fuente del texto
     * @return label con propiedades dadas
     **/
    public static JLabel texto(String cadena, int x, int y, int ancho, int alto, Color colorFuente,Font fuente){        
        JLabel label= new JLabel(cadena);
        label.setSize(ancho, alto);
        label.setLocation(x, y);
        label.setForeground(colorFuente);
        label.setFont(fuente);
        return label;
    }
    
    /**
     * Este metodo retorna un icono
     *
     * @param o ventana o frame que requiere la imagen
     * @param ruta ruta del icono
     * @param width ancho de la imagen
     * @param height alto de la imagen
     * @return icono
     **/
    public static Icon icono(Object o, String ruta, int width, int height){
        ImageIcon iIcono = new ImageIcon(o.getClass().getResource(ruta));
        Icon icono = new ImageIcon(iIcono.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT));
        return icono;
    }
    
    /**
     * Para dar propiedades y hacer visible a una ventana dada
     * @param frame ventana
     * @param ancho ancho de la centana
     * @param alto alto de la ventana
     * @param titulo titulo de la ventana
     */
    public static void frame(JFrame frame, int ancho, int alto, String titulo){
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setTitle(titulo);
        frame.setSize(ancho, alto);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    /**
     * Retorna un JButton con propiedades dadas
     * @param texto
     * @param x
     * @param y
     * @param ancho
     * @param alto
     * @param cursor
     * @param imagen
     * @param fuente
     * @param colorFondo
     * @param colorFuente
     * @param borde
     * @param direccion
     * @param esSolido
     * @return
     */
    public static JButton construirJButton(String texto, int x, int y, int ancho, int alto, Cursor cursor, ImageIcon imagen, Font fuente, 
        Color colorFondo, Color colorFuente,Border borde, String direccion, boolean esSolido){
        
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

}
