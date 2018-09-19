package game;

import game.buttons.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.JLabel;
import java.util.ArrayList;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

public class Window extends JLabel {

    private static JFrame show = new JFrame("Tamagachi");

    //private static JLabel[] poops = new JLabel[10];
    private static ArrayList<JLabel> poops = new ArrayList<JLabel>();
    private static int poopCounter;
    public static JFrame getShow() {
        return show;
    }

    public static void setTamaPicture(Tama currentTama) {
        try{
            show.remove(currentTama.getTom());
        }catch (Exception NullPointerException ){
            System.out.println("no tama yet!");
        }
        switch(currentTama.getPetState()) {
            default:
                System.out.println("Value in Windows setTamaPicture was not correct.");
                break;
            case 0:
                JLabel egg = new JLabel(new ImageIcon(Window.class.getResource("Images/" + currentTama.getFolderName() + "/First.gif")));
                egg.setBounds((show.getWidth() / 2) - 12, 170, 22, 27);
                currentTama.setTom(egg);

                show.add(currentTama.getTom());

                //System.out.println("EGG!");
                break;
            case 1:
                show.remove(currentTama.getTom()); // this isnt working

                JLabel lizard = new JLabel(new ImageIcon(Window.class.getResource("Images/" + currentTama.getFolderName() + "/Second.gif")));
                lizard.setBounds((show.getWidth() / 2) - 50, 130, 100, 100);
                currentTama.setTom(lizard);

                show.add(currentTama.getTom());

                //System.out.println("LIZARD");
                break;
        }
        reDrawWindow();
    }

    public static void showPet(Tama currentTama) {
        poopCounter = 0;
        show.setLayout(null);
        ImageIcon img = new ImageIcon(Tama.class.getResource("Images/Egg.png"));

        createSettings();

        show.setPreferredSize(new Dimension(206, 279));
        show.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        show.setIconImage(img.getImage());
        show.pack();
        show.setResizable(false);

        setTamaPicture(currentTama);

        createFeedButton();
        createCleanButton();
        createResetButton();
        JLabel empty = new JLabel("");
        show.add(empty);
        show.setVisible(true);

        JPopupMenu pop = new JPopupMenu();
        pop.addPopupMenuListener(new TamaSwitcher());

        JMenuItem jerry = new JMenuItem("Jerry");
        JMenuItem terry = new JMenuItem("Terry");
        JPanel panel = new JPanel();
        panel.setComponentPopupMenu(pop);
        panel.setSize(500,500);
        panel.setOpaque(false);
        pop.add(jerry);
        pop.addSeparator();
        pop.add(terry);
        show.add(panel);
        reDrawWindow();
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

    public static void addPoop() {
        Tama currentTama = Driver.getTama();
        if(poopCounter >= 10) {
            System.out.println("Pet Died");
        }
        else {
            JLabel poop = new JLabel(new ImageIcon(Window.class.getResource("Images/poo.png")));
            poop.setBounds(50, 50, 100 + (int) (Math.random() * 80), 230 + (int) (Math.random() * 80));
            poops.add(poop);
            poopCounter++;
            currentTama.setPoop(poopCounter);
            show.add(poop);
            reDrawWindow();
        }
    }

    public static void removePoop() {
        Tama currentTama = Driver.getTama();
        if(!(poopCounter == 0)){
            for (int i = 0; i < poops.size(); i++) {
                show.remove(poops.get(i));
                reDrawWindow();
            }
            poopCounter = 0;
            currentTama.setPoop(poopCounter); // so like here it doesnt set it back to zero :o
        }
    }


    private static void reDrawWindow() {
        show.repaint();
    }
}
