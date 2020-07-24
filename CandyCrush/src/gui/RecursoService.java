package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class RecursoService {

    private static RecursoService service;

    public final Color 
    //Paletas de colores--------------------------------------------------------
        //estandat
        BLACK = new Color(0, 0, 0),
        RED = new Color(255, 0, 0),
        
        //paleta verde pastel complementario
        VERDE_CLARO = new Color(193, 255, 171),
        VERDE = new Color(122, 179, 102),
        VERDE_PASTEL = new Color(212, 255, 196),
        MORADO = new Color(179, 84, 167),
        MORADO_CLARO = new Color(255, 171, 245),
            
        //especiales
        CYAN = new Color(72, 206, 247),
        CYAN_OSCURO = new Color(70, 147, 171),
        OCRE_OSCURO = new Color(169, 105, 0),
        MOSTAZA = new Color(255, 225, 0),
        AZUL_GRIS_OSCURO = new Color(58, 117, 181),
        AZUL_GRIS = new Color(82, 125, 181);
        
    public final Font 
    //Fuentes-------------------------------------------------------------------
        //fuentes estandar
        FUENTE_TITULO = new Font("Gill Sans MT Condensed", Font.PLAIN, 64),
        FUENTE_SUBTITULO = new Font("Gill Sans MT Condensed", Font.PLAIN, 32),
        FUENTE_TITULO_JUEGO = new Font("Imprint MT Shadow", Font.PLAIN, 72),
        FUENTE_VERSION = new Font("Arial", Font.PLAIN, 14),
        FUENTE_OPCION = new Font("Arial Narrow", Font.PLAIN, 18);
    
    public final Cursor
    //Cursores------------------------------------------------------------------
        //cursores estandar
        CURSOR_DEFECTO = new Cursor(0),
        CURSOR_CRUZ = new Cursor(1),
        CURSOR_TEXTO = new Cursor(2),
        CURSOR_ESPERAR = new Cursor(3),
        CURSOR_N_RESIZE = new Cursor(8),
        CURSOR_E_RESIZE = new Cursor(11),
        CURSOR_MANO = new Cursor(12),
        CURSOR_MOVER = new Cursor(13);
    
    public final Border
    //Bordes--------------------------------------------------------------------
        //bordes estandar
        BORDE_NEGRO = BorderFactory.createLineBorder(Color.black, 2, true),
        BORDE_GRIS = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true);
    
    private RecursoService(){
    }

    public static RecursoService getService(){
        if(service == null)
            service = new RecursoService();
        return service;
    }
    
}
