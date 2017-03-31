import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class Exercise16_11 extends JFrame{

	private Point point = new Point();
	private char printChar = ' ';
	
	public Exercise16_11(){
		add(new drawPanel());
		addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent me){
				point.x = me.getX()-15;
				point.y = me.getY()-30;
				repaint();
			}
		});
		
		addKeyListener(new KeyAdapter(){
			@Override
			public void keyTyped(KeyEvent ke){
				printChar = ke.getKeyChar();
			}
		});
	}
	
	class drawPanel extends JPanel{
		 @Override
		  protected void paintComponent(Graphics g) {
		    super.paintComponent(g);
		    g.setColor(Color.BLACK);
		    g.drawString(String.valueOf(printChar), point.x, point.y);
		 }
		}
	
	public static void main (String []args){
		JFrame frame = new Exercise16_11();
		frame.setTitle("Exercise16_11");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
