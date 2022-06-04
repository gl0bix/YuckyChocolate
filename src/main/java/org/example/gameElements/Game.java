package org.example.gameElements;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import org.example.chocolateBar.Bar;

import java.util.Scanner;

@Data
@Builder
@Accessors(fluent = true)
public class Game {

    private boolean gameOver;
    private boolean mode2p;
    Player player1;
    Player player2;
    private Player onTurnPlayer;
    private Bar bar;

    public static Game init() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Breite der Tafel? ");
        var wrongInput = true;
        int cols = 0;
        while (wrongInput) {
            cols = scanner.nextInt();
            if (cols <= 0) {
                System.out.println("Fehlerhafte Eingabe");
            } else {
                wrongInput = false;
            }
        }

        System.out.print("Höhe der Tafel? ");
        wrongInput = true;
        int rows = 0;
        while (wrongInput) {
            rows = scanner.nextInt();
            if (rows <= 0) {
                System.out.println("Fehlerhafte Eingabe");
            } else {
                wrongInput = false;
            }
        }

        System.out.print("Anzahl menschlicher Spieler (1-2)? ");
        wrongInput = true;
        boolean mode2p = true;
        while (wrongInput) {
            int count = scanner.nextInt();
            if (count == 2) {
                wrongInput = false;
            } else if (count == 1) {
                mode2p = false;
                wrongInput = false;
            } else {
                System.out.println("Fehlerhafte Eingabe");
            }
        }

        var bar = new Bar(cols, rows);

        System.out.print("Name für Player 1: ");
        String player1Name = scanner.next();
        Player player1 = new Player(player1Name);

        Player player2 = new Player();
        if (mode2p) {
            System.out.print("Name für Player 2: ");
            String player2Name = scanner.next();

             player2.setName(player2Name);
        } else {
            System.out.println("Brace yourself! Ambrosius is playing");
            player2 = new PlayerAmbrosius();
            player2.setName("Ambrosius");
        }

        return new GameBuilder()
                .bar(bar)
                .mode2p(mode2p)
                .player1(player1)
                .player2(player2)
                .gameOver(false)
                .build();
    }

    public void toggleOnTurnPlayer() {
        if (this.onTurnPlayer.equals(player1))
                this.onTurnPlayer = player2;
        else
            this.onTurnPlayer = player1;
    }

}
