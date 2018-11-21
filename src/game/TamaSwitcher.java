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

        Tama currentTama = Driver.tamas.getTama();

        currentTama.removePoop();

        Driver.tamas.setTamaIndex(Math.abs(Driver.tamas.getTamaIndex() - 1));

        currentTama = Driver.tamas.getTama();

        currentTama.setTamaPic();
        Driver.changeTamaLabel(currentTama.getTamaPic());

    }
}
