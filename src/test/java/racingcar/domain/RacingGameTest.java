package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

    Car car1;
    Car car2;

    @BeforeEach
    void init() {
        car1 = new Car("AAA");
        car2 = new Car("BBB");
    }

    @Test
    void 우승자_한명를_반환한다() {
        RacingGame racingGame = new RacingGame(Arrays.asList(car1, car2), 3);
        car1.move();

        assertThat(racingGame.getWinners().size()).isEqualTo(1);
    }

    @Test
    void 우승자_두명를_반환한다() {
        RacingGame racingGame = new RacingGame(Arrays.asList(car1, car2), 3);
        car1.move();
        car2.move();

        assertThat(racingGame.getWinners().size()).isEqualTo(2);
    }

    @Test
    void 입력한_횟수보다_게임을_적게_진행하면_종료하지_않는다() {
        RacingGame racingGame = new RacingGame(Arrays.asList(car1, car2), 3);

        assertThat(racingGame.canContinue(2)).isEqualTo(true);
    }

    @Test
    void 입력한_횟수만큼_게임을_진행하면_종료한다() {
        RacingGame racingGame = new RacingGame(Arrays.asList(car1, car2), 3);

        assertThat(racingGame.canContinue(4)).isEqualTo(false);
    }

    @Test
    void 자동차들_중에서_선두_위치를_반환한다() {
        RacingGame racingGame = new RacingGame(Arrays.asList(car1, car2), 3);
        car1.move();
        car2.move();
        car2.move();

        assertThat(racingGame.getMaxPosition()).isEqualTo(2);
    }
}