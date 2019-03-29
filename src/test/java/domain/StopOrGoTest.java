package domain;

import org.junit.Assert;
import org.junit.Test;

public class StopOrGoTest {

    private int[] testNums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    private StopOrGo[] expected = new StopOrGo[]{StopOrGo.STOP, StopOrGo.STOP, StopOrGo.STOP,
            StopOrGo.GO, StopOrGo.GO, StopOrGo.GO, StopOrGo.GO, StopOrGo.GO, StopOrGo.GO};

    @Test
    public void test() {
        for (int i = 0; i < testNums.length; i++) {
            Assert.assertEquals(expected[i], StopOrGo.valueOf(testNums[i]));
        }
    }
}
