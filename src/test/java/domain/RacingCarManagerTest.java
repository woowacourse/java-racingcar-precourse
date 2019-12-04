package domain;

import org.junit.jupiter.api.Test;

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

}