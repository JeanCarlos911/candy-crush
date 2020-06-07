package Game;

public class Jugador {

    //Atributos
    private String nombre;
    private int vidasRestantes;
    private int numeroMovimientos;

    //Metods setter y getter
    public void setVidasRestantes(int vidasRestantes){
        this.vidasRestantes = vidasRestantes;
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

    public void setNumeroMovimientos(int numeroMovimientos){
        this.numeroMovimientos = numeroMovimientos;
    }

    public int getNumeroMovimientos(){
        return this.numeroMovimientos;
    }

    //Metodos propios del jugador
    
}