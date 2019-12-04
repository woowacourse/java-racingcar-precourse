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
    public void carNameNullTest() {
        Validator validator = new Validator();
        List<String> carNames = new LinkedList<>();

        carNames.add("John");
        carNames.add("Kim");
        carNames.add("James");

        assertThat(validator.isNotNull(carNames)).isEqualTo(true);
    }

    @Test
    public void carNameExcessTest() {
        Validator validator = new Validator();
        List<String> carNames = new LinkedList<>();
        List<String> carNamesWrong = new LinkedList<>();

        carNames.add("John");
        carNames.add("Kim");
        carNames.add("James");

        carNamesWrong.add("Jonathan");
        carNamesWrong.add("Kim");
        carNamesWrong.add("James");

        assertThat(validator.isNotExcess(carNames)).isEqualTo(true);
        assertThat(validator.isNotExcess(carNamesWrong)).isEqualTo(false);
    }

    @Test
    public void carNameBelowZeroTest() {
        Validator validator = new Validator();
        List<String> carNames = new LinkedList<>();
        List<String> carNamesWrong = new LinkedList<>();

        carNames.add("John");
        carNames.add("Kim");
        carNames.add("James");

        carNamesWrong.add("");
        carNamesWrong.add("Kim");
        carNamesWrong.add("James");

        assertThat(validator.isNotBelowZero(carNames)).isEqualTo(true);
        assertThat(validator.isNotBelowZero(carNamesWrong)).isEqualTo(false);
    }

    @Test
    public void tryTimeBelowZeroTest() {
        Validator validator = new Validator();

        assertThat(validator.isNotBelowZero(1)).isEqualTo(true);
        assertThat(validator.isNotBelowZero(12321)).isEqualTo(true);
        assertThat(validator.isNotBelowZero(0)).isEqualTo(false);
        assertThat(validator.isNotBelowZero(-3)).isEqualTo(false);
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
}