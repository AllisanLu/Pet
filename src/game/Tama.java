package game;

import javax.swing.*;
import java.util.ArrayList;

public class Tama {

    private String name;
    private int food, health, petState;
    private JLabel tom;
    private int exp;
    private int expPerFood = 10;            //TODO: was there a reason why expPerFood was an array if so, I can change it back
    private double lastTimeFed;
    private String folderName;
    private ArrayList<JLabel> poops = new ArrayList<JLabel>();

    /**
     * Sets minimum basic instance variables in Tama. Should
     * only be used if there is an error retrieving data from the txt files.
     */
    public Tama() {
        this.food = 0;
        this.health = 0;
        this.lastTimeFed = 0;
    }

    /**
     * @param name       Sets the name for Tama that user created.
     * @param folderName The folder where the data for the game.Tamas are saved.
     */
    public Tama(String name, String folderName) {      //String folderName what is this for
        this.food = 0;
        this.name = name;
        this.health = 0;
        this.petState = 0;
        this.exp = 0;
        this.folderName = folderName;
        this.lastTimeFed = System.currentTimeMillis();      //TODO: gotta fix last time fed
    }

    public String getName() {
        return name;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getPoop() {
        return poops.size();
    }

    public void setPoop(int poop) {
        for(int i = 0; i < poop; i++) {
            addPoop();
        }
    }

    public JLabel getTom() {
        return tom;
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

    public double getLastTimeFed() {
        return this.lastTimeFed;
    }

    public void setLastTimeFed(double lastTimeFed) {
        this.lastTimeFed = lastTimeFed;
    }

    public int getExp() {
        return exp;
    }                               //TODO: fix exp

    public void setExp(int exp) {
        this.exp = exp;
    }

    /**
     * Increases the petState and changes the picture to the next level of the Tama.
     */
    public void grow() {
        if (petState < 2) {
            this.petState += 1;

            this.exp = 0;
            setTamaPicture();
            Driver.changeTamaLabel(tom);
        }
    }

    public int getExpPerFood() {
        return expPerFood;
    }

    public void setExpPerFood(int expPerFood) {
        this.expPerFood = expPerFood;
    }

    public void setTamaPicture() {
        switch (petState) {
            default:
                System.out.println("Value in Windows setTamaPicture was not correct.");
                break;
            case 0:
                ImageIcon ghostIcon = new ImageIcon(Tama.class.getResource("Images/" + folderName + "/Dead.gif"));
                JLabel ghost = new JLabel(ghostIcon);
                ghost.setBounds((Driver.SHOW_WIDTH - ghostIcon.getIconWidth()) / 2, 150, ghostIcon.getIconWidth(), ghostIcon.getIconHeight());
                tom = ghost;
                break;

            case 1:
                ImageIcon eggIcon = new ImageIcon(Tama.class.getResource("Images/" + folderName + "/First.gif"));
                JLabel egg = new JLabel(eggIcon);
                egg.setBounds((Driver.SHOW_WIDTH - eggIcon.getIconWidth()) / 2, 170, eggIcon.getIconWidth(), eggIcon.getIconHeight());
                tom = egg;
                break;

            case 2:
                ImageIcon lizardIcon = new ImageIcon(Tama.class.getResource("Images/" + folderName + "/Second.gif"));
                JLabel lizard = new JLabel(lizardIcon);

                lizard.setBounds((Driver.SHOW_WIDTH - lizardIcon.getIconWidth()) / 2, 150, lizardIcon.getIconWidth(), lizardIcon.getIconHeight());
                tom = lizard;

                break;
        }
    }

    public void addPoop() {
        if (poops.size() >= 15) {
            System.out.println("Pet Died");
            petState = 0;
            setTamaPicture();
            Driver.changeTamaLabel(tom);
        } else {
            ImageIcon poopIcon = new ImageIcon(Tama.class.getResource("Images/poo.png"));
            JLabel poop = new JLabel(poopIcon);
            poop.setBounds((Driver.SHOW_WIDTH - tom.getWidth()) / 2 + (int) (Math.random() * 50), 180 + (int) (Math.random() * 5), poopIcon.getIconWidth(), poopIcon.getIconHeight());
            poops.add(poop);
            Driver.addPoop(poop);
        }
    }

    public void removePoop() {
        for (int i = 0; i < poops.size(); i++) {
            Driver.removePoop(poops.get(i));
        }
    }

    /**
     * Returns user set instance variables and instance variables that change through the
     * running of the application. @return String of those variables.
     */
    public String toString() {
        return "Name: " + name + "\n" +
                "Folder Name: " + folderName + "\n" +
                "Food: " + food + "\n" +
                "Health: " + health + "\n" +
                "Pet State: " + petState + "\n" +
                "Exp: " + exp + "\n" +
                "Exp Per Food: " + expPerFood + "\n" +
                "Last Time Fed: " + lastTimeFed + "\n" +
                "ArrayList Poops: " + poops.size();
    }

    /**
     * Resets all the feature about the Tama except for the name and foldername.
     */
    public void reset() {
        health = 0;
        petState = 1;
        exp = 0;
        food = 0;
        removePoop();
        lastTimeFed = System.currentTimeMillis();
        setTamaPicture();
    }
}