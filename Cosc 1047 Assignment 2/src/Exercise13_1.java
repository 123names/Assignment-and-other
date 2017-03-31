import java.awt.*;

import javax.swing.*;


public class Exercise13_1 extends JPanel{
	
	public Exercise13_1(){
		
	}
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(Color.BLUE);
		g.drawLine(0, 100, 300, 100);
		g.drawLine(0, 200, 300, 200);
		g.drawLine(0, 300, 300, 300);
		
		g.setColor(Color.RED);
		g.drawLine(100,0,100,300);
		g.drawLine(200, 0, 200, 300);
		g.drawLine(300, 0, 300, 300);
	}

	public static void main(String[]args){
		JFrame frame = new JFrame();
		frame.setTitle("Exercise13_1");
		frame.add(new Exercise13_1());
		frame.setSize(310,340);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
