package game;

import gui.main.MainTemplate;
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
            //Estado.actualizarDibujoJuego(this, this.jugador, this.tablero, this.nivel);
            controlador.setPosicion();
            tablero.moverDulce(controlador.getPosiciones());
            tablero.setPuntuacion(0);
            jugador.restarMovimientos();
            if(tablero.actualizarTablero()){
                this.puntuacionAcumulada += tablero.getPuntuacion();
                if(evaluarGanar()==true){
                    //MainTemplate.finalizar();
                    break;
                }
            }else {
                tablero.moverDulce(controlador.getPosiciones(-1));
                pedirEntrada();
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
            //Estado.perder();
        }
        //MainTemplate.finalizar();
    }

    /**
     * Revisa si el jugador ha llegado a la puntuacion objetivo, en caso afirmativo
     * imprime que ha ganado y retorna true
     * @return true si el jugador gana
     */
    public boolean evaluarGanar() {
        if(this.puntuacionAcumulada>=nivel.getPuntuacionObjetivo()){
            System.out.println("\n\n\n\n");
            for(int i=0; i<100; i++){
                System.out.print("-");
            }
            System.out.println("\n\n\t\tSuperaste el único nivel desarrollado hasta el momento\n"
                         + "\t\t\t\t    ¡ HAS GANADO !\n");
            for(int i=0; i<100; i++){
                System.out.print("-");
            }
            System.out.println();
            return true;
        }else{
            return false;
        }
    }

}
