package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class OutputFormatterTest {

    @Test
    void carStatusTest() {
        String result = OutputFormatter.converseCarStatus(3, "t");
        assertThat(result).isEqualTo("t : ---");
    }

    @Test
    void winnerFormatTest() {
        String result = OutputFormatter.convertWinners(Arrays.asList("abc", "bcd"));
        assertThat(result).isEqualTo("최종 우승자 : abc, bcd");
    }

    @Test
    void gameStatusFormatTest() {
        String result = OutputFormatter.converseGameStatus(Arrays.asList(
            OutputFormatter.converseCarStatus(1, "test"),
            OutputFormatter.converseCarStatus(2, "test1")
        ));
        assertThat(result).isEqualTo(
            "test : -\ntest1 : --\n"
        );
    }
}