package racingcar;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.Test;

public class WinnersTest {

    @Test
    public void getWinnerNames() {
        Winners winners = new Winners(Arrays.asList(new Car("aa"), new Car("bb")));
        assertThat(winners.getWinnerNames()).isEqualTo("aa, bb");
    }
}