package Game;

import GUI.Estado;
import GUI.Menu;
import controllers.PlayerController;

public class Partida {
    // Atributos
    private Tablero tablero;
    private Jugador jugador;
    private long puntuacionAcumulada;
    private PlayerController controlador;
    private Nivel nivel;

    // Metodos propios de la partida

    /**
     * crea y establece valores iniciales para tablero, jugador y
     * puntuacionAcumulada
     * 
     * @param nombre nombre del jugador que jugara en la partida
     */
    public Partida(String nombre) {
        this.nivel = new Nivel();

        this.tablero = new Tablero();

        this.jugador = new Jugador(nombre);

        this.controlador = new PlayerController();

        this.puntuacionAcumulada = 0;
    }

    public long getPuntuacionAcumulada() {
        return this.puntuacionAcumulada;
    }

    /**
     * inicia partida nueva
     */
    public void pedirEntrada() {
        while (this.jugador.getVidasRestantes() > 0 || this.jugador.getNumeroMovimientos() > 0) {
            Estado.actualizarDibujoJuego(this, this.jugador, this.tablero, this.nivel);
            controlador.setPosicion();
            jugador.restarMovimientos();
        }
    }

    public void iniciarPartida() {

        tablero.generarTablero();
        this.puntuacionAcumulada = 0;
        this.pedirEntrada();

    }

    /**
     * Revisa si el jugador dispone de movimientos, si son cero revisa si tiene
     * vidas disponibles para iniciar otra partida de lo contrario se iniciara el
     * evento perder
     * 
     * /** acciones que se ejecutaran cuando el jugador se quede sin vidas
     */
    public static void eventoPerder() {
        System.out.println("No hay vidas suficientes para continuar jugando, you lose!");
        Menu.iniciar();
    }

}
