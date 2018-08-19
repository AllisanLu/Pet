package game;
import game.file.GameLoader;
import game.file.WindowActivation;

public class Driver {

    private static Tama jerry = new Tama();

    public static void main(String[] args) {
        WindowActivation test = new WindowActivation(Window.getShow());

        try {
            GameLoader.makeFile();
        }catch (Exception IoException){
            System.out.println("error in Game Loader");
        }
    }

    public static Tama getTama() {
        return jerry;
    }
}
