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

    /**
     * crea y establece valores iniciales para tablero, jugador con su controlador y
     * puntuacionAcumulada
     * @param nombre nombre del jugador que jugara en la partida
     */
    public Partida(String nombre) {
        this.puntuacionAcumulada = 0;
        this.nivel = new Nivel();
        this.jugador = new Jugador(nombre);
        this.tablero = new Tablero();
        this.controlador = new PlayerController();
    }

    public long getPuntuacionAcumulada() {
        return this.puntuacionAcumulada;
    }

    /**
     * Inicia la secuencia de entradas del jugador hasta que pierda o gane
     */
    public void pedirEntrada() {
        while (this.jugador.getVidasRestantes() > 0 || this.jugador.getNumeroMovimientos() > 0) {
            Estado.actualizarDibujoJuego(this, this.jugador, this.tablero, this.nivel);
            controlador.setPosicion();
            tablero.moverDulce(controlador.getPosiciones());
            tablero.setPuntuacion(0);
            tablero.actualizarTablero();
            this.puntuacionAcumulada += tablero.getPuntuacion();
            jugador.restarMovimientos();
            if(evaluarGanar()==true){
                Menu.finalizar();
                break;
            }
        }
        evaluarPerder();
    }
    
    /**
     * inicia partida nueva
     */
    public void iniciarPartida() {
        tablero.generarTablero();
        tablero.organizar();
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
    public void evaluarPerder() {
        if(this.puntuacionAcumulada<nivel.getPuntuacionObjetivo()){
            System.out.println("No hay vidas suficientes ni turnos para continuar jugando y no alcanzó la meta establecida\n"
                    + "     ¡ HAS PERDIDO !");
        }
        Menu.finalizar();
    }

    /**
     * Revisa si el jugador ha llegado a la puntuacion objetivo, en caso afirmativo
     * imprime que ha ganado y retorna true
     * @return true si el jugador gana
     */
    public boolean evaluarGanar() {
        if(this.puntuacionAcumulada>=nivel.getPuntuacionObjetivo()){
            System.out.println("Superaste el único nivel desarrollado hasta el momento\n"
                    + "     ¡ HAS GANADO !");
            return true;
        }else{
            return false;
        }
    }

}
