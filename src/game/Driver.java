package game;

public class Driver {

    public static Tama jerry = new Tama();

    public static void main(String[] args) {
        GameLoader.makeFile();
        GameLoader.readFile();
    }

    public static Tama getTama() {
        return jerry;
    }
}
