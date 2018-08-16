package game;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;

<<<<<<< HEAD
public class Tama {
	private int food = 0;
	private JLabel tom;
	private int health = 6;
	private int petState = 0;

	public Tama() {
	    showPet(this);
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public JLabel getTom() {
        return tom;
    }

    public void setTom(JLabel tom) {
        this.tom = tom;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPetState() {
        return petState;
    }

    public void setPetState(int petState) {
        this.petState = petState;
    }

    public static void grow(JLabel pet, int food) {
		pet = new JLabel(new ImageIcon(Tama.class.getResource("Images/Lizard1.png")));
	}
	
	public static void showPet(Tama tama) {
		JFrame show = new JFrame("Tamagachi");
=======
public class Tama{
	static int food = 0;
	static JLabel tom;
	static int health = 6;
	static int petState = 0;
	static JFrame show = new JFrame("Tamagachi");
	
	public static void grow(JLabel pet, int food) {
		show.remove(pet);
		JLabel lizard = new JLabel(new ImageIcon(Tama.class.getResource("Images/Lizard1.gif")));
		lizard.setBounds((show.getWidth()/2)-29, 150, 58, 49);
		petState ++;
		show.add(lizard);
		reDrawWindow(show);
	}
	
	public static void showPet() {
>>>>>>> b378229fbad5cd74bf1d8480f3293238c55ed6c2

		show.setLayout(null);
		ImageIcon img = new ImageIcon(Tama.class.getResource("Images/Egg.png"));

		createSettings(show);
		
		show.setPreferredSize(new Dimension(206, 279));
		show.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		show.setIconImage(img.getImage());
		show.pack();
		show.setResizable(false);

		tama.setTom(createPets(show));
		
		createFeedButton(show);
		createCleanButton(show);
		createResetButton(show);
    
		JLabel empty = new JLabel("");
		show.add(empty);
		show.setVisible(true);

	}
	
	private static JLabel createPets(JFrame show) {
		JLabel pet = new JLabel(new ImageIcon(Tama.class.getResource("Images/EggMoving.gif"))); 
		pet.setBounds((show.getWidth()/2)-12, 170, 22, 27);
		show.add(pet);
		
		return pet;
	}
	private static void createSettings(JFrame show) {
		show.setContentPane(new JLabel(new ImageIcon(Tama.class.getResource("Images/Border.png"))));
		
		JLabel health = new JLabel(new ImageIcon(Tama.class.getResource("Images/HealthBar.png"))); 
		health.setBounds(65, 35, 107, 7);
		show.add(health);
	}
	private  static void createFeedButton(JFrame show) {
		JButton feed = new JButton(new ImageIcon(Tama.class.getResource("Images/FeedButton.png"))); 
		feed.setBounds(23, 227, 40, 15);
		show.add(feed);
		
		FeedButton feedButton = new FeedButton(feed);
	}
	private static void createCleanButton(JFrame show) {
		JButton clean = new JButton(new ImageIcon(Tama.class.getResource("Images/CleanButton.png"))); 
		clean.setBounds(81, 227, 40, 15);
		show.add(clean);
		
		CleanButton cleanButton = new CleanButton(clean);
	}
	private  static void createResetButton(JFrame show) {
		JButton reset = new JButton(new ImageIcon(Tama.class.getResource("Images/ResetButton.png"))); 
		reset.setBounds(136, 227, 40, 15);
		show.add(reset);
		
		ResetButton resetButton = new ResetButton(reset);
	}
	private static void reDrawWindow(JFrame show) {
		show.revalidate(); 
		show.repaint(); 
	}
}