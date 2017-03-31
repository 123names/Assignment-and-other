
public class Octagon extends GeometricObject implements Comparable<Octagon>,Cloneable{

	private double side = 1.0;
	
	public Octagon(){
		
	}
	
	public Octagon(double side){
		this.side = side; 
	}
	public double getSide1(){
		return side;
	}
	public void setSide(double side1){
		this.side = side1;
	}

	public double getArea(){
		double area=(2 +4/22)*side*side;
		return area;
	}
	public double getPerimeter(){
		return (side*8);
	}

	@Override
	public int compareTo(Octagon o) {
		if(o.getArea()>this.getArea()){
			return -1;
		}
		if(o.getArea()<this.getArea()){
			return 1;
		}
		else return 0;
	}
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();

	}
}
 