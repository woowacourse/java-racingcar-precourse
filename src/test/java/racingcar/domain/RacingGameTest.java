package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.strategies.CarMovingStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int THREE = 3;
    private static final int FOUR = 4;

    @Test
    public void 한_사이클_진행로직_확인_무조건_전진_전략일_때() {
        //given
        List<String> carNames = Arrays.asList("heon", "fobi", "woni");
        RacingGame racingGame = new RacingGame(carNames, new MustGoStrategy());

        //when
        racingGame.playOneCycle();
        List<Car> cars = racingGame.getCars();
        List<Integer> distances = cars.stream()
                .mapToInt(Car::getPosition)
                .boxed()
                .collect(Collectors.toList());

        //then
        assertThat(distances).containsOnly(ONE);
    }

    @Test
    public void 한_사이클_진행로직_확인_무조건_정지_전략일_때() {
        //given
        List<String> carNames = Arrays.asList("heon", "fobi", "woni");
        RacingGame racingGame = new RacingGame(carNames, new MustStopStrategy());

        //when
        racingGame.playOneCycle();
        List<Car> cars = racingGame.getCars();
        List<Integer> distances = cars.stream()
                .mapToInt(Car::getPosition)
                .boxed()
                .collect(Collectors.toList());

        //then
        assertThat(distances).containsOnly(ZERO);
    }

    private static class MustGoStrategy implements CarMovingStrategy {

        @Override
        public int generate() {
            return FOUR;
        }
    }

    private static class MustStopStrategy implements CarMovingStrategy {

        @Override
        public int generate() {
            return THREE;
        }
    }
}