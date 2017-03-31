import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Exercise16_3 extends JFrame{

	private int xValue =0;
	private int yValue = 0;
	private circle circle1 = new circle();
	public Exercise16_3(){
		
    	JPanel p1 = new JPanel();
    	JButton jbt1 = new JButton("Left");
    	JButton jbt2 = new JButton("Right");
    	JButton jbt3 = new JButton("Up");
    	JButton jbt4 = new JButton("Down");
    	p1.setLayout(new GridLayout(1,0,5,5));
    	p1.add(jbt1);
    	p1.add(jbt2);
    	p1.add(jbt3);
    	p1.add(jbt4);
    	add(p1,BorderLayout.SOUTH);
    	add(circle1, BorderLayout.CENTER);
    	jbt1.addActionListener(new moveLeft());
    	jbt2.addActionListener(new moveRight());
    	jbt3.addActionListener(new moveUp());
    	jbt4.addActionListener(new moveDown());
    }
	class moveLeft implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			xValue-=5;
			repaint();
		}
	}
	class moveRight implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent a){
			xValue+=5;
			repaint();
		}
	}
	class moveUp implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent a){
			yValue -=5;
			repaint();
		}
	}
	class moveDown implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent a){
			yValue+=5;
			repaint();
		}
	}
	
	public static void main(String []args){
		JFrame frame = new Exercise16_3();
		frame.setSize(300, 200);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	class circle extends JPanel{

		private int radius = 15;
		
		@Override
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawOval(xValue, yValue, radius*2, radius*2);
		}
	}
}
