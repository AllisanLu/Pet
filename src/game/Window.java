package game;

import game.buttons.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.JLabel;

public class Window extends JLabel {

    private static JFrame show = new JFrame("Tamagachi");

    public static JFrame getShow() {
        return show;
    }

    public static void setTamaPicture(Tama jerry) {
        System.out.println(jerry.getPetState());
        switch(jerry.getPetState()) {
            default:
                System.out.println("Value in Windows setTamaPicture was not correct.");
                break;
            case 0: JLabel egg = new JLabel(new ImageIcon(Window.class.getResource("Images/EggMoving.gif")));
                    egg.setBounds((show.getWidth()/2)-12, 170, 22, 27);
                    jerry.setTom(egg);

                    show.add(jerry.getTom());

                    reDrawWindow(show);
                    System.out.println("EGG!");
                break;
            case 1: show.remove(jerry.getTom());

                    JLabel lizard = new JLabel(new ImageIcon(Window.class.getResource("Images/lizard1.gif")));
                    lizard.setBounds((show.getWidth()/2)-50, 130, 100, 100);
                    jerry.setTom(lizard);

                    show.add(jerry.getTom());

                    reDrawWindow(show);
                    System.out.println("LIZARD");
                break;
        }
    }

    public static void showPet(Tama jerry) {
        show.setLayout(null);
        ImageIcon img = new ImageIcon(Tama.class.getResource("Images/Egg.png"));

        createSettings();

        show.setPreferredSize(new Dimension(206, 279));
        show.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        show.setIconImage(img.getImage());
        show.pack();
        show.setResizable(false);

        setTamaPicture(jerry);
        //jerry.setTom(createPets());

        createFeedButton();
        createCleanButton();
        createResetButton();

        JLabel empty = new JLabel("");
        show.add(empty);
        show.setVisible(true);

        Window win = new Window();
    }

    private static void createSettings() {
        show.setContentPane(new JLabel(new ImageIcon(Tama.class.getResource("Images/Border.png"))));

        JLabel health = new JLabel(new ImageIcon(Tama.class.getResource("Images/HealthBar.png")));
        health.setBounds(65, 35, 107, 7);
        show.add(health);
    }
    private  static void createFeedButton() {
        JButton feed = new JButton(new ImageIcon(Tama.class.getResource("Images/FeedButton.png")));
        feed.setBounds(23, 227, 40, 15);
        show.add(feed);

        FeedButton feedButton = new FeedButton(feed);
    }
    private static void createCleanButton() {
        JButton clean = new JButton(new ImageIcon(Tama.class.getResource("Images/CleanButton.png")));
        clean.setBounds(81, 227, 40, 15);
        show.add(clean);

        CleanButton cleanButton = new CleanButton(clean);
    }
    private  static void createResetButton() {
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
