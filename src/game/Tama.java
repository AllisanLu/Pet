package game;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Tama{
	static int food = 0;
	static JLabel tom;
	static int health = 6;
	static int petState = 0;
	
	public static void grow(JLabel pet, int food) {
		pet = new JLabel(new ImageIcon(Tama.class.getResource("Images/Lizard1.png")));
		petState ++;
	}
	
	public static void showPet() {
		JFrame show = new JFrame("Tamagachi");

		show.setLayout(null);
		ImageIcon img = new ImageIcon(Tama.class.getResource("Images/Egg.png"));

		createSettings(show);
		
		show.setPreferredSize(new Dimension(206, 279));
		show.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		show.setIconImage(img.getImage());
		show.pack();
		show.setResizable(false);

		tom = createPets(show);
		
		createFeedButton(show);
		createCleanButton(show);
		createResetButton(show);
    
		JLabel empty = new JLabel("");
		show.add(empty);
		show.setVisible(true);

	}
	
	public static JLabel createPets(JFrame show) {
		JLabel pet = new JLabel(new ImageIcon(Tama.class.getResource("Images/EggMoving.gif"))); 
		pet.setBounds((show.getWidth()/2)-12, 170, 22, 27);
		show.add(pet);
		
		return pet;
	}
	public static void createSettings(JFrame show) {
		show.setContentPane(new JLabel(new ImageIcon(Tama.class.getResource("Images/Border.png"))));
		
		JLabel health = new JLabel(new ImageIcon(Tama.class.getResource("Images/HealthBar.png"))); 
		health.setBounds(65, 35, 107, 7);
		show.add(health);
	}
	public static void createFeedButton(JFrame show) {
		JButton feed = new JButton(new ImageIcon(Tama.class.getResource("Images/FeedButton.png"))); 
		feed.setBounds(23, 227, 40, 15);
		show.add(feed);
		
		FeedButton feedButton = new FeedButton(feed);
	}
	public static void createCleanButton(JFrame show) {
		JButton clean = new JButton(new ImageIcon(Tama.class.getResource("Images/CleanButton.png"))); 
		clean.setBounds(81, 227, 40, 15);
		show.add(clean);
		
		CleanButton cleanButton = new CleanButton(clean);
	}
	public static void createResetButton(JFrame show) {
		JButton reset = new JButton(new ImageIcon(Tama.class.getResource("Images/ResetButton.png"))); 
		reset.setBounds(136, 227, 40, 15);
		show.add(reset);
		
		ResetButton resetButton = new ResetButton(reset);
	}
	public static void reDrawWindow(JFrame show) {
		show.revalidate(); 
		show.repaint(); 
	}
	
	public static void main(String[] args) {
		food = 0;
		showPet();
		if(food == 10) {
			grow(tom,food);
		}
	}
}