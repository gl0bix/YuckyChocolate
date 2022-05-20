package org.example.chocolateBar;

import lombok.*;

@Data
public class Bar {

    private final int width;
    private final int height;

    @Getter
    private char[][] barGrid;

    public Bar(int _width, int height){
        this.width = _width;
        this.height = height;
        generateBarGrid();
    }

    public boolean isOnlySoap(){
        var result = false;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(this.barGrid[i][j] == '#') {
                    result = false;
                    break;
                } else {
                    result = true;
                }
            }
        }
        return result;
    }

    public void breakHor(int rows){
        for (int i = height-1; i > height - 1 - rows; i--){
            for (int j = 0; j < width; j++) {
                this.barGrid[i][j] = '~';
            }
        }
    }

    public void breakVer(int cols){
        for (int i = width-1; i > width - 1 - cols; i--){
            for (int j = 0; j < height; j++) {
                this.barGrid[j][i] = '~';
            }
        }
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

    public void print() {
        for (int i = 0; i < height; i++) {
            System.out.print("\n");
            for (int j = 0; j < width; j++) {
                System.out.print(this.barGrid[i][j]);
            }
        }
        System.out.print("\n");
    }

}
