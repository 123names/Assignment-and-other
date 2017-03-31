import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;


public class Exercise17_3 extends JFrame{

	private JRadioButton r1,r2,r3;
	private boolean red = false;
	private boolean yellow = false;
	private boolean green = false;
	
	public Exercise17_3(){
		drawPanel p1 = new drawPanel();
		//panel add button
		JPanel p2 = new JPanel();
		//panel add panel 1 to set position
		r1 = new JRadioButton("Red");
		r2 = new JRadioButton("Yellow");
		r3 = new JRadioButton("Green");
		
		ButtonGroup bg1 = new ButtonGroup();
		bg1.add(r1);
		bg1.add(r2);
		bg1.add(r3);
		r1.addItemListener(new selectListener());
		r2.addItemListener(new selectListener());
		r3.addItemListener(new selectListener());
		p2.add(r1);
		p2.add(r2);
		p2.add(r3);
		
		add(p1);
		add(p2, BorderLayout.SOUTH);
	}
	//drawpanel
	class drawPanel extends JPanel{
		@Override
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			
			g.setColor(Color.BLACK);
			g.drawRect(100, 15, 70, 180);
			g.drawOval(110, 20, 50, 50);
			g.drawOval(110, 80, 50, 50);
			g.drawOval(110, 140, 50, 50);
			if(red){
				g.setColor(Color.RED);
				g.fillOval(110, 20, 50, 50);
			}
			if(yellow){
				g.setColor(Color.YELLOW);
				g.fillOval(110, 80, 50, 50);
			}
			if(green){
				g.setColor(Color.GREEN);
				g.fillOval(110, 140, 50, 50);
			}
		}
	}
	class selectListener implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent ie) {
			if(ie.getStateChange() == ie.SELECTED){
				if(ie.getSource() == r1){
					red = true;
					repaint();
				}
				if(ie.getSource() == r2){
					yellow = true;
					repaint();
				}
				if(ie.getSource() == r3){
					green = true;
					repaint();
				}
			}
			if(ie.getStateChange() == ie.DESELECTED){
				if(ie.getSource() == r1){
					red = false;
					repaint();
				}
				if(ie.getSource() == r2){
					yellow = false;
					repaint();
				}
				if(ie.getSource() == r3){
					green = false;
					repaint();
				}
			}
		}
	}
	//main
	public static void main(String []args){
		JFrame frame = new Exercise17_3();
		frame.setTitle("Exercise17_3");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
