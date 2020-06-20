package Game;

import GUI.Estado;
import GUI.Menu;

public class Partida {
    //Atributos
    private Tablero tablero;
    private Jugador jugador;
    private long puntuacionAcumulada;
    private Nivel nivel;
    
//Metodos propios de la partida
    
    /**
     * crea y establece valores iniciales para tablero, jugador y puntuacionAcumulada
     * @param nombre nombre del jugador que jugara en la partida
     */
    public Partida(String nombre){
        this.nivel = new Nivel();
        
        this.tablero = new Tablero();
        
        this.jugador = new Jugador();
        this.jugador.setNombre(nombre);
        this.jugador.setNumeroMovimientos(50);
        this.jugador.setVidasRestantes(4);
        
        
        this.puntuacionAcumulada = 0;
    }

    public long getPuntuacionAcumulada(){
        return this.puntuacionAcumulada;
    }
    
    /**
     * inicia partida nueva 
     */
    public void iniciarPartida(){
        
        tablero.generarTablero();
        puntuacionAcumulada = 0;
        Estado.actualizarDibujoJuego(this, this.jugador, this.tablero, this.nivel);
    }
    
    /**
     * Revisa si el jugador dispone de movimientos, si son cero revisa si tiene vidas
     * disponibles para iniciar otra partida de lo contrario se iniciara el evento perder
     */
    public void evaluarPerder(){
        
        if(jugador.getNumeroMovimientos()==0){

            if(jugador.getVidasRestantes()>0){

                jugador.setNumeroMovimientos(50);
                jugador.setVidasRestantes(jugador.getVidasRestantes()-1);
                iniciarPartida();

            }else{
                eventoPerder();
            }
        }
    }
    
    /**
     * acciones que se ejecutaran cuando el jugador se quede sin vidas
     */
    public void eventoPerder(){
        System.out.println("No hay vidas suficientes para continuar jugando, you lose!");
        Menu.iniciar();
    }
    
}
