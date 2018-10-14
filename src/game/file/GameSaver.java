package game.file;

import game.Driver;
import game.Tama;

import java.io.FileWriter;

public class GameSaver {

    private FileWriter pen;

    public GameSaver() {
        int tamaOn = 0;
        String[] labels = {"food: ", " health: ", " petState: ", " poop: ", " EXP: "};
        //System.out.println("GameSaver ran");

        try {
            pen = new FileWriter(GameLoader.getFile());
            //System.out.println("Got file!");
            for(int i = 0; i < Driver.tamas.getTotalTamas(); i++) {
                Driver.tamas.setTamaIndex(i);
                Tama currentTama = Driver.tamas.getTama();
                pen.write(currentTama.getName() + " ");
                int[] values = {currentTama.getFood(), currentTama.getHealth(), currentTama.getPetState(), currentTama.getPoop(), currentTama.getExp()};

                for (int k = 0; k < values.length; k++) {
                    pen.write(labels[k] + values[k]);
                }
                pen.write(" " + System.getProperty("line.separator"));
            }
            pen.close();
        } catch(Exception IOException) {
            System.out.println("file Writer messed up. \n Could not save game.");
        }
    }
}