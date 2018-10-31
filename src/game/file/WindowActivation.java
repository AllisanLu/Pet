package game.file;

import game.Driver;
import game.Tama;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import static game.Driver.tamas;

public class WindowActivation implements WindowListener {

    @Override
    public void windowOpened(WindowEvent e) {
        Tama currentTama = Driver.tamas.getTama();
        currentTama.setTamaPicture();
        Driver.changeTamaLabel(currentTama.getTom());
    }

    @Override
    public void windowClosing(WindowEvent e) {
        new GameSaver();
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