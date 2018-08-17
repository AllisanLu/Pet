package game;
import javax.swing.JOptionPane;

public class Driver {

    public static Tama jerry = new Tama();

    public static void main(String[] args) {
        GameLoader.makeFile();
        GameLoader.readFile();

        try {
            GameLoader.makeFile();
        }catch (Exception IoException){
            System.out.println("error in Game Laoder");
        }

        show.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                GameSaver.gameSaver();
            }
        });
    }

    public static Tama getTama() {
        return jerry;
    }
}
