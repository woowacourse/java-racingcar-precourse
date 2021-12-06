package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import racingcar.utils.OutputFormatter;

class RacingCarGameTest {

    final static int STOP = 1;
    final static int GO = 5;
    final static int STOP_POSITION = 0;
    final static int GO_POSITION = 1;

    @Test
    void stopTest() {
        assertRandomNumberInRangeTest(
            () -> {
                List<String> names = Arrays.asList("test", "test1");
                List<String> result = names.stream()
                    .map(s -> OutputFormatter.converseCarStatus(STOP_POSITION, s))
                    .collect(Collectors.toList());
                RacingCarGame game = new RacingCarGame(names);
                game.moveCars();
                assertThat(game.getGameStatus()).isEqualTo(
                    OutputFormatter.converseGameStatus(result));
            },
            STOP, STOP
        );
    }

    @Test
    void goTest() {
        assertRandomNumberInRangeTest(
            () -> {
                List<String> name = Collections.singletonList("test");
                List<String> result = name.stream()
                    .map(s -> OutputFormatter.converseCarStatus(GO_POSITION, s))
                    .collect(Collectors.toList());
                RacingCarGame game = new RacingCarGame(name);
                game.moveCars();
                assertThat(game.getGameStatus()).isEqualTo(
                    OutputFormatter.converseGameStatus(result));
            },
            GO
        );
    }

    @Test
    void coWinnerTest() {
        assertRandomNumberInRangeTest(
            () -> {
                List<String> names = Arrays.asList("car1", "car2");
                RacingCarGame game = new RacingCarGame(names);
                game.moveCars();
                String result = OutputFormatter.convertWinners(names);
                assertThat(game.getWinners()).isEqualTo(result);
            },
            GO
        );
    }
}