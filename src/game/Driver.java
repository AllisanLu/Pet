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
    private static final int SHOW_WIDTH = 206;
    private static final int SHOW_HEIGHT = 279;

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

        startingShow(Tamas[0]);

        updateClock();
    }

    public static void startingShow(Tama currentTama) {

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
        currentTama.setTamaPicture();
        //show.add(currentTama.getTom());

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

        SwitchToJerry switchJ = new SwitchToJerry(jerryMenu);
        SwitchToTerry switchT = new SwitchToTerry(terryMenu);

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
/*        feed.addActionListener(new ActionListener() {
*             @Override
*             public void actionPerformed(ActionEvent e) {
*
*              }
*          });
*/
        feed.addActionListener(event -> {   //Same as calling above but shorter
            double currentTime = System.currentTimeMillis();
            Tama currentTama = Driver.getTama();

            currentTama.addPoop();

            currentTama.setLastTimeFed(System.currentTimeMillis());
            currentTama.setExp(currentTama.getExp() + currentTama.getExpPerFood()); //!! removed [level counter from getExpPerFood "array" ?
            currentTama.setFood(currentTama.getFood() + 1);
            if(currentTama.getExp() >= 100) {
                //levelCounter++;
                if(currentTama.getPetState() < 2) {
                    currentTama.grow();
                    System.out.println("Tama: " + currentTama.getName());
                    System.out.println("BABY HAS GROWN UP!");
                }
            }
        });
        feed.setBounds(23, 227, feedIcon.getIconWidth(), feedIcon.getIconHeight());
        show.add(feed);

        ImageIcon cleanIcon = new ImageIcon(Tama.class.getResource("Images/CleanButton.png"));
        JButton clean = new JButton(cleanIcon);
        clean.addActionListener(event -> {
            Tama currentTama = Driver.getTama();

            currentTama.removePoop();
            System.out.println("ALL THE POOP IS GONE" + "\n" + "poop: " + Driver.getTama().getPoop());
        });
        clean.setBounds(81, 227, cleanIcon.getIconWidth(), cleanIcon.getIconHeight());
        show.add(clean);

        ImageIcon resetIcon = new ImageIcon(Tama.class.getResource("Images/ResetButton.png"));
        JButton reset = new JButton(resetIcon);
        reset.addActionListener(event -> {
            Tama currentTama = Driver.getTama();

            show.remove(currentTama.getTom());
            currentTama.reset();
            show.add(currentTama.getTom());
            currentTama.removePoop();
            System.out.println("DERP: RESET INCOMING: \n" + currentTama);
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
        reDrawWindow();
    }

    public static void removeTama(JLabel tama){
        show.remove(tama);
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
