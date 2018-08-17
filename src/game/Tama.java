package game;

import javax.swing.JLabel;

public class Tama {

    private String name;
    private int food, health, petState;
    private JLabel tom;
    private double exp;
    private double[] expPerFood = { 10, 5, 1.5, .9};

	public Tama() {
	    food = 0;
	    health = 0;
	    petState = 0;
		Window.showPet(this);
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

    public JLabel getTom() {
        return tom;
    }

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
        return petState;
    }

    public void setPetState(int petState) {
        this.petState = petState;
    }

    public double getExp() {
        return exp;
    }

    public void setExp(double exp) {
        this.exp = exp;
    }

    public void grow() {
	    this.petState += 1;
	    this.exp = 0;
        Window.setTamaPicture(this);
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
