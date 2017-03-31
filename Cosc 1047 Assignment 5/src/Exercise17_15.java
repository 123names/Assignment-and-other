import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;


public class Exercise17_15 extends JFrame{
	private JLabel test = new JLabel("show colors", JLabel.CENTER);
	private int red,green,blue;
	JScrollBar s1,s2,s3;
	public Exercise17_15(){
		
		JPanel p1 = new JPanel();
		//create panel add label
		p1.setLayout(new GridLayout(3,0,5,5));
		JLabel l1 = new JLabel("Red");
		JLabel l2 = new JLabel("Green");
		JLabel l3 = new JLabel("Blue");
		p1.add(l1);
		p1.add(l2);
		p1.add(l3);
		
		JPanel p2 = new JPanel();
		//panel add JScrollbar
		p2.setLayout(new GridLayout(3,0,5,5));
		s1 = new JScrollBar(JScrollBar.HORIZONTAL);
		s1.setMaximum(255);
		s1.addAdjustmentListener(new colorChange());
		
		s2 = new JScrollBar(JScrollBar.HORIZONTAL);
		s2.setMaximum(255);
		s2.addAdjustmentListener(new colorChange());
		
		s3 = new JScrollBar(JScrollBar.HORIZONTAL);
		s3.setMaximum(255);
		s3.addAdjustmentListener(new colorChange());
		
		p2.add(s1);
		p2.add(s2);
		p2.add(s3);
		//panel add together
		JPanel p3 = new JPanel(new BorderLayout());
		p3.setBorder(new TitledBorder("Choose Color"));
		p3.add(p1, BorderLayout.WEST);
		p3.add(p2, BorderLayout.EAST);
		add(p3,BorderLayout.SOUTH);
		
		add(test);
	}
	//inner class
	class colorChange implements AdjustmentListener{

		@Override
		public void adjustmentValueChanged(AdjustmentEvent ae)  {
			if(ae.getSource()==s1){
				red = s1.getValue();
			}
			if(ae.getSource()==s2){
				green = s2.getValue();
			}
			if(ae.getSource()==s3){
				blue = s3.getValue();
			}
			Color color = new Color(red,green,blue);
			test.setForeground(color);
		}
		
	}
	//main
	public static void main(String []args){
		JFrame frame = new Exercise17_15();
		frame.setTitle("Exercise17_15");
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
