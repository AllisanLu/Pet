package game.file;

import game.Driver;

import java.io.File;
import java.util.Scanner;

public class GameLoader {
    private static File file;
    private static Scanner reader;
    private static int foodFromFile;
    private static int petStateFromFile;
    private static int healthFromFile;
    private static int poopFromFile;
    private static int tamaOn = 0;


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
            reader.useDelimiter(System.getProperty("line.separator"));
        } catch (Exception FileNotFound) {
            System.out.println("Scanner could not find file: " + file);
            System.out.println("Setting default settings.");
        }

        //TODO: Make readFile read two Strings than the rest numbers(doubles) wuuut

        while(reader.hasNext()) {
            String gameState = "";
            gameState += reader.next();

            int currentCount = 0;
            //System.out.println("game state: " + gameState);
            String strs = "";
            for (int x = 0; x < gameState.length(); x++) {
                strs += gameState.substring(x, x+1);

                if(gameState.substring(x, x+1).equals(" ")) {
                   //System.out.println(strs + " : " + strs.matches("\\d+ "));
                    if (strs.matches("\\d+ ")) {
                        strs = strs.replaceAll("\\s", "");
                        int number = Integer.parseInt(strs);
                        //System.out.println("number: " + number);
                        switch (currentCount) {
                            default:
                                System.out.println("That didn't work:" + number + ", counter at " + currentCount);
                                break;
                            case 0:
                                Driver.getTamas()[tamaOn].setFood(number);
                                //System.out.println("GAME LOADER: " + "food" + Driver.getTama().getFood());
                                break;
                            case 1:
                                Driver.getTamas()[tamaOn].setHealth(number);
                                //System.out.println("GAME LOADER: " + Driver.getTama().getHealth());
                                break;
                            case 2:
                                Driver.getTamas()[tamaOn].setPetState(number);
                                //System.out.println("GAME LOADER: " + Driver.getTama().getPetState());
                                break;
                            case 3:
                                Driver.getTamas()[tamaOn].setPoop(number);
                                //System.out.println("GAME LOADER: " + Driver.getTama().getPoop());
                                break;
                            case 4:
                                Driver.getTamas()[tamaOn].setExp(number);
                                //System.out.println("GAME LOADER: " + Driver.getTama().getExp());
                        }
                        currentCount++;
                    }
                    strs = "";
                }
            }
            tamaOn++;
        }
        //System.out.println(Driver.getTamas()[0]);
        //System.out.println(Driver.getTamas()[1]);
    }
}

