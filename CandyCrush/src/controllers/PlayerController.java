package controllers;

import java.util.Scanner;

public class PlayerController {
    //Atributos
    private Scanner in;
    private int xf,xi,yf,yi;
    private int[] posiciones;

    /**
     * inicializar scanner
     */
    public PlayerController(){
        in = new Scanner(System.in);
    }
    
    /**
     * Retorna posiciones insertadas por el jugador traducidas a lenguaje tablero
     * @return int[] con posiciones traducidas
     */
    public int[] getPosiciones(){
        this.posiciones = new int[]{(xi-1),(yi-1),(xf-1),(yf-1)};
        return this.posiciones;
    }
    
    public int[] getPosiciones(int i){
        int[] inversa = new int[]{(xf-1),(yf-1),(xi-1),(yi-1)};
        return inversa;
    }
    
    /**
     * Este metodo verifica el movimiento insertado por el jugador
     * @param xi x inicial
     * @param yi y inicial
     * @param xf x final
     * @param yf y final
     * @return boolean true si es valido
     */
    public boolean verificarMovimiento(int xi, int yi,int xf,int yf){
        int sumatoria = Math.abs(xf - xi) + Math.abs(yf-yi);
        
        if((xi<1 || xi>9) || (yi<1 || yi>9) || (xf<1 || xf>9) || (yf<1 || yf>9)){
            return false;
        }else if(sumatoria != 1){
            return false;
        }else{
            return true;
        }
    }

    /**
     * Recibe posiciones de movimiento del jugador
     */
    public void setPosicion(){

        System.out.print("Ingrese el valor de x1: ");
        this.xi = this.in.nextInt();
            
        System.out.print("Ingrese el valor de y1: ");
        this.yi = this.in.nextInt();
        
        System.out.print("Ingrese el valor de x2: ");
        this.xf = this.in.nextInt();
            
        System.out.print("Ingrese el valor de y2: ");
        this.yf = this.in.nextInt();


        if(this.verificarMovimiento(xi, yi, xf, yf) == false){
            System.out.println("Ingrese posiciones validas :v");
            this.setPosicion();
        }

        
    }

}