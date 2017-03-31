import java.awt.Color;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class Exercise16_7 extends JFrame{

	private JPanel p1 = new JPanel();
	private boolean pressedShiftOrNot = false;
	public Exercise16_7(){
		
		p1.setBackground(Color.BLUE);
		addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent ke){
				if(ke.getKeyCode()==KeyEvent.VK_SHIFT){
					pressedShiftOrNot = true;
				}
			}
		});
		 addMouseListener(new MouseAdapter(){
			 @Override
			 public void mousePressed(MouseEvent e){
				 p1.setBackground(Color.BLACK);
				 if(pressedShiftOrNot){
					 p1.setBackground(Color.RED);
					
				 }
				 repaint();
				 pressedShiftOrNot = false;
			 }
			 @Override
			 public void mouseReleased(MouseEvent e){
				 p1.setBackground(Color.BLUE);
				 repaint();
			 }
			 @Override
			 public void mouseEntered(MouseEvent me){
				 p1.setBackground(Color.WHITE);
				 repaint();
			 }
			 public void mouseExits(MouseEvent me){
				 p1.setBackground(Color.BLUE);
				 repaint();
			 }
			 
		 });
		 add(p1);
	}

	public static void main(String [] args){
		JFrame frame = new Exercise16_7();
		frame.setTitle("Exercise16_7");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
