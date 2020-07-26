package models;

public class Nivel {

    private int nivel;
    private String nombre;
    private long puntuacionObjetivo;
    
    //creacion del Nivel
    public Nivel(){
        this.nivel = 1;
        this.nombre = "Jelly";
        this.puntuacionObjetivo = 1000;
    }
    
    /**
     * Retorna nombre del nivel
     * @return string nombre del nivel actual
     */
    public String getNombre(){
        return this.nombre;
    }
    
    /**
     * Retorna puntuacion objetivo del nivel actual
     * @return long puntuacion objetivo
     */
    public long getPuntuacionObjetivo(){
        return this.puntuacionObjetivo;
    }

    public int getNivel(){
        return this.nivel;
    }

}
