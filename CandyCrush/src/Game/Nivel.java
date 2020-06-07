package Game;

public class Nivel {
    //Atributos
    private int nivel;
    private String nombre;
    private long puntuacionObjetivo;
    
    //creacion del Nivel
    public Nivel(){
        //Valores iniciales por defecto
        nivel=1;
        nombre="Jelly";
        puntuacionObjetivo=1000;
    }

//Metodos propios del Nivel-----------------------------------------------
    
    //metods setters y getters
    public String getNombre(){
        return this.nombre;
    }
    
    /**
     * Este metodo por ahora solo cambia de nivel segun la puntuacion dada y
     * devuelve un boolean que envia si hubo cambio de nivel (true) o no (false);
     * @param puntuacion long puntuacion actual@
     */
    public boolean pasarNivel(long puntuacion){
        if(puntuacion>=puntuacionObjetivo){
            nivel+=1;
            puntuacionObjetivo+=500;
            if(nivel==2){
                nombre="Ingredient";
            }else if(nivel==3){
                nombre="Timed";
            }else{
                nombre="Jelly extra";
            }
            return true;
        }else{
            return false;
        }
    }
    
}
