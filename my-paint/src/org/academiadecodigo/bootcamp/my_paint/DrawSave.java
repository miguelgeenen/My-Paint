package org.academiadecodigo.bootcamp.my_paint;

import java.io.*;

public class DrawSave {

    public static void drawSave(String gridToSave) {

        FileWriter fileWriter;
        BufferedWriter bWriter = null;

        try {
            fileWriter = new FileWriter("resources/new-draw30x30");
            bWriter = new BufferedWriter(fileWriter);

            bWriter.write(gridToSave);

        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            try {
                bWriter.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}