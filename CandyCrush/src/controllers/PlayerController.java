package controllers;

import java.util.Scanner;

public class PlayerController {

    private int xf,xi,yf,yi;
    private Scanner entrada = new Scanner(System.in);
    
    public boolean verificarMovimiento(int xi, int yi,int xf,int yf){
        
        int sumatoria = Math.abs(xf - xi) + Math.abs(yf-yi);
        if(sumatoria != 1){
            return false;
        }else{
            return true;
        }
        
    }

    public void setPosicion(){

        System.out.println("Ingrese el valor de x1: ");
        this.xi = this.entrada.nextInt();
            
        System.out.println("Ingrese el valor de y1: ");
        this.yi = this.entrada.nextInt();
        
        System.out.println("Ingrese el valor de x2: ");
        this.xf = this.entrada.nextInt();
            
        System.out.println("Ingrese el valor de y2: ");
        this.yi = this.entrada.nextInt();


        if(this.verificarMovimiento((xi-1),(yi-1),(xf-1),(yf-1)) == false){
            System.out.println("Ingrese posiciones validas tarado :v");
            this.setPosicion();
        }

        
    }


    

}