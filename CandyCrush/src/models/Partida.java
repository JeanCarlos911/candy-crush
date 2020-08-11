package models;

import gui.ventanas.Ventana;

public class Partida {
    
    //referencia unica
    private static Partida partida;

    // Atributos
    private Jugador jugador;
    private Ventana ventana;

    /**
     * Ejemplifica variables del juego, crea ventana y almacena referencia
     */
    public Partida(String nombre) {
        this.jugador = Jugador.getReference(nombre);
        this.ventana = new Ventana();
        partida = this;
    }

    public Ventana getVentana(){
        return ventana;
    }

    public static Partida getReferencia(){
        return partida;
    }

    public Jugador getJugador(){
        return jugador;
    }

    

}
