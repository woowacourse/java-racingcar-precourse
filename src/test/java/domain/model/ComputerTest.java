package domain.model;

import static org.junit.Assert.*;

import annotation.TestDescription;
import domain.controller.RacingGame;
import org.junit.Test;

public class ComputerTest {
    private static final int ENOUGH_BIG_NUMBER = 1000000;

    @Test
    @TestDescription("컴퓨터가 생성하는 난수의 범위 및 결과를 테스트합니다.")
    public void randomNumberTest() {
        Computer computer = new Computer();
        for (int i = 0; i < ENOUGH_BIG_NUMBER; i++) {
            assertTrue(computer.makeRandomNumber() <= 9);
            assertTrue(computer.makeRandomNumber() >= 0);
        }
        RacingGame racingGame = new RacingGame();

        assertFalse(racingGame.notifyGoOrStop(1));
        assertFalse(racingGame.notifyGoOrStop(2));
        assertFalse(racingGame.notifyGoOrStop(3));
        assertTrue(racingGame.notifyGoOrStop(4));
        assertTrue(racingGame.notifyGoOrStop(5));
        assertTrue(racingGame.notifyGoOrStop(6));
        assertTrue(racingGame.notifyGoOrStop(7));
        assertTrue(racingGame.notifyGoOrStop(8));
        assertTrue(racingGame.notifyGoOrStop(9));
    }


}