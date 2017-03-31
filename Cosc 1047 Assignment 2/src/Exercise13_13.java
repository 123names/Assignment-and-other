import javax.swing.*;
import java.awt.*;

public class Exercise13_13 extends JPanel{
	
	public Exercise13_13() {
		
	}
	int[]x1 = {140,120,160};
	int[]y1 = {115,150,150};

	@Override
	protected void paintComponent(Graphics g){
		super.paintComponents(g);
		
		g.setColor(Color.YELLOW);
		g.fillOval(50, 25, 180, 200);
		
		g.setColor(Color.BLACK);
		g.drawOval(85, 75, 40, 30);
		
		g.setColor(Color.BLACK);
		g.drawOval(155, 75, 40, 30);
		
		g.setColor(Color.WHITE);
		g.fillOval(85, 75, 40, 30);
		
		g.setColor(Color.WHITE);
		g.fillOval(155, 75, 40, 30);
		
		g.setColor(Color.BLACK);
		g.fillOval(100, 85, 15, 10);
		
		g.setColor(Color.BLACK);
		g.fillOval(165, 85, 15, 10);
		
		g.setColor(Color.BLACK);
		g.drawPolygon(x1, y1, x1.length);
		g.drawLine(70, 30, 100, 50);
		g.drawLine(138, 5, 138, 40);
		g.drawLine(200, 30, 170, 50);
		
		g.setColor(Color.BLACK);
		g.drawArc(30, 25, 200, 170, -105, 45);
		
	}
	
	
	


	public static void main(String []args){
		
		JFrame frame = new JFrame();
		frame.add(new Exercise13_13());
		frame.setTitle("Exercise13_13");
		frame.setSize(300,300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
