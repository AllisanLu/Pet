package game.file;

import game.Driver;
import game.Tama;

import java.io.File;
import java.util.Scanner;
import java.util.regex.*;

public class GameLoader {
    private static File file;
    private static Scanner reader;
    private static int foodFromFile;
    private static int petStateFromFile;
    private static int healthFromFile;
    private static int poopFromFile;


    public static File getFile() {
        return file;
    }

    /**
     * If the method cannot find a txt File in the correct spot and name, it creates one to save
     * future data on the Tamas into.
     */
    public static void makeFile() {
        //System.out.println("this ran");
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

        //TODO: Make readFile read two Strings than the rest numbers(doubles) wuuut

        String gameState = "";
          while (reader.hasNext()) {
            gameState += reader.nextLine();
        }

        int currentCount = 0;
        for (String strs : gameState.split(" ")) {
            if(strs.matches("\\d+")){
                int number = Integer.parseInt(strs);
                switch(currentCount) {
                    default:
                        System.out.println("That didn't work:" + number + "counter at " + currentCount);
                        break;
                    case 0:
                        Driver.getTama().setFood(number);
                        //System.out.println("GAME LOADER: " + "food" + Driver.getTama().getFood());
                        break;
                    case 1:
                        Driver.getTama().setHealth(number);
                       // System.out.println("GAME LOADER: " + Driver.getTama().getHealth());
                        break;
                    case 2:
                        Driver.getTama().setPetState(number);
                      //  System.out.println("GAME LOADER: " + Driver.getTama().getPetState());
                        break;
                    case 3:
                        Driver.getTama().setPoop(number);
                      //  System.out.println("GAME LOADER: " + Driver.getTama().getPoop());
                        break;
                }
                currentCount++;
            }
        }
    }
}

