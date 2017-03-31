
public class Philosopher extends Thread{
	   private DiningServer runner;
	   private int       tNum;
	   private int       sleepTime;
   public Philosopher(DiningServer t, int i){
      runner = t;
      tNum = i;
   }

   private void thinking(){
     System.out.println("philosopher " + tNum + " is thinking.");

     sleepTime = (int) (DiningServer.DELAY * Math.random() );
     try { sleep(sleepTime*5000); } 
     catch(InterruptedException e) {}
   }

   private void eating(){
    System.out.println("philosopher " + tNum + " is eating.");

    sleepTime = (int) (DiningServer.DELAY * Math.random() );
    try { sleep(sleepTime*1000); } 
    catch(InterruptedException e) {}
   }
   
   public void run(){
     while (true)
      {
       thinking();

       System.out.println("philosopher " + tNum + " is hungry.");
      
       runner.takeForks(tNum);

       eating();
 
       runner.putForks(tNum);
       
       System.out.println("philosopher " + tNum + " is done eating.");
      }
   }
}
