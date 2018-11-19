package game;

import game.file.WindowActivation;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Calendar;

public class Driver {
    private static JFrame show = new JFrame("Tamagachi");
    private static JLabel currentTamaPic = new JLabel("");
    public static Tamas tamas;

    public static void main(String[] args) throws IOException {

        if (Constants.Files.SAVED_DATA.createNewFile())           //Returns true if File doesn't exist false otherwise.
            tamas = new Tamas();
        else {
            FileInputStream file = new FileInputStream(Constants.Files.SAVED_DATA);
            ObjectInputStream reader = new ObjectInputStream(file);
            try {
                tamas = (Tamas) reader.readObject();
                tamas.updateTamaPics();
            } catch (ClassNotFoundException e) {            //Creates new Tamas if there is an error reading.
                e.printStackTrace();
                tamas = new Tamas();
            }
        }

        startingShow();
        changeTamaLabel(tamas.getTama().getTamaPic());
        startClock();
    }

    public static void startingShow() {

        //Settings of the JFrame show
        show.setLayout(null);
        show.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        show.setPreferredSize(new Dimension(Constants.GUIDimensions.GUI_WIDTH, Constants.GUIDimensions.GUI_HEIGHT));
        show.setResizable(false);
        show.pack();

        //Icon that displays on Windows Bar
        show.setIconImage(new ImageIcon(Constants.Paths.BACKGROUND + "Egg.png").getImage());

        //Background of the Application Tama
        show.setContentPane(new JLabel(new ImageIcon(Constants.Paths.BACKGROUND + "Border.png")));

        //This sets a static healthBar with no way to modify it in the future.
        ImageIcon healthIcon = new ImageIcon(Constants.Paths.BACKGROUND + "HealthBar.png");
        JLabel health = new JLabel(healthIcon);
        health.setBounds(Constants.ImageLocations.HEALTH_BAR_X, Constants.ImageLocations.HEALTH_BAR_Y, healthIcon.getIconWidth(), healthIcon.getIconHeight());
        show.add(health);

        createButtons();

        JPopupMenu pop = new JPopupMenu();

        JMenuItem switcher = new JMenuItem("Switch");
        JPanel panel = new JPanel();
        panel.setComponentPopupMenu(pop);
        panel.setSize(500, 500);
        panel.setOpaque(false);
        pop.add(switcher);

        new TamaSwitcher(switcher);


        show.add(panel);
        show.setVisible(true);

        show.addWindowListener(new WindowActivation(show));
    }

    /**
     * Creates buttons and sets their actions with the Method addActionListener.
     * Adds the buttons to JFrame show after they are fully ready
     */
    private static void createButtons() {
        ImageIcon feedIcon = new ImageIcon(Constants.Paths.BUTTONS + "FeedButton.png");
        JButton feed = new JButton(feedIcon);

        feed.addActionListener(event -> {   //lambada
            double currentTime = System.currentTimeMillis();
            Tama currentTama = tamas.getTama();

            currentTama.addPoop();
            currentTama.setLastTimeFed(currentTime);
            currentTama.setExp(currentTama.getExp() + currentTama.getExpPerFood());
            currentTama.setFood(currentTama.getFood() + 1);
            if (currentTama.getExp() >= 100) {
                currentTama.grow();
            }
        });

        feed.setBounds(Constants.ImageLocations.FEED_BUTTON_X, Constants.ImageLocations.BUTTON_HEIGHT, feedIcon.getIconWidth(), feedIcon.getIconHeight());
        show.add(feed);

        ImageIcon cleanIcon = new ImageIcon(Constants.Paths.BUTTONS + "CleanButton.png");
        JButton clean = new JButton(cleanIcon);
        clean.addActionListener(event -> {
            Tama currentTama = tamas.getTama();

            currentTama.removePoop();
            System.out.println("ALL THE POOP IS GONE" + "\n" + "poop: " + currentTama.getPoop());
        });
        clean.setBounds(Constants.ImageLocations.CLEAN_BUTTON_X, Constants.ImageLocations.BUTTON_HEIGHT, cleanIcon.getIconWidth(), cleanIcon.getIconHeight());
        show.add(clean);

        ImageIcon resetIcon = new ImageIcon(Constants.Paths.BUTTONS + "ResetButton.png");
        JButton reset = new JButton(resetIcon);
        reset.addActionListener(event -> {
            Tama currentTama = tamas.getTama();
            currentTama.reset();
            changeTamaLabel(currentTama.getTamaPic());
            currentTama.removePoop();
        });
        reset.setBounds(Constants.ImageLocations.RESET_BUTTON_X, Constants.ImageLocations.BUTTON_HEIGHT, resetIcon.getIconWidth(), resetIcon.getIconHeight());
        show.add(reset);
    }


    public static void reDrawWindow() {
        show.repaint();
    }

    /**
     * Starts a new Thread that updates the clock in the corner right of the screen.
     * Clock is run in standard 24-Hour Time.
     * Should only be called to once.
     */
    private static void startClock() {
        new Thread(() -> {
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
        }).start();
    }


    public static void changeTamaLabel(JLabel newTama) {
        show.remove(currentTamaPic);
        show.add(newTama);
        currentTamaPic = newTama;
        reDrawWindow();
    }

    public static void addPoop(JLabel poop) {
        show.add(poop);
        reDrawWindow();
    }

    public static void removePoop(ArrayList<JLabel> poops) {
        for (int i = 0; i < poops.size(); i++) {
            show.remove(poops.get(i));
        }
        reDrawWindow();
    }

}