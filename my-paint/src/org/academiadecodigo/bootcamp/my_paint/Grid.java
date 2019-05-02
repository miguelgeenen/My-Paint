package org.academiadecodigo.bootcamp.my_paint;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    public static final int BOUNDARY = 10;
    public static final int CELL_SIZE = 25;

    private int cols;
    private int rows;

    private Rectangle[][] rectangleArray;

    public Grid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
    }

    public void start() {
        Rectangle gridBackground = new Rectangle(BOUNDARY, BOUNDARY, getWidth(), getHeight());
        gridBackground.setColor(Color.LIGHT_GRAY);
        gridBackground.fill();

        rectangleArray = new Rectangle[cols][rows];

        int col;
        int row;

        System.out.println("Grid initialized with: " + cols + " cols and " + rows + " rows.");
        
        for (col = 0; col < cols; col++) {
            for (row = 0; row < rows; row++) {
                rectangleArray[col][row] = new Rectangle(BOUNDARY + col * CELL_SIZE, BOUNDARY + row * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                rectangleArray[col][row].draw();
            }
        }
    }

    public String gridToString() {

        String character = "";

        for (int row = 0; row < rectangleArray.length; row++) { //array todos
            for (int col = 0; col < rectangleArray[row].length; col++) { //array de rect

                if (rectangleArray[col][row].isFilled() && rectangleArray[col][row].getColor() == Color.BLACK) {
                    character += "1";

                } else if (rectangleArray[col][row].isFilled() && rectangleArray[col][row].getColor() == Color.RED) {
                    character += "2";

                } else if (rectangleArray[col][row].isFilled() && rectangleArray[col][row].getColor() == Color.WHITE) {
                    character += "3";

                } else if (rectangleArray[col][row].isFilled() && rectangleArray[col][row].getColor() == Color.YELLOW) {
                    character += "4";

                } else if (rectangleArray[col][row].isFilled() && rectangleArray[col][row].getColor() == Color.BLUE) {
                    character += "5";

                } else if (rectangleArray[col][row].isFilled() && rectangleArray[col][row].getColor() == Color.MAGENTA) {
                    character += "6";

                } else if (rectangleArray[col][row].isFilled() && rectangleArray[col][row].getColor() == Color.ORANGE) {
                    character += "7";

                } else if (rectangleArray[col][row].isFilled() && rectangleArray[col][row].getColor() == Color.GREEN) {
                    character += "8";

                } else if (rectangleArray[col][row].isFilled() && rectangleArray[col][row].getColor() == Color.CYAN) {
                    character += "9";

                } else {
                    character += "0";
                }
            }
            character += "\n";
        }
        return character;
    }

    public void stringToGrid(String file) {

        String[] lines = file.split("\n");

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                rectangleArray[col][row].draw();
                if (lines[row].charAt(col) == '1') {
                    rectangleArray[col][row].fill();

                } else if (lines[row].charAt(col) == '2') {
                    rectangleArray[col][row].setColor(Color.RED);
                    rectangleArray[col][row].fill();

                } else if (lines[row].charAt(col) == '3') {
                    rectangleArray[col][row].setColor(Color.WHITE);
                    rectangleArray[col][row].fill();

                } else if (lines[row].charAt(col) == '4') {
                    rectangleArray[col][row].setColor(Color.YELLOW);
                    rectangleArray[col][row].fill();

                } else if (lines[row].charAt(col) == '5') {
                    rectangleArray[col][row].setColor(Color.BLUE);
                    rectangleArray[col][row].fill();

                } else if (lines[row].charAt(col) == '6') {
                    rectangleArray[col][row].setColor(Color.MAGENTA);
                    rectangleArray[col][row].fill();

                } else if (lines[row].charAt(col) == '7') {
                    rectangleArray[col][row].setColor(Color.ORANGE);
                    rectangleArray[col][row].fill();

                } else if (lines[row].charAt(col) == '8') {
                    rectangleArray[col][row].setColor(Color.GREEN);
                    rectangleArray[col][row].fill();

                } else if (lines[row].charAt(col) == '9') {
                    rectangleArray[col][row].setColor(Color.CYAN);
                    rectangleArray[col][row].fill();
                }
            }
        }
    }

    public Rectangle getArrayRectangle(int x, int y) {
        return rectangleArray[x][y];
    }

    public int getWidth() {
        return CELL_SIZE * cols;
    }

    public int getHeight() {
        return CELL_SIZE * rows;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }
}