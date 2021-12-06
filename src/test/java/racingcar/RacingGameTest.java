package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.utils.StringUtils.MIN_VALUE_OF_ROUND_NUMBER;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    void 총_회차만큼_게임을_하면_끝났음을_확인가능() {
        int numberOfRounds = 3;
        RacingGame racingGame = RacingGame.create(numberOfRounds);
        for (int i = 0; i < numberOfRounds; i++) {
             racingGame.completeOneRound();
        }

        Assertions.assertThat(racingGame.isOver()).isTrue();
    }

    @Test
    void 총_회차만큼_게임을_하지_않았다면_경기가_끝나지_않았음을_확인_가능() {
        int numberOfRounds = 3;
        int smallerNumberThanNumOfRounds = 2;
        RacingGame racingGame = RacingGame.create(numberOfRounds);
        for (int i = 0; i < smallerNumberThanNumOfRounds; i++) {
            racingGame.completeOneRound();
        }

        Assertions.assertThat(racingGame.isOver()).isFalse();
    }

    @Test
    void 회차가_1보다_작을경우_예외_발생() {
        int smallerThanOne = 0;
        assertThat(smallerThanOne).isLessThan(MIN_VALUE_OF_ROUND_NUMBER);

        assertThatThrownBy(() -> RacingGame.create(smallerThanOne)).isInstanceOf(IllegalArgumentException.class);
    }

}
