public class DiningServer {  
	   private int[] state;
	   public static final int DELAY = 5;
	   private static final int THINKING = 0;
	   private static final int HUNGRY = 1;
	   private static final int EATING = 2;
	
   public DiningServer(){
    state = new int[5];
     for (int i = 0; i < 5; i++)
         state[i] = THINKING;
   }
   
   public synchronized void takeForks(int pnum){
      state[pnum] = HUNGRY;
      test(pnum);  

      while (state[pnum] == HUNGRY){
         try { wait(); }
         catch(InterruptedException e) {}
      }
   }
   
   public synchronized void putForks(int pnum){
      state[pnum] = THINKING;
      test(leftNeighbor(pnum));
      test(rightNeighbor(pnum));

      notifyAll();
   }

   private void test(int i){
	
      if(state[i] == HUNGRY && state[leftNeighbor(i)] != EATING &&state[rightNeighbor(i)] != EATING){
         state[i] = EATING;
      }
   }

   private int leftNeighbor(int i){
      if (i == 0){
         return 4;
      }
      else{
         return i - 1;
      }
   }

   
   private int rightNeighbor(int i){
      if (i == 4){
         return 0;
      }
      else{
         return i + 1;
      }
   }
}
