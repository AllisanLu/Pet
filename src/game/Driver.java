package game;
import game.buttons.*;
import game.file.GameLoader;
import game.file.WindowActivation;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import javax.swing.JLabel;

public class Driver extends JLabel {
    private static JFrame show = new JFrame("Tamagachi");

    private static Tama[] Tamas;

    public static void main(String[] args) {
        Tama jerry = new Tama("jerry", "jerry");
        Tama terry = new Tama("terry", "terry");
        Tama.setInstance(0);
        Tamas = new Tama[2];
        Tamas[0] = jerry;
        Tamas[1] = terry;
        WindowActivation test = new WindowActivation();
        try {
            GameLoader.makeFile();
        } catch (Exception IoException) {
            System.out.println("error in Game Loader");
        }

        showPet(Tamas[0]);

        updateClock();
    }

    public static void showPet(Tama currentTama) {
        show.setLayout(null);
        ImageIcon img = new ImageIcon(Tama.class.getResource("Images/Egg.png"));

        createSettings();

        show.setPreferredSize(new Dimension(206, 279));
        show.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        show.setIconImage(img.getImage());
        show.pack();
        show.setResizable(false);

        currentTama.setTamaPicture();

        createFeedButton();
        createCleanButton();
        createResetButton();
        JLabel empty = new JLabel("");
        show.add(empty);
        show.setVisible(true);

        JPopupMenu pop = new JPopupMenu();

        JMenuItem jerryMenu = new JMenuItem("Jerry");
        JMenuItem terryMenu = new JMenuItem("Terry");
        JPanel panel = new JPanel();
        panel.setComponentPopupMenu(pop);
        panel.setSize(500, 500);
        panel.setOpaque(false);
        pop.add(jerryMenu);
        pop.addSeparator();
        pop.add(terryMenu);

        SwitchToJerry switchJ = new SwitchToJerry(jerryMenu);
        SwitchToTerry switchT = new SwitchToTerry(terryMenu);

        show.add(panel);
        reDrawWindow();
    }

    private static void createSettings() {
        show.setContentPane(new JLabel(new ImageIcon(Tama.class.getResource("Images/Border.png"))));

        JLabel health = new JLabel(new ImageIcon(Tama.class.getResource("Images/HealthBar.png")));
        health.setBounds(65, 35, 107, 7);
        show.add(health);
    }

    private static void createFeedButton() {
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

    private static void createResetButton() {
        JButton reset = new JButton(new ImageIcon(Tama.class.getResource("Images/ResetButton.png")));
        reset.setBounds(136, 227, 40, 15);
        show.add(reset);

        ResetButton resetButton = new ResetButton(reset);
    }

    public static void reDrawWindow() {             //should this be public?
        show.repaint();
    }

    public static void updateClock() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Calendar cal;
                JLabel time = new JLabel();
                time.setBounds(125, 4, 50, 30);
                show.add(time);
                while (true) {
                    cal = Calendar.getInstance();
                    time.setText(cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        //        Calendar cal;
//        JLabel time = new JLabel();
//        time.setBounds(125, 4, 50, 30);
//        show.add(time);
//        while(true) {
//            try {
//                cal = Calendar.getInstance();
//                time.setText(cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND));
//                reDrawWindow();
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

    }

    public static JFrame getShow() {
        return show;
    }


    public static Tama getTama() {
        return Tamas[Tama.getInstance()];
    }

    public static Tama[] getTamas() {
        return Tamas;
    }

    public static void addTama(JLabel tama) {
        show.add(tama);
    }

    public static void removeTama(JLabel tama){
        show.remove(tama);
    }

    public static void addPoop(JLabel poop){
        show.add(poop);
    }

    public static void removePoop(JLabel poop){
        show.remove(poop);
    }

}
