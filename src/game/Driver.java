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

        Tama.setTamaPicture(currentTama);

        createButtons(Tamas[0]);
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

    private static void createButtons(Tama currentTama) {
        ImageIcon feedIcon = new ImageIcon(Tama.class.getResource("Images/FeedButton.png"));
        JButton feed = new JButton(feedIcon);
        feed.addActionListener(event -> {
            double currentTime = System.currentTimeMillis();
            //System.out.println("For feeding: " + Driver.getTama().getFood() + " " + Tama.getInstance());
            //If Tama has been fed in the last 5 minutes prints I'm to full
            Tama.addPoop();
//        if(currentTime - currentTama.getLastTimeFed() < 30000) {
//            System.out.println("I'm to full");
//        }
//        else {
            currentTama.setLastTimeFed(System.currentTimeMillis());
            currentTama.setExp(currentTama.getExp() + currentTama.getExpPerFood()); //!! removed [level counter from getExpPerFood "array" ?
            currentTama.setFood(currentTama.getFood() + 1);
            if(currentTama.getExp() >= 100) {
                //levelCounter++;
                if(currentTama.getPetState() < 1) {
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
            Tama.removePoop();
            System.out.println("ALL THE POOP IS GONE" + "\n" + "poop: " + Driver.getTama().getPoop());
        });
        clean.setBounds(81, 227, cleanIcon.getIconWidth(), cleanIcon.getIconHeight());
        show.add(clean);

        ImageIcon resetIcon = new ImageIcon(Tama.class.getResource("Images/ResetButton.png"));
        JButton reset = new JButton(resetIcon);
        reset.addActionListener(event -> {
            currentTama.reset();

            Tama.removePoop();
            System.out.println("DERP, pet has been reset! \n" +
                    "food: " + Driver.getTama().getFood() + "\n" +
                    "pet state: " + Driver.getTama().getPetState() + "\n" +
                    "poop: " + Driver.getTama().getPoop() + "\n" +
                    "Health: " + Driver.getTama().getHealth());
        });
        reset.setBounds(136, 227, resetIcon.getIconWidth(), resetIcon.getIconHeight());
        show.add(reset);
    }

    private static void createSettings() {
        show.setContentPane(new JLabel(new ImageIcon(Tama.class.getResource("Images/Border.png"))));

        JLabel health = new JLabel(new ImageIcon(Tama.class.getResource("Images/HealthBar.png")));
        health.setBounds(65, 35, 107, 7);
        show.add(health);
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
