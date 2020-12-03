package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import org.junit.Before;
import org.junit.Test;

public class GameResultTest {

    Car joy;
    Car happy;

    @Before
    public void setUp() throws Exception {
        joy = new Car("joy");
        happy = new Car("happy");
    }

    @Test
    public void getWinnerNames_multiWinners() {
        GameResult gameResult = new GameResult(
                Arrays.asList(joy, happy));

        assertThat(gameResult.getWinnerNames()).isEqualTo("joy, happy");
    }

    @Test
    public void getWinnerNames_singleWinner() {
        GameResult gameResult = new GameResult(
                Collections.singletonList(joy));

        assertThat(gameResult.getWinnerNames()).isEqualTo("joy");
    }
}