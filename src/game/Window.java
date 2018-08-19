package game;

<<<<<<< HEAD
import game.File.*;
import game.buttons.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.JLabel;

public class Window extends JLabel {

    private static JFrame show = new JFrame("Tamagachi");;

    public static JFrame getShow() {
        return show;
    }

    public static void setTamaPicture(Tama jerry) {
        switch(jerry.getPetState()) {
            default:
                System.out.println("Value in Windows setTamaPicture was not correct.");
                break;
=======
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

public class Window extends JLabel implements WindowListener{

    public static void growTama(int petState, Tama jerry) {
        switch(petState){
>>>>>>> 451def0219ad3435139753a1d13dd681a7509f03
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
        show.setLayout(null);
        ImageIcon img = new ImageIcon(Tama.class.getResource("Images/Egg.png"));

        createSettings();

        show.setPreferredSize(new Dimension(206, 279));
        show.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        show.setIconImage(img.getImage());
        show.pack();
        show.setResizable(false);

        jerry.setTom(createPets());

        createFeedButton();
        createCleanButton();
        createResetButton();

        JLabel empty = new JLabel("");
        show.add(empty);
        show.setVisible(true);
<<<<<<< HEAD
=======

        Window win = new Window(show);
>>>>>>> 451def0219ad3435139753a1d13dd681a7509f03
    }

    private static JLabel createPets() {
        JLabel pet = new JLabel(new ImageIcon(Tama.class.getResource("Images/EggMoving.gif")));
        pet.setBounds((show.getWidth()/2)-12, 170, 22, 27);
        show.add(pet);

        return pet;
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

<<<<<<< HEAD

=======
    public Window(JFrame show) {
        show.addWindowListener(this);
    }

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

>>>>>>> 451def0219ad3435139753a1d13dd681a7509f03
}
