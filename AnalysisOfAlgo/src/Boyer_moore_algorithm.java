import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Boyer_moore_algorithm {

	public static void main(String []args){
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please input the text you want to search: ");
		String text = input.nextLine();
		System.out.println("Please input the pattern that you want to search: ");
		String pattern = input.nextLine();
		input.close();
		// bad symbol table
		HashMap<Character, Integer> bst = bad_symbol_table_form(text,pattern);
		System.out.println("Bad symbol table for the pattern " + pattern+ ": ");
		for (Character name: bst.keySet()){
            String key =name.toString();
            String value = bst.get(name).toString();  
            System.out.print("Key = "+key + " Value = " + value + "; ");  
        }
		System.out.println();
		// good suffix table
		ArrayList <Good_Suffix_element> good_suffix_table = good_suffix_table_form(new StringBuilder(pattern).reverse().toString());
		System.out.println("Good suffix table for the pattern " + pattern + ": ");
		for(int i =0;i<good_suffix_table.size();i++){
			System.out.print("K = " + good_suffix_table.get(i).getK() + " D2 = " + good_suffix_table.get(i).d2Value()+ "; ");
		}
		System.out.println();
		// check if pattern the string using bst and gst
		boolean match = matchString(bst,good_suffix_table,text,pattern);
		if(match){
			System.out.println("The pattern is in the text. ");
		}
		else{
			System.out.println("The pattern is not in the text. ");
		}
	}
	public static Good_Suffix_element getD2(String reversedPattern,String subPattern){
		Good_Suffix_element e = null;
		int subPatternSize = subPattern.length();
		char initPatternPrecededChar = reversedPattern.charAt(subPatternSize);
		int shiftNum = 1;
		int matchedPatternPrecededIndex = subPatternSize;
		// while subPattern occur
		while(reversedPattern.indexOf(subPattern, (shiftNum))!=-1){
			// if sub pattern match but have same PrecededChar, increase the subMatchedPatternPrecededIndex
			if(initPatternPrecededChar==reversedPattern.charAt((matchedPatternPrecededIndex))){
				// loop though pattern to see if sub pattern match occur with different precededChar
				matchedPatternPrecededIndex = reversedPattern.indexOf(subPattern, (shiftNum))+subPatternSize;
			}
			//System.out.println("subP " + subPattern + " matchedPatternPrecededIndex " + (matchedPatternPrecededIndex));
			// check if subMatchedPatternStartIndex already reach end of pattern by checking if exceed limit
			if((matchedPatternPrecededIndex)>reversedPattern.length()-1){
				// d2 = same sub PatternIndex - sub patternIndex
				e = new Good_Suffix_element(subPatternSize,((matchedPatternPrecededIndex-subPatternSize)));
				break;
			}
			//if sub pattern match occur in the mid of pattern and pattern match and have different precededChar
			if(initPatternPrecededChar!=reversedPattern.charAt(matchedPatternPrecededIndex)){
				e = new Good_Suffix_element(subPatternSize,(matchedPatternPrecededIndex-subPatternSize));
				break;
			}
			shiftNum++;
			// check if only pattern match occur on same PrecededChar, doing it after adding shift num or it will meet the while condition
			if(reversedPattern.indexOf(subPattern, (shiftNum))==-1){
				String tailOfSuffix = reversedPattern.substring(0,subPatternSize-1);
				int compareIndex = (reversedPattern.length()-1)-(tailOfSuffix.length()-1);
				//System.out.println(tailOfSuffix+ " " + compareIndex);
				for(int i =0;i<tailOfSuffix.length();i++){
					// check if tail match the head
					if(reversedPattern.charAt(compareIndex)==tailOfSuffix.charAt(i)){
						// if go though the list
						if(i==tailOfSuffix.length()-1){
							e = new Good_Suffix_element(subPatternSize,(reversedPattern.length()-tailOfSuffix.length()));
							break;
						}
						else{
							compareIndex++;
						}
					}
					else{
						// reset i if not match occur
						i=0;
						// shift pattern to left (reversed pattern so right this case)
						tailOfSuffix = tailOfSuffix.substring(0, tailOfSuffix.length()-1);
						compareIndex = (reversedPattern.length()-1)-(tailOfSuffix.length()-1);
						i--;
					}
				}
				if(tailOfSuffix.length()==0){
					e = new Good_Suffix_element(subPatternSize,reversedPattern.length());
				}
			}
		}
		return e;
	}
	
	public static ArrayList<Good_Suffix_element> good_suffix_table_form(String reversedPattern){
		ArrayList <Good_Suffix_element> good_suffix_table = new ArrayList<>();
		if(reversedPattern.length()>1){
			int subPatternSize = 1;
			String subPattern = reversedPattern.substring(0,subPatternSize);
			while(!subPattern.equals(reversedPattern)){
				// if sub pattern occurrence except itself
				if(reversedPattern.indexOf(subPattern, 1)!=-1){
					good_suffix_table.add(getD2(reversedPattern,subPattern));
				}
				// if no sub pattern occurrence
				else{
					String tailOfSuffix = reversedPattern.substring(0,subPatternSize-1);
					int compareIndex = (reversedPattern.length()-1)-(tailOfSuffix.length()-1);
					//System.out.println(tailOfSuffix+ " " + compareIndex);
					for(int i =0;i<tailOfSuffix.length();i++){
						// check if tail match the head
						if(reversedPattern.charAt(compareIndex)==tailOfSuffix.charAt(i)){
							// if go though the list and find matched tail entirely
							if(i==tailOfSuffix.length()-1){
								Good_Suffix_element e = new Good_Suffix_element(subPatternSize,(reversedPattern.length()-tailOfSuffix.length()));
								good_suffix_table.add(e);
								break;
							}
							else{
								compareIndex++;
							}
						}
						else{
							// reset i and compareIndex if not match occur
							i=0;
							// shift tail to left (reversed pattern so right this case)
							tailOfSuffix = tailOfSuffix.substring(0, tailOfSuffix.length()-1);
							compareIndex = (reversedPattern.length()-1)-(tailOfSuffix.length()-1);
							i--;
						}
					}
					if(tailOfSuffix.length()==0){
						Good_Suffix_element e = new Good_Suffix_element(subPatternSize,reversedPattern.length());
						good_suffix_table.add(e);
					}
				}
				subPatternSize++;
				subPattern = reversedPattern.substring(0,subPatternSize);
			}
		}
		return good_suffix_table;
	}
	
	public static HashMap<Character, Integer> bad_symbol_table_form(String text,String pattern){
		HashMap<Character, Integer> temp_bst = new HashMap<Character, Integer>();
		int counter = 1;
		char firstChar = pattern.charAt(pattern.length()-1);
		for(int i = pattern.length()-2; i>=0;i--){
			if(temp_bst.containsKey(pattern.charAt(i))){
				int value = temp_bst.get(pattern.charAt(i)).intValue();
				if(value>counter){
					temp_bst.put(pattern.charAt(i), counter);
				}
			}
			else{
				temp_bst.put(pattern.charAt(i), counter);
			}
			counter++;
		}
		for(int i = 0;i<text.length();i++){
			if(!temp_bst.containsKey(text.charAt(i))){
				temp_bst.put(text.charAt(i), pattern.length());
			}
		}
		if(temp_bst.get(firstChar)==null){
			temp_bst.put(firstChar, pattern.length());
		}
		return temp_bst;
	}
	
	public static boolean matchString(HashMap<Character, Integer> bst,ArrayList <Good_Suffix_element> gst, String text, String pattern){
		int compareIndex = pattern.length()-1;
		while(text.length()>=pattern.length()){
			int k = 0;
			if(text.charAt(compareIndex)!=pattern.charAt(compareIndex)){
				int ShiftSize = bst.get(pattern.charAt(compareIndex));
				text = text.substring(ShiftSize);
			}
			else{
				for (int j = compareIndex; j>=0;j--){
					if(text.charAt(j)==pattern.charAt(j)){
						k++;
						if(j==0){
							return true;
						}
					}
					else{
						// max(d1,d2)                                                   k-1 for indexing
						int ShiftSize = Math.max(bst.get(pattern.charAt(j)).intValue(), gst.get(k-1).d2Value());
						text = text.substring(ShiftSize);
					}
				}
			}
		}
		return false;
	}
}
