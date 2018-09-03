package game.buttons;

import game.Driver;
import game.Tama;
import game.Window;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetButton implements ActionListener {

    public ResetButton(JButton dead){
        dead.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent arg0) {
        Tama currentTama = Driver.getTama();
        currentTama.reset();

        Window.removePoop();
        System.out.println("DERP");
    }
}

