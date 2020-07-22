package game;

public class Tablero {
    //Atributos
    private Dulce matriz[][];
    private long puntuacion;
    
    /**
     * Al crear un tablero, se establece el tamaño de la matriz de dulces
     */
    public Tablero(){
        this.matriz = new Dulce[9][9];
        generarTablero();
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
     * Establece puntuacion segun parametro de entrada
     * @param puntuacion long puntuacion a establecer
     */
    public void setPuntuacion(long puntuacion){
        this.puntuacion = puntuacion;
    }

    /**
     * retorna puntuacion generada
     * @return long puntuacion generada
     */
    public long getPuntuacion(){
        return this.puntuacion;
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
        boolean existe = this.hayLinea();
        if(existe){
            this.eliminarDulces();
            this.caerDulces();
            this.llenarDulces();
            organizar();
        }else if(hayPosibleMovimiento() == false){
            generarTablero();
            organizar();
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
     * Encuentra linea válida en el tablero
     * @return int[] con descripciones de la linea encontrada
     */
    private int[] encontrarLinea() {
        int fila = 0, columna = 0, contadorDulces = 1;
        while(columna < 8){
            if(this.matriz[fila][columna].getForma() == this.matriz[fila][columna+1].getForma()){
                contadorDulces ++;
            }else{
                if(contadorDulces > 2){
                    return new int[]{contadorDulces, fila, columna, 0};
                }else{
                    contadorDulces = 1;
                }
            }
            if(columna<7){
                columna ++;
            }else if(contadorDulces > 2){
                return new int[]{contadorDulces, fila, columna + 1, 0};
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
                    return new int[]{contadorDulces, fila, columna, 1};
                }else{
                    contadorDulces = 1;
                }
            }
            if(fila<7){
                fila ++;
            }else if(contadorDulces > 2){
                return new int[]{contadorDulces, fila + 1, columna, 1};
            }else if(columna < 8){
                columna ++;
                fila = 0;
                contadorDulces = 1;
            }else{
                break;
            }
        }
        return new int[]{-1};
    }

    /**
     * Este metodo elimina una fila de dulces encontrados (transforma su forma a vacio es decir a int 0)
     */
    private void eliminarDulces() {
        int[] dato = encontrarLinea();
        int fila = dato[1];
        int columna = dato[2];
        
        for (int dulces = dato[0]; dulces > 0; dulces--){
            this.matriz[fila][columna].setForma(0);
            if(dato[3] == 0){
                columna--;
            }else {
                fila--;
            }
        }
    }

    /**
     * Se encarga de la gravedad característica del candy crush cuando se elimina algún dulces
     */
    private void caerDulces(){
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
    private void llenarDulces(){
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
    public void moverDulce(int[] dato){
        int formaA = this.getDulce(dato[0], dato[1]).getForma();
        int formaB = this.getDulce(dato[2], dato[3]).getForma();

        this.matriz[dato[0]][dato[1]].setForma(formaB);
        this.matriz[dato[2]][dato[3]].setForma(formaA);
    }

    /**
     * Actualiza el tablero con la variante que adiciona la puntuacion generada
     */
    public boolean actualizarTablero(){
        boolean existe = this.hayLinea();
        if(existe){
            this.eliminarDulces();
            this.validarPuntuacion();
            this.caerDulces();
            this.llenarDulces();
            this.actualizarTablero();
            
            return true;
        }else if(this.puntuacion == 0){
            return false;
        }else{
            if(this.hayPosibleMovimiento()){
                return true;
            }else{
                generarTablero();
                organizar();
                return true;
            }
        }

    }

    /**
     * Adiciona la puntuacion generada por el movimiento del usuario
     */
    private void validarPuntuacion() {
        int cantidadDulces = 0;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j<9; j++){
                if(this.matriz[i][j].getForma() == 0){
                    cantidadDulces++;
                }
            }
        }
        sumarPuntuacion(cantidadDulces);
    }
    
    /**
     * Suma puntuacion dependiendo del numero de dulces en serie dados
     * @param cantidadDulces numero de dulces en serie
     */
    private void sumarPuntuacion(int cantidadDulces){
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

    private boolean hayPosibleMovimiento(){
        int contador = 0;
        String direccion = "";
        for(int i = 0; i <= 8; i++){
            for(int j = 0; j <= 8; j++){
                contador = 0;
                direccion = "";
                try{
                    if(this.matriz[i][j-1].getForma() == this.matriz[i-1][j].getForma()){
                        contador++;
                        direccion = "leftup";
                    }

                    if(this.matriz[i-1][j].getForma() == this.matriz[i][j+1].getForma()){
                        contador++;
                        direccion = "uprigth";
                    }

                    if(this.matriz[i][j+1].getForma() == this.matriz[i+1][j].getForma()){
                        contador++;
                        direccion = "rigthdown";
                    }

                    if(this.matriz[i+1][j].getForma() == this.matriz[i][j-1].getForma()){
                        contador++;
                        direccion = "downleft";
                    }

                    if(this.matriz[i][j-1].getForma() == this.matriz[i][j+1].getForma()){
                        contador++;
                        direccion = "fila";
                    }

                    if(this.matriz[i-1][j].getForma() == this.matriz[i+1][j].getForma()){
                        contador++;
                        direccion = "columna";
                    }

                    if(contador >= 3){
                        return true;
                    }else if(contador == 1){
                        contador = 0;
                        if(direccion.equals("leftup")){
                            if(this.matriz[i][j-2].getForma() == this.matriz[i][j-1].getForma()){
                                contador++;
                            }

                            if(this.matriz[i-2][j].getForma() == this.matriz[i-1][j].getForma()){
                                contador++;
                            }

                            if(contador >= 2){
                                return true;
                            }
                        }

                        if(direccion.equals("uprigth")){
                            if(this.matriz[i-2][j].getForma() == this.matriz[i-1][j].getForma()){
                                contador++;
                            }

                            if(this.matriz[i][j+2].getForma() == this.matriz[i][j+1].getForma()){
                                contador++;
                            }

                            if(contador >= 2){
                                return true;
                            }
                        }

                        if(direccion.equals("rigthdown")){
                            if(this.matriz[i][j+2].getForma() == this.matriz[i][j+1].getForma()){
                                contador++;
                            }

                            if(this.matriz[i+2][j].getForma() == this.matriz[i+1][j].getForma()){
                                contador++;
                            }

                            if(contador >= 2){
                                return true;
                            }
                        }

                        if(direccion.equals("downleft")){
                            if(this.matriz[i+2][j].getForma() == this.matriz[i+1][j].getForma()){
                                contador++;
                            }

                            if(this.matriz[i][j-2].getForma() == this.matriz[i][j-1].getForma()){
                                contador++;
                            }

                            if(contador >= 2){
                                return true;
                            }
                        }

                        if(direccion.equals("columna")){
                            if(this.matriz[i+2][j].getForma() == this.matriz[i+1][j].getForma()){
                                contador++;
                            }

                            if(this.matriz[i-2][j].getForma() == this.matriz[i-1][j].getForma()){
                                contador++;
                            }

                            if(contador >= 2){
                                return true;
                            }
                        }


                        if(direccion.equals("fila")){
                            if(this.matriz[i][j+2].getForma() == this.matriz[i][j+1].getForma()){
                                contador++;
                            }

                            if(this.matriz[i][j-2].getForma() == this.matriz[i][j-1].getForma()){
                                contador++;
                            }

                            if(contador >= 2){
                                return true;
                            }
                        }

                    }

                }catch(ArrayIndexOutOfBoundsException e){}

            }
        }
        return false;
    }
    
}