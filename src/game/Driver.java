package game;
import game.file.GameLoader;
import game.file.WindowActivation;
import sun.plugin2.os.windows.Windows;

import java.util.Calendar;
import java.util.Date;

public class Driver {

    private static Tama[] Tamas;
    public static void main(String[] args) {
        Tama jerry = new Tama("jerry", "jerry");
        Tama terry = new Tama("terry", "terry");
        Tama.setInstance(0);
        Tamas = new Tama[2];
        Tamas[0] = jerry;
        Tamas[1] = terry;
        WindowActivation test = new WindowActivation();
        try {
            GameLoader.makeFile();
        }catch (Exception IoException){
            System.out.println("error in Game Loader");
        }
        Window.showPet(Tamas[Tama.getInstance()]);

        Window.updateClock();
    }



    public static Tama getTama() {
        return Tamas[Tama.getInstance()];
    }

    public static Tama[] getTamas(){ return Tamas; }
}