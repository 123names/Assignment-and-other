
public class GeometricObject {

	private String colour;
	private boolean isFilled;
	
	GeometricObject(){
		
	}
	public void setColour(String colour){
		this.colour = colour;
	}
	public String getColour(){
		return this.colour;
	}
	public void Fill(boolean fill){
		this.isFilled = true;
	}
	public boolean isFilled(){
		return this.isFilled;
	}
	public String toString(){
		return "The colour is " + colour + " Fill or not is " + isFilled;
	}
}
