package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TamaSwitcher implements ActionListener {
    public TamaSwitcher(JMenuItem... Jmen) {
        for (JMenuItem J : Jmen) {
            J.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!e.getActionCommand().equalsIgnoreCase(Driver.tamas.getTama().getName())) {
            Tama currentTama = Driver.tamas.getTama();
            currentTama.removePoop();

            Driver.tamas.setTamaIndex(e.getActionCommand());

            currentTama = Driver.tamas.getTama();

            currentTama.setTamaPicture();
            Driver.changeTamaLabel(currentTama.getTom());

            currentTama.addPoop();
        }
    }
}
