package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public final class Recurso {

    public static final Color 
    //Paletas de colores--------------------------------------------------------
        //paleta estándar
        COLOR_CYAN = new Color(72, 206, 247),
        COLOR_CYAN_OSCURO = new Color(70, 147, 171),
        
        //paleta verde pastel complementario
        COLOR_VERDE_CLARO = new Color(193, 255, 171),
        COLOR_VERDE = new Color(122, 179, 102),
        COLOR_VERDE_PASTEL = new Color(212, 255, 196),
        COLOR_MORADO = new Color(179, 84, 167),
        COLOR_MORADO_CLARO = new Color(255, 171, 245);
    
    public static final Font 
    //Fuentes-------------------------------------------------------------------
        //fuentes estándar
        FUENTE_TITULO = new Font("Gill Sans MT Condensed", Font.PLAIN, 64),
        FUENTE_SUBTITULO = new Font("Gill Sans MT Condensed", Font.PLAIN, 32),
        FUENTE_TITULO_JUEGO = new Font("Imprint MT Shadow", Font.PLAIN, 72),
        FUENTE_VERSION = new Font("Arial", Font.PLAIN, 14),
        FUENTE_OPCION = new Font("Arial Narrow", Font.PLAIN, 18);
    
    public static final Cursor
    //Cursores------------------------------------------------------------------
        //cursores estándar
        CURSOR_MANO = new Cursor(Cursor.HAND_CURSOR);;
    
    public static final Border
    //Bordes--------------------------------------------------------------------
        //bordes estándar
        BORDE_NEGRO = BorderFactory.createLineBorder(Color.black, 2, true),
        BORDE_GRIS = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true);
    
    private Recurso(){
    }
    
}
