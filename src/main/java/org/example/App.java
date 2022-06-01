package org.example;

import org.example.chocolateBar.Bar;
import org.example.chocolateBar.ChocolateElements;
import org.example.gameElements.Game;

import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        System.out.println("*******************************************");
        System.out.println("*** Welcome to the Yucky Chocolate Game ***");
        System.out.println("*******************************************");

        Scanner scanner = new Scanner(System.in);
        Game game = Game.init();
        System.out.println("Initialized new Game");
        game.bar().printGrid();
        game.onTurnPlayer(game.player1());

        while (!game.gameOver()) {
            boolean wrongInput = true;

            // choose to break of either horizontally or vertically while checking for remaining width/height
            System.out.print(game.onTurnPlayer().getName() + ", wollen sie horizontal oder vertikal abbrechen (Eingabe H oder V)? ");
            String breakChoice = "";
            if (game.bar().getHeight() == 1) {
                System.out.println("Nur noch vertikales Abbrechen möglich.");
                breakChoice = "V";
            } else if (game.bar().getWidth() == 1) {
                System.out.println("Nur noch horizontales Abbrechen möglich.");
                breakChoice = "H";
            } else {
                while (wrongInput) {
                    breakChoice = scanner.next().toUpperCase();
                    if (breakChoice.equals("H") || breakChoice.equals("V")) wrongInput = false;
                    else System.out.println("Fehlerhafte Eingabe. Bitte wiederholen: ");
                }
            }

            //choose how many rows or cols to break of
            System.out.print("Wie " + (breakChoice.equals("H")? "hoch": "breit") + " ist das abgebrochene Stück? ");
            int count = 0;
            wrongInput = true;
            while (wrongInput) {
                count = scanner.nextInt();
                if (count < 1 || count > (breakChoice.equals("H")? game.bar().getHeight() - 1: game.bar().getWidth() - 1))
                    System.out.println("Fehlerhafte Eingabe. Bitte wiederholen: ");
                else wrongInput = false;
            }

            // break from bar according to players choice
            if (breakChoice.equals("H")) {
                game.bar().breakHor(count);
            } else {
                game.bar().breakVer(count);
            }

            game.bar().printGrid();
            game.gameOver(game.bar().isOnlySoap());
            game.toggleOnTurnPlayer();
        }

        System.out.println("Game over!");
        game.toggleOnTurnPlayer(); //toggle again, to get player who broke the last possible piece
        System.out.println(game.onTurnPlayer().getName() + " gewinnt");


    }
}
