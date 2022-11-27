package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarGameTest {
    
    @Test
    @DisplayName("게임 종료 확인")
    void isFinished() {
        final RacingCarGame racingCarGame = new RacingCarGame("jun, pobi");
        racingCarGame.racing();
        racingCarGame.racing();
        racingCarGame.racing();
        
        assertThat(racingCarGame.isFinished(3)).isTrue();
    }
}