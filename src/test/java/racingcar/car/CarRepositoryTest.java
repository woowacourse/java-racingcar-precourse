package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.utils.StringConstants.MIN_NUMBER_TO_CAR_TO_GO;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarRepositoryTest {
    private final List<Car> initialCarsToSave = new ArrayList<>();
    private CarRepository carRepository;

    @BeforeEach
    void setUp() {
        carRepository = new CarRepository();
        addCarsToList();
        saveCarsInRepository();
    }

    private void saveCarsInRepository() {
        carRepository.saveInOrder(initialCarsToSave);
    }

    private void addCarsToList() {
        initialCarsToSave.add(Car.create("car1"));
        initialCarsToSave.add(Car.create("car2"));
        initialCarsToSave.add(Car.create("car3"));
    }

    @Test
    void 들어온_순으로_순서가_정해지며_해당_순서로_cars_내보내기() {
        List<Car> savedCars = carRepository.findAllInOrder();
        assertThat(savedCars).isEqualTo(initialCarsToSave);
    }

    @Test
    void repository에_저장된_list는_변경_불가() {
        List<Car> result = carRepository.findAllInOrder();
        result.add(Car.create("name4"));
        assertThat(carRepository.findAllInOrder()).isEqualTo(initialCarsToSave);
    }

    @Test
    void 간_거리가_가장_많은_자동차를_반환() {
        List<Car> savedCars = carRepository.findAllInOrder();
        int carIndexToBeWinner = 1;
        Car carToWin = savedCars.get(carIndexToBeWinner);
        carToWin.run(MIN_NUMBER_TO_CAR_TO_GO);

        List<Car> expectedResult = new ArrayList<>();
        expectedResult.add(carToWin);

        assertThat(carRepository.findTopByOrderByPosition()).isEqualTo(expectedResult);
    }

    @Test
    void 간_거리가_가장_많은_자동차들이_복수라면_해당_차를_모두_반환() {
        List<Car> savedCars = carRepository.findAllInOrder();
        for (Car savedCar : savedCars) {
            savedCar.run(MIN_NUMBER_TO_CAR_TO_GO);
        }

        assertThat(carRepository.findTopByOrderByPosition()).isEqualTo(initialCarsToSave);
    }
}
