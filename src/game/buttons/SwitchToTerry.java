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

            currentTama.removePoop();


            System.out.println("Switching to Terry");

            Tama.setInstance(1);

            currentTama = Driver.getTama();
            //System.out.println(currentTama);

            currentTama.setTamaPicture();
            Driver.changeTamaLabel(currentTama.getTom());

            int poop = currentTama.getPoop();
            System.out.println(currentTama.getName() + " " + currentTama.getPoop());
            currentTama.setPoop(0);
            for (int i = 0; i < poop; i++) {
                currentTama.addPoop();
            }
        }
    }
}