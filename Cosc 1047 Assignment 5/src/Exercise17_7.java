import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Exercise17_7 extends JFrame{

	private JTextField hour, min, second;
	private StillClock clock = new StillClock();
	public Exercise17_7(){
		add(clock, BorderLayout.NORTH);
		JPanel panel = new JPanel();
		
		hour = new JTextField(2);
		hour.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae){
				clock.setHour(Integer.parseInt(hour.getText()));
			}
		});
		min = new JTextField(2);
		min.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae){
				clock.setMinute(Integer.parseInt(min.getText()));
			}
		});
		second = new JTextField(2);
		second.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae){
				clock.setSecond(Integer.parseInt(second.getText()));
			}
		});
		JLabel hours, minute, seconds;
		hours = new JLabel("Hour: ");
		minute = new JLabel("Minute: ");
		seconds = new JLabel("Second: ");
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		
		p1.add(hours);
		p1.add(hour);
		panel.add(p1,BorderLayout.WEST);
		
		p2.add(minute);
		p2.add(min);
		panel.add(p2,BorderLayout.SOUTH);
		
		p3.add(seconds);
		p3.add(second);
		panel.add(p3, BorderLayout.EAST);
		
		add(panel, BorderLayout.SOUTH);
	}
	
	public static void main(String []args){
		JFrame frame = new Exercise17_7();
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
