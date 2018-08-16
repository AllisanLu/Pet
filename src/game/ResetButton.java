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
<<<<<<< HEAD
		System.out.println("THE RESET HAS BEEN PRESSED UR BABY HAS BEEN REVIVED DONT FUK UP AGAIN");
=======
		System.out.println("THE RESET HAS BEEN PRESSED");
>>>>>>> f7434db5611964fa1e093242947f2f831886ad98
	}
}

class FeedButton implements ActionListener{
	
	public FeedButton(JButton food) {
		food.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("BABY HAS BEEN FED");


		Driver.getTama().incrementFood(1);
		if(Driver.getTama().getFood() == 10) {
<<<<<<< HEAD
			Driver.getTama().grow();
			System.out.println("BABY HAS GROWN UP!");
		}


		Driver.getTama().incrementFood(1);
		if(Driver.getTama().getFood() == 10) {
=======
>>>>>>> f7434db5611964fa1e093242947f2f831886ad98
            Driver.getTama().grow();
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