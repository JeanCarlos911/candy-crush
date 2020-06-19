package Game;

public class Tablero {
    //Atributos
    private Dulce matriz[][];

    public Tablero(){
        this.matriz = new Dulce[9][9];
    }

    public void setDulce(int fila,int columna,Dulce dulce){
        this.matriz[fila][columna] = dulce;
    }

    public Dulce getDulce(int fila,int columna){
        return this.matriz[fila][columna];
    }
    
    public void actualizarTablero(){
        
        while(this.verificarTablero()){

            this.eliminarDulces();
            this.validarPuntuacion();
            this.caerDulces();
            this.llenarDulces();
        }
    }

    public void generarTablero(){
        
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                this.setDulce(i, j, new Dulce(Dulce.formaRamdon()));          
            }
        }
    }

    public void moverDulce(int xi,int yi,int xf,int yf){

        if(Math.abs(xf-xi) == 1 || Math.abs(yf-yi) == 1){

            Dulce cambio = this.getDulce(xf, yf);
            Dulce dulceAmover = this.getDulce(xi,yi);

            this.setDulce(xi, yi, cambio);
            this.setDulce(xf, yf, dulceAmover);

        }
        
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
        
        for(int i = 0; i < 8; i++){
            for(int j = 0; i < 8; j++){
                try{
                    if(this.getDulce(i,j) != null && this.getDulce(i+1,j) == null){
                        Dulce dulceCayo = this.getDulce(i,j);
                        this.setDulce(i, j, null);
                        this.setDulce(j+1, j, dulceCayo);
                        this.llenarDulces();

                    }
                }catch(ArrayIndexOutOfBoundsException e){}
            }
                
        }
    }

    private boolean hayFila(){

        int fila = 0,columna = 0,contadorDulces = 1;
        boolean filas = false;

        while(fila < 8){
            while(columna < 7){
                if(this.getDulce(fila, columna).getForma() == this.getDulce(fila, columna+1).getForma()){
                    contadorDulces += 1;
                    columna += 1;
                }else{
                    if(contadorDulces >= 3 && contadorDulces <= 6){
                        filas = true;
                        return filas;
                    }else{
                        contadorDulces = 0;
                        columna = 0;
                        fila += 1;
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
            while(fila < 7){
                if(this.getDulce(fila, columna).getForma() == this.getDulce(fila+1, columna).getForma()){
                    contadorDulces += 1;
                    fila += 1;
                }else{
                    if(contadorDulces >= 3 && contadorDulces <= 6){
                        columnas = true;
                        return columnas;
                    }else{
                        contadorDulces = 0;
                        fila = 0;
                        columna += 1;
                    }
                    
                }
            }
            
        }
        
        return columnas;
    }

    private boolean verificarTablero() {
        boolean estado = false;

        if(this.hayFila() || this.hayColumna()){
            estado = true;
        }

        return estado;
    }

    private void eliminarDulces() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    private void validarPuntuacion() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}