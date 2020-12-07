package racingcar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerCheckerTests {
    private static Stream<Arguments> positionArguments() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), 1),
                Arguments.of(Arrays.asList(5, 4, 5), 2),
                Arguments.of(Arrays.asList(0, 0, 0), 3),
                Arguments.of(Arrays.asList(5, 5, 5, 6, 6, 6, 6), 4),
                Arguments.of(Arrays.asList(5, 10, 10, 10, 5, 10, 10), 5)
        );
    }

    @ParameterizedTest
    @MethodSource("positionArguments")
    public void test(List<Integer> positions, int winnerCount) {
        String[] carNameSamples = {"a", "b", "c", "d", "e", "f", "g"};
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < positions.size(); i++) {
            Car car = new Car(carNameSamples[i]);
            car.forward(positions.get(i));
            carList.add(car);
        }
        Cars cars = new Cars(carList);
        Cars winners = WinnerChecker.run(cars);

        assertThat(winners.getCars().size())
                .isEqualTo(winnerCount);
    }
}
