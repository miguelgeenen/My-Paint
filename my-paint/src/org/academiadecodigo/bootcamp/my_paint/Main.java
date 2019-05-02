package org.academiadecodigo.bootcamp.my_paint;

public class Main {
    public static void main(String[] args) {

        Grid grid = new Grid(30,30);
        Player player = new Player(grid);

        grid.start();
        player.prep();
    }
}