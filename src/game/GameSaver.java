package game;

import java.io.FileWriter;
import java.io.IOException;

public class GameSaver {
    public GameSaver(Tama jerry) throws IOException {
        FileWriter pen = new FileWriter(GameLoader.getFile());
        String[] labels = {"food: ", "health: ", "pet state: "};
        int[] values = {jerry.getFood(), jerry.getHealth(), jerry.getPetState()};

        for (int i = 0; i < values.length; i++) {
            pen.write(labels[i] + values[i] + "\n");
        }
    }
}
