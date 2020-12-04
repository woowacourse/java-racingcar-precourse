package racingcar;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import org.junit.Before;
import org.junit.Test;

public class WinnersTest {

    Car joy;
    Car happy;

    @Before
    public void setUp() throws Exception {
        joy = new Car("joy");
        happy = new Car("happy");
    }

    @Test
    public void getWinnerNames_multiWinners() {
        Winners gameResult = new Winners(
                Arrays.asList(joy, happy));

        assertThat(gameResult.getWinnerNames()).isEqualTo("joy, happy");
    }

    @Test
    public void getWinnerNames_singleWinner() {
        Winners gameResult = new Winners(
                Collections.singletonList(joy));

        assertThat(gameResult.getWinnerNames()).isEqualTo("joy");
    }
}