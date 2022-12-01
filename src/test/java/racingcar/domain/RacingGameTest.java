package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @DisplayName("우승자를 반환한다.")
    @Test
    void getWinner() {
        Car han = new Car("han");
        Car kim = new Car("kim");
        List<Car> list = Arrays.asList(han, kim);
        RacingGame racingGame = new RacingGame(list);
        han.addPosition();
        RacingResult winner = racingGame.getWinner();

        Assertions.assertThat(winner.getCarNames()).containsExactly("han");
    }

    @DisplayName("우승자가 2명이면 모두 반환한다.")
    @Test
    void getTwoWinner() {
        Car han = new Car("han");
        Car kim = new Car("kim");
        List<Car> list = Arrays.asList(han, kim);
        RacingGame racingGame = new RacingGame(list);
        han.addPosition();
        kim.addPosition();
        RacingResult winner = racingGame.getWinner();

        Assertions.assertThat(winner.getCarNames()).containsOnly("han", "kim");
    }

}