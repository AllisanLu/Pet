package game.file;

import game.Driver;

import java.io.File;
import java.util.Scanner;
import java.util.regex.*;

public class GameLoader {
    private static File file;
    private static Scanner reader;

    public static File getFile() {
        return file;
    }

    /**
     * If the method cannot find a txt File in the correct spot and name, it creates one to save
     * future data on the Tamas into.
     */
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
        //TODO: SERIOUSLY CONSIDER SWITCHING TO LOOPS I THINK IT WILL BE MUCH EASIER
        String gameState = "";
          while (reader.hasNext()) {
            gameState += reader.nextLine();
        }

        int currentCount = 0;
        for (String strs : gameState.split(" ")) {
            if(strs.matches("\\d")){
               // System.out.println("Here's a number");
                int number = Integer.parseInt(strs);
                switch(currentCount) {
                    default:
                        System.out.println("That didn't work:" + number + "counter at " + currentCount);
                        break;
                    case 0:
                        Driver.getTama().setFood(number);
                        break;
                    case 1:
                        Driver.getTama().setHealth(number);
                        break;
                    case 2:
                        Driver.getTama().setPetState(number);
                        break;
                    case 3:
                        Driver.getTama().setPoop(number);
                        break;
                        //System.out.println("Poop at loaer is " + Driver.getTama().getPoop());
                }
                currentCount++;
            }
        }
    }
}

