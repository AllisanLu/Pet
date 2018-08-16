package game;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;

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

    public void incrementPetState(int petState) {
		this.petState += petState;
	}

	public void grow() {
		this.incrementPetState(1);
		Window.growTama(this.petState);
	}
}