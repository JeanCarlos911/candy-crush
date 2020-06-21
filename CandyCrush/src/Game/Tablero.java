package Game;

public class Tablero {
    //Atributos
    private Dulce matriz[][];
    private long puntuacion;
    /**
     * Al crear un tablero, se establece el tamaño de la matriz de dulces
     */
    public Tablero(){
        this.matriz = new Dulce[9][9];
    }

    public void setDulce(int fila,int columna,Dulce dulce){
        this.matriz[fila][columna] = dulce;
    }

    public Dulce getDulce(int fila,int columna){
        return this.matriz[fila][columna];
    }

    public void setPuntuacion(long puntuacion){
        this.puntuacion = puntuacion;
    }

    public long getPuntuacion(){
        return this.puntuacion;
    } 
    
    public void actualizarTablero(){
        
        while(this.verificarTablero()){

            //this.eliminarDulces();
            //this.validarPuntuacion();
            this.caerDulces();
            this.llenarDulces();
        }
    }

    public void organizar(){
        
        while(this.verificarTablero()){

            //this.eliminarDulces();
            this.caerDulces();
            this.llenarDulces();
        }
    }

    public void generarTablero(){
        
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                this.setDulce(i, j, new Dulce(Dulce.formaRamdon()));          
            }
        }
    }

    public void moverDulce(int[] arreglo){

        Dulce cambio = this.getDulce(arreglo[2], arreglo[3]);
        Dulce dulceAmover = this.getDulce(arreglo[0],arreglo[1]);

        this.setDulce(arreglo[0], arreglo[1], cambio);
        this.setDulce(arreglo[2], arreglo[3], dulceAmover);

    }

    private void llenarDulces(){
        
        for(int i = 0; i < 8; i++){
            for(int j = 0; i < 8; j++){
                if(this.getDulce(i, j) == null){
                    this.setDulce(i, j,new Dulce(Dulce.formaRamdon()));
                } 
            }
        }
    }

    private void caerDulces(){
        
        for(int i = 0; i <= 7; i++){
            for(int j = 0; i < 8; j++){
                if(this.getDulce(i,j) != null && this.getDulce(i+1,j) == null){
                    Dulce dulceCayo = this.getDulce(i,j);
                    this.setDulce(i, j, null);
                    this.setDulce(j+1, j, dulceCayo);
                    this.llenarDulces();

                }
                
            }
                
        }
    }

    private boolean hayFila(){

        int fila = 0,columna = 0,contadorDulces = 1;
        boolean filas = false;

        while(fila < 8){
            while(columna <= 7){
                if(this.getDulce(fila, columna).getForma() == this.getDulce(fila, columna+1).getForma()){
                    contadorDulces += 1;
                    columna += 1;
                }else{
                    if(contadorDulces >= 3 && contadorDulces <= 6){
                        filas = true;
                        this.validarPuntuacion(contadorDulces);
                        return filas;
                    }else{
                        /*Si no ha formado la fila indeendientemente de si debe seguir recorriendola
                          El contador de dulces se vuelve a resetear
                        */
                        contadorDulces = 1;

                        /*Condicion para mirar si esta en la penultima columna y debe pasar a la siguiente
                        fila o se mantiene en la misma*/

                        if(columna >= 7){
                            columna = 0;
                            fila += 1;
                        }else{
                            columna += 1;
                        }
                        
                    }   
                }
            }
            
        }
        
        return filas;
    }

    private boolean hayColumna(){

        int fila = 0,columna = 0,contadorDulces = 1;
        boolean columnas = false;

        while(columna < 8){
            while(fila <= 7){
                if(this.getDulce(fila, columna).getForma() == this.getDulce(fila+1, columna).getForma()){
                    contadorDulces += 1;
                    fila += 1;
                }else{
                    if(contadorDulces >= 3 && contadorDulces <= 6){
                        columnas = true;
                        this.validarPuntuacion(contadorDulces);
                        return columnas;
                    }else{
                        contadorDulces = 0;
                        if(fila >= 7){
                            fila = 0;
                            columna += 1;
                        }else{
                            fila += 1;
                        }
                    }
                    
                }
            }
            
        }
        
        return columnas;
    }

    private boolean verificarTablero() {
        if(this.hayFila() || this.hayColumna()){
            return true;
        }
        return false;
    }

    private void eliminarDulces() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    private void validarPuntuacion(int cantidadDulces) {
        switch(cantidadDulces){
            case 3:
                this.puntuacion += 50;
                break;
            case 4:
                this.puntuacion += 100;
                break;
            case 5:
                this.puntuacion += 200;
                break;
            case 6:
                this.puntuacion += 400;
                break;
            default:
                this.puntuacion += 0;
                break;

        }
    }
    
}