package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ResetButton implements ActionListener{
	
	public ResetButton(JButton dead){
		dead.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("THE RESET HAS BEEN PRESSED UR BABY HAS BEEN REVIVED DONT FUK UP AGAIN");
		
		
	}
}

class FeedButton implements ActionListener{
	
	public FeedButton(JButton food) {
		food.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("BABY HAS BEEN FED");

<<<<<<< HEAD

		if(Tama.food == 10) {
			Tama.grow(Tama.tom,Tama.food);
=======
		Tama.food++;
		if(Tama.food == 10) {
			Tama.grow(Tama.tom,Tama.food);
			System.out.println("BABY HAS GROWN UP!");
>>>>>>> b378229fbad5cd74bf1d8480f3293238c55ed6c2
		}
		
	}
	
}

class CleanButton implements ActionListener{

	public CleanButton(JButton poop) {
		poop.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ALL THE POOP IS GONE");
		
	}
	
}