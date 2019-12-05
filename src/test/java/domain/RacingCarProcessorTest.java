package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarProcessorTest {
    @Test
    public void carMovementRandomGeneratorTest() {
        RacingCarProcessor racingCarProcessor = new RacingCarProcessor();

        assertThat(racingCarProcessor.carMovementRandomGenerator(10).size()).isEqualTo(10);
        assertThat(racingCarProcessor
                .carMovementRandomGenerator(1000)
                .stream()
                .filter(num -> num < 10)
                .count())
                .isEqualTo(1000);
        assertThat(racingCarProcessor
                .carMovementRandomGenerator(1000)
                .stream()
                .filter(num -> num > -1)
                .count())
                .isEqualTo(1000);
    }
}