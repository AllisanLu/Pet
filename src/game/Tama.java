package game;

import javax.swing.JLabel;

public class Tama {

    private String name;
    private int food, health, petState;
    private JLabel tom;
    private double exp;
    private double[] expPerFood = { 10, 5, 1.5, .9};
    private double lastTimeFed;
    private static int currentTamaInstance;
    private String folderName;

    public Tama(){
        this.food = 0;
        this.health = 0;
        this.lastTimeFed = System.currentTimeMillis();
    }

    public Tama(String name, String folderName) {
	    this.food = 0;
	    this.name = name;
	    this.health = 0;
	    this.petState = 0;
	    this.folderName = folderName;
	    this.lastTimeFed = System.currentTimeMillis();
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

    public double getExp() {
        return exp;
    }

    public static int getCurrentTamaInstance() {
        return currentTamaInstance;
    }

    public static void setCurrentTamaInstance(int currentTamaInstance) {
        Tama.currentTamaInstance = currentTamaInstance;
    }

    public void setExp(double exp) {
        this.exp = exp;
    }

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

    public double[] getExpPerFood() {
        return expPerFood;
    }

    public void setExpPerFood(double[] expPerFood) {
        this.expPerFood = expPerFood;
    }

    public String toString() {
	    return "Food: " + food + "\n" +
                "Health" + health + "\n" +
                "petState" + petState + "\n";
    }
}
