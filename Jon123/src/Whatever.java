public class Whatever {  
	public static void insertionSort(int []data){  
        for(int index=1;index<data.length;index++){  
            int key = data[index];  
            int position = index;  
            //shift larger values to the right  
            while(position>0&&key<data[position-1]){  
            	data[position] = data[position-1];  
                position--; 
            }  
            data[position]=key;  
        }     
    }  
    public static void main(String []args){  
        int []c={4,9,23,1,45,27,5,2};  
        insertionSort(c);  
        for(int i=0;i<c.length;i++)  
            System.out.println("²åÈëÅÅÐò£º"+c[i]);  
    }  
}