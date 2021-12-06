package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.utils.StringUtils.MIN_NUMBER_TO_CAR_TO_GO;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarRepositoryTest {
    private final List<Car> initialCarsToSave = new ArrayList<>();
    private CarRepository carRepository;
    private List<Car> savedCars;

    public CarRepositoryTest() {
        addCarsToInitialCars();
    }

    private void addCarsToInitialCars() {
        initialCarsToSave.add(Car.create("car1"));
        initialCarsToSave.add(Car.create("car2"));
        initialCarsToSave.add(Car.create("car3"));
    }

    @BeforeEach
    void setUp() {
        carRepository = new CarRepository();
        saveCarsInRepository();
        savedCars = carRepository.findAllInOrder();
    }

    private void saveCarsInRepository() {
        carRepository.saveInOrder(initialCarsToSave);
    }

    @Test
    void 들어온_순으로_순서가_정해지며_해당_순서로_자동차들_내보내기() {
        assertThat(savedCars).isEqualTo(initialCarsToSave);
    }

    @Test
    void repository에_저장된_리스트는_변경_불가() {
        savedCars.add(Car.create("name4"));

        assertThat(carRepository.findAllInOrder()).isEqualTo(initialCarsToSave);
    }

    @Test
    void 간_거리가_가장_많은_자동차를_반환() {
        int carIndexToBeWinner = 1;
        Car carToWin = savedCars.get(carIndexToBeWinner);
        carToWin.run(MIN_NUMBER_TO_CAR_TO_GO);

        List<Car> expectedResult = new ArrayList<>();
        expectedResult.add(carToWin);

        assertThat(carRepository.findTopByOrderByPosition()).isEqualTo(expectedResult);
    }

    @Test
    void 간_거리가_가장_많은_자동차들이_복수라면_해당_차를_모두_반환() {
        for (Car savedCar : savedCars) {
            savedCar.run(MIN_NUMBER_TO_CAR_TO_GO);
        }

        assertThat(carRepository.findTopByOrderByPosition()).isEqualTo(initialCarsToSave);
    }
}
