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

            Tama.removePoop();

            Driver.removeTama(currentTama.getTom());

            System.out.println("Switching to Terry");

            Tama.setInstance(1);

            currentTama = Driver.getTama();
            //System.out.println(currentTama);

            Driver.addTama(Tama.setTamaPicture(currentTama));

            for (int i = 0; i < currentTama.getPoop(); i++) {
                Tama.addPoop();
                //TODO: add correct amount of poop, why does it only add one right now? btw the Driver.get poop() thing works
            }
            Driver.reDrawWindow();
        }
    }
}
