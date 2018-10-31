package game.file;

import game.Driver;
import game.Tama;
import game.Tamas;

import java.io.File;
import java.util.Scanner;

public class GameLoader {
    private static File file;
    private static Scanner reader;
    private static int tamaOn = 0;


    public static File getFile() {
        return file;
    }

    /**
     * If the method cannot find a txt File in the correct spot and name, it creates one to save
     * future data on the game.Tamas into.
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

//    public static void readFile() {
//        try {
//            reader = new Scanner(file);
//            reader.useDelimiter(System.getProperty("line.separator"));
//        } catch (Exception FileNotFound) {
//            System.out.println("Scanner could not find file: " + file);
//            System.out.println("Setting default settings.");
//        }
//
//        //TODO: Make readFile read two Strings than the rest numbers(doubles) wuuut
//
//        while(reader.hasNext()) {
//            String gameState = "";
//            gameState += reader.next();
//
//            int currentCount = 0;
//            //System.out.println("game state: " + gameState);
//            String strs = "";
//            for (int x = 0; x < gameState.length(); x++) {
//                strs += gameState.substring(x, x+1);
//
//                if(gameState.substring(x, x+1).equals(" ")) {
//
//                    if (strs.matches("\\d+ ")) {
//                        strs = strs.replaceAll("\\s", "");
//                        int number = Integer.parseInt(strs);
//                        Driver.tamas.setTamaIndex(tamaOn);
//                        //Driver.tamas.setTamaIndex(tamaOn);
//                        Tama currentTama = Driver.tamas.getTama();
//                        switch (currentCount) {
//                            default:
//                                System.out.println("That didn't work:" + number + ", counter at " + currentCount);
//                                break;
//                            case 0:
//                                currentTama.setFood(number);
//                                //System.out.println("GAME LOADER: " + "food" + Driver.getTama().getFood());
//                                break;
//                            case 1:
//                                currentTama.setHealth(number);
//                                //System.out.println("GAME LOADER: " + Driver.getTama().getHealth());
//                                break;
//                            case 2:
//                                currentTama.setPetState(number);
//                                //System.out.println("GAME LOADER: " + Driver.getTama().getPetState());
//                                break;
//                            case 3:
//                                currentTama.setPoop(number);
//                                //System.out.println("GAME LOADER: " + Driver.getTama().getPoop());
//                                break;
//                            case 4:
//                                currentTama.setExp(number);
//                                //System.out.println("GAME LOADER: " + Driver.getTama().getExp());
//                        }
//                        currentCount++;
//                    }
//                    strs = "";
//                }
//            }
//            tamaOn++;
//        }
//        //System.out.println(Driver.getTamas()[0]);
//        //System.out.println(Driver.getTamas()[1]);
//    }

    public static Tama[] readFile() {
        try {
            reader = new Scanner(file);
            reader.useDelimiter(System.getProperty("line.separator"));
        } catch (Exception FileNotFound) {
            System.out.println("Scanner could not find file: " + file);
            System.out.println("Setting default settings.");
        }

        String name = "";
        int[] ints = new int[5];
        int at = 0;

        name = reader.next(); // what is this??

        int i = 0;
        while(reader.hasNext()) {
            if(reader.hasNextInt()) {
                ints[i] = reader.nextInt();
                i++;
            }
            reader.next();
        }

        Tama current = new Tama(name, name, ints);
        Tama[] array = new Tama[2];
        array[at] = current;
        at++;

        return array;
    }
}