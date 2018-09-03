package game.buttons;

import game.Driver;
import game.Tama;
<<<<<<< HEAD
=======
import game.Window;
>>>>>>> b8a76296efdc213e470713049458187a82ef1b8a

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
<<<<<<< HEAD
=======
        Window.removePoop();
>>>>>>> b8a76296efdc213e470713049458187a82ef1b8a
        System.out.println("THE RESET HAS BEEN PRESSED UR BABY HAS BEEN REVIVED DONT FUK UP AGAIN");
    }
}

