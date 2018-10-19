package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TamaSwitcher implements ActionListener{
    public TamaSwitcher(JMenuItem... Jmen) {
        for(JMenuItem J : Jmen) {
            J.addActionListener(this);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand() + " " + Driver.tamas.getTama().getName());
        if(!e.getActionCommand().equalsIgnoreCase(Driver.tamas.getTama().getName())) {
            Tama currentTama = Driver.tamas.getTama();

            currentTama.removePoop();


            System.out.println("Switching to Terry");

            Driver.tamas.setTamaIndex(Math.abs(Tama.getInstance() - 1));

            currentTama = Driver.tamas.getTama();
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
