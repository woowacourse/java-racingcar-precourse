package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class RacingCarGameTest {

    final static int STOP = 1;
    final static int GO = 5;

    @Test
    void stopTest() {
        try (MockedStatic<Randoms> randoms = mockStatic(Randoms.class)) {
            randoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(STOP);
            RacingCarGame game = new RacingCarGame(Collections.singletonList("test"));
            game.moveCars();
            assertThat(game.getGameStatus()).doesNotContain("-");
        }
    }

    @Test
    void goTest() {
        try (MockedStatic<Randoms> randoms = mockStatic(Randoms.class)) {
            randoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(GO);
            RacingCarGame game = new RacingCarGame(Collections.singletonList("test"));
            game.moveCars();
            assertThat(game.getGameStatus()).contains("-");
        }
    }
}