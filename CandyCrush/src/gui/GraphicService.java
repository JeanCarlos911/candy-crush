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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public final class GraphicService {
    
    private static GraphicService service;

    private GraphicService(){
    }
    
    public static  Icon getIcon(String ruta, int width, int height){
        ImageIcon iIcono = new ImageIcon(Icon.class.getResource(ruta));
        Icon icono = new ImageIcon(iIcono.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT));
        return icono;
    }
    
    public JPanel setPanel(JPanel panel, int x, int y, int ancho, int largo){
        panel.setBounds(x, y, ancho, largo);
        panel.setLayout(null);
        return panel;
    }
    
    public JPanel getPanel(int x, int y, int ancho, int largo){
        JPanel panel = new JPanel();
        setPanel(panel, x, y, ancho, largo);
        return panel;
    }
    
    public JPanel getPanel(int x, int y, int ancho, int largo, Color color){
        JPanel panel = getPanel(x, y, ancho, largo);
        panel.setBackground(color);
        return panel;
    }
    
    public JLabel getLabel(Icon icono, int x, int y){
        JLabel label = new JLabel();
        label.setSize(icono.getIconWidth(), icono.getIconHeight());
        label.setLocation(x, y);
        label.setIcon(icono);
        return label;
    }
    
    public JLabel getLabel(Icon icono, int x, int y, Cursor cursor){
        JLabel label = getLabel(icono, x, y);
        label.setCursor(cursor);
        return label;
    }
    
    public JLabel getLabel(String cadena, int x, int y, int ancho, int alto, Color colorFuente, Font fuente){        
        JLabel label= new JLabel(cadena);
        label.setSize(ancho, alto);
        label.setLocation(x, y);
        label.setForeground(colorFuente);
        label.setFont(fuente);
        return label;
    }
    
    public void setFrame(JFrame frame, int ancho, int alto, String titulo){
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setTitle(titulo);
        frame.setSize(ancho, alto);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public JFrame getFrame(int ancho, int alto, String titulo){
        JFrame frame = new JFrame();
        setFrame(frame, ancho, alto, titulo);
        return frame;
    }
    
    public JButton getButton(int x, int y, Icon icono, Cursor cursor){
        JButton button = new JButton();
        button.setContentAreaFilled(false);
        button.setBorder(null);
        button.setLocation(x, y);
        button.setCursor(cursor);
        button.setFocusable(false);
        if(icono != null){
            button.setIcon(icono);
            button.setSize(icono.getIconWidth(), icono.getIconHeight());
        }
        return button;
    }
    
    public JButton getButton(int x, int y, int ancho, int alto, Cursor cursor, Icon icono, Color colorFondo, boolean esSolido){
        JButton button = getButton(x, y, icono, cursor);
        button.setSize(ancho, alto);
        button.setBackground(colorFondo);
        button.setContentAreaFilled(esSolido);
        return button;
    }
    
    public JButton getButton(String texto, int x, int y, int ancho, int alto, Cursor cursor, Icon icono, Font fuente, Color colorFondo,
            Color colorFuente,Border borde, String direccion, boolean esSolido){
        
        JButton button = getButton(x, y, ancho, alto, cursor, icono, colorFondo, esSolido);
        button.setText(texto);
        button.setFont(fuente);
        button.setForeground(colorFuente);
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
    
    public JTextField getJTextField(int x, int y, int width, int height, String text, Color foreground, Color background, Color caret,
            String alignment){
        JTextField textField = new JTextField(text);
        textField.setSize(width, height);
        textField.setLocation(x, y);
        textField.setForeground(foreground);
        textField.setBackground(background);
        textField.setCaretColor(caret);
        switch (alignment) {
            case "CENTER":
                textField.setHorizontalAlignment(0);
                break;
            case "RIGTH":
                textField.setHorizontalAlignment(4);
                break;
            case "TOP":
                textField.setHorizontalAlignment(1);
                break;
            case "BOTTOM":
                textField.setHorizontalAlignment(3);
                break;
            default:
                textField.setHorizontalAlignment(2);
                break;
        }
        return textField;
    }
    
    public static GraphicService getService(){
        if(service == null)
            service = new GraphicService();
        return service;
    }

}