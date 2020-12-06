package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.strategies.MustGoMovingStrategy;
import racingcar.domain.strategies.MustStopMovingStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    public void 한_사이클_진행로직_확인_무조건_전진_전략일_때() {
        //given
        List<String> carNames = Arrays.asList("heon", "fobi", "woni");
        RacingGame racingGame = new RacingGame(carNames, new MustGoMovingStrategy());

        //when
        racingGame.playOneCycle();
        List<Car> cars = racingGame.getCars();
        List<Integer> distances = cars.stream()
                .mapToInt(Car::getPosition)
                .boxed()
                .collect(Collectors.toList());

        //then
        assertThat(distances).containsOnly(1);
    }

    @Test
    public void 한_사이클_진행로직_확인_무조건_정지_전략일_때() {
        //given
        List<String> carNames = Arrays.asList("heon", "fobi", "woni");
        RacingGame racingGame = new RacingGame(carNames, new MustStopMovingStrategy());

        //when
        racingGame.playOneCycle();
        List<Car> cars = racingGame.getCars();
        List<Integer> distances = cars.stream()
                .mapToInt(Car::getPosition)
                .boxed()
                .collect(Collectors.toList());

        //then
        assertThat(distances).containsOnly(0);
    }
}