package org.academiadecodigo.bootcamp.my_paint;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import static org.academiadecodigo.bootcamp.my_paint.Grid.BOUNDARY;
import static org.academiadecodigo.bootcamp.my_paint.Grid.CELL_SIZE;

public enum KeyFunctions {
    UP,
    DOWN,
    LEFT,
    RIGHT,
    CLEAR,
    SAVE,
    LOAD,
    QUIT,
    COLOR_BLACK,
    COLOR_RED,
    COLOR_WHITE,
    COLOR_YELLOW,
    COLOR_MAGENTA,
    COLOR_ORANGE,
    COLOR_GREEN,
    COLOR_CYAN;

    private Rectangle movable;

    public void moveUp() {
        if (movable.getY() > BOUNDARY) {
            movable.translate(0, -CELL_SIZE);
        }
    }
}
