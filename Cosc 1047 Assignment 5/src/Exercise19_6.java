import java.io.*;

public class Exercise19_6 {
  public static void main(String[] args) throws IOException {
    ObjectOutputStream output = new ObjectOutputStream(
      new FileOutputStream("Exercise19_07.dat"));

    output.writeObject(new test(2.5, 5, 1000));
    output.writeObject(new test(3.5, 5, 2000));
    output.writeObject(new test(4.5, 5, 3000));
    output.writeObject(new test(5.5, 5, 4000));
    output.writeObject(new test(6.5, 5, 5000));

    output.close();
  }
}
