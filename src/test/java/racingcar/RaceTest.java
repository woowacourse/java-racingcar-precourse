package racingcar;

import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.InputDigitStrategy;
import utils.RandomDigitStrategy;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RaceTest {
    final static int MIN_RUNNABLE = 4;

    @Test
    @DisplayName("라운드 횟수 당 현재 위치가 잘 증가되는 지 확인")
    public void testPositionPerRound() throws Exception {
        //given
        List<Car> cars = createCars();
        final int ROUND = 3;
        Race race = new Race(cars, ROUND);
        //when
        race.start(new InputDigitStrategy(MIN_RUNNABLE));
        //then
        cars.forEach(car -> assertEquals(car.getCurrentPosition(), ROUND));
    }

    @Test
    @DisplayName("위너가 리턴 되는 지 확인")
    public void testWinnerCar() throws Exception {
        //given
        List<String> winners = Arrays.asList("Bomin", "Daniel");
        List<Car> cars = createCars();
        final int ROUND = 3;
        cars.stream().filter(car -> winners.contains(car.getName()))
                .forEach(car -> car.run(MIN_RUNNABLE));
        Race race = new Race(cars, ROUND);
        //when
        List<String> result = race.start(new InputDigitStrategy(MIN_RUNNABLE));
        //then
        result.forEach(name -> assertTrue(winners.contains(name)));
    }

    @Test
    @DisplayName("랜덤 레이스 상황이 화면에 잘 출력 되는 지 확인")
    public void testRandomRace() throws Exception {
        //given
        List<Car> cars = createCars();
        final int ROUND = 5;
        //when
        Race race = new Race(cars, ROUND);
        //then
        race.start(new RandomDigitStrategy());
    }

    private List<Car> createCars() {
        return Arrays.asList(
                new Car("Bomin"),
                new Car("Daniel"),
                new Car("Francisco")
        );
    }
}