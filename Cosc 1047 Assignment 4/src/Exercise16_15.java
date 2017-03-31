import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Exercise16_15 extends JFrame{
	
	private Timer timer = new Timer(1000, new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e){
			repaint();
		}
	});
	private drawPanel car = new drawPanel();
	public Exercise16_15(){
		
		add(car);
		car.setFocusable(true);
		
		timer.start();
		
		car.addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent ke){
				int delay = timer.getDelay();
				if(ke.getKeyCode() == KeyEvent.VK_PAUSE){
					timer.stop();
				}
				if(ke.getKeyCode() == KeyEvent.VK_ENTER){
					timer.restart();
				}
				if(ke.getKeyCode() == KeyEvent.VK_UP){
					   timer.setDelay(delay > 100? delay-100:0);
				}
				if(ke.getKeyCode() == KeyEvent.VK_DOWN){
						timer.setDelay(delay < 50000? delay+100:50000);
					
				}
			}
		});
		
	}
	
	class drawPanel extends JPanel{

		private int xValue =0;
		@Override
		protected void paintComponent(Graphics g){
			super.paintComponent(g);	
			if(xValue>this.getWidth()){
				xValue =- 10;	
			}
			 xValue +=10;
			int [] pointx = {20+xValue,30+xValue,40+xValue,10+xValue};
			int [] pointy = {130,130,140,140};
			g.drawString("Notes: Press Pause to stop, press Enter to restart. ", 110, 80);
			
			g.setColor(Color.RED);
			g.fillPolygon(pointx, pointy, pointx.length);
			g.setColor(Color.BLUE);
			
			g.fillRect(0+ xValue, 140, 50, 10);
			g.setColor(Color.BLACK);
			g.fillOval(10+ xValue, 149, 10, 10);
			g.fillOval(30+ xValue, 149, 10, 10);
		}
	}
	
	

	public static void main(String []args){
		JFrame frame = new Exercise16_15();
		frame.setTitle("Exercise16_15");
		frame.setSize(500, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
