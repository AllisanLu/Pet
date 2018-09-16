package game;

import javax.swing.JLabel;

public class Tama {

    private String name;
    private int food, health, petState, poop;
    private JLabel tom;
    private double exp;
    private double expPerFood = 10;                     //TODO: was there a reason why expPerFood was an array if so, I can change it back
    private double lastTimeFed;
    private static int currentInstance;
    private String folderName;

    /**
     * Sets minimum basic instance variables in Tama. Should
     * only be used if there is an error retrieving data from the txt files.
     */
    public Tama(){
        this.food = 0;
        this.health = 0;
        this.poop = 0;
        this.lastTimeFed = System.currentTimeMillis();
    }

    /**
     * @param name Sets the name for Tama that user created.
     * @param folderName The folder where the data for the Tamas are saved.
     */
    public Tama(String name, String folderName) {
	    this.food = 0;
	    this.name = name;
	    this.health = 0;
	    this.petState = 0;
	    this.folderName = folderName;
	    this.lastTimeFed = System.currentTimeMillis();      //TODO: gotta fix last time fed
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
	    this.food = food;
    }

    public int getPoop(){ return poop; }

    public void setPoop(int poop) { this.poop = poop;}

    public JLabel getTom() { return tom; }

    public void setTom(JLabel tom) {
        this.tom = tom;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPetState() {
        return this.petState;
    }

    public void setPetState(int petState) {
        this.petState = petState;
    }

    public void setLastTimeFed(double lastTimeFed) {
        this.lastTimeFed = lastTimeFed;
    }

    public double getLastTimeFed() {
	    return this.lastTimeFed;
    }

    public double getExp(){ return exp; }                               //TODO: fix exp

    public void setExp(double exp) {
        this.exp = exp;
    }

    public static int getInstance() { return currentInstance; }

    public static void setInstance(int currentTamaInstance) {
        Tama.currentInstance = currentTamaInstance;
    }

    /**
     * Increases the petState and changes the picture to the next level of the Tama.
     */
    public void grow() {
	    this.petState += 1;

	    this.exp = 0;
        Window.setTamaPicture(this);
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public double getExpPerFood() {
        return expPerFood;
    }

    public void setExpPerFood(double expPerFood) {
        this.expPerFood = expPerFood;
    }

    /**
     * Returns user set instance variables and instance variables that change through the
     * running of the application. @return String of those variables.
     */
    public String toString() {
	    return "Name: " + name + "\n" +
                "TamaInstance: " + currentInstance + "\n" +
                "Food: " + food + "\n" +
                "Health: " + health + "\n" +
                "PetState: " + petState + "\n" +
                "Exp: " + exp + "\n";


    }

    /**
     * Resets all the feature about the Tama except for the name and foldername.
     */
    public void reset() {
        this.health = 0;
        this.petState = 0;
        this.exp = 0;
        this.food = 0;
        Window.setTamaPicture(this);
    }
}
