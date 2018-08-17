package game;

import game.File.GameSaver;
import game.buttons.FeedButton;
import game.buttons.CleanButton;
import game.buttons.ResetButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JLabel;

public class Window extends JLabel {

    public static void setTamaPicture(Tama jerry) {
        switch(jerry.getPetState()){
            case 0: JLabel egg = new JLabel(new ImageIcon(Window.class.getResource("Images/Egg.png")));
                    egg.setBounds(100,100,100,100);
                    jerry.setTom(egg);
                break;
            case 1: JLabel lizard = new JLabel(new ImageIcon(Window.class.getResource("Images/lizard1.gif")));
                    lizard.setBounds(100,100,100,100);
                    jerry.setTom(lizard);
                break;
        }
    }

    public static void showPet(Tama jerry) {
        JFrame show = new JFrame("Tamagachi");
        show.setLayout(null);
        ImageIcon img = new ImageIcon(Tama.class.getResource("Images/Egg.png"));

        createSettings(show);

        show.setPreferredSize(new Dimension(206, 279));
        show.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        show.setIconImage(img.getImage());
        show.pack();
        show.setResizable(false);

        jerry.setTom(createPets(show));

        createFeedButton(show);
        createCleanButton(show);
        createResetButton(show);

        JLabel empty = new JLabel("");
        show.add(empty);
        show.setVisible(true);
        show.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("Loading!");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                new GameSaver(Driver.getTama());
                System.out.println("Saved!");
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
        });
    }

    private static JLabel createPets(JFrame show) {
        JLabel pet = new JLabel(new ImageIcon(Tama.class.getResource("Images/EggMoving.gif")));
        pet.setBounds((show.getWidth()/2)-12, 170, 22, 27);
        show.add(pet);

        return pet;
    }
    private static void createSettings(JFrame show) {
        show.setContentPane(new JLabel(new ImageIcon(Tama.class.getResource("Images/Border.png"))));

        JLabel health = new JLabel(new ImageIcon(Tama.class.getResource("Images/HealthBar.png")));
        health.setBounds(65, 35, 107, 7);
        show.add(health);
    }
    private  static void createFeedButton(JFrame show) {
        JButton feed = new JButton(new ImageIcon(Tama.class.getResource("Images/FeedButton.png")));
        feed.setBounds(23, 227, 40, 15);
        show.add(feed);

        FeedButton feedButton = new FeedButton(feed);
    }
    private static void createCleanButton(JFrame show) {
        JButton clean = new JButton(new ImageIcon(Tama.class.getResource("Images/CleanButton.png")));
        clean.setBounds(81, 227, 40, 15);
        show.add(clean);

        CleanButton cleanButton = new CleanButton(clean);
    }
    private  static void createResetButton(JFrame show) {
        JButton reset = new JButton(new ImageIcon(Tama.class.getResource("Images/ResetButton.png")));
        reset.setBounds(136, 227, 40, 15);
        show.add(reset);

        ResetButton resetButton = new ResetButton(reset);
    }
    private static void reDrawWindow(JFrame show) {
        show.revalidate();
        show.repaint();
    }
}
