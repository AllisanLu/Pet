package game.buttons;

import game.Driver;
import game.Tama;

import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//public class SwitchToJerry implements PopupMenuListener {

public class SwitchToJerry implements ActionListener {

    public SwitchToJerry(JMenuItem jerryMenu) {
        jerryMenu.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(Tama.getInstance() != 0) {
            Tama currentTama = Driver.getTama();
            for (int x = 0; x < currentTama.getPoop(); x++) {
                currentTama.removePoop();
            }
            Driver.getShow().remove(currentTama.getTom());

            System.out.println("Switching to Jerry");

            Tama.setInstance(0);

            currentTama = Driver.getTama();
            currentTama.setTamaPicture();
            Driver.getShow().add(currentTama.getTom());

            System.out.println(currentTama.getPoop());
            for (int i = 0; i < currentTama.getPoop(); i++) {
                currentTama.removePoop();
                //TODO: add correct amount of poop, why does it only add one right now? btw the Driver.get poop() thing works
            }
        }
    }

}