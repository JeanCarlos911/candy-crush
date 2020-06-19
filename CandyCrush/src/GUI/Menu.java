package GUI;

import Game.Partida;
import java.util.Scanner;

public class Menu {
    //Como no es un objeto no dispone de atributos ni de constructor publico
    private Menu(){
    }
    
//Metodos del menu
    /**
     * aqui se inicia un nuevo menu
     */
    public static void iniciar(){
        //inicializar scanner para su posterior uso
        Scanner in = new Scanner(System.in);
        
        //Menu principal--------------------------------------------------------------
        nextPage();
        String nombre, linea="★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★",
                  lineaVacia="★                                         ★";
        int opcion;
        
        System.out.printf("\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s", linea, lineaVacia,
                "★        ❄ ❄ ❄ CANDY CRUSH ❄ ❄ ❄          ★", lineaVacia,
                "★       [1] Empezar nueva partida         ★",
                "★       [2] Salir                         ★", lineaVacia, linea, "$ ");
        opcion = in.nextInt();
        
        switch (opcion) {
            case 1:
                nextPage();
                System.out.printf("%s\n★       ingrese nombre del jugador        ★\n%s\n$ ", linea, linea);
                nombre = in.next();
                Partida nuevaPartida = new Partida(nombre);
                nuevaPartida.iniciarPartida();
                break;
            case 2:
                nextPage();
                System.out.printf("%s\n%s\n%s\n\n\n", linea, "★    ejecucion finalizada exitosamente    ★", linea);
                System.exit(0);
                break;
            default:
                System.out.println(linea + "\nopcion no válida");
                Menu.iniciar();
                break;
        }

        in.close();
    }

    public static void nextPage(){
      System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}