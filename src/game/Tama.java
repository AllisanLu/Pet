package game;

import javax.swing.JLabel;
import javax.swing.*;

public class Tama {
    private int food = 0;
    private JLabel tom;
    private int health = 6;
    private int petState = 0;



	public Tama() {
		Window.showPet(this);
	}

    public int getFood() {
        return food;
    }

    public void incrementFood(int food) {
        this.food += food;
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
    public void incrementPetState(int petState) {
        this.petState += petState;
    }

    public void grow() {
	    this.petState += 1;
        Window.growTama(this.petState);
    }
}
