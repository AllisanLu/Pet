package game.buttons;

import game.Driver;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FeedButton implements ActionListener {

    private int[] levelUp = { 10, 20, 30, 40, };
    private int levelCounter = 0;

    public FeedButton(JButton food) {
        food.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("BABY HAS BEEN FED");

        Driver.getTama().incrementFood(1);
        if(Driver.getTama().getFood() >= levelUp[levelCounter]) {
            levelCounter++;
            Driver.getTama().grow();
            System.out.println("BABY HAS GROWN UP!");
        }
    }
}