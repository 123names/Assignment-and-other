
public class MyRectangle2D {

	private double x = 0;
	private double y = 0;
	private double width = 1;
	private double height = 1;
	
	MyRectangle2D(double x, double y, double width, double height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	public void setX(double x){
		this.x = x;
	}
	public double getX(){
		return x;
	}
	public void setY(double y){
		this.y = y;
	}
	public double getY(){
		return y;
	}
	public void setWidth(double width){
		this.width = width;
	}
	
	public double getWidth(){
		return width;
	}
	public void setHeight(double height){
		this.height = height;
	}
	public double getHeight(){
		return height;
	}
	public double getArea(){
		return (this.height * this.width);
	}
	public double getPerimeter(){
		return (this.height + this.width)*2;
	}
	public boolean contains(double x, double y){
	    return Math.abs(((x-this.x)*2) - height) < height && Math.abs((y - this.y)*2 -width) < width;
	}
	public boolean contains(MyRectangle2D r)
	{
	    return contains(r.getX(), r.getY()) && contains(r.getX() + r.getHeight(), r.getY() + r.getWidth());
	}
	public boolean overlaps(MyRectangle2D r)
	{
	    return contains(r.getX(), r.getY()) || contains(r.getX() + r.getHeight(), r.getY() + r.getWidth());
	}
}
