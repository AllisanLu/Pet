package game.buttons;

import game.Driver;
import game.Tama;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CleanButton implements ActionListener {

    public CleanButton(JButton poop) {
        poop.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Tama currentTama = Driver.getTama();

        currentTama.removePoop();
        System.out.println("ALL THE POOP IS GONE" + "\n" + "poop: " + Driver.getTama().getPoop());
    }
}
