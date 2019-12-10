package domain.controller;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import annotation.TestDescription;
import domain.model.Car;
import org.junit.Test;

@TestDescription("게임 시작 이외 모든 기능을 타 클래스에 위임하고 있기에 입력값이 정상적으로 작동하는지만 테스트합니다.")
public class RacingGameTest {
    private static final int ENOUGH_BIG_NUMBER = 1000000;

    @Test
    public void inputTest() {
        RacingGame racingGame = new RacingGame();
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("name"));
        cars.add(new Car("enl"));
        cars.add(new Car("ish"));

        racingGame.gameStart(cars, 4);
        List winner = racingGame.getWinner(cars);
        assertEquals(cars.size(), 3);
        for (int i = 0; i < ENOUGH_BIG_NUMBER; i++) {
            assertTrue(winner.size() <= cars.size());
        }
    }
}
