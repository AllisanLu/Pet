package game;

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
    }

    public static Tama getTama() {
        return jerry;
    }
}
