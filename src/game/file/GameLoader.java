package game.file;

import java.io.File;
import java.util.Scanner;

public class GameLoader {
    private static File file;
    private static Scanner reader;

    public static File getFile() {
        return file;
    }


    public static void makeFile() {
        System.out.println("this ran");
        file = new File("bin/saveData.txt");
        try {
            file.createNewFile();
        } catch (Exception IOException) {
            System.out.println("Game Loader class has broke!");
        }
    }

    public static void readFile() {
        try {
            reader = new Scanner(file);
        } catch (Exception FileNotFound) {
            System.out.println("Scanner could not find file: " + file);
            System.out.println("Setting default settings.");
        }

        //TODO: Make readFile read two Strings than the rest numbers(doubles)
        String gameState = "";
          while (reader.hasNext()) {
            gameState += reader.nextDouble();
        }

        for (String strs : gameState.split(" ")) {

        }
    }
}

