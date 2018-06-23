package game;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Tama {
	
	public static void showPet() {
		JFrame show = new JFrame("Tamagachi");
		show.setLayout(null);
		ImageIcon img = new ImageIcon(Tama.class.getResource("Images/Egg.png"));
		createSettings(show);
		
		System.out.println(img.getIconWidth() + " " + img.getIconHeight());
		
		show.setPreferredSize(new Dimension(216, 289));
		show.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		show.setIconImage(img.getImage());
		show.pack();
		show.setResizable(false);
		createPets(show);
		createFeedButton(show); 
		createCleanButton(show); 
		createResetButton(show); 
		//Buttons here = new Buttons(show);
		//here.setSize(100, 100);
		//here.setVisible(true);
		
		JLabel empty = new JLabel("");
		show.add(empty);
		show.setVisible(true);
		
		
	}
	
	public static void createPets(JFrame show) {
		JLabel pet = new JLabel(new ImageIcon(Tama.class.getResource("Images/EggMoving.gif"))); 
		pet.setBounds((show.getWidth()/2)-15, 170, 22, 27);
		show.add(pet);
	}
	public static void createSettings(JFrame show) {
		JLabel health = new JLabel(new ImageIcon(Tama.class.getResource("Images/HealthBar.png"))); 
		health.setBounds(65, 35, 107, 7);
		show.add(health);
		
		JLabel border = new JLabel(new ImageIcon(Tama.class.getResource("Images/Border.png")));
		border.setBounds((show.getWidth()/2), show.getHeight()/2, 205, 255);
		show.add(border);
	}
	public static void createFeedButton(JFrame show) {
		JButton feed = new JButton(new ImageIcon(Tama.class.getResource("Images/FeedButton.png"))); 
		feed.setBounds(23, 227, 40, 15);
		show.add(feed);
	}
	public static void createCleanButton(JFrame show) {
		JButton clean = new JButton(new ImageIcon(Tama.class.getResource("Images/CleanButton.png"))); 
		clean.setBounds(81, 227, 40, 15);
		show.add(clean);
	}
	public static void createResetButton(JFrame show) {
		JButton reset = new JButton(new ImageIcon(Tama.class.getResource("Images/ResetButton.png"))); 
		reset.setBounds(136, 227, 40, 15);
		show.add(reset);
	}
	public static void reDrawWindow(JFrame show) {
		show.revalidate(); 
		show.repaint(); 
	}
	
	public static void main(String[] args) {	
		showPet();
	}
}