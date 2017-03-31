import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Compiler {
	static File in = new File("program1.txt");
	static Scanner input;
	static String line1;
	static String line2;
	static boolean lastLine;
	
	public static void main(String[] args) throws FileNotFoundException{
		File in = new File("d:/1.txt");
		input = new Scanner(in);
		line1 = input.nextLine();
		skip1();
		line2 = input.nextLine();
		skip2();
		if(line1.equals("begin")){
			if(input.hasNextLine()){
				stmtList();
				checkEnd();
			}
			else{
			    checkEnd();
				System.out.println("But nothing inside the body.");
			}
		}
		else{
			terminate();
		}
	
	}
	
	public static void skip1(){
		while(line1.isEmpty() && input.hasNextLine()){
			line1 = input.nextLine();
		}
	}
	
	public static void skip2(){
		while(line2.isEmpty() && input.hasNextLine()){
			line2 = input.nextLine();
		}
	}
	
	public static void checkEnd(){
		if(line1.equals("end")){
			System.out.println("This is a comlete program.");
			System.exit(0);
		}
		else{
			terminate();
	    }
	}
	
	public static void stmtList(){
			stmt();
			stmtList();
	}
	
	
	public static void stmt(){
		if(input.hasNextLine()){
			line1 = line2;
			line2 = input.nextLine();
			skip2();
		}
		else{
			line1 = line2;
			checkEnd();
		}
		System.out.println("stmt:"+line1);
		StringTokenizer st = new StringTokenizer(line1);
		String temp = st.nextToken();
		
			if(temp.contains("while")){
				whileStmt();
			}
			else if(temp.contains("if")){
				ifStmt();
			}
			else{
				assignStmt();
			}
	}
	
	public static boolean checkColon(){
		for(int i=line1.length()-1;i>=0;i--){
			if(line1.charAt(i)==';'){
				line1 = line1.substring(0, i);
				return true;
			}
			else{
				continue;
			}
		}
		return false;
	}
	
	public static void assignStmt(){
		System.out.println("assign:"+line1);
		if(line2.equals("end")&&checkColon()){
				terminate();
		}
		if(!(line2.equals("end"))&&!checkColon()){
			terminate();
		}
		for(int i=0; i<line1.length();i++){
			if(line1.charAt(i)=='='){
				var(line1.substring(0,i));
				expr(line1.substring(i+1));
			}
		}
	}
	
	
	public static void ifStmt(){
		StringTokenizer st = new StringTokenizer(line1);
		String temp = st.nextToken();
		System.out.println("temp:"+temp);
			if(temp.contains("(") || st.nextToken().contains("(")){
				int i = 0;
				while(line1.charAt(i)!='('){
				i++;
				}
				logicExpr(line1.substring(i));
			}else{
				terminate();
			}
		//check then keyword	
		for(int i=line1.length()-1;i>3;i--){
			if(line1.charAt(i)==32)
				continue;
			if(line1.charAt(i-4)==32 && line1.charAt(i)=='n' && line1.charAt(i-1)=='e' && line1.charAt(i-2)=='h' && line1.charAt(i-3)=='t'){
				break;
			}else{
				terminate();
			}
		}
	}
	
	
	public static void whileStmt(){
		StringTokenizer st = new StringTokenizer(line1);
		String temp = st.nextToken();
		System.out.println("temp:"+temp);
		if(temp.contains("(") || st.nextToken().contains("(")){
			int i = 0;
			while(line1.charAt(i)!='('){
			   i++;
			}
			logicExpr(line1.substring(i));
		}
		else{
			terminate();
		}
	}
	
	public static void logicExpr(String st){
		System.out.println("logicExpr:"+st);
		int i=0;
		boolean found = false;
		while(st.charAt(i)!=')'|| i<st.length() ){
			if(st.charAt(i) !=')'){
				i++;
			}
			else{
				logicExprHelper(st.substring(1, i));
				found = true;
				break;
			}
		}
		if(!found){
			terminate();
		}
		
	}
	
	public static void logicExprHelper(String st){
		boolean found = false;
		for(int i=1;i<st.length()-1;i++){
			if(st.charAt(i)=='<' || st.charAt(i)=='>'){
				var(st.substring(0, i));
				expr(st.substring(i+1));
				found  = true;
			}
		}
		if(!found)
			terminate();
	}
	
	public static void var(String str){
		System.out.println("var:"+str);
		if(str.isEmpty())
			terminate();
		StringTokenizer stk = new StringTokenizer(str);
		if(stk.countTokens()!=1){
			terminate();
		}
		String st = stk.nextToken();
		for(int i=0;i<st.length();i++){
			if(!(st.charAt(i)>='A' && st.charAt(i)<='z') && !(st.charAt(i)>='0' && st.charAt(i)<='9'))
				terminate();
		}
	}
	//
	public static void expr(String st){
		System.out.println("expr:"+st);
		if(st.isEmpty())
			terminate();
		
		boolean p = false;
		String pass= "";
		
		for(int i=0;i<st.length();i++){
			if(p && i==st.length()-1 && st.charAt(i)!=')')
				terminate();
			
			else if(st.charAt(i)=='('){
				pass+=st.charAt(i);
				p = true;
			}else if(st.charAt(i)==')'){
				pass+=st.charAt(i);
				p = false;
			}else if(p){
				pass+=st.charAt(i);
			}else if(!p && st.charAt(i)=='+' || st.charAt(i)=='-'){
				term(pass);
				pass="";
			}else{
				pass+=st.charAt(i);
			}
		}
		term(pass);
	}
	
	public static void term(String st){
		System.out.println("term:"+st);
		StringTokenizer stk = new StringTokenizer(st);
		if(!stk.hasMoreTokens())
			terminate();
		boolean found = false;
		for(int i=0;i<st.length();i++){
			if(st.charAt(i)=='*' || st.charAt(i)=='\\' || st.charAt(i)=='/'){
				found = true;
				factor(st.substring(0, i));
				factor(st.substring(i+1));
			}
		}
		if(!found)
			factor(st);
	}
	
	public static void factor(String st){
		System.out.println("Factor:"+st);
		for(int i=0;i<st.length();i++){
			if(st.charAt(i)==32){
				continue;
			}
			else if(st.charAt(i)=='('){
				for(int j=i;j<st.length();j++){
					if(st.charAt(j)==')'){
						expr(st.substring(i+1, j));
						i=j;
						break;
					}
					else if(st.charAt(j)!=')'&&j==st.length()-1){
						terminate();
					}
					else{
						continue;
					}
				}
			}
			else if(st.charAt(i)>='0'&&st.charAt(i)<='9'){
				integerConstant(st);
				break;
			}
			else{
				System.out.println("st: "+st+" current char:"+st.charAt(i));
				var(st);
				break;
			}
		}
	}
	
	public static void integerConstant(String str){
		System.out.println("integer:"+str);
		if(str.isEmpty())
			terminate();
		StringTokenizer stk = new StringTokenizer(str);
		if(stk.countTokens()!=1){
			terminate();
		}
		String st = stk.nextToken();
		System.out.println(st);
		for(int i=0;i<st.length();i++){
			if((st.charAt(i)<'0' || (st.charAt(i)>'9')))
				terminate();
		}
	}
	
	public static void terminate(){
		System.out.println("Error");
		System.exit(0);
	}

}