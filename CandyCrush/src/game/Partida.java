package game;

import game.Jugador;
import controllers.PlayerController;
import gui.ventanas.Ventana;

import javax.swing.JOptionPane;

public class Partida {
    //estados
    private enum Estado {GANAR, PERDER, CONTINUAR};

    //referencia unica
    private static Partida partida;

    // Atributos
    private Jugador jugador;
    private PlayerController controlador;
    private Ventana ventana;
    private Estado estado;

    /**
     * Ejemplifica variables del juego, crea ventana y almacena referencia
     */
    public Partida() {
        this.jugador = new Jugador(JOptionPane.showInputDialog(null, "Ingrese su nombre: ", "Nombre jugador", JOptionPane.QUESTION_MESSAGE));
        this.controlador = new PlayerController();
        this.ventana = new Ventana();
        partida = this;
    }

    public static Partida getReferencia(){
        return partida;
    }

    public Jugador getJugador(){
        return jugador;
    }

    /**
     * Actualiza el estado del juego
     */
    private void evaluarEstado(){
        if(jugador.getPuntaje() > 999)
            estado = Estado.GANAR;
        else if(jugador.getVidasRestantes() == 0 && jugador.getTurnosRestantes() == 0)
            estado = Estado.PERDER;
        else
            estado = Estado.CONTINUAR;
    }

}
