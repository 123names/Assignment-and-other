/*Ygao Cose2006
 * BusinessManagementSystem for assignment 1
 */

import java.util.Scanner; //import Scanner
import java.io.*;
public class BusinessManagementSystem {

	//main
	public static void main(String[] args) throws FileNotFoundException {
		int [] employeeID = new int [200];// create 3 array to receive data from file
		String [] salaryType = new String [200];
		double [] amount = new double [200];
		//some variable used in loop
		int i =0;
		int c = 0;
		int a = 0;
		int count = 0;
		int check = 0;
		boolean exist = false;
		String command = "A";
		File stuff = new File("E:/JAVA/Workspace/a1data.txt");// read data from txt file
		Scanner read = new Scanner(stuff);
		//Scanner read read data from stuff
		Scanner input = new Scanner(System.in);
		// read data until not line
		while(read.hasNextLine()){
			employeeID[i] = read.nextInt();
			i++;
			count++;
			salaryType[c] = read.next();
			c++;
			amount[a] = read.nextDouble();
			a++;
		}
		// method that put every thing in order
		order(employeeID,salaryType,amount);
		//do while loop to Enter command until Q(Quit)
		do{
		System.out.print("Please enter your command:  S (Search for an employee), P (Print Total Salary) or Q (quit): ");
		command = input.next();
		//switch statement to make choice
		switch(command){
		case "S": //case s, search eemployee to find other quility
			System.out.print("Please enter employee number: ");
			check = input.nextInt();
			exist = false;
			for (int b =0; b<count;b++){
				if(check == employeeID[b]){
					System.out.println("Employee ID:         Salary Type:            Amount:");
					System.out.printf("%-23d%-22s%-14.3f\n" ,employeeID[b], salaryType[b],amount[b]);
					exist = true;
				}
			}
			if(exist ==false){
				System.out.println("ID not exist. ");
			}
			break;
		case "P"://out put everything i read in file
			System.out.println("Employee ID:         Salary Type:            Amount:");
			for(int b =0; b<count; b++){
				System.out.printf("%-23d%-22s%-14.3f\n" ,employeeID[b], salaryType[b],amount[b]);
			}
			break;
		case "Q"://quit
			command ="Q";
			break;
		default: //condition that type wrong code
			System.out.println("Wrong code for command.");
			break;
		}
	}while(command!="Q");
  }
	//order method to put things in order
	public static void order(int [] a, String []b, double []c){
		for(int i =1; i<a.length; i++){
			int inloop = i;
			int key = a[i];
			while(inloop>0&&key>a[inloop-1]){
				a[inloop]=a[inloop-1];
				b[inloop]=b[inloop-1];
				c[inloop]=c[inloop-1];
				inloop--;
			}
			a[inloop]=key ;
		}
	}
}
