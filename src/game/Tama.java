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
    private static ArrayList<JLabel> poops = new ArrayList<JLabel>();
    private static int poopCounter;

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
        setTamaPicture(this);
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

    public static void setTamaPicture(Tama currentTama) {
        try{
            Driver.getShow().remove(currentTama.getTom());
        }catch (Exception NullPointerException ){
            System.out.println("no tama yet!");
        }
        switch(currentTama.getPetState()) {
            default:
                System.out.println("Value in Windows setTamaPicture was not correct.");
                break;
            case 0:
                JLabel egg = new JLabel(new ImageIcon(Tama.class.getResource("Images/" + currentTama.getFolderName() + "/First.gif")));
                egg.setBounds((Driver.getShow().getWidth() / 2) - 12, 170, 22, 27);
                currentTama.setTom(egg);

                Driver.getShow().add(currentTama.getTom());
                break;
            case 1:
                Driver.getShow().remove(currentTama.getTom()); // this isnt working

                JLabel lizard = new JLabel(new ImageIcon(Tama.class.getResource("Images/" + currentTama.getFolderName() + "/Second.gif")));
                lizard.setBounds((Driver.getShow().getWidth() / 2) - 50, 130, 100, 100);
                currentTama.setTom(lizard);

                Driver.getShow().add(currentTama.getTom());
                break;

            case 2:
                Driver.getShow().remove(currentTama.getTom()); // this isnt working

                JLabel ghost = new JLabel(new ImageIcon(Tama.class.getResource("Images/" + currentTama.getFolderName() + "/Dead.gif")));
                ghost.setBounds((Driver.getShow().getWidth() / 2) - 50, 130, 100, 100);
                currentTama.setTom(ghost);

                Driver.getShow().add(currentTama.getTom());
                break;
        }
        Driver.reDrawWindow();
    }

    public static void addPoop() {
        Tama currentTama = Driver.getTama();
        if(poopCounter >= 15) {
            System.out.println("Pet Died");
            Driver.getTama().setPetState(2);
            setTamaPicture(Driver.getTama());
        }
        else {
            JLabel poop = new JLabel(new ImageIcon(Tama.class.getResource("Images/poo.png")));
            poop.setBounds(50, 50, 100 + (int) (Math.random() * 80), 230 + (int) (Math.random() * 80));
            poops.add(poop);
            poopCounter++;
            currentTama.setPoop(poopCounter);
            Driver.getShow().add(poop);
            Driver.reDrawWindow();
        }
    }

    public static void removePoop() {
        Tama currentTama = Driver.getTama();
        if(!(poopCounter == 0)){
            for (int i = 0; i < poops.size(); i++) {
                Driver.getShow().remove(poops.get(i));
                Driver.reDrawWindow();
            }
            poopCounter = 0;
            currentTama.setPoop(poopCounter);
        }
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
        setTamaPicture(this);
    }
}
