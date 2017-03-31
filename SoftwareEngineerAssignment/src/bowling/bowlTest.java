package bowling;

import static org.junit.Assert.*;

import org.junit.Test;

public class bowlTest {

	public bowl b = new bowl();
	@Test
	public void testaddScore() {
		frameScore []test = new frameScore[12];
		for(int i= 0; i<11;i++){
			test[i]= new frameScore();
			test[i].setFirst(3);
			test[i].setSecond(7);
			test[i].setSpare(true);
			test[i].setTotal(10);
		}
		test[10].setFirst(3);
		test[10].setSpare(true);
		test[10].setTotal(3);

		assertEquals("Total score is", 130, b.addScore(test, 11));// this method accept the score object array and the frame count
	}

}

