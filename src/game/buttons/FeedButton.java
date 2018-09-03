package game.buttons;

import game.Driver;
import game.Tama;
import game.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FeedButton implements ActionListener {

    private int levelCounter = 0;

    public FeedButton(JButton food) {
        food.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        double currentTime = System.currentTimeMillis();
        Tama currentTama = Driver.getTama();
        //If Tama has been fed in the last 5 minutes prints I'm to full
        Window.addPoop();
        if(currentTime - currentTama.getLastTimeFed() < 30000) {
            System.out.println("I'm to full");
        }
        else {
            currentTama.setLastTimeFed(System.currentTimeMillis());
            currentTama.setExp(currentTama.getExp() + currentTama.getExpPerFood()[levelCounter]);
            currentTama.setFood(currentTama.getFood() + 1);
            if(currentTama.getExp() >= 100) {
                levelCounter++;
                currentTama.grow();
                System.out.println("BABY HAS GROWN UP!");
            }
        }
    }
}