
public class Circle extends GeometricObject implements Comparable<Circle>{
	
	private double radius = 0;
	
	public Circle(double radius){
		this.radius = radius;
	}
	public void setRadius(double radius){
		this.radius = radius;
	}
	public double getRadius(){
		return radius;
	}
	@Override
	public int compareTo(Circle o) {
		if(this.radius >o.getRadius()){
			return 1;
		}
		if(this.radius< o.getRadius()){
			return -1;
		}
		else return 0;
	}
	public boolean equals(Object obj) {
	    return this.getRadius() == ((Circle)obj).getRadius();
	  }
}
