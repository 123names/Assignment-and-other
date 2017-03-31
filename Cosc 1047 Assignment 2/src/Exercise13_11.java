import javax.swing.*;
import java.awt.*;
public class Exercise13_11 extends JPanel{
	
	public Exercise13_11(){
	    setLayout(new BorderLayout());
	}
	
	Polygon p = new Polygon();
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawLine(200, 20, 200, 300);
		g.drawLine(50, 200, 350, 200);
		
	    g.drawLine(200, 20, 180, 50);
	    g.drawLine(200, 20, 220, 50);
	    g.drawLine(350, 200, 330, 180);
	    g.drawLine(350, 200, 330, 220);
		
	    g.drawString("X", 360, 180);
	    g.drawString("Y", 220, 40);
		
		double scaleFactor = 0.1;
		
		for(int x = -100; x <= 100; x++) {
			p.addPoint(x + 200,200- (int)(scaleFactor * x * x));
		}
		g.drawPolygon(p);
		
	}
	public int [] xpoints(){
		int[]x =p.xpoints;
		return x;
	}
	public int [] ypoints(){
		int[]y =p.ypoints;
		return y;
	}
	public int  npoints(){
		int n =p.npoints;
		return n;
	}
	
	public static void main(String[]args){
		JFrame frame = new JFrame();
		frame.add(new Exercise13_11());
		frame.setTitle("Exercise13_11");
		frame.setSize(400,300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
