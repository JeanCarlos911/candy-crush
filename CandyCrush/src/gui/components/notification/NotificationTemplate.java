package gui.components.notification;

//Elementos Graficos
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
//Elementos decoradores
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
//Eventos
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class NotificationTemplate extends JPanel implements ActionListener {

    
    private static final long serialVersionUID = 1L;
    private final int ancho = 500, alto = 300;
    private JPanel panelInterno;
    private JLabel titulo,img1;
    private JButton btnFinalizar;
    private final String font = "P052";

    public NotificationTemplate(){

        setLayout(null);
        //setBackground(new Color(239,243,143));
        setBackground(new Color(87,119,230));
        setSize(new Dimension(ancho,alto));
        setLocation(0, 0);        

        panelInterno = new JPanel();
        panelInterno.setLayout(null);
        panelInterno.setSize(new Dimension(380,alto));
        panelInterno.setLocation((this.getWidth() - panelInterno.getWidth())/2,0);
        panelInterno.setBackground(new Color(255,255,153));
        //panelInterno.setBackground(Color.WHITE);
        
        titulo = new JLabel("Felicidades Ganaste");
        titulo.setSize(new Dimension(200,30));
        titulo.setLocation((panelInterno.getWidth() - titulo.getWidth())/2,20);
        titulo.setFont(new Font(font,Font.BOLD,20));
        titulo.setForeground(new Color(153,76,0));

        img1 = new JLabel();
        img1.setSize(new Dimension(100,100));
        img1.setIcon(new ImageIcon("../resources/game/star.png"));
        img1.setLocation((panelInterno.getWidth() - img1.getWidth())/2,50);

        btnFinalizar = new JButton("Continuar");
        btnFinalizar.setSize(new Dimension(150,40));
        btnFinalizar.setBackground(new Color(102,204,0));
        btnFinalizar.setForeground(Color.white);
        btnFinalizar.setFocusable(false);
        btnFinalizar.setFont(new Font(font,Font.BOLD,25));
        btnFinalizar.setLocation((panelInterno.getWidth() - btnFinalizar.getWidth())/2,200);
        btnFinalizar.addActionListener(this);
        
       panelInterno.add(btnFinalizar);
       panelInterno.add(titulo);
       add(panelInterno);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.exit(0);
    }
    
}