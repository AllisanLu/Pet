package game.file;

import game.Driver;
import game.Tama;

import java.io.FileWriter;

public class GameSaver {

    private FileWriter pen;

    public GameSaver(Tama[] tamas) {
        int tamaOn = 0;
        Tama currentTama;
        String[] labels = {"food: ", " health: ", " petState: ", " poop: ", " EXP: "};
        //System.out.println("GameSaver ran");

        try {
            pen = new FileWriter(GameLoader.getFile());
            //System.out.println("Got file!");

            for(int x = 0; x < tamas.length; x++) {
                currentTama = tamas[tamaOn];
                //System.out.println(currentTama);
                pen.write(currentTama.getName() + " ");
                int[] values = {currentTama.getFood(), currentTama.getHealth(), currentTama.getPetState(), currentTama.getPoop(), currentTama.getExp()};

                for (int i = 0; i < values.length; i++) {
                    pen.write(labels[i] + values[i]);
                    //System.out.println("GAME SAVER: " + labels[i] + ": " + values[i]);
                }
                pen.write(" " + System.getProperty("line.separator"));
                tamaOn++;
            }
            pen.close();
        } catch(Exception IOException) {
            System.out.println("file Writer messed up. \n Could not save game.");
        }
    }
}
