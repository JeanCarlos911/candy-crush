/*
 * Esta clase se encarga de graficar continuamente los momentos del juego
 */
package GUI;

import Game.Jugador;
import Game.Nivel;
import Game.Partida;
import Game.Tablero;

public class Estado {

    //Atributos
    private static final String linea = "★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★ ★";

    //No permite crear objetos
    private Estado() {
    }

//Methods of Estado
    /**
     * Se encarga de dibujar cada cambio en el tablero, en los turnos y en las
     * vidas durante el juego
     *
     * @param j Jugador en juego
     * @param t Tablero en el que juga el jugador
     */
    public static void actualizarDibujoJuego(Partida p, Jugador j, Tablero t, Nivel n) {
        header(j);
        tablero(t);
        footer(n, p);
    }

    private static void header(Jugador j) {
        Menu.nextPage();

        System.out.printf("%s\n   %s   %s   %s\n%s\n\n",
                linea, j.getNombre(), "♥ = " + j.getVidasRestantes(), "Movimientos restantes = " + j.getNumeroMovimientos(),
                linea);
    }

    private static void tablero(Tablero t) {
        String paddinLeft = "     ";
        System.out.println(paddinLeft + "fila/columna 1  2  3  4  5  6  7  8  9");
        System.out.println(paddinLeft + "    ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓");

        for (int fila = 0; fila < 9; fila++) {
            for (int columna = 0; columna < 9; columna++) {
                if (columna == 0) {
                    System.out.print(paddinLeft + (fila + 1) + " → ");
                }
                System.out.print(transformarForma(t.getDulce(fila, columna).getForma()) + "  ");
            }
            System.out.println("\n");
        }
    }

    private static void footer(Nivel n, Partida p) {
        System.out.printf("\n%s\n   %s   %s\n%s\n",
                linea, "puntuación objetivo = " + n.getPuntuacionObjetivo(), "puntuación acumulada = " + p.getPuntuacionAcumulada(),
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
