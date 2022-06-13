package org.example.gameElements;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.chocolateBar.Bar;

@Data
@EqualsAndHashCode(callSuper = true)
public class PlayerAmbrosius extends Player {

    //TODO: optimize to return both direction and count in one method

    public String getBreakDirection(Bar bar) {
        final var width = bar.getWidth();
        final var height = bar.getHeight();

        if (width < height) {
            System.out.println("Ambrosius wird horizontal..");
            return "H";
        } else if (width > height) {
            System.out.println("Ambrosius wird vertikal..");
            return "V";
        } else {
            System.out.println("Welch Teufelei! Ambrosius wird wahrscheinlich verlieren.");
        }
        System.out.println("Ambrosius wird horizontal..");
        return "H";
    }

    public int getBreakCount(Bar bar) {
        final var width = bar.getWidth();
        final var height = bar.getHeight();

        if (width < height) {
            System.out.println((height - width) + " Reihen abbrechen.");
            return height - width;
        } else if (width > height) {
            System.out.println((width - height) + " Spalten abbrechen.");
            return width - height;
        } else {
            System.out.println(1 + " Reihen abbrechen.");
        }
        return 1;
    }
}
