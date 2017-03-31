import java.awt.*;

import javax.swing.*;


public class gameTic_Tac_ToeBoard extends JFrame{

	private ImageIcon x = new ImageIcon("E:/JAVA/Workspace/image/x.gif");
	private ImageIcon o = new ImageIcon("E:/JAVA/Workspace/image/o.gif");
	public gameTic_Tac_ToeBoard(){
		setLayout(new GridLayout(3,3, 5,5));
		for(int i =0; i<9; i++){
			int a = (int) (Math.random()*2);
			if(a ==0){
				add(new JLabel(x));
			}
			if(a==1){
				add(new JLabel(o));
			}
		}
	}
	
	public static void main(String []args){
		
		gameTic_Tac_ToeBoard frame = new gameTic_Tac_ToeBoard();
		frame.setTitle("Exercise 12.7");
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
}
