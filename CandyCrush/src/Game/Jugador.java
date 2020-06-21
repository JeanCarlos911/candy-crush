package Game;


public class Jugador {

    //Atributos
    private String nombre;
    private int vidasRestantes;
    private int numeroMovimientos;

    public Jugador(String nombre){
        this.nombre = nombre;
        this.vidasRestantes = 5;
        this.numeroMovimientos = 50;
    }

    //Methods setters y getters
    public void bajarVida(){
        this.vidasRestantes -= 1;
    }

    public int getVidasRestantes(){
        return this.vidasRestantes;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void restarMovimientos(){
        if(numeroMovimientos > 0){
            numeroMovimientos -= 1;
        }else if(vidasRestantes > 0){
            numeroMovimientos += 49;
            vidasRestantes -= 1;
        }else{
            Partida.eventoPerder();
        }
        
        
    }

    public int getNumeroMovimientos(){
        return this.numeroMovimientos;
    }

    //Metodos propios del jugador
    
}