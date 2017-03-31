import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class test extends JFrame {
	
	private Timer timer = new Timer(1000, new TimerListener());
	private CarPanel canvas = new CarPanel();
	
	class TimerListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			repaint();
		}
	}
	
public test() {
	JPanel p = new JPanel();
	
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
    test frame = new test();
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
   