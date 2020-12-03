package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class GameResultTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getWinnerNames() {
        GameResult gameResult = new GameResult(
                Arrays.asList(
                        new Car("joy"),
                        new Car("happy")));

        assertThat(gameResult.getWinnerNames()).isEqualTo("joy, happy");
    }
}