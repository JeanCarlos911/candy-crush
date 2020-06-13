package Game;

public class Dulce {

    private int forma;
    
    /**
     * Establece forma inicial del dulce al crearse
     * @param forma es un int representativo de la forma
     */
    public Dulce(int forma){
        this.forma = forma;
    }
    
    /**
     * Devuelve una forma aleatoria a traves de un int representativo
     * @return int representativo
     */
    public static int formaRamdon(){
        int numeroAleatorio = (int)(Math.random()*6+1);
        return numeroAleatorio;
    }
    
    /**
     * Retorna forma del dulce
     * @return int representativo de la forma
     */
    public int getForma(){
        return this.forma;
    }
    
}