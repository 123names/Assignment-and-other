import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
public class LexicalAnalyzer {

	public static void main (String []args) throws FileNotFoundException{
		ArrayList<String> expr = new ArrayList();
		String inFile = null;
		String test = null;
		int count = 1;
		Scanner in = new Scanner(System.in);
		System.out.println("Please input the file of expression that you want to check: ");
		inFile = in.nextLine();
		File expressionFile = new File(inFile);
		Scanner read = new Scanner(expressionFile);
		while(read.hasNextLine()){
			expr.add(read.nextLine());
		}
		System.out.println("The expression is : ");
		for(int i = 0; i<expr.size();i++){
			System.out.println(expr.get(i));
		}
		for(int i = 0; i<expr.size();i++){
			if(expr.get(i).toString().isEmpty()){
				expr.remove(i);
			}
		}
		if(expr.get(0).toString().compareTo("begin")!=0){
			System.out.println("Syntax error! The keyword begin is missing.");
			System.exit(0);
		}
		else if(expr.get(expr.size()-1).toString().compareTo("end")!=0){
			System.out.println("Syntax error! The keyword end is missing.");
			System.exit(0);
		}
		while(count<expr.size()-1){
			if(count == expr.size()-2){
				stmtList(expr.get(count).toString(), true);
			}
			else{
				stmtList(expr.get(count).toString(),false);
			}
			count++;
		}
		if(count == expr.size()-1){
			System.out.println("There are no syntax error in this statement. ");
		}
	}
	
	public static void stmtList(String str, boolean lastline) {
		stmt(str, lastline);
	}
	public static void stmt(String str, boolean lastline){
		if(str.contains("while")){
			//System.out.println("while ste: " + str);
			whileStmt(str);
		}
		else if(str.contains("if")){
			//System.out.println("if ste: " + str);
			ifStmt(str);
		}
		else if(str.contains("=")){
		//	System.out.println("assign ste: " + str);
			assignStmt(str,lastline);
		}
		else{
			//System.out.println("Syntax error! No possible statement can be create");
			System.exit(0);
		}
	}

	public static void assignStmt(String str, boolean lastline) {
		if (!checkSemicolon(str)&&!lastline){
			System.out.println("Syntax error! Miss of semicolon");
			System.exit(0);
		}
		if(lastline){
			for(int i=0; i<str.length();i++){
				if(str.charAt(i)=='='){
					identifier(str.substring(0,i));
					expr(str.substring(i+1));
				}
			}
		}
		for(int i=0; i<str.length();i++){
			if(str.charAt(i)=='='){
				identifier(str.substring(0,i));
				expr(str.substring(i+1));
			}
		}
	}

	public static void ifStmt(String str) {
		str = str.replaceAll("\\s", "");
		//System.out.println(str);
		if(str.contains("(")){
		    int beginForloex = 0;
			while(str.charAt(beginForloex)!='('){
				beginForloex++;
		    }
         	logicExpr(str.substring(beginForloex));
		}
		else{
			System.out.println("Syntax error! There are no logical expression in the statement!");
			System.exit(0);
		}
		if(str.contains("then")){
			int beginthen = 0;
			while(str.charAt(beginthen)!=')'){
				beginthen++;
		    }
			if(str.substring(beginthen+1).compareTo("then")!=0){
				System.out.println("Syntax error! KeyWord then is misplaced!");
			}
		}
		else{
			System.out.println("Syntax error! KeyWord then is missing!");
			System.exit(0);
		}
	}
	
	public static void whileStmt(String str) {

		if(str.contains("(")){
			int beginForloex = 0;
			while(str.charAt(beginForloex)!='('){
				beginForloex++;
		    }
			logicExpr(str.substring(beginForloex));
		}
		else{
			System.out.println("Syntax error!");
			System.exit(0);
		}
	}
	
	public static void logicExpr(String str) {
		int i = 0; 
		boolean rightp = false;
		while(str.charAt(i)!=')' || i<str.length()){
			if(str.charAt(i) !=')'){
				i++;
			}
			else{
				checkOpeartor(str.substring(1, i));
				rightp = true;
				break;
			}
		}
		if(!rightp){
			System.out.println("Syntax error! There are left parenthesis but no right parenthesis!");
			System.exit(0);
		}
		
	}
	public static void checkOpeartor(String str){
		boolean opeartor = false;
		for(int i=1;i<str.length()-1;i++){
			if(str.charAt(i)=='<' || str.charAt(i)=='>'){
				identifier(str.substring(0, i));
				expr(str.substring(i+1));
				opeartor  = true;
			}
		}
		if(!opeartor){
			System.out.println("Syntax error! Operator not found!!");
			System.exit(0);
		}
	}
	
	
	public static boolean checkSemicolon(String str){
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)==';'){
				str = str.substring(0, i);
				return true;
			}
		}
		return false;
	}

	public static void identifier(String str){
		if(str.isEmpty()){
			System.out.println("Syntax error! Variable can not be empty!");
			System.exit(0);
		}
		StringTokenizer stk = new StringTokenizer(str);
		if(stk.countTokens()!=1){
			System.out.println("Syntax error! Variable can not be two or more words!");
			System.exit(0);
		}
		String st = stk.nextToken();
		for(int i=0;i<st.length();i++){
			if(!(st.charAt(i)>='A' && st.charAt(i)<='z') && !(st.charAt(i)>='0' && st.charAt(i)<='9')){
				System.out.println("Syntax error! An identifier is a string that begins with a letter followed by 0 or more letters and digits!");
				System.exit(0);
			}	
		}
	}
	//
	public static void expr(String str){
		str = str.replaceAll("\\s", "");
		boolean usingp = false;
		String passpart= "";
		
		if(str.isEmpty()){
			System.out.println("Syntax error! Expression can not be empty!");
			System.exit(0);
		}
		for(int i=0;i<str.length();i++){
			if(usingp && i==(str.length()-1) && str.charAt(i)!=')'){
				System.out.println("Syntax error! There are left parenthesis but no right parenthesis!");
				System.exit(0);
			}
			else if(str.charAt(i)=='('){
				passpart+=str.charAt(i);
				usingp = true;
			}
			else if(str.charAt(i)==')'){
				passpart+=str.charAt(i);
				usingp = false;
			}
			else if(usingp){
				passpart+=str.charAt(i);
			}
			else if(!usingp && str.charAt(i)=='+' || str.charAt(i)=='-'){
				term(passpart);
				passpart="";
			}
			else{
				passpart+=str.charAt(i);
			}
		}
	}
	
	public static void term(String str){
		boolean usingp = false;
		String passpart= "";
		if(str.isEmpty()){
			System.out.println("Syntax error! Term can not be empty");
			System.exit(0);
		}
		for(int i=0;i<str.length();i++){
			if(usingp && i==(str.length()-1) && str.charAt(i)!=')'){
				System.out.println("Syntax error!There are left parenthesis but no right parenthesis!");
				System.exit(0);
			}
			else if(str.charAt(i)=='('){
				passpart+=str.charAt(i);
				usingp = true;
			}
			else if(str.charAt(i)==')'){
				passpart+=str.charAt(i);
				usingp = false;
			}
			else if(usingp){
				passpart+=str.charAt(i);
			}
			else if(!usingp &&str.charAt(i)=='*' || str.charAt(i)=='/'){
				factor(passpart);
			}
		}
	}
	
	public static void factor(String str){
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)==' '){
				continue;
			}
			else if(str.charAt(i)=='('){
				for(int j=i;j<str.length();j++){
					if(str.charAt(j)==')'){
						expr(str.substring(i+1, j));
						i=j;
						break;
					}
					else if(str.charAt(j)!=')'&&j==str.length()-1){
						System.out.println("Syntax error!There are left parenthesis but no right parenthesis!");
						System.exit(0);
					}
					else{
						continue;
					}
				}
			}
			else if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
				int_constant(str);
				break;
			}
			else{
				identifier(str);
				break;
			}
		}
	}

	public static void int_constant(String str) {
		if(str.isEmpty()){
			System.out.println("Syntax error!Constant can not be empty!");
			System.exit(0);
		}
		StringTokenizer stk = new StringTokenizer(str);
		if(stk.countTokens()!=1){
			System.out.println("Syntax error!Constant can not be more that one element!");
			System.exit(0);
		}
		String st = stk.nextToken();
		System.out.println(st);
		for(int i=0;i<st.length();i++){
			if((st.charAt(i)<'0' || (st.charAt(i)>'9')))
				System.out.println("Syntax error!That is not a constant!");
			    System.exit(0);
		}
	}
}
