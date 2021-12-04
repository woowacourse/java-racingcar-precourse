package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarRepositoryTest {
    private CarRepository carRepository;
    private List<Car> initialCarsToSave;

    @BeforeEach
    void setUp() {
        carRepository = new CarRepository();

        initialCarsToSave = new ArrayList<>();
        addCarsToList();

        for (Car car : initialCarsToSave) {
            carRepository.saveInOrder(car);
        }
    }

    private void addCarsToList() {
        initialCarsToSave.add(Car.create("car1"));
        initialCarsToSave.add(Car.create("car2"));
        initialCarsToSave.add(Car.create("car3"));
    }

    @Test
    void 들어온_순으로_순서가_정해지며_해당_순서로_cars_내보내기() {
        List<Car> savedCars = carRepository.findAllCarsInOrder();
        assertThat(savedCars).isEqualTo(initialCarsToSave);
    }

    @Test
    void repository에_저장된_list는_변경_불가() {
        List<Car> result = carRepository.findAllCarsInOrder();
        result.add(Car.create("name4"));
        assertThat(carRepository.findAllCarsInOrder()).isEqualTo(initialCarsToSave);
    }
}
