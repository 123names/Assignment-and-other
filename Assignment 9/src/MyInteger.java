
public class MyInteger {

	int value;
	static int changeableValue;
	
	MyInteger(int Newvalue){
		changeableValue = Newvalue;
	}
	int getValue(){
		return value;
	}
	
	boolean isEven(){
		boolean even =false;
		if(value%2 ==0){
			even =true;
		}
		return even;
	}
	boolean isOdd(){
		boolean odd =false;
		if(value%2 !=0){
			odd =true;
		}
		return odd;
	}
	boolean isPrime(){
		boolean prime = false;
		if(value == 5){
			prime =true;
		}
		else if(value/2 %2 !=0){
			prime = true;
		}
		return prime;
	}
	static boolean isEven(int value){
		boolean even =false;
		if(value%2 ==0){
			even =true;
		}
		return even;
	}
	static boolean isOdd(int value){
		boolean odd =false;
		if(value%2 !=0){
			odd =true;
		}
		return odd;
	}
	static boolean isPrime(int value){
		boolean prime = false;
		if(value == 5){
			prime =true;
		}
		else if(value/2 %2 !=0){
			prime = true;
		}
		return prime;
	}
	static boolean iseven(){
		boolean even =false;
		if(changeableValue%2 ==0){
			even =true;
		}
		return even;
	}
	static boolean isodd(){
		boolean even =false;
		if(changeableValue%2 ==0){
			even =true;
		}
		return even;
	}
	static boolean isprime(){
		boolean prime = false;
		if(changeableValue == 5){
			prime =true;
		}
		else if(changeableValue/2 %2 !=0){
			prime = true;
		}
		return prime;
	}
	boolean equals(int number){
		boolean result = false;
		if(value == number){
			result = true;
		}
		return result;
	}
	boolean equals1(int number){
		boolean result = false;
		if(changeableValue == number){
			result = true;
		}
		return result;
	}
	static int[] parseInt(char[]whatever){
		int [] convert = new int [whatever.length];
		for(int i =0; i<whatever.length; i++){
		    if(Character.isLetter(whatever[i])){
		    	convert [i] = whatever[i];
		    }
	    }
		return convert;
		/*
	static int [] parseInt(String []convert){
		int [] convert1 = new int [convert.length];
		for(int i =0; i<convert.length; i++){
			convert1[i]=convert[i];
		}
		*/
	}
}
