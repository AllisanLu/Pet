package game;

import java.io.File;
import java.io.IOException;

public class GameLoader {
    private static File file;

    public static File getFile() {
        return file;
    }

    public static void makeFile() throws IOException{
        //System.out.println(GameSaver.class.getResource("bin/gameSaved.txt").toString());
        file = new File(GameSaver.class.getResource("bin/gameSaved.txt"));
        file.createNewFile();
        System.out.println("FIle ahs been created");
    }
}

