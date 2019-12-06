package domain;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarManagerTest {
    @Test
    public void createTest() {
        RacingCarManager racingCarManager = new RacingCarManager();
        RacingCarPosition racingCarPosition = new RacingCarPosition();
        RacingCarProcessor racingCarProcessor = new RacingCarProcessor();
        Validator validator = new Validator();

        assertThat(racingCarManager).isNotNull();
        assertThat(racingCarPosition).isNotNull();
        assertThat(racingCarProcessor).isNotNull();
        assertThat(validator).isNotNull();
    }

    @Test
    public void carRegisterSizeTest() {
        RacingCarManager racingCarManager = new RacingCarManager();
        List<String> carName = new LinkedList<>();
        List<Car> registeredCar = new LinkedList<>();

        carName.add("John");
        carName.add("Kim");
        carName.add("Hans");

        assertThat(racingCarManager.carGenerator(registeredCar, carName)).isEqualTo(3);
    }

    @Test
    public void gameFinishTest() {
        RacingCarManager racingCarManager = new RacingCarManager();
        List<Car> registeredCar = new LinkedList<>();

        registeredCar.add(new Car("John"));
        registeredCar.add(new Car("Kim"));
        registeredCar.add(new Car("Hans"));

        registeredCar.get(0).goForwardPosition();
        registeredCar.get(1).goForwardPosition();

        assertThat(racingCarManager.gameFinish(registeredCar)).isEqualTo("John, Kim");
    }
}