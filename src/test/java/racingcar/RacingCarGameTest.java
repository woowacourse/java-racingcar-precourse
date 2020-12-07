package racingcar;

import org.junit.jupiter.api.Test;
import utils.RandomUtils;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {

    @Test
    public void 범위_0_9_사이의_랜덤_값을_검증한다() throws Exception {
        //given
        //when
        //then
        for (int i = 0; i < 20; i++) {
            assertThat(RandomUtils.nextInt(0, 9)).isBetween(0, 9);
        }
    }
}