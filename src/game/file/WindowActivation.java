package game.file;

import game.Constants;
import game.Driver;
import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WindowActivation implements WindowListener {

    public WindowActivation(JFrame show) {
        show.addWindowListener(this);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    //hey so I'ms leave this here o/ bob says hi

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            FileOutputStream file = new FileOutputStream(Constants.Files.SAVED_DATA);
            ObjectOutputStream output = new ObjectOutputStream(file);
            output.writeObject(Driver.tamas);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
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