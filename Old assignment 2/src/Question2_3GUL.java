import javax.swing.JOptionPane;
public class Question2_3GUL {

	public static void main(String[] args) {
		
		String feet1 = JOptionPane.showInputDialog("Enter a value for feet: ");
		double feet = Double.parseDouble(feet1);
		double meter = feet * 0.305;
		JOptionPane.showMessageDialog( null,feet +  " feet is " + meter + " meters.");
	}

}
