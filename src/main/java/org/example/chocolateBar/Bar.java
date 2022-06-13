package org.example.chocolateBar;

import lombok.Data;
import lombok.Getter;

import java.util.Objects;

@Data
public class Bar {

    private int width;
    private int height;

    @Getter
    private char[][] barGrid;

    public Bar(int _width, int height) {
        this.width = _width;
        this.height = height;
        generateBarGrid();
    }

    public boolean isOnlySoap() {
        return this.width == 1 && this.height == 1;
    }

    public void breakBar(String dir, int count) {
        if (Objects.equals(dir, "H")) this.height -= count;
        else this.width -= count;
    }


    private void generateBarGrid() {
        this.barGrid = new char[this.height][this.width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.barGrid[i][j] = '#';
            }
        }
        this.barGrid[0][0] = 'O';
    }

    public void printGrid() {
        for (int i = 0; i < height; i++) {
            System.out.print("\n");
            for (int j = 0; j < width; j++) {
                System.out.print(this.barGrid[i][j]);
            }
        }
        System.out.println("\n");
        System.out.println("Höhe: " + height);
        System.out.println("Breite: " + width);
        System.out.println("\n");
    }
}
