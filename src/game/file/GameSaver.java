package game.file;

import game.Tama;

import java.io.FileWriter;

public class GameSaver {

    private FileWriter pen;

    public GameSaver(Tama currentTama) {

        String[] labels = {"food: ", " health: ", " petState: ", " poop: "};
        int[] values = {currentTama.getFood(), currentTama.getHealth(), currentTama.getPetState(), currentTama.getPoop()};
        System.out.println("this ran");
        try {
             pen = new FileWriter(GameLoader.getFile());
             System.out.println("Got file!");

            for (int i = 0; i < values.length; i++) {
                pen.write(labels[i] + values[i] + "\n");
            }
            pen.close();
        } catch(Exception IOException) {
            System.out.println("file Writer messed up. \n Could not save game.");
        }
    }
}
