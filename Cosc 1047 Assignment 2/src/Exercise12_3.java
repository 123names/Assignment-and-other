import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class Exercise12_3 extends JFrame{
	
	public Exercise12_3(){
		
		JPanel p1 = new JPanel(new FlowLayout());

		p1.add(new JButton("Button 1"));
		p1.add(new JButton("Button 2"));
		p1.add(new JButton("Button 3"));
		
		JPanel p2 = new JPanel(new FlowLayout());
		p2.add(new JButton("Button 4"));
		p2.add(new JButton("Button 5"));
		p2.add(new JButton("Button 6"));
		
		JPanel p3 = new JPanel(new GridLayout(2,3));
		p3.add(new JButton("Button 7"));
		p3.add(new JButton("Button 8"));
		p3.add(new JButton("Button 9"));
		p3.add(new JButton("Button 10"));
		p3.add(new JButton("Button 11"));
		p3.add(new JButton("Button 12"));
		
		
		add(p1);
		add(p2);
		add(p3);
	}

}
