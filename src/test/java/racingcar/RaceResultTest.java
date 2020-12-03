package racingcar;

import domain.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RaceResultTest {
    @Test
    @DisplayName("우승자가 한 명일 때")
    public void testOneWinner() throws Exception {
        //given
        final String WINNER_NAME = "Bomin";
        final int RUNNABLE_NUM = 5;
        List<Car> multiCars = createMultiCars();
        //when
        multiCars.stream()
                .filter(car -> car.getName().equals(WINNER_NAME))
                .forEach(car -> car.run(RUNNABLE_NUM));
        RaceResult result = RaceResult.of(multiCars);
        //then
        assertThat(result.getWinnersName()).contains(WINNER_NAME);
    }

    @Test
    @DisplayName("우승자가 여러 명 일 때")
    public void testMultiWinners() throws Exception {
        //given
        final List<String> WINNER_NAMES = Arrays.asList("Bomin", "Daniel");
        final int RUNNABLE_NUM = 5;
        List<Car> multiCars = createMultiCars();
        //when
        multiCars.stream()
                .filter(car -> WINNER_NAMES.contains(car.getName()))
                .forEach(car -> car.run(RUNNABLE_NUM));
        RaceResult result = RaceResult.of(multiCars);
        //then
        assertThat(WINNER_NAMES).isEqualTo(result.getWinnersName());
    }

    public List<Car> createMultiCars() {
        return Arrays.asList(
                new Car("Bomin"),
                new Car("Daniel"),
                new Car("Francisco"),
                new Car("Scott")
        );
    }

}