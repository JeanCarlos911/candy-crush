package Game;

import java.util.Scanner;

public class Partida {
    //Atributos
    private Tablero tablero;
    private Jugador jugador;
    private long puntuacionAcumulada;
    
//Metodos propios de la partida
    /**
     * crea y establece valores iniciales para tablero, jugador y puntuacionAcumulada
     */
    public Partida(){
        //inicializar scanner para su posterior uso
        Scanner in = new Scanner(System.in);
        
        //tablero
        tablero = new Tablero();
        tablero.generarTablero();
        
        //jugador
        jugador = new Jugador();
        System.out.println("ingrese nombre del jugador");
        jugador.setNombre(in.nextLine());
        jugador.setNumeroMovimientos(50);
        jugador.setVidasRestantes(4);
        
        //puntuacionAcumulada
        puntuacionAcumulada = 0;
    }
    
    /**
     * inicia partida nueva 
     */
    private void iniciarPartida(){
        //genera nuevo tablero
        tablero.generarTablero();
        
        //reestablece puntuacion
        puntuacionAcumulada = 0;
    }
    
    /**
     * Revisa si el jugador dispone de movimientos, si son cero revisa si tiene vidas
     * disponibles para iniciar otra partida de lo contrario se iniciara el evento perder
     */
    private void evaluarPerder(){
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
    private void eventoPerder(){
        //en proceso
    }
}
