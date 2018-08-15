package game;

import java.io.FileWriter;
import java.io.IOException;

public class GameSaver {
    public GameSaver() throws IOException {
        FileWriter pen = new FileWriter(GameLoader.getFile());
        String[] labels = {"food: ", "health: ", "pet state: "};
        int[] values = {Tama.food, Tama.health, Tama.petState};

        for (int i = 0; i < values.length; i++) {
            pen.write(labels[i] + values[i] + "\n");
        }
    }
}
