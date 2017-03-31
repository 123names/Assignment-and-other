import java.awt.FlowLayout;

import javax.swing.*;
public class FlowLayout12_1 {

	public static void main(String []args){
		
		Exercise12_1 frame = new Exercise12_1();
		frame.setLayout(new FlowLayout(FlowLayout.LEFT));
		frame.setTitle("Exercise12_1");
		frame.setSize(560,85);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
}