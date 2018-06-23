package game;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Tama {
	public static void showPet() {
		JFrame show = new JFrame("Tamagachi");
		JPanel panel = new JPanel();
		panel.setLayout(null);
		ImageIcon img = new ImageIcon("C:/Users/Allison/OneDrive/programming/Tomogachi/egg icon.png");
		createSettings(show);
		
		show.setPreferredSize(new Dimension(216, 289));
		show.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		show.setIconImage(img.getImage());
		show.pack();
		
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
		JLabel pet = new JLabel(new ImageIcon("C:/Users/Allison/OneDrive/programming/Tomogachi/egg.gif")); 
		pet.setBounds((show.getWidth()/2)-15, 170, 22, 27);
		show.add(pet);
	}
	public static void createSettings(JFrame show) {
		JLabel health = new JLabel(new ImageIcon("C:/Users/Allison/OneDrive/programming/Tomogachi/health.png")); 
		show.add(health);
		health.setBounds(65, 35, 107, 7);
		
		JLabel border = new JLabel(new ImageIcon("C:/Users/Allison/OneDrive/programming/Tomogachi/border.png"));
		show.add(border);
		border.setBounds((show.getWidth()/2), show.getHeight()/2, 205, 255);
	}
	public static void createFeedButton(JFrame show) {
		JButton feed = new JButton(new ImageIcon("C:/Users/Allison/OneDrive/programming/Tomogachi/feed button.png")); 
		show.add(feed);
		feed.setBounds(23, 227, 40, 15);
		feed.setVisible(true);
	}
	public static void createCleanButton(JFrame show) {
		JButton clean = new JButton(new ImageIcon("C:/Users/Allison/OneDrive/programming/Tomogachi/clean.png")); 
		show.add(clean);
		clean.setBounds(81, 227, 40, 15);
		clean.setVisible(true);
	}
	public static void createResetButton(JFrame show) {
		JButton reset =new JButton(new ImageIcon("C:/Users/Allison/OneDrive/programming/Tomogachi/reset.png")); 
		show.add(reset);
		reset.setBounds(136, 227, 40, 15);
		reset.setVisible(true);
	}
	
	public static void main(String[] args) {	
		showPet();
	}
}