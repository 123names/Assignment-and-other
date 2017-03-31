import java.awt.FlowLayout;

import javax.swing.*;
public class GridLayout12_3 {

	public static void main(String []args){
		
		Exercise12_3 frame = new Exercise12_3();
		frame.setLayout(new FlowLayout(FlowLayout.LEFT));
		frame.setTitle("Exercise12_3");
		frame.setSize(560,155);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
}