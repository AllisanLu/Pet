package game;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class GameLoader {
    private static File file;
    private static Scanner reader;

    public static File getFile() {
        return file;
    }

<<<<<<< HEAD
    public static void makeFile() {
        file = new File("bin/saveData.txt");
        System.out.println(file.getAbsoluteFile());
        try {
            file.createNewFile();
        } catch (Exception IOException) {
            System.out.println("Game Loader class has broke!");
        }
    }

    public static void readFile() {
        try {
            reader = new Scanner(file);
        } catch(Exception FileNotFound) {
            System.out.println("Scanner could not find file: " + file);
            System.out.println("Setting default settings.");
        }
        String gameState = "";
        while(reader.hasNext()) {
            gameState += reader.nextLine();
            System.out.println(gameState);
        }
        for(String strs : gameState.split(" ")) {
            System.out.println(strs);
        }
=======
    public static void makeFile() throws IOException{
        //System.out.println(GameSaver.class.getResource("bin/gameSaved.txt").toString());
        file = new File(GameSaver.class.getResource("bin/gameSaved.txt"));
        file.createNewFile();
        System.out.println("FIle ahs been created");
>>>>>>> f7434db5611964fa1e093242947f2f831886ad98
    }
}

