package game.buttons;

import game.Driver;
import game.Tama;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwitchToTerry implements ActionListener{
    public SwitchToTerry(JMenuItem terryMenu) {
        terryMenu.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(Tama.getInstance() != 1) {
            Tama currentTama = Driver.getTama();
            for (int x = 0; x < currentTama.getPoop(); x++) {
                currentTama.removePoop();
            }
            Driver.removeTama(currentTama.getTom());

            System.out.println("Switching to Terry");

            Tama.setInstance(1);
            currentTama = Driver.getTama();
            //System.out.println(currentTama);
            currentTama.setTamaPicture();
            Driver.addTama(currentTama.getTom());

            for (int i = 0; i < currentTama.getPoop(); i++) {
                currentTama.addPoop();
                //TODO: add correct amount of poop, why does it only add one right now? btw the Driver.get poop() thing works
            }
        }
    }
}
