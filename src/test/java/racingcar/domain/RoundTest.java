package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoundTest {
    @Test
    @DisplayName("Round 엔드 테스트")
    public void roundEndTest() throws Exception{
        Round round = new Round(2);
        round.next();
        Assertions.assertEquals(round.isFinish(), false);
        round.next();
        Assertions.assertEquals(round.isFinish(), true);
    }

}