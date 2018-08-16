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

	private int[] levelUp = { 10, 20, 30, 40, };
	private int levelCounter = 0;

	public FeedButton(JButton food) {
		food.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("BABY HAS BEEN FED");

		Driver.getTama().incrementFood(1);
		if(Driver.getTama().getFood() >= levelUp[levelCounter]) {
			levelCounter++;
			Driver.getTama().grow();
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