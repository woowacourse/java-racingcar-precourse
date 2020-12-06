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
}
