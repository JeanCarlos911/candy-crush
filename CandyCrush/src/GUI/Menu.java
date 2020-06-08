package GUI;

import Game.Partida;
import java.util.Scanner;

public class Menu {
    
//Metodos publicos del menu
    /**
     * aqui se genera el menu cuando se crea
     */
    public Menu(){
        //inicializar scanner para su posterior uso
        Scanner in = new Scanner(System.in);
        
        //Menu principal--------------------------------------------------------------
        String nombre, linea="--------------------------------------";
        int opcion;
        
        System.out.printf("%s\n%s\n%s\n%s\n%s\n%s",linea,"|             Candy Crush            |",linea,"[1] Empezar nueva partida",
                "[2] Salir", "$ ");
        opcion = in.nextInt();
        
        if(opcion==1){
            System.out.print(linea + "\ningrese nombre del jugador\n$ ");
            nombre = in.nextLine();
            nombre = in.nextLine();//lo coloque dos veces porq siempre se saltaba el primero
            System.out.println(linea);
            Partida nueva = new Partida(nombre);
            
        }else if(opcion==2){
            System.out.printf("%s\n%s\n%s\n", linea, ">>ejecucion finalizada exitosamente<<", linea);
            System.exit(0);
            
        }else{
            System.out.println(linea + "\nopcion no vàlida");
            this.iniciar();
        }

        in.close();
    }
    
    /**
     * aqui se inicia un nuevo menu
     */
    public static void iniciar(){
        Menu main = new Menu();
    }
    
//Metodos propios del menu
    
}