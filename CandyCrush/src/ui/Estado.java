/*
 * Esta clase se encarga de graficar continuamente los momentos del juego
 * Está diseñado principalmente para ejecutar en repl
 */
package ui;

import models.Jugador;
import models.Nivel;
import models.Partida;
import models.Tablero;

public class Estado {
    //referencias
    private static Jugador jugador;
    
    //Atributos
    private static final String linea = Menu.getMarginLeft() + "★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★",
        paddinLeft  = Menu.getMarginLeft() + "★                ", paddinRight = "                ★", lineaVacia = paddinLeft + "                               " + paddinRight;

    //No permite crear objetos
    private Estado() {
    }

    /**
     * Se encarga de dibujar cada cambio en el tablero, en los turnos y en las
     * vidas durante el juego
     *
     * @param j Jugador en juego
     * @param t Tablero en el que juga el jugador
     */
    public static void actualizarDibujoJuego(Partida p, Jugador j, Tablero t, Nivel n) {
        if(jugador == null)
            jugador = j;
        
        Menu.nextPage();
        //Estructura similar al html para estar familiarizados
        header();
        section(j);
        tablero(t);
        footer(n, p);
    }

    /**
     * Ventana perder (consola)
     */
    public static void perder(){
        System.out.println(linea);
        System.out.println("                    No hay vidas suficientes ni turnos para continuar jugando y no alcanzó la meta establecida\n"
                    + "                         ¡ HAS PERDIDO !");
        System.out.println(linea);
    }
    
    private static void header(){
      System.out.printf("%s\n%s\n%s    %s    %s\n%s\n%s\n", linea, lineaVacia, paddinLeft,"❄ ❄ ❄ CANDY CRUSH ❄ ❄ ❄", paddinRight,
       lineaVacia, linea);
    }

    private static void section(Jugador j) {
        System.out.printf("   %s   %s   %s\n%s\n", Menu.getMarginLeft() + j.getNombre(), "♥ = " + j.getVidasRestantes(), "Movimientos restantes = " + j.getTurnosRestantes(),
          linea);
    }

    private static void tablero(Tablero t) {
        System.out.println(lineaVacia);
        System.out.println(paddinLeft + "x/y 1  2  3  4  5  6  7  8  9  " + paddinRight);
        System.out.println(paddinLeft + "    ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  " + paddinRight);

        for (int fila = 0; fila < 9; fila++) {
            for (int columna = 0; columna < 9; columna++) {
                if (columna == 0) {
                    System.out.print(paddinLeft + (fila + 1) + " → ");
                }
                System.out.print(transformarForma(t.getDulce(fila, columna).getForma()) + "  ");
                if(columna==8){
                  System.out.print(paddinRight);
                }
            }
            System.out.println("\n" + lineaVacia);
        }
    }

    private static void footer(Nivel n, Partida p) {
        System.out.printf("%s\n   %s   %s\n%s\n\n",
                linea, Menu.getMarginLeft() + "puntuación objetivo = " + n.getPuntuacionObjetivo(), "puntuación acumulada = " + jugador.getPuntaje(),
                linea);
    }

    private static String transformarForma(int forma) {
        switch (forma) {
            case 1:
                return "★";
            case 2:
                return "✦";
            case 3:
                return "◈";
            case 4:
                return "✴";
            case 5:
                return "❄";
            default:
                return " ";
        }
    }
}
