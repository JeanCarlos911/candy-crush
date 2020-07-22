package gui.components.AsideComponent;

import javax.swing.JFrame;
import game.Jugador;

public class TestTemplate extends JFrame {
 
    private static final long serialVersionUID = 1L;
    private AsideTemplate prueba;

    public TestTemplate(){
        prueba = new AsideTemplate(new Jugador("Ser"),1000,0);
        setSize(1200,750);
        setLayout(null);
        add(prueba);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
}