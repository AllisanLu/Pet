package game;

import javax.swing.*;
import java.util.ArrayList;

public class Tama implements java.io.Serializable {

    private int food, health, petState;
    private transient JLabel tamaPic;
    private int exp, expPerFood;
    private double lastTimeFed;
    private String folderName;
    private ArrayList<JLabel> poops = new ArrayList<JLabel>();

    /**
     * Sets Tama to default values as if it was starting new.
     */
    public Tama(String path) {
        expPerFood = 10;

        folderName = path;
        setTamaPic();
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getPoop(){ return poops.size(); }

    public JLabel getTamaPic() { return tamaPic; }

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

    /**
     * Increases the petState and changes the picture to the next level of the Tama.
     */
    public void grow() {
        if(petState < 2) {
            this.petState += 1;

            this.exp = 0;
            setTamaPic();
            Driver.changeTamaLabel(tamaPic);
        }
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

    public void setTamaPic() {
        switch(petState) {
            default:
                System.out.println("Value in Windows petState was not correct:" + petState);
                break;

            case 0:
                ImageIcon ghostIcon = new ImageIcon(folderName + "dead.gif");
                JLabel ghost = fixTamaDimensions(ghostIcon);
                tamaPic = ghost;
                break;

            case 1:
                ImageIcon eggIcon = new ImageIcon(folderName + "First.gif");
                JLabel egg = fixTamaDimensions(eggIcon);
                tamaPic = egg;
                break;

            case 2:
                ImageIcon lizardIcon = new ImageIcon(folderName + "Second.gif");
                JLabel lizard = fixTamaDimensions(lizardIcon);
                tamaPic = lizard;
                break;
        }
    }

    private JLabel fixTamaDimensions(ImageIcon icon) {
        JLabel rtn = new JLabel(icon);
        rtn.setBounds((Constants.GUIDimensions.GUI_WIDTH - icon.getIconWidth())/2, Constants.GUIDimensions.GUI_HEIGHT * 6/10, icon.getIconWidth(), icon.getIconHeight());
        return rtn;
    }

    public void addPoop() {
        if(poops.size() >= 15) {
            System.out.println("Pet Died");
            petState = 0;
            setTamaPic();
            Driver.changeTamaLabel(tamaPic);
        }
        else {
            ImageIcon poopIcon = new ImageIcon(Constants.Paths.IMAGES + "poo.png");
            JLabel poop = new JLabel(poopIcon);
            poop.setBounds((Constants.GUIDimensions.GUI_WIDTH - tamaPic.getWidth())/2 + (int) (Math.random() * 50), 180 + (int) (Math.random() * 5), poopIcon.getIconWidth(), poopIcon.getIconHeight());
            poops.add(poop);
            Driver.addPoop(poop);
        }
    }

    public void removePoop() {
        Driver.removePoop(poops);
        poops.clear();
    }

    /**
     * Returns user set instance variables and instance variables that change through the
     * running of the application. @return String of those variables.
     */
    public String toString() {
        return "Folder Name: " + folderName + "\n" +
                "Food: " + food + "\n" +
                "Health: " + health + "\n" +
                "Pet State: " + petState + "\n" +
                "Poop: " + poops.size() + "\n" +
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
        lastTimeFed = System.currentTimeMillis();
        setTamaPic();
    }
}