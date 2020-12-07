package racingcar.domain.engine;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EngineTest {

    @RepeatedTest(value = 10)
    void 난수_생성범위_테스트() {
        // given, when
        Engine randomEngine = new RandomEngine();
        int randomDigit = randomEngine.getDigit();
        boolean isInRange = randomDigit >= 0 && randomDigit < 10;

        // then
        assertTrue(isInRange);
    }

    @Test
    void 지정_값_테스트() {
        // given, when
        int fixedNum = 5;
        Engine fixedEngine = new FixedEngine(fixedNum);

        // then
        assertEquals(fixedNum, fixedEngine.getDigit());
    }
}