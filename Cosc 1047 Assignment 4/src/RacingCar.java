import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RacingCar extends JFrame {
    private JButton jbtPause = new JButton("Press");
    private JButton jbtResume = new JButton("Release");
	private Timer timer = new Timer(1000, new TimerListener());
	private CarPanel canvas = new CarPanel();
	
	class TimerListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			repaint();
		}

	}
	
public RacingCar() {
	JPanel p = new JPanel();
	p.add(jbtPause);
	p.add(jbtResume);
	
	this.add(canvas,BorderLayout.CENTER);
	this.add(p,BorderLayout.SOUTH);
	
	jbtPause.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e){
			canvas.paused();
			canvas.requestFocusInWindow();
		}
	});

	jbtResume.addActionListener(new ActionListener(){
	    @Override
		public void actionPerformed(ActionEvent e){
	    	canvas.resume();
	    	canvas.requestFocusInWindow();
	    }

	});
	
	canvas.setFocusable(true);
	
	 //start timer for animation
	 timer.start();
	//control animation speed using keyboard using UP and DOWN arrow keys
   canvas.addKeyListener(new KeyAdapter(){
	   @Override
	   public void keyPressed(KeyEvent e){
		   int delay = timer.getDelay();
		   if(e.getKeyCode() == KeyEvent.VK_UP)
			   timer.setDelay(delay > 300? delay-300:0);
		   if(e.getKeyCode() == KeyEvent.VK_DOWN)
			   timer.setDelay(delay < 50000? delay+100:50000);
	   }
   });
  
}

/**main method*/
public static void main(String[] args) {
    RacingCar frame = new RacingCar();
    frame.setTitle("Exercise16_15");
    frame.setSize(500, 150);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true); 
}


class CarPanel extends JPanel{
	private int xCoordinate = 10;
	private int yCoordinate = 20;
	
public void paused(){
	timer.stop();
}

public void resume(){
	timer.restart();
}

protected void paintComponent(Graphics g){
	super.paintComponent(g);
	if(xCoordinate>getWidth()){
		xCoordinate =- 10;	
	}
	xCoordinate += 15;
	  int x[] = {xCoordinate+20,xCoordinate+30,xCoordinate+40,xCoordinate+10};
	  int y[] = {yCoordinate-10,yCoordinate-10,yCoordinate,yCoordinate};
	  g.setColor(Color.YELLOW);
	  g.fillPolygon(x,y,x.length);
	  
	  g.setColor(Color.BLUE);
	  g.fillRect(xCoordinate,yCoordinate,50,10);
	  
	  g.setColor(Color.BLACK);
	  g.fillOval(xCoordinate+10,yCoordinate+10,10,10);
	  g.fillOval(xCoordinate+30,yCoordinate+10,10,10);
	
}

}


}
   
   
/*public class RacingCar extends JFrame {
	private int x = 100;
	private int y = 100;
	public RacingCar(){
		add(new MovingCarPanel(new CarPanel()));
	}
	
	//get car
	class CarPanel extends JPanel{
		public void paintComponent(Graphics g){
			
			int[] x1={x+20, x+10, x+40, x+30};
			int[] y1={y-30, y-20, y-20, y-30};
			g.setColor(Color.GREEN);
			g.fillPolygon(x1, y1,x1.length);
			
			g.setColor(Color.GRAY);
			g.fillRect(x, y-20, x+50, 10);
			
			g.setColor(Color.BLACK);
			g.fillOval(x+10, y-10,10, 10);
			
			g.setColor(Color.BLACK);
			g.fillOval(x+30, y-10,10, 10);
			
		}
	}
	public static void main(String[] args){
		RacingCar frame = new RacingCar();
		frame.setSize(400,200);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	static class MovingCarPanel extends JPanel{
		private int x = 400;
		private int y = 100;
		private Timer timer = new Timer(1000,new TimerListener());
		public MovingCarPanel(CarPanel carPanel) {
			timer.start();
			
		this.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				
			}
		});
		}
		
		
	}
}
*/