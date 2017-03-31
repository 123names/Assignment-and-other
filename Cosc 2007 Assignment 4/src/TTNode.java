
public class TTNode {

	private int Num1 = 0;                                              // contain small item 
	private int Num2 = 0;                                              // contain big item
	private TTNode left ;
	private TTNode mid ;
	private TTNode right;
	private boolean twoItem = false;                                   // boolean to track if it's 2 item or not
	private TTNode parent = null;                                      // parent pointer to track the parent of curr node
	private int tempNum = 0;
	private TTNode temp = null;
	
	public TTNode(){                                                   // Default constructor
		
	}
	public TTNode(int in1){                                            // constructor take one value
		Num1 = in1;
		left = null;
		right = null;
	}
	public TTNode(int in1, int in2){                                   // constructor take two value
		if(in1>in2){                                                   // make sure Num1 is smaller that Num2
			Num2 = in1;
			Num1 = in2;
		}
		else if(in1<in2){
			Num2 = in2;
			Num1 = in1;
		}
		twoItem = true;
		left = null;
		mid = null;
		right = null;
	}
	public boolean isTwoItem(){                                        // Function to return is two item or not
		return twoItem;
	} 
	public void setItem(int in1){                                      // set item 1
		Num1 = in1;
	}
	public void setItem2(int in2){                                     // set item 2, bigger one
		if(in2==0){
			twoItem= false;
		}
		else if(Num1 !=0&&Num1<in2){
			Num2 = in2;
			twoItem = true;                                            // set it as two item node
		}
		else if(Num1>in2){
			Num2 = Num1;
			Num1 = in2;
			twoItem = true; 
		}
	}

	public int getSmallItem(){                                         // get return of smaller item in node
		return Num1;
	}
	public int getBigItem(){                                           // get return of bigger item in node
		return Num2;
	}
	public void setLeft(TTNode left){                                  // set left node
		this.left = left;
	}
	public void setRight(TTNode right){                                // set right node
		this.right = right;
	}
	public void setMid(TTNode mid){                                    // set mid node
		this.mid = mid;
	}
	public void setTempNode(TTNode t){  
		temp = t;
	}
	public void setParent(TTNode p){                                   // changing the parent all the time
		parent = p;
	}
	public void setTemp(int t){
		tempNum = t;
	}
	public TTNode getLeft(){                                           // Accesses to left
		return left;
	}
	public TTNode getRight(){                                          // Accesses to right
		return right;
	}
	public TTNode getMid(){                                            // Accesses to mid
		return mid;
	}
	public TTNode getParent(){                                         // Accesses to parent to track the node
		return parent;
	}
	public TTNode getTempNode(){
		return temp;
	}
	public int getTemp(){
		return tempNum;
	}
}
