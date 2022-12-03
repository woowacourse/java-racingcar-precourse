package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.NumberGenerator;
import racingcar.domain.car.RandomNumberGenerator;

class RacingGameTest {

    static RacingGame racingGame;

    @BeforeAll
    static void init() {
        List<String> playerNames = Arrays.asList("pobi", "conan", "crong");
        Player player = new Player(playerNames);
        racingGame = new RacingGame(player, 4);
    }

    @Test
    void play_메소드에_따라_isGameContinue_변화_확인() {
        // given
        assertThat(racingGame.isGameContinue()).isEqualTo(true);

        // when
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        for (int i = 0; i < 4; i ++) {
            racingGame.play(numberGenerator);
        }

        // then
        assertThat(racingGame.isGameContinue()).isEqualTo(false);
    }
}