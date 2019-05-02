package org.academiadecodigo.bootcamp.my_paint;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import static org.academiadecodigo.bootcamp.my_paint.Grid.BOUNDARY;
import static org.academiadecodigo.bootcamp.my_paint.Grid.CELL_SIZE;

public class Player implements KeyboardHandler {

    private Rectangle movable;
    private Grid grid;

    private KeyFunctions keyFunctions;

    private Keyboard kb = new Keyboard(this);

    public int changeX() {
        return movable.getX() / CELL_SIZE;
    }

    public int changeY() {
        return movable.getY() / CELL_SIZE;
    }

    public Player(Grid grid) {
        this.grid = grid;
    }

    public void paintCell() {
        if (grid.getArrayRectangle(grid.getWidth(), grid.getHeight()).isFilled()) {
            grid.getArrayRectangle(grid.getWidth(), grid.getHeight()).draw();

        } else {
            grid.getArrayRectangle(grid.getWidth(), grid.getHeight()).fill();
        }
    }

    public void activateKeys() {
        //MOVEMENT:
        addEventToKeyboard(KeyboardEvent.KEY_UP, KeyboardEventType.KEY_PRESSED);    // Move UP
        addEventToKeyboard(KeyboardEvent.KEY_DOWN, KeyboardEventType.KEY_PRESSED);  // Move DOWN
        addEventToKeyboard(KeyboardEvent.KEY_LEFT, KeyboardEventType.KEY_PRESSED);  // Move LEFT
        addEventToKeyboard(KeyboardEvent.KEY_RIGHT, KeyboardEventType.KEY_PRESSED); // Move RIGHT
        //FUNCTIONALITY:
        addEventToKeyboard(KeyboardEvent.KEY_C, KeyboardEventType.KEY_PRESSED);     // Clear screen
        addEventToKeyboard(KeyboardEvent.KEY_Q, KeyboardEventType.KEY_PRESSED);     // Quit the program
        addEventToKeyboard(KeyboardEvent.KEY_S, KeyboardEventType.KEY_PRESSED);     // Save the draw
        addEventToKeyboard(KeyboardEvent.KEY_L, KeyboardEventType.KEY_PRESSED);     // Load the previously saved draw
        //COLORING:
        addEventToKeyboard(KeyboardEvent.KEY_1, KeyboardEventType.KEY_PRESSED);     // Black
        addEventToKeyboard(KeyboardEvent.KEY_2, KeyboardEventType.KEY_PRESSED);     // Red
        addEventToKeyboard(KeyboardEvent.KEY_3, KeyboardEventType.KEY_PRESSED);     // White
        addEventToKeyboard(KeyboardEvent.KEY_4, KeyboardEventType.KEY_PRESSED);     // Yellow
        addEventToKeyboard(KeyboardEvent.KEY_5, KeyboardEventType.KEY_PRESSED);     // Blue
        addEventToKeyboard(KeyboardEvent.KEY_6, KeyboardEventType.KEY_PRESSED);     // Magenta
        addEventToKeyboard(KeyboardEvent.KEY_7, KeyboardEventType.KEY_PRESSED);     // Orange
        addEventToKeyboard(KeyboardEvent.KEY_8, KeyboardEventType.KEY_PRESSED);     // Green
        addEventToKeyboard(KeyboardEvent.KEY_9, KeyboardEventType.KEY_PRESSED);     // Cyan

    }

    private void addEventToKeyboard(int keySpace, KeyboardEventType keyPressed) {
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(keySpace);
        event.setKeyboardEventType(keyPressed);
        kb.addEventListener(event);
    }

    public void prep() {
        movable = new Rectangle(BOUNDARY, BOUNDARY, CELL_SIZE, CELL_SIZE);

        movable.setColor(Color.DARK_GRAY);
        movable.fill();

        activateKeys();
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            // MOVE
            case KeyboardEvent.KEY_LEFT:
                if (movable.getX() > BOUNDARY) {
                    movable.translate(-CELL_SIZE, 0);
                }
                break;

            case KeyboardEvent.KEY_RIGHT:
                if (movable.getX() < grid.getWidth() - CELL_SIZE + BOUNDARY) {
                    movable.translate(CELL_SIZE, 0);
                }
                break;

            case KeyboardEvent.KEY_DOWN:
                if (movable.getY() < grid.getHeight() - CELL_SIZE + BOUNDARY) {
                    movable.translate(0, CELL_SIZE);
                }
                break;

            case KeyboardEvent.KEY_UP:
                if (movable.getY() > BOUNDARY) {
                    movable.translate(0, -CELL_SIZE);
                }
                break;

            // SAVE & LOAD
            case KeyboardEvent.KEY_S:
                //save
                DrawSave.drawSave(grid.gridToString());
                System.out.println("Saved.");
                break;

            case KeyboardEvent.KEY_L:
                //load
                // needs a clear before a load
                int cols;
                int rows;

                for (cols = 0; cols < grid.getCols(); cols++) {
                    for (rows = 0; rows < grid.getRows(); rows++) {
                        grid.getArrayRectangle(cols, rows).setColor(Color.BLACK);
                        grid.getArrayRectangle(cols, rows).draw();
                    }
                }
                grid.stringToGrid(DrawLoad.drawLoad());
                System.out.println("Loaded.");
                break;

            case KeyboardEvent.KEY_C:

                int col;
                int row;

                for (col = 0; col < grid.getCols(); col++) {
                    for (row = 0; row < grid.getRows(); row++) {
                        grid.getArrayRectangle(col, row).setColor(Color.BLACK);
                        grid.getArrayRectangle(col, row).draw();
                    }
                }
                System.out.println("Clean.");
                break;

            // QUIT
            case KeyboardEvent.KEY_Q:
                //save
                int i = 1;
                System.exit(i);
                break;

            // COLOR
            case KeyboardEvent.KEY_1:
                if (grid.getArrayRectangle(changeX(), changeY()).isFilled()) {
                    grid.getArrayRectangle(changeX(), changeY()).setColor(Color.BLACK);
                    grid.getArrayRectangle(changeX(), changeY()).draw();
                } else {
                    grid.getArrayRectangle(changeX(), changeY()).setColor(Color.BLACK);
                    grid.getArrayRectangle(changeX(), changeY()).fill();
                }
                break;

            case KeyboardEvent.KEY_2:
                if (grid.getArrayRectangle(changeX(), changeY()).isFilled()) {
                    grid.getArrayRectangle(changeX(), changeY()).setColor(Color.BLACK);
                    grid.getArrayRectangle(changeX(), changeY()).draw();
                } else {
                    grid.getArrayRectangle(changeX(), changeY()).setColor(Color.RED);
                    grid.getArrayRectangle(changeX(), changeY()).fill();
                }
                break;

            case KeyboardEvent.KEY_3:
                if (grid.getArrayRectangle(changeX(), changeY()).isFilled()) {
                    grid.getArrayRectangle(changeX(), changeY()).setColor(Color.BLACK);
                    grid.getArrayRectangle(changeX(), changeY()).draw();
                } else {
                    grid.getArrayRectangle(changeX(), changeY()).setColor(Color.WHITE);
                    grid.getArrayRectangle(changeX(), changeY()).fill();
                }
                break;

            case KeyboardEvent.KEY_4:
                if (grid.getArrayRectangle(changeX(), changeY()).isFilled()) {
                    grid.getArrayRectangle(changeX(), changeY()).setColor(Color.BLACK);
                    grid.getArrayRectangle(changeX(), changeY()).draw();
                } else {
                    grid.getArrayRectangle(changeX(), changeY()).setColor(Color.YELLOW);
                    grid.getArrayRectangle(changeX(), changeY()).fill();
                }
                break;

            case KeyboardEvent.KEY_5:
                if (grid.getArrayRectangle(changeX(), changeY()).isFilled()) {
                    grid.getArrayRectangle(changeX(), changeY()).setColor(Color.BLACK);
                    grid.getArrayRectangle(changeX(), changeY()).draw();
                } else {
                    grid.getArrayRectangle(changeX(), changeY()).setColor(Color.BLUE);
                    grid.getArrayRectangle(changeX(), changeY()).fill();
                }
                break;

            case KeyboardEvent.KEY_6:
                if (grid.getArrayRectangle(changeX(), changeY()).isFilled()) {
                    grid.getArrayRectangle(changeX(), changeY()).setColor(Color.BLACK);
                    grid.getArrayRectangle(changeX(), changeY()).draw();
                } else {
                    grid.getArrayRectangle(changeX(), changeY()).setColor(Color.MAGENTA);
                    grid.getArrayRectangle(changeX(), changeY()).fill();
                }
                break;

            case KeyboardEvent.KEY_7:
                if (grid.getArrayRectangle(changeX(), changeY()).isFilled()) {
                    grid.getArrayRectangle(changeX(), changeY()).setColor(Color.BLACK);
                    grid.getArrayRectangle(changeX(), changeY()).draw();
                } else {
                    grid.getArrayRectangle(changeX(), changeY()).setColor(Color.ORANGE);
                    grid.getArrayRectangle(changeX(), changeY()).fill();
                }
                break;

            case KeyboardEvent.KEY_8:
                if (grid.getArrayRectangle(changeX(), changeY()).isFilled()) {
                    grid.getArrayRectangle(changeX(), changeY()).setColor(Color.BLACK);
                    grid.getArrayRectangle(changeX(), changeY()).draw();
                } else {
                    grid.getArrayRectangle(changeX(), changeY()).setColor(Color.GREEN);
                    grid.getArrayRectangle(changeX(), changeY()).fill();
                }
                break;

            case KeyboardEvent.KEY_9:
                if (grid.getArrayRectangle(changeX(), changeY()).isFilled()) {
                    grid.getArrayRectangle(changeX(), changeY()).setColor(Color.BLACK);
                    grid.getArrayRectangle(changeX(), changeY()).draw();
                } else {
                    grid.getArrayRectangle(changeX(), changeY()).setColor(Color.CYAN);
                    grid.getArrayRectangle(changeX(), changeY()).fill();
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
