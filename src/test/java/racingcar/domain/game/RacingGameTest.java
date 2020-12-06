package racingcar.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Cars;
import racingcar.domain.exception.CannotRaceException;
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
        GameState gameState = GameState.initiate(3);

        assertThatCode(() -> {
            new RacingGame(cars, gameState);
        }).doesNotThrowAnyException();
    }

    @DisplayName("RacingGame 시도 횟수가 남았다면, isEnd는 false 반환")
    @Test
    public void isEnd_시도_횟수_남아있으면_false를_반환한다() {
        Cars cars = Cars.createCars(carNames, new RandomMovingStrategy());
        GameState gameState = GameState.initiate(3);

        RacingGame racingGame = new RacingGame(cars, gameState);

        assertThat(racingGame.isEnd()).isFalse();
    }

    @DisplayName("RacingGame이 한 차례 경주하면, 시도 횟수가 1회 차감된다")
    @Test
    public void race_1번_경주하면_시도_횟수가_1만큼_차감되고_isEnd는_true를_반환한다() {
        Cars cars = Cars.createCars(carNames, new RandomMovingStrategy());
        GameState gameState = GameState.initiate(1);
        RacingGame racingGame = new RacingGame(cars, gameState);

        racingGame.race();

        assertThat(racingGame.isEnd()).isTrue();
    }

    @DisplayName("잔여 시도 횟수가 없을 때, RacingGame이 경주를 시도하면 예외 발생")
    @Test
    public void race_시도_횟수가_없을때_예외가_발생한다() {
        Cars cars = Cars.createCars(carNames, new RandomMovingStrategy());
        GameState gameState = GameState.initiate(1);
        RacingGame racingGame = new RacingGame(cars, gameState);
        racingGame.race();

        assertThatCode(() -> {
            racingGame.race();
        }).isInstanceOf(CannotRaceException.class);
    }
}
