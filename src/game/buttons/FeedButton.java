package game.buttons;

import game.Driver;
import game.Tama;
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
        Tama currentTama = Driver.getTama();

        currentTama.setExp(currentTama.getExp() + currentTama.getExpPerFood()[levelCounter]);
        currentTama.setFood(currentTama.getFood() + 1);
        if(currentTama.getExp() >= 100) {
            levelCounter++;
            Driver.getTama().grow();
            System.out.println("BABY HAS GROWN UP!");
        }
    }
}