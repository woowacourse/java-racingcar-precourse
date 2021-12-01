package racingcar;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CarRepositoryTest {

    CarRepository carRepository = CarRepository.getInstance();

    @BeforeEach
    void setUp(){
        List<Car> cars = Arrays.asList(new Car("car"), new Car("car2"));
        carRepository.saveAll(cars);
    }

    @DisplayName("자동차 저장")
    @Test
    void save_cars(){
        List<Car> findCars = carRepository.findAll();
        assertThat(findCars.size()).isEqualTo(2);
    }

    @DisplayName("자동차 리스트 초기화")
    @Test
    void clear_cars(){
        carRepository.clear();
        List<Car> findCars = carRepository.findAll();

        assertThat(findCars.size()).isEqualTo(0);
    }
}