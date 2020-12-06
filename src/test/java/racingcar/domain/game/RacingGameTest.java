package racingcar.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.Cars;
import racingcar.domain.exception.RacingTryCountsNumberFormatException;
import racingcar.domain.strategy.RandomMovingStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class RacingGameTest {

    private final List<String> carNames = Arrays.asList("pobi", "crong", "hyeju");

    @DisplayName("RacingGame 객체 정상 생성")
    @Test
    public void RacingGmae_객체_정상_생성한다() {
        Cars cars = Cars.createCars(carNames, new RandomMovingStrategy());
        int racingTryCounts = 3;

        assertThatCode(() -> {
            new RacingGame(cars, racingTryCounts);
        }).doesNotThrowAnyException();
    }

    @DisplayName("RacingGame 객체 생성 예외 : racingTryCounts가 1 미만인 경우")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    public void RacingGame_시도_횟수가_1_미만이면_예외_발생(int racingTryCounts) {
        Cars cars = Cars.createCars(carNames, new RandomMovingStrategy());

        assertThatCode(() -> {
            new RacingGame(cars, racingTryCounts);
        }).isInstanceOf(RacingTryCountsNumberFormatException.class);
    }

    @DisplayName("RacingGame 시도 횟수가 남았다면, isEnd는 false 반환")
    @Test
    public void isEnd_시도_횟수_남아있으면_false를_반환한다() {
        Cars cars = Cars.createCars(carNames, new RandomMovingStrategy());

        RacingGame racingGame = new RacingGame(cars, 3);

        assertThat(racingGame.isEnd()).isFalse();
    }

    @DisplayName("RacingGame이 한 차례 경주하면, 시도 횟수가 1회 차감된다")
    @Test
    public void race_1번_경주하면_시도_횟수가_1만큼_차감되고_isEnd는_true를_반환한다() {
        Cars cars = Cars.createCars(carNames, new RandomMovingStrategy());
        RacingGame racingGame = new RacingGame(cars, 1);

        racingGame.race();

        assertThat(racingGame.isEnd()).isTrue();
    }
}
