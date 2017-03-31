
public class test {

	public static void main(String[] args) {
	
			  int num1 = 567;

			  int num2;

			  int a,b,c;         //分别存放百位，十位，个位上的数字

			  a=num1/100;    //求得百位上的数字
			  System.out.println(a);

			  b=(num1%100)/10;       //小括号里是求123除以100的余数，然后再除以10，求的十位上的数字
			  System.out.println(b);
			  c=num1%10;           //求个位数字，解释和上面一样
			  System.out.println(c);
			  num2=c*100+b*10+a;  //好了，求出来321了

			    System.out.println(num2);   //输出321
			 }

			

		
	}


