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
        Tama jerry = Driver.getTama();

        jerry.setExp(jerry.getExp() + jerry.getExpPerFood()[levelCounter]);
        jerry.setFood(jerry.getFood() + 1);
        if(jerry.getExp() >= 100) {
            levelCounter++;
            Driver.getTama().grow();
            System.out.println("BABY HAS GROWN UP!");
        }
    }
}