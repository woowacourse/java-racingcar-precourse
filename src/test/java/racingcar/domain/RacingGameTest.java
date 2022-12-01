package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {
    private Car han;
    private Car kim;
    private RacingGame racingGame;

    @BeforeEach
    void before() {
        han = new Car("han");
        kim = new Car("kim");
        racingGame = new RacingGame(Arrays.asList(han, kim));
    }

    @DisplayName("우승자를 반환한다.")
    @Test
    void getWinner() {
        han.addPosition();

        RacingResult winner = racingGame.getWinner();

        Assertions.assertThat(winner.getCarNames()).containsExactly("han");
    }

    @DisplayName("우승자가 2명이면 모두 반환한다.")
    @Test
    void getTwoWinner() {
        han.addPosition();
        kim.addPosition();

        RacingResult winner = racingGame.getWinner();

        Assertions.assertThat(winner.getCarNames()).containsOnly("han", "kim");
    }

}