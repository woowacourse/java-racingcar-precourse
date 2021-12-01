package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinnersTest {
    @Test
    void toString메소드_테스트() {
        Winners winners = new Winners();
        winners.addWinner("A");
        winners.addWinner("B");
        winners.addWinner("C");

        assertEquals(winners.toString(), "A, B, C");
    }
}