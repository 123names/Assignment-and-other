

public class DiningPhilosophers
{  
   public static void main(String args[])
   {
      DiningServer server = new DiningServer();

      Philosopher[] phil = new Philosopher[5];
     
     
     for (int i = 0; i < 5; i++)
         phil[i] = new Philosopher(server,i);
     
     for (int i = 0; i < 5; i++)
         phil[i].start();
   }
}
