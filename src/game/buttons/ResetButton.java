package game.buttons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetButton implements ActionListener {

    public ResetButton(JButton dead){
        dead.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent arg0) {
        System.out.println("THE RESET HAS BEEN PRESSED UR BABY HAS BEEN REVIVED DONT FUK UP AGAIN");
    }
}

