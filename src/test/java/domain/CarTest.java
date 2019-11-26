package domain;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class CarTest {

    @Test
    public void randomNumberCorrectTest(){
        int testNumber = (int) (Math.random() * 10);
        System.out.println(testNumber);
        for(int i=0; i<100000000; i++){
            assertTrue(testNumber>=0);
            assertTrue(testNumber<=10);
        }
    }
}
