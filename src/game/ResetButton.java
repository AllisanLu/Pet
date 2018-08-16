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
		Driver.getTama().incrementFood(1);
		if(Driver.getTama().getFood() == 10) {
			Driver.getTama().grow();
=======


		if(Tama.food == 10) {
			Tama.grow(Tama.tom,Tama.food);

		Tama.food++;
		if(Tama.food == 10) {
			Tama.grow(Tama.tom,Tama.food);
>>>>>>> 61f5dd8fc1b80678dbb1923b5aea446de0cdf941
			System.out.println("BABY HAS GROWN UP!");
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