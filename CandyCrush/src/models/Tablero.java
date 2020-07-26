package models;

import controllers.TableroController;

public class Tablero {
    //Atributos
    private Dulce matriz[][];
    private boolean llamada;
    private TableroController tableroController;
    
    /**
     * Al crear un tablero, se establece el tamaño de la matriz de dulces
     */
    public Tablero(){
        this.matriz = new Dulce[9][9];
        tableroController = new TableroController(this);
        generarTablero();
    }

    public TableroController getController(){
        return tableroController;
    }
    
    public Dulce[][] getMatriz(){
        return matriz;
    }    
    
    /**
     * Establece dulce en la posicion dada del tablero
     * @param fila fila del dulce a establecer
     * @param columna columna del dulce a establecer
     * @param dulce dulce que establecerá en la posicion dada
     */
    public void setDulce(int fila,int columna, Dulce dulce){
        this.matriz[fila][columna] = dulce;
    }
    
    /**
     * Obtiene dulce en la posición dada
     * @param fila fila del dulce requerido
     * @param columna columna del dulce requerido
     * @return dulce requerido
     */
    public Dulce getDulce(int fila,int columna){
        return this.matriz[fila][columna];
    }

    /**
     * Define cada posicion de la matriz de dulces de manera aleatorea
     */
    public void generarTablero(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                this.setDulce(i, j, new Dulce(Dulce.formaRamdon()));          
            }
        }
        organizar();
    }

    /**
     * Modifica el tablero de tal forma que no hayan filas ni columnas formadas al iniciar
     */
    public void organizar(){
        if( this.hayLinea() ){
            tableroController.eliminarDulces();
            this.caerDulces();
            this.llenarDulces();
            this.organizar();
        }else if( !tableroController.hayPosibleMovimiento() ){
            generarTablero();
        }
    }

    /**
     * Verifica si hay linea válida en el tablero
     * @return boolean true si hay linea
     */
    private boolean hayLinea() {
        int fila = 0, columna = 0, contadorDulces = 1;
        
        while(columna < 8){
            if(this.matriz[fila][columna].getForma() == this.matriz[fila][columna+1].getForma()){
                contadorDulces ++;
            }else{
                if(contadorDulces > 2){
                    return true;
                }else{
                    contadorDulces = 1;
                }
            }
            if(columna<7){
                columna ++;
            }else if(contadorDulces > 2){
                return true;
            }else if(fila < 8){
                fila ++;
                columna = 0;
                contadorDulces = 1;
            }else{
                break;
            }
        }
        
        fila = 0; columna = 0; contadorDulces = 1;
        
        while(fila < 8){
            if(this.matriz[fila][columna].getForma() == this.matriz[fila+1][columna].getForma()){
                contadorDulces ++;
            }else{
                if(contadorDulces > 2){
                    return true;
                }else{
                    contadorDulces = 1;
                }
            }
            if(fila<7){
                fila ++;
            }else if(contadorDulces > 2){
                return true;
            }else if(columna < 8){
                columna ++;
                fila = 0;
                contadorDulces = 1;
            }else{
                break;
            }
        }
        
        return false;
    }

    /**
     * Se encarga de la gravedad característica del candy crush cuando se elimina algún dulces
     */
    private void caerDulces() {
        for(int i = 0; i < 10; i++){
            for(int fila = 0; fila < 8; fila++){
                for(int columna = 0; columna < 9; columna++){
                    if(matriz[fila][columna].getForma() != 0 && matriz[fila + 1][columna].getForma() == 0){
                        this.matriz[fila+1][columna].setForma(matriz[fila][columna].getForma());
                        this.matriz[fila][columna].setForma(0);
                    }
                }
            }
        }
    }

    /**
     * Reemplaza los espacios vacios por nuevos dulces
     */
    private void llenarDulces() {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(this.matriz[i][j].getForma() == 0){
                    this.matriz[i][j].setForma(Dulce.formaRamdon());
                } 
            }
        }
    }

    /**
     * Mueve dos dulces segun posiciones dadas por el jugador en lenguaje tablero
     * @param dato arreglo con posiciones dadas por el usuario y traducidas a lenguaje tablero
     */
    public void moverDulce( int[] dato ) {
        int formaA = this.getDulce(dato[0], dato[1]).getForma();
        int formaB = this.getDulce(dato[2], dato[3]).getForma();

        this.matriz[dato[0]][dato[1]].setForma(formaB);
        this.matriz[dato[2]][dato[3]].setForma(formaA);
    }

    /**
     * Actualiza el tablero con la variante que adiciona la puntuacion generada
     */
    public boolean actualizarTablero() {
        llamada = false;
        if( this.hayLinea() ){
            tableroController.eliminarDulces();
            tableroController.validarPuntuacion();
            this.caerDulces();
            this.llenarDulces();
            this.actualizarTablero();
            
            llamada = true;
            return true;
        }else if(!llamada){
            return false;
        }else{
            if(!tableroController.hayPosibleMovimiento()){
                generarTablero();
            }
                return true;
        }

    }

}