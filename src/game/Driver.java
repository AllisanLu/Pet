package game;

import game.file.GameLoader;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.util.Calendar;

public class Driver {
    private static JFrame show = new JFrame("Tamagachi");
    public static final int SHOW_WIDTH = 206;
    public static final int SHOW_HEIGHT = 279;
    private static JLabel currentTamaPic = new JLabel("");
    public static Tamas tamas;

    public static void main(String[] args) {

        GameLoader.makeFile();
        tamas = new Tamas(GameLoader.readFile(), 0);

        startingShow();
        updateClock();
        tamas.getTama().setTamaPicture();
        changeTamaLabel(tamas.getTama().getTom());
        System.out.println(tamas);
    }

    public static void startingShow() {

        //Settings of the JFrame show
        show.setLayout(null);
        show.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        show.setPreferredSize(new Dimension(SHOW_WIDTH, SHOW_HEIGHT));
        show.setResizable(false);
        show.pack();

        //Icon that displays on Windows Bar
        show.setIconImage(new ImageIcon(Tama.class.getResource("Images/Egg.png")).getImage());

        //Background of the Application Tama
        show.setContentPane(new JLabel(new ImageIcon(Tama.class.getResource("Images/Border.png"))));

        //This sets a static healthBar with no way to modify it in the future.
        ImageIcon healthIcon = new ImageIcon(Tama.class.getResource("Images/HealthBar.png"));
        JLabel health = new JLabel(healthIcon);
        health.setBounds(65, 35, healthIcon.getIconWidth(), healthIcon.getIconHeight());
        show.add(health);

        show.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                String[] labels = {"food: ", " health: ", " petState: ", " poop: ", " EXP: "};

                try {
                    FileWriter pen = new FileWriter(GameLoader.getFile());
                    for (int i = 0; i < Driver.tamas.getTotalTamas(); i++) {
                        Driver.tamas.setTamaIndex(i);
                        Tama currentTama = Driver.tamas.getTama();
                        pen.write(currentTama.getName() + " " );
                        int[] values = {currentTama.getFood(), currentTama.getHealth(), currentTama.getPetState(), currentTama.getPoop(), currentTama.getExp()};

                        for (int k = 0; k < values.length; k++) {
                            pen.write(labels[k] + values[k]);
                        }
                        pen.write(" " + System.getProperty("line.separator"));
                    }
                    pen.close();
                } catch (Exception IOException) {
                    System.out.println("file Writer messed up. \n Could not save game.");
                }
            }
        });

        createButtons();

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
        new TamaSwitcher(terryMenu, jerryMenu);

        show.add(panel);
        show.setVisible(true);
    }

    /**
     * Creates buttons and sets their actions with the Method addActionListener.
     * Adds the buttons to JFrame show after they are fully ready
     */
    private static void createButtons() {
        ImageIcon feedIcon = new ImageIcon(Tama.class.getResource("Images/FeedButton.png"));
        JButton feed = new JButton(feedIcon);

        feed.addActionListener(event -> {   //Same as calling above but shorter
            double currentTime = System.currentTimeMillis();
            Tama currentTama = tamas.getTama();

            if(currentTama.getLastTimeFed() + 300000 > currentTime) {
                currentTama.addPoop();
                currentTama.setLastTimeFed(currentTime);
                currentTama.setExp(currentTama.getExp() + currentTama.getExpPerFood());
                currentTama.setFood(currentTama.getFood() + 1);
                if (currentTama.getExp() >= 100) {
                    currentTama.grow();
                }
            }
            else {
                System.out.println("Time till hungry: " + (currentTama.getLastTimeFed() - (300000 + currentTime)));
            }
        });

        feed.setBounds(23, 227, feedIcon.getIconWidth(), feedIcon.getIconHeight());
        show.add(feed);

        ImageIcon cleanIcon = new ImageIcon(Tama.class.getResource("Images/CleanButton.png"));
        JButton clean = new JButton(cleanIcon);
        clean.addActionListener(event -> {
            Tama currentTama = tamas.getTama();
            currentTama.removePoop();
            System.out.println("ALL THE POOP IS GONE" + "\n" + "poop: " + currentTama.getPoop());
        });
        clean.setBounds(81, 227, cleanIcon.getIconWidth(), cleanIcon.getIconHeight());
        show.add(clean);

        ImageIcon resetIcon = new ImageIcon(Tama.class.getResource("Images/ResetButton.png"));
        JButton reset = new JButton(resetIcon);
        reset.addActionListener(event -> {
            Tama currentTama = tamas.getTama();
            currentTama.reset();
            changeTamaLabel(currentTama.getTom());
            currentTama.removePoop();
        });
        reset.setBounds(136, 227, resetIcon.getIconWidth(), resetIcon.getIconHeight());
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
    private static void updateClock() {
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

    public static void addPoop(JLabel poop){
        show.add(poop);
        reDrawWindow();
    }

    public static void removePoop(JLabel poop){
        show.remove(poop);
        reDrawWindow();
    }

}