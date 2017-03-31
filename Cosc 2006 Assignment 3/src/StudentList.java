public class StudentList {
	
	private LinkedListNode head = null;
	private int count = 0;
	
	public StudentList (){
		
	}
	
	public void add(int stN, double stM){
		
		LinkedListNode newNode = new LinkedListNode(stN,stM, null);
		
		if(head == null){
			head = newNode;
			count++;
			}
		else{
			LinkedListNode curr = head;
			if(curr.getMark()<newNode.getMark()){
				head = newNode;
				head.setNext(curr);
				count++;
				}
			else{
				boolean insert = false;
				
				while(curr.getNext()!=null){
					
					if(newNode.getMark()>curr.getNext().getMark()){
						newNode.setNext(curr.getNext());
						curr.setNext(newNode);
						insert = true;
						count++;
						break;
						}
					curr = curr.getNext();
					}
				if (!insert){
					curr.setNext(newNode);
					count++;
					}
				}
			}
		}

	public void printList() {
		
		LinkedListNode curr = head;
		while(curr != null) {
			printNode(curr);
			curr = curr.getNext();
			}
		}
	public LinkedListNode medianMark(){
		LinkedListNode curr = head;
		int count1 = count;
		count1 = count1/2;
		while(count1!=0) {
			curr = curr.getNext();
			count1--;
			}
		return curr;	
	}
	/*
	public double totalMark(LinkedListNode curr){
		count++;
		return curr.getMark()+totalMark(curr.getNext());
	}
	*/
	public void printNode(LinkedListNode curr) {
		if(curr != null){
			System.out.println(curr.getNum()+"                              " + curr.getMark());
			}
		}
	}