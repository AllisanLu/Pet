package game.buttons;

import game.Driver;
import game.Tama;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FeedButton implements ActionListener {

    //private int levelCounter = 0; // TODO: what is thisss????

    public FeedButton(JButton food) {
        food.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        double currentTime = System.currentTimeMillis();
        Tama currentTama = Driver.getTama();
        //System.out.println("For feeding: " + Driver.getTama().getFood() + " " + Tama.getInstance());
        //If Tama has been fed in the last 5 minutes prints I'm to full
        Tama.addPoop();
//        if(currentTime - currentTama.getLastTimeFed() < 30000) {
//            System.out.println("I'm to full");
//        }
//        else {
            currentTama.setLastTimeFed(System.currentTimeMillis());
            currentTama.setExp(currentTama.getExp() + currentTama.getExpPerFood()); //!! removed [level counter from getExpPerFood "array" ?
            currentTama.setFood(currentTama.getFood() + 1);
            if(currentTama.getExp() >= 100) {
                //levelCounter++;
                if(currentTama.getPetState() < 1) {
                    currentTama.grow();
                    System.out.println("Tama: " + currentTama.getName());
                    System.out.println("BABY HAS GROWN UP!");
                }
            }
//        }
    }
}

//TODO: add the timmer thinggy rn it's removed