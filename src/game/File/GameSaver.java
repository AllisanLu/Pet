package game.File;

import game.File.GameLoader;
import game.Tama;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.io.IOException;

public class GameSaver {

    private FileWriter pen;

    public GameSaver(Tama jerry) {

        String[] labels = {"food: ", "health: ", "pet state: "};
        int[] values = {jerry.getFood(), jerry.getHealth(), jerry.getPetState()};

        try {
             pen = new FileWriter(GameLoader.getFile());
             //System.out.println("Got file!");

            for (int i = 0; i < values.length; i++) {
                pen.write(labels[i] + values[i] + "\n");
            }
        } catch(Exception IOException) {
            System.out.println("File Writer messed up. \n Could not save game.");
        }

    }
}
