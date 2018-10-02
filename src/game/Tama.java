package game;

import javax.swing.*;
import java.util.ArrayList;

public class Tama {

    private String name;
    private int food, health, petState, poop;
    private JLabel tom;
    private int exp;
    private int expPerFood = 10;                     //TODO: was there a reason why expPerFood was an array if so, I can change it back
    private double lastTimeFed;
    private static int currentInstance;
    private String folderName;
    //for adding and removing poop
    private ArrayList<JLabel> poops = new ArrayList<JLabel>();

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

    public int getExp(){ return exp; }                               //TODO: fix exp

    public void setExp(int exp) {
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
        setTamaPicture();
        Driver.changeTamaLabel(tom);
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public int getExpPerFood() {
        return expPerFood;
    }

    public void setExpPerFood(int expPerFood) {
        this.expPerFood = expPerFood;
    }

    public void setTamaPicture() {
        switch(petState) {
            default:
                System.out.println("Value in Windows setTamaPicture was not correct.");
                break;
            case 0:
                JLabel ghost = new JLabel(new ImageIcon(Tama.class.getResource("Images/" + folderName + "/Dead.gif")));
                ghost.setBounds((Driver.getShow().getWidth() / 2) - 50, 130, 100, 100);
                tom = ghost;

                break;

            case 1:
                ImageIcon eggIcon = new ImageIcon(Tama.class.getResource("Images/" + folderName + "/First.gif"));
                JLabel egg = new JLabel(eggIcon);
                egg.setBounds((Driver.WIDTH + eggIcon.getIconWidth())/2, 170, eggIcon.getIconWidth(), eggIcon.getIconHeight());
                tom = egg;


                break;

            case 2:
                ImageIcon lizardIcon = new ImageIcon(Tama.class.getResource("Images/" + folderName + "/Second.gif"));
                JLabel lizard = new JLabel(lizardIcon);
                lizard.setBounds((Driver.WIDTH / 2) + lizardIcon.getIconWidth(), 130, lizardIcon.getIconWidth(), lizardIcon.getIconHeight());
                tom = lizard;
                break;
        }
    }

    public void addPoop() {
        if(this.poop >= 15) {
            System.out.println("Pet Died");
            petState = 0;
            setTamaPicture();
            Driver.changeTamaLabel(tom);
        }
        else {
            ImageIcon poopIcon = new ImageIcon(Tama.class.getResource("Images/poo.png"));
            JLabel poop = new JLabel(poopIcon);
            poop.setBounds(50 + (int) (Math.random() * 30), 150 + (int) (Math.random() * 30), poopIcon.getIconWidth(), poopIcon.getIconHeight());
            poops.add(poop);
            this.poop++;
            Driver.addPoop(poop);
        }
    }

    public void removePoop() {
            for (int i = 0; i < poops.size(); i++) {
                Driver.removePoop(poops.get(i));
            }
            poop = 0;
    }

    /**
     * Returns user set instance variables and instance variables that change through the
     * running of the application. @return String of those variables.
     */
    public String toString() {
	    return "Name: " + name + "\n" +
                "Tama Instance: " + currentInstance + "\n" +
                "Folder Name: " + folderName + "\n" +
                "Food: " + food + "\n" +
                "Health: " + health + "\n" +
                "Pet State: " + petState + "\n" +
                "Poop: " + poop + "\n" +
                "Exp: " + exp + "\n" +
                "Exp Per Food: " + expPerFood + "\n" +
                "Last Time Fed: " + lastTimeFed + "\n" +
                "ArrayList Poops: " + poops.toArray();
    }

    /**
     * Resets all the feature about the Tama except for the name and foldername.
     */
    public void reset() {
        this.health = 0;
        this.petState = 1;
        this.exp = 0;
        this.food = 0;
        setTamaPicture();
    }
}
