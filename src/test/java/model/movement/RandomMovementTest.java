package model.movement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomMovementTest {
    private final int[] temporaryRandomNumbers = new int[] {3, 4};
    private int numberIndex = 0;

    private final RandomMovement randomMovement = new RandomMovement() {
        @Override
        public int generateRandomNumber() {
            return temporaryRandomNumbers[numberIndex++];
        }
    };

    @Test
    @DisplayName("랜덤한 숫자를 생성해 4 이상이면 true, 4 미만이면 false를 반환한다.")
    void canMove() {
        boolean firstMovement = randomMovement.canMove();
        boolean secondMovement = randomMovement.canMove();
        assertAll(
                () -> assertThat(firstMovement).isFalse(),
                () -> assertThat(secondMovement).isTrue()
        );
    }
}
