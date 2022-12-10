package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.CarVenueService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class CarVenueServiceTest {
    @Test
    @DisplayName("최종 우승자 테스트, CarVenue 내의 포지션으로 우승자 관리")
    public void printTurnTest() throws Exception{
        List<Car> cars = new ArrayList<>();
        Car hiCar = new Car("hi");
        Car byeCar = new Car("bye");
        Car helloCar = new Car("hello");
        cars.add(hiCar);
        cars.add(byeCar);
        cars.add(helloCar);
        int round = 3;
        CarVenueService carVenueService = new CarVenueService(cars, round);
        IntStream.range(0, round).map(i -> 5).forEach(hiCar::move);
        Assertions.assertEquals(carVenueService.printWinner(), "최종 우승자 : bye, hello");
    }

    @Test
    @DisplayName("게임 엔딩 확인 테스트")
    public void endGameTest() throws Exception{
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("hi1"));
        int round = 3;
        CarVenueService carVenueService = new CarVenueService(cars, round);
        IntStream.range(0, round).forEach(i -> carVenueService.moveTurn());
        Assertions.assertEquals(carVenueService.isEnd(), true);
    }

    @Test
    @DisplayName("게임 진행 및 출력 확인")
    public void carVenueServiceTest() throws Exception{
        //given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("hi1"));
        cars.add(new Car("hi2"));
        int round = 3;
        CarVenueService carVenueService = new CarVenueService(cars, round);
        carVenueService.moveTurn();
        Assertions.assertEquals(carVenueService.printTurn().contains("hi1 : "),
                true);
        Assertions.assertEquals(carVenueService.printTurn().contains("hi2 : "),
                true);
    }
}