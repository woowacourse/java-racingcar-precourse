package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.Test;

class RacingGameTest {
    @Test
    void 우승자_계산_성공() {
        RacingGame racingGame = new RacingGame(new TestNumberGenerator());
        racingGame.enrollCars(List.of("pobi", "jason", "java", "joon"));
        racingGame.repeatMovingCars(1);

        assertThat(racingGame.findWinners()).containsOnly("java", "joon");
    }

    private static class TestNumberGenerator implements NumberGenerator {
        private final Queue<Integer> numbers = new LinkedList<>(List.of(1, 3, 4, 4));

        @Override
        public int make() {
            if (numbers.isEmpty()) {
                return -1;
            }
            return numbers.poll();
        }
    }
}