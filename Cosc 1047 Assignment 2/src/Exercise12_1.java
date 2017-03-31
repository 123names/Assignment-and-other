import java.awt.FlowLayout;

import javax.swing.*;

public class Exercise12_1 extends JFrame{
	
	public Exercise12_1(){
		
		JPanel p1 = new JPanel(new FlowLayout());

		p1.add(new JButton("Button 1"));
		p1.add(new JButton("Button 2"));
		p1.add(new JButton("Button 3"));
		
		JPanel p2 = new JPanel(new FlowLayout());
		p2.add(new JButton("Button 4"));
		p2.add(new JButton("Button 5"));
		p2.add(new JButton("Button 6"));
		
		add(p1);
		add(p2);
	}

}
