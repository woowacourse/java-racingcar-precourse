package racing.display;

import org.junit.Test;

import static org.junit.Assert.*;

public class UnitTest {

    @Test
    public void 라운드입력_테스트_양의정수_성공() {
        int testData = 3;
        int inputData = InputDisplay.getRound();
        assertEquals(testData, inputData);
    }
}