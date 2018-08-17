package game.buttons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CleanButton implements ActionListener {

    public CleanButton(JButton poop) {
        poop.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("ALL THE POOP IS GONE");

    }
}
