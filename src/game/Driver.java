package game;

public class Driver {

    public static Tama jerry = new Tama();

    public static void main(String[] args) {
<<<<<<< HEAD
        GameLoader.makeFile();
        GameLoader.readFile();
=======
        try {
            GameLoader.makeFile();
        }catch (Exception IoException){
            System.out.println("error in Game Laoder");
        }
>>>>>>> f7434db5611964fa1e093242947f2f831886ad98
    }

    public static Tama getTama() {
        return jerry;
    }
}
