package org.academiadecodigo.bootcamp.my_paint;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DrawLoad {

    public static String drawLoad() {

        FileReader fileReader;
        BufferedReader bReader = null;

        String result = "";

        try {

            fileReader = new FileReader("resources/new-draw30x30");
            bReader = new BufferedReader(fileReader);

            String line;

            while ((line = bReader.readLine()) != null) {
                result += line + "\n";
            }


        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                bReader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
