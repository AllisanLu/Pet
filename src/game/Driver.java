package game;
import game.File.GameLoader;
import game.File.GameSaver;
import game.File.WindowActivation;

public class Driver {

    private static Tama jerry = new Tama();

    public static void main(String[] args) {
        WindowActivation test = new WindowActivation(Window.getShow());

        try {
            GameLoader.makeFile();
        }catch (Exception IoException){
            System.out.println("error in Game Laoder");
        }
    }

    public static Tama getTama() {
        return jerry;
    }
}
