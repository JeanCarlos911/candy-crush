package GUI;

import Game.Partida;
import java.util.Scanner;

public class Menu {
    //Como no es un objeto no dispone de atributos y su constructor no es publico
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
                System.out.printf("%s\n★       Ingrese nombre del jugador        ★\n%s\n$ ", linea, linea);
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
                System.out.println(linea + "\nopción no válida");
                Menu.iniciar();
                break;
        }
        in.close();
    }
    
    /**
     * Se ejecuta una vez finalizado el juego
     */
    public static void finalizar(){
        Scanner in = new Scanner(System.in);
        System.out.println("¿Desea ir al menú principal? (1)Si/(0)No");
        int answer = in.nextInt();
        switch(answer){
            case 1:
                Menu.iniciar();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Opción no válida, digite nuevamente");
                Menu.finalizar();
        }
        in.close();
    }

    /**
     * Este método realiza varios saltos de linea para iniciar un nuevo frame limpio en consola
     */
    public static void nextPage(){
      System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    
}