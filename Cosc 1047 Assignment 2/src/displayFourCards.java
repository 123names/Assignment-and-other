import javax.swing.*;

import java.awt.*;


public class displayFourCards extends JFrame{

	private ImageIcon back = new ImageIcon("E:/JAVA/Workspace/image/card/b1fv.png");
	private ImageIcon image =new ImageIcon(back.getImage().getScaledInstance(180, 280, Image.SCALE_SMOOTH));
	
	int a =(int)(Math.random()*55);
	private ImageIcon number1 = new ImageIcon("E:/JAVA/Workspace/image/card/"+ a +".png");
	private ImageIcon card1 = new ImageIcon(number1.getImage().getScaledInstance(180, 280, Image.SCALE_SMOOTH));
	
	int b =(int)(Math.random()*55);
	private ImageIcon number2 = new ImageIcon("E:/JAVA/Workspace/image/card/"+ b +".png");
	private ImageIcon card2 = new ImageIcon(number2.getImage().getScaledInstance(180, 280, Image.SCALE_SMOOTH));
	
	int c =(int)(Math.random()*55);
	private ImageIcon number3 = new ImageIcon("E:/JAVA/Workspace/image/card/"+ c +".png");
	private ImageIcon card3 = new ImageIcon(number3.getImage().getScaledInstance(180, 280, Image.SCALE_SMOOTH));
	
	int d =(int)(Math.random()*55);
	private ImageIcon number4 = new ImageIcon("E:/JAVA/Workspace/image/card/"+ d +".png");
	private ImageIcon card4 = new ImageIcon(number4.getImage().getScaledInstance(180, 280, Image.SCALE_SMOOTH));
	
	
	public displayFourCards(){
		setLayout(new GridLayout(1,4,0,0));
		

		JButton number1 = (JButton) new JButton(image);
		number1.setPressedIcon(card1);
		number1.setRolloverIcon(image);
		add(number1);
		

		JButton number2 = (JButton) new JButton(image);
		number2.setPressedIcon(card2);
		number2.setRolloverIcon(image);
		add(number2);
		
		
		JButton number3 = (JButton) new JButton(image);
		number3.setPressedIcon(card3);
		number3.setRolloverIcon(image);
		add(number3);
		
	
		JButton number4 = (JButton) new JButton(image);
		number4.setPressedIcon(card4);
		number4.setRolloverIcon(image);
		add(number4);
	}
	
	
	
	
	public static void main(String []args){
		displayFourCards frame = new displayFourCards();
		frame.setTitle("Exercise12_11");
		frame.setSize(800,300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
}
