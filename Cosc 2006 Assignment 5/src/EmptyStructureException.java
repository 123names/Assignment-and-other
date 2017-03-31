
public class EmptyStructureException extends RuntimeException {
	
	public EmptyStructureException() {
		super(); 
	}
	
	public EmptyStructureException(String s) { 
		System.out.print(s);
	}
}