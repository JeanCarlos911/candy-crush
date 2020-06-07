package Game;

import GUI.Menu;

public class Partida {
    //Atributos
    private Tablero tablero;
    private Jugador jugador;
    private long puntuacionAcumulada;
    
    //Metodos propios de la partida
    /**
     * crea y establece valores iniciales para tablero, jugador y puntuacionAcumulada
     */
    public Partida(String nombre){
        //tablero
        tablero = new Tablero();
        tablero.generarTablero();
        
        //jugador
        jugador = new Jugador();
        jugador.setNombre(nombre);
        jugador.setNombre(nombre);
        jugador.setNumeroMovimientos(50);
        jugador.setVidasRestantes(4);
        
        //puntuacionAcumulada
        puntuacionAcumulada = 0;
    }

    public long getPuntuacionAcumulada(){
        return this.puntuacionAcumulada;
    }
    
    /**
     * inicia partida nueva 
     */
    public void iniciarPartida(){
        //genera nuevo tablero
        tablero.generarTablero();
        
        //reestablece puntuacion
        puntuacionAcumulada = 0;
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
        //imprime que ha perdido y se va al menu principal
        System.out.println("No hay vidas suficientes para continuar jugando, you lose!");
        Menu.iniciar();
        
    }
}
