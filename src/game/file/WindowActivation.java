package game.file;

import game.Driver;
import game.Tama;
import game.Window;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowActivation implements WindowListener {

    public WindowActivation() {
        System.out.println("Windows Activated");
        Window.getShow().addWindowListener(this);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        GameLoader.makeFile();
        GameLoader.readFile();

        /* System.out.println(Driver.getTama()); */

       // System.out.println(Tama.getInstance());
        Window.setTamaPicture(Driver.getTama());
        //System.out.println("poop is " + Driver.getTama().getPoop());
        for(int i = 0; i < Driver.getTama().getPoop(); i++){
            System.out.println(Driver.getTama().getPoop());
            Window.addPoop();
            //TODO: add correct amount of poop, why does it only add one right now? btw the Driver.get poop() thing works
        }

        //System.out.println("hi");
    }
    //hey so I'ms leave this here o/ bob says hi

    @Override
    public void windowClosing(WindowEvent e) {
        new GameSaver(Driver.getTamas());
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}