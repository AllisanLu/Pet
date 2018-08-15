package game;

import java.io.File;
import java.io.IOException;

public class GameLoader {
    private static File file;

    public static File getFile() {
        return file;
    }

    public static void makeFile() throws IOException{
        file = new File(GameSaver.class.getResource("bin/gameSaved.txt").toString());
        if(!file.exists()) {
            file.createNewFile();
        }
    }
}
