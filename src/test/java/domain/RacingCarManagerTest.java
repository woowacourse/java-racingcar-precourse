package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarManagerTest {
    @Test
    public void createTest() {
        RacingCarManager racingCarManager = new RacingCarManager();
        assertThat(racingCarManager).isNotNull();
    }

}