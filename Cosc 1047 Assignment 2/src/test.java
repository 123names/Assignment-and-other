import javax.swing.*;
import java.awt.*;

public class test extends JFrame {
	
	 private ImageIcon myIcon = new ImageIcon("image/x.gif");
	 private ImageIcon frIcon = new ImageIcon("image/y.gif");
	 private ImageIcon ukIcon = new ImageIcon("image/y.gif");
	
	 public test() {
		 
	 setLayout(new GridLayout(1,4,5,5));
	
	 add(new JLabel(myIcon));
	
	 add(new JButton(ukIcon));
	 }
	
	 /** Main method */
	 public static void main(String[] args) {
	 test frame = new test();
	 frame.setTitle("TestImageIcon");
	 frame.setSize(200,200);
	 frame.setLocationRelativeTo(null);// Center the frame
	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 frame.setVisible(true);
	 }
}

