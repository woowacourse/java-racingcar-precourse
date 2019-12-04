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
    public void carNameBelowZero() {
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
}