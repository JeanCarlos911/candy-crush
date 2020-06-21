package Game;

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
    
    //Setters y getters
    public String getNombre(){
        return this.nombre;
    }
    
    public long getPuntuacionObjetivo(){
        return this.puntuacionObjetivo;
    }
    
    /**
     * Este metodo por ahora solo cambia de nivel segun la puntuacion dada y
     * devuelve un boolean que envia si hubo cambio de nivel (true) o no (false);
     * @param puntuacion long puntuacion actual@
     */
    public boolean pasarNivel(long puntuacion){ 

        if(puntuacion>=puntuacionObjetivo){

            this.nivel += 1;
            this.puntuacionObjetivo += 500;

            if(this.nivel == 2){

                this.nombre = "Ingredient";

            }else if( this.nivel == 3){

                this.nombre = "Timed";

            }else{
                this.nombre = "Jelly extra";
            }

            return true;
            
        }else{
            return false;
        }
    }
    
}
