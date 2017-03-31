import java.io.FileWriter;
import java.io.IOException;
public class TTTree {

	private TTNode root = null;
	public FileWriter output;
	
	public TTTree() throws IOException{
		output = new FileWriter("F:/result.txt");
	}
	public TTNode getR(){
		return root;
	}
	public TTNode findPosition(TTNode r , int item){
		
		if(r==null){                                             // if r is null, the tree contain nothing, return r
			return r;
		}
		if(r.getSmallItem()==item||r.getBigItem()==item){        // if item exist in tree, exit it
			System.out.println("Duplicate item detected!!");
		}
		else{
			if(!r.isTwoItem()){                                   //if r is not contain two item
				
				if(r.getLeft()==null&&r.getMid()==null){        // if find leaf
					return r;
				}
				else if(item>r.getSmallItem()){                        // if item bigger that item in r, recursive call to it's right node
					return findPosition(r.getMid(),item);
				}
				else{                                             // if input item smaller than item in r but can go left, recursive to left node
					return findPosition(r.getLeft(), item);
				}
			}
			else{
				if(r.getLeft()==null&&r.getRight()==null&&r.getMid()==null){   // if root or leaf
					return r;
				}
				if(item<r.getSmallItem()){                            // item can go left, recursive call left
					return findPosition(r.getLeft(),item);
				}
				if(item>r.getSmallItem()&&item<r.getBigItem()){       // item can go mid, recursive call mid
					return findPosition(r.getMid(),item);
				}
				if(item>r.getBigItem()){                              // item can go right, recursive call right
					return findPosition(r.getRight(),item);
				}
			}
		}
		return r;
	}
	
	public void InsertItem( int item){
		TTNode leaf = findPosition(root, item);
		if(leaf==null){                                          // if root is nothing, create new node and put item in it
			leaf = new TTNode(item);
			root = leaf;
			// System.out.println("1.Leaf small " + leaf.getSmallItem() + " Leaf big " + leaf.getBigItem());
		}
		else if(!leaf.isTwoItem()){                              // if leaf have on item, we add one to it
			leaf.setItem2(item);
			// System.out.println("2.Leaf small " + leaf.getSmallItem() + " Leaf big " + leaf.getBigItem());
		}
		else{                                                    // if leaf try to insert item in to two node leaf, split it
			split(leaf,item);
			// System.out.println("3.Leaf small " + leaf.getSmallItem() + " Leaf big " + leaf.getBigItem() + " item " + item);
		}
	}
	public void split(TTNode curr, int item){                    // split take node and item you try to insert in to 2 item node 
		
		if(curr==root&&curr.getParent()==null){                // if item is root 
			TTNode newR = new TTNode();                                 // create new node as root
			root = newR;                                         // set the root = new node
			TTNode childleft = new TTNode();                     //create two children
			TTNode childMid = new TTNode();
			newR.setLeft(childleft);                             // attach children to root
			newR.setMid(childMid);
			childleft.setParent(newR);                           // set parent of child is new root
			childMid.setParent(newR);
			
			if(item<curr.getSmallItem()){                        //condition1, item smaller than small item in curr
				childleft.setItem(item);
				newR.setItem(curr.getSmallItem());
				childMid.setItem(curr.getBigItem());             
			}
			else if(item>curr.getBigItem()){                     // condition2, item bigger than bigger item in curr
				childleft.setItem(curr.getSmallItem());
				newR.setItem(curr.getBigItem());
				childMid.setItem(item);
			}
			else{                                                // item it self is in the mid
				newR.setItem(item);
				childleft.setItem(curr.getSmallItem());
				childMid.setItem(curr.getBigItem());
			}
			
			if(curr.getLeft() != null){                           // taking relationship from curr
				curr.getLeft().setParent(childleft);
				childleft.setLeft(curr.getLeft());
			}
			if(curr.getMid() != null){
				curr.getMid().setParent(childleft);
				childleft.setRight(curr.getMid());
			}
			if(curr.getRight()!=null){
				curr.getRight().setParent(childMid);
				childMid.setLeft(curr.getRight());
			}
			if(curr.getTempNode()!=null){
				curr.getTempNode().setParent(childMid);
				childMid.setRight(curr.getTempNode());
			}
			/*
			System.out.println("1. left child left " + childleft.getSmallItem());
			System.out.println("2. left child right " + childleft.getBigItem());
			System.out.println("3. root left " + newR.getSmallItem());
			System.out.println("4. root Right " + newR.getBigItem());
			System.out.println("5. right child left " + childMid.getSmallItem());
			System.out.println("6. right child Right " + childMid.getBigItem());
			*/
		}
		
		else{
			if (curr.getParent().getBigItem()==0){               // if parent get 1 item only
				
				TTNode rightmost = new TTNode();
				rightmost.setParent(curr.getParent());
				
				if(item<curr.getSmallItem()){                    // if item smaller than small item in curr
					curr.getParent().setItem2(curr.getSmallItem());
					
					rightmost.setItem(curr.getBigItem());
					rightmost.setLeft(curr.getRight());
					rightmost.setMid(curr.getTempNode());
					
					curr.setItem(item);
					curr.setItem2(0);
					curr.setTempNode(null);
					curr.setRight(null);
					curr.getParent().setRight(rightmost);
				}
				else if(item>curr.getBigItem()){
					curr.getParent().setItem2(curr.getBigItem());
					
					rightmost.setItem(item);
					rightmost.setLeft(curr.getRight());
					rightmost.setMid(curr.getTempNode());
					
					curr.setItem(curr.getSmallItem());
					curr.setItem2(0);
					curr.setTempNode(null);
					curr.setRight(null);
					curr.getParent().setRight(rightmost);
				}
				else{
					curr.getParent().setItem2(item);
					
					rightmost.setItem(curr.getBigItem());
					rightmost.setLeft(curr.getRight());
					rightmost.setMid(curr.getTempNode());
					
					curr.setItem(curr.getSmallItem());
					curr.setItem2(0);
					curr.setTempNode(null);
					curr.setRight(null);
					curr.getParent().setRight(rightmost);
				}
			}
			
			else{                                                       // if parent get 2 item but still try to insert other one
				TTNode temp = new TTNode();
				temp.setParent(curr.getParent());
				int passUp = 0;
				if(item<curr.getSmallItem()){
					temp.setItem(curr.getBigItem());
					temp.setLeft(curr.getRight());
					curr.setRight(null);
					temp.setMid(curr.getTempNode());
					curr.setTempNode(null);
					curr.getParent().setTempNode(temp);
					curr.setItem2(0);
					passUp = curr.getSmallItem();
					curr.setItem(item);
				}
				else if(item>curr.getBigItem()){
					temp.setParent(curr.getParent());
					temp.setItem(item);
					temp.setLeft(curr.getRight());
					curr.setRight(null);
					temp.setMid(curr.getTempNode());
					curr.setTemp(0);
					curr.getParent().setTempNode(temp);
					passUp = curr.getBigItem();
					curr.setItem2(0);
				}
				else{
					temp.setParent(curr.getParent());
					temp.setItem(curr.getBigItem());
					temp.setLeft(curr.getRight());
					curr.setRight(null);
					temp.setMid(curr.getTempNode());
					curr.setTempNode(null);
					curr.getParent().setTempNode(temp);
					passUp = item;
					curr.setItem2(0);
				}
				split(curr.getParent(),passUp);
			}
		}
	}

	public void printAscending(TTNode curr) throws IOException{
		
		boolean leaf = curr.getLeft()==null&&curr.getMid()==null&&curr.getRight()==null;
		
		int Num1 = curr.getSmallItem();
		int Num2 = curr.getBigItem();
		if(leaf){
			if(curr.isTwoItem()){
				output.write(Num1); 
				output.append(System.lineSeparator());               //write new line to file
				output.write(Num2); 
				output.append(System.lineSeparator());               //write new line to file
				System.out.print(curr.getSmallItem()+ " " );
				System.out.print(curr.getBigItem()+ " ");
			}
			else{
				output.write(Num1); 
				output.append(System.lineSeparator());               //write new line to file
				System.out.print(curr.getSmallItem()+ " ");
			}
		}
		else if(curr.isTwoItem()&&!leaf){
			printAscending(curr.getLeft());
			output.write(Num1); 
			output.append(System.lineSeparator());               //write new line to file
			System.out.print(curr.getSmallItem()+ " ");
			printAscending(curr.getMid());
			output.write(Num2); 
			output.append(System.lineSeparator());               //write new line to file
			System.out.print(curr.getBigItem()+ " ");
			printAscending(curr.getRight());
		}
		else{
			printAscending(curr.getLeft());
			if(curr.isTwoItem()){
				output.write(Num1); 
				output.append(System.lineSeparator());               //write new line to file
				System.out.print(curr.getSmallItem()+ " " );
				output.write(Num2); 
				output.append(System.lineSeparator());               //write new line to file
				System.out.print(curr.getBigItem()+ " ");
			}
			else{
				output.write(Num1); 
				output.append(System.lineSeparator());               //write new line to file
				System.out.print(curr.getSmallItem()+ " " );
			}
			printAscending(curr.getMid());
		}
	}
	public void printDescending(TTNode curr){
		
		if(curr.getLeft()==null&&curr.getMid()==null&&curr.getRight()==null){
			if(curr.isTwoItem()){
				System.out.print(curr.getBigItem()+ " ");
				System.out.print(curr.getSmallItem()+ " ");
			}
			else{
				System.out.print(curr.getSmallItem()+ " ");
			}
		}
		else if(curr.isTwoItem()){
			printDescending(curr.getRight());
			System.out.print(curr.getBigItem()+ " ");
			printDescending(curr.getMid());
			System.out.print(curr.getSmallItem()+ " ");
			printDescending(curr.getLeft());
		}
		else{
			printDescending(curr.getMid());
			if(curr.isTwoItem()){
				System.out.print(curr.getBigItem()+ " ");
				System.out.print(curr.getSmallItem()+ " " );
			}
			else{
				System.out.print(curr.getSmallItem()+ " " );
			}
			printDescending(curr.getLeft());
		}
	}
}
