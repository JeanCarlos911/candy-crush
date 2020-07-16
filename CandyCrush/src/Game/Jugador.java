package game;

public class Jugador {
    //Atributos
    private String nombre;
    private int vidasRestantes;
    private int numeroMovimientos;
    
    /**
     * Establece valores iniciales del jugador
     * @param nombre nombre del jugador
     */
    public Jugador(String nombre){
        this.nombre = nombre;
        this.vidasRestantes = 5;
        this.numeroMovimientos = 50;
    }

    /**
     * retorna el numero de vidas restantes del jugador
     * @return int vidas restantes
     */
    public int getVidasRestantes(){
        return this.vidasRestantes;
    }

    /**
     * Retorna nombre del jugador
     * @return String nombre del jugador
     */
    public String getNombre(){
        return this.nombre;
    }
    
    /**
     * Retorna numero de movimientos restantes del jugador
     * @return int numero de movimientos restantes
     */
    public int getNumeroMovimientos(){
        return this.numeroMovimientos;
    }
    
    /**
     * Resta la vida del jugador en 1
     */
    public void bajarVida(){
        this.vidasRestantes --;
    }

    /**
     * Este metodo resta un  movimiento al jugador o vida según corresponda
     */
    public void restarMovimientos(){
        if(numeroMovimientos > 0){
            numeroMovimientos --;
        }else if(vidasRestantes > 0){
            numeroMovimientos += 49;
            vidasRestantes --;
        }
    }

}