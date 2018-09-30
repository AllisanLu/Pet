package game.file;

import game.Driver;
import game.Tama;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowActivation implements WindowListener {

    public WindowActivation() {
        System.out.println("Windows Activated");
        Driver.getShow().addWindowListener(this);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        Tama currentTama = Driver.getTama();

        GameLoader.makeFile();
        GameLoader.readFile();

        /* System.out.println(Driver.getTama()); */

       // System.out.println(Tama.getInstance());
        Driver.addTama(currentTama.setTamaPicture());
        //System.out.println("poop is " + Driver.getTama().getPoop());
        int poop = currentTama.getPoop();
        currentTama.setPoop(0);
        for(int i = 0; i < poop; i++){
            //System.out.println("poop at begining: " + Driver.getTama().getPoop());
            currentTama.addPoop();
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