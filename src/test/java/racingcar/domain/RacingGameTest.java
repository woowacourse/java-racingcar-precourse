package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class RacingGameTest {

    @Test
    void 우승자_한명를_반환한다() {
        Car car1 = new Car("AAA");
        Car car2 = new Car("BBB");

        RacingGame racingGame = new RacingGame(Arrays.asList(car1, car2), 3);
        car1.move();

        Assertions.assertThat(racingGame.getWinners().size()).isEqualTo(1);
    }

    @Test
    void 우승자_두명를_반환한다() {
        Car car1 = new Car("AAA");
        Car car2 = new Car("BBB");

        RacingGame racingGame = new RacingGame(Arrays.asList(car1, car2), 3);
        car1.move();
        car2.move();

        Assertions.assertThat(racingGame.getWinners().size()).isEqualTo(2);
    }

    @Test
    void 입력한_횟수보다_게임을_적게_진행하면_종료하지_않는다() {
        Car car1 = new Car("AAA");
        Car car2 = new Car("BBB");

        RacingGame racingGame = new RacingGame(Arrays.asList(car1, car2), 3);

        Assertions.assertThat(racingGame.canContinue(2)).isEqualTo(true);
    }

    @Test
    void 입력한_횟수만큼_게임을_진행하면_종료한다() {
        Car car1 = new Car("AAA");
        Car car2 = new Car("BBB");

        RacingGame racingGame = new RacingGame(Arrays.asList(car1, car2), 3);

        Assertions.assertThat(racingGame.canContinue(4)).isEqualTo(false);
    }

    @Test
    void 자동차들_중에서_선두_위치를_반환한다() {
        Car car1 = new Car("AAA");
        Car car2 = new Car("BBB");

        RacingGame racingGame = new RacingGame(Arrays.asList(car1, car2), 3);
        car1.move();
        car2.move();
        car2.move();

        Assertions.assertThat(racingGame.getMaxPosition()).isEqualTo(2);
    }
}