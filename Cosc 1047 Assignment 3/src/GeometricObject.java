
public abstract class GeometricObject {

	private String colour;
	private boolean isFilled;
	
	protected GeometricObject(){
		
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

}
