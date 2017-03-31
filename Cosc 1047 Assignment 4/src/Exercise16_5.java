import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Exercise16_5 extends JFrame{

	private JTextField text1;
	private JTextField text2;
	private JTextField text3;
	private JTextField text4;
	private JTextField text5;
	private JTextField text6;
	private int count = 0;
	
	private String [] databaseOfName = new String [5000];
	private String [] databaseOfquality = new String [5000];
	private String [] databaseOfincomingprice = new String [5000];
	private String [] databaseOfNumber = new String [5000];
	private String [] databaseOfprice = new String [5000];
	private JButton button;
	private JButton searchbutton;
	private JTextField textR1;
	private JTextField textR2;
	private JTextField textR3;
	private JTextField textR4;
	private JTextField textR5;
	
	
	public Exercise16_5(){
		setLayout(new BorderLayout());
	    JLabel lab1 = new JLabel("中药品名：");
	    text1 = new JTextField(8);
	    text1.setHorizontalAlignment(SwingConstants.RIGHT);
	    JLabel lab2 = new JLabel("规格：");
	    text2 = new JTextField(8);
	    text2.setHorizontalAlignment(SwingConstants.RIGHT);
	    JLabel lab3 = new JLabel("进价：");
	    text3 = new JTextField(8);
	    text3.setHorizontalAlignment(SwingConstants.RIGHT);
	    JLabel lab4 = new JLabel("数量：");
	    text4 = new JTextField(8);
	    text4.setHorizontalAlignment(SwingConstants.RIGHT);
	    JLabel lab5 = new JLabel("售价：");
	    text5 = new JTextField(8);
	    text5.setHorizontalAlignment(SwingConstants.RIGHT);
	    button = new JButton("录入");
	    
	    text6 = new JTextField(8);
	    text6.setHorizontalAlignment(SwingConstants.RIGHT);
	    searchbutton = new JButton("寻找");
	    
	    JLabel labR1 = new JLabel("中药品名：");
	    textR1 = new JTextField(8);
	    textR1.setHorizontalAlignment(SwingConstants.RIGHT);
	    JLabel labR2 = new JLabel("规格：");
	    textR2 = new JTextField(8);
	    textR2.setHorizontalAlignment(SwingConstants.RIGHT);
	    JLabel labR3 = new JLabel("进价：");
	    textR3 = new JTextField(8);
	    textR3.setHorizontalAlignment(SwingConstants.RIGHT);
	    JLabel labR4 = new JLabel("数量：");
	    textR4 = new JTextField(8);
	    textR4.setHorizontalAlignment(SwingConstants.RIGHT);
	    JLabel labR5 = new JLabel("售价：");
	    textR5 = new JTextField(8);
	    textR5.setHorizontalAlignment(SwingConstants.RIGHT);
		
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(5,0));
		p1.add(lab1);
		p1.add(text1);
		p1.add(lab2);
		p1.add(text2);
		p1.add(lab3);
		p1.add(text3);
		p1.add(lab4);
		p1.add(text4);
		p1.add(lab5);
		p1.add(text5);
		add(p1,BorderLayout.NORTH);
		
		JPanel p2 = new JPanel();
		p2.add(button);
		add(p2, BorderLayout.EAST);
		
		JPanel p3 = new JPanel();
		p3.add(text6);
		p3.add(searchbutton);
		p3.setLayout(new GridLayout(6,0));
		p3.add(labR1);
		p3.add(textR1);
		p3.add(labR2);
		p3.add(textR2);
		p3.add(labR3);
		p3.add(textR3);
		p3.add(labR4);
		p3.add(textR4);
		p3.add(labR5);
		p3.add(textR5);
		add(p3,BorderLayout.SOUTH);
		
		button.addActionListener(new calculate());
		searchbutton.addActionListener(new search());
	}
	class search implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String input = text6.getText();
			boolean exist = false;
			for(int i =0;i<5000;i++){
				if(input == databaseOfName[i]){
					textR1.setText(databaseOfName[i]);
					textR1.setEditable(false);
					textR2.setText(databaseOfquality[i]);
					textR2.setEditable(false);
					textR3.setText(databaseOfincomingprice[i]);
					textR3.setEditable(false);
					textR4.setText(databaseOfNumber[i]);
					textR4.setEditable(false);
					textR5.setText(databaseOfprice[i]);
					textR5.setEditable(false);
					exist = true;
				}
				else{
					exist = false;
				}
			}
			if(exist = false){
				JOptionPane.showMessageDialog(null,"没找到此药品记录！");
			}
		}

	}

	class calculate implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String name = text1.getText();
			boolean exist = false;
			for(int i = 0; i<5000;i++){
				if(name==databaseOfName[i]){
					databaseOfName[i] = text1.getText();
					databaseOfquality[i] = text2.getText();
					databaseOfincomingprice[i] = text3.getText();
					databaseOfNumber[i] = text4.getText();
					databaseOfprice[i] = text5.getText();
					exist = true;
					JOptionPane.showMessageDialog(null,"已覆盖原始记录！");
				}
			}
			if(exist==false){
				databaseOfName[count] = text1.getText();
				databaseOfquality[count] = text2.getText();
				databaseOfincomingprice[count] = text3.getText();
				databaseOfNumber[count] = text4.getText();
				databaseOfprice[count] = text5.getText();
				count++;
				JOptionPane.showMessageDialog(null,"录入成功！");
			}
		}
		
	}
	
	public static void main(String []args){
		JFrame frame = new Exercise16_5();
		frame.setTitle("Exercise16_5");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
