package game.file;

import game.Tama;

import java.io.FileWriter;

public class GameSaver {

    private FileWriter pen;

    public GameSaver(Tama jerry) {

        String[] labels = {"food: ", "health: ", "pet state: "};
        int[] values = {jerry.getFood(), jerry.getHealth(), jerry.getPetState()};
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
