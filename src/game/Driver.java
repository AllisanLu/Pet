package game;
import game.file.GameLoader;
import game.file.WindowActivation;

public class Driver {

    private static Tama[] Tamas;
    public static void main(String[] args) {
        WindowActivation test = new WindowActivation();
        Tama jerry = new Tama("jerry", "jerry");
        Tama.setInstance(0);
        Tamas = new Tama[1];
        Tamas[0] = jerry;
        Window.showPet(Tamas[Tama.getInstance()]);
        try {
            GameLoader.makeFile();
        }catch (Exception IoException){
            System.out.println("error in Game Loader");
        }
    }
    
    public static Tama getTama() {
        return Tamas[Tama.getInstance()];
    }
}
